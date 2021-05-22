let user = JSON.parse(sessionStorage.getItem("user"))

init()

function init() {
    if (user == null) {
        window.location.href = '/welcome'
    }
    setInterval(getChatMessage, 500)
}

function textAreaKeyPress(e) {
    let keynum;
    if (window.event) { // IE
        keynum = e.keyCode;
    } else if (e.which) { // Netscape/Firefox/Opera
        keynum = e.which;
    }
    if (keynum === 13) {
        postChatMessage()
    }
}

function getChatMessage() {
    fetch(`${window.location.origin}/user/${user.id}/channels/detail/id/${window.channelId}/message`)
        .then(response => response.json())
        .then(data => {
            let messageDiv = document.querySelector("#postedMessage")
            messageDiv.innerHTML = ''
            data.forEach(message => {
                messageDiv.innerHTML += `<div>
			  <span class="timestamp">${message.user.userName}: </span>
		  	  <span class="message">${message.message}</span>
			</div>`

            })
        })
}

function postChatMessage() {
    let textArea = document.querySelector('#messageText')
    let someOb = {
        "user": JSON.stringify(user),
        "message": textArea.value
    }

    fetch(`${window.location.origin}/user/${user.id}/channels/detail/id/${window.channelId}/message`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(someOb)
    }).then(response => {
        response.json()
    }).then(body => {
        console.log(body)
        textArea.value = ''
    })
}
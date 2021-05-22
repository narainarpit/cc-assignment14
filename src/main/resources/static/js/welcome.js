init()

function init() {
    sessionStorage.setItem('user', '')
    let name = prompt('What\'s your name')
    user = {"userName": name}
    fetch(`http://localhost:8080/welcome`, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(user)
    }).then(response => response.json()).then(body => {
        if (body.id) {
            processResponse(body);
        } else {
            console.log(`Error while logging in : ${JSON.stringify(body)}`)
        }
    })
}

function processResponse(body) {
    sessionStorage.setItem("user", JSON.stringify(body))
    window.location.replace(`${window.location.origin}/user/${body.id}/channels`);
}



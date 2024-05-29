
const url = "http://localhost:8080/auth/"


async function login(email, password) {
    const response = await fetch(url + 'login', {
        mode: 'no-cors',
        body: { email, password },
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
        },
        method: 'post'
    })

    const responseBody = await response.json()

    console.log(responseBody)
}


// function register({ name, email, password, phoneNumber }) {

// }


export {
    login,
    // register
}
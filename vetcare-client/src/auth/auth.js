import axios from "axios";

export async function login(email, password) {
    const response = await axios.post('http://localhost:8090/auth/login', {
        email,
        password
    })

    const responseBody = response.data

    saveToken(responseBody.token)
}

export async function register({ name, email, password, phoneNumber }) {
    const response = await axios.post('http://localhost:8090/auth/register', {
        name,
        email,
        password,
        phoneNumber
    })

    const responseBody = response.data

    saveToken(responseBody.token)
}

function saveToken(token) {
    window.localStorage.setItem('auth-token', token)
}
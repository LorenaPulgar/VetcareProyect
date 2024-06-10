import axios from "axios";

export async function login(email, password) {
    try {

        const response = await axios.post('auth/login', { email, password })

        const responseBody = response.data

        saveToken(responseBody.token)
        saveUserId(responseBody.userId, responseBody.petOwnerId)

        alert(":)")

    } catch (err) {
        if (err.response && err.response.status === 404) {
            if (err.response.data && err.response.data.description) {
                throw err.response.data.description
            }
        }
    }
}

export async function register({ name, email, password, phoneNumber }) {
    try {

        const response = await axios.post('auth/register', {
            name,
            email,
            password,
            phoneNumber
        })

        const responseBody = response.data

        saveToken(responseBody.token)
        saveUserId(responseBody.userId, responseBody.petOwnerId)

        alert(":)")
    } catch (err) {
        if (err.response && err.response.status === 409) {
            if (err.response.data && err.response.data.description) {
                throw err.response.data.description
            }
        }
    }

}

function saveToken(token) {
    window.localStorage.setItem('auth-token', token)
}

function saveUserId(userId, petOwnerId) {
    window.localStorage.setItem('user-id', userId)
    window.localStorage.setItem('pet-owner-id', petOwnerId)
}
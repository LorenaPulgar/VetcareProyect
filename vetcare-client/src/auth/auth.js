import axios from "axios";

export async function login(email, password) {
    try {

        const response = await axios.post('http://localhost:8090/auth/login', {
            email,
            password
        })
        
        const responseBody = response.data
        
        saveToken(responseBody.token)
        
        alert(":)")
        
    } catch(err) {
        if (err.response && err.response.status === 404) {
            if (err.response.data && err.response.data.description) {
                alert(err.response.data.description)
            }
        }
    }
}

export async function register({ name, email, password, phoneNumber }) {
    try {

        const response = await axios.post('http://localhost:8090/auth/register', {
            name,
            email,
            password,
            phoneNumber
        })
        
        const responseBody = response.data
        
        saveToken(responseBody.token)
        
        alert(":)")
    } catch(err) {
        if (err.response && err.response.status === 409) {
            if (err.response.data && err.response.data.description) {
                alert(err.response.data.description)
            }
        }
    }

}

function saveToken(token) {
    window.localStorage.setItem('auth-token', token)
}
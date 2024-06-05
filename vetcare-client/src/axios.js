import axios from "axios"

axios.defaults.baseURL = 'http://localhost:8090/'
axios.defaults.headers.common['Authorization'] = 'Bearer ' + window.localStorage.getItem('auth-token')

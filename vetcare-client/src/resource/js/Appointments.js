import axios from "axios";

export async function getAppointments() {
    try {

        const response = await axios.get('api/v1/appointment')

        return response.data

    } catch (err) {
        console.error(err)
    }
}

export async function scheduleAppointment(userId, veterinaryId, date) {
    const requestBody = {
        petOwner: {
            id: userId
        },
        veterinaryOffice: {
            id: veterinaryId
        },
        date
    }

    try {
        await axios.post('/api/v1/appointment/', requestBody)
    } catch (err) {
        console.error(err);
    }
}
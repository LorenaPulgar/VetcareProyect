import axios from "axios";

export async function getAppointments() {
    try {
        const response = await axios.get('api/v1/appointment')

        const formattedAppointments = response.data.map(appointment => ({
            id: appointment.id,
            date: appointment.date,
            address: appointment.veterinaryOffice.address,
            veterinaryName: appointment.veterinaryOffice.user.name,
            veterinaryId: appointment.veterinaryOffice.id,
            status: appointment.status
        }))

        return formattedAppointments

    } catch (err) {
        console.error(err)
    }
}

export async function scheduleAppointment(veterinaryId, date) {
    const requestBody = {
        petOwner: {
            id: window.localStorage.getItem('pet-owner-id')
        },
        veterinaryOffice: {
            id: veterinaryId
        },
        date
    }

    try {
        await axios.post('/api/v1/appointment', requestBody)
    } catch (err) {
        console.error(err);
    }
}
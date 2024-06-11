import axios from "axios";

export async function getAppointments() {
    try {
        const response = await axios.get('api/v1/appointment')

        const statusMap = {
            ['PENDING']: 'Pendiente',
            ['CANCELLED']: 'Cancelada',
            ['COMPLETED']: 'Completada'
        };

        const formattedAppointments = response.data.map(appointment => ({
            id: appointment.id,
            date: new Date(appointment.date).toLocaleDateString(),
            time: new Date(appointment.date).toLocaleTimeString(),
            address: appointment.veterinaryOffice.address,
            veterinaryName: appointment.veterinaryOffice.user.name,
            veterinaryId: appointment.veterinaryOffice.id,
            status: statusMap[appointment.status]
        }))

        console.log(formattedAppointments);


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
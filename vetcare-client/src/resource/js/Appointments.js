import axios from "axios";

export async function getAppointments() {
    try {
        const response = await axios.get('api/v1/appointment')

        console.log(response.data)

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
            status: statusMap[appointment.status],
            userId: appointment.petOwner.id,
            petOwner: JSON.stringify(appointment.petOwner),
            veterinaryOffice: JSON.stringify(appointment.veterinaryOffice),
            dateTimeSpam: appointment.date
        }))

        console.log(formattedAppointments);


        return formattedAppointments

    } catch (err) {
        console.error(err)
    }
}


export async function AppointmentStatus(appointmentId, petOwnerDto, veterinaryOfficeDto, date, status,) {
    try {

        // Enviar el cuerpo con los datos requeridos por el backend
        const requestBody = 
            {
                id: appointmentId,
                petOwner: JSON.parse(petOwnerDto), // Asumiendo que `userId` corresponde al dueño de la mascota
                veterinaryOffice: JSON.parse(veterinaryOfficeDto), // No es necesario enviar el veterinario, ya que se puede obtener de la petOwner
                status: status,      // Asigna el nuevo estado si es requerido por el backend
                date: date   // Convertir la fecha a formato Date
            };

        console.log(requestBody)
        const response = await axios.patch(`/api/v1/cancel-appointment`,requestBody);
        console.log(response.data)
        window.location.reload();
    } catch (err) {
        console.error(err);
        throw err;                   // Lanza el error para que pueda ser manejado en la UI
    }
}
export async function AcceptAppointment(appointmentId, veterinaryId) {
    try {
        await axios.put(`/${veterinaryId}/appoinment/${appointmentId}`)
    } catch (err) {
        console.error(err);
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
<script setup>
import { getAppointments, scheduleAppointment } from '@/resource/js/Appointments';
import { getVeterinaries } from '@/resource/js/Veterinaries';
import { ref } from 'vue';
import FullCalendar from '@fullcalendar/vue3';
import dayGridPlugin from '@fullcalendar/daygrid';
import interactionPlugin from '@fullcalendar/interaction';

/** @type {import('vue').Ref<import('@/resource/js/Veterinaries').Veterinary[]>} */
const veterinaries = ref([]);
const appointments = ref([]);

getVeterinaries().then(vets => {
    veterinaries.value = vets;
});

getAppointments().then(apps => {
    if (apps) {
        appointments.value = apps;
        // Convert appointments to calendar events
        calendarEvents.value = apps.map(app => ({
            id: app.id,
            title: `Appointment with ${app.veterinaryName}`,
            start: app.date
        }));
    }
});

const calendarEvents = ref([]);

const handleDateClick = (info) => {
    const newAppointment = {
        id: Date.now(),
        veterinaryName: 'New Veterinary', // Actualiza esto según sea necesario
        date: info.dateStr
    };
    scheduleAppointment(newAppointment).then(() => {
        appointments.value.push(newAppointment);
        calendarEvents.value.push({
            id: newAppointment.id,
            title: `Appointment with ${newAppointment.veterinaryName}`,
            start: newAppointment.date
        });
    });
};
</script>

<template>
    <div class="wrap">
        <h2>Veterinarias</h2>
        <div class="vet-list">
            <div v-for="veterinary in veterinaries" :key="veterinary.veterinaryId" class="card">
                <p>{{ veterinary.name }}</p>
                <p>{{ veterinary.address }}</p>
            </div>
        </div>
        <FullCalendar
            :plugins="[dayGridPlugin, interactionPlugin]"
            initialView="dayGridMonth"
            :events="calendarEvents"
            @dateClick="handleDateClick"
        />
    </div>
</template>

<style>
.wrap {
    font-family: "Open Sans";
    padding: 40px 30px 0px 30px;
}

.card {
    padding: 20px;
    background-color: rgb(222, 240, 255);
}

.vet-list {
    display: grid;
    gap: 30px;
    grid-template-columns: repeat(3, 1fr);
    padding-top: 30px;
}
</style>

<script setup>
import { getAppointments, scheduleAppointment } from '@/resource/js/Appointments';
import { getVeterinaries } from '@/resource/js/Veterinaries';
import { ref } from 'vue';

/** @type {import('vue').Ref<import('@/resource/js/Veterinaries').Veterinary[]>} */
const veterinaries = ref([])
const appointments = ref([])

getVeterinaries().then(vets => {
    veterinaries.value = vets
})

getAppointments().then(apps => {
    appointments.value = apps
})

function scheduleAppointmentHandle(veterinary) {
    let date = document.getElementById('vet-' + veterinary.veterinaryId).value
    scheduleAppointment(veterinary.veterinaryId, date)
}

</script>

<template>
    <div class="wrap">
        <h2>Veterinarias</h2>
        <div class="vet-list">
            <div v-for="veterinary in veterinaries" v-bind:key="veterinary.veterinaryId" class="card">
                <p>{{veterinary.name}}</p>
                <p>{{veterinary.address}}</p>
                <input type="datetime-local" :id="'vet-' + veterinary.veterinaryId">
                <button @click="scheduleAppointmentHandle(veterinary)">
                    Agendar cita
                </button>
            </div>
        </div>
        <h2>Citas pendientes</h2>
        <div class="sche-list">
            <div v-for="appointment in appointments" v-bind:key="appointment.id" class="card">
                <p>{{appointment.id}}</p>
                <p class="code" v-for="line in JSON.stringify(appointment, null, '&nbsp; &nbsp;').split('\n')" v-bind:key="line">
                    {{line}}
                </p>
            </div>
        </div>
    </div>
</template>

<style>

.wrap {
    font-family: "Open Sans";
    padding: 40px 30px 0px 30px;
}

.code {
    font-family: 'consolas';
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

.sche-list {
    display: grid;
    gap: 30px;
    grid-template-columns: repeat(1, 1fr);
    padding-top: 30px;
}
</style>
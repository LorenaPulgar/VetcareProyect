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

async function scheduleAppointmentHandle(veterinary) {
    let date = document.getElementById('vet-' + veterinary.veterinaryId).value
    await scheduleAppointment(veterinary.veterinaryId, date)
    getAppointments().then(apps => {
        appointments.value = apps
    })
}

function validateTime(event) {
    const input = event.target;
    const datetime = new Date(input.value);
    if (datetime.getMinutes() !== 0 || datetime.getSeconds() !== 0) {
        datetime.setMinutes(0, 0, 0);
        input.value = datetime.toISOString().slice(0, 16);
        alert('Please select a time with hours on the hour, like 18:00 or 2:00.');
    }
}

</script>

<template>
    <header class="header">
        <div class="headermodif">
            <div class="logo">
                <img src="../resource/img/Logo-VetCare-invertido.png" alt="VetCare Logo" class="imglogo" />
                <h1 class="logo-text">VetCare</h1>
            </div>
        </div>
        <div class="nav-signup">
            <nav>
                <div class="navbar-icons">
                    <i class="fa-solid fa-house" @click="goToHomeLog"></i>
                    <i class="fa-regular fa-bell"></i>
                    <div class="user-menu">
                        <i class="fa-solid fa-user" @click="toggleMenu"></i>
                        <div v-if="showMenu" class="dropdown-menu">
                            <div class="dropdown-item" @click="goToMenuConfig">
                                <i class="fa-solid fa-gear"></i>
                                <span>Configuración</span>
                            </div>
                            <div class="dropdown-item" @click="goToHomePage">
                                <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                <span>Cerrar sesión</span>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    </header>
    <div class="wrap">
        <h2>Veterinarias</h2>
        <div class="vet-list">
            <div v-for="veterinary in veterinaries" v-bind:key="veterinary.veterinaryId" class="card">
                <p><strong>{{ veterinary.name }}</strong></p>
                <p>{{ veterinary.address }}</p>
                <input type="datetime-local" :id="'vet-' + veterinary.veterinaryId" class="datetime-local"
                    @change="validateTime">
                <button class="btnagendar" @click="scheduleAppointmentHandle(veterinary)">
                    Agendar cita
                </button>
            </div>
        </div>
        <h2>Citas pendientes</h2>
        <div class="sche-list">
            <div v-for="appointment in appointments" v-bind:key="appointment.id" class="card">
                <p> <strong> Veterinaria: </strong> {{ appointment.veterinaryName }} </p>
                <p> <strong> Fecha: </strong> {{ appointment.date }} </p>
                <p> <strong> Hora: </strong> {{ appointment.time }} </p>
                <p> <strong> Dirección: </strong> {{ appointment.address }} </p>
                <p> <strong> Estado: </strong> {{ appointment.status }} </p>
            </div>
        </div>
    </div>
</template>

<style src="../resource/css/DemoSchedule.css"></style>

<script>
export default {
    name: 'DemoScheduleAppointment',
    data() {
        return {
            showMenu: false,
        };
    },
    methods: {
        toggleMenu() {
            this.showMenu = !this.showMenu;
        },
        goToMenuConfig() {
            this.$router.push('/configuration');
        },
        goToHomePage() {
            this.$router.push('/');
        },
        goToHomeLog() {
            this.$router.push('/home');
        },
    },
};
</script>
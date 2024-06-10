import { createRouter, createWebHistory } from 'vue-router';
import Home from '../components/HomePage.vue';
import LoginComponent from '../components/LoginComponent.vue';
import HomeLog from '../components/HomePageLog.vue';
import Menu from '../components/MenuConf.vue';
import DemoScheduleAppointment from '@/components/DemoScheduleAppointment.vue';
import ScheduleAppointment from '@/components/ScheduleAppointment.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/auth', component: LoginComponent },
    { path: '/home', component: HomeLog},
    { path: '/configuration', component: Menu},
    { path: '/schedule-appointment', component: ScheduleAppointment },
    { path: '/demo-schedule-appointment', component: DemoScheduleAppointment },
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;

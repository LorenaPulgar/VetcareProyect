import { createRouter, createWebHistory } from 'vue-router';
import Home from '../components/HomePage.vue'; // Ajusta la ruta según la estructura de tu proyecto
import LoginComponent from '../components/LoginComponent.vue'; // Ajusta la ruta según la estructura de tu proyecto

const routes = [
    { path: '/', component: Home },
    { path: '/auth', component: LoginComponent }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;

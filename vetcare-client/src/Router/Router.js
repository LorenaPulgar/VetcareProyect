import { createRouter, createWebHistory } from 'vue-router';
import HomeComponent from '../components/HomePage.vue';
import LoginComponent from '../components/LoginComponent.vue';

const routes = [
    {
        path: '/',
        name: 'Home',
        component: HomeComponent
    },
    {
        path: '/auth',
        name: 'Auth',
        component: LoginComponent
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;



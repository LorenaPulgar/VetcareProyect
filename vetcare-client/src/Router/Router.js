import { createRouter, createWebHistory } from 'vue-router';
import Home from '../components/HomePage.vue';
import LoginComponent from '../components/LoginComponent.vue';
import HomeLog from '../components/HomePageLog.vue';
import Menu from '../components/MenuConf.vue';

const routes = [
    { path: '/', component: Home },
    { path: '/auth', component: LoginComponent },
    { path: '/home', component: HomeLog},
    { path: '/configuration', component: Menu}
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;

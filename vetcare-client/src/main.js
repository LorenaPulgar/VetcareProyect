import { createApp } from 'vue';
import App from './App.vue';
import router from './Router/Router.js';
import './axios'

createApp(App).use(router).mount('#app');


<script setup>

import { login, register } from '@/auth/auth.js'

const datos = {
    name: '',
    phoneNumber: '',
    email: '',
    password: '',
    repassword: ''
}

function makeRegister() {
    register(datos)
        .then(() => window.location.assign('/home'))
        .catch(err => alert(err))
}

function makeLogin() {
    login(datos.email, datos.password)
        .then(() => window.location.assign('/home'))
        .catch(err => alert(err))    
}

</script>

<template>
    <div class="fondopagina divcontenedor">
        <button @click="GoToHome" class="btnvolver">
            <i class="fa-regular fa-circle-xmark fa-xl"></i>
        </button>
        <div class="contenedor__todo">
            <div class="caja__trasera">
                <div class="caja__trasera-login">
                    <div class="logopagina">
                        <img src="../resource/img/Logo-VetCare-invertido.png" alt="Logo de la página">
                        <h1 class="logoText">Vetcare</h1>
                    </div>
                    <h3>¿Ya tienes una cuenta?</h3>
                    <p>Inicia sesión para entrar en la página</p>
                    <button id="btn__iniciar-sesion" @click="showLogin">Iniciar Sesión</button>
                </div>
                <div class="caja__trasera-register">
                    <div class="logopagina">
                        <img src="../resource/img/Logo-VetCare-invertido.png" alt="Logo de la página">
                        <h1 class="logoText">Vetcare</h1>
                    </div>
                    <h3>¿Aún no tienes una cuenta?</h3>
                    <p>Regístrate para que puedas iniciar sesión</p>
                    <button id="btn__registrarse" @click="showRegister">Registrarse</button>
                </div>
            </div>

            <!-- Formulario de Login y registro -->
            <div class="contenedor__login-register">
                <!-- Login -->
                <form @submit.prevent="makeLogin" class="formulario__login" ref="loginForm">
                    <h2 class="textTitul">Iniciar Sesión</h2>
                    <input v-model="datos.email" type="email" required placeholder="Correo Electrónico">
                    <input v-model="datos.password" type="password" required placeholder="Contraseña">
                    <a href="">¿Has olvidado tu contraseña?</a>
                    <button>Entrar</button>
                    <div class="redessociales">
                        <p>Entra con otra cuenta:</p>
                        <i class="fa-brands fa-facebook fa-2xl" style="color: #0aa0a3;"></i>
                        <i class="fa-brands fa-google fa-2xl" style="color: #0aa0a3;"></i>
                    </div>
                </form>

                <!-- Register -->
                <form @submit.prevent="makeRegister" class="formulario__register" ref="registerForm">
                    <h2 class="textTitul">Registrarse</h2>
                    <input v-model="datos.name" type="text" placeholder="Nombre completo">
                    <input v-model="datos.email" type="email" required placeholder="Correo Electrónico">
                    <input v-model="datos.phoneNumber" type="text" placeholder="Número de teléfono">
                    <input v-model="datos.password" type="password" required placeholder="Contraseña">
                    <input v-model="datos.repassword" type="password" required placeholder="Repetir Contraseña">
                    <button>Registrarse</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'LoginComponent',
    methods: {
        GoToHome() {
            this.$router.push('/');
        }
    },
    mounted() {
        document.getElementById("btn__iniciar-sesion").addEventListener("click", iniciarSesion);
        document.getElementById("btn__registrarse").addEventListener("click", register);
        window.addEventListener("resize", anchoPage);

        //Declarando variables
        var formulario_login = document.querySelector(".formulario__login");
        var formulario_register = document.querySelector(".formulario__register");
        var contenedor_login_register = document.querySelector(".contenedor__login-register");
        var caja_trasera_login = document.querySelector(".caja__trasera-login");
        var caja_trasera_register = document.querySelector(".caja__trasera-register");

        //FUNCIONES

        function anchoPage() {
            if (window.innerWidth > 850) {
                caja_trasera_register.style.display = "block";
                caja_trasera_login.style.display = "block";
            } else {
                caja_trasera_register.style.display = "block";
                caja_trasera_register.style.opacity = "1";
                caja_trasera_login.style.display = "none";
                formulario_login.style.display = "block";
                contenedor_login_register.style.left = "0px";
                formulario_register.style.display = "none";
            }
        }

        anchoPage();

        function iniciarSesion() {
            if (window.innerWidth > 850) {
                formulario_login.style.display = "block";
                contenedor_login_register.style.left = "10px";
                formulario_register.style.display = "none";
                caja_trasera_register.style.opacity = "1";
                caja_trasera_login.style.opacity = "0";
            } else {
                formulario_login.style.display = "block";
                contenedor_login_register.style.left = "0px";
                formulario_register.style.display = "none";
                caja_trasera_register.style.display = "block";
                caja_trasera_login.style.display = "none";
            }
        }

        function register() {
            if (window.innerWidth > 850) {
                formulario_register.style.display = "block";
                contenedor_login_register.style.left = "410px";
                formulario_login.style.display = "none";
                caja_trasera_register.style.opacity = "0";
                caja_trasera_login.style.opacity = "1";
            } else {
                formulario_register.style.display = "block";
                contenedor_login_register.style.left = "0px";
                formulario_login.style.display = "none";
                caja_trasera_register.style.display = "none";
                caja_trasera_login.style.display = "block";
                caja_trasera_login.style.opacity = "1";
            }
        }
    }
}
</script>

<style src="../resource/css/login_Regisro.css"></style>
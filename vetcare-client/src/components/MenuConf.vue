<template>
    <div class="home">
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
                                <div class="dropdown-item">
                                    <i class="fa-solid fa-gear"></i>
                                    <span>Configuración</span>
                                </div>
                                <div class="dropdown-item">
                                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                    <span>Cerrar sesión</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <div class="container">
            <div class="menuconfig">
                <div class="avatar">
                    <img src="../resource/img/business-man-cartoon-character-vector.jpg" alt="Avatar">
                </div>
                <p>Vetcare@vetcare.com</p>
                <div class="option option1">
                    <h4>Cuenta</h4>
                    <div class="account-options">
                        <span> <i class="fa-regular fa-pen-to-square"></i> Editar perfil<i class="fa-solid fa-chevron-right"></i></span>
                    </div>
                </div>
                <div class="option option2">
                    <h4>Suscripción</h4>
                    <div class="subscription-options">
                        <div class="subscription-option">
                            <span><i class="fa-regular fa-gem"></i> Planes disponibles <i class="fa-solid fa-chevron-right"></i></span>
                        </div>
                        <div class="subscription-option">
                            <span><img src="../resource/img/Logo.svg" alt="Administrar Plan"> Administra tu plan<i class="fa-solid fa-chevron-right"></i></span>
                        </div>
                    </div>
                </div>
                <button class="btneliminar">Eliminar cuenta</button>
            </div>
        </div>
    </div>
</template>

<style src="../resource/css/MenuConf.css"></style>

<script>
export default {
    name: 'MenuConf',
    data() {
        return {
            showMenu: false,
        };
    },
    methods: {
        toggleMenu() {
            this.showMenu = !this.showMenu;
        },
        goToHomeLog() {
            this.$router.push('/home');
        },
    },
};
</script>

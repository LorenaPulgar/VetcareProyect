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
                        <i class="fa-solid fa-house"></i>
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
            <div class="avatar">
                <img src="../resource/img/dog-8434228_1280.jpg" alt="Avatar">
            </div>
            <p>Vetcare@vetcare.com</p>
            <div class="option">
                <span>Editar perfil</span>
                <span>&gt;</span>
            </div>
            <div class="option">
                <span>Planes disponibles</span>
                <span>&gt;</span>
            </div>
            <div class="option">
                <span>Administra tu plan</span>
                <span>&gt;</span>
            </div>
            <button class="btneliminar"> Eliminar cuenta </button>
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
    },
};
</script>

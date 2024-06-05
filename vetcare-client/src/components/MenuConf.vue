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
                        <img src="" alt="Home Icon" class="nav-icon" />
                        <img src="" alt="Notification Icon" class="nav-icon" />
                        <div class="user-menu">
                            <img 
                                src="" 
                                alt="User Icon" 
                                @click="toggleMenu" 
                                class="user-icon"
                            />
                            <div v-if="showMenu" class="dropdown-menu">
                                <div class="dropdown-item">
                                    <img src="" alt="Settings Icon" />
                                    <span>Configuración</span>
                                </div>
                                <div class="dropdown-item">
                                    <img src="" alt="Logout Icon" />
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
                <img src="" alt="Avatar">
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
            <p>Eliminar cuenta</p>
        </div>
    </div>
</template>

<style src="../resource/css/MenuConf.css"></style>

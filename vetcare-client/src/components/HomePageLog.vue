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

        <div class="IntroWelcome">
            <div class="welcome">
                <img src="../resource/img/ilustracion.png" alt="Welcome" />
            </div>
        </div>

        <main class="main-content">
            <section class="information">
                <div class="Somos">
                    <div class="Lupa">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </div>
                    <div class="aSomos">
                        <a href="#">Agendar Cita</a>
                    </div>
                </div>
                <div class="Reseñas">
                    <div class="Estrella">
                        <i class="fa-regular fa-star"></i>
                    </div>
                    <div class="aReseña">
                        <a href="#">Blog</a>
                    </div>
                </div>
                <div class="Cont">
                    <div class="Flecha">
                        <i class="fa-solid fa-file-arrow-down"></i>
                    </div>
                    <div class="aCont">
                        <a href="#">Historial</a>
                    </div>
                </div>
            </section>
        </main>

        <footer class="footer">
            <div class="social-media">
                <a href="#"><i class="fa-brands fa-instagram fa-2xl" alt="InstagramProfile"></i></a>
                <a href="#"><i class="fa-brands fa-whatsapp fa-2xl" alt="WhatsappProfile"></i></a>
                <a href="#"><i class="fa-brands fa-github fa-2xl" alt="GitHubProfile"></i></a>
            </div>
        </footer>
    </div>
</template>

<script>
export default {
    name: 'HomePageLog',
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

<style src="../resource/css/HomePageLog.css"></style>

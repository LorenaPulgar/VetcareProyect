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
                                <div class="dropdown-item" @click="goToMenuConfig">
                                    <i class="fa-solid fa-gear"></i>
                                    <span>Configuración</span>
                                </div>
                                <div class="dropdown-item" @click="goToHomePage">
                                    <i class="fa-solid fa-arrow-right-from-bracket"></i>
                                    <span>Cerrar sesión</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>

        <div class="Intro">
            <img src="../resource/img/dog-8434228_1280.jpg" alt="Veterinaria" />
        </div>

        <main class="main-content">
            <section class="information">
                <div class="agendar">
                    <div class="agendaricon">
                        <i class="fa-solid fa-calendar-days"></i>
                    </div>
                    <div class="aAgendar">
                        <a href="/demo-schedule-appointment">Agendar Cita</a>
                    </div>
                </div>
                <div class="Blog">
                    <div class="blogicon">
                        <i class="fa-brands fa-blogger-b"></i>
                    </div>
                    <div class="aBlog">
                        <a href="#">Blog</a>
                    </div>
                </div>
                <div class="Hist">
                    <div class="historialicon">
                        <i class="fa-solid fa-notes-medical"></i>
                    </div>
                    <div class="aHist">
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
        goToMenuConfig() {
            this.$router.push('/configuration');
        },
        goToHomePage(){
            this.$router.push('/');
        },
    },
};
</script>

<style src="../resource/css/HomePageLog.css"></style>

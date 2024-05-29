<template>
    <div class="home">
        <header class="header">
            <div class="headermodif">
                <div class="logo">
                    <img src="../resource/img/Logo-VetCare-invertido.png" alt="VetCare Logo" class="imglogo" />
                </div>
                <h1 class="logo-text">VetCare</h1>
            </div>
            <div class="nav-signup">
                <nav>
                    <ul>
                        <li><a href="#">INICIO</a></li>
                        <li><a href="#">BLOG</a></li>
                        <li><a href="#">PETSHOP</a></li>
                    </ul>
                </nav>
                <div class="btn-signup">
                    <button class="signup" @click="goToSignUp">Sign up</button>
                </div>
            </div>
        </header>

        <div class="IntroWelcome">
            <section class="intro">
                <h2>En vetcare <br /> encontraras:</h2>
                <p>
                    Atención médica virtual.<br />
                    Consejos de cuidado de mascotas.<br />
                    Información sobre enfermedades comunes.
                </p>
            </section>
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
                        <a href="#">¿Quienes somos?</a>
                    </div>
                </div>
                <div class="Reseñas">
                    <div class="Estrella">
                        <i class="fa-regular fa-star"></i>
                    </div>
                    <div class="aReseña">
                        <a href="#">Reseñas</a>
                    </div>
                </div>
                <div class="Cont">
                    <div class="Flecha">
                        <i class="fa-solid fa-file-arrow-down"></i>
                    </div>
                    <div class="aCont">
                        <a href="#">Contenido gratuito</a>
                    </div>
                </div>
            </section>
        </main>


        <footer class="footer">

            <div class="social-media">
                <a href="#"><i class="fa-brands fa-instagram fa-2xl" alt="InstagramProfile"></i> </a>
                <a href="#"><i class="fa-brands fa-whatsapp fa-2xl" alt="WhatsappProfile"></i></a>
                <a href="#"><i class="fa-brands fa-github fa-2xl" alt="GitHubprofile"></i></a>
            </div>
        </footer>
    </div>
</template>

<script>
export default {
    name: 'HomeComponent',
    methods: {
        goToSignUp() {
            this.$router.push('Auth');
        }
    }
};
</script>

<style src="../resource/css/HomePage.css"></style>

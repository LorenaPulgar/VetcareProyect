import eventBus from "@/eventBus";


export default {
    name: 'Home',
    methods: {
        goToSignUp() {
            this.$router.push('/auth');
            // Opcionalmente, puedes enviar un evento para cambiar la vista a registro automáticamente
            this.$nextTick(() => {
                this.$root.$emit('showRegister');
            });
        }
    },
    mounted() {
        eventBus.$on('showRegister', () => {
            // Si estás usando un método para mostrar el formulario de registro en el componente LoginComponent, puedes llamarlo aquí
            if (this.$refs.loginComponent) {
                this.$refs.loginComponent.showRegister();
            }
        });
    },
    beforeUnmount() {
        eventBus.$off('showRegister');
    }
};


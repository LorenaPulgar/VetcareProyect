<script setup>
import { ref, onMounted } from 'vue';
import { gapi } from 'gapi-script';

// Configuración de la API
const CLIENT_ID = '709530173155-v9ukvfc25mcucue24gts6skdv11p9rfr.apps.googleusercontent.com';
const API_KEY = 'AIzaSyBFpyFoSrz0VXcd_MQVd6U6-G17IIdBSJE';
const DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];
const SCOPES = "https://www.googleapis.com/auth/calendar.events";

// Datos de la aplicación
const isAuthenticated = ref(false);
const calendarEvents = ref([]);

// Cargar la biblioteca de cliente de Google
const loadClient = () => {
    gapi.load('client:auth2', initClient);
};

// Inicializar el cliente de Google
const initClient = () => {
    gapi.client.init({
        apiKey: API_KEY,
        clientId: CLIENT_ID,
        discoveryDocs: DISCOVERY_DOCS,
        scope: SCOPES,
    }).then(() => {
        gapi.auth2.getAuthInstance().isSignedIn.listen(updateSigninStatus);
        updateSigninStatus(gapi.auth2.getAuthInstance().isSignedIn.get());
    });
};

// Actualizar el estado de autenticación
const updateSigninStatus = (isSignedIn) => {
    isAuthenticated.value = isSignedIn;
    if (isSignedIn) {
        listUpcomingEvents();
    }
};

// Manejar el inicio de sesión
const handleAuthClick = () => {
    gapi.auth2.getAuthInstance().signIn();
};

// Manejar el cierre de sesión
const handleSignoutClick = () => {
    gapi.auth2.getAuthInstance().signOut();
};

// Listar eventos próximos
const listUpcomingEvents = () => {
    gapi.client.calendar.events.list({
        'calendarId': 'primary',
        'timeMin': (new Date()).toISOString(),
        'showDeleted': false,
        'singleEvents': true,
        'maxResults': 10,
        'orderBy': 'startTime'
    }).then(response => {
        const events = response.result.items;
        calendarEvents.value = events.map(event => ({
            id: event.id,
            title: event.summary,
            start: event.start.dateTime || event.start.date
        }));
    });
};

// Agregar un nuevo evento
const addEvent = (newEvent) => {
    const event = {
        'summary': newEvent.title,
        'start': {
            'dateTime': newEvent.start,
            'timeZone': 'America/Los_Angeles'
        },
        'end': {
            'dateTime': newEvent.end,
            'timeZone': 'America/Los_Angeles'
        }
    };

    gapi.client.calendar.events.insert({
        'calendarId': 'primary',
        'resource': event
    }).then(response => {
        console.log('Event created: ' + response.htmlLink);
        listUpcomingEvents(); // Actualizar lista de eventos
    });
};

// Cargar cliente de Google al montar el componente
onMounted(() => {
    loadClient();
});

</script>

<template>
    <div class="wrap">
        <h2>Google Calendar Integration</h2>
        <div>
            <button v-if="!isAuthenticated" @click="handleAuthClick">Sign In</button>
            <button v-else @click="handleSignoutClick">Sign Out</button>
        </div>
        <FullCalendar
            :plugins="[dayGridPlugin, interactionPlugin]"
            initialView="dayGridMonth"
            :events="calendarEvents"
            @dateClick="info => {
                const title = prompt('Enter Event Title:');
                if (title) {
                    addEvent({
                        title,
                        start: info.dateStr,
                        end: new Date(new Date(info.dateStr).setHours(new Date(info.dateStr).getHours() + 1)).toISOString() // Evento de 1 hora
                    });
                }
            }"
        />
    </div>
</template>

<style>
.wrap {
    font-family: "Open Sans";
    padding: 40px 30px 0px 30px;
}

</style>

<template>
  <v-app id="materialpro" :class="`${!$vuetify.breakpoint.smAndDown ? 'full-sidebar' : 'mini-sidebar'}`">
      <router-view />
    <LoginComponent role="user" />
  </v-app>

</template>

<script>
import LoginComponent from '../../shared_components/Login.vue';

export default {
  name: 'App',

  components: {
    LoginComponent
  }

};
</script>

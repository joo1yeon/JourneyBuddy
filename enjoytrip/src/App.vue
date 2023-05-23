<template>
  <div id="app" class="mypadding">
    <the-navi></the-navi>
    <router-view />
    <the-footer></the-footer>
  </div>
</template>

<script>
import TheNavi from "@/components/layout/TheNavi.vue";
import TheFooter from "./components/layout/TheFooter.vue";

export default {
  name: "App",
  components: { TheNavi, TheFooter },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>
<style>
@import "@/assets/styles/main.css";
@import "@/assets/styles/default.css";
@import "@/assets/styles/font.css";

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.alignLeft {
  text-align: left;
}
.alignRight {
  text-align: right;
}
.borderRadius {
  border-radius: 1em;
}
</style>

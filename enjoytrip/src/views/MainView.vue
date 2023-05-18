<template>
  <div>
    <main-carousel></main-carousel>
    <main-hotplace></main-hotplace>
  </div>
</template>

<script>
import MainCarousel from "@/components/main/MainCarousel.vue";
import MainHotplace from "@/components/main/MainHotplace.vue";

export default {
  name: "MainView",
  components: { MainCarousel, MainHotplace },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

<template>
  <div>
    <main-carousel></main-carousel>
  </div>
</template>

<script>
import MainCarousel from "@/components/main/MainCarousel.vue";

export default {
  name: "MainView",
  components: { MainCarousel },
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

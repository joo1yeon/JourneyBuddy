<template>
  <div>
    <b-container class="my-5 py-5">
      <h1 class="alignLeft">핫플레이스</h1>
      <hr />
      <div class="flexContainer col-12">
        <hotplace-list-item></hotplace-list-item>
        <hotplace-list-item></hotplace-list-item>
        <hotplace-list-item></hotplace-list-item>
        <hotplace-list-item></hotplace-list-item>
        <hotplace-list-item></hotplace-list-item>
      </div>
    </b-container>
  </div>
</template>

<script>
import HotplaceListItem from "./item/HotplaceListItem.vue";

export default {
  name: "HotplaceList",
  components: { HotplaceListItem },
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.flexContainer {
  display: flex;
  flex-wrap: wrap;
}
</style>

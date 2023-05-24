<template>
  <div>
    <b-container class="my-5 py-5">
      <h1 class="alignLeft">핫플레이스</h1>
      <hr />
      <div class="flexContainer col-12">
        <hotplace-list-item
          v-for="hotplace in hotplaceList"
          :key="hotplace.hotplaceId"
          :hotplace="hotplace"
        ></hotplace-list-item>
      </div>
    </b-container>
  </div>
</template>

<script>
import http from "@/api/http";
import HotplaceListItem from "./item/HotplaceListItem.vue";

export default {
  name: "HotplaceList",
  components: { HotplaceListItem },
  data() {
    return {
      hotplaceList: [],
    };
  },
  created() {
    http.get(`/hotplace/list`).then(({ data }) => {
      this.hotplaceList = data;
      console.log(this.hotplaceList);
    });
  },
  methods: {},
};
</script>

<style scoped>
.flexContainer {
  display: flex;
  flex-wrap: wrap;
}
</style>

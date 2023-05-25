<template>
  <div>
    <b-container class="my-5 py-5">
      <h1 class="alignLeft">핫플레이스</h1>
      <hr />
      <div class="flexContainer col-12" v-if="hotplaceList.length">
        <hotplace-list-item
          v-for="hotplace in hotplaceList"
          :key="hotplace.hotplaceId"
          :hotplace="hotplace"
        ></hotplace-list-item>
      </div>
      <div v-else>
        등록된 핫플레이스가 없습니다.<br /><br /><br />
        <b-button>등록하기</b-button>
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

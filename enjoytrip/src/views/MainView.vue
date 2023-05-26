<template>
  <div class="main_image">
    <img width="1024" class="main-background" src="@/assets/img/common/main-background3.jpg" alt="image slot" />
    <b-jumbotron style="background-color: rgba(0, 0, 0, 0)" class="alignRight main_image_text grad">
      <template #header><br /><br /><br />Journey Buddy</template>

      <template #lead>
        여행지를 검색하고 계획을 세울 수 있습니다.<br />
        핫 플레이스를 공유하고 나만의 여행 계획을 만들어보세요!
      </template>

      <hr class="my-4" style="color: white" />

      <div v-if="!userInfo">
        <p>회원가입 후 계획 세우고 핫 플레이스 공유하기</p>
        <b-button :to="{ name: 'join' }" style="background-color: rgba(0, 0, 0, 0); border: 1px solid">회원가입</b-button>
      </div>
    </b-jumbotron>
    <div class="my-5"></div>

    <div v-if="hotplaceList.length">
      <h2>🚩 핫플레이스 Best 4</h2>
      <b-container class="flexBox">
        <hotplace-list-item v-for="hotplace in hotplaceList" :key="hotplace.hotplaceId" :hotplace="hotplace" class="col-3"></hotplace-list-item>
      </b-container>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";

import HotplaceListItem from "@/components/hotplace/item/HotplaceListItem.vue";
import http from "@/api/http";

export default {
  name: "MainView",
  components: { HotplaceListItem },
  data() {
    return {
      hotplaceList: [],
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  created() {
    http.get(`/hotplace/list?cnt=4`).then(({ data }) => {
      this.hotplaceList = data;
    });
  },
  methods: {},
};
</script>

<style scoped>
.main_image {
  position: relative;
}
.main_image_text {
  position: absolute;
  height: 80vh;
  width: 100%;
  top: 0%;
  left: 0%;
  /* transform: translate(-50%, -50%); */
  color: white;
}
hr {
  background: rgba(255, 255, 255, 0.3);
  height: 1px;
  border: 0;
}
.grad {
  background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0), rgba(0, 0, 0, 0.7));
}
.flexBox {
  display: flex;
  flex-wrap: wrap;
}
</style>

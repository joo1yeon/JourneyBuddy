<template>
  <b-container id="detail">
    <h2 align="left"><b-icon icon="map"></b-icon> {{ title }}</h2>
    <hr />
    <!-- 카카오 Map -->
    <div id="card">
      <the-map ref="map" :detailList="detailList"></the-map>
    </div>
    <h2 class="mt-4 mb-3" align="left"><b-icon icon="list-task"></b-icon> 나의 일정</h2>
    <hr />
    <!-- 일정 카드 start -->
    <div id="detail-card" v-for="(detail, index) in detailList" :key="index">
      <span class="icon-number mb-3">{{ index + 1 }}</span>
      <b-card no-body class="overflow-hidden mb-3" border-variant="dark" align="left" style="position: relative">
        <b-row no-gutters>
          <!-- 카드 이미지 -->
          <b-col md="4">
            <b-img thumbnail :src="detail.image1" :alt="detail.title" class="rounded-0 card-img" style="max-height: 250px"></b-img>
          </b-col>
          <!-- 카드 body -->
          <b-col md="4">
            <b-card-body :title="detail.title" :sub-title="detail.addr1">
              <hr />
              <b-card-text>
                <strong><b-icon icon="calendar-date"></b-icon> 날짜 : </strong>{{ detail.detailTime }}<br />
                <strong><b-icon icon="check2-square"></b-icon> 메모 내용 : </strong>
                {{ detail.detailInfo }}
              </b-card-text>
            </b-card-body>
          </b-col>
          <!-- 카드 footer -->
          <b-col md="4" style="overflow-y: auto">
            <b-card-footer><b-icon icon="info-square-fill"></b-icon> 관광지 정보</b-card-footer>
            <div style="max-height: 200px; overflow-y: auto">
              <b-list-group>
                <b-list-group-item>{{ detail.overview }}</b-list-group-item>
              </b-list-group>
            </div>
          </b-col>
        </b-row>
      </b-card>
      <!-- 일정 카드 end -->
    </div>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";

import http from "@/api/http";
import TheMap from "@/components/trip/map/TheMap.vue";
export default {
  name: "MyPlanDetail",
  components: { TheMap },
  data() {
    return {
      detailList: [],
      coorList: [],
      title: "",
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  created() {
    this.loadData(); // 데이터 로드 및 지도 작업 실행
    this.loadMapComponent(); // the-map 컴포넌트 로드
  },
  async mounted() {},
  methods: {
    async loadMapComponent() {
      const module = await import("@/components/trip/map/TheMap.vue");
      this.$options.components.TheMap = module.default || module; // the-map 컴포넌트를 동적으로 등록
    },
    loadData() {
      http.get(`/plan/detail/${this.userInfo.userId}/${this.$route.params.tripPlanId}`).then((response) => {
        this.detailList = response.data;
        this.title = this.detailList[0].planTitle;
      });
    },
  },
};
</script>

<style scoped>
#detail {
  margin-top: 100px;
}
#map {
  height: 500px;
}
.icon-number {
  display: flex;
  align-items: center;
  justify-content: center;
  width: 30px;
  height: 30px;
  border-radius: 50%;
  background-color: #28a745;
  color: #fff;
  font-size: 15px;
}
.card-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>

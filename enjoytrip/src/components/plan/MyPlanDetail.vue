<template>
  <b-container id="detail">
    <h2 class="text-left"><b-icon icon="map"></b-icon> {{ title }}</h2>
    <!-- <b-card-group>
      <b-card border-variant="primary" :header="title" align="center">
        <b-card-text>{{}}</b-card-text>
      </b-card>
    </b-card-group> -->
    <hr />
    <div id="map" v-if="detailList.length > 0">
      <the-map ref="map"></the-map>
    </div>
    <hr />
    <h2><b-icon icon="info-circle-fill"></b-icon> 일정</h2>
    <div id="detail-card" v-for="(detail, index) in detailList" :key="index">
      <b-card no-body class="overflow-hidden mb-3" border-variant="dark">
        <b-row no-gutters>
          <b-col md="4">
            <b-card-img :src="detail.image1" :alt="detail.title" class="rounded-0" style="max-height: 250px"></b-card-img>
          </b-col>
          <b-col md="4">
            <b-card-body :title="detail.title" :sub-title="detail.addr1">
              <b-card-text>
                <strong>날짜 : </strong>{{ detail.detailTime }}<br />
                <strong>메모 내용 : </strong>
                {{ detail.detailInfo }}
              </b-card-text>
            </b-card-body>
          </b-col>
          <b-col md="4" style="overflow-y: auto">
            <b-card-footer><b-icon-info-square-fill></b-icon-info-square-fill> 관광지 정보</b-card-footer>
            <div style="max-height: 200px; overflow-y: auto">
              <b-list-group>
                <b-list-group-item>{{ detail.overview }}</b-list-group-item>
              </b-list-group>
            </div>
          </b-col>
        </b-row>
      </b-card>
    </div>
  </b-container>
</template>

<script>
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
  created() {
    this.loadMapComponent(); // TheMap 컴포넌트를 먼저 로드하기 위해 created 훅에서 실행
  },
  methods: {
    loadMapComponent() {
      import("@/components/trip/map/TheMap.vue").then((module) => {
        this.$options.components.TheMap = module.default || module; // TheMap 컴포넌트를 동적으로 등록
      });
    },
    loadData() {
      http.get(`/plan/detail/ssafy/${this.$route.params.tripPlanId}`).then((response) => {
        this.detailList = response.data;
        this.title = this.detailList[0].planTitle;
        this.$nextTick(() => {
          this.$refs.map.drawLine(this.detailList);
          this.$refs.map.displayMarker(this.detailList);
        });
      });
    },
  },
  mounted() {
    this.loadData(); // 데이터 로드 및 지도 작업 실행
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
</style>

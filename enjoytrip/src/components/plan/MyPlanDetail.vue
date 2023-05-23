<template>
  <b-container id="detail">
    <h2 align="left"><b-icon icon="map"></b-icon> {{ title }}</h2>
    <hr />
    <div id="map">
      <the-map ref="map"></the-map>
    </div>
    <!-- <hr /> -->
    <h2 class="mt-4 mb-3" align="left"><b-icon icon="list-task"></b-icon> 나의 일정</h2>
    <hr />
    <div id="detail-card" v-for="(detail, index) in detailList" :key="index">
      <span class="icon-number mb-3">{{ index + 1 }}</span>
      <b-card no-body class="overflow-hidden mb-3" border-variant="dark" align="left" style="position: relative">
        <b-row no-gutters>
          <b-col md="4">
            <b-img thumbnail :src="detail.image1" :alt="detail.title" class="rounded-0 card-img" style="max-height: 250px"></b-img>
          </b-col>
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
  created() {},
  mounted() {
    http.get(`/plan/detail/ssafy/${this.$route.params.tripPlanId}`).then((response) => {
      this.detailList = response.data;
      this.title = this.detailList[0].planTitle;
      this.$refs.map.drawLine(this.detailList);
      this.$refs.map.displayMarker(this.detailList);
    });
  },
  updated() {},
  methods: {},
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

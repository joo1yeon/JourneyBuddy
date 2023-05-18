<template>
  <div id="search">
    <!-- 중앙 content start -->
    <b-container>
      <b-row>
        <!-- 중앙 left content  start -->
        <div class="col-md-3">
          <!-- 관광지 리스트 Start -->
          <b-alert variant="success" show>관광지 리스트</b-alert>
          <div style="overflow-y: auto; height: 520px">
            <b-table striped hover :fields="fields" :items="attractionList" @row-clicked="moveCenter" v-if="attractionList.length"> </b-table>
            <span v-else>관광지 리스트가 존재하지 않습니다</span>
          </div>
          <!-- 관광지 리스트 End -->
        </div>
        <!-- 중앙 left content end -->
        <!-- 중앙 center content end -->
        <div class="col-md-9">
          <b-alert variant="primary" show>전국 관광지 정보</b-alert>
          <!-- 관광지 검색 start -->
          <form class="my-3" onsubmit="return false;" role="search">
            <div class="d-flex mb-3">
              <b-form-select
                v-model="selectedSido"
                :options="sidos"
                value-field="sidoCode"
                text-field="sidoName"
                @change="searchGugun"
              ></b-form-select>
              <b-form-select v-model="selectedGugun" :options="guguns" value-field="gugunCode" text-field="gugunName"></b-form-select>
              <input id="search-keyword" class="form-control me-2" type="search" placeholder="검색어" aria-label="검색어" v-model="query" />
              <b-button variant="outline-success" type="button" @click="search">검색</b-button>
            </div>
            <b-form-radio-group v-model="contentType" :options="places" name="place-type"></b-form-radio-group>
          </form>
          <!-- 카카오 맵 start -->
          <the-map class="mt-3" ref="map"></the-map>
          <!-- 카카오 맵 end -->
        </div>
      </b-row>
    </b-container>
    <!-- 중앙 content end -->

    <!-- 핫플레이스 추가 modal start -->
    <div
      class="modal fade"
      id="hotPlaceModal"
      data-bs-backdrop="static"
      data-bs-keyboard="false"
      tabindex="-1"
      aria-labelledby="staticBackdropLabel"
      aria-hidden="true"
    >
      <div class="modal-dialog modal-lg">
        <div class="modal-content">
          <!-- Modal Header -->
          <div class="modal-header">
            <h4 class="modal-title">
              <i class="bi"> 핫플레이스 추가</i>
            </h4>
            <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
          </div>

          <!-- Modal body -->
          <div class="modal-body">
            <form action="">
              <div class="mb-3">
                <i class="bi" style="color: rgb(121, 2, 119)"></i>
                <label for="question" class="form-label">핫 플레이스:</label>
                <input type="text" class="form-control" id="question" placeholder="핫 플레이스 입력..." name="question" />
              </div>
              <div class="mb-3">
                <i class="bi" style="color: rgb(14, 2, 121)"></i>
                <label for="question" class="form-label">리뷰:</label>
                <button type="button" id="btn-answer-add" class="btn btn-outline-primary btn-sm"><i class="bi bi-plus-square-fill"></i> 추가</button>
              </div>
              <div id="hotPlace-answer-list" class="row mb-3">
                <div class="row mb-1 hotPlace-answer-list-item">
                  <div class="col-md-10">
                    <input type="text" class="form-control" name="answer" />
                  </div>
                </div>
              </div>
            </form>
          </div>

          <!-- Modal footer -->
          <div class="modal-footer">
            <button type="button" id="btn-hotPlace-create" class="btn btn-primary btn-sm">리뷰작성</button>
            <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">Close</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";
import TheMap from "@/components/trip/map/TheMap.vue";
export default {
  name: "TripSearch",
  components: { TheMap },
  data() {
    return {
      selectedSido: 6,
      selectedGugun: 16,
      selectedPlace: 16,
      sidos: [],
      guguns: [],
      places: [
        { text: "전체 선택", value: 0 },
        { text: "관광지", value: 12 },
        { text: "문화 시설", value: 14 },
        { text: "축제공연행사", value: 15 },
        { text: "여행코스", value: 25 },
        { text: "레포츠", value: 28 },
        { text: "숙박", value: 32 },
        { text: "쇼핑", value: 38 },
        { text: "음식점", value: 39 },
      ],
      contentType: 12,
      query: "해운대",
      attractionList: [],
      fields: [
        {
          key: "title",
          label: "관광지명",
        },
        {
          key: "addr1",
          label: "주소",
        },
      ],
    };
  },
  created() {
    http.get("/trip/sido").then((response) => {
      this.sidos = response.data;
    });
  },
  methods: {
    searchGugun() {
      http.get(`/trip/gugun?sidoCode=${this.selectedSido}`).then((response) => {
        this.guguns = response.data;
      });
    },
    search() {
      if (!this.query || this.query == "") {
        alert("검색어를 입력해주세요");
        return;
      }
      let url = "contentType=" + this.contentType;
      if (this.selectedGugun > 0) {
        url += "&gugunCode=" + this.selectedGugun;
      }
      if (this.selectedSido > 0) {
        url += "&sidoCode=" + this.selectedSido;
      }
      url += "&query=" + this.query;
      http.get(`/trip/list?${url}`).then((response) => {
        this.attractionList = response.data;
        this.$refs.map.displayMarker(this.attractionList);
      });
    },
    moveCenter(items) {
      console.log(items);
      this.$refs.map.moveCenter(items);
    },
  },
};
</script>

<style>
#search {
  margin-top: 100px;
}
</style>

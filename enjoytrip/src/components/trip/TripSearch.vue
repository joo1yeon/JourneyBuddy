<template>
  <div id="search">
    <!-- 중앙 content start -->
    <div>
      <b-row>
        <!-- 중앙 left content  start -->
        <div class="col-md-3">
          <!-- 관광지 리스트 Start -->
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
              <input
                id="search-keyword"
                class="form-control me-2"
                type="search"
                placeholder="검색어"
                aria-label="검색어"
                v-model="query"
                @keyup.enter="search"
              />
              <b-button variant="outline-success" type="button" @click="search">검색</b-button>
            </div>
            <b-form-radio-group v-model="contentType" :options="places" name="place-type"></b-form-radio-group>
          </form>
          <b-alert variant="success" show v-if="attractionList.length">관광지 리스트 ({{ attractionList.length }}개의 검색결과)</b-alert>
          <b-alert variant="success" show v-else>관광지 리스트</b-alert>
          <div style="overflow-y: auto; height: 520px">
            <b-table striped hover :fields="fields" :items="attractionList" @row-clicked="moveCenter" v-if="attractionList.length">
              <template #cell(checked)="data">
                <b-checkbox v-model="data.item.checked" @change="check"></b-checkbox>
              </template>
            </b-table>
            <span v-else>관광지 리스트가 존재하지 않습니다</span>
          </div>
          <!-- 관광지 리스트 End -->
        </div>
        <!-- 중앙 left content end -->

        <!-- 중앙 center content end -->
        <!-- 카카오 맵 start -->
        <div class="col-md-6">
          <the-map ref="map"></the-map>
        </div>
        <!-- 카카오 맵 end -->

        <!-- 선택된 여행지 start -->
        <div class="col-md-3">
          <b-alert variant="warning" show>선택된 여행지</b-alert>
          <b-form v-if="checkList.length" class="text-left">
            <b-form-group label="여행 주제 : ">
              <b-input type="text" v-model="title"></b-input>
            </b-form-group>
            <b-button class="text-left mb-2" variant="danger" @click="registerPlan">등록하기</b-button>
          </b-form>
          <div style="overflow-y: auto; height: 520px" class="mt-3">
            <b-table striped hover :fields="fields2" :items="checkList" @row-clicked="showModal" v-if="checkList.length"> </b-table>
            <span v-else>선택된 여행지가 존재하지 않습니다</span>
          </div>
          <!-- 계획 등록 modal start -->
          <b-modal id="plan-modal" title="장소 정보 등록" @ok="registerInfo">
            <plan-modal :infoItem="infoItem" :attraction="attraction" :show="show" ref="planInfo" @plan-detail="DetailSetting"> </plan-modal>
          </b-modal>
          <!-- 계획 등록 modal end -->
          <!-- 여행 주제 modal start -->
          <b-modal id="plan-title" title="여행 주제 선정" hide-footer>
            <plan-title :show="show"></plan-title>
          </b-modal>
          <!-- 여행 주제 modal end -->
        </div>
        <!-- 선택된 여행지 end -->
      </b-row>
    </div>
    <!-- 중앙 content end -->

    <!-- 핫플레이스 추가 (예정) modal start -->
    <b-modal>
      <hot-place> </hot-place>
    </b-modal>
    <!-- 핫플레이스 추가 (예정) modal end -->
  </div>
</template>

<script>
import http from "@/api/http";
import TheMap from "@/components/trip/map/TheMap.vue";
import HotPlace from "@/components/trip/map/HotPlace.vue";
import PlanModal from "@/components/trip/plan/PlanModal.vue";
import PlanTitle from "@/components/trip/plan/PlanTitle.vue";
export default {
  name: "TripSearch",
  components: { TheMap, HotPlace, PlanModal, PlanTitle },
  data() {
    return {
      title: "",
      show: false,
      selectedSido: 0,
      selectedGugun: 0,
      selectedPlace: 0,
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
      contentType: 0,
      query: "해운대",
      // infoItem: {},
      attraction: {},
      attractionList: [],
      checkList: [],
      infoList: [],
      fields: [
        {
          key: "title",
          label: "관광지명",
        },
        {
          key: "addr1",
          label: "주소",
        },
        {
          key: "checked",
          label: "선택",
        },
      ],
      fields2: [
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
    // 시도
    http.get("/trip/sido").then((response) => {
      this.sidos = response.data;
    });
  },
  computed: {},
  methods: {
    // 구군 검색
    searchGugun() {
      http.get(`/trip/gugun?sidoCode=${this.selectedSido}`).then((response) => {
        this.guguns = response.data;
      });
    },
    // 관광지 검색
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
        this.attractionList = [];
        this.attractionList = response.data;
        this.$refs.map.displayMarker(this.attractionList);
      });
    },
    // 지도 중심 이동
    moveCenter(items) {
      this.$refs.map.moveCenter(
        items.contentId,
        items.latitude,
        items.longitude,
        items.title,
        items.addr1,
        items.addr2,
        items.image1,
        items.contentTypeId
      );
    },
    // 여행 계획 등록
    registerPlan() {
      let plan = [];
      console.log(this.title);
      console.log(this.checkList);
      this.checkList.forEach((check, index) => {
        const obj = {
          contentId: check.contentId,
          info: check.info,
          sequence: index + 1,
          time: check.time,
          title: this.title,
          tripPlanDetailId: 0,
          writer: "ssafy",
        };
        plan.push(obj);
      });
      http.post(`/plan/ssafy/${this.title}`, plan).then(alert("정상적으로 등록되었습니다"));
    },
    // 계획 정보 등록 모달
    showModal(item) {
      this.$bvModal.show("plan-modal");
      this.infoItem = this.infoList.find((tmp) => {
        tmp.contentId == item.contentId;
      });
      this.attraction = item;
      this.show = true;
    },
    // 체크박스 체크 시
    check(item) {
      // 체크
      if (item) {
        this.attractionList.forEach((att) => {
          if (att.checked === true && this.checkDuplicate(att)) {
            this.checkList.push(att);
          }
        });
      }
      // 체크 해제
      else {
        this.checkList.forEach((test2) => {
          if (test2.checked == false) {
            this.removePlan(test2);
          }
        });
      }
    },
    // 관광지 중복 여부 확인
    checkDuplicate(att) {
      return !this.checkList.some((a) => a.contentId === att.contentId);
    },
    // 선택 여행지 제거
    removePlan(test2) {
      const index = this.checkList.findIndex((a) => a.contentId === test2.contentId);
      if (index !== -1) {
        this.checkList.splice(index, 1);
      }
    },
    // 여행 정보 등록
    registerInfo() {
      this.$refs.planInfo.registerPlanDetail();
      alert("정상적으로 등록되었습니다");
    },
    // 여행 정보 세팅 (PlanModal로 부터 받음)
    DetailSetting(detail) {
      const index = this.infoList.findIndex((item) => item.contentId == detail.contentId);
      // 값이 존재하는 경우
      if (index != -1) {
        this.infoList[index] = detail;
      }
      // 값이 존재하지 않는 경우
      else {
        this.infoList.push(detail);
      }
    },
    infoItem() {
      return this.infoList;
    },
  },
};
</script>

<style>
#search {
  margin-top: 100px;
}
</style>

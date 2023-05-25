<template>
  <b-container class="my-5 py-5 alignLeft">
    <h1>핫 플레이스 등록</h1>
    <hr />
    <b-row class="mb-5">
      <div class="col-6">
        제목으로 장소 검색
        <!-- 검색창 -->
        <div>
          <b-input-group class="mb-3">
            <b-form-input @keyup.enter="search" v-model="query" style="border-radius: 1em 0 0 1em"></b-form-input>
            <b-input-group-append>
              <b-button @click="search" size="sm" style="border-radius: 0 1em 1em 0"><b-icon icon="search" /></b-button>
            </b-input-group-append>
          </b-input-group>
          <strong v-if="attractionList.length">{{ attractionList.length }}개의 검색결과</strong>
        </div>
        <!-- 검색 결과 -->
        <div style="overflow-y: auto; height: 20em">
          <b-table hover :fields="fields" :items="attractionList" @row-clicked="moveCenter" v-if="attractionList.length"> </b-table>
          <span v-else>검색 결과가 없습니다.</span>
        </div>
      </div>
      <div class="col-6" style="height: 23em">
        위치
        <the-map ref="map" class="borderRadius"></the-map>
      </div>
    </b-row>

    <hr />
    <b-row>
      <div class="col-6">
        핫 플레이스 정보

        <div class="box shadow">
          <b-input type="text" v-model="userId" style="display: none"></b-input>
          <div class="inputStyle">
            <b-icon icon="hash" /> 제목
            <b-input type="text" v-model="hotplaceInfo.hotplaceTitle"></b-input>
          </div>
          <div class="inputStyle">
            <b-icon icon="calendar" /> 방문 날짜
            <b-input type="date" v-model="hotplaceInfo.visitDate"></b-input>
          </div>
          <div class="inputStyle">
            <b-icon icon="geo-alt-fill" /> 장소 이름
            <b-input type="text" v-model="hotplaceInfo.placeName"></b-input>
          </div>
          <div class="inputStyle">
            <b-icon icon="building" /> 장소 유형
            <b-form-select v-model="hotplaceInfo.placeType" :options="options"></b-form-select>
          </div>
          <div class="inputStyle">
            <b-icon icon="camera-fill" /> 이미지 추가
            <!-- Styled -->
            <b-form-file
              @change="previewImageFile"
              ref="hotplImage"
              id="hotplImage"
              :state="Boolean(upfile)"
              placeholder="파일을 선택하거나 이 곳으로 드래그"
              drop-placeholder="이 곳으로 드래그"
            ></b-form-file>
          </div>
          <div class="inputStyle">
            <b-icon icon="star-fill" /> 별점
            <b-form-rating v-model="hotplaceInfo.score" variant="warning" class="mb-2" style="border: none"></b-form-rating>
          </div>
        </div>
      </div>
      <div class="col-6">
        <div class="mb-3">선택된 이미지</div>
        <b-img v-if="previewImage" :src="previewImage" fluid alt="Responsive image" class="borderRadius"></b-img>
        <div v-else>이미지를 선택해주세요.</div>
      </div>
    </b-row>
    <hr />
    <b-row class="mb-5">
      상세 내용
      <b-form-textarea
        v-model="hotplaceInfo.contents"
        id="textarea"
        placeholder="상세 내용 작성하기"
        rows="5"
        max-rows="10"
        class="borderRadius"
      ></b-form-textarea>
    </b-row>

    <div style="text-align: center">
      <b-button variant="outline-secondary" style="border-radius: 1em 0 0 1em">취소</b-button>
      <b-button @click="register()" class="borderRadiusRight" style="border-radius: 0 1em 1em 0">등록</b-button>
    </div>
  </b-container>
</template>

<script>
import http from "@/api/http";
import TheMap from "../trip/map/TheMap.vue";

import { mapState, mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "HotplaceWrite",
  components: { TheMap },
  data() {
    return {
      selected: "0",
      options: [
        { value: "0", text: "선택하세요." },
        { value: "12", text: "관광지" },
        { value: "14", text: "문화시설" },
        { value: "15", text: "축제 | 공연 | 행사" },
        { value: "25", text: "여행코스" },
        { value: "28", text: "레포츠" },
        { value: "32", text: "숙박" },
        { value: "38", text: "쇼핑" },
        { value: "39", text: "음식점" },
      ],
      previewImage: "",
      upfile: null,
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
      attractionList: [],
      contentType: 0,
      query: "",
      hotplaceInfo: {
        placeId: "",
        placeType: "",
        placeName: "",
        hotplaceTitle: "",
        writer: "",
        visitDate: "",
        contents: "",
        score: 0,
      },
      // userInfo: null,
    };
  },
  created() {},
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");

      if (this.isLogin) {
        await this.getUserInfo(token);
        // this.userInfo = this.$store.state.userStore.userInfo;
      }
    },
    previewImageFile(e) {
      let imageFile = e.target.files;
      console.log(imageFile[0]);
      let url = URL.createObjectURL(imageFile[0]);
      console.log(url);
      this.previewImage = url;

      this.upfile = imageFile[0];
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

      // 관광지 정보 가져오기
      this.hotplaceInfo.placeId = items.contentId;
      this.hotplaceInfo.placeType = items.contentTypeId;
      this.hotplaceInfo.placeName = items.title;
    },
    // 관광지 검색
    search() {
      if (!this.query || this.query == "") {
        alert("검색어를 입력해주세요");
        return;
      }
      let url = "contentType=" + this.contentType;

      url += "&query=" + this.query;
      http.get(`/trip/list?${url}`).then((response) => {
        this.attractionList = [];
        this.attractionList = response.data;
        this.$refs.map.displayMarker(this.attractionList);
      });
    },
    register() {
      this.hotplaceInfo.writer = this.userInfo.userId;

      http.post("/hotplace", this.hotplaceInfo).then(() => {
        this.$router.push({ name: "hotplacelist" });
      });
    },
  },
};
</script>

<style scoped>
.box {
  border: lightgrey 1px solid;
  border-radius: 1em;
  /* height: 23em; */
  padding: 1em;
  margin: 1em;
}
.inputStyle {
  margin: 1em;
}
.flexBox {
  display: flex;
}
/* table th:nth-child(1),
table td:nth-child(1) {
  width: 11em;
} */
</style>

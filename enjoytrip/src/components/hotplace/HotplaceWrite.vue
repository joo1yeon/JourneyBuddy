<template>
  <b-container class="my-5 py-5 alignLeft">
    <h1>핫플레이스 등록</h1>
    <hr />
    <b-row>
      <div class="col-6">
        <div class="mb-3">선택된 이미지</div>
        <b-img
          v-if="previewImage"
          :src="previewImage"
          fluid
          alt="Responsive image"
          class="radiusImg"
        ></b-img>
        <div v-else>이미지를 선택해주세요.</div>
      </div>
      <div class="col-6">
        핫플레이스 정보

        <div class="box shadow">
          <div class="inputStyle">
            <b-icon icon="calendar" /> 방문 날짜
            <b-input type="date"></b-input>
          </div>
          <div class="inputStyle">
            <b-icon icon="building" /> 장소 유형
            <b-form-select v-model="selected" :options="options"></b-form-select>
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
        </div>
      </div>
    </b-row>
    <hr />
    <b-row class="mb-5">
      상세 내용
      <b-form-textarea
        id="textarea"
        placeholder="상세 내용 작성하기"
        rows="5"
        max-rows="10"
        class="radiusImg"
      ></b-form-textarea>
    </b-row>

    <hr />
    <b-row class="mb-5">
      <div class="col-12" style="height: 20em">
        위치
        <the-map ref="map" class="radiusImg"></the-map>
      </div>
    </b-row>

    <div class="alignRight">
      <b-button variant="outline-secondary" class="mx-1">취소</b-button>
      <b-button class="mx-1">등록</b-button>
    </div>
  </b-container>
</template>

<script>
import TheMap from "../trip/map/TheMap.vue";

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
    };
  },
  created() {},
  methods: {
    previewImageFile(e) {
      let imageFile = e.target.files;
      console.log(imageFile[0]);
      let url = URL.createObjectURL(imageFile[0]);
      console.log(url);
      this.previewImage = url;

      this.upfile = imageFile[0];
    },
  },
};
</script>

<style scoped>
.box {
  border: lightgrey 1px solid;
  border-radius: 1em;
  height: 19em;
  padding: 1em;
  margin: 1em;
}
.inputStyle {
  margin: 1em;
}
</style>

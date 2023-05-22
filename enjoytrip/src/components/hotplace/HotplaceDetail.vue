<template>
  <b-container class="my-5 py-5 alignLeft">
    <h2>해운대</h2>
    <p class="alignRight"><b-icon icon="suit-heart" font-scale="1" /> 12</p>
    <hr />
    <b-row>
      <div class="col-6">
        이미지
        <b-img
          src="https://picsum.photos/1024/500/?image=41"
          fluid
          alt="Responsive image"
          class="radiusImg"
        ></b-img>
      </div>
      <div class="col-6">
        핫플레이스 정보

        <table class="box">
          <tr>
            <b-td><b-icon icon="calendar" /> 날짜</b-td>
            <td>2023.05.23</td>
          </tr>
          <tr>
            <td><b-icon icon="building" /> 장소 유형</td>
            <td>관광지</td>
          </tr>
          <tr>
            <td><b-icon icon="person" /> 작성자</td>
            <td>김싸피</td>
          </tr>
          <tr>
            <td><b-icon icon="chat-right-dots" /> 상세내용</td>
            <td>ㅎㅎㅎㅎㅋㅋㅋㅋㅋㅋㅋㅋ 관통 너무 재밌다</td>
          </tr>
        </table>
      </div>
    </b-row>
    <hr />

    <b-row>
      <div class="col-12" style="height: 20em">
        위치
        <the-map ref="map" class="radiusImg"></the-map>
      </div>
    </b-row>
    <hr />
    <div>댓글</div>
    <hr />
    <div>
      <b-form-textarea
        id="textarea"
        v-model="text"
        placeholder="댓글 작성하기"
        rows="3"
        max-rows="6"
        class="radiusImg mb-5"
      ></b-form-textarea>

      <pre class="mt-3 mb-0">{{ text }}</pre>
    </div>
    <hotplace-comment-item></hotplace-comment-item>
  </b-container>
</template>

<script>
import TheMap from "../trip/map/TheMap.vue";
import HotplaceCommentItem from "./item/HotplaceCommentItem.vue";

export default {
  components: { HotplaceCommentItem, TheMap },
  name: "HotplaceDetail",
};
</script>

<style scoped>
.alignLeft {
  text-align: left;
}
.alignRight {
  text-align: right;
}
.radiusImg {
  border-radius: 1em;
}
table {
  /* border: lightgrey 1px solid; */
  border-radius: 1em;
  height: 2em;
  padding: 1em;
  margin: 0.5em;
}
td:nth-child(1) {
  width: 8em;
  padding: 0.7em;
  font-size: 1em;
}
</style>

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
          class="borderRadius"
        ></b-img>
      </div>
      <div class="col-6">
        핫플레이스 정보

        <!-- <div class="box shadow">
          <div class="inputStyle">
            <b-icon icon="calendar" /> 방문 날짜
            <div>2023.05.23</div>
          </div>
          <div class="inputStyle">
            <b-icon icon="building" /> 장소 유형
            <b-form-select v-model="selected" :options="options"></b-form-select>
          </div>
          <div class="inputStyle">
            <b-icon icon="camera-fill" /> 이미지 추가

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
            <b-form-rating v-model="ratingValue" variant="warning" class="mb-2"></b-form-rating>
          </div>
        </div> -->

        <div class="box shadow">
          <table>
            <tr>
              <td><b-icon icon="calendar" /> 날짜</td>
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
              <td><b-icon icon="star" /> 평점</td>
              <td>
                <b-form-rating
                  v-model="ratingValue"
                  show-value
                  readonly
                  variant="warning"
                  class="mb-2 borderNone"
                ></b-form-rating>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </b-row>
    <hr />

    <b-row class="my-2 flexContainer">
      <div class="col-12"><b-icon icon="chat-right-dots" /> 상세내용</div>
      <div class="col-12 flexBox">ㅎㅎㅎㅎㅋㅋㅋㅋㅋㅋㅋㅋ 관통 너무 재밌다</div>
    </b-row>

    <hr />
    <b-row class="my-5">
      <div class="col-12" style="height: 20em">
        위치
        <the-map ref="map" class="borderRadius"></the-map>
      </div>
    </b-row>
    <hr />

    <div>
      댓글
      <b-form-textarea
        id="textarea"
        v-model="comment"
        placeholder="댓글 작성하기"
        rows="3"
        max-rows="6"
        class="borderRadius"
      ></b-form-textarea>

      <div class="alignRight my-3">
        <b-button>등록</b-button>
      </div>
    </div>
    <hotplace-comment-item></hotplace-comment-item>
    <b-row>
      <b-button class="alignCenter my-3" :to="{ name: 'hotplacelist' }">목록으로</b-button>
    </b-row>
  </b-container>
</template>

<script>
import TheMap from "../trip/map/TheMap.vue";
import HotplaceCommentItem from "./item/HotplaceCommentItem.vue";

export default {
  components: { HotplaceCommentItem, TheMap },
  name: "HotplaceDetail",
  data() {
    return {
      comment: "",
      ratingValue: 5,
    };
  },
};
</script>

<style scoped>
.box {
  border: lightgrey 1px solid;
  border-radius: 1em;
  height: 15em;
  padding: 1em;
  margin: 1em;
}
.inputStyle {
  margin: 1em;
}
td:nth-child(1) {
  width: 8em;
  padding: 0.7em;
  font-size: 1em;
}
.borderNone {
  border: none;
}
.flexContainer {
  display: flex;
}
.flexBox {
  border: lightgrey 1px solid;
  border-radius: 1em;
  padding: 1em;
  margin: 1em;
}
.alignCenter {
  margin: 0 auto;
}
</style>

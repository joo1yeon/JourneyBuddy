<template>
  <b-container class="my-5 py-5 alignLeft">
    <h3>{{ hotplaceInfo.hotplaceTitle }}</h3>
    <small>{{ hotplaceInfo.visitDate }}</small>
    <p style="display: none" class="alignRight"><b-icon icon="suit-heart" font-scale="1" /> 12</p>
    <hr />
    <b-row>
      <div class="col-6">
        이미지
        <b-img src="https://picsum.photos/1024/500/?image=41" fluid alt="Responsive image" class="borderRadius"></b-img>
      </div>
      <div class="col-6">
        🚩 핫 플레이스 정보

        <div class="box shadow">
          <table>
            <tr>
              <td><b-icon icon="geo-alt-fill" /> 장소 이름</td>
              <td>{{ hotplaceInfo.placeName }}</td>
            </tr>
            <tr>
              <td><b-icon icon="building" /> 장소 유형</td>
              <td>{{ getPlaceType() }}</td>
            </tr>
            <tr>
              <td><b-icon icon="person" /> 작성자</td>
              <td>{{ hotplaceInfo.writer }}</td>
            </tr>
            <tr>
              <td><b-icon icon="eye" /> 조회수</td>
              <td>{{ hotplaceInfo.hit }}</td>
            </tr>
            <tr>
              <td><b-icon icon="star" /> 평점</td>
              <td>
                <b-form-rating v-model="hotplaceInfo.score" show-value readonly variant="warning" class="mb-2 borderNone"></b-form-rating>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </b-row>
    <hr />

    <b-row class="my-2 flexContainer">
      <div class="col-12"><b-icon icon="chat-right-dots" /> 상세내용</div>
      <div class="col-12 flexBox">{{ hotplaceInfo.contents }}</div>
    </b-row>

    <hr />
    <b-row class="my-5">
      <div class="col-12" style="height: 20em">
        위치
        <the-map ref="map" class="borderRadius" :hotplaceAttractionInfo="hotplaceAttractionInfo"></the-map>
      </div>
    </b-row>
    <hr />

    <div>
      <b-form-textarea
        id="textarea-comment"
        v-model="commentInfo.contents"
        placeholder="댓글 작성하기"
        rows="3"
        max-rows="6"
        class="borderRadius"
      ></b-form-textarea>

      <div class="alignRight my-3">
        <b-button @click="writeComment()">등록</b-button>
      </div>
    </div>
    댓글
    <hr />
    <template v-if="commentList">
      <hotplace-comment-item
        v-for="comment in commentList"
        :key="comment.hotplaceCommentId"
        :comment="comment"
        @reloadComments="reloadComments"
      ></hotplace-comment-item>
    </template>
    <div v-else>댓글이 없습니다.</div>
    <b-row>
      <b-button class="alignCenter my-3" :to="{ name: 'hotplacelist' }">목록으로</b-button>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/http";
import TheMap from "../trip/map/TheMap.vue";
import HotplaceCommentItem from "./item/HotplaceCommentItem.vue";

import { mapState } from "vuex";

const userStore = "userStore";

export default {
  components: { HotplaceCommentItem, TheMap },
  name: "HotplaceDetail",
  data() {
    return {
      hotplaceInfo: {
        hotplaceId: "",
        placeId: "",
        placeType: "",
        placeName: "",
        hotplaceTitle: "",
        writer: "",
        visitDate: "",
        contents: "",
        score: 0,
        hit: 0,
        rcmdCnt: 0,
      },
      hotplaceAttractionInfo: {},
      commentInfo: {
        hotplaceCommentId: "",
        hotplaceId: "",
        writer: "",
        contents: "",
      },
      commentList: [],
    };
  },
  created() {
    this.loadMapComponent(); // the-map 컴포넌트 로드
    this.loadHotplaceInfo(); // 핫플레이스 정보 로드
    this.loadCommentList(); // 댓글 리스트 로드
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  async mounted() {},
  methods: {
    loadHotplaceInfo() {
      this.hotplaceInfo.hotplaceId = this.$route.params.hotplaceId;
      http.get(`/hotplace/${this.hotplaceInfo.hotplaceId}`).then(({ data }) => {
        this.hotplaceInfo = data;
        this.loadAttractionInfo();
      });
    },
    loadCommentList() {
      http
        .get(`/hotplace/comment/list`, {
          params: {
            hotplaceId: `${this.hotplaceInfo.hotplaceId}`,
          },
        })
        .then(({ data }) => {
          this.commentList = data;
        });
    },
    loadAttractionInfo() {
      http
        .get(`/trip`, {
          params: {
            contentId: this.hotplaceInfo.placeId,
          },
        })
        .then(({ data }) => {
          this.hotplaceAttractionInfo = data;
        });
    },
    async loadMapComponent() {
      const module = await import("@/components/trip/map/TheMap.vue");
      this.$options.components.TheMap = module.default || module; // the-map 컴포넌트를 동적으로 등록
    },
    getPlaceType() {
      let placeType = this.hotplaceInfo.placeType;

      if (placeType === "12") {
        return "관광지";
      } else if (placeType === "14") {
        return "문화시설";
      } else if (placeType === "15") {
        return "축제 | 공연 | 행사";
      } else if (placeType === "25") {
        return "여행코스";
      } else if (placeType === "28") {
        return "레포츠";
      } else if (placeType === "32") {
        return "숙박";
      } else if (placeType === "38") {
        return "쇼핑";
      } else if (placeType === "39") {
        return "음식점";
      }
    },
    writeComment() {
      this.commentInfo.hotplaceId = this.hotplaceInfo.hotplaceId;
      this.commentInfo.writer = this.userInfo.userId;
      http.post(`/hotplace/comment`, this.commentInfo).then(() => {
        this.commentInfo.contents = "";

        http
          .get(`/hotplace/comment/list`, {
            params: {
              hotplaceId: `${this.hotplaceInfo.hotplaceId}`,
            },
          })
          .then(({ data }) => {
            this.commentList = data;
          });
      });
    },
    reloadComments() {
      http
        .get(`/hotplace/comment/list`, {
          params: {
            hotplaceId: `${this.hotplaceInfo.hotplaceId}`,
          },
        })
        .then(({ data }) => {
          this.commentList = data;
        });
    },
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

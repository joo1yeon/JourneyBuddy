<template>
  <b-container id="list">
    <b-alert show><h2>공지사항</h2></b-alert>
    <div v-if="userInfo && userInfo.userId == 'ssafy'" class="d-flex mb-3">
      <b-button variant="success" type="button" :to="{ name: 'noticewrite' }">작성하기</b-button>
    </div>
    <!-- 공지 리스트만 있을 경우 -->
    <div v-if="!isNotice && noticeList">
      <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields">
        <template #cell(userId)="data">
          <div v-if="data.item.userId === 'ssafy'">관리자</div>
        </template>
      </b-table>
    </div>
    <!-- 메인공지 & 공지 리스트 모두 존재 할 경우 -->
    <div v-else-if="isNotice && noticeList">
      <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields" :top-row="topRowContent">
        <template #cell(userId)="data">
          <div v-if="data.item.userId === 'ssafy'">관리자</div>
        </template>
      </b-table>
    </div>
    <!-- 메인공지 & 공지 리스트 모두 존재 안 할 경우 -->
    <div v-else-if="!isNotice && !noticeList">
      <h2>공지사항이 존재하지 않습니다</h2>
    </div>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";

import http from "@/api/http";
export default {
  name: "NoticeList",
  data() {
    return {
      fields: [
        {
          key: "noticeNo",
          label: "글 번호",
        },
        {
          key: "subject",
          label: "제목",
        },
        {
          key: "userId",
          label: "작성자",
        },
        {
          key: "hit",
          label: "조회수",
        },
      ],
      noticeList: [],
      mainNotice: null,
      isNotice: false,
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
    tableData() {
      if (this.mainNotice) {
        return [this.mainNotice, ...this.noticeList];
      } else {
        return this.noticeList;
      }
    },
    topRowContent() {
      if (this.isNotice) {
        return [this.mainNotice];
      } else {
        return null;
      }
    },
  },
  created() {
    http.get("/notice/list").then((response) => {
      this.noticeList = response.data;
      this.mainNotice !== undefined;
      if (this.noticeList) {
        this.mainNotice = this.noticeList.find((notice) => notice.mainNotice === "true");
      }
      if (this.mainNotice !== undefined && this.noticeList) {
        this.mainNotice._rowVariant = "danger";
        this.isNotice = true;
      } else {
        this.isNotice = false;
      }
    });
  },

  methods: {
    noticeView(items) {
      this.$router.push({ name: "noticeview", params: { noticeno: items.noticeNo } });
    },
  },
};
</script>

<style scoped>
#list {
  margin-top: 100px;
}
</style>

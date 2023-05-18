<template>
  <b-container id="list">
    <h2>공지사항 게시판</h2>
    <b-button variant="success" type="button" :to="{ name: 'noticewrite' }">작성하기</b-button>
    <!-- <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields" v-if="noticeList.length && !mainNotice">
      <template #cell(userId)="data">
        <div v-if="data.item.userId === 'ssafy'">1</div>
      </template>
    </b-table> -->
    <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields" v-if="noticeList.length" :top-row="topRowContent">
      <template #cell(userId)="data">
        <div v-if="data.item.userId === 'ssafy'">2</div>
      </template>
    </b-table>
    <!-- <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields" v-if="(noticeList.length = 0)">
      <template #cell(userId)="data">
        <div v-if="data.item.userId === 'ssafy'">3</div>
      </template>
    </b-table> -->
  </b-container>
</template>

<script>
import http from "@/api/http";
export default {
  name: "NoticeList",
  data() {
    return {
      fields: [
        {
          key: "noticeNo",
          label: "글 번호",
          sortable: true,
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
          sortable: true,
        },
      ],
      noticeList: [],
      mainNotice: null,
    };
  },
  computed: {
    tableData() {
      if (this.mainNotice) {
        return [this.mainNotice, ...this.noticeList];
        // return [...this.noticeList];
      } else {
        return this.noticeList;
      }
    },
    topRowContent() {
      if (this.mainNotice) {
        return [this.mainNotice];
      } else {
        return null;
      }
    },
  },
  created() {
    http.get("/notice/list").then((response) => {
      this.noticeList = response.data;
      this.mainNotice = { ...this.noticeList.find((notice) => notice.mainNotice === "true") };
      if (this.mainNotice != null || this.mainNotice.length > 0 || !this.mainNotice) {
        this.mainNotice._rowVariant = "danger";
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

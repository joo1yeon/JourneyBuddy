<template>
  <b-container id="list">
    <b-alert show><h2>공지사항</h2></b-alert>
    <b-button class="float-left mb-3" variant="success" type="button" :to="{ name: 'noticewrite' }"
      >작성하기</b-button
    >
    <div v-if="!isNotice">
      <b-table hover :items="tableData" @row-clicked="noticeView" :fields="fields">
        <template #cell(userId)="data">
          <div v-if="data.item.userId === 'ssafy'">메인 공지 없음</div>
        </template>
      </b-table>
    </div>
    <div v-else>
      <b-table
        hover
        :items="tableData"
        @row-clicked="noticeView"
        :fields="fields"
        :top-row="topRowContent"
      >
        <template #cell(userId)="data">
          <div v-if="data.item.userId === 'ssafy'">메인 공지 있음</div>
        </template>
      </b-table>
    </div>
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
      isNotice: false,
    };
  },
  computed: {
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
      this.mainNotice = this.noticeList.find((notice) => notice.mainNotice === "true");
      if (this.mainNotice !== undefined) {
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

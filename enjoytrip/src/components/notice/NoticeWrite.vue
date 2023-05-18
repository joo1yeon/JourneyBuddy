<template>
  <b-container fluid="lg" id="write">
    <h2>공지사항 작성하기</h2>
    <b-form @submit="onSubmit" @reset="onReset">
      <b-form-group id="input-group-1" label="제목" label-for="input-1">
        <b-form-input id="input-1" v-model="form.subject" type="text" placeholder="제목을 입력하세요" required></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="내용" label-for="input-2">
        <b-form-textarea id="textarea" v-model="form.content" placeholder="내용을 입력하세요" rows="3" max-rows="6" required></b-form-textarea>
      </b-form-group>

      <!-- 메인 공지 작성 여부 -->
      <b-form-group id="input-group-4">
        <b-form-checkbox v-model="form.mainNotice">메인 공지사항 등록</b-form-checkbox>
      </b-form-group>

      <b-button type="submit" variant="primary">작성</b-button>
      <b-button type="reset" variant="danger">취소</b-button>
      <b-button type="button" @click="goList" variant="info">리스트</b-button>
    </b-form>
  </b-container>
</template>

<script>
import http from "@/api/http";
export default {
  name: "NoticeWrite",
  data() {
    return {
      form: {
        subject: "",
        content: "",
        registerTiem: "",
        hit: 0,
        userId: "ssafy",
        noticeNo: 0,
        mainNotice: false,
      },
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      if (this.form.subject == "" || !this.form.subject) return;
      if (this.form.content == "" || !this.form.content) return;
      http.post("/notice/list", this.form).then(() => {
        this.$router.push({ name: "noticelist" });
      });
    },
    onReset(event) {
      event.preventDefault();
      this.form.subject = "";
      this.form.content = "";
    },
    goList() {
      this.$router.push({ name: "notice" });
    },
  },
};
</script>

<style scoped>
#write {
  margin-top: 100px;
}
</style>

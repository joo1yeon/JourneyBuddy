<template>
  <b-container fluid="lg" id="view">
    <b-alert show class="text-left"
      ><h2>{{ form.noticeNo }}. {{ form.subject }}</h2></b-alert
    >
    <b-form @submit="onSubmit" @reset="onReset">
      <b-form-group id="input-group-1" label="제목" label-for="input-1" label-align="left">
        <b-form-input id="input-1" v-model="form.subject" type="text" placeholder="제목을 입력하세요" required readonly></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="내용" label-for="input-2" label-align="left">
        <b-form-textarea
          id="textarea"
          v-model="form.content"
          placeholder="내용을 입력하세요"
          rows="3"
          max-rows="6"
          required
          readonly
        ></b-form-textarea>
      </b-form-group>
      <b-form-group id="input-group-1" label="조회수" label-for="input-3" label-align="left">
        <b-form-input id="input-3" v-model="form.hit" type="number" required readonly></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-1" label="등록 시간" label-for="input-4" label-align="left">
        <b-form-input id="input-4" v-model="form.registerTime" type="text" required readonly></b-form-input>
      </b-form-group>

      <b-button type="button" variant="success" @click="noticemodify" class="mr-4">수정하기</b-button>
      <b-button type="button" variant="danger" @click="noticedelete" class="mr-4">삭제하기</b-button>
      <b-button type="button" @click="goList" variant="info">리스트</b-button>
    </b-form>
  </b-container>
</template>

<script>
import http from "@/api/http";
export default {
  name: "NoticeView",
  components: {},
  data() {
    return {
      form: {
        subject: "",
        content: "",
        registerTiem: "",
        hit: 0,
        userId: "ssafy",
        noticeNo: 0,
      },
    };
  },
  created() {
    this.form.noticeNo = this.$route.params.noticeno;
    http.get(`/notice/list/${this.form.noticeNo}`).then((response) => {
      this.form = response.data;
    });
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      http.post("/notice/list", this.form).then(() => {
        this.$router.push({ name: "noticelist" });
      });
    },
    onReset(event) {
      event.preventDefault();
      this.form.subject = "";
      this.form.content = "";
    },
    noticedelete() {
      http.delete(`/notice/list/${this.form.noticeNo}`).then(alert(`${this.form.noticeNo}번 글이 삭제되었습니다`));
      this.$router.push({ name: "noticelist" });
    },
    noticemodify() {
      this.$router.push({ name: "noticemodify", params: { noticeno: this.form.noticeNo } });
    },
    goList() {
      this.$router.push({ name: "notice" });
    },
  },
};
</script>

<style scoped>
#view {
  margin-top: 100px;
}
</style>

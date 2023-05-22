<template>
  <b-container fluid="lg" id="modify">
    <b-alert show class="text-left"
      ><h2>{{ form.noticeNo }}. {{ form.subject }} (수정)</h2></b-alert
    >
    <b-form @submit="onSubmit">
      <b-form-group id="input-group-1" label="제목" label-for="input-1" label-align="left">
        <b-form-input id="input-1" v-model="form.subject" type="text" placeholder="제목을 입력하세요" required></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="내용" label-for="input-2" label-align="left">
        <b-form-textarea id="textarea" v-model="form.content" placeholder="내용을 입력하세요" rows="3" max-rows="6" required></b-form-textarea>
      </b-form-group>
      <b-form-group id="input-group-1" label="조회수" label-for="input-3" label-align="left">
        <b-form-input id="input-3" v-model="form.hit" type="number" required readonly></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-1" label="등록 시간" label-for="input-4" label-align="left">
        <b-form-input id="input-4" v-model="form.registerTiem" type="text" required readonly></b-form-input>
      </b-form-group>

      <!-- 메인 공지 작성 여부 -->
      <b-form-checkbox v-model="form.mainNotice" id="input-5" class="text-left">메인 공지사항 등록</b-form-checkbox>

      <!-- 버튼 -->
      <b-button type="submit" variant="primary" class="mr-4">수정완료</b-button>
      <b-button type="button" @click="goList" variant="info">리스트</b-button>
    </b-form>
  </b-container>
</template>

<script>
import http from "@/api/http";
export default {
  name: "NoticeModify",
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
        mainNotice: false,
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
      http.put("/notice/list", this.form).then(this.goList, alert(`${this.form.noticeNo}번 글이 수정되었습니다`));
    },
    goList() {
      this.$router.push({ name: "notice" });
    },
  },
};
</script>

<style scoped>
#modify {
  margin-top: 100px;
}
</style>

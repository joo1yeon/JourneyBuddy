<template>
  <b-container fluid="lg" id="modify">
    <h2>공지사항 수정하기</h2>
    <b-form @submit="onSubmit">
      <b-form-group id="input-group-1" label="제목" label-for="input-1">
        <b-form-input id="input-1" v-model="form.subject" type="text" placeholder="제목을 입력하세요" required></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="내용" label-for="input-2">
        <b-form-textarea id="textarea" v-model="form.content" placeholder="내용을 입력하세요" rows="3" max-rows="6" required></b-form-textarea>
      </b-form-group>
      <b-form-group id="input-group-1" label="조회수" label-for="input-3">
        <b-form-input id="input-3" v-model="form.hit" type="number" required readonly></b-form-input>
      </b-form-group>
      <b-form-group id="input-group-1" label="등록 시간" label-for="input-4">
        <b-form-input id="input-4" v-model="form.registerTime" type="text" required readonly></b-form-input>
      </b-form-group>

      <!-- 메인 공지 작성 여부 -->
      <b-form-group id="input-group-4">
        <b-form-checkbox v-model="form.mainNotice">메인 공지사항 등록</b-form-checkbox>
      </b-form-group>

      <b-button type="submit" variant="primary">수정완료</b-button>
      <b-button type="button" @click="goList" variant="info">리스트</b-button>
    </b-form>
    <!-- <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card> -->
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

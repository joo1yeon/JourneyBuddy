<template>
  <div class="modal-content">
    <div class="modal-header">
      <h4 class="modal-title">
        <i class="bi bi-chat-left-dots-fill text-info"> 회원가입</i>
      </h4>
      <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
    </div>

    <div class="modal-body">
      <b-form id="join-form" method="POST">
        <div class="mb-3">
          <i class="bi bi-database" style="color: rgb(121, 2, 119)"></i>
          <label for="question" class="form-label">아이디 :</label>
          <b-form-input
            type="text"
            class="form-control"
            id="register-id"
            placeholder="아이디..."
            v-model="user.userId"
          />
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <label for="question" class="form-label">비밀번호 :</label>
          <b-form-input
            type="password"
            class="form-control"
            id="register-password"
            placeholder="비밀번호..."
            v-model="user.userPassword"
          />
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <label for="question" class="form-label">비밀번호확인 :</label>
          <b-form-input
            type="password"
            class="form-control"
            id="register-password-confirm"
            placeholder="비밀번호확인..."
            v-model="user.userPasswordConfirm"
          />
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <label for="question" class="form-label">이름 :</label>
          <b-form-input
            type="text"
            class="form-control"
            id="register-name"
            placeholder="이름..."
            v-model="user.userName"
          />
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <label for="birthdate" class="form-label">생년월일</label>
          <b-form-input
            type="date"
            class="form-control"
            id="register-birthdate"
            v-model="user.birthDate"
          />
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <b-form-group label="성별">
            <b-form-radio id="register-gender-male" v-model="user.gender" value="0" /> 남
            <b-form-radio id="register-gender-female" v-model="user.gender" value="1" /> 여
          </b-form-group>
        </div>
        <div class="mb-3">
          <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
          <label for="question" class="form-label">이메일 :</label>
          <div class="input-group mb-3">
            <b-form-input
              type="text"
              class="form-control"
              id="register-email"
              placeholder="이메일아이디"
              v-model="user.emailId"
            />
            <span class="input-group-text">@</span>
            <b-form-select
              id="emali-domain"
              v-model="user.emailDomain"
              :options="options"
              class="form-select"
            />
          </div>
        </div>
      </b-form>
    </div>

    <div class="modal-footer">
      <b-button type="button" id="btn-register" class="btn-sm" variant="primary" @click="join()">
        회원가입
      </b-button>
      <b-button type="button" class="btn-sm" variant="outline-success" @click="reset()"
        >초기화</b-button
      >
      <b-button type="button" class="btn-sm" variant="outline-danger" data-bs-dismiss="modal">
        닫기
      </b-button>
    </div>
  </div>
</template>

<script>
import http from "@/api/http";

export default {
  name: "UserJoin",
  components: {},
  data() {
    return {
      user: {
        userId: "",
        userPassword: "",
        userName: "",
        birthDate: "",
        gender: "",
        emailId: "",
        emailDomain: "0",
        registerDate: "",
      },
      options: [
        { value: 0, text: "선택" },
        { value: "gmail.com", text: "gmail.com" },
        { value: "naver.com", text: "naver.com" },
        { value: "kakao.com", text: "kakao.com" },
        { value: "ssafy.com", text: "ssafy.com" },
      ],
    };
  },
  created() {},
  methods: {
    join() {
      console.log(this.user);
      http.post(`/user`, this.user).then(({ data }) => {
        console.log(data);
        alert("회원가입");
      });
    },
  },
};
</script>

<style scoped></style>

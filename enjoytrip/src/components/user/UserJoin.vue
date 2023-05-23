<template>
  <b-container>
    <div class="my-5 py-5 alignLeft">
      <b-row>
        <div class="col-3"></div>
        <div class="col-6 p-5 box shadow">
          <h3>회원가입</h3>
          <hr />
          <b-form id="join-form" method="POST">
            <div class="mb-3">
              <label for="question" class="form-label">아이디</label>
              <b-form-input
                type="text"
                class="form-control borderRadius"
                id="register-id"
                placeholder="아이디"
                v-model="user.userId"
                :state="idState"
              />
            </div>
            <div class="mb-3">
              <label for="question" class="form-label">비밀번호</label>
              <b-form-input
                type="password"
                class="form-control borderRadius"
                id="register-password"
                placeholder="비밀번호"
                v-model="user.userPassword"
              />
            </div>
            <div class="mb-3">
              <label for="question" class="form-label">비밀번호확인</label>
              <b-form-input
                type="password"
                class="form-control borderRadius"
                id="register-password-confirm"
                placeholder="비밀번호확인"
                v-model="user.userPasswordConfirm"
                :state="pwState"
              />
            </div>
            <div class="mb-3">
              <label for="question" class="form-label">이름</label>
              <b-form-input
                type="text"
                class="form-control borderRadius"
                id="register-name"
                placeholder="이름"
                v-model="user.userName"
              />
            </div>
            <div class="mb-3">
              <label for="birthdate" class="form-label">생년월일</label>
              <b-form-input
                type="date"
                class="form-control borderRadius"
                id="register-birthdate"
                v-model="user.birthDate"
              />
            </div>
            <div class="mb-3 btnWidth">
              <b-form-group label="성별">
                <b-form-radio-group
                  id="register-gender"
                  name="gender"
                  v-model="user.gender"
                  :options="radioOptions"
                  value="0"
                  buttons
                  button-variant="outline-secondary"
                  class="col-12 mx-0 px-0"
                />
              </b-form-group>
            </div>
            <div class="mb-3">
              <label for="question" class="form-label">이메일</label>
              <div class="input-group mb-3">
                <b-form-input
                  type="text"
                  class="form-control borderRadius"
                  id="register-email"
                  placeholder="이메일아이디"
                  v-model="user.emailId"
                />
                <span class="input-group-text">@</span>
                <b-form-select
                  id="emali-domain"
                  v-model="user.emailDomain"
                  :options="selectOptions"
                  class="form-select borderRadius"
                />
              </div>
            </div>
          </b-form>
          <div class="mt-5 alignRight">
            <b-button
              type="button"
              class="mx-1 borderRadius"
              variant="outline-secondary"
              :to="{ name: 'main' }"
            >
              닫기
            </b-button>
            <b-button
              type="button"
              id="btn-register"
              class="mx-1 borderRadius"
              variant="secondary"
              @click="join()"
            >
              회원가입
            </b-button>
          </div>
        </div>
      </b-row>
    </div>
  </b-container>
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
        gender: "0",
        emailId: "",
        emailDomain: "0",
        registerDate: "",
      },
      selectOptions: [
        { value: 0, text: "선택" },
        { value: "gmail.com", text: "gmail.com" },
        { value: "naver.com", text: "naver.com" },
        { value: "kakao.com", text: "kakao.com" },
        { value: "ssafy.com", text: "ssafy.com" },
      ],
      radioOptions: [
        { text: "남", value: 0 },
        { text: "여", value: 1 },
      ],
      idState: null,
      pwState: null,
    };
  },
  created() {},
  methods: {
    join() {
      console.log(this.user);
      http.post(`/user`, this.user).then(({ data }) => {
        console.log(data);
        alert("회원가입이 완료되었습니다.");
        this.$router.push({ name: "main" });
      });
    },
  },
};
</script>

<style scoped>
.box {
  border-radius: 1em;
  border: 1px solid lightgrey;
}
.btnWidth {
  margin: 0 auto;
}
.borderRadius {
  border-radius: 1em;
}
</style>

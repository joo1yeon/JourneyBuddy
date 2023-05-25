<template>
  <div class="rounded-4">
    <div class="p-5 pb-4 border-bottom-0">
      <h1 class="fw-bold mb-0 fs-2">로그인</h1>
    </div>

    <div class="modal-body p-5 pt-0">
      <div id="login-form">
        <div class="form-floating mb-3">
          <input
            type="text"
            class="form-control rounded-3"
            id="floatingInput"
            name="userId"
            placeholder="아이디"
            v-model="user.userId"
            v-on:keyup.enter="confirm()"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating mb-3">
          <input
            type="password"
            class="form-control rounded-3"
            id="floatingPassword"
            name="userPassword"
            placeholder="비밀번호"
            v-model="user.userPassword"
            v-on:keyup.enter="confirm()"
          />
          <label for="floatingPassword">비밀번호</label>
        </div>
        <div class="form-check">
          <label class="form-check-label" for="id-checkbox">
            <input class="form-check-input" type="checkbox" value="save" id="id-checkbox" name="saveid" />
            <small class="text-body-secondary">아이디 저장</small>
          </label>
        </div>
        <b-button type="button" class="w-100 my-2 btn-lg rounded-3" @click="confirm"> 로그인 </b-button>
        <router-link :to="{ name: 'join' }">
          <b-button type="button" class="w-100 my-2 btn-lg rounded-3" variant="outline-secondary" @click="hideModal"> 회원가입 </b-button>
        </router-link>
        <hr class="my-4" />
        <!-- <h2 class="fs-5 fw-bold mb-3">Or use a third-party</h2> -->
        <!-- 네이버 로그인 API -->
        <div id="naver_id_login"></div>
        <b-button class="w-100 py-2 mb-2 rounded-3" variant="outline-secondary" type="submit">
          <svg class="bi me-1" width="16" height="16"><use xlink:href="#facebook" /></svg>
          카카오를 사용하여 로그인하기
        </b-button>
        <b-button class="w-100 py-2 mb-2rounded-3" variant="outline-secondary" type="submit">
          <svg class="bi me-1" width="16" height="16"><use xlink:href="#github" /></svg>
          깃허브를 사용하여 로그인하기
        </b-button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState, mapActions } from "vuex";

const userStore = "userStore";

export default {
  name: "UserLogin",
  components: {},
  data() {
    return {
      user: {
        userId: null,
        userPassword: null,
        naver_id_login: null,
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  created() {},
  //  네이버 로그인을 위한 마운트 설정
  mounted() {
    this.naver_id_login = new window.naver_id_login(process.env.VUE_APP_NAVER_CLIENT_ID, process.env.VUE_APP_NAVER_REDIRECT_URL);
    const state = this.naver_id_login.getUniqState();
    this.naver_id_login.setButton("green", 3); // 버튼 설정
    this.naver_id_login.setState(state);
    // this.naver_id_login.setPopup(); // popup 설정을 위한 코드

    console.log(this.naver_id_login.init_naver_id_login());
    this.naver_id_login.init_naver_id_login();
  },
  methods: {
    naverSignInCallback() {
      alert(this.naver_id_login.getProfileData("email"));
      alert(this.naver_id_login.getProfileData("nickname"));
      alert(this.naver_id_login.getProfileData("age"));
    },
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        // this.$router.push({ name: "main" });
        // $bvModal.hide("login-modal");
        // this.$refs["login-modal"].hide();
        // this.modal.hide();
        this.$emit("hideLoginModal");
      }
    },
    hideModal() {
      this.$emit("hideLoginModal");
    },
  },
};
</script>

<style scoped>
#naver_id_login {
}
</style>

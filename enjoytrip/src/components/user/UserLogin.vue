<template>
  <div class="p-4 py-md-5" role="dialog">
    <div class="" role="document">
      <div class="rounded-4 shadow">
        <div class="p-5 pb-4 border-bottom-0">
          <h1 class="fw-bold mb-0 fs-2">로그인</h1>
          <b-button
            type="button"
            class="btn-close"
            data-bs-dismiss="modal"
            aria-label="Close"
          ></b-button>
        </div>

        <div class="modal-body p-5 pt-0">
          <form action="/userlogin" id="login-form" method="post">
            <div class="form-floating mb-3">
              <input
                type="text"
                class="form-control rounded-3"
                id="floatingInput"
                name="userId"
                placeholder="아이디"
                v-model="user.userId"
                @keyup.enter="confirm"
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
                @keyup.enter="confirm"
              />
              <label for="floatingPassword">비밀번호</label>
            </div>
            <div class="form-check">
              <label class="form-check-label" for="id-checkbox">
                <input
                  class="form-check-input"
                  type="checkbox"
                  value="save"
                  id="id-checkbox"
                  name="saveid"
                />
                <small class="text-body-secondary">아이디 저장</small>
              </label>
            </div>
            <b-button
              type="button"
              class="w-100 my-2 btn-lg rounded-3"
              variant="primary"
              @click="confirm"
            >
              로그인
            </b-button>
            <hr class="my-4" />
            <h2 class="fs-5 fw-bold mb-3">Or use a third-party</h2>
            <b-button class="w-100 py-2 mb-2 rounded-3" variant="outline-secondary" type="submit">
              <svg class="bi me-1" width="16" height="16"><use xlink:href="#twitter" /></svg>
              네이버를 사용하여 로그인하기
            </b-button>
            <b-button class="w-100 py-2 mb-2 rounded-3" variant="outline-primary" type="submit">
              <svg class="bi me-1" width="16" height="16"><use xlink:href="#facebook" /></svg>
              카카오를 사용하여 로그인하기
            </b-button>
            <b-button class="w-100 py-2 mb-2rounded-3" variant="outline-secondary" type="submit">
              <svg class="bi me-1" width="16" height="16"><use xlink:href="#github" /></svg>
              깃허브를 사용하여 로그인하기
            </b-button>
          </form>
        </div>
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
        userId: "",
        userPassword: "",
      },
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  created() {},
  methods: {
    ...mapActions(userStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      // console.log("1. confirm() token >> " + token);
      if (this.isLogin) {
        await this.getUserInfo(token);
        // console.log("4. confirm() userInfo :: ", this.userInfo);
        // this.$router.push({ name: "main" });
      }
    },
  },
};
</script>

<style scoped></style>

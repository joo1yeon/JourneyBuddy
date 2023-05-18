<template>
  <b-navbar
    toggleable="lg"
    type="light"
    variant="light"
    class="bg-body-tertiary shadow fixed-top"
    style="padding: 0 10vw"
  >
    <!-- <a class="navbar-brand link-primary fw-bold fs-3" href="/"> -->
    <!-- </a> -->
    <router-link :to="{ name: 'main' }" class=""
      ><img
        id="header-logo"
        src="@/assets/img/common/logo.png"
        alt=""
        width="100px"
        :to="{ name: 'main' }"
    /></router-link>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav class="ml-auto">
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item href="#" @click="$bvModal.show('login-modal')">로그인</b-nav-item>
        <b-modal id="login-modal" hide-footer>
          <user-login></user-login>
        </b-modal>

        <b-nav-item href="#" @click="$bvModal.show('join-modal')">회원가입</b-nav-item>
        <b-modal id="join-modal" hide-footer>
          <user-join></user-join>
        </b-modal>
        <b-nav-item @click="onClickLogout">로그아웃</b-nav-item>
        <b-nav-item :to="{ name: 'trip' }">여행지</b-nav-item>
        <b-nav-item :to="{ name: 'plan' }">나의여행계획</b-nav-item>
        <b-nav-item-dropdown text="핫플레이스" right>
          <b-dropdown-item href="#">등록하기</b-dropdown-item>
          <b-dropdown-item href="#">게시판</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item :to="{ name: 'notice' }">공지사항</b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
import UserLogin from "@/components/user/UserLogin.vue";
import UserJoin from "../user/UserJoin.vue";
import { mapActions, mapGetters, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "TheNavi",
  components: { UserLogin, UserJoin },
  data() {
    return {};
  },
  created() {},
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  methods: {
    ...mapActions(userStore, ["userLogout"]),
    onClickLogout() {
      console.log(this.userInfo.userId);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userid);
      this.userLogout(this.userInfo.userId);
      sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
      sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
      if (this.$route.path != "/") this.$router.push({ name: "main" });
    },
  },
};
</script>

<style scoped></style>

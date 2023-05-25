<template>
  <b-navbar toggleable="lg" variant="light" class="bg-body-tertiary shadow fixed-top" style="padding: 0 10vw">
    <router-link :to="{ name: 'main' }" class=""
      ><img id="header-logo" src="@/assets/img/common/logo.png" alt="" width="100px" :to="{ name: 'main' }"
    /></router-link>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav class="ml-auto">
      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">
        <b-nav-item :to="{ name: 'trip' }">여행지</b-nav-item>
        <b-nav-item :to="{ name: 'plan' }">나의여행계획</b-nav-item>
        <b-nav-item-dropdown text="핫플레이스" right>
          <b-dropdown-item :to="{ name: 'hotplacewrite' }">등록하기</b-dropdown-item>
          <b-dropdown-item :to="{ name: 'hotplacelist' }">게시판</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item :to="{ name: 'notice' }">공지사항</b-nav-item>
      </b-navbar-nav>
      <!-- 로그인 후-->
      <template v-if="userInfo">
        <b-nav-item v-b-toggle.sidebar-mypage><b-avatar variant="success"></b-avatar> </b-nav-item>
        <b-sidebar id="sidebar-mypage" right shadow="lg" width="20vw" backdrop>
          <h3>마이페이지</h3>
          <user-mypage-edit v-if="editMode" @nowEditMode="mypageEditMode"></user-mypage-edit>
          <user-mypage v-else @nowEditMode="mypageEditMode"></user-mypage>
        </b-sidebar>
      </template>

      <!-- 로그인 전 -->
      <b-nav-item v-else @click="$bvModal.show('login-modal')"><b-avatar></b-avatar></b-nav-item>
      <b-modal id="login-modal" hide-footer ref="login-modal">
        <user-login v-on:hideLoginModal="hideModal"></user-login>
      </b-modal>
    </b-collapse>
  </b-navbar>
</template>

<script>
import UserLogin from "@/components/user/UserLogin.vue";
import UserMypage from "@/components/user/UserMypage.vue";
import UserMypageEdit from "../user/UserMypageEdit.vue";

import { mapState } from "vuex";
const userStore = "userStore";

export default {
  name: "TheNavi",
  components: { UserLogin, UserMypage, UserMypageEdit },
  data() {
    return {
      editMode: false,
    };
  },
  created() {},
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    // mypageEditMode: {
    //   get() {
    //     return this.editMode;
    //   },
    //   set(value) {
    //     this.editMode = value;
    //   },
    // },
  },
  methods: {
    hideModal() {
      this.$refs["login-modal"].hide();
    },
    mypageEditMode(value) {
      return (this.editMode = value);
    },
  },
};
</script>

<style scoped></style>

<template>
  <div class="px-3 py-2">
    <b-img src="https://picsum.photos/500/500/?image=54" fluid rounded="circle"></b-img>

    <table>
      <tr>
        <td>이름</td>
        <td>{{ userInfo.userName }}</td>
      </tr>
      <tr>
        <td>이메일</td>
        <td>{{ userInfo.emailId }}@{{ userInfo.emailDomain }}</td>
      </tr>

      <tr>
        <td>생년월일</td>
        <td>{{ userInfo.birthDate }}</td>
      </tr>
    </table>

    <b-button @click="changeEditMode">정보수정</b-button>
    <b-button @click="onClickLogout" variant="outline-secondary">로그아웃</b-button>
  </div>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "UserMypage",
  components: {},
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
      // console.log(this.userInfo.userId);
      //vuex actions에서 userLogout 실행(Backend에 저장 된 리프레시 토큰 없애기
      //+ satate에 isLogin, userInfo 정보 변경)
      // this.$store.dispatch("userLogout", this.userInfo.userid);
      if (this.userInfo) {
        this.userLogout(this.userInfo.userId);
        sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
        sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
        if (this.$route.path != "/") this.$router.push({ name: "main" });
      }
    },
    changeEditMode() {
      this.$emit("nowEditMode", true);
    },
  },
};
</script>

<style scoped></style>

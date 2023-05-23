<template>
  <div>
    <div class="p-3 py-2 box shadow">
      <b-img src="https://picsum.photos/200/200/?image=54" fluid rounded="circle"></b-img>
      <hr />
      <h5>{{ userInfo.userId }}</h5>
      <small>{{ userInfo.userName }}</small>
    </div>
    <div class="px-3 py-2 box">
      <table class="col-12 my-5">
        <tr>
          <td><b-icon icon="envelope" /> 이메일</td>
          <td>{{ userInfo.emailId }}@{{ userInfo.emailDomain }}</td>
        </tr>

        <tr>
          <td><b-icon icon="emoji-smile" /> 생년월일</td>
          <td>{{ userInfo.birthDate }}</td>
        </tr>
        <tr>
          <td><b-icon icon="calendar" /> 가입 날짜</td>
          <td>{{ userInfo.registerDate }}</td>
        </tr>
      </table>
      <b-button @click="changeEditMode" class="col-12 my-1">정보수정</b-button>
      <b-button @click="onClickLogout" variant="outline-secondary" class="col-12 my-1"
        >로그아웃</b-button
      >
    </div>
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

<style scoped>
.box {
  border-radius: 1em;
  height: 20em;
  padding: 1em;
  margin: 1em;
}
.outline {
  border: lightgrey 1px solid;
}
td {
  padding: 0.5em;
  border-bottom: lightgrey 1px solid;
}
tr > td:nth-child(1) {
  text-align: left;
  width: 7em;
}
tr > td:nth-child(2) {
  text-align: left;
}
.imageSize {
  width: 10em;
  height: 10em;
}
</style>

<template>
  <div>
    <div class="p-3 py-2 box shadow">
      <b-img
        v-if="userProfileImg"
        :src="userProfileImg"
        fluid
        rounded="circle"
        width="200"
        height="200"
      ></b-img>
      <b-avatar v-else size="12rem"></b-avatar>
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
import http from "@/api/http";
import { mapActions, mapGetters, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "UserMypage",
  components: {},
  data() {
    return {
      userFileInfo: {},
      userProfileImg: "",
    };
  },
  created() {
    // 프로필 이미지 정보 가져오기
    http({
      method: "get",
      url: `/user/file/${this.userInfo.userId}`,
    }).then(({ data }) => {
      this.userFileInfo = data;

      // 프로필 이미지 가져오기
      if (
        this.userFileInfo.saveFolder != null &&
        this.userFileInfo.originalFile &&
        this.userFileInfo.saveFile
      ) {
        http({
          method: "get",
          url: `/user/file/${this.userFileInfo.saveFolder}/${this.userFileInfo.originalFile}/${this.userFileInfo.saveFile}`,
          responseType: "blob",
        }).then(({ data }) => {
          console.log(data);
          const newFile = new File([data], this.userInfo.userId);

          // FileReader를 통해 File 객체를 브라우저가 이해할 수 있는 이미지 링크로 변환
          const reader = new FileReader();
          reader.onload = (event) => {
            const previewImage = String(event.target?.result);
            this.userProfileImg = previewImage;
          };
          reader.readAsDataURL(newFile);
        });
      }
    });
  },
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

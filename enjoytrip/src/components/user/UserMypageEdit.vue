<template>
  <div>
    <div class="p-3 py-2 box shadow">
      <b-img
        v-if="previewProfile"
        :src="previewProfile"
        fluid
        rounded="circle"
        class="imageSize"
      ></b-img>
      <b-avatar v-else size="10rem"></b-avatar>
      <!-- 프로필 사진 수정 -->
      <div>
        <input
          @change="previewImg"
          ref="profileImg"
          id="profileimg"
          type="file"
          style="display: none"
        />
        <label for="profileimg"><b-icon icon="camera-fill" class="editProfileBtn" /></label>
      </div>
      <hr />
      <h5>{{ userInfo.userId }}</h5>
      <div class="inputWidth">
        <b-form-input v-model="user.userName" size="sm" />
      </div>
    </div>

    <div class="px-3 box">
      <table class="col-12 my-1">
        <tr>
          <td><b-icon icon="envelope" /> 이메일</td>
          <td>
            <b-form-input v-model="user.emailId" size="sm" class="emailInput"></b-form-input>
            @
            <b-form-input v-model="user.emailDomain" size="sm" class="emailInput"></b-form-input>
          </td>
        </tr>
        <tr>
          <td><b-icon icon="emoji-smile" /> 생년월일</td>
          <td><b-form-input type="date" v-model="user.birthDate" size="sm"></b-form-input></td>
        </tr>
      </table>
      <div class="my-5">
        <b-button @click="modifyUser" class="m-1 col-12">수정완료</b-button>
        <b-button @click="changeEditMode" variant="outline-secondary" class="m-1 col-12"
          >취소</b-button
        >
      </div>
    </div>
  </div>
</template>

<script>
import api from "@/api/http";
import { mapGetters, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "UserMypageEdit",
  components: {},
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  data() {
    return {
      user: {},
      previewProfile: "",
      upfile: null,
    };
  },
  created() {
    this.user = this.userInfo;
  },
  methods: {
    changeEditMode() {
      this.$emit("nowEditMode", false);
    },
    previewImg(e) {
      let imageFile = e.target.files;
      console.log(imageFile[0]);
      let url = URL.createObjectURL(imageFile[0]);
      console.log(url);
      this.previewProfile = url;

      this.upfile = imageFile[0];
    },
    modifyUser() {
      let accessToken = sessionStorage.getItem("access-token");
      let formData = new FormData();

      formData.append("userId", this.user.userId);
      formData.append("userName", this.user.userName);
      formData.append("emailId", this.user.emailId);
      formData.append("emailDomain", this.user.emailDomain);
      formData.append("birthDate", this.user.birthDate);

      formData.append("upfile", this.upfile);
      console.log(this.user.userId);
      api({
        method: "put",
        url: "/user",
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Headers":
            "Origin, X-Requested-With, Content-Type, Cookie, Accept, X-PINGOTHER",
          "Access-Control-Allow-Methods": "GET, POST, PUT, OPTIONS",
          "Access-Control-Allow-Credentials": true,
          "Content-Type": "multipart/form-data",
          Authorization: `Bearer ${accessToken}`,
        },
        data: formData,
      });

      this.$emit("nowEditMode", false);
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
.inputWidth {
  width: 5em;
  margin: 0 auto;
}
.editProfileBtn {
  color: gray;
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
.emailInput {
  width: 6em;
  display: inline;
}
.imageSize {
  width: 10em;
  height: 10em;
}
</style>

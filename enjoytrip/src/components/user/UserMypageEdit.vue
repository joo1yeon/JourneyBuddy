<template>
  <div>
    <div class="px-3 py-2">
      <b-img :src="previewProfile" fluid rounded="circle"></b-img>

      <!-- 프로필 사진 수정 -->
      <input
        @change="previewImg"
        ref="profileImg"
        id="profileimg"
        type="file"
        style="display: none"
      />
      <label for="profileimg">여기 클릭</label>
      <div class="px-3 my-5">
        <table>
          <tr>
            <td>이름</td>
            <td><b-form-input v-model="user.userName"></b-form-input></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <b-form-input v-model="user.emailId"></b-form-input>
              @
              <b-form-input v-model="user.emailDomain"></b-form-input>
            </td>
          </tr>
          <tr>
            <td>생년월일</td>
            <td><b-form-input type="date" v-model="user.birthDate"></b-form-input></td>
          </tr>
        </table>
      </div>

      <b-button @click="modifyUser">정보수정</b-button>
      <b-button @click="changeEditMode" variant="outline-secondary">취소</b-button>
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
    },
  },
};
</script>

<style scoped></style>

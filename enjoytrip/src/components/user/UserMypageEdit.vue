<template>
  <div>
    <div class="px-3 py-2">
      <b-img :src="previewImage" fluid rounded="circle"></b-img>

      <!-- 프로필 사진 수정 -->
      <input @change="upload" ref="profileImg" id="profileimg" type="file" style="display: none" />
      <label for="profileimg">여기 클릭</label>
      <div class="px-3 my-5">
        <table>
          <tr>
            <td>이름</td>
            <td><b-form-input placeholder="Enter your name"></b-form-input></td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <b-form-input placeholder="Enter your name"></b-form-input>
              @
              <b-form-input placeholder="Enter your name"></b-form-input>
            </td>
          </tr>
          <tr>
            <td>생년월일</td>
            <td><b-form-input type="date" placeholder="Enter your name"></b-form-input></td>
          </tr>
        </table>
      </div>

      <b-button>정보수정</b-button>
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
      previewImage: "",
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
    upload(e) {
      let imageFile = e.target.files;
      console.log(imageFile[0]);
      let url = URL.createObjectURL(imageFile[0]);
      console.log(url);
      this.previewImage = url;

      this.upfile = imageFile;

      api.put("/user", this.user, this.upfile);
    },
  },
};
</script>

<style scoped></style>

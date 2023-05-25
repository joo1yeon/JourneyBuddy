<template>
  <div>
    <b-row>
      <div class="col-11">
        <b-media left-align vertical-align="center">
          <template #aside>
            <b-img rounded="circle" blank blank-color="#ccc" width="50" alt="placeholder"></b-img>
          </template>
          <div>
            <h5 class="mt-0 mb-1">{{ comment.writer }}</h5>

            <small>{{ comment.registerDate }}</small>
          </div>
        </b-media>
        <p class="my-3 mx-2">
          {{ comment.contents }}
        </p>
      </div>
      <div class="col-1" v-if="userInfo != null && userInfo.userId === comment.writer">
        <b-icon icon="trash" @click="deleteComment"></b-icon>
      </div>
      <div class="col-1" v-else></div>
    </b-row>
    <hr />
  </div>
</template>

<script>
import http from "@/api/http";
import { mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "HotplaceCommentItem",
  props: {
    comment: Object,
  },
  computed: {
    ...mapState(userStore, ["isLogin", "userInfo"]),
  },
  methods: {
    deleteComment() {
      http
        .delete(`/hotplace/comment/delete`, {
          params: {
            hotplaceCommentId: this.comment.hotplaceCommentId,
          },
        })
        .then(() => {
          this.$emit("reloadComments");
        });
    },
  },
};
</script>

<style scoped></style>

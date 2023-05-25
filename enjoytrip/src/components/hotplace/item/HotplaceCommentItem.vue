<template>
  <div>
    <b-media left-align vertical-align="center">
      <template #aside>
        <b-img rounded="circle" blank blank-color="#ccc" width="50" alt="placeholder"></b-img>
      </template>
      <div>
        <h5 class="mt-0 mb-1">{{ comment.writer }}</h5>
        <small>{{ comment.registerDate }}</small>
      </div>
    </b-media>
    <p class="my-3">{{ comment.contents }}</p>
    <hr />
  </div>
</template>

<script>
export default {
  name: "HotplaceCommentItem",
  props: {
    comment: Object,
  },
};
</script>

<style scoped></style>

<template>
  <div>
    <b-media left-align vertical-align="center">
      <template #aside>
        <b-img rounded="circle" blank blank-color="#ccc" width="50" alt="placeholder"></b-img>
      </template>
      <div>
        <h5 class="mt-0 mb-1">김싸피</h5>
        <small>2023.05.23</small>
      </div>
    </b-media>
    <p class="my-3">다음 여행은 여기다.</p>
    <hr />
  </div>
</template>

<script>
export default {
  name: "HotplaceCommentItem",
};
</script>

<style scoped></style>

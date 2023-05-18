<template>
  <div>
    <nav class="navbar navbar-expand bg-body-tertiary">
      <div class="container">
        <router-link :to="{ name: 'main' }" class="navbar-brand link-primary fw-bold fs-3">
          <img id="footer-logo" src="@/assets/img/common/ssafy-logo.png" alt=""
        /></router-link>
        <ul class="navbar-nav ms-auto mb-2">
          <li class="nav-item">
            <a class="nav-link active link-secondary" aria-current="page" href="#">개인정보처리방침</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active link-secondary" aria-current="page" href="#">이용약관</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active link-secondary" aria-current="page" href="#">오시는길</a>
          </li>
          <li class="nav-item">
            <a class="nav-link active link-secondary" aria-current="page" href="#">&COPY; SSAFY Corp.</a>
          </li>
        </ul>
      </div>
    </nav>
  </div>
</template>

<script>
export default {
  name: "TheFooter",
  components: {},
  data() {
    return {
      message: "",
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped></style>

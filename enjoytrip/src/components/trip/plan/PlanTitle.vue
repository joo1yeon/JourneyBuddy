<template>
  <b-form>
    <b-form-group label="여행 주제 : " lebel-for="plan-title">
      <b-input type="text" id="plan-title" required></b-input>
    </b-form-group>
  </b-form>
</template>

<script>
export default {
  name: "PlanTitle",
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

<template>
  <div></div>
</template>

<script>
import http from "@/api/http";
export default {
  name: "MyPlanDetail",
  components: {},
  data() {
    return {
      fields: [
        {
          key: "tripPlanDetailId",
          label: "계획 번호",
          sortable: true,
        },
        {
          key: "title",
          label: "여행 주제",
        },
        {
          key: "registerTime",
          label: "등록 일",
          sortable: true,
        },
      ],
      detailList: [],
    };
  },
  created() {
    http.get(`/plan/detail/ssafy/${this.$route.params.tripPlanId}`).then((response) => {
      this.detailList = response.data;
      console.log(this.detailList);
    });
  },
  methods: {},
};
</script>

<style scoped></style>

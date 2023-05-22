<template>
  <b-container id="list">
    <b-alert variant="danger" show><h2>나의 여행 계획</h2></b-alert>
    <div v-if="planList">
      <b-table hover :items="planList" @row-clicked="planView" :fields="fields"></b-table>
    </div>
    <div v-else>
      <h2>나의 여행 계획이 존재하지 않습니다</h2>
    </div>
  </b-container>
</template>

<script>
// import http from "@/api/http";
export default {
  name: "MyPlanList",
  components: {},
  data() {
    return {
      fields: [
        {
          key: "planNum",
          label: "계획 번호",
          sortable: true,
        },
        {
          key: "contentId",
          label: "장소 명",
        },
        {
          key: "time",
          label: "시간",
          sortable: true,
        },
      ],
      planList: [],
    };
  },
  created() {
    this.planList = null;
    // http.get("/plan/list/ssafy").then((response) => {
    //   this.planList = response.data;
    // });
  },
  methods: {},
};
</script>

<style scoped>
#list {
  margin-top: 100px;
}
</style>

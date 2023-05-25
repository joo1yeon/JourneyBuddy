<template>
  <b-container id="list">
    <b-alert variant="danger" show><h2>나의 여행 계획</h2></b-alert>
    <div v-if="planList.length">
      <b-table hover :items="planList" @row-clicked="planView" :fields="fields">
        <template #cell(tripPlanId)="row">{{ row.index + 1 }}</template>
      </b-table>
    </div>
    <div v-else>
      <h2>나의 여행 계획이 존재하지 않습니다</h2>
    </div>
  </b-container>
</template>

<script>
import { mapState } from "vuex";
const userStore = "userStore";

import http from "@/api/http";
export default {
  name: "MyPlanList",
  components: {},
  data() {
    return {
      fields: [
        {
          key: "tripPlanId",
          label: "계획 번호",
          sortable: true,
        },
        {
          key: "planTitle",
          label: "여행 주제",
        },
        {
          key: "registerTime",
          label: "등록일",
          sortable: true,
        },
      ],
      planList: [],
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin", "isLoginError", "userInfo"]),
  },
  created() {
    http.get(`/plan/list/${this.userInfo.userId}`).then((response) => {
      this.planList = response.data;
    });
  },
  methods: {
    planView(items) {
      this.$router.push({ name: "plandetail", params: { tripPlanId: items.tripPlanId } });
    },
  },
};
</script>

<style scoped>
#list {
  margin-top: 100px;
}
</style>

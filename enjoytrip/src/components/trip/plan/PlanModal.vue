<template>
  <b-form>
    <b-row>
      <!-- 기존 장소 정보 start -->
      <b-col col>
        <b-form-group label="장소명">
          <b-input readonly v-model="info.title" v-if="info"></b-input>
        </b-form-group>
        <b-form-group label="주소">
          <b-input readonly v-model="info.addr1" v-if="info"></b-input>
        </b-form-group>
      </b-col>
      <!-- 기존 장소 정보 end-->
      <!-- 여행 계획 등록 start -->
      <b-col>
        <b-form-group label="여행지 사진">
          <b-img thumbnail fluid :src="info.image1" :alt="info.title" v-if="info"></b-img>
        </b-form-group>
      </b-col>
      <!-- 여행 계획 등록 end -->
    </b-row>
    <b-form-group label="여행지 정보">
      <b-form-textarea readonly rows="5" v-model="info.overview" v-if="info"></b-form-textarea>
    </b-form-group>
    <b-row>
      <b-col col>
        <!-- 날짜 입력 -->
        <b-input-group class="mb-4">
          <b-input-group-prepend is-text><b-icon icon="calendar-date"></b-icon></b-input-group-prepend>
          <b-form-input type="date" id="date" v-model="info.time"></b-form-input>
        </b-input-group>
        <!-- 메모 입력 -->
        <b-input-group>
          <b-input-group-prepend is-text><b-icon icon="check2-square"></b-icon></b-input-group-prepend>
          <b-form-input type="text" id="text" v-model="info.info" placeholder="메모를 입력하세요"></b-form-input>
        </b-input-group>
      </b-col>
    </b-row>
  </b-form>
</template>

<script>
export default {
  name: "ScheduleModal",
  components: {},
  props: {
    attraction: Object,
    show: Boolean,
    infoItem: Array,
  },
  data() {
    return {
      infos: {
        title: "",
      },
      planDetail: {
        contentId: 0,
        time: "",
        info: "",
      },
    };
  },
  computed: {
    info() {
      if (this.attraction) {
        return this.attraction;
      } else {
        return null;
      }
    },
  },
  created() {
    if (this.infoItem) {
      this.planDetail = this.infoItem;
    }
  },
  methods: {
    registerPlanDetail() {
      this.planDetail.contentId = this.attraction.contentId;
      this.$emit("plan-detail", this.planDetail);
    },
  },
};
</script>

<style scoped></style>

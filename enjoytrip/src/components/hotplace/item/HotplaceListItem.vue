<template>
  <div class="col-6 my-3">
    <router-link
      :to="{ name: 'hotplacedetail', params: { hotplaceId: hotplace.hotplaceId } }"
      class="textStyle"
    >
      <b-card no-body class="overflow-hidden shadow borderRadius" style="max-width: 32em">
        <b-row no-gutters>
          <b-col md="6">
            <b-card-img
              src="https://picsum.photos/400/400/?image=20"
              alt="Image"
              class="rounded-0"
            ></b-card-img>
          </b-col>
          <b-col md="6">
            <b-card-body>
              <h4>{{ hotplace.hotplaceTitle }}</h4>
              <b-card-text>
                <div class="box">
                  <table class="alignLeft">
                    <tr>
                      <td><b-icon icon="geo-alt-fill" /></td>
                      <td>{{ hotplace.placeName }}</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="calendar" /></td>
                      <td>{{ hotplace.visitDate }}</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="building" /></td>
                      <td>{{ getPlaceType() }}</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="person" /></td>
                      <td>{{ hotplace.writer }}</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="star-fill" /></td>
                      <td>
                        <b-form-rating
                          v-model="score"
                          show-value
                          readonly
                          variant="warning"
                          class="borderNone"
                        ></b-form-rating>
                      </td>
                    </tr>
                  </table>
                </div>
              </b-card-text>
            </b-card-body>
          </b-col>
        </b-row>
      </b-card>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "HotplaceListItem",
  components: {},
  data() {
    return {
      score: this.hotplace.score,
      placeType: this.hotplace.placeType,
    };
  },
  props: {
    hotplace: Object,
  },
  created() {},
  methods: {
    getPlaceType() {
      if (this.placeType === "12") {
        return "관광지";
      } else if (this.placeType === "14") {
        return "문화시설";
      } else if (this.placeType === "15") {
        return "축제 | 공연 | 행사";
      } else if (this.placeType === "25") {
        return "여행코스";
      } else if (this.placeType === "28") {
        return "레포츠";
      } else if (this.placeType === "32") {
        return "숙박";
      } else if (this.placeType === "38") {
        return "쇼핑";
      } else if (this.placeType === "39") {
        return "음식점";
      }
    },
  },
};
</script>

<style scoped>
.borderNone {
  border: none;
}
td {
  padding: 0.2em;
  font-size: 0.95em;
}
.textStyle {
  text-decoration: none;
  color: dimgray;
}
.borderRadius {
  border-radius: 1em;
}
</style>

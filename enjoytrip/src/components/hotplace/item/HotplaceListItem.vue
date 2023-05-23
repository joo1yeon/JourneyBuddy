<template>
  <div class="col-6 my-3">
    <router-link :to="{ name: 'hotplacedetail' }" class="textStyle">
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
            <b-card-body title="해운대">
              <b-card-text>
                <div class="box">
                  <table class="alignLeft">
                    <tr>
                      <td><b-icon icon="calendar" /></td>
                      <td>2023.05.23</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="building" /></td>
                      <td>관광지</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="person" /></td>
                      <td>김싸피</td>
                    </tr>
                    <tr>
                      <td><b-icon icon="star-fill" /></td>
                      <td>
                        <b-form-rating
                          v-model="ratingValue"
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
      ratingValue: 5,
    };
  },
  created() {},
  methods: {},
};
</script>

<style scoped>
.borderNone {
  border: none;
}
td {
  padding: 0.2em;
  font-size: 1em;
}
.textStyle {
  text-decoration: none;
  color: dimgray;
}
.borderRadius {
  border-radius: 1em;
}
</style>

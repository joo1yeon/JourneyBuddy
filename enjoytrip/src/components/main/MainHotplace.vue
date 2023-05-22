<template>
  <div>
    <h3>핫플레이스</h3>
    <div>
      <b-card
        title="1위"
        img-src="https://picsum.photos/600/300/?image=25"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the bulk of the card's
          content.
        </b-card-text>

        <router-link :to="{ name: 'hotplacedetail' }">
          <b-button>Go somewhere</b-button>
        </router-link>
      </b-card>
    </div>
    <div>
      <b-card
        title="2위"
        img-src="https://picsum.photos/600/300/?image=25"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the bulk of the card's
          content.
        </b-card-text>

        <b-button>Go somewhere</b-button>
      </b-card>
    </div>
    <div>
      <b-card
        title="3위"
        img-src="https://picsum.photos/600/300/?image=25"
        img-alt="Image"
        img-top
        tag="article"
        style="max-width: 20rem"
        class="mb-2"
      >
        <b-card-text>
          Some quick example text to build on the card title and make up the bulk of the card's
          content.
        </b-card-text>

        <b-button>Go somewhere</b-button>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "MainHotplace",
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

<style scoped>
div {
  display: inline-block;
}
</style>

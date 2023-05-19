<template>
  <div
    class="modal fade"
    id="hotPlaceModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
  >
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">
            <i class="bi"> 핫플레이스 추가</i>
          </h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <form action="">
            <div class="mb-3">
              <i class="bi" style="color: rgb(121, 2, 119)"></i>
              <label for="question" class="form-label">핫 플레이스:</label>
              <input type="text" class="form-control" id="question" placeholder="핫 플레이스 입력..." name="question" />
            </div>
            <div class="mb-3">
              <i class="bi" style="color: rgb(14, 2, 121)"></i>
              <label for="question" class="form-label">리뷰:</label>
              <button type="button" id="btn-answer-add" class="btn btn-outline-primary btn-sm"><i class="bi bi-plus-square-fill"></i> 추가</button>
            </div>
            <div id="hotPlace-answer-list" class="row mb-3">
              <div class="row mb-1 hotPlace-answer-list-item">
                <div class="col-md-10">
                  <input type="text" class="form-control" name="answer" />
                </div>
              </div>
            </div>
          </form>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" id="btn-hotPlace-create" class="btn btn-primary btn-sm">리뷰작성</button>
          <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HotPlace",
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

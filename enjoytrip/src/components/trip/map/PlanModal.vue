<template>
  <!-- 여행 경로 추가 modal start -->
  <div
    class="modal fade"
    id="tripModal"
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
            <i class="bi text-info"> 여행 경로 추가</i>
          </h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>

        <!-- Modal body -->
        <div class="modal-body">
          <form action="">
            <div class="row mb-3 mt-3">
              <div class="col-md-6">
                <i class="bi bi-calendar2-date text-primary"></i>
                <label for="start-date" class="form-label">시작일:</label>
                <input type="date" class="form-control" id="start-date" name="start-date" />
              </div>
              <div class="col-md-6">
                <i class="bi bi-calendar2-date text-danger"></i>
                <label for="end-date" class="form-label">종료일:</label>
                <input type="date" class="form-control" id="end-date" name="end-date" />
              </div>
            </div>
            <div class="mb-3">
              <i class="bi" style="color: rgb(121, 2, 119)"></i>
              <label for="question" class="form-label">여행제목:</label>
              <input type="text" class="form-control" id="question" placeholder="여행제목 입력..." name="question" />
            </div>
            <div class="mb-3">
              <i class="bi" style="color: rgb(14, 2, 121)"></i>
              <label for="question" class="form-label">세부일정:</label>
              <button type="button" id="btn-answer-add" class="btn btn-outline-primary btn-sm"><i class="bi bi-plus-square-fill"></i> 추가</button>
            </div>
            <div id="trip-answer-list" class="row mb-3">
              <div class="row mb-1 trip-answer-list-item">
                <div class="col-md-10">
                  <input type="text" class="form-control" name="answer" />
                </div>
              </div>
            </div>
          </form>
        </div>

        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" id="btn-poll-create" class="btn btn-primary btn-sm">여행생성</button>
          <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "ScheduleModal",
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

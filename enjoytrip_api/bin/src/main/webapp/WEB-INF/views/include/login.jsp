<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div 
	class="modal fade modal-sheet p-4 py-md-5"
	id="loginModal"
	role="dialog"
>
  <div class="modal-dialog" role="document">
    <div class="modal-content rounded-4 shadow">
      <div class="modal-header p-5 pb-4 border-bottom-0">
        <h1 class="fw-bold mb-0 fs-2">로그인</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>

      <div class="modal-body p-5 pt-0">
        <form action="/userlogin" id="login-form" method="post">
          <div class="form-floating mb-3">
            <input type="email" class="form-control rounded-3" id="floatingInput" name="userId" placeholder="아이디">
            <label for="floatingInput">아이디</label>
          </div>
          <div class="form-floating mb-3">
            <input type="password" class="form-control rounded-3" id="floatingPassword" name="userPassword" placeholder="비밀번호">
            <label for="floatingPassword">비밀번호</label>
          </div>
          <div class="form-check">
              <label class="form-check-label" for="id-checkbox">
                  <input
                      class="form-check-input"
                      type="checkbox"
                      value="save"
                      id="id-checkbox"
                      name="saveid"
                      ${idck}
                  />
          <small class="text-body-secondary">아이디 저장</small>
              </label>
          </div>          
          <button class="w-100 my-2 btn btn-lg rounded-3 btn-primary" type="button" onclick="login()">로그인</button>
          <hr class="my-4">
          <h2 class="fs-5 fw-bold mb-3">Or use a third-party</h2>
          <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
            <svg class="bi me-1" width="16" height="16"><use xlink:href="#twitter"/></svg>
            네이버를 사용하여 로그인하기
          </button>
          <button class="w-100 py-2 mb-2 btn btn-outline-primary rounded-3" type="submit">
            <svg class="bi me-1" width="16" height="16"><use xlink:href="#facebook"/></svg>
            카카오를 사용하여 로그인하기
          </button>
          <button class="w-100 py-2 mb-2 btn btn-outline-secondary rounded-3" type="submit">
            <svg class="bi me-1" width="16" height="16"><use xlink:href="#github"/></svg>
            깃허브를 사용하여 로그인하기
          </button>
        </form>
      </div>
    </div>
  </div>
</div>
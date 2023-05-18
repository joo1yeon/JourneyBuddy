<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg bg-body-tertiary shadow fixed-top">
    <div class="container">
        <a class="navbar-brand link-primary fw-bold fs-3" href="/">
            <img id="header-logo" src="/assets/img/common/logo.png" alt="" width="100px" />
        </a>
        <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
        >
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse fw-bold" id="navbarSupportedContent">
            <!-- 로그인 전 -->
            <c:if test="${not empty loginUser}">
                <ul class="navbar-nav mb-2 mb-lg-0 ms-auto logged-out">
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            aria-current="page"
                            href="#"
                            data-bs-toggle="modal"
                            data-bs-target="#registerModal"
                            >회원가입</a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            aria-current="page"
                            href="#"
                            data-bs-toggle="modal"
                            data-bs-target="#loginModal"
                            >로그인</a
                        >
                    </li>
                </ul>
            </c:if>
            <!-- 로그인 후 -->
            <c:if test="${ empty loginUser}">
                <ul class="navbar-nav mb-2 mb-lg-0 ms-auto logged-in">
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            aria-current="page"
                            href="/search"
                            >지역별여행지</a
                        >
                    </li>
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            aria-current="page"
                            href="/schedule"
                            >나의여행계획</a
                        >
                    </li>
		            <li class="nav-item dropdown">
		              <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                핫플레이스
		              </a>
		              <ul class="dropdown-menu">
		                <li><a class="dropdown-item" href="/hotplace">핫플 등록하기</a></li>
		                <li><a class="dropdown-item" href="/trip/action=tripinfo&order=none&keyword=">핫플 게시판</a></li>
		                <li>
		                  <hr class="dropdown-divider">
		                </li>
		                <li><a class="dropdown-item" href="#">Something else here</a></li>
		              </ul>
		            </li>                                       
                    <li class="nav-item">
                        <a
                            class="nav-link"
                            aria-current="page"
                            href="/notice"
                            >공지사항</a
                        >
                    </li>
                    <li data-bs-toggle="offcanvas" data-bs-target="#offcanvasWithBothOptions" aria-controls="offcanvasWithBothOptions>
                    	<a
                    		class="nav-item nav-link"
                    		aria-current="page"
                    		href="/user/${loginUser.userId}"
                    		>
								<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
								  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
								  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
								</svg>                    			
                    	</a>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</nav>

<div class="offcanvas offcanvas-end" data-bs-scroll="true" tabindex="-1" id="offcanvasWithBothOptions" aria-labelledby="offcanvasWithBothOptionsLabel">
  <div class="offcanvas-header">
    <h5 class="offcanvas-title" id="offcanvasWithBothOptionsLabel">마이페이지</h5>
    <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
  </div>
  <div class="offcanvas-body">
    <section id="board-share-list" class="pt-3">
       <div class="container" data-aos="fade-up">
	
		    <div class="row justify-content-center">
		      <div class="card mb-3" style="max-width: 50em; height: 32em">
		        <div class="row g-0">
		          <div class="col-md-12">
		            <img style="width: 10em;" src="/assets/img/common/profile.png" class="img-fluid rounded-start" alt="..." />
		          </div>
		          <div class="col-md-12 py-3">
		            <div class="card-body">
		              <h5 class="card-title">회원 정보</h5>
		            </div>
		            <ul class="list-group list-group-flush">
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">이름</small><br /></div>
		              	${loginUser.userName}
		              </li>
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">아이디</small><br /></div>
		                ${loginUser.userId}
		              </li>
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">이메일</small><br /></div>
		                ${loginUser.emailId}@${loginUser.emailDomain}
		              </li>
		              <li class="list-group-item"></li>
		            </ul>
		            <div class="card-body" style="text-align: end">
		              <a href="/user" class="btn btn-outline-danger">회원 탈퇴</a>
		              <a href="/user?action=mvmodify" class="btn btn-primary">정보 수정</a>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>
		<a
	          class="nav-link"
	          aria-current="page"
	          href="/logout"
	          onclick="logout()"
	          >로그아웃</a
	      >
  </div>
</div>
<!-- 상단 header nav end -->

<!-- 상단 header 고정을 위한 공백 start -->
<div style="height: 90px"></div>
<!-- 상단 header 고정을 위한 공백 end -->

<!-- 로그인 modal start -->
<%@ include file="../include/login.jsp" %>
<!-- div
    class="modal fade"
    id="loginModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
>
    <c:if test="${cookie.cookie_id.value ne null}">
        <c:set var="idck" value=" checked" />
        <c:set var="saveid" value="${cookie.cookie_id.value}" />
    </c:if>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">
                    <i class="bi bi-door-open text-info"> 로그인</i>
                </h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <form action="/login" id="login-form" method="post">
                    <div class="mb-3">
                        <i class="bi bi-database" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">아이디</label>
                        <input
                            type="text"
                            class="form-control"
                            id="login-id"
                            placeholder="아이디"
                            name="userId"
                            value="${saveid}"
                        />
                    </div>
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">비밀번호</label>
                        <input
                            type="password"
                            class="form-control"
                            id="login-password"
                            placeholder="비밀번호"
                            name="userPassword"
                        />
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
                            아이디 저장
                        </label>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button
                    type="button"
                    id="btn-login"
                    class="btn btn-outline-primary btn-sm"
                    onclick="login()"
                >
                    로그인
                </button>
                <button
                    type="button"
                    id="btn-find-id"
                    class="btn btn-outline-success btn-sm"
                    onclick="findId()"
                >
                    아이디 찾기
                </button>
                <button
                    type="button"
                    id="btn-find-password"
                    class="btn btn-outline-danger btn-sm"
                    onclick="findPassword()"
                >
                    비밀번호 찾기
                </button>
            </div>
        </div>
    </div>
</div -->
<!-- 로그인 modal end -->

<!-- 회원가입 modal start -->
<div
    class="modal fade"
    id="registerModal"
    data-bs-backdrop="static"
    data-bs-keyboard="false"
    tabindex="-1"
    aria-labelledby="staticBackdropLabel"
    aria-hidden="true"
>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">
                    <i class="bi bi-chat-left-dots-fill text-info"> 회원가입</i>
                </h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <form id="join-form" action="" method="POST">
                    <input type="hidden" name="action" value="join" />
                    <div class="mb-3">
                        <i class="bi bi-database" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">아이디 :</label>
                        <input
                            type="text"
                            class="form-control"
                            id="register-id"
                            placeholder="아이디..."
                            name="id"
                        />
                    </div>
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">비밀번호 :</label>
                        <input
                            type="password"
                            class="form-control"
                            id="register-password"
                            placeholder="비밀번호..."
                            name="password"
                        />
                    </div>                    
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">비밀번호확인 :</label>
                        <input
                            type="password"
                            class="form-control"
                            id="register-password-confirm"
                            placeholder="비밀번호확인..."
                            name="password-confirm"
                        />                       
                    </div>
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">이름 :</label>
                        <input
                            type="text"
                            class="form-control"
                            id="register-name"
                            placeholder="이름..."
                            name="name"
                        />
                    </div>
					<div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="birthdate" class="form-label">생년월일</label>
                        <input
                            type="date"
                            class="form-control"
                            id="register-birthdate"
                            name="birthdate"
                        />
                    </div>
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="gender" class="form-label">성별</label>
                        <input
                            type="radio"
                            class=""
                            id="register-gender-male"
                            name="gender"
                            value="0"
                        /> 남
                        <input
                            type="radio"
                            class=""
                            id="register-gender-female"
                            name="gender"
                            value="1"
                        /> 여
                    </div>                                                               
                    <div class="mb-3">
                        <i class="bi bi-database-lock" style="color: rgb(121, 2, 119)"></i>
                        <label for="question" class="form-label">이메일 :</label>
                        <div class="input-group mb-3">
                            <input
                                type="text"
                                class="form-control"
                                id="register-email"
                                placeholder="이메일아이디"
                                name="emailid"
                            />
                            <span class="input-group-text">@</span>
                            <select id="emali-domain" name="emaildomain" class="form-select">
                                <option value="0" selected="">선택</option>
                                <option value="gmail.com">gmail.com</option>
                                <option value="naver.com">naver.com</option>
                                <option value="kakao.com">kakao.com</option>
                                <option value="ssafy.com">ssafy.com</option>
                            </select>
                        </div>
                    </div>
                </form>
            </div>

            <div class="modal-footer">
                <button
                    type="button"
                    id="btn-register"
                    class="btn btn-outline-primary btn-sm"
                    onclick="register()"
                >
                    회원가입
                </button>
                <button type="button" class="btn btn-outline-success btn-sm" onclick="reset()">
                    초기화
                </button>
                <button type="button" class="btn btn-outline-danger btn-sm" data-bs-dismiss="modal">
                    닫기
                </button>
            </div>
        </div>
    </div>
</div>
<!-- 회원가입 modal end -->

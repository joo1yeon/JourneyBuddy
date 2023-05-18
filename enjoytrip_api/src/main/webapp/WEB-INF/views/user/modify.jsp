<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="/include/header.jsp" %>
    </head>
    <body>
        <%@ include file="/include/nav.jsp" %>
        <div class="row my-5 py-5 justify-content-center">
            <div class="card mb-3 my-5" style="max-width: 50em; height: 32em">
                <div class="row g-0">
                    <div class="col-md-4">
                        <img
                            src="./assets/img/common/profile.png"
                            class="img-fluid rounded-start"
                            alt="..."
                        />
                    </div>
                    <div class="col-md-8 py-3">
                        <div class="card-body">
                            <h5 class="card-title">자기소개</h5>
                            <p class="card-text">안녕하세요~ :)</p>
                            <p class="card-text">
                                <small class="text-muted">Last updated 3 mins ago</small>
                            </p>
                        </div>
                        <form method="POST" id="modify-form">
                        <input type="hidden" name="action" value="modify-user"/>
                        <ul class="list-group list-group-flush">
                            <li class="list-group-item">
                                <div class="my-2"><small class="text-muted">이름</small><br /></div>
                                <input type="text" name="name" value="${loginInfo.userName}"/>
                            </li>
                            <li class="list-group-item">
                                <div class="my-2">
                                    <small class="text-muted">아이디</small><br />
                                </div>
                                <input type="text" name="id" value="${loginInfo.userId}" readonly />
                            </li>
                            <li class="list-group-item">
                                <div class="my-2">
                                    <small class="text-muted">이메일</small><br />
                                </div>
                                <input type="email" name="emailid" value="${loginInfo.emailId}"/>
                                @
                                <select id="emali-domain" name="emaildomain" class="form-select" style="width: 13em; display: inline-block">
	                                <option value="0" selected="">선택</option>
	                                <option value="gmail.com">gmail.com</option>
	                                <option value="naver.com">naver.com</option>
	                                <option value="kakao.com">kakao.com</option>
	                                <option value="ssafy.com">ssafy.com</option>
                            	</select>
                            </li>

                            <li class="list-group-item"></li>
                        </ul>
                        <div class="card-body" style="text-align: end">
                            <button class="btn btn-primary" id="btn-modify">완료</button>
                        </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script>
        	document.querySelector("#btn-modify").addEventListener("click", function () {
                let modifyForm = document.querySelector("#modify-form");
                modifyForm.setAttribute("action", "${root}/user?action=modify");
                modifyForm.submit();
            });
        </script>
    </body>
</html>

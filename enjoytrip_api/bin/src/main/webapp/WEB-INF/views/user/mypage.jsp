<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/include/header.jsp" %>
	<style>
      a {
        text-decoration: none;
      }
    </style>
    <link href="${root}/assets/styles/main.css" rel="stylesheet" />
</head>
<body>
	<%@ include file="/include/nav.jsp" %>
	
    <section id="board-share-list" class="pt-3">
       <div class="container" data-aos="fade-up">
           <div class="section-header text-center">
               <h2>마이페이지</h2>
               <div class="contour"></div>
           </div>
	
		    <div class="row justify-content-center">
		      <div class="card mb-3 my-5" style="max-width: 50em; height: 32em">
		        <div class="row g-0">
		          <div class="col-md-4">
		            <img src="${root}/assets/img/common/profile.png" class="img-fluid rounded-start" alt="..." />
		          </div>
		          <div class="col-md-8 py-3">
		            <div class="card-body">
		              <h5 class="card-title">회원 정보</h5>
		            </div>
		            <ul class="list-group list-group-flush">
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">이름</small><br /></div>
		              	${loginInfo.userName}
		              </li>
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">아이디</small><br /></div>
		                ${loginInfo.userId}
		              </li>
		              <li class="list-group-item">
		                <div class="my-2"><small class="text-muted">이메일</small><br /></div>
		                ${loginInfo.emailId}@${loginInfo.emailDomain}
		              </li>
		              <li class="list-group-item"></li>
		            </ul>
		            <div class="card-body" style="text-align: end">
		              <a href="${root}/user?action=delete" class="btn btn-outline-danger">회원 탈퇴</a>
		              <a href="${root}/user?action=mvmodify" class="btn btn-primary">정보 수정</a>
		            </div>
		          </div>
		        </div>
		      </div>
		    </div>
		  </div>
		</section>


</body>
</html>
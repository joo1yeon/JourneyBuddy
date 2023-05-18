<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../include/header.jsp" %>
        <link href="/assets/styles/main.css" rel="stylesheet" />
    </head>
    <body>
        <%@ include file="../include/nav.jsp" %>

        <!-- 중앙 content start-->
        <section id="board-make" class="pt-3">
            <div class="container" data-aos="fade-up">
                <div class="section-header text-center">
                    <h2>여행계획!!</h2>
                    <div class="contour"></div>
                </div>

                <!-- kakao map start -->
                <div id="schedule-map" style="width: 100%; height: 550px" class="mb-3"></div>
                <script
                    type="text/javascript"
                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e6f6d1ba0faa1e1b28897b8ec0e6ae8c&libraries=services,clusterer,drawing"
                ></script>
                <script type="text/javascript" src="/assets/js/schedule.js"></script>
                <!-- kakao map end -->

                <div class="row">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>대표이미지</th>
                                <th>관광지명</th>
                                <th>주소</th>
                                <th>위도</th>
                                <th>경도</th>
                                <th>삭제하기</th>
                            </tr>
                        </thead>
                        <tbody id="schedule-list">
                        	<c:forEach var="attraction" items="${schedulePath}">
	                            <tr class="attraction" onclick="moveCenter(${attraction.latitude}, ${attraction.longitude});">
					                <td><img src="${attraction.image1}" width="100px"></td>
					                <td class="title">${attraction.title}</td>
					                <td class="address">${attraction.addr1} ${attraction.addr2}</td>
					                <td class="latitude">${attraction.latitude}</td>
					                <td class="longitude">${attraction.longitude}</td>
					                <td>
					                    <a
					                    	id="btn-remove-schedule"
				                            class="btn btn-danger btn-sm"
				                            href="/trip?action=removeSchedule&contentId=${attraction.contentId}"
				                            ><i class="bi bi-trash"></i></a
				                        >
					                    </button>
					                </td>
					            </tr>
            
                        	</c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- 중앙 content end -->

        <%@ include file="../include/footer.jsp" %>
    </body>
</html>

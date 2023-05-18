<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="include/header.jsp" %>

        <link href="/assets/styles/main.css" rel="stylesheet" />
        <script src="/assets/js/account.js" type="text/javascript"></script>
    </head>
    <body>
        <%@ include file="include/nav.jsp" %>

        <!-- 중앙 content start-->
        <!-- main background-image start -->
        <section>
            <div
                class="bg-image main-background"
                style="background-image: url(/assets/img/common/main-background3.jpg)"
            >
            </div>
        </section>
        <!-- main background-image end -->

        <!-- 중앙 content start -->

        <!-- hotplace 설명 start -->
        <section id="main-hotplace" class="pt-3">
            <div class="container" data-aos="fade-up">
                <div class="section-header text-center">
                    <h2>핫플레이스</h2>
                    <div class="contour"></div>

                    <p>
                        오늘의 BERST 여행지는 <해운대> 입니다. 해운대는 고운 최치원의 자인
                        해운(海雲)에서 비롯된 지명이다. 고운 최치원이 낙향하여 절로 들어가는 길에
                        우연히 해운대에 들렀는데, 주변이 무척 아름다워 동백섬에 海雲臺(해운대)라는
                        글을 음각으로 새겼고 해운대의 이름이 유래되었다.
                    </p>
                </div>

                <div class="row gy-4 mt-3 mb-3">
                    <div
                        class="card col-xl-3 col-md-6 d-flex p-3 mx-auto"
                        data-aos="fade-up"
                        data-aos-delay="100"
                    >
                        <div class="schedule text-center">
                            <img
                                src="/assets/img/hotplace/busan_1.png"
                                class="card-img-top rounded-2"
                                height="300px"
                                alt=""
                            />
                            <div class="card-body"></div>
                            <h4>1위 부산 밤 야경</h4>
                            <p>로맨틱한 부산 밤 야경을 추천합니다</p>
                            <button type="button" class="btn btn-primary">더보기..</button>
                        </div>
                    </div>
                    <!-- End Team Member -->
                    <div
                        class="card col-xl-3 col-md-6 d-flex p-3 mx-auto"
                        data-aos="fade-up"
                        data-aos-delay="100"
                    >
                        <div class="schedule text-center rounded-2">
                            <img
                                src="/assets/img/hotplace/busan_2.png"
                                class="card-img-top"
                                height="300px"
                                alt=""
                            />
                            <div class="card-body"></div>
                            <h4>2위 해운대</h4>
                            <p>부산오면 꼭 와야하는 바다 1위!</p>
                            <button type="button" class="btn btn-primary">더보기..</button>
                        </div>
                    </div>
                    <!-- End Team Member -->
                    <div
                        class="card col-xl-3 col-md-6 d-flex p-3 mx-auto"
                        data-aos="fade-up"
                        data-aos-delay="100"
                    >
                        <div class="schedule text-center rounded-2">
                            <img
                                src="/assets/img/hotplace/busan_3.png"
                                class="card-img-top"
                                height="300px"
                                alt=""
                            />
                            <div class="card-body"></div>
                            <h4>3위 해운대 전통 시장</h4>
                            <p>맛있는 부산의 먹거리를 즐겨보세요</p>
                            <button type="button" class="btn btn-primary">더보기..</button>
                        </div>
                    </div>
                    <!-- End Team Member -->
                </div>
            </div>
        </section>
        <!-- hotplace 설명 end -->

        <!-- 중앙 content end -->

        <%@ include file="include/footer.jsp" %>
    </body>
</html>

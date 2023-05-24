import Vue from "vue";
import VueRouter from "vue-router";
// import store from "@/store";

// Views
import MainView from "@/views/MainView";

// Component
// Trip

Vue.use(VueRouter);

// // https://v3.router.vuejs.org/kr/guide/advanced/navigation-guards.html
// const onlyAuthUser = async (to, from, next) => {
//   const checkUserInfo = store.getters["userStore/checkUserInfo"];
//   const checkToken = store.getters["userStore/checkToken"];
//   let token = sessionStorage.getItem("access-token");
//   console.log("로그인 처리 전", checkUserInfo, token);

//   if (checkUserInfo != null && token) {
//     console.log("토큰 유효성 체크하러 가자!!!!");
//     await store.dispatch("userStore/getUserInfo", token);
//   }
//   if (!checkToken || checkUserInfo === null) {
//     alert("로그인이 필요한 페이지입니다..");
//     // next({ name: "login" });
//     // router.push({ name: "login" });
//   } else {
//     console.log("로그인 했다!!!!!!!!!!!!!.");
//     next();
//   }
// };

const routes = [
  {
    path: "/",
    name: "main",
    component: MainView,
  },

  {
    path: "/trip",
    name: "trip",
    component: () => import(/* webpackChunkName: "trip" */ "@/views/TripView"),
    redirect: "/trip/search",
    children: [
      {
        path: "search",
        name: "tripsearch",
        component: () => import(/* webpackChunkName: "trip" */ "@/components/trip/TripSearch"),
      },
    ],
  },
  {
    path: "/notice",
    name: "notice",
    component: () => import(/* webpackChunkName: "notice" */ "@/views/NoticeBoard"),
    redirect: "/notice/list",
    children: [
      {
        path: "list",
        name: "noticelist",
        // beforeEnter: onlyAuthUser,
        component: () => import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeList"),
      },
      {
        path: "write",
        name: "noticewrite",
        component: () => import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeWrite"),
      },
      {
        path: "view/:noticeno",
        name: "noticeview",
        component: () => import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeView"),
      },
      {
        path: "modify/:noticeno",
        name: "noticemodify",
        component: () => import(/* webpackChunkName: "notice" */ "@/components/notice/NoticeModify"),
      },
    ],
  },
  {
    path: "/plan",
    name: "plan",
    component: () => import(/* webpackChunkName: "plan" */ "@/views/PlanView"),
    redirect: "/plan/list",
    children: [
      {
        path: "list",
        name: "planlist",
        component: () => import(/* webpackChunkName: "plan" */ "@/components/plan/MyPlanList"),
      },
      {
        path: "detail/:tripPlanId",
        name: "plandetail",
        component: () => import(/* webpackChunkName: "plan" */ "@/components/plan/MyPlanDetail"),
      },
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import(/* webpackChunkName: "user" */ "@/views/UserView"),
    children: [
      {
        path: "join",
        name: "join",
        component: () => import(/* webpackChunkName: "user" */ "@/components/user/UserJoin"),
      },
    ],
  },
  {
    path: "/hotplace",
    name: "hotplace",
    component: () => import(/* webpackChunkName: "hotplace" */ "@/views/HotplaceView"),
    redirect: "/hotplace/list",
    children: [
      {
        path: "list",
        name: "hotplacelist",
        component: () =>
          import(/* webpackChunkName: "hotplace" */ "@/components/hotplace/HotplaceList"),
      },
      {
        path: "detail/:hotplaceId",
        name: "hotplacedetail",
        component: () =>
          import(/* webpackChunkName: "hotplace" */ "@/components/hotplace/HotplaceDetail"),
      },
      {
        path: "write",
        name: "hotplacewrite",
        component: () =>
          import(/* webpackChunkName: "hotplace" */ "@/components/hotplace/HotplaceWrite"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

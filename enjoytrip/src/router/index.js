import Vue from "vue";
import VueRouter from "vue-router";

// Views
import MainView from "@/views/MainView";

// Component
// Trip

Vue.use(VueRouter);

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
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

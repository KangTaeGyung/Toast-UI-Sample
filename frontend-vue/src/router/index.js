import { createRouter, createWebHistory } from "vue-router";

const routes = [
  // 홈
  {
    path: "/",
    component: () => import("../views/HomeView.vue"),
  },
  // 부서상세조회 / 수정
  {
    path: "/dept/:dno",
    component: () => import("../views/basic/DeptDetail.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;

import Vue from "vue";
import VueRouter from "vue-router";
import routes from "./routes";
Vue.use(VueRouter);
import { getCookie } from "./cookieHelper";
// // configure router
// const router = new VueRouter({
//   routes, // short for routes: routes
//   linkActiveClass: "active",
// });
//
// export default router;
const router = new VueRouter({
  mode: "history", // Chế độ history để URL đẹp
  routes,
  linkActiveClass: "active",
});

// router.beforeEach((to, from, next) => {
//   const token = localStorage.getItem("token"); // Kiểm tra token
//   if (to.matched.some(record => record.meta.requiresAuth) && !token) {
//     next({ path: "/login", query: { redirect: to.fullPath } });
//   } else {
//     next();
//   }
// });

// router.beforeEach((to, from, next) => {
//   const token = getCookie("token"); // Sử dụng hàm getCookie để lấy token
//   if (to.matched.some(record => record.meta.requiresAuth) && !token) {
//     next({ path: "/login", query: { redirect: to.fullPath } });
//   } else {
//     next();
//   }
// });
router.beforeEach((to, from, next) => {
  const token = getCookie("token"); // Lấy token từ cookie
  const role = getCookie("role"); // Lấy role từ cookie

  // Kiểm tra xem route yêu cầu xác thực và người dùng chưa đăng nhập
  if (to.matched.some(record => record.meta.requiresAuth) && !token) {
    next({ path: "/login", query: { redirect: to.fullPath } });
  } else if (to.meta.requiresAdmin && role !== "admin") {
    // Nếu route yêu cầu admin và người dùng không phải là admin
    next({ path: "/login", query: { redirect: to.fullPath } });
  } else {
    next();
  }
});
export default router;

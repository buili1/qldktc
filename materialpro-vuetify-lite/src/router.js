import Vue from 'vue';
import Router from 'vue-router';
//import store from '@/store'; // Nhập Vuex store
import { getCookie } from './cookieHelper';
Vue.use(Router);

const router = new Router({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: 'dashboard/basic-dashboard',
            component: () => import('@/layouts/Layout'),
            meta: {requiresUser: true, requiresAuth: true }, // Đánh dấu yêu cầu đăng nhập
            children: [
                {
                    name: 'Alerts',
                    path: 'pages/alerts',
                    component: () => import('@/views/pages/Alerts'),
                    meta: {requiresUser: true, requiresAuth: true }, // Đánh dấu yêu cầu đăng nhập
                },
                {
                    name: 'Profile',
                    path: 'pages/profile',
                    component: () => import('@/views/pages/Profile'),
                    meta: {requiresUser: true, requiresAuth: true },
                },
                {
                    name: 'Icons',
                    path: 'pages/icons',
                    component: () => import('@/views/pages/Icons'),
                    meta: {requiresUser: true, requiresAuth: true },
                },
                {
                    name: 'TableSimple',
                    path: 'pages/tables-simple',
                    component: () => import('@/views/pages/TableSimple'),
                    meta: {requiresUser: true, requiresAuth: true },
                },
                {
                    name: 'Dashboard',
                    path: 'dashboard/basic-dashboard',
                    component: () => import('@/views/dashboard/BasicDashboard'),
                    meta: {requiresUser: true, requiresAuth: true },
                },
            ],
        },
        {
            path: '/login',
            name: 'Login',
            component: () => import('@/../../shared_components/Login.vue'), // Trang đăng nhập
        },
    ],
});

// const router = new Router({
//     mode: 'hash',
//     base: process.env.BASE_URL,
//     routes: [
//         {
//             path: '/',
//             redirect: '/login', // Chuyển hướng đến trang đăng nhập khi truy cập vào '/'
//         },
//         {
//             path: '/login',
//             name: 'Login',
//             component: () => import('@/../../shared_components/Login.vue'), // Trang đăng nhập
//         },
//         {
//             path: '/dashboard',
//             component: () => import('@/layouts/Layout'),
//             meta: { requiresAuth: true }, // Đánh dấu yêu cầu đăng nhập
//             children: [
//                 {
//                     name: 'Alerts',
//                     path: 'pages/alerts',
//                     component: () => import('@/views/pages/Alerts'),
//                     meta: { requiresAuth: true }, // Đánh dấu yêu cầu đăng nhập
//                 },
//                 {
//                     name: 'Profile',
//                     path: 'pages/profile',
//                     component: () => import('@/views/pages/Profile'),
//                     meta: { requiresAuth: true },
//                 },
//                 {
//                     name: 'Icons',
//                     path: 'pages/icons',
//                     component: () => import('@/views/pages/Icons'),
//                     meta: { requiresAuth: true },
//                 },
//                 {
//                     name: 'TableSimple',
//                     path: 'pages/tables-simple',
//                     component: () => import('@/views/pages/TableSimple'),
//                     meta: { requiresAuth: true },
//                 },
//                 {
//                     name: 'Dashboard',
//                     path: 'basic-dashboard', // Cập nhật path để phù hợp với cấu trúc
//                     component: () => import('@/views/dashboard/BasicDashboard'),
//                     meta: { requiresAuth: true },
//                 },
//             ],
//         },
//     ],
// });



// router.beforeEach((to, from, next) => {
//     const token = localStorage.getItem("token"); // Kiểm tra token
//     if (to.matched.some(record => record.meta.requiresAuth) && !token) {
//         next({ path: "/login", query: { redirect: to.fullPath } });
//     } else {
//         next();
//     }
// });


// router.beforeEach((to, from, next) => {
//     const token = getCookie("token"); // Lấy token từ cookie
//     if (to.matched.some(record => record.meta.requiresAuth) && !token) {
//         next({ path: "/login", query: { redirect: to.fullPath } });
//     } else {
//         next();
//     }
// });

router.beforeEach((to, from, next) => {
  const token = getCookie("token"); // Lấy token từ cookie
  const role = getCookie("role"); // Lấy role từ cookie

  // Kiểm tra xem route yêu cầu xác thực và người dùng chưa đăng nhập
  if (to.matched.some(record => record.meta.requiresAuth) && !token) {
    next({ path: "/login", query: { redirect: to.fullPath } });
  } else if (to.meta.requiresUser && role !== "user") {
    // Nếu route yêu cầu admin và người dùng không phải là admin
    next({ path: "/login", query: { redirect: to.fullPath } });
  } else {
    next();
  }
});

export default router;

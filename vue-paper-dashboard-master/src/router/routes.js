import DashboardLayout from "@/layout/dashboard/DashboardLayout.vue";
// GeneralViews
import NotFound from "@/pages/NotFoundPage.vue";

// Admin pages
import Dashboard from "@/pages/Dashboard.vue";
import UserProfile from "@/pages/UserProfile.vue";
import Notifications from "@/pages/Notifications.vue";
import Icons from "@/pages/Icons.vue";
import Maps from "@/pages/Maps.vue";
import Typography from "@/pages/Typography.vue";
import TableList from "@/pages/TableList.vue";

const routes = [
  {
    path: "/",
    component: DashboardLayout,
    redirect: "/dashboard",
    meta: { requiresAdmin: true, requiresAuth: true }, // Route yêu cầu đăng nhập
    children: [
      {
        path: "dashboard",
        name: "dashboard",
        component: Dashboard,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "stats",
        name: "stats",
        component: UserProfile,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "notifications",
        name: "notifications",
        component: Notifications,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "icons",
        name: "icons",
        component: Icons,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "maps",
        name: "maps",
        component: Maps,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "typography",
        name: "typography",
        component: Typography,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
      {
        path: "table-list",
        name: "table-list",
        component: TableList,
        meta: {requiresAdmin: true, requiresAuth: true },
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/../../shared_components/Login.vue"), // Thay bằng component Login của bạn
  },
  { path: "*", component: NotFound },
];

export default routes;

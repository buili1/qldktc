import Vue from 'vue'
import Vuex from 'vuex'
import { getCookie } from './cookieHelper';
Vue.use(Vuex)

// export default new Vuex.Store({
//     state: {
//         Sidebar_drawer: null,
//         Customizer_drawer: false,
//         SidebarColor: 'white',
//         SidebarBg: ''
//       },
//     mutations: {
//         SET_SIDEBAR_DRAWER (state, payload) {
//             state.Sidebar_drawer = payload
//         },
//         SET_CUSTOMIZER_DRAWER (state, payload) {
//             state.Customizer_drawer = payload
//         },
//         SET_SIDEBAR_COLOR (state, payload) {
//             state.SidebarColor = payload
//         },
//     },
//     actions: {
//
//     }
// })


// export default new Vuex.Store({
//     state: {
//         Sidebar_drawer: null,
//         Customizer_drawer: false,
//         SidebarColor: 'white',
//         SidebarBg: '',
//         isAuthenticated: !!localStorage.getItem("token"),// Thêm trạng thái đăng nhập
//     },
//     mutations: {
//         SET_SIDEBAR_DRAWER(state, payload) {
//             state.Sidebar_drawer = payload;
//         },
//         SET_CUSTOMIZER_DRAWER(state, payload) {
//             state.Customizer_drawer = payload;
//         },
//         SET_SIDEBAR_COLOR(state, payload) {
//             state.SidebarColor = payload;
//         },
//         SET_AUTHENTICATION(state, payload) {
//             state.isAuthenticated = payload; // Cập nhật trạng thái đăng nhập
//         },
//     },
//     actions: {
//         initializeAuth({ commit }) {
//             const token = localStorage.getItem("token");
//             commit('SET_AUTHENTICATION', !!token); // Đồng bộ trạng thái
//         },
//         login({ commit }, token) {
//             localStorage.setItem("token", token); // Lưu token
//             commit('SET_AUTHENTICATION', true);
//         },
//         logout({ commit }) {
//             commit('SET_AUTHENTICATION', false);
//             localStorage.removeItem("token");
//         }
//     }
// });

export default new Vuex.Store({
    state: {
        Sidebar_drawer: null,
        Customizer_drawer: false,
        SidebarColor: 'white',
        SidebarBg: '',
        isAuthenticated: !!getCookie("token"), // Kiểm tra trạng thái từ cookie
    },
    mutations: {
        SET_AUTHENTICATION(state, payload) {
            state.isAuthenticated = payload;
        },
    },
    actions: {
        initializeAuth({ commit }) {
            const token = getCookie("token");
            commit('SET_AUTHENTICATION', !!token);
        },
        logout({ commit }) {
            commit('SET_AUTHENTICATION', false);
            // Xóa cookie khi đăng xuất
            document.cookie = "token=; path=/; domain=localhost; expires=Thu, 01 Jan 1970 00:00:00 GMT; secure";
            document.cookie = "role=; path=/; domain=localhost; expires=Thu, 01 Jan 1970 00:00:00 GMT; secure";
        }
    }
});


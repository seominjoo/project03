import Vue from "vue"
import VueRouter from "vue-router"
import MainView from "../views/MainView.vue"
import Login from "../views/Login.vue"
import MyPage from '@/views/MyPage.vue'

Vue.use(VueRouter);

const router = new VueRouter({
    mode: "history",
    routes: [
        { path: "/", component: MainView },
        { path: "/login", component: Login },
        { path: "/mypage", component: MyPage },
    ]
})

export default router
import Vue from "vue"
import VueRouter from "vue-router"
import MainView from "../views/MainView.vue"
import ProductInfo from "../views/ProductInfo.vue";

Vue.use(VueRouter);

const router = new VueRouter({
  mode: "history",
  routes: [
    { path: "/", component: MainView },
    { path: "/ProductInfo", component: ProductInfo },
  ],
});

export default router
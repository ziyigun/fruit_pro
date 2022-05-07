import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import BarView from "@/views/BarView";
import PieView from "@/views/PieView";
import TableView from "@/views/TableView";
import EditView from "@/views/EditView";
import AddView from "@/views/AddView";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/BarView.vue')
  },
  {
    path: '/pie',
    name: 'pie',
    component: PieView
  },
  {
    path: '/table',
    name: 'table',
    component: TableView
  },
  {
    path: '/edit',
    name: 'edit',
    component: EditView
  },
  {
    path: '/add',
    name: 'add',
    component: AddView
  },
  {
    path: '/bar',
    name: 'bar',
    component: BarView
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

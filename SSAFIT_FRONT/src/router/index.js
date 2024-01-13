import { createRouter, createWebHistory } from "vue-router";

import Home from "../views/HomeView.vue";
import HomeVideoList from "@/components/home/HomeVideoList.vue";
import User from "../views/UserView.vue";
import LoginForm from "@/components/LoginForm.vue";
import UserRegist from "@/components/user/UserRegist.vue";
import YoutubeView from "@/views/YoutubeView.vue";
import VideoView from "@/views/VideoView.vue";
import VideoList from "@/components/video/VideoList.vue";
import VideoDetail from "@/components/video/VideoDetail.vue";
import BoardCreate from "@/components/video/BoardCreate.vue";
import BoardView from "@/views/BoardView.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardUpdate from "@/components/board/BoardUpdate.vue";
import WishlistView from "@/views/WishlistView.vue";
import WishlistList from "@/components/wishlist/WishlistList.vue";

const routes = [
  // 홈페이지
  {
    path: "/",
    name: "Home",
    component: Home,
    children: [
      {
        path: "",
        name: "HomeVideoList",
        component: HomeVideoList,
      },
    ],
  },
  // 로그인
  {
    path: "/login",
    name: "Login",
    component: LoginForm,
  },
  // 유저
  {
    path: "/user",
    component: User,
    children: [
      {
        path: "regist",
        name: "Regist",
        component: UserRegist,
      },
      // {
      //   path: "",
      //   name: "List",
      //   component: UserList,
      // },
      // {
      //   path: ":id",
      //   name: "Detail",
      //   component: UserDetail,
      // },
    ],
  },
  // 유튜브
  {
    path: "/youtube",
    name: "youtube",
    component: YoutubeView,
  },
  // 영상
  {
    path: "/video",
    name: "video",
    component: VideoView,
    children: [
      {
        path: "",
        name: "videoList",
        component: VideoList,
      },
      {
        path: ":id",
        name: "videoDetail",
        component: VideoDetail,
      },
      {
        path: "create/:id",
        name: "boardCreate",
        component: BoardCreate,
      },
    ],
  },
  // 게시판(후기)
  {
    path: "/board",
    name: "board",
    component: BoardView,
    children: [
      {
        path: "",
        name: "boardList",
        component: BoardList,
      },
      {
        path: ":id",
        name: "boardDetail",
        component: BoardDetail,
      },
      {
        path: "update",
        name: "boardUpdate",
        component: BoardUpdate,
      },
    ],
  },
  // 위시리스트
  {
    path: "/wishlist",
    name: "wishlist",
    component: WishlistView,
    children: [
      {
        path: "",
        name: "wishlistList",
        component: WishlistList,
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;

<template>
  <div class="outer-container">
    <div id="top-marker"></div>
    <HeaderNav :user="user" @logout="logout" />
    <NavigationView />
    <div class="app-container">
      <RouterView @login="login" />
    </div>
    <TheFooter />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import HeaderNav from "@/components/common/HeaderNav.vue";
import NavigationView from "@/components/common/NavigationView.vue";
import TheFooter from "@/components/common/TheFooter.vue";
import axios from "axios";
import { useRouter } from "vue-router";
import { RouterView } from "vue-router";

const router = useRouter();
const user = ref(null);

// 유저가 있는지 확인
onMounted(() => {
  const savedUser = localStorage.getItem("loginUser");
  if (savedUser) {
    user.value = JSON.parse(savedUser);
  }
});

// 로그아웃
const logout = () => {
  user.value = null;
  localStorage.removeItem("loginUser");
  router.push({ name: "Home" });
};

// 로그인
const login = (loginUser) => {
  // user 정보 요청 api 주소
  const REST_USER_API = `http://localhost:9999/api-user`;
  const userId = loginUser.userId;
  const password = loginUser.password;

  // 로그인
  axios
    .post(`${REST_USER_API}/login`, { userId, password })
    .then((response) => {
      user.value = {
        userId: response.data.userId,
        password: response.data.password,
        name: response.data.name,
        nickname: response.data.nickname,
        birthdate: response.data.birthdate,
      };
      localStorage.setItem("loginUser", JSON.stringify(user));
      router.push("/");
    })
    .catch((error) => {
      console.log(error);
      alert("아이디 혹은 비밀번호가 잘못되었습니다.");
    });
};
</script>
<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  list-style: none;
  font-family: Arial, Helvetica, sans-serif;
}

/* 드래그 방지 */
body {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

html {
  overflow-y: scroll;
}

.outer-container {
  background-color: #1e1e20;
}

.app-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.text-center {
  text-align: center;
}
.container {
  margin: 0px 30px;
}

input:focus {
  outline: none;
}
</style>

<template>
  <header>
    <nav class="header-nav">
      <div>
        <RouterLink to="/" class="logo"
          ><img
            class="logo-img"
            src="../../img/ssafit_page_logo_black.png"
            style="width: 110px"
        /></RouterLink>
      </div>
      <div class="user-box">
        <a
          v-if="getUser"
          style="margin: 10px; text-decoration: none; color: white"
          >{{ hello }}님 안녕하세요.</a
        >
        <RouterLink :to="{ name: 'Regist' }" v-if="!getUser" class="join"
          >회원가입</RouterLink
        >
        <a href="#" v-if="getUser" @click="logout">로그아웃</a>
        <RouterLink :to="{ name: 'Login' }" v-else>로그인</RouterLink>
      </div>
    </nav>
  </header>
</template>

<script setup>
import { RouterLink } from "vue-router";
import { computed, ref, watch } from "vue";

const props = defineProps(["user"]);
const emits = defineEmits(["logout"]);

const getUser = computed(() => !!props.user);
const hello = ref(""); // ref로 변수 선언

const logout = () => {
  localStorage.removeItem("loginUser");
  emits("logout");
};

// onMounted 대신 watch를 사용하여 getUser 값이 변경될 때마다 실행
watch(
  () => getUser.value,
  (newValue) => {
    if (newValue) {
      const loginUserString1 = localStorage.getItem("loginUser");
      if (loginUserString1) {
        const currentUser = JSON.parse(loginUserString1);
        hello.value = currentUser._rawValue.name;
      }
    }
  }
);
</script>

<style>
html {
  background-color: #1e1e20;
}

header {
  margin-top: 20px;
  height: 70px;
  background-color: #1e1e20;
  line-height: 50px;
  padding: 0px 30px;
}

header a {
  margin: 10px;
  text-decoration: none;
  color: white;
}

.header-nav {
  max-width: 1200px;
  margin: 0 auto;
  padding-top: 20px;
  display: flex;
  justify-content: space-between;
}

.logo {
  display: inline-block;
  font-size: 2rem;
  font-weight: bold;
  color: white;
  margin: 0;
}

.user-box {
  font-size: 14px;
  margin: 0 2px;
}

.join {
  margin-right: 20px;
  color: #02bf53;
}

.logo-img:hover {
  cursor: pointer;
}
</style>

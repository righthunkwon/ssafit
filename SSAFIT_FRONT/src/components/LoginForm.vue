<template>
  <div>
    <div class="outer-container">
      <div class="text-center main-logo">
        <img src="../img/ssafit_page_logo_black.png" style="width: 300px" />
      </div>
      <div class="login-container">
        <div class="item-wrapper">
          <fieldset class="text-center login-box">
            <input
              type="text"
              id="id"
              class="view"
              v-model="id"
              @keyup.enter="login"
              placeholder="아이디"
            /><br />
            <input
              type="password"
              id="password"
              class="view"
              v-model="password"
              @keyup.enter="login"
              placeholder="비밀번호"
            /><br />
            <button class="login-button" @click="login">로그인</button>
          </fieldset>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

// id, 비밀번호, 로그인 상태
const id = ref("");
const password = ref("");
const emit = defineEmits(["login"]);

// 로그인
const login = () => {
  let user = {
    userId: id.value,
    password: password.value,
  };
  emit("login", user);
};
</script>

<style scoped>
.outer-container {
  background-color: #1e1e20;
}
.login-container {
  padding: 20px;
  margin: 0 auto;
  margin-top: 10px;
  width: 500px;
}

.item-wrapper {
  background-color: #343638;
}

.login-box {
  background-color: 1e1E20 !important;
}

.main-logo {
  margin-top: 50px;
}

.login-button {
  margin-top: 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.login-button:hover {
  background-color: #45a049;
}
</style>

<template>
  <div>
    <div class="item-wrapper-login">
      <div class="service-title">회원가입</div>
      <fieldset class="signup-box">
        <div class="signup-box-item">
          <label for="id">아이디</label>
          <input type="text" id="id" v-model="id" class="view" /><br />
        </div>

        <div class="signup-box-item">
          <label for="password">비밀번호</label>
          <input
            type="password"
            id="password"
            v-model="password"
            class="view"
          /><br />
        </div>
        <div class="signup-box-item">
          <label for="password2">비밀번호 확인</label>
          <input
            type="password"
            id="password2"
            v-model="password2"
            class="view"
          /><br />
        </div>
        <div class="signup-box-item">
          <label for="name">이름</label>
          <input type="text" id="name" v-model="name" class="view" /><br />
        </div>
        <div class="signup-box-item">
          <label for="nickname">별명</label>
          <input
            type="text"
            id="nickname"
            v-model="nickname"
            class="view"
          /><br />
        </div>
        <div class="signup-box-item">
          <label for="birthdate">생년월일(6자리)</label>
          <input
            type="text"
            id="birthdate"
            v-model="birthdate"
            class="view"
          /><br />
        </div>
        <div class="signup-button-box">
          <button class="signup-button" @click="regist">등록</button>
        </div>
      </fieldset>
    </div>
    <div class="empty-box"></div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import axios from "axios";
import { useRouter } from "vue-router";
// import http from "@/util/http-common";

const router = useRouter();
const emit = defineEmits(["create-user"]);

const id = ref("");
const password = ref("");
const password2 = ref("");
const name = ref("");
const nickname = ref("");
const birthdate = ref("");
const users = ref([]);

const getUserList = () => {
  const API_URL = `http://localhost:9999/api-user/user`;
  axios({
    url: API_URL,
    method: "GET",
  })
    .then((res) => {
      users.value = Array.isArray(res.data) ? res.data : [];
    })
    .catch((err) => {
      console.log(err);
    });
};

const regist = () => {
  const user = {
    userId: id.value,
    password: password.value,
    name: name.value,
    nickname: nickname.value,
    birthdate: birthdate.value,
  };
  emit("create-user", user);
};
getUserList();
</script>

<style scoped>
.item-wrapper-login {
  margin: 0 auto;
  margin-top: 40px;
  background-color: #272829;
  border-radius: 5px;
  padding: 20px;
  color: white;
  max-width: 900px;
}

.service-title {
  margin-left: 20px;
  font-size: 20px;
  margin-bottom: 20px;
}

.signup-box {
  margin-left: 20px;
}

.signup-box-item {
  padding: 2px;
  margin: 8px;
  background-color: #343638;
  border-radius: 5px;
  padding-left: 20px;
}

.view {
  width: 400px;
}

.signup-button {
  margin-top: 20px;
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.signup-button-box {
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
  padding-right: 10px;
}
.signup-button:hover {
  background-color: #45a049;
}

.empty-box {
  height: 100px;
}
</style>

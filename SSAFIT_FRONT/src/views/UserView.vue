<template>
  <div class="container">
    <RouterView
      :users="users"
      @create-user="createUser"
      @update-user="updateUser"
      @delete-user="deleteUser"
    />
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";
import http from "@/util/http-common";

const router = useRouter();
const users = ref([]);
const REST_USER_API = `http://localhost:9999/api-user`;

// 사용자 목록 조회
const getUserList = () => {
  http
    .get(`/api-user/user`)
    .then((response) => {
      users.value = response.data;
    })
    .catch((error) => {
      console.log(error);
    });
};

// 사용자 등록
const createUser = (user) => {
  axios
    .post(`${REST_USER_API}/signup`, user)
    .then((response) => {
      if (response.status === 201) {
        alert("회원가입을 환영합니다.");
        router.push("/");
      }
    })
    .catch((error) => {
      if (error.response && error.response.status === 409) {
        alert("이미 존재하는 아이디입니다. 다른 아이디를 입력해 주세요.");
      }
    });
};

onMounted(() => {
  getUserList();
});
</script>

<style>
.user-link {
  color: black;
}

.view {
  width: 80%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  color: #787878;
  font-size: medium;
}

label {
  display: inline-block;
  width: 130px;
}

.btn {
  width: 8%;
  background-color: #d0d3d0;
  color: rgb(80, 82, 79);
  padding: 14px 20px;
  margin: 8px;
  border: 1px solid #787878;
  border-radius: 4px;
  font-size: large;
  cursor: pointer;
}

/* 테이블 CSS */
.user-list {
  border-collapse: collapse;
  width: 100%;
  text-align: center;
  margin: auto;
}

.user-list td,
.user-list th {
  border: 1px solid black;
}
</style>

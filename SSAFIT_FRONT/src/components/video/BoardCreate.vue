<template>
  <div>
    <div class="item-wrapper-create">
      <h4 class="create-title">후기 등록</h4>
      <div>
        <fieldset>
          <div>
            <label for="title">제목 : </label>
            <input type="text" id="title" v-model="board.title" />
          </div>
          <div>
            <label for="userId">작성자 : </label>
            <input type="text" id="userId" readonly v-model="currentUserId" />
          </div>
          <div>
            <label for="content">내용 : </label>
            <textarea
              id="content"
              cols="30"
              rows="10"
              v-model="board.content"
            ></textarea>
          </div>
          <div>
            <button class="create-button" @click="createBoard">등록</button>
            <button @click="cancel">취소</button>
          </div>
        </fieldset>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useBoardStore } from "@/stores/board";

const store = useBoardStore();
const currentURL = window.location.href;
const urlParts = currentURL.split("/");
const videoId = urlParts[urlParts.length - 1];
const loginUserString = localStorage.getItem("loginUser");
const currentUser = JSON.parse(loginUserString);
const currentUserId = currentUser._rawValue.userId;

const board = ref({
  videoId: videoId,
  userId: currentUserId,
  title: "",
  content: "",
});

const createBoard = function () {
  store.createBoard(board.value);
};

// 취소(뒤로가기)
const cancel = function () {
  history.back(-1);
};
</script>

<style scoped>
.item-wrapper-create {
  max-width: 900px;
  margin: 0 auto;
  margin-top: 40px;
  padding: 20px;
  background-color: #272829;
  color: white;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
}

label {
  margin-top: 20px;
  margin-bottom: 10px;
  font-size: 16px;
}

button {
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.create-button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  margin-right: 6px;
}

.create-button:hover {
  background-color: #45a049;
}

button {
  background-color: #ff6b6b;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

button:hover {
  background-color: rgb(238, 81, 54);
}

div {
  padding: 8px;
  display: flex;
  flex-direction: row;
  justify-content: flex-end;
}

input:focus {
  outline: none;
}

textarea:focus {
  outline: none;
}

input,
textarea {
  flex: 1;
  padding: 10px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
  width: 650px;
}

.empty-box {
  height: 100px;
}
</style>

<template>
  <div>
    <div class="item-wrapper-update">
      <h4>게시글 수정</h4>
      <fieldset>
        <div class="item-wrapper-item">
          <label for="title" class="item-wrapper-title">제목 </label>
          <input
            type="text"
            id="title"
            class="update-input"
            v-model="store.board.title"
          />
        </div>
        <div class="item-wrapper-item">
          <label for="writer" class="item-wrapper-title">글쓴이 </label>
          <input
            type="text"
            id="writer"
            class="update-input"
            readonly
            v-model="store.board.userId"
          />
        </div>

        <div class="item-wrapper-item">
          <label for="content" class="item-wrapper-title">내용 </label>
          <textarea
            id="content"
            class="update-input"
            cols="30"
            rows="10"
            v-model="store.board.content"
          ></textarea>
        </div>
        <div class="button-box">
          <button @click="updateBoard" class="update-button">수정</button>
          <button @click="cancel" class="cancel-button">취소</button>
        </div>
      </fieldset>
    </div>
    <div class="empty-box"></div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
const store = useBoardStore();

const updateBoard = function () {
  store.updateBoard();
};

// 취소(뒤로가기)
const cancel = function () {
  history.back(-1);
};
</script>

<style scoped>
.item-wrapper-update {
  max-width: 900px;
  margin: 0 auto;
  margin-top: 40px;
  padding: 20px;
  background-color: #272829;
  color: white;
  border-radius: 8px;
}

.item-wrapper-item {
  display: flex;
  flex-direction: column;
}

.item-wrapper-title {
  margin-top: 20px;
  margin-bottom: 10px;
  font-size: 16px;
}

.button-box {
  margin-top: 30px;
  margin-bottom: 20px;
}

.cancel-button,
.update-button {
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.cancel-button {
  background-color: #ff6b6b;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  margin-left: 6px;
}

.cancel-button:hover {
  background-color: rgb(238, 81, 54);
}

.update-button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.update-button:hover {
  background-color: #45a049;
}

.button-box {
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

.update-input {
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

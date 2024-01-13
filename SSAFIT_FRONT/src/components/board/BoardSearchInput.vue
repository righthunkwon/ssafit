<template>
  <div class="search-box">
    <div class="search-criteria-box">
      <div>
        <select class="search-select" v-model="searchInfo.key">
          <option value="none">검색기준</option>
          <option value="user_id">작성자</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
      </div>
    </div>
    <div class="search-box">
      <input
        type="text"
        class="search-input"
        placeholder="검색어를 입력해주세요"
        v-model="searchInfo.word"
        @keyup.enter="searchBoardList"
      />
      <button class="search-button" @click="searchBoardList">검색</button>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useBoardStore } from "@/stores/board";

const store = useBoardStore();
const searchInfo = ref({
  key: "none",
  word: "",
});
const searchBoardList = function () {
  store.searchBoardList(searchInfo.value);
};
</script>

<style scoped>
.search-container {
  display: flex;
  justify-content: center;
}
.search-select {
  padding: 9px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
  width: 150px; /* 선택 박스의 너비 조절 */
  cursor: pointer;
}
.search-box {
  width: 550px;
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  align-items: center;
  margin-left: 10px;
}

.search-input {
  flex: 1;
  padding: 10px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
  width: 300px;
}
.search-button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.search-button:hover {
  background-color: #45a049;
}
</style>

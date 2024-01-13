<template>
  <div class="search-box">
    <div class="search-criteria-box">
      <div>
        <select v-model="searchInfo.key" class="search-select">
          <option value="none">검색기준</option>
          <option value="creator">크리에이터</option>
          <option value="title">영상제목</option>
          <option value="content">영상내용</option>
          <option value="part">운동부위</option>
        </select>
      </div>
    </div>
    <div>
      <div>
        <input
          type="text"
          class="search-input"
          placeholder="검색어를 입력해주세요"
          v-model="searchInfo.word"
          @keyup.enter="searchVideoList"
        />
        <button class="search-button" @click="searchVideoList">검색</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useVideoStore } from "@/stores/video";

const store = useVideoStore();
const searchInfo = ref({
  key: "none",
  word: "",
});
const searchVideoList = function () {
  store.searchVideoList(searchInfo.value);
};
</script>

<style scoped>
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

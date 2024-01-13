<template>
  <div>
    <div class="item-wrapper">
      <div class="item-wrapper-box">
        <div class="search-box">
          <div class="search-title">영상 검색</div>
        </div>
        <div>
          <input
            type="text"
            class="search-input"
            placeholder="검색어를 입력해 주세요."
            v-model="keyword"
            @keyup.enter="search"
          />
          <button @click="search" class="search-button">검색</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { useYoutubeStore } from "@/stores/youtube";
const keyword = ref("");

const store = useYoutubeStore();

const search = function () {
  store.videoSearch(keyword.value);
};
</script>

<style scoped>
input:focus {
  outline: none;
}
.item-wrapper {
  width: 700px;
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  padding-left: 40px;
}

.item-wrapper-box {
  display: flex;
  flex-direction: column;
  justify-content: left;
  color: white;
}

.search-box {
  margin-right: 20px;
  font-size: 20px;
}

.search-title {
  margin-bottom: 20px;
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

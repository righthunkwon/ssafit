<template>
  <div class="board-container">
    <div class="item-wrapper-table">
      <div class="review-title">후기 목록</div>
      <table class="table-box">
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>등록일시</th>
        </tr>
        <tr v-for="board in store.boardList.reverse()" :key="board.reviewId">
          <td>{{ board.reviewId }}</td>
          <td class="video-title-box" style="text-align: left">
            <RouterLink class="video-title" :to="`/board/${board.reviewId}`">{{
              board.title
            }}</RouterLink>
          </td>
          <td>{{ board.userId }}</td>
          <td>{{ board.viewcnt }}</td>
          <td>{{ board.regdate }}</td>
        </tr>
      </table>
    </div>
    <div class="item-wrapper-search">
      <div class="search-box"><BoardSearchInput /></div>
    </div>
  </div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";
import BoardSearchInput from "./BoardSearchInput.vue";
const store = useBoardStore();

onMounted(() => {
  store.getBoardList();
});
</script>

<style scoped>
.item-wrapper-table {
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  margin: 0 auto;
  max-width: 900px;
  margin-top: 40px;
  color: white;
}

.item-wrapper-search {
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  width: 600px;
  margin: 0 auto;
  margin-top: 40px;
}
.board-container {
  display: flex;
  flex-direction: column;
}
.table-box {
  width: 100%;
  text-align: center;
  table-layout: fixed;
  font-size: 14px;
}

.table-box th {
  padding: 10px;
}

.table-box th:nth-child(1) {
  width: 16%;
}

.table-box th:nth-child(2) {
  width: 37%;
}

.table-box th:nth-child(3) {
  width: 20%;
}

.table-box th:nth-child(4) {
  width: 20%;
}

.table-box th:nth-child(5) {
  width: 39%;
}

.video-title-box {
  padding-left: 30px;
  font-size: 15px;
}
.video-title {
  font-weight: 500;
  text-decoration: none;
  color: cornflowerblue;
  font-weight: 600;
}

.review-title {
  margin-left: 20px;
  font-size: 20px;
  margin-bottom: 20px;
}
</style>

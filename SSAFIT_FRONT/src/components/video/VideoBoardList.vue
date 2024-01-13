<template>
  <div class="item-wrapper-review">
    <div class="review-title">후기 목록</div>
    <table class="table-box">
      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>등록일시</th>
      </tr>
      <tr v-for="board in store.boardList" :key="board.reviewId">
        <td v-if="board.videoId == videoId">{{ board.reviewId }}</td>
        <td class="video-title-box" v-if="board.videoId == videoId">
          <RouterLink class="video-title" :to="`/board/${board.reviewId}`">{{
            board.title
          }}</RouterLink>
        </td>
        <td v-if="board.videoId == videoId">{{ board.userId }}</td>
        <td v-if="board.videoId == videoId">{{ board.viewcnt }}</td>
        <td v-if="board.videoId == videoId">{{ board.regdate }}</td>
      </tr>
    </table>

    <BoardSearchInput />
  </div>
  <div class="empty-space"></div>
</template>

<script setup>
import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";
const store = useBoardStore();
const currentURL = window.location.href;
const urlParts = currentURL.split("/");
const videoId = urlParts[urlParts.length - 1];

onMounted(() => {
  store.getBoardList();
});
</script>

<style scoped>
.item-wrapper-review {
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  margin: 0 auto;
  max-width: 900px;
  margin-top: 40px;
  color: white;
}

.empty-space {
  height: 100px;
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

<template>
  <div>
    <div class="delivery-review">
      <div class="delivery-review-header">
        <h2 class="delivery-review-title">{{ store.board.title }}</h2>
      </div>

      <div class="delivery-review-content">
        <div class="review-detail">
          <div class="detail-item">
            <label class="detail-label">영상제목:</label>
            <div class="content">
              {{ store.video.title }}
            </div>
          </div>

          <div class="detail-item">
            <label class="detail-label">내용:</label>
            <div class="content">{{ store.board.content }}</div>
          </div>

          <div class="detail-item">
            <label class="detail-label">조회수:</label>
            <div>{{ store.board.viewcnt }}</div>
          </div>

          <div class="detail-item">
            <label class="detail-label">작성자:</label>
            <div>{{ store.board.userId }}</div>
          </div>

          <div class="detail-item">
            <label class="detail-label">작성일:</label>
            <div>{{ store.board.regdate }}</div>
          </div>
        </div>
      </div>
      <div class="button-box">
        <button @click="updateBoard" class="update-button">수정</button>
        <button @click="deleteBoard" class="delete-button">삭제</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useBoardStore } from "@/stores/board";
import { onMounted } from "vue";
import axios from "axios";

const store = useBoardStore();
const route = useRoute();
const router = useRouter();

onMounted(async () => {
  await store.getBoard(route.params.id);
});

const deleteBoard = function () {
  const loginUserString = localStorage.getItem("loginUser");
  const currentUser = JSON.parse(loginUserString);
  const boardAuthorId = store.board.userId;

  if (
    currentUser &&
    boardAuthorId &&
    currentUser._rawValue.userId === boardAuthorId
  ) {
    const flag = confirm("정말 삭제하시겠습니까?");
    if (flag) {
      axios
        .delete(`http://localhost:9999/api-review/${route.params.id}`)
        .then(() => {
          alert("글이 삭제되었습니다.");
          router.go(-1);
        });
    }
  } else {
    alert("삭제할 권한이 없습니다.");
  }
};

const updateBoard = function () {
  const loginUserString = localStorage.getItem("loginUser");
  const currentUser = JSON.parse(loginUserString);
  const boardAuthorId = store.board.userId;

  if (
    currentUser &&
    boardAuthorId &&
    currentUser._rawValue.userId === boardAuthorId
  ) {
    router.push({ name: "boardUpdate" });
  } else {
    alert("수정할 권한이 없습니다.");
  }
};
</script>

<style scoped>
.delivery-review {
  max-width: 900px;
  margin: 0 auto;
  margin-top: 40px;
  padding: 20px;
  background-color: #272829;
  color: white;
  border-radius: 8px;
}
.delivery-review-header {
  text-align: center;
}

.delivery-review-title {
  font-size: 24px;
  margin-bottom: 10px;
}

.delivery-review-content {
  background-color: 343638;
  padding: 20px;
  border-radius: 8px;
  margin-top: 20px;
}

.review-detail {
  margin-bottom: 20px;
}

.detail-item {
  display: flex;
  margin-bottom: 10px;
}

.detail-label {
  min-width: 80px;
  font-weight: bold;
  margin-right: 10px;
}

.content {
  white-space: pre-line;
}

.delete-button,
.update-button {
  padding: 8px 16px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.delete-button {
  background-color: #ff6b6b;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
  margin-left: 6px;
}

.delete-button:hover {
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
</style>

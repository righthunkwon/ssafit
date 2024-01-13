<template>
  <div class="video-container">
    <!-- item -->
    <div class="item-wrapper-search">
      <div class="search-box"><VideoSearchInput /></div>
    </div>
    <hr />
    <div class="item-wrapper">
      <div class="row">
        <div
          class="col-lg-3 col-md-4 col-sm-6 mb-4"
          v-for="video in paginatedVideos"
          :key="video.videoId"
        >
          <div class="card">
            <div class="card-body">
              <td class="thumbnail">
                <RouterLink :to="`/video/${video.videoId}`">
                  <img
                    :src="`http://localhost:9999/image/${video.videoId}.jpg`"
                    alt=""
                /></RouterLink>
              </td>
              <div class="card-title-box">
                <RouterLink
                  :to="`/video/${video.videoId}`"
                  class="card-title"
                  >{{ video.title }}</RouterLink
                >
              </div>
              <div class="card-text-box">
                <p class="card-text card-creator">{{ video.creator }}</p>
                <p class="card-text">{{ video.part }}운동</p>
                <p class="card-text">조회수 {{ video.viewcnt }}</p>
                <p class="card-text">{{ formatDate(video.regdate) }}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- page navigation -->
    <nav
      class="page-navigation"
      v-if="totalPages > 1"
      aria-label="Page navigation"
    >
      <ul class="pagination">
        <!-- 이전 버튼 -->
        <li v-if="currentPage > 1" class="page-item">
          <button class="page-link" @click="prevPage">이전</button>
        </li>
        <!-- 중간 페이지 버튼 -->
        <li
          v-for="page in displayedPages"
          :key="page"
          :class="{ 'page-item': true, active: currentPage === page }"
        >
          <button class="page-link" @click="changePage(page)">
            {{ page }}
          </button>
        </li>
        <!-- 다음 버튼 -->
        <li v-if="currentPage < totalPages" class="page-item">
          <button class="page-link" @click="nextPage">다음</button>
        </li>
      </ul>
    </nav>
    <div class="empty-box"></div>
  </div>
</template>

<script setup>
import { onMounted, ref, computed } from "vue";
import { useVideoStore } from "@/stores/video";
import VideoSearchInput from "./VideoSearchInput.vue";

const store = useVideoStore();
const itemsPerPage = 8; // 한 페이지에 보여줄 아이템 수
const currentPage = ref(1);

onMounted(() => {
  store.getVideoList();
});

function formatDate(dateString) {
  const options = { year: "numeric", month: "2-digit", day: "2-digit" };
  const date = new Date(dateString);
  return date.toLocaleDateString("ko-KR", options);
}

const paginatedVideos = computed(() => {
  const startIndex = (currentPage.value - 1) * itemsPerPage;
  const endIndex = startIndex + itemsPerPage;
  return store.videoList.slice(startIndex, endIndex);
});

const totalPages = computed(() => {
  return Math.ceil(store.videoList.length / itemsPerPage);
});

function changePage(page) {
  currentPage.value = page;
}

function nextPage() {
  if (currentPage.value < totalPages.value) {
    currentPage.value++;
  }
}

function prevPage() {
  if (currentPage.value > 1) {
    currentPage.value--;
  }
}

// 페이지네이션에서 보여질 페이지 그룹을 계산하는 computed 속성 추가
const displayedPages = computed(() => {
  const totalDisplayedPages = 5; // 한 번에 보여질 페이지 수
  const groupSize = 5; // 그룹 당 페이지 수
  const groupNumber = Math.ceil(currentPage.value / groupSize);
  const startPage = (groupNumber - 1) * groupSize + 1;
  const endPage = Math.min(
    startPage + totalDisplayedPages - 1,
    totalPages.value
  );

  const pages = [];
  for (let i = startPage; i <= endPage; i++) {
    pages.push(i);
  }
  return pages;
});
</script>

<style scoped>
.video-container {
  display: flex;
  flex-direction: column;
}

.item-wrapper {
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
}

.item-wrapper-search {
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  width: 600px;
  margin: 0 auto;
  margin-top: 40px;
}

.card {
  background-color: #343638;
  color: darkgray;
}

.card img {
  width: 100%;
  height: auto;
}

.card-title-box {
  background-color: black;
  border-radius: 0 0 5px 5px;
  height: 60px;
  padding: 0 6px;
  text-align: center;
}

.card-title {
  text-decoration: none;
  color: white;
  font-size: 14px;
}

.card-text-box {
  margin-top: 20px;
}
.card-text {
  font-size: 14px;
  margin: 4px;
}

.empty-box {
  height: 100px;
}

.page-navigation {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}

.pagination {
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
}

.page-item {
  margin: 0 2px;
}

.page-link {
  background-color: white;
  color: black;
  border-radius: 5px;
  cursor: pointer;
}

.page-link:hover {
  background-color: gray;
  border-color: gray;
  color: white;
}

.page-link:focus {
  outline: none;
}

.active .page-link {
  background-color: #02bf53;
  border-color: #02bf53;
}
</style>

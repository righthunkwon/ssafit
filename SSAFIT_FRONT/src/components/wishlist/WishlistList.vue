<template>
  <div>
    <div class="item-wrapper-wish">
      <div class="wish-title">즐겨찾는 영상</div>
      <table class="table-box">
        <tr>
          <th>썸네일</th>
          <th>제목</th>
          <th>작성자</th>
          <th>조회수</th>
          <th>등록일</th>
        </tr>
        <tr v-for="video in wishlistStore.wishlist" :key="video.videoId">
          <td class="wishlist-thumbnail">
            <img
              :src="`http://localhost:9999/image/${video.videoId}.jpg`"
              alt=""
            />
          </td>
          <td class="video-title-box">
            <RouterLink
              class="video-title"
              :to="`/video/${video.videoId}`"
              style="color: cornflowerblue"
              >{{ getVideoId(video.videoId) }}</RouterLink
            >
          </td>
          <td>{{ getVideoCreator(video.videoId) }}</td>
          <td>{{ getVideoViewcnt(video.videoId) }}</td>
          <td>{{ getVideoRegdate(video.videoId) }}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useWishlistStore } from "@/stores/wishlist";
import { useVideoStore } from "@/stores/video";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const videoStore = useVideoStore();
const wishlistStore = useWishlistStore();

onMounted(() => {
  if (localStorage.getItem("loginUser") != null) {
    const loginUserString = localStorage.getItem("loginUser");
    const currentUser = JSON.parse(loginUserString);
    const currentUserId = currentUser._rawValue.userId;

    videoStore.getVideoList();
    wishlistStore.getWishlist(currentUserId);
    videoStore.getVideoList();
  } else {
    alert("로그인이 필요한 서비스입니다.");
    router.push({ name: "Login" });
  }
});

const route = useRoute();
function getVideoId(videoId) {
  for (const el of videoStore.videoList) {
    if (el.videoId == videoId) {
      return el.title;
    }
  }
}

function getVideoCreator(videoId) {
  for (const el of videoStore.videoList) {
    if (el.videoId == videoId) {
      return el.creator;
    }
  }
}

function getVideoViewcnt(videoId) {
  for (const el of videoStore.videoList) {
    if (el.videoId == videoId) {
      return el.viewcnt;
    }
  }
}

function getVideoRegdate(videoId) {
  for (const el of videoStore.videoList) {
    if (el.videoId == videoId) {
      return el.regdate;
    }
  }
}
</script>

<style scoped>
.item-wrapper-wish {
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  margin: 0 auto;
  max-width: 900px;
  margin-top: 40px;
  color: white;
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
  width: 40%;
}

.table-box th:nth-child(3) {
  width: 25%;
}
.table-box th:nth-child(4) {
  width: 14%;
}

.table-box th:nth-child(5) {
  width: 37%;
}

.video-title-box {
  padding-left: 30px;
  font-size: 15px;
  text-align: left;
  padding: 0 20px;
}
.video-title {
  font-weight: 500;
  text-decoration: none;
  font-weight: 600;
}

.wishlist-thumbnail img {
  width: 100%;
  height: auto;
}

.wish-title {
  margin-left: 20px;
  font-size: 20px;
  margin-bottom: 20px;
}

.video-title-box {
  padding-left: 30px;
  font-size: 15px;
}
.video-title {
  font-weight: 500;
  text-decoration: none;
  color: #02bf53;
  font-weight: 600;
}
</style>

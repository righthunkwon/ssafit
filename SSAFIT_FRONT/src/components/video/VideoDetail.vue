<template>
  <div class="outer-wrapper">
    <div class="item-wrapper-video">
      <div class="video-wrapper">
        <iframe
          id="player"
          width="560"
          height="315"
          :src="store.video.link"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
          allowfullscreen
        ></iframe>
      </div>
      <div class="text-wrapper">
        <div class="btn-box">
          <div>
            <button
              v-if="showVideoLikeButton"
              class="likeBtn"
              @click="handleLike"
            >
              <i v-if="!store.videoLike" class="bi-heart"></i>
              <i v-else class="bi-heart-fill"></i>
              <span class="video-likes-text">
                {{ store.videoLikes }} Likes</span
              >
            </button>
          </div>
          <span class="text-up-box">
            <i
              v-if="showAddWishlistButton"
              @click="addWishlist"
              class="bi bi-bookmark-heart add-wish-btn"
            ></i>

            <i
              v-if="showDeleteWishlistButton"
              @click="deleteWishlist"
              class="bi bi-bookmark-heart-fill delete-wish-btn"
            ></i>
          </span>
        </div>
        <div class="info-wrapper">
          <div class="info-wrapper-video-title">{{ store.video.title }}</div>
          <div>{{ store.video.content }}</div>
          <div>{{ store.video.creator }}</div>
          <div>조회수 {{ store.video.viewcnt }}</div>
          <div>등록일시 {{ store.video.regdate }}</div>
        </div>
        <div class="btn-wrapper">
          <button
            class="create-button"
            v-if="showCreateBoardButton"
            @click="createBoard"
          >
            후기 등록
          </button>
        </div>
      </div>
    </div>

    <VideoBoardList />
    <div class="empty-space"></div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { useVideoStore } from "@/stores/video";
import { useWishlistStore } from "@/stores/wishlist";
import { ref, onMounted, computed, watch } from "vue";
import VideoBoardList from "@/components/video/VideoBoardList.vue";

const store = useVideoStore();
const wishlistStore = useWishlistStore();
const route = useRoute();
const router = useRouter();

const currentURL = window.location.href;
const urlParts = currentURL.split();

const showAddWishlistButton = ref(false);
const showDeleteWishlistButton = ref(false);

// 비동기 처리
onMounted(async () => {
  if (localStorage.getItem("loginUser") != null) {
    const loginUserString = localStorage.getItem("loginUser");
    const currentUser = JSON.parse(loginUserString);
    const currentUserId = currentUser._rawValue.userId;
    await store.getVideoLikes(route.params.id);
    await store.getVideoLike(currentUserId, route.params.id);
    await wishlistStore.getWishlistList();

    const inWishlist = wishlistStore.wishlistList?.some(
      (item) => item.videoId == route.params.id && item.userId == currentUserId
    );

    showAddWishlistButton.value = !inWishlist;
    showDeleteWishlistButton.value = inWishlist;
  } else {
    showAddWishlistButton.value = false;
    showDeleteWishlistButton.value = false;
  }
  store.getVideo(route.params.id);
});

watch(
  () => wishlistStore.wishlistList,
  (newVal) => {
    // wishlistList 값이 변경될 때 실행되는 로직
    const loginUserString = localStorage.getItem("loginUser");
    if (loginUserString !== null) {
      const currentUser = JSON.parse(loginUserString);
      const currentUserId = currentUser._rawValue.userId;

      const inWishlist = newVal?.some(
        (item) =>
          item.videoId == route.params.id && item.userId == currentUserId
      );

      showAddWishlistButton.value = !inWishlist;
      showDeleteWishlistButton.value = inWishlist;
    }
  },
  { deep: true }
);

const toggleButtons = () => {
  showAddWishlistButton.value = !showAddWishlistButton.value;
  showDeleteWishlistButton.value = !showDeleteWishlistButton.value;
};

// 위시리스트 등록 메서드
const addWishlist = function () {
  const loginUserString = localStorage.getItem("loginUser");
  const currentUser = JSON.parse(loginUserString);
  const currentUserId = currentUser._rawValue.userId;
  wishlistStore.addWishlist(currentUserId, route.params.id);
  toggleButtons();
};

// 위시리스트 삭제 메서드
const deleteWishlist = function () {
  const loginUserString = localStorage.getItem("loginUser");
  const currentUser = JSON.parse(loginUserString);
  const currentUserId = currentUser._rawValue.userId;
  wishlistStore.deleteWishlist(currentUserId, route.params.id);
  toggleButtons();
};

// 후기 등록 버튼 렌더링 여부
const showCreateBoardButton = computed(() => {
  if (localStorage.getItem("loginUser") != null) {
    const loginUserString = localStorage.getItem("loginUser");
    const currentUser = JSON.parse(loginUserString);
    const currentUserId = currentUser._rawValue.userId;
    return currentUserId !== null;
  }
});

// 새 후기 등록
const createBoard = function () {
  router.push({ name: "boardCreate" });
};

// 좋아요 버튼 렌더링 여부
const showVideoLikeButton = computed(() => {
  if (localStorage.getItem("loginUser") != null) {
    const loginUserString = localStorage.getItem("loginUser");
    const currentUser = JSON.parse(loginUserString);
    const currentUserId = currentUser._rawValue.userId;
    return currentUserId !== null;
  }
});

// 좋아요 버튼(클릭 이벤트)
const handleLike = function () {
  const loginUserString = localStorage.getItem("loginUser");
  const currentUser = JSON.parse(loginUserString);
  const currentUserId = currentUser._rawValue.userId;
  if (store.videoLike) store.videoLikes -= 1;
  else store.videoLikes += 1;
  store.videoLike = !store.videoLike;
  store.sendLikeRequest(currentUserId, store.video.videoId);
};
</script>

<style scoped>
.item-wrapper-video {
  width: 596px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
  margin: 40px auto;
}
.empty-space {
  height: 60px;
}

.video-wrapper {
  background-color: black;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 560px;
  height: 354px;
  border-radius: 5px;
}

.text-wrapper {
  color: white;
}

.video-likes-text {
  padding-left: 10px;
  color: white;
}
.btn-box {
  margin: 10px 0;
  padding: 0 10px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

.likeBtn {
  border: 0;
  cursor: default;
  background-color: transparent;
}

.bi-heart {
  color: darkgray;
  font-size: 36px;
}

.bi-heart-fill {
  color: red;
  font-size: 36px;
}

.add-wish-btn {
  color: darkgray;
  font-size: 42px;
}

.delete-wish-btn {
  color: sandybrown;
  font-size: 42px;
}

.text-up-box {
  margin-top: -7px;
}

.info-wrapper {
  padding-left: 10px;
  color: darkgray;
}

.info-wrapper-video-title {
  font-size: 20px;
  margin-bottom: 16px;
  color: white;
}

.btn-wrapper {
  margin-top: 30px;
  margin-bottom: 10px;
  margin-left: 465px;
  padding-left: 10px;
}

.create-button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 5px 10px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.create-button:hover {
  background-color: #45a049;
}
</style>

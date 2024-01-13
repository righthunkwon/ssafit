<template>
  <div>
    <div class="item-wrapper" v-if="store.selectedVideo">
      <h4 class="search-list-title">영상 보기</h4>
      <div class="video-container">
        <div class="video-box">
          <iframe
            width="560"
            height="315"
            :src="videoURL"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen
          ></iframe>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import { computed } from "vue";
const store = useYoutubeStore();

const videoURL = computed(() => {
  const videoId = store.selectedVideo.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
});
</script>

<style scoped>
.item-wrapper {
  width: 700px;
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
}

.video-container {
  margin-left: 22px;
  width: 560px;
  border-radius: 5px;
  background-color: black;
  display: flex;
  justify-content: center;
}

.video-box {
  padding-top: 20px;
  padding-bottom: 14px;
}

.search-list-title {
  font-size: 20px;
  margin-left: 21px;
  margin-bottom: 20px;
  color: white;
}
</style>

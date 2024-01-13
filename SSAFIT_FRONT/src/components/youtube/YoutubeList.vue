<template>
  <div>
    <div class="item-wrapper">
      <div class="search-result-container">
        <h4 class="search-list-title">검색 결과</h4>
        <ul>
          <VideoListItem
            v-for="video in store.videos"
            :key="video.id.videoId"
            :video="video"
          />
        </ul>
        <div class="empty-space"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
import VideoListItem from "./YoutubeListItem.vue";

const store = useYoutubeStore();
</script>

<style scoped>
.empty-space {
  height: 65px;
}

.search-list-title {
  font-size: 20px;
  margin-left: 20px;
  margin-top: 3px;
  margin-bottom: 16px;
}
</style>

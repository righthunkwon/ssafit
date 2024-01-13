<template>
  <div class="wrapper">
    <li @click="clickVideo" class="click-element">
      <div class="video-list-box">
        <img :src="video.snippet.thumbnails.default.url" />
        <div class="video-list-item-title" v-html="video.snippet.title"></div>
      </div>
    </li>
  </div>
</template>

<script setup>
import { useYoutubeStore } from "@/stores/youtube";
const store = useYoutubeStore();

const props = defineProps({
  video: {
    type: Object,
    required: true,
  },
});

const clickVideo = function () {
  store.clickVideo(props.video);
};
</script>

<style scoped>
.wrapper {
  margin-left: -14px;
}
.video-list-box {
  display: flex;
  flex-direction: row;
  justify-content: left;
  align-items: center;
  background-color: #343638;
  padding: 5px;
  margin: 8px 0;
}
.video-list-item-title {
  margin-left: 10px;
  margin-right: 120px;
  font-size: 14px;
  color: white;
  text-decoration: none;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}

.click-element:hover {
  cursor: pointer;
}
</style>

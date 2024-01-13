<template>
  <div class="container">
    <div class="most-viewed-container">
      <Carousel :autoplay="2500" :wrap-around="true">
        <Slide v-for="video in store.homeVideoList" :key="video.videoId">
          <div class="carousel__item">
            <div class="video-title-box">{{ video.title }}</div>
            <img
              :src="`http://localhost:9999/image/${video.videoId}.jpg`"
              alt=""
            />
          </div>
        </Slide>
      </Carousel>
    </div>
    <div class="empty-space"></div>
  </div>
</template>

<script setup>
import { Carousel, Slide } from "vue3-carousel";
import "vue3-carousel/dist/carousel.css";
import { onMounted } from "vue";
import { useHomeStore } from "@/stores/home";

const store = useHomeStore();
onMounted(() => {
  store.getHomeVideoList();
});
</script>

<style scoped>
.empty-space {
  height: 20px;
}

.most-viewed-container {
  padding-top: 20px;
  border-radius: 5px;
  background-color: black;
}

.video-title-box {
  font-size: 22px;
  color: white;
  background-color: #000;
}
</style>

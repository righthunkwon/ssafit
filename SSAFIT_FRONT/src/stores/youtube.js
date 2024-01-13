import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

// YOUTUBE API 주소
const YOUTUBE_API = `https://www.googleapis.com/youtube/v3/search`;

export const useYoutubeStore = defineStore("youtube", () => {
  const videos = ref([]);

  const selectedVideo = ref(null);

  const videoSearch = function (keyword) {
    const URL = YOUTUBE_API;
    const API_KEY = import.meta.env.VITE_YOUTUBE_API_KEY;
    axios({
      url: URL,
      method: "GET",
      params: {
        key: API_KEY,
        part: "snippet",
        q: keyword,
        type: "video",
        maxResults: 8,
      },
    })
      .then((response) => {
        videos.value = response.data.items;
      })
      .catch(() => {});
  };
  const clickVideo = function (video) {
    selectedVideo.value = video;
  };
  return { videos, videoSearch, clickVideo, selectedVideo };
});

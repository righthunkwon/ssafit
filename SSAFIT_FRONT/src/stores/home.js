import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

// HOME API 주소
const REST_HOME_API = `http://localhost:9999/api-home`;

export const useHomeStore = defineStore("home", () => {
  // 가장 많이 시청한 영상 조회(다섯 개)
  const homeVideoList = ref([]);

  const getHomeVideoList = function () {
    axios.get(REST_HOME_API).then((response) => {
      homeVideoList.value = response.data;
    });
  };

  return {
    homeVideoList,
    getHomeVideoList,
  };
});

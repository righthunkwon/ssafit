import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

// VIDEO API 주소
const REST_VIDEO_API = `http://localhost:9999/api-video`;
const REST_VIDEO_LIKE_API = `http://localhost:9999/api-video-like`;

export const useVideoStore = defineStore("video", () => {
  // 게시글 조회(전체)
  const videoList = ref([]);
  const getVideoList = function () {
    axios.get(REST_VIDEO_API).then((response) => {
      videoList.value = response.data;
    });
  };

  // 게시글 조회(하나)
  const video = ref({});
  const getVideo = function (videoId) {
    axios.get(`${REST_VIDEO_API}/${videoId}`).then((response) => {
      video.value = response.data;
    });
  };

  // 좋아요 여부 조회(비동기 처리)
  let videoLike = ref(false);
  const getVideoLike = function (currentUserId, videoId) {
    return new Promise((resolve, reject) => {
      axios
        .get(`${REST_VIDEO_LIKE_API}/getLike`, {
          params: {
            userId: currentUserId,
            videoId: videoId,
          },
        })
        .then((response) => {
          if (response.status === 200) {
            videoLike.value = true;
          } else if (response.status === 204) {
            videoLike.value = false;
          }
          resolve(videoLike.value);
        })
        .catch((error) => {
          reject(error);
        });
    });
  };

  const videoLikes = ref(0);
  const getVideoLikes = function (videoId) {
    axios
      .get(`${REST_VIDEO_LIKE_API}/getLikes`, {
        params: {
          videoId: videoId,
        },
      })
      .then((response) => {
        videoLikes.value = response.data;
      })
      .catch((error) => {
        reject(error);
      });
  };

  // 조건 하 검색
  const searchVideoList = function (searchCondition) {
    axios
      .get(`${REST_VIDEO_API}/search`, {
        params: searchCondition,
      })
      .then((response) => {
        videoList.value = response.data;
      });
  };

  // 좋아요
  const sendLikeRequest = function (currentUserId, videoId) {
    let URL = videoLike.value
      ? `${REST_VIDEO_LIKE_API}/addLike`
      : `${REST_VIDEO_LIKE_API}/removeLike`;

    if (!videoLike.value) {
      axios
        .delete(URL, {
          params: {
            userId: currentUserId,
            videoId: videoId,
          },
        })
        .then((response) => {
          if (response.status === 200) {
          } else {
            console.error("API 요청이 실패했습니다.");
          }
        });
    } else {
      axios
        .post(URL, {
          userId: currentUserId,
          videoId: videoId,
        })
        .then((response) => {
          if (response.status === 200) {
          } else {
            console.error("API 요청이 실패했습니다.");
          }
        });
    }
  };

  return {
    videoList,
    getVideoList,
    video,
    getVideo,
    searchVideoList,
    sendLikeRequest,
    getVideoLike,
    videoLike,
    getVideoLikes,
    videoLikes,
  };
});

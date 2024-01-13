import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

// VIDEO API 주소
const REST_WISHLIST_API = `http://localhost:9999/api-wishlist`;

export const useWishlistStore = defineStore("wishlist", () => {
  // 위시리스트 조회(전체)
  const wishlistList = ref([]);
  const wishlist = ref({});

  const getWishlistList = function () {
    axios
      .get(`http://localhost:9999/api-wishlist/selectAllWishlist`)
      .then((response) => {
        wishlistList.value = response.data;
      });
  };

  // 위시리스트 조회 (하나)
  const getWishlist = function (id) {
    axios
      .get(`http://localhost:9999/api-wishlist/showWishlist?userId=${id}`)
      .then((response) => {
        wishlist.value = response.data;
      });
  };

  //위시리스트 추가
  let wishStatus = ref(false);
  const addWishlist = function (currentUserId, videoId) {
    axios
      .post(`${REST_WISHLIST_API}/regist`, {
        userId: currentUserId,
        videoId: videoId,
      })
      .then((response) => {
        wishStatus.value = response.data;
      });
  };

  //위시리스트 삭제
  const deleteWishlist = function (currentUserId, videoId) {
    axios
      .delete(`${REST_WISHLIST_API}/delete`, {
        params: {
          userId: currentUserId,
          videoId: videoId,
        },
      })
      .then((response) => {
        wishStatus.value = response.data;
      });
  };

  return {
    wishlistList,
    getWishlistList,
    wishlist,
    getWishlist,
    addWishlist,
    deleteWishlist,
    wishlistList,
    wishStatus,
  };
});

import { ref } from "vue";
import { defineStore } from "pinia";
import router from "@/router";
import axios from "axios";

// BOARD API 주소
const REST_BOARD_API = `http://localhost:9999/api-review`;

export const useBoardStore = defineStore("board", () => {
  // 게시글 조회(전체)
  const boardList = ref([]);
  const getBoardList = function () {
    axios.get(REST_BOARD_API).then((response) => {
      boardList.value = response.data;
    });
  };

  // 게시글 조회(하나)
  const board = ref({});
  const video = ref({});
  const getBoard = function (id) {
    axios.get(`${REST_BOARD_API}/${id}`).then((response) => {
      board.value = response.data.review;
      video.value = response.data.video;
    });
  };

  // 게시글 등록
  const createBoard = function (board) {
    axios({
      url: REST_BOARD_API,
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      data: board,
    })
      .then(() => {
        router.push({ name: "boardList" });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const updateBoard = function () {
    axios.put(REST_BOARD_API, board.value).then(() => {
      router.push({ name: "boardList" });
    });
  };

  const searchBoardList = function (searchCondition) {
    axios
      .get(`${REST_BOARD_API}/search`, {
        params: searchCondition,
      })
      .then((response) => {
        boardList.value = response.data;
      });
  };

  return {
    boardList,
    getBoardList,
    board,
    video,
    getBoard,
    createBoard,
    updateBoard,
    searchBoardList,
  };
});

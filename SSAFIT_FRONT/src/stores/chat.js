import { ref } from "vue";
import { defineStore } from "pinia";
import axios from "axios";

// Chat API 주소
const REST_CHAT_API = `http://localhost:9999/api-chat`;

export const useChatStore = defineStore("chat", () => {
  // 입력 메세지 처리
  const responseMessage = ref("");
  const sendMessage = function (message) {
    // 호출 막기 위해 임시로 주석처리
    axios
      .post(`${REST_CHAT_API}/sendMessage`, {
        message,
      })
      .then((response) => {
        responseMessage.value = response.data;
      })
      .catch((error) => {
        console.error(error);
      });
  };
  return { sendMessage, responseMessage };
});

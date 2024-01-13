<template>
  <div>
    <div id="chat" class="chat-container item-wrapper">
      <div class="chat-box">
        <div>
          <p class="assistant chat-message">
            검색하고 싶은 운동 부위(가슴, 등, 팔, 어깨, 전신 등)에 대해
            물어봐주세요!
          </p>
          <p v-if="inputMessage" class="chat-message client-chat-message">
            {{ inputMessage }}
          </p>
          <p v-if="store.responseMessage" class="assistant chat-message">
            {{ store.responseMessage }}
          </p>
        </div>
      </div>
      <div id="chat-input" class="chat-input">
        <input
          type="text"
          class="search-input"
          placeholder=" 메시지를 입력하세요..."
          v-model="message"
          @keyup.enter="sendMessage"
        />
        <button class="search-button" @click="sendMessage">입력</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute, useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import { useChatStore } from "@/stores/chat";

const store = useChatStore();
const route = useRoute();
const router = useRouter();

// 메세지
let message = ref("");
let inputMessage = ref("");
let flag = ref(false);

// 기본 메세지 처리
onMounted(async () => {
  if (localStorage.getItem("loginUser") != null) {
    await store.getDefaultMessage();
  } else {
    alert("로그인이 필요한 서비스입니다.");
    router.push({ name: "Login" });
  }
});

const sendMessage = function () {
  inputMessage.value = message.value;
  store.sendMessage(message.value); // 메세지 전달
  message.value = ""; // 메세지 초기화
  store.responseMessage = !store.responseMessage;
};
</script>

<style scoped>
.chat-container {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  margin-top: 20px;
}

.chat-elements button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.chat-elements button:hover {
  background-color: #45a049;
}

.chat-box {
  background-color: #f2f2f2;
  padding: 10px;
  border-radius: 10px;
  margin-bottom: 20px;
  overflow-y: scroll;
  height: 300px;
}

.chat-message {
  background-color: #fff;
  color: #202632;
  font-weight: 600;
  padding: 10px;
  border-radius: 10px;
  margin-bottom: 10px;
}

.client-chat-message {
  text-align: right;
}

.chat-message p {
  margin: 0;
  padding: 0;
}

.chat-input {
  display: flex;
  margin-top: 20px;
}

.search-input {
  flex: 1;
  width: 150px;
  padding: 10px;
  border: none;
  border-radius: 5px;
  margin-right: 10px;
}

.search-button {
  background-color: #4caf50;
  color: #fff;
  border: none;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

.search-button:hover {
  background-color: #45a049;
}

.assistant {
  font-weight: 600;
  font-family: "Noto Sans KR", sans-serif;
  color: dodgerblue;
}
</style>

<template>
  <div class="container">
    <!-- item 1 -->
    <div class="item-wrapper">
      <div class="navigation-box">
        <h2 class="service-title">인공지능 운동 추천 서비스, SSAFIT</h2>
        <div class="service-text">
          당신만을 위한 운동, 이제 운동 전문가 인공지능 SSAFIT에 맡기세요.
        </div>
        <div class="function-wrapper">
          <div class="function-box">
            <div>
              <div
                @click="switchComponent('1')"
                class="function-box-item function-box-item-1"
              >
                <div class="function-icon-box">
                  <i class="bi bi-robot"></i>
                </div>
              </div>
              <div class="function-box-item-text">AI 추천</div>
            </div>
            <div>
              <div
                @click="switchComponent('2')"
                class="function-box-item function-box-item-2"
              >
                <div class="function-icon-box">
                  <i class="bi bi-youtube"></i>
                </div>
              </div>
              <div class="function-box-item-text">영상목록</div>
            </div>
            <div>
              <div
                @click="switchComponent('3')"
                class="function-box-item function-box-item-3"
              >
                <div class="function-icon-box">
                  <i class="bi bi-pencil-square"></i>
                </div>
              </div>
              <div class="function-box-item-text">후기목록</div>
            </div>
            <div>
              <div
                @click="switchComponent('4')"
                class="function-box-item function-box-item-4"
              >
                <div class="function-icon-box">
                  <i class="bi bi-bookmark-heart"></i>
                </div>
              </div>
              <div class="function-box-item-text">즐겨찾기</div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- item 2 -->
    <div class="item-wrapper">
      <div class="most-viewed-video-box">
        <h2 class="most-viewed-video-box-title">가장 많이 시청한 영상</h2>
        <RouterView />
      </div>
    </div>
    <div class="empty-space"></div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";
const router = useRouter();

const switchComponent = (itemNum) => {
  let path;
  switch (itemNum) {
    case "1":
      path = "/youtube";
      break;
    case "2":
      path = "/video";
      break;
    case "3":
      path = "/board";
      break;
    case "4":
      path = "/wishlist";
      break;
    default:
      path = "/";
  }

  router.push(path);
};
</script>

<style>
.item-wrapper {
  margin-top: 20px;
  background-color: #272829;
  border-radius: 5px;
  padding: 15px;
}

.function-wrapper {
  width: 600px;
  display: flex;
  flex-direction: row;
  justify-content: center;
}
.service-title {
  color: white;
  margin-bottom: 10px;
}

.service-text {
  color: darkgray;
  margin-bottom: 45px;
}

.navigation-box {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.function-box {
  width: 65vw;
  max-width: 1050px;
  display: flex;
  flex-direction: row;
  justify-content: space-evenly;
}

.function-box-item {
  width: 70px;
  height: 70px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  cursor: pointer;
  border-radius: 5px;
  box-shadow: 3px 3px 3px 3px rgb(28, 28, 28);
  color: #02bf53;
}

.function-box-item:hover {
  opacity: 1;
  -webkit-animation: flash 1.5s;
  animation: flash 1.5s;
  transition: transform 0.3s ease-in-out;
}
@-webkit-keyframes flash {
  0% {
    opacity: 0.4;
  }
  100% {
    opacity: 1;
  }
}
@keyframes flash {
  0% {
    opacity: 0.4;
  }
  100% {
    opacity: 1;
  }
}

.function-box-item-1 {
  background-color: #343638;
  color: cornflowerblue;
}

.function-box-item-2 {
  background-color: #343638;
  color: red;
}

.function-box-item-3 {
  background-color: #343638;
  color: #00a949;
}

.function-box-item-4 {
  background-color: #343638;
  color: rgb(228, 155, 91);
}

.function-box-item-text {
  margin-top: 10px;
  color: white;
  text-align: center;
  font-size: 14px;
}

.function-icon-box {
  font-size: 32px;
  max-width: 180px;
}

.function-text-box {
  margin-top: 20px;
  height: 60px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-size: 24px;
  font-weight: 600;
}

.most-viewed-video-box {
  margin-top: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.most-viewed-video-box-title {
  color: white;
  margin-bottom: 30px;
}

.empty-space {
  height: 100px;
}
</style>

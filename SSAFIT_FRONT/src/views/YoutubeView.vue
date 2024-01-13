<template>
  <div class="container">
    <div class="entire-container">
      <div class="search-container">
        <YoutubeSearch />
        <hr />
        <YoutubeDetail />
        <hr />
      </div>
      <div class="main-container">
        <div class="youtube-container">
          <YoutubeList />
        </div>
        <div class="chat-container">
          <Chat />
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import YoutubeSearch from "@/components/youtube/YoutubeSearch.vue";
import YoutubeList from "@/components/youtube/YoutubeList.vue";
import YoutubeDetail from "../components/youtube/YoutubeDetail.vue";
import Chat from "../components/chat/Chat.vue";
</script>

<style scoped>
.entire-container {
  display: flex;
  flex-direction: column;
  /* background-color: blue; */
}

.main-container {
  display: flex;
  flex-direction: row;
}

.youtube-container {
  width: 700px;
  min-width: 400px;
  margin-right: 20px;
  color: white;
}

.chat-container {
  min-width: 296px;
  width: 350px;
}
</style>

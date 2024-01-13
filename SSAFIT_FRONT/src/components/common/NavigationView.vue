<template>
  <div id="container">
    <header>
      <nav>
        <RouterLink to="/" class="nav-menu">홈페이지</RouterLink>
        <RouterLink to="/youtube" class="nav-menu"
          >인공지능 추천운동</RouterLink
        >
        <RouterLink to="/video" class="nav-menu">전체 영상</RouterLink>
        <RouterLink :to="{ name: 'boardList' }" class="nav-menu"
          >최신 후기</RouterLink
        >
        <RouterLink to="/wishlist" class="nav-menu">즐겨찾기</RouterLink>
      </nav>
    </header>
  </div>
</template>

<script setup></script>

<style scoped>
#container {
  text-align: center;
}

nav {
  padding: 30px;
  color: white;
  margin-top: -10px;
  white-space: nowrap;
}

nav a {
  text-decoration: none;
  margin-right: 30px;
  font-size: 16px;
}

nav a.router-link-exact-active {
  color: #02bf53;
}

.nav-menu:hover {
  color: darkgray;
}
</style>

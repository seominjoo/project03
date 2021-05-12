<template>
  <div class="header-nav">
    <router-link class="header-nav__logo" to="/">  
      <img alt="Logo" src="../assets/image/logo.png" class="header-nav__logo-img">
    </router-link>
    <div v-if="!isAuth" class="header-nav__items">
      <router-link to="/login" class="header-nav__item">Sign in</router-link>
      <router-link to="/join" class="header-nav__item">Sign up</router-link>
    </div>
    <div v-if="isAuth" class="header-nav__items">
      <router-link to="/mypage" class="header-nav__item">My page</router-link>
      <a v-on:click="logout" class="header-nav__item">Logout</a>
    </div>
  </div>
</template>

<script>
// import axios from '@/api'
import { mapGetters, mapActions } from 'vuex'

export default {
  computed: {
    ...mapGetters(['isAuth']),
  },
  methods: {
    ...mapActions(['account', 'postLogout']),
    logout() {
      this.postLogout();
      alert('로그아웃 성공!');
      
    },
  }
}
</script>

<style scoped>
.header-nav {
  padding: 10px 20px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.header-nav__logo {
  height: 40px;
  width: 40px;
}
.header-nav__logo-img {
  height: 100%;
  object-fit: contain;
}
.header-nav__item {
  margin-right: 10px;
  cursor: pointer;
}
.header-nav__item:last-child {
  margin-right: 0;
}
</style>
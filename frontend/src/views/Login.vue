<template>
  <div class="login">
    <form v-on:submit.prevent="submitLoginForm" class="login__form">
      <h2 class="login__header">LOGIN</h2>
      <div class="login__input-box">
        <label for="password">Username</label>
        <input type="text" autocomplete="off" v-model="username">
      </div>
      <div class="login__input-box">
        <label for="password">Password</label>
        <input type="password" autocomplete="new-password" v-model="password">
      </div>
      <button type="submit" class="login__submit-btn">Login</button>
    </form>
  </div>
</template>

<script>
import router from '@/router'
import { mapGetters, mapActions } from 'vuex'

export default {
  data: function() {
    return {
      username: '',
      password: '',
    }
  },
  computed: {
    ...mapGetters(['isAuth']),
  },
  methods: {
    ...mapActions(['account', 'postLogin']),
    submitLoginForm() {      
      this.postLogin({ username: this.username, password: this.password })
        .then(function() {
          alert('로그인 성공');
          router.push('/');
        })
        .catch(function() {
          alert('로그인 실패');
        });

    }
  }
}
</script>

<style scoped>
.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
  width: 100%;
  background-color: #f5f5f5;
}
.login__form {
  padding: 40px 30px;
  background-color: white;
  border-radius: 6px;
}
.login__header {
  margin-bottom: 40px;
  text-align: center;
  font-size: 30px;
  font-weight: 900;
}
.login__input-box {
  margin-bottom: 20px;
}
.login__input-box label {
  font-size: 14px;
  font-weight: 100;
}
.login__input-box input {
  display: block;
  margin-top: 6px;
  width: 260px;
  padding: 6px;
}
.login__submit-btn {
  width: 100%;
  margin-top: 25px;
  padding: 6px;
}
</style>
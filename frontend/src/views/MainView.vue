<template>
  <div>
    <h1>main</h1>
    <button v-on:click="test">TEST</button>
  </div>
</template>

<script>
import axios from '../api'

export default {
  methods: {
    test: function() {
      axios.get("/")
        .then(function(response) {
          console.log(response.status);
        })
        .catch(function(error) {
          console.log(error);
        })
    }
  }
}
</script>

<style>

</style>
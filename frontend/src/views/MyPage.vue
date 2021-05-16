<template>
  <div>
    {{ this.$store.state.account.username }}
    <UserImage v-bind:uid="getUid" :size="200"></UserImage>
  </div>
</template>

<script>
import { mapGetters } from 'vuex';
import UserImage from '@/components/common/UserImage.vue';

export default {
  components: {
    UserImage,
  },
  computed: {
    ...mapGetters(['getUid']),
  }
}
</script>

<style>

</style>
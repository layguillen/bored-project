<template>
  <div class="home">
    <h1>Your saved activities:</h1>
    <HomeContent />
  </div>
</template>

<script>
// @ is an alias to /src
import HomeContent from '@/components/HomeContent.vue';

export default {
  name: 'HomeView',
  components: {
    HomeContent
  }
}
</script>

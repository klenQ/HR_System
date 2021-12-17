<template>
  <div>
    这是ViewP组件
    <router-link to="/viewa">ViewA</router-link>
    <router-link to="/viewb">ViewB</router-link>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "ViewP"
}
</script>

<style scoped>

</style>
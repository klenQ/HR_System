<template>

  <div id="container">
    <div>
      {{message}}
    </div>
    <button @click="change">ClickMe</button>
  </div>
</template>

<script>
export default {
name: "A",
  data(){
    return{
      message: "Hello I am component A"
    }
  },
  methods: {
    change: function () {
      this.message = "Hello, this is component A"
    }
  }
}
</script>

<style scoped>
  #container{
    width: 800px;
    margin: 10px auto;
  }
</style>
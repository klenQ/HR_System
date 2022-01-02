import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import axios from 'axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import Qs from 'qs'
import store from './store'//引入store
import tools from "./util/tools";

Vue.prototype.tools = tools
Vue.prototype.qs = Qs
Vue.config.productionTip = false;
Vue.prototype.axios = axios;
Vue.use(ElementUI);
new Vue({
  router,store,
  render: h => h(App)
}).$mount("#app");

axios.interceptors.request.use(function (config){

  if(localStorage.token){
    config.headers.Authorization = localStorage.token
  }
  return config;
}, function (error){
  console.log("interceptor error",error)
});

axios.interceptors.response.use(function(response){

  if(response.data.code == 0){
    Vue.prototype.$message({
      message: "No login",
      type: 'error',
      duration: 2000
    });
  }else if(response.data.code == 1){
    Vue.prototype.$message({
      message: "Login Success",
      type: 'success',
      dutation: 2000
    });
  }else if(response.data.code == 2){
    Vue.prototype.$message({
      message: "Login Failed",
      type: 'error',
      duration: 2000
    });
  }else if(response.data.code==3){
    Vue.prototype.$message({
      message: "Not authorized",
      type: 'error',
      duration: 2000
    });
  }
  return response;
},
function(error){
  if(error.response.data.status==404){
    Vue.prototype.$message({
      message: '404, cannnot find the page',
      type: 'error',
      duration: 2000
    });

  }else if(error.response.data.status==5000){
    Vue.prototype.$message({
      message: "500, Internal error",
      type: "error",
      duration: 2000
    });
  }
});
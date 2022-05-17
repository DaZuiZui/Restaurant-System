import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Axios from 'axios'
//导入路由
import store from './store/index'
import router from './router'
Vue.config.productionTip = false
Vue.use(ElementUI);

Vue.config.silent = true
Axios.defaults.baseURL="http://127.0.0.1:8989"
Vue.prototype.$axios = Axios


new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')

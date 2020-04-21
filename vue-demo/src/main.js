import Vue from 'vue'

import Cookies from 'js-cookie'



import Element from 'element-ui'

import './styles/element-variables.scss'
// global css
import './styles/index.scss'
import App from './App'

import router from './router'
import store from '@S'

import axios from 'axios'
Vue.prototype.$axios = axios
axios.defaults.baseURL = '/api'
//解决方案
import vuex from 'vuex'
import './router/index' // permission control

Vue.use(Element, {
  size: Cookies.get('size') || 'small' // set element-ui default size
})

Vue.config.productionTip = false

new Vue({
  el: '#app',
  router,
  store,  
  render: h => h(App)
})

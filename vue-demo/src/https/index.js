import axios from "axios";
import store from '@S'
const router = require(`@R`).default;


const merge = require('webpack-merge')

const Axios = axios.create({
  baseURL: process.env.BASE_API,
  timeout: 30*60000,
  headers: {
    "Content-Type": "application/x-www-form-urlencoded;charset=utf-8"
    // "Content-Type": "application/json"
  }
});

const object2body = params => {
  let ret = [];
  for (let key in params) {
    key = encodeURIComponent(key);
    let values = params[key];
    if (values && values.constructor == Array) {
      let queryValues = [];
      for (let i = 0, len = values.length, value; i < len; i++) {
        value = values[i];
        queryValues.push(object2Pair(key, value));
      }
      ret = ret.concat(queryValues);
    }
    else {
      ret.push(object2Pair(key, values))
    }
  }

  return ret.join('&')
}

const object2Pair = (key, value) => {
  if (typeof value == 'undefined') {
    return key;
  }
  else if (typeof value == 'object') {
    value = JSON.stringify(value)
  }
  return key + '=' + encodeURIComponent(value === null ? '' : String(value));
}

Axios.interceptors.request.use(
  config => {


    //入参注入access_token && refresh_token
    if (store.state.auth.access_token) {
      config.data = merge(config.data, {access_token: store.state.auth.access_token});
      config.headers.refresh_token = store.state.auth.refresh_token;
    }
    // console.log("入参拦截："+config.url,config);

    //loading
    store.dispatch('CHANGE_LOADING', {
      loadingFlag: true
    });

    //入参格式转form表单
    config.data = object2body(config.data);

    return config;
  },
  error => error
);

Axios.interceptors.response.use(
  response => {
    // console.log("出参拦截",response);
    if (response.headers.access_token && response.headers.refresh_token) {
      store.dispatch('SET_TOKEN', {
        access_token: response.headers.access_token,
        refresh_token: response.headers.refresh_token
      });

    }
    //loading
    store.dispatch('CHANGE_LOADING', {
      loadingFlag: false
    });

    return response
  },
  error => {
    // console.log("错误拦截",error.response);

    if (error.response.status == 401) {
      store.dispatch('REMOVE_TOKEN');
      if (!this.access_token) {
        router.push('/')
      }
    }
  }
);

export default {
  //get请求
  get(url,params) {
    return new Promise(
      (resolve, reject) => {
        Axios.get(url, params)
          .then(
            response => resolve(response),
            error => reject(error)
          )
      }
    )
  },

  //post请求
  post(url, param) {
    return new Promise(
      (resolve, reject) => {
        Axios.post(url, param)
          .then(
            response => resolve(response),
            error => reject(error)
          )
      }
    )
  }


}


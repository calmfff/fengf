<template>
  <div class="login">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" label-position="left" label-width="0px" class="login-form">
      <h3 class="title">
        EL-ADMIN 后台管理系统
      </h3>
      <el-form-item prop="username">
        <el-input v-model="loginForm.username" type="text" auto-complete="off" placeholder="账号">
          <svg-icon slot="prefix" icon-class="user" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input v-model="loginForm.password" type="password" auto-complete="off" placeholder="密码" @keyup.enter.native="handleLogin">
          <svg-icon slot="prefix" icon-class="password" class="el-input__icon input-icon" />
        </el-input>
      </el-form-item>
    
      <el-checkbox v-model="loginForm.rememberMe" style="margin:0 0 25px 0;">
        记住我
      </el-checkbox>
      <el-form-item style="width:100%;">
        <el-button :loading="loading" size="medium" type="primary" style="width:100%;" @click.native.prevent="selectUser" >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
        <router-link to="/mindex" class="f">进入管理员界面</router-link>

        <router-link to="/user" class="s">进入用户界面</router-link>
      </el-form-item>
    </el-form>
    <!--  底部  -->
    <div  id="el-login-footer">
      
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie'
 import $post from '@H'
export default {
    
  name: 'Login',
  data() {
    return {
      codeUrl: '',
      cookiePass: '',
      loginForm: {
        username: '',
        password: '',
        rememberMe: false,
        code: '',
        uuid: ''
      },
      loginRules: {
        username: [{ required: true, trigger: 'blur', message: '用户名不能为空' }],
        password: [{ required: true, trigger: 'blur', message: '密码不能为空' }],
        code: [{ required: true, trigger: 'change', message: '验证码不能为空' }]
      },
      loading: false,
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  created() {
  
  },
  methods: {
    go(){
      this.$router.push('/user')
    },

    selectUser(){
      let params = {
        name:'刘韵哲'
      }
      $post.post('user/selectUser',params).then(res =>{
        console.log(res)
      })
      
    },
    handleLogin() {
      let params={
        loginName:this.loginForm.username,
        password: this.loginForm.password

      }
      debugger
      $post.post('user/login',params).then(res => {
        if(res.data.code==200){
           this.$router.push({ path: this.redirect || '/user', query: res.data.data })
          console.log('succ')
        }
      });
    //   this.$refs.loginForm.validate(valid => {
    //     const user = {
    //       username: this.loginForm.username,
    //       password: this.loginForm.password,
    //       rememberMe: this.loginForm.rememberMe,
    //       code: this.loginForm.code,
    //       uuid: this.loginForm.uuid
    //     }
    //     if (user.password !== this.cookiePass) {
    //       user.password = encrypt(user.password)
    //     }
    //     if (valid) {
    //       this.loading = true
    //       if (user.rememberMe) {
    //         Cookies.set('username', user.username, { expires: Config.passCookieExpires })
    //         Cookies.set('password', user.password, { expires: Config.passCookieExpires })
    //         Cookies.set('rememberMe', user.rememberMe, { expires: Config.passCookieExpires })
    //       } else {
    //         Cookies.remove('username')
    //         Cookies.remove('password')
    //         Cookies.remove('rememberMe')
    //       }
    //       this.$store.dispatch('Login', user).then(() => {
    //         this.loading = false
    //         this.$router.push({ path: this.redirect || '/' })
    //       }).catch(() => {
    //         this.loading = false
    //         this.getCode()
    //       })
    //     } else {
    //       console.log('error submit!!')
    //       return false
    //     }
    //   })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss">
  .login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image:url(https://api.isoyu.com/bing_images.php);
    background-size: cover;
  }
  .title {
    margin: 0 auto 30px auto;
    text-align: center;
    color: #707070;
  }

  .login-form {
    border-radius: 6px;
    background: #ffffff;
    width: 385px;
    padding: 25px 25px 5px 25px;
    .el-input {
      height: 38px;
      input {
        height: 38px;
      }
    }
    .input-icon{
      height: 39px;width: 14px;margin-left: 2px;
    }
  }
  .login-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
  }
  .login-code {
    width: 33%;
    display: inline-block;
    height: 38px;
    float: right;
    img{
      cursor: pointer;
      vertical-align:middle
    }
  }
  .f{
    left: 0;
    color: #707070;
  }
  .s{
    right: 0;
    color: #707070;
  }
</style>

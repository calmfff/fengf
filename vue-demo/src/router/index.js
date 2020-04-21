import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'


//第三方库需要use一下才能用
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name:'Login',
      component: () => import('@/view/login/index'),
      hidden: true,
      //登录界面
     } ,
    {
      path: '/user',
      name: 'user',
      component: () => import('@/view/manage/user/index'),
      hidden: true
      //用户界面
     },
     {
      path: '/mindex',
      name:'mindex',
      component: () => import('@/view/manage/manager/index'),
      hidden: true  
      //管理员界面的首页 
     },
     {
      path: '/mana',
      name:'mana',
      component: () => import('@/view/manage/manager/mana'),
      hidden: true
      //管理员界面的管理员管理
     },
     {
      path: '/muser',
      name:'muser',
      component: () => import('@/view/manage/manager/muser'),
      hidden: true
      //管理员界面的用户管理
     }
  ]
})

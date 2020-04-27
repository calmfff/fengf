<template>
    <el-aside>
    <el-menu :default-openeds="['1', '6']">
       
        <el-menu-item index="1" @click="menu1"><i class="el-icon-star-on"></i>首页</el-menu-item>      
        <el-menu-item index="2" @click="menu2"><i class="el-icon-star-on"></i>管理员管理</el-menu-item>
        <el-menu-item index="3" @click="menu3"><i class="el-icon-star-on"></i>用户管理</el-menu-item>
        <el-menu-item index="4" @click="menu4"><i class="el-icon-star-on"></i>投票信息管理</el-menu-item>
        <el-menu-item index="5" @click="menu5"><i class="el-icon-star-on"></i>科研成果信息管理</el-menu-item>
        <el-submenu index="6">
           <template slot="title"><i class="el-icon-star-on"></i>系统设置</template> 
           <el-menu-item-group>      
              <el-menu-item index="1-1" @click="menu6">修改密码</el-menu-item>
              <el-menu-item index="1-2" @click="menu7">修改个人资料</el-menu-item>
           </el-menu-item-group>      
        </el-submenu>

    </el-menu>
  </el-aside>
</template>

<style>
.el-aside {
    color: #333;
  }



</style>

<script>
import Msg from './msg.js'
export default {
    methods:{
        menu1:function(){
            //传值效果:将1的值传给a，触发on事件，on事件在bottom中
            Msg.$emit("var","1");
        },
        menu2:function(){
            Msg.$emit("var","2");
        },
        menu3:function(){
            Msg.$emit("var","3");
        },
        menu4:function(){
            Msg.$emit("var","4");
        },
        menu5:function(){
            Msg.$emit("var","5");
        },
        menu6:function(){
            Msg.$emit("var","6");
        },
        menu7:function(){
            Msg.$emit("var","7");
        }
    }
}
</script>
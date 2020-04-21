<template>
   <el-container style="height: 500px; border: 1px solid #eee">
  <el-aside width="300px" style="background-color: rgb(238, 241, 246)" >
    <el-menu :default-openeds="['1', '2']">
      <el-submenu index="1">
        <template slot="title"><i class="el-icon-message"></i>个人管理</template>
        <el-menu-item-group>
          
          <el-menu-item index="1-1">个人信息</el-menu-item>
          <el-menu-item index="1-2">修改密码</el-menu-item>
        </el-menu-item-group>
       
      
      </el-submenu>
      <el-submenu index="2">
        <template slot="title"><i class="el-icon-menu"></i>投票信息</template>
        <el-menu-item-group>
          
          <el-menu-item index="1-1">评优</el-menu-item>
          <el-menu-item index="1-2">验收</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
  
    </el-menu>
  </el-aside>
  
  <el-container>
    <el-header style="text-align: right; font-size: 12px">
      <el-dropdown>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>注销</el-dropdown-item>
          <el-dropdown-item>刷新</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <span>此处添加用户名</span>
      <button @click="go">点我跳转</button>
    </el-header>
    
    <el-main>
      <el-table :data="tableData">
        <el-table-column prop="tid" label="编号" width="140">
        </el-table-column>
        <el-table-column prop="ttitle" label="主题" width="120">
        </el-table-column>
        <el-table-column prop="ttype" label="类型">
        </el-table-column>
      </el-table>
    </el-main>
  </el-container>
</el-container>



</template>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
  }
  
  .el-aside {
    color: #333;
  }
</style>


<script>
  export default {
    name:'user',
    methods:{
      go(){
        this.$router.push('/mindex')
      }
    },
    data() {
      const item = {
        tid:'冯冯冯',
        ttitle: '靖王妃feng',
        ttype: '王凯我爱你！',
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };

</script> 
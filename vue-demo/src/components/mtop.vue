<template>
    <div class="mtop">
         <p class="hi">欢迎进入管理员界面</p>
         <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
            <el-dropdown-item>注销</el-dropdown-item>
            <el-dropdown-item>刷新</el-dropdown-item>
            </el-dropdown-menu>
        </el-dropdown>
                <span>此处添加管理员名</span>
          </div>
</template>

<script>
export default {
    
}
</script>

<style>
.hi{
    color:rgb(14, 13, 9);
    letter-spacing: 2em;
    text-align: center;
    margin-top: 5px;
    
  }
 
</style>
<template>
    <div>
        <div v-if="aa==1">
            <img src="../assets/img/index.jpg" class="img1">
        </div>
        <div v-else-if="aa==2">           
            <el-table data="tableData" style="width: 100%">
               <el-table-column label="编号" width="180">
                      <template slot-scope="scope">
                      <i class="el-icon-time"></i>
                      <span style="margin-left: 10px">{{ scope.row.date }}</span>
                      </template>
               </el-table-column>
               <el-table-column label="管理员ID" width="180">
                      <template slot-scope="scope">
                      <i class="el-icon-time"></i>
                      <span style="margin-left: 10px">{{ scope.row.date }}</span>
                      </template>
               </el-table-column>
               <el-table-column label="管理员名"  width="180">
                      <template slot-scope="scope">
                      <el-popover trigger="hover" placement="top">
                        <p>姓名: {{ scope.row.name }}</p>
                        <p>住址: {{ scope.row.address }}</p>
                        <div slot="reference" class="name-wrapper">
                        <el-tag size="medium">{{ scope.row.name }}</el-tag>
                        </div>
                      </el-popover>
                      </template>
              </el-table-column>
             <el-table-column label="操作">
                     <template slot-scope="scope">
                        <el-button size="mini"  @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                        <el-button size="mini"  type="danger"  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                     </template>
             </el-table-column>
            </el-table>
        </div>
        <div v-else-if="aa==3">
            <el-table :data="tableData">
                 <el-table-column prop="date" label="用户编号" width="140"></el-table-column>
                 <el-table-column prop="name" label="用户名" width="120"></el-table-column>
                 <el-table-column prop="address" label="用户密码"></el-table-column>
              </el-table>
        </div>
        <div v-else-if="aa==4">
            <el-table :data="tableData">
                 <el-table-column prop="date" label="投票题目" width="140"></el-table-column>
                 <el-table-column prop="name" label="投票状态" width="120"></el-table-column>
                 <el-table-column prop="address" label="投票题目类型"></el-table-column>
              </el-table>
        </div>
        <div v-else-if="aa==5">
            <el-table :data="tableData">
                 <el-table-column prop="date" label="科研成果编号" width="140"></el-table-column>
                 <el-table-column prop="name" label="简介" width="120"></el-table-column>
                 <el-table-column prop="address" label="作者"></el-table-column>
              </el-table>
        </div>
        <div v-else-if="aa==6">
            666
        </div>
        <div v-else-if="aa==7">
            777
        </div>
        <div v-else>
            <img src="../assets/img/index.jpg" class="img1">
        </div>

    </div>
</template>

<style>

</style>

<script type="text/javascript">
import Msg from './msg.js'
export default {
    data(){
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
        return{
            aa:0,
            tableData:[{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }]
        }
        
    },
    //接收
    mounted:function(){
        var _this=this
        //将var交给m进行处理
        Msg.$on('var',function(m){
            _this.aa=m;
        })
    },
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    }
}
</script>


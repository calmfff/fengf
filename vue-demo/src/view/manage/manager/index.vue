<template>
    
    <div class="mmain">
      <div class="mleft">
        <mleft></mleft>
      </div>
      <div class="mright">
           <div class="mtop">
               <mtop></mtop>
           </div>
          <div class="mbuttom">
              <mbottom></mbottom>
          </div>
      </div>

    </div>

</template>

<style>
  .mright{
    width: 1000px;
    float: left;
    margin-left: 10px;
    margin-top: -5px;
  }
  .mleft {
    width: 300px;
    float: left;
    margin-left: 10px;
    margin-top: 10px;
    
  }
  .main{
    width: 1200px;
    margin: 20px auto;
  }
  .mtop{
    height: 60px;
    width: 1000px;   
  }
  .mleft,.mtop{
    background-color:#C0C4CC;
  }
 
  
</style>

<script>
  import mleft from '../../../components/mleft.vue'
  import mtop from '../../../components/mtop.vue'
  import mbottom from '../../../components/mbottom.vue'
  //引用的效果
  export default {
    //对所需要引用的组件进行注册
      components:{
        mleft,
        mtop,
        mbottom
      },
    data() {
      const item = {
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      };
      return {
        tableData: Array(20).fill(item)
      }
    }
  };
</script>
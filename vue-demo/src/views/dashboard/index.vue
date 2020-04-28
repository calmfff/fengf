<template>
  <div class="dashboard-container">
    <div class="dashboard-text">name: {{ name }}</div>

    <el-row>
      <el-col :span="8" class="col-card" style="padding-left: 10px;">
        <el-card class="box-card" style="  height: 400px;">
          <div slot="header" class="clearfix">
            <span>日历</span>
          </div>
          <Calendar ref="Calendar"></Calendar>
        </el-card>
      </el-col>
      <el-col :span="8" class="col-card" style="padding-left: 10px;">
        <el-card class="box-card" style="  height: 400px;">
          <div slot="header" class="clearfix">
            <span>科研信息</span>
          </div>
          <!-- <el-calendar v-model="value"></el-calendar> -->
        </el-card>
      </el-col>
      <el-col :span="8" class="col-card" style="padding-left: 10px;">
        <el-card class="box-card" style="  height: 400px;">
          <div slot="header" class="clearfix">
            <span>投票信息</span>
          </div>
          <!-- <el-calendar v-model="value"></el-calendar> -->
        </el-card>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12" class="col-card" style="padding-left: 10px;">
        <el-card class="box-card" style="  height: 400px;">
          <div slot="header" class="clearfix">
            <span>投票数据</span>
          </div>
          <schart class="schart" canvasId="bar" :options="options1" style="height: 300px;"></schart>
        </el-card>
      </el-col>
      <el-col :span="12" class="col-card" style="padding-left: 10px;">
        <el-card class="box-card" style="  height: 400px;">
          <div slot="header" class="clearfix">
            <span>投票数据</span>
          </div>
          <schart class="schart" canvasId="pie" :options="options3" style="height: 300px;"></schart>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import Calendar from "@/components/vue-calendar-component/src/calendar.vue"; //引入vue日历
import Schart from "vue-schart";
export default {
  name: "Dashboard",
  computed: {
    ...mapGetters(["name"])
  },
  components: {
    Calendar,
    Schart
  },
  data() {
    return {
      value: new Date(),
      options1: {
        type: "bar",
        title: {
          text: "2019年科研成果评优结果图"
        },
        bgColor: "#fbfbfb",
        labels: ["大数据科研", "投票系统", "人脸识别", "智能交通", "安全支付"],
        datasets: [
          {
            label: "优秀",
            fillColor: "rgba(241, 49, 74, 0.5)",
            data: [234, 278, 270, 190, 230]
          },
          {
            label: "良好",
            data: [164, 178, 190, 135, 160]
          },
          {
            label: "一般",
            data: [144, 198, 150, 235, 120]
          }
        ]
      },
      options3: {
        type: "pie",
        title: {
          text: "科研成果验收通过率占比"
        },
        legend: {
          position: "left"
        },
        bgColor: "#fbfbfb",
        labels: ["通过", "评审中", "未通过" ],
        datasets: [
          {
            data: [334, 278, 190]
          }
        ]
      }
    };
  }
};
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both;
  }
  .box-card {
    width: 480px;
    height: 480px;
  }
  .col-card {
    padding-left: 10px;
  }

  /*今天*/
  .wh_content_item .wh_isToday[data-v-2ebcbc83] {
    background-color: rgb(139, 175, 241);
  }
  /*日历点击*/
  .wh_content_item .wh_chose_day[data-v-2ebcbc83] {
    background-color: transparent;
  }
  /*日历划过*/
  .wh_item_date[data-v-2ebcbc83]:hover {
    background-color: rgb(111, 223, 223);
    border-radius: 100%;
  }
  .wh_content_all {
    background-color: rgb(111, 223, 223);
  }
  .wh_top_changge li[data-v-2ebcbc83] {
    color: #000;
  }
  .schart {
    width: 100%;
    height: 400px;
  }
}
</style>

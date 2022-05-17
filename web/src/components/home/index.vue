<template>
<div>
  <el-carousel indicator-position="outside">
    <el-carousel-item v-for="item in marquee" :key="item">
      <div style="margin-left: 25%;height: 50% ;width: 50%">
        <el-image :src="item.image"></el-image>
      </div>
    </el-carousel-item>
  </el-carousel>


  <el-card shadow="hover">
    今日热搜
    <div style="margin-top: 3%;margin-left: 10%;margin-right: 15%">
      <el-row>
        <el-col :span="8" v-for="itme in top3">
          <div class="grid-content bg-purple" style="margin-right: 3%;margin-top: 2%">
            <Image_Card  :image="itme.image" :title="itme.menu" :id="itme.menuId" :details="itme.introduce"></Image_Card>
          </div>
        </el-col>
      </el-row>
    </div>
  </el-card>
  <br>
  <div>

    <div style="margin-top: 5%"></div>
    <el-collapse>

      <el-collapse-item title="今日三餐" name="1">

         <div style="margin-top: 3%">
      <el-row>
        <el-col :span="6" v-for="(article,index) in arraylist" :key="index">
          <div class="grid-content bg-purple" style="margin-right: 3%;margin-top: 2%">
            <Image_Card :image="article.image" :id="article.menuId" :details="article.introduce"></Image_Card>
          </div>
        </el-col>
      </el-row>
    </div>
      </el-collapse-item>
    </el-collapse>
  </div>
  <br>
  <br>
  <div>
    <span style="margin-bottom: 20px ; text-align: center"> 口味推荐</span>

    <div style="margin-top: 3%">
      <el-row>
        <el-col :span="6" v-for="(article,index) in arraylist1" :key="index">
          <div class="grid-content bg-purple" style="margin-right: 3%;margin-top: 2%">
            <Image_Card :image="article.image" :id ="article.menuId" :title="article.menu" :details="article.introduce"></Image_Card>
          </div>
        </el-col>
      </el-row>
    </div>
  </div>
  <br>
</div>
</template>

<script>
import tday from "@/components/home/tday";
import Image_Card from "@/components/widget/image_card";
export default {
  name: "index",
  data () {
    return {
      radio1:' ',
      marquee:[
        {
          image:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
          menu_id:''
        },
      ],
      top3:[
        {
          image:'https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png',
          menu_id:''
        }
      ],
      day3:true,
      arraylist: null,
      arraylist1: null,
    }
  },
  methods: {
    getMarquee(){
      this.$axios.get('/menu/rand').then(res=>{
        // this.$message.success("??/")
        // console.log(res.data)
        this.marquee = res.data
      })
    },
    topSearch(){
      this.$axios('/getqiansan').then(res=>{
        console.log(res.data)
        this.top3 = res.data
      })
    }
  },
  components:{
    tday,
    Image_Card
  },
  watch:{
    radio1(){
      this.$message.success("更新了")
    }
  },
  created() {
    this.getMarquee();
    this.topSearch();
    //获取今日三餐
    this.$axios.get("http://127.0.0.1:8989/menu/rand")
    .then(res => {
      // console.log(res.data)
        this.arraylist1 =res.data;
    })

    this.$axios.get("http://127.0.0.1:8989/menu/tjsfzzw")
    .then(res => {
        this.arraylist =res.data;
    })
  }
}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #ffffff;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #ffffff;
}
</style>

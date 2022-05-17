<template>
<div>
  <template >
    <div>
      <div style="margin-top: 3%;">
        口味:&nbsp;
        <el-radio-group v-model="radio1">
          <el-radio-button label="甜"></el-radio-button>
          <el-radio-button label="酸"></el-radio-button>
          <el-radio-button label="辣"></el-radio-button>
        </el-radio-group>
      </div>
      <div style="margin-top: 20px">
        菜系:&nbsp;
        <el-radio-group v-model="radio2" size="medium">
          <!--        川菜、鲁菜、粤菜、苏菜、浙菜、闽菜、其他。-->
          <el-radio-button label="川菜" ></el-radio-button>
          <el-radio-button label="鲁菜"></el-radio-button>
          <el-radio-button label="粤菜"></el-radio-button>
          <el-radio-button label="苏菜"></el-radio-button>
          <el-radio-button label="浙菜"></el-radio-button>
          <el-radio-button label="闽菜"></el-radio-button>
          <el-radio-button label="其他"></el-radio-button>
        </el-radio-group>
      </div>
      <div style="margin-top: 20px">
        三餐:&nbsp;
        <!--      早餐、午餐、晚餐。-->
        <el-radio-group v-model="radio3" size="small">
          <el-radio-button label="早餐"></el-radio-button>
          <el-radio-button label="午餐"  ></el-radio-button>
          <el-radio-button label="晚餐"></el-radio-button>
        </el-radio-group>
      </div>
    </div>

    <div style="margin-top: 3%">
      <el-row>
        <el-col :span="6" v-for="itme in menus">
          <div class="grid-content bg-purple" style="margin-right: 3%;margin-top: 2%">
        <Image_Card :image="itme.image" :id="itme.menuId" :title="itme.menu" :details="itme.introduce"></Image_Card>
        </div>
        </el-col>
      </el-row>
    </div>


  </template>
</div>
</template>

<script>
import Image_Card from "@/components/widget/image_card";
export default {
  name: "index",
  data () {
    return {
      radio1: '',
      radio2: '',
      radio3: '',
      menus:[
        {
          menu:'', // 菜名
          image:'', //图片
          foodtimes:'',//用餐时间
          menuId:''//餐品id
        }
      ]
    };

  },
  methods:{
    getAllMenu(){
      this.$axios('/menu/getAll').then(res=>{
        // console.log(res.data)
        this.menus = res.data
      })
    }
  },
  components:{
    Image_Card
  },
  watch:{
    radio1(){
     // this.$message.success("更新了")
     //     public String querybytype(String flavor,String menuMake,String menuType){
      this.$message.success("更新了菜谱")
      this.$axios('/menu/querybytype?flavor='+this.radio1+"&menuMake="+this.radio2+"&menuType="+this.radio3).then(res=>{
        this.$message.success("更新了菜谱")
        this.menus = res.data
      })
    },
    radio2(){
      this.$axios('/menu/querybytype?flavor='+this.radio1+"&menuMake="+this.radio2+"&menuType="+this.radio3).then(res=>{
        this.menus = res.data
      })
    },
    radio3(){
      this.$axios('/menu/querybytype?flavor='+this.radio1+"&menuMake="+this.radio2+"&menuType="+this.radio3).then(res=>{
        this.menus = res.data
      })
    }
  },
  created() {
    this.getAllMenu()
  }

}
</script>

<style scoped>

</style>

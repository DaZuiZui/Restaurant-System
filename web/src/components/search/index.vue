<template>
<div >
  <div style="margin-top: 3%"  v-for="itme in result">

    <el-card shadow="hover">
      <span style="margin-left: 7% ; font-weight: bolder; font-size: 13pt">{{itme.menu}}</span>
      <div style="margin-left: 10%;font-size: 11pt; margin-top: 0.5%" >
<!--        这里是描述-->
        {{itme.introduce}}
<!--        您搜索的内容是 {{value}}-->
      </div>
      <div  style="width: 27%; margin-left: 7% ;margin-top: 2%">
        <Image_Card :image="itme.image" :id="itme.menuId"></Image_Card>
      </div>
    </el-card>
  </div>

</div>
</template>

<script>
import Image_Card from "@/components/widget/image_card";
export default {
  name: "index",
  props:['value'],
  data(){
    return{
      result: null,
    }
  },
  components:{
    Image_Card
  },
  created() {

    this.getSearchValue();
  },
  methods:{
    getSearchValue(){
      this.$message('更新了 更新了')
      this.$axios('/menu/getmenubymenu?menu=' +this.value).then(res=>{
          this.result = res.data
          // console.log(this.result)
      })
    }
  },
  watch:{
    value(){
      this.getSearchValue();
    }
  }
}
</script>

<style scoped>

</style>

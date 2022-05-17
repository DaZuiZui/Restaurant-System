<template>
<div>
<!--  卡片图片组件 -->
  <el-card shadow="hover">
    <span>{{title}}</span>
     <el-link v-if="title==null" style="margin-left: 70%" @click="updateIndex" type="success" >查看详情</el-link>
     <el-link v-else style="margin-left: 50%" type="success" @click="updateIndex" >查看详情</el-link>
    <div style="margin-bottom: 3%">
      {{details}}
    </div>
  <div style="width: 250px ; height: 250px">
    <div style="width: 200px ;height: 200px ;">
      <img :src="image" class="image">
    </div>
  </div>



  </el-card>
</div>
</template>

<script>
export default {
  name: "image_card",
  props:['image','title','details','id'],
  methods:{
    updateIndex(){
      // alert("?")
      this.$store.dispatch('setIndex',11);
      this.$store.dispatch('setMenu',this.id)
    }
  },
  created() {

  }


}
</script>

<style scoped>

</style>

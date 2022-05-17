<template>
<div>
<!--  这里是菜谱详情-->
  <el-row>
    <el-col :span="12"><div class="grid-content bg-purple">
      <div style="margin-left: 20%">
        <div style="margin-left: 30%">
          <h1>{{result.menu}}</h1>
          <div>{{result.introduce}}</div>
        </div>
        <div class="block" style="margin-left: 5%;width: 60%;margin-top: 5% ; margin-right: 5%">
          <el-image :src="result.image"></el-image>
        </div>
      </div>
    </div></el-col>
    <el-col :span="12"><div class="grid-content bg-purple-light">
<!--      <span>制作方法</span>-->
      <h2>制作方法</h2>
      <el-card shadow="never">
        {{result.menuMake}}
      </el-card>
      <h2>所需材料</h2>
      <el-card shadow="never">
        {{result.menuData}}
      </el-card>

    </div></el-col>
  </el-row>

<div style="margin-top: 3%; margin-left: 15%;margin-bottom: 5%">
  <el-row>
    <el-col :span="16"><div class="grid-content bg-purple">
      <el-input
          type="textarea"
          :rows="2"
          placeholder="添加你的评论"
          v-model="textarea">
      </el-input>
    </div></el-col>
    <el-col :span="6"><div class="grid-content bg-purple-light">
      <el-button type="primary" style="margin-left: 10%;margin-top: 1%" @click="addconment()">发送</el-button>
    </div></el-col>
  </el-row>
</div>

  <el-divider content-position="center" style="margin-top: 5%"><h3>评论区</h3></el-divider>


  <div v-for=" itme in conments" style="margin-top: 1%">
    <el-card shadow="always">

      <span> {{ itme.username }}</span>
      :
      <span> {{ itme.comConten }}</span>

    </el-card>

  </div>


</div>
</template>

<script>
export default {
  name: "menu_details",
  data() {
    return {
      id:'',
      result:{
        image:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg',
        introduce:'',
        menu:''
      },
      conments:'',
      textarea:''

    }
  },
  methods:{
    getMenu(){
      this.$axios('/querybymenuId?id='+this.id).then(res=>{
        // console.log(res.data)
        console.log(res.data)
        this.result = res.data
      })
    },
    getconments(){
      this.$axios('/conment/commentsAll?menuId='+this.id).then(res=>{
        this.conments = res.data;

      })
    },
    addconment(){
      // console.log(this.$store.state.username)
      if (this.$store.state.username == null || this.$store.state.username=='') {
      this.$message('请登录')
        return
      }
      this.$axios('/conment/add?menuId='+this.id +"&username=" + this.$store.state.username +"&comConten=" +this.textarea).then(res=>{
        this.getconments();
        this.textarea ='';
      })
    }
  },
  created() {
    this.id = this.$store.state.menu ;
    // alert("传入的id"+this.$store.state.menu)
    this.getMenu() ;
    this.getconments();
  }


}
</script>

<style scoped>

</style>

<template>
<div style="margin-left: 40px;margin-top: 40px">
  <el-descriptions title="关于我们">
    <el-descriptions-item label="用户名">kooriookami</el-descriptions-item>
    <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
    <el-descriptions-item label="居住地">苏州市</el-descriptions-item>
    <el-descriptions-item label="备注">
      <el-tag size="small">学校</el-tag>
    </el-descriptions-item>
    <el-descriptions-item label="联系地址">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
  </el-descriptions>
  <el-input style="width: 60%; margin-left: 10%;margin-top: 3%" v-model="input" placeholder="输入标题"></el-input>
  <el-input style="width: 60%; margin-left: 10%;margin-top: 1%"
      type="textarea"
      :rows="2"
      placeholder="写给我们的话"
      v-model="textarea">
  </el-input>
  <br>
  <el-button style="width: 30%;margin-left: 35%; margin-top: 3%" type="primary" @click="addComments">发送留言</el-button>
</div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      input:'',
      textarea:''
    }
  },
  methods:{
    addComments(){
      if (this.$store.state.username =='' || this.$store.state.username==null){
        this.$message('请先 登录')
        return
      }
      this.$axios('/leavemessage/add?username='+this.$store.state.username+"&title="+this.input+"&proCon="+this.textarea).then(res=>{
        if (res.data == true){
          this.$message.success("发送成功");
        }else {
          this.$message.info("发送成功失败");
        }
      })

    }
  }
}
</script>

<style scoped>

</style>

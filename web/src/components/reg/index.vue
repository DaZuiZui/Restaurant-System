<template>
<div>
  <h1 style="margin-left: 35%">
     REG
  </h1>
  <el-input style="margin-top: 2%" v-model="username" placeholder="输入您想注册的账号"></el-input>
  <el-input style="margin-top: 2%" v-model="password1" placeholder="输入密码"></el-input>
  <el-input  style="margin-top: 2%" v-model="password2" placeholder="再次输入密码"></el-input>
  <el-button  style="margin-top: 5% ;width: 100%" type="success" round @click="check">注册</el-button>
</div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      username:'',
      password1:'',
      password2:'',
    }
  },
  methods:{
    check(){
      if (this.password1 != this.password2){
        this.$message.error("您输入的两次密码不一样")
        return
      }
      let user ={
        username :this.username ,
        password: this.password1
      }
      this.$axios.post('/user/reg',user).then(res=>{
        if (res.data == true){
          this.$message.success("注册成功")
          this.logOut()
        }else {
          this.$message.error("账号已 被注册")
        }
      })


    },
    logOut(){
      this.$parent.LogOut();
    }
  }
}
</script>

<style scoped>

</style>

<template>
<div>
    <h1 style="margin-left: 25%">Login</h1>
    <el-input v-model="username" placeholder="输入你的账号"></el-input>
    <el-input style="margin-top: 2%" v-model="password" placeholder="请输入你的密码" show-password></el-input>
    <div style="margin-top: 10% ;">
      <el-button type="primary" round plain style="width: 100%" @click="login">登录</el-button>
    </div>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      username: '',
      password: '',
    }
  },
  methods:{
    login(){
      let user ={
        username:this.username,
        password:this.password
      }
      this.$axios('/user/login?username='+user.username+'&password='+user.password).then(res=>{
        // alert(res.data)
        if (res.data == false){
          // alert(res.data)
          this.$message.error("账号或者密码错误")
          return

        }else {
          // console.log(res.data)
          this.$message.success("登录成功");
          this.$store.dispatch('setUsername',user.username);
          this.$parent.setHome();
        }
      })


    }
  }


}
</script>

<style scoped>

</style>

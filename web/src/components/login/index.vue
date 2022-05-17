<template>
  <div  style="margin-top: 9% ;margin-left: 40%; margin-right: 40%">
      <div v-if="login">
        <Login></Login>
      </div>
    <div v-else>
      <Reg></Reg>
    </div>
<div style="margin-top: 15% ;margin-left: 7%">
  <el-link v-if="login" type="success" @click="login=false">还没有账号吗 ? 点我注册</el-link>
  <el-link v-else type="success" @click="login=true">已有账号？ 点我登录</el-link>
</div>
  </div>
</template>

<script>
import Reg from '../reg/index'
import Login from './login'
export default {
  name: "index",
  data() {
    return {
      login: true
    }
  },
  components:{
    Reg,
    Login
  },
  methods: {
    setHome(){
      this.$parent.setHome();
    },
    logOut(){
      alert("促销")
    }
  }
}
</script>

<style scoped>

</style>

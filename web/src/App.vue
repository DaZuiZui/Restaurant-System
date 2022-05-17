<template>

  <div id="app">
    <div style="margin-left: 5% ;margin-right: 5%" class="middle">
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect" router>
        <!--     这里是导航-->
        <el-menu-item index="1" @click="index=1" disabled style="opacity: revert">
          <div style="background-color: #ffffff">
            <span style="color: #000000">Logo标志</span>
          </div>
        </el-menu-item>
        <el-menu-item index="2" disabled style="opacity: revert">
          <div >
            <el-input style="width: 70%;margin-right: 4px" v-model="search" placeholder="请输入内容"></el-input>
            <el-button icon="el-icon-search" circle @click="select"></el-button>
          </div>
        </el-menu-item>
        <el-menu-item index="3" @click="updateIndex(3)">主页栏目</el-menu-item>
        <el-menu-item index="4" @click="updateIndex(4)">菜谱栏目</el-menu-item>
        <el-menu-item index="5" @click="updateIndex(5)">健康饮食栏目</el-menu-item>
        <el-menu-item index="6" @click="updateIndex(6)">联系我们栏目</el-menu-item>
        <el-menu-item v-if="login" index="7" @click="updateIndex(7)">个人中心栏目</el-menu-item>
        <el-menu-item v-if="!login" index="9" @click="updateIndex(9)">请先登录</el-menu-item>
        <el-menu-item index="8" @click="updateIndex(8)" disabled style="opacity: revert">
          <div>
            <div  class="block"><el-avatar  shape="square" :size="50" :src="head_image"></el-avatar></div>
          </div>
        </el-menu-item>

      </el-menu>
      <div v-if="index == 1">

      </div>
      <div v-if="index == 2">

      </div>
      <div v-if="index == 3">
      <Home></Home>
      </div>
      <div v-if="index == 4">
        <Menu></Menu>
      </div>
      <div v-if="index == 5">
      <Health></Health>
      </div>
      <div v-if="index == 6">
        <contactUs></contactUs>
      </div>
      <div v-if="index == 7">
        <User></User>
      </div>
      <div v-if="index == 9">
        <Login></Login>
      </div>
      <div v-if="index == 10">
        <Search :value="search"></Search>
      </div>
      <div v-if="index==11">
        <Menu_Details></Menu_Details>
      </div>


    </div>

  </div>
</template>

<script>
import Login from './components/login/index'
import contactUs from './components/contactUs/index'
import Home from './components/home/index'
import Menu from './components/menu/index'
import Health from  './components/health/index'
import User from './components/user/index'
import Search from './components/search/index'
import Menu_Details from "@/components/menu/menu_details";

export default {
  name: 'App',
  data() {
    return {
      activeIndex: '1',
      index:0,
      login:false,
      search:'',
      head_image:'https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg'
    };
  },
  methods: {
    handleSelect(key, keyPath) {
    },
    setHome(){
      this.index =3 ;
      this.activeIndex ='3';
      this.login =true;
    },
    select(){
      this.index =10 ;
      this.$store.dispatch('setIndex',10)
    },
    LogOut(){
      this.index =9 ;
      this.activeIndex ='9';
      this.login =false;
    },
    updateIndex(index){
      this.index = index
      this.$store.dispatch('setIndex',index)
    }
  },
  components: {
    contactUs,
    Home,
    Menu,
    User,
    Health,
    Login,
    Search,
    Menu_Details
  },
  created() {
    this.index = 3 ;
    this.activeIndex ='3';
  },

  computed:{
    index_menu(){
      return this.$store.state.index
    },
    username_login(){
      return this.$store.state.username;
    }
  },
  watch:{
    index_menu(){
      if (this.$store.state.index != 11) return
      this.index = 11
      this.activeIndex = '11'
    },
    username_login(){
      this.$axios('/user/querytheuserbyusername?username='+this.$store.state.username).then(res=>{
        // console.log(this.$store.state.username)
        // console.log('res.data ==>')
        console.log(res.data)
        this.head_image = res.data.headImage
      })
    }
  }
}
</script>

<style>

.middle{
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
}
</style>

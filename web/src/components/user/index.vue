<template>
<div style="margin-top: 3%">
  <div style="margin-left: 45%; margin-right: 42% ; margin-bottom: 3%" v-if="updateimage">
    <el-avatar shape="square" :size="160" :fit="fit" :src="head_image"></el-avatar>
  </div>

  <div v-else style="margin-left: 45%; margin-right: 42% ; background-color: #deccb5 ; margin-bottom: 2%">

    <div v-if="addimage">
      <el-upload
          class="avatar-uploader"
          action="http://127.0.0.1:8989/uploadimage"
          :show-file-list="false"
          name="files"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
      </el-upload>
    </div>
    <div v-else>
      头像修改成功下次登录可查看
    </div>

  </div>
  <div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="您的账号" >
        <el-input v-model="this.$store.state.username" disabled></el-input>
      </el-form-item>

      <el-form-item label="修改密码">
        <el-input v-model="form.name" show-password></el-input>
      </el-form-item>


      <el-form-item style="text-align: center;margin-top: 3%">
        <el-button type="primary"  style="width: 20%" @click="updatePassword()">更新</el-button>
        <el-button @click="updateimage=!updateimage" style="width: 20%"><span v-if="updateimage">修改头像</span> <span v-else>取消修改头像</span></el-button>
        <el-button @click="logOut" style="width: 20%">退出登录</el-button>
      </el-form-item>
    </el-form>
  </div>

</div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      form: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: '',


      },
      updateimage :true,
      head_image:'',
      addimage:true,
      updateimageName:''
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!');
    },
    logOut(){
      this.$parent.LogOut();
      this.$store.dispatch('setUsername','')
    },
    username_login(){
      this.$axios('/user/querytheuserbyusername?username='+this.$store.state.username).then(res=>{
        // console.log(this.$store.state.username)
        // console.log('res.data ==>')
        this.head_image = res.data.headImage
      })
    },
    handleAvatarSuccess(res, file) {
      console.log(res)
      this.updateimageName = file.name ;
      this.addimage = false
      this.updateimageA(res)
    },
    updateimageA(imagename){
      this.$axios('/username/updateimage?username='+this.$store.state.username+'&image='+imagename).then(res=>{
        this.$message.success('更新成功')
      })
    },
    updatePassword(){
      this.$axios('/username/updatepassword?username='+this.$store.state.username+'&password='+this.form.name).then(res=>{
        if (res.data == true) {
          this.$message.success('密码修改成功 ')
        }
      })
    }


  },
  created() {
    this.username_login();
  }
}
</script>

<style scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>

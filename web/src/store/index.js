import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)
const actions = {
    setUsername(context,value){
        context.commit('SETUSERNAME',value)
    },
    setUserID(context,value){
        context.commit('SETUSERID',value)
    },
    setName(context,value){
        context.commit('SETNAME',value)
    },
    //SETMENU
    setMenu(context,value){
        context.commit('SETMENU',value);
    },
    setIndex(context,value){
        context.commit('SETINDEX',value);
    }


}
const mutations={
    SETUSERNAME(state,value){
        state.username = value;
    },
    SETUSERID(state,value){
        state.id=value;
    },
    SETNAME(state,value){
        state.name =value;
    },
    SETMENU(state,value){
        state.menu =value;
    },
    SETINDEX(state,value){
        state.index =value;
    }
}
const state={
    id:null,
    username:null,
    name:null,
    //监听  详情 的内容
    menu: 0,
    index:0,

}


//创建VueX对象
export default new Vuex.Store({
    actions,
    mutations,
    state
})

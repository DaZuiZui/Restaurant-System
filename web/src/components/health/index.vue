<template>
<div style="margin-top: 3%">

  <div style="margin-left: 4%;margin-right: 4%">
    <h3>健康饮食 小贴士</h3>
    <div v-for="itme in article">
      <div style="margin-top: 1%">
        <el-card shadow="hover">
          <span style="margin-left: 7% ; font-weight: bolder; font-size: 13pt">{{itme.title}}</span>
          <div style="margin-left: 10%;font-size: 11pt; margin-top: 0.5%" >
            {{itme.text}}
          </div>
        </el-card>
      </div>
    </div>

  </div>

</div>
</template>

<script>
export default {
  name: "index",
  data(){
    return{
      article:[
        {
          title:'吃不同食物',
          text:'我们的身体极为复杂，没有任何一种单一食物囊括我们需要的所有营养成分，使我们的身体处于最佳状态。因此，我们的饮食应包括各种有营养的新鲜食物，才能保持身体健康。均衡饮食的小贴士：\n' +
              '日常饮食应尽量含有小麦、玉米、大米和土豆等多种主食，滨豆和豆荚等豆类。新鲜水果和蔬菜以及动物来源食品（如肉类、鱼类、蛋类和奶类）。\n' +
              '尽可能选择未经加工的全谷物食品，如玉米、小米、燕麦、小麦和糙米等；这些食物富含纤维，可增加饱腹感。\n' +
              '尽可能选择瘦肉，或者去掉过肥的肉。\n' +
              '烹饪时尽量采用蒸或煮的方式，而不是煎炸食物。\n' +
              '选择的零食应是蔬菜、不加盐的坚果和新鲜水果，而不是高糖、高脂、高盐食品。'
        },
        {
          title:'少盐',
          text:'吃过多的盐血压会升高，而高血压是心脏病和中风的主要风险因素。世界上大多数人都盐摄入量过多：平均而言，我们每天的盐摄入量是世卫组织推荐量（5克，相当于一茶匙）的两倍。\n' +
              '\n' +
              '我们应该了解，即使没有在食物中另添加盐，加工食品和饮料中往往都含有不少的盐。\n' +
              '减少盐摄入小贴士：\n' +
              '烹饪和加工食物时少用盐，减少咸味酱和调味品的使用（如酱油、高汤或鱼露）。\n' +
              '避免食用高盐零食，尽量选择新鲜的健康零食而不是加工食品。\n' +
              '选用罐头或干蔬菜、坚果和水果时，要选择不加盐和糖的品种。\n' +
              '餐桌上不摆放盐瓶和含盐调味品，尽量避免养成添加此类调味品的习惯；人的味蕾能迅速做出调整，而一旦调整后，你就能够享用低盐但美味更佳的食物！\n' +
              '查看食品标签，选择低钠产品。'
        },
        {
          title:'减少脂肪和油的摄入',
          text:'我们的饮食中都需要一定量的脂肪，但是摄入过多，尤其是不好的脂肪，会增加肥胖、心脏病和中风的风险。\n' +
              '\n' +
              '工业生产的反式脂肪对健康的危害最大。饮食中如果含有大量反式脂肪，可使罹患心脏病的风险增加近30%。\n' +
              '\n' +
              '减少食用脂肪的小贴士：\n' +
              '以大豆油、菜籽油、玉米油、籽油和葵花籽油等更健康的油代替黄油、猪油和酥油。\n' +
              '选择家禽和鱼类等白肉，其脂肪含量通常低于红肉；同时限制食用加工肉制品。\n' +
              '查看食品标签，一定要避免食用含有工业生产的反式脂肪的各种加工食品、快餐和油炸食品。反式脂肪往往存在于人造黄油和酥油、预包装的零食、快餐、焙烤和煎炸食品中。'
        },
        {
          title:'限制糖摄入',
          text:'食用太多的糖不仅对牙齿有害，还会增加超重和肥胖的风险，从而导致严重的慢性健康问题。\n' +
              '\n' +
              '与盐一样，一定要注意“隐藏”在加工食品和饮料中的糖分。例如，一罐汽水可含多达10茶匙的添加糖!\n' +
              '\n' +
              '减少糖摄入的小贴士：\n' +
              '限制甜食和含糖饮料的摄入，如碳酸饮料、果汁和果汁饮料、果汁浓缩液或粉、加味水、能量和运动饮料、即饮茶和咖啡以及加味乳饮料。\n' +
              '选择健康新鲜的零食，摒弃加工食品。\n' +
              '避免给孩子吃含糖食品。2岁以下儿童的辅食中不应添加盐和糖，2岁以上儿童的食物中也应限制糖和盐的用量。'
        },
        {
          title:'避免酒精的有害使用',
          text:'酒精不属于健康饮食，但在许多文化中，节假日与大量饮酒有关。总体而言，饮酒过量或过频，会增加受伤的直接风险，也会带来长期影响，如肝损害、癌症、心脏病和精神疾患。\n' +
              '\n' +
              '世卫组织忠告：饮酒无安全阈值可言；对许多人来说，即使少量饮酒也可能带来严重的健康风险。\n' +
              '记住：减少饮酒对健康有益，滴酒不沾也完全没有问题。\n' +
              '如果你属于下列情况就完全不应饮酒：怀孕或正在哺乳；驾驶、操作机械或者从事有相关风险的其他活动；患有酒精会加重病情的疾病；正在服用与酒精有直接作用的药物；或者对饮酒缺乏自制力。'
        }
      ]
    }
  }
}
</script>

<style scoped>

</style>

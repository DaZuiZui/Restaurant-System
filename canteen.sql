/*
 Navicat Premium Data Transfer

 Source Server         : 03112022demo
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 192.144.213.195:3310
 Source Schema         : canteen

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 17/05/2022 14:43:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments`  (
  `menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜谱名',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `com_conten` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `com_date` date NULL DEFAULT NULL COMMENT '评论时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('9', '1234', '我在 9 号文章BB', '2022-05-13');
INSERT INTO `comments` VALUES ('9', '1234', '我再次BB', '2022-05-19');
INSERT INTO `comments` VALUES ('7', '123', '41414', '2022-05-13');
INSERT INTO `comments` VALUES ('9', '1234', '我是正文', '2022-05-11');
INSERT INTO `comments` VALUES ('9', '1234', '打发手动阀手动阀啊', '2022-05-11');
INSERT INTO `comments` VALUES ('3', '1234', '1231241241243', '2022-05-11');
INSERT INTO `comments` VALUES ('3', '1234', '12314124313', '2022-05-11');
INSERT INTO `comments` VALUES ('2', '1234', '我而发哦死的好发三百 阿萨大发算法', '2022-05-11');
INSERT INTO `comments` VALUES ('1', '1234', '123124', '2022-05-11');
INSERT INTO `comments` VALUES ('1', '1234', '123123123', '2022-05-11');
INSERT INTO `comments` VALUES ('1', '1234', '1231412412', '2022-05-11');

-- ----------------------------
-- Table structure for leavemessage
-- ----------------------------
DROP TABLE IF EXISTS `leavemessage`;
CREATE TABLE `leavemessage`  (
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `pro_con` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '留言内容',
  `prodate` date NULL DEFAULT NULL COMMENT '留言时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of leavemessage
-- ----------------------------
INSERT INTO `leavemessage` VALUES ('用户名', '标题', '内容', '2022-05-28');
INSERT INTO `leavemessage` VALUES ('我是名字1', '我是标题', '我是·内容', '2022-05-10');
INSERT INTO `leavemessage` VALUES (NULL, '234234234', '234234244234234', '2022-05-10');
INSERT INTO `leavemessage` VALUES (NULL, '234234234123123', '234234244234234', '2022-05-10');
INSERT INTO `leavemessage` VALUES ('1234', '90876542', '123124451234123', '2022-05-10');
INSERT INTO `leavemessage` VALUES ('1234', 'bhhb', 'vghjvgh', '2022-05-11');
INSERT INTO `leavemessage` VALUES ('1234', '但是发射点飞洒地方阿萨大飞洒', '啊手动阀手动阀阿萨大发士大夫a', '2022-05-11');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜谱id',
  `menu` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜谱名',
  `image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片',
  `flavor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '口味',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '介绍',
  `menu_data` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '材料',
  `menu_make` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '制作方法',
  `foodtimes` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '早餐午饭晚餐',
  `menutype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜系分裂',
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '菜A', 'https://bxxt-lzj.oss-cn-beijing.aliyuncs.com/0/0ef751d8-d430-44df-b6aa-7de15eba44cbfiles.png', '甜', '我是菜的', '1234', '1234', '早', '川菜');
INSERT INTO `menu` VALUES (2, '菜B', 'https://morandizj.oss-cn-beijing.aliyuncs.com/03/2c613d0f-34bd-401e-8061-460350515e9dfiles.png', '苦', '134', '134', '1354', '晚', '');
INSERT INTO `menu` VALUES (3, '菜C', '\r\nhttps://srb-zhaojia.oss-cn-beijing.aliyuncs.com/avatar/goutou.jpg', '甜', '1234', '13423', '453', '早', '川菜');
INSERT INTO `menu` VALUES (9, '我是大哥', 'http://127.0.0.1:8989/getimage?imgUrl=1.jpg', '我是大哥', '我是大哥', '我是大哥', '我是大哥', '晚', '我是大哥');

-- ----------------------------
-- Table structure for menu_type
-- ----------------------------
DROP TABLE IF EXISTS `menu_type`;
CREATE TABLE `menu_type`  (
  `category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'l类别',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '菜谱名'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu_type
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `power` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '权限',
  `head_image` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, '1234', '6666', 'admin', 'http://127.0.0.1:8989/getimage?imgUrl=/99.jpg');
INSERT INTO `user` VALUES (3, '', '123', 'admin', 'null');
INSERT INTO `user` VALUES (6, '1231', '3333', '1', '1');

SET FOREIGN_KEY_CHECKS = 1;

/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : update

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 11/01/2018 22:58:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_update
-- ----------------------------
DROP TABLE IF EXISTS `tb_update`;
CREATE TABLE `tb_update`  (
  `update_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `update_type` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新类型（A:android,I:ios）',
  `update_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '版本号',
  `update_min_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '支持最低版本',
  `update_code` int(11) DEFAULT NULL COMMENT '版本code',
  `update_note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '更新说明',
  `update_ismust` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否强制更新',
  `update_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '文件地址',
  `update_crt_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_filesize` double DEFAULT NULL COMMENT '文件大小',
  PRIMARY KEY (`update_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

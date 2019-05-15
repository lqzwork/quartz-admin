/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50715
Source Host           : 127.0.0.1:3306
Source Database       : ffxl_cloud

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-12-03 19:26:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for s_timetask
-- ----------------------------
DROP TABLE IF EXISTS `s_timetask`;
CREATE TABLE `s_timetask` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '任务名',
  `group_name` varchar(50) DEFAULT NULL COMMENT '任务组',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '开始时间',
  `end_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '结束时间',
  `cron` varchar(30) DEFAULT NULL COMMENT '表达式',
  `job_status` varchar(20) DEFAULT NULL COMMENT '任务状态\r\n0：未发布\r\n1：已发布',
  `plan_status` varchar(20) DEFAULT NULL COMMENT '计划状态\r\nNone：None\r\nNORMAL：正常运行\r\nPAUSED：已暂停\r\nCOMPLETE：任务执行中\r\nBLOCKED：线程阻塞\r\nERROR：错误\r\n其它：  未计划',
  `is_concurrent` tinyint(4) DEFAULT NULL COMMENT '运行状态\r\ntrue : 运行中\r\nfalse：未运行',
  `job_data` varchar(50) DEFAULT NULL COMMENT '参数',
  `method_name` varchar(50) DEFAULT NULL COMMENT '方法',
  `bean_name` varchar(100) DEFAULT NULL COMMENT '实例bean',
  `description` varchar(1000) DEFAULT NULL COMMENT '任务描述',
  `create_user_id` varchar(32) NOT NULL,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `modify_user_id` varchar(32) NOT NULL,
  `modify_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_timetask
-- ----------------------------
INSERT INTO `s_timetask` VALUES ('001', 'deleteTimeTaskLog', 'TimeTaskLogDispatchController', '2018-12-03 16:19:43', '2018-08-31 00:00:00', '0 0/2 * * * ?', '1', null, '0', '1', 'deleteTimeTaskLog', 'com.ffxl.quartz.quartztest.TimeTaskLogDispatchController', '定时清除timeTaskLog 7天之前的记录（每天间隔2分钟执行一次）', 'system', '2018-08-31 11:59:09', 'f7c6245b9b5b45d08ed21bf776c7119f', '2018-08-31 11:59:12');

-- ----------------------------
-- Table structure for s_timetask_log
-- ----------------------------
DROP TABLE IF EXISTS `s_timetask_log`;
CREATE TABLE `s_timetask_log` (
  `id` varchar(32) NOT NULL,
  `job_id` varchar(32) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `reason` varchar(2000) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


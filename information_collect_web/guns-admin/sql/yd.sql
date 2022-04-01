/*
Navicat MySQL Data Transfer

Source Server         : localhost:3306
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : yd_full_business

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2021-06-16 17:09:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for act_id_user
-- ----------------------------
DROP TABLE IF EXISTS `act_id_user`;
CREATE TABLE `act_id_user` (
  `ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `FIRST_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `LAST_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `EMAIL_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PWD_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PICTURE_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_id_user
-- ----------------------------

-- ----------------------------
-- Table structure for act_re_deployment
-- ----------------------------
DROP TABLE IF EXISTS `act_re_deployment`;
CREATE TABLE `act_re_deployment` (
  `ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `NAME_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `CATEGORY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TENANT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `DEPLOY_TIME_` timestamp NULL DEFAULT NULL,
  `ENGINE_VERSION_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_re_deployment
-- ----------------------------
INSERT INTO `act_re_deployment` VALUES ('1', 'SpringAutoDeployment', null, null, '', '2018-05-25 10:20:55', null);
INSERT INTO `act_re_deployment` VALUES ('10001', 'SpringAutoDeployment', null, null, '', '2018-06-04 17:01:40', null);
INSERT INTO `act_re_deployment` VALUES ('12501', 'SpringAutoDeployment', null, null, '', '2018-06-05 15:21:01', null);
INSERT INTO `act_re_deployment` VALUES ('15001', 'SpringAutoDeployment', null, null, '', '2018-06-05 15:49:18', null);
INSERT INTO `act_re_deployment` VALUES ('17501', 'SpringAutoDeployment', null, null, '', '2018-06-05 16:31:39', null);
INSERT INTO `act_re_deployment` VALUES ('20001', 'SpringAutoDeployment', null, null, '', '2019-04-30 14:57:29', null);
INSERT INTO `act_re_deployment` VALUES ('22501', 'SpringAutoDeployment', null, null, '', '2019-05-15 09:26:23', null);
INSERT INTO `act_re_deployment` VALUES ('25001', 'SpringAutoDeployment', null, null, '', '2019-05-15 10:59:58', null);
INSERT INTO `act_re_deployment` VALUES ('2501', 'SpringAutoDeployment', null, null, '', '2018-05-25 10:46:32', null);
INSERT INTO `act_re_deployment` VALUES ('27501', 'SpringAutoDeployment', null, null, '', '2019-05-17 16:50:27', null);
INSERT INTO `act_re_deployment` VALUES ('30001', 'SpringAutoDeployment', null, null, '', '2019-05-17 17:10:28', null);
INSERT INTO `act_re_deployment` VALUES ('32501', 'SpringAutoDeployment', null, null, '', '2019-05-17 17:14:38', null);
INSERT INTO `act_re_deployment` VALUES ('35001', 'SpringAutoDeployment', null, null, '', '2019-05-17 17:15:03', null);
INSERT INTO `act_re_deployment` VALUES ('37501', 'SpringAutoDeployment', null, null, '', '2019-05-20 09:26:05', null);
INSERT INTO `act_re_deployment` VALUES ('40001', 'SpringAutoDeployment', null, null, '', '2019-06-12 10:31:08', null);
INSERT INTO `act_re_deployment` VALUES ('42501', 'SpringAutoDeployment', null, null, '', '2019-06-12 15:39:34', null);
INSERT INTO `act_re_deployment` VALUES ('45001', 'SpringAutoDeployment', null, null, '', '2020-07-31 11:33:25', null);
INSERT INTO `act_re_deployment` VALUES ('5001', 'SpringAutoDeployment', null, null, '', '2018-05-28 14:55:22', null);
INSERT INTO `act_re_deployment` VALUES ('7501', 'SpringAutoDeployment', null, null, '', '2018-05-29 17:06:46', null);

-- ----------------------------
-- Table structure for act_re_procdef
-- ----------------------------
DROP TABLE IF EXISTS `act_re_procdef`;
CREATE TABLE `act_re_procdef` (
  `ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `REV_` int(11) DEFAULT NULL,
  `CATEGORY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `KEY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `VERSION_` int(11) NOT NULL,
  `DEPLOYMENT_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `RESOURCE_NAME_` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DGRM_RESOURCE_NAME_` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `HAS_START_FORM_KEY_` tinyint(4) DEFAULT NULL,
  `HAS_GRAPHICAL_NOTATION_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `ENGINE_VERSION_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  UNIQUE KEY `ACT_UNIQ_PROCDEF` (`KEY_`,`VERSION_`,`TENANT_ID_`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_re_procdef
-- ----------------------------
INSERT INTO `act_re_procdef` VALUES ('Expense:10:22504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '10', '22501', 'E:\\Property\\Code\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'E:\\Property\\Code\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:11:25004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '11', '25001', 'F:\\IDEA_workspace\\areagunstrue\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\IDEA_workspace\\areagunstrue\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:12:27504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '12', '27501', 'F:\\apache-tomcat-8.0.53\\webapps\\guns\\WEB-INF\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\apache-tomcat-8.0.53\\webapps\\guns\\WEB-INF\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:13:30004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '13', '30001', 'F:\\apache-tomcat-8.0.53\\webapps\\ROOT\\WEB-INF\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\apache-tomcat-8.0.53\\webapps\\ROOT\\WEB-INF\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:14:32504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '14', '32501', 'F:\\apache-tomcat-8.0.53\\webapps\\guns\\WEB-INF\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\apache-tomcat-8.0.53\\webapps\\guns\\WEB-INF\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:15:35004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '15', '35001', 'F:\\apache-tomcat-8.0.53\\webapps\\ROOT\\WEB-INF\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\apache-tomcat-8.0.53\\webapps\\ROOT\\WEB-INF\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:16:37504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '16', '37501', 'F:\\IDEA_workspace\\areagunstrue\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\IDEA_workspace\\areagunstrue\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:17:40004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '17', '40001', 'F:\\IDEA_workspace\\areagunsture\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\IDEA_workspace\\areagunsture\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:18:42504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '18', '42501', 'F:\\IDEA_workspace\\propertyguns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\IDEA_workspace\\propertyguns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:19:45004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '19', '45001', 'E:\\gmZcgl\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'E:\\gmZcgl\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:1:4', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '1', '1', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:2:2504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '2', '2501', 'F:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:3:5004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '3', '5001', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:4:7504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '4', '7501', 'C:\\Users\\DELL\\Desktop\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'C:\\Users\\DELL\\Desktop\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:5:10004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '5', '10001', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\naan1993-guns-master\\guns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:6:12504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '6', '12501', 'F:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:7:15004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '7', '15001', 'F:\\ideaPro\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'F:\\ideaPro\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:8:17504', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '8', '17501', 'E:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'E:\\zhdj\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);
INSERT INTO `act_re_procdef` VALUES ('Expense:9:20004', '1', 'http://www.flowable.org/processdef', 'ExpenseProcess', 'Expense', '9', '20001', 'E:\\landGuns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.bpmn20.xml', 'E:\\landGuns\\guns-admin\\target\\classes\\processes\\ExpenseProcess.Expense.png', '报销流程', '0', '1', '1', '', null);

-- ----------------------------
-- Table structure for act_ru_execution
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_execution`;
CREATE TABLE `act_ru_execution` (
  `ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `BUSINESS_KEY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PARENT_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SUPER_EXEC_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ROOT_PROC_INST_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ACT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `IS_ACTIVE_` tinyint(4) DEFAULT NULL,
  `IS_CONCURRENT_` tinyint(4) DEFAULT NULL,
  `IS_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_EVENT_SCOPE_` tinyint(4) DEFAULT NULL,
  `IS_MI_ROOT_` tinyint(4) DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `CACHED_ENT_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `NAME_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `START_ACT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `START_TIME_` datetime DEFAULT NULL,
  `START_USER_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `LOCK_TIME_` timestamp NULL DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `EVT_SUBSCR_COUNT_` int(11) DEFAULT NULL,
  `TASK_COUNT_` int(11) DEFAULT NULL,
  `JOB_COUNT_` int(11) DEFAULT NULL,
  `TIMER_JOB_COUNT_` int(11) DEFAULT NULL,
  `SUSP_JOB_COUNT_` int(11) DEFAULT NULL,
  `DEADLETTER_JOB_COUNT_` int(11) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  `CALLBACK_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `CALLBACK_TYPE_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_EXEC_BUSKEY` (`BUSINESS_KEY_`) USING BTREE,
  KEY `ACT_IDC_EXEC_ROOT` (`ROOT_PROC_INST_ID_`) USING BTREE,
  KEY `ACT_FK_EXE_PROCINST` (`PROC_INST_ID_`) USING BTREE,
  KEY `ACT_FK_EXE_PARENT` (`PARENT_ID_`) USING BTREE,
  KEY `ACT_FK_EXE_SUPER` (`SUPER_EXEC_`) USING BTREE,
  KEY `ACT_FK_EXE_PROCDEF` (`PROC_DEF_ID_`) USING BTREE,
  CONSTRAINT `act_ru_execution_ibfk_1` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`id_`),
  CONSTRAINT `act_ru_execution_ibfk_2` FOREIGN KEY (`PARENT_ID_`) REFERENCES `act_ru_execution` (`id_`) ON DELETE CASCADE,
  CONSTRAINT `act_ru_execution_ibfk_3` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`id_`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `act_ru_execution_ibfk_4` FOREIGN KEY (`SUPER_EXEC_`) REFERENCES `act_ru_execution` (`id_`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_execution
-- ----------------------------

-- ----------------------------
-- Table structure for act_ru_task
-- ----------------------------
DROP TABLE IF EXISTS `act_ru_task`;
CREATE TABLE `act_ru_task` (
  `ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
  `REV_` int(11) DEFAULT NULL,
  `EXECUTION_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PROC_INST_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PROC_DEF_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SUB_SCOPE_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_TYPE_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SCOPE_DEFINITION_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `NAME_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PARENT_TASK_ID_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DESCRIPTION_` varchar(4000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TASK_DEF_KEY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `OWNER_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ASSIGNEE_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DELEGATION_` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PRIORITY_` int(11) DEFAULT NULL,
  `CREATE_TIME_` timestamp NULL DEFAULT NULL,
  `DUE_DATE_` datetime DEFAULT NULL,
  `CATEGORY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `SUSPENSION_STATE_` int(11) DEFAULT NULL,
  `TENANT_ID_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT '',
  `FORM_KEY_` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `CLAIM_TIME_` datetime DEFAULT NULL,
  `IS_COUNT_ENABLED_` tinyint(4) DEFAULT NULL,
  `VAR_COUNT_` int(11) DEFAULT NULL,
  `ID_LINK_COUNT_` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_`),
  KEY `ACT_IDX_TASK_CREATE` (`CREATE_TIME_`) USING BTREE,
  KEY `ACT_IDX_TASK_SCOPE` (`SCOPE_ID_`,`SCOPE_TYPE_`) USING BTREE,
  KEY `ACT_IDX_TASK_SUB_SCOPE` (`SUB_SCOPE_ID_`,`SCOPE_TYPE_`) USING BTREE,
  KEY `ACT_IDX_TASK_SCOPE_DEF` (`SCOPE_DEFINITION_ID_`,`SCOPE_TYPE_`) USING BTREE,
  KEY `ACT_FK_TASK_EXE` (`EXECUTION_ID_`) USING BTREE,
  KEY `ACT_FK_TASK_PROCINST` (`PROC_INST_ID_`) USING BTREE,
  KEY `ACT_FK_TASK_PROCDEF` (`PROC_DEF_ID_`) USING BTREE,
  CONSTRAINT `act_ru_task_ibfk_1` FOREIGN KEY (`PROC_DEF_ID_`) REFERENCES `act_re_procdef` (`id_`),
  CONSTRAINT `act_ru_task_ibfk_2` FOREIGN KEY (`EXECUTION_ID_`) REFERENCES `act_ru_execution` (`id_`),
  CONSTRAINT `act_ru_task_ibfk_3` FOREIGN KEY (`PROC_INST_ID_`) REFERENCES `act_ru_execution` (`id_`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of act_ru_task
-- ----------------------------

-- ----------------------------
-- Table structure for compound_pipe_design_scheme
-- ----------------------------
DROP TABLE IF EXISTS `compound_pipe_design_scheme`;
CREATE TABLE `compound_pipe_design_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pipeline_kw_length` decimal(10,2) DEFAULT NULL COMMENT '开挖管道长度',
  `pipeline_js_length` decimal(10,2) DEFAULT NULL COMMENT '管道建设长度',
  `pipeline_gd_money` decimal(10,2) DEFAULT NULL COMMENT '管道投资额',
  `pipeline_gl_length` decimal(10,2) DEFAULT NULL COMMENT '光缆建设长度',
  `pipeline_count` decimal(10,2) DEFAULT NULL COMMENT '纤芯数',
  `pipeline_gl_money` decimal(10,2) DEFAULT NULL COMMENT '光缆投资金额',
  `cover_count` decimal(10,2) DEFAULT NULL COMMENT '设计覆盖数',
  `cover_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '覆盖类型',
  `pipeline_sb_money` decimal(10,2) DEFAULT NULL COMMENT '设备投资额',
  `design_cover_count` decimal(10,2) DEFAULT NULL COMMENT '设计覆盖栋数',
  `join_olt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接入OLT',
  `all_money` decimal(20,2) DEFAULT NULL COMMENT '总投资额',
  `other` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他说明',
  `entry_instructions` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '入户说明',
  `scheme_review_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方案审核编码',
  `rh_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传入户条件确认表',
  `sj_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传设计方案',
  `tz_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传工程图纸',
  `ys_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传工程预算',
  `next_days` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下环节处理时限',
  `all_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传附件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of compound_pipe_design_scheme
-- ----------------------------
INSERT INTO `compound_pipe_design_scheme` VALUES ('8', '11.00', null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('9', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('10', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('11', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('12', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('13', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('14', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');
INSERT INTO `compound_pipe_design_scheme` VALUES ('15', null, null, null, null, null, null, null, '', null, null, '', null, '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for f_archive_info
-- ----------------------------
DROP TABLE IF EXISTS `f_archive_info`;
CREATE TABLE `f_archive_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `files` varchar(255) DEFAULT NULL COMMENT '归档附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_archive_info
-- ----------------------------
INSERT INTO `f_archive_info` VALUES ('2', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('3', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('4', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('5', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('6', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('7', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('8', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_archive_info` VALUES ('9', 'b731114781e749e5be4fb7fdb6a1ff26');
INSERT INTO `f_archive_info` VALUES ('10', '1608589e1953416bbc686d3111970d23');
INSERT INTO `f_archive_info` VALUES ('11', '1608589e1953416bbc686d3111970d23');

-- ----------------------------
-- Table structure for f_before_build_info
-- ----------------------------
DROP TABLE IF EXISTS `f_before_build_info`;
CREATE TABLE `f_before_build_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `current_process` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `project_name` varchar(255) DEFAULT NULL,
  `order_source` varchar(255) DEFAULT NULL,
  `urgency_degree` varchar(255) DEFAULT NULL,
  `finish_time` varchar(255) DEFAULT NULL,
  `online_system_send_people` varchar(255) DEFAULT NULL,
  `online_system_send_people_phone` varchar(255) DEFAULT NULL,
  `client_id` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `bussiness_apply_company` varchar(255) DEFAULT NULL,
  `bussiness_apply_region` varchar(255) DEFAULT NULL,
  `bussiness_apply_network` varchar(255) DEFAULT NULL,
  `bussiness_need_type` varchar(255) DEFAULT NULL,
  `audio_line_number` int(11) DEFAULT NULL,
  `audio_out_number` int(11) DEFAULT NULL,
  `audio_other_number` int(11) DEFAULT NULL,
  `audio_is_v` varchar(255) DEFAULT NULL,
  `audio_machine_need` varchar(255) DEFAULT NULL,
  `network_service_level` varchar(255) DEFAULT NULL,
  `implement_type` varchar(255) DEFAULT NULL,
  `generic_cabling` varchar(255) DEFAULT NULL,
  `top_band` varchar(255) DEFAULT NULL,
  `bottom_band` varchar(255) DEFAULT NULL,
  `order_type` varchar(255) DEFAULT NULL,
  `implement_name` varchar(255) DEFAULT NULL,
  `implement_point_type` varchar(255) DEFAULT NULL,
  `a_address` varchar(255) DEFAULT NULL,
  `z_address` varchar(255) DEFAULT NULL,
  `before_files` varchar(255) DEFAULT NULL,
  `files` varchar(255) DEFAULT NULL,
  `is_big_device` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `resource_standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `resource_arrive` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `computer_is_finish` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `computer_address_is_have` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `cabinet_address_is_have` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `power_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `property_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `property_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `ip_num` int(11) DEFAULT NULL,
  `line_need_provide_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `power_need_provide_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `resource_judge_id` int(11) DEFAULT NULL,
  `system_scheme_id` int(11) DEFAULT NULL,
  `site_scheme_id` int(11) DEFAULT NULL,
  `webmaster_verify_id` int(11) DEFAULT NULL,
  `create_order_id` int(11) DEFAULT NULL,
  `bussiness_need_remark` varchar(255) DEFAULT NULL,
  `front_entry` varchar(255) DEFAULT NULL,
  `local_cover_id` int(11) DEFAULT NULL,
  `compound_cover_id` int(11) DEFAULT NULL,
  `local_site_scheme_id` int(11) DEFAULT NULL,
  `compound_site_scheme_id` int(11) DEFAULT NULL,
  `full_service_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_manager` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `client_manager_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `status` int(11) DEFAULT '1' COMMENT '1:正常，2：退单，3：退回上一步，4：挂起，5：保存，',
  `verify_status` int(11) unsigned DEFAULT '0' COMMENT '审核状态（1:市公司审核，2分公司审核，3客户经理审核 , 4成功 5驳回）',
  `abnormal_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常原因',
  `abnormal_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人',
  `abnormal_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人电话',
  `abnormal_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常备注',
  `estimate_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '预计完成时间',
  `back_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '退单原因',
  `hang_file` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起证明',
  `order_start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '工单开始时间',
  `hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '申请挂起时间',
  `relieve_hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '解挂时间',
  `branch_verify_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '分公司审核时间',
  `hang_reason` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起原因',
  `hang_num_of_client` int(11) DEFAULT '0' COMMENT '客户原因挂起天数',
  `hang_num_of_other` int(11) DEFAULT '0' COMMENT '非客户原因挂起天数',
  `client_manager_id` int(11) DEFAULT NULL COMMENT '客户经理ID',
  `is_need_supply_cable` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_before_build_info
-- ----------------------------
INSERT INTO `f_before_build_info` VALUES ('215', '前勘单', '[南海]-111（11）-互联网数据专线', null, '', '', '', '', null, '南海分公司-桂城-234-111--', '南海分公司', '南海东部-桂城|平洲', '南海东区政企中心（桂城、平洲）', '互联网数据专线', null, null, null, '', null, '', '', '', '', '', '', '', '', '', '', null, null, '是', '', '', '', '', '', '', '', '', null, '', '', '109', null, null, null, '84', '', '', '68', '69', null, null, 'GCJS-20210616-0002', null, null, null, null, null, null, '1', '0', null, null, null, null, null, null, null, '2021-06-16', null, null, null, null, '0', '0', '331', null);
INSERT INTO `f_before_build_info` VALUES ('216', '', '[123][123]-[禅城]-123（123）-互联网数据专线', null, '', '', '', '', null, '南海分公司-桂城-123-123-123-123', '南海分公司', '南海东部-桂城|平洲', '南海东区政企中心（桂城、平洲）', '互联网数据专线', null, null, null, '', null, '', '', '', '', '', '', '', '', '', '', null, null, '是', '', '', '', '', '', '', '', '', null, '', '', '110', null, null, null, '85', '', '', null, null, null, null, 'GCJS-20210616-0003', null, null, null, null, null, null, '1', '0', null, null, null, null, null, null, null, '2021-06-16', null, null, null, null, '0', '0', '331', null);

-- ----------------------------
-- Table structure for f_business
-- ----------------------------
DROP TABLE IF EXISTS `f_business`;
CREATE TABLE `f_business` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `connect_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接入地址',
  `business_need_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务需求类型',
  `son_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '子类型',
  `bring_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '集团下带电话',
  `money` decimal(30,2) DEFAULT NULL COMMENT '价格',
  `discount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '折扣',
  `discount_money` decimal(30,2) DEFAULT NULL COMMENT '折扣价',
  `resend_area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '转派区域',
  `client_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户名称',
  `client_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户联系号码',
  `client_manager_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户经理名称',
  `client_manager_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户经理联系号码',
  `up_net` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上行带宽',
  `down_net` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下行带宽',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `business_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商机单号',
  `order_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '商机下单时间',
  `child_company_train_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分公司商机转派时间',
  `area_train_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '片区转派时间',
  `account_manager_send_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户经理签收时间',
  `esop_send_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户经理派ESOP工单时间',
  `place_on_file_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服开归档时间',
  `now_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '当前处理节点用户',
  `procedure_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '流程所有流经的用户',
  `clique_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '集团名称',
  `other_need_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其他需求说明',
  `esop_order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'esop单号',
  `apply_user` int(11) DEFAULT NULL,
  `back_idea` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '退回意见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_business
-- ----------------------------
INSERT INTO `f_business` VALUES ('5', '禅城-张槎-123-123-123-123', '互联网超值版', null, null, null, null, null, null, '123', '123', '123', '123', '1230', '123', '123', '4', 'FS-20210616-0001', '2021-06-16 15:19:45', '2021-06-16 15:35:59', '2021-06-16 15:36:19', null, null, null, '359', '341,351,369', '123', '123', null, null, null);
INSERT INTO `f_business` VALUES ('6', '南海-平洲-qwe-qwe-qwe-qwe', 'SD-WAN', null, null, null, null, null, null, 'wq', 'w', '', '', '', '', '', '4', 'FS-20210616-0002', '2021-06-16 16:20:03', '2021-06-16 16:29:27', '2021-06-16 16:31:27', null, null, null, '362', '341,350,364', '', '', null, null, null);

-- ----------------------------
-- Table structure for f_business_acceptance
-- ----------------------------
DROP TABLE IF EXISTS `f_business_acceptance`;
CREATE TABLE `f_business_acceptance` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `is_complete_acceptance` varchar(11) DEFAULT NULL COMMENT '是否完成商务验收',
  `acceptance_participate_peple` varchar(255) DEFAULT NULL COMMENT '商务验收参与人员（格式：姓名（电话））',
  `acceptance_participate_time` varchar(255) DEFAULT NULL COMMENT '商务验收时间',
  `acceptance_participate_suggestion` varchar(255) DEFAULT NULL COMMENT '客户商务验收意见',
  `user_confirm_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户确认书',
  `files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其它附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_business_acceptance
-- ----------------------------
INSERT INTO `f_business_acceptance` VALUES ('1', '已完成', 'asd', '2021-05-26', 'asdasd', '5beb55023bfa4e0f8ae24acb84b864f4', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_business_acceptance` VALUES ('2', '暂时无法完成', 'asd', '2021-05-18', 'asdas', '5beb55023bfa4e0f8ae24acb84b864f4', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_business_acceptance` VALUES ('3', '已完成', 'asd', '2021-05-11', 'asd', '5beb55023bfa4e0f8ae24acb84b864f4', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_business_acceptance` VALUES ('4', '已完成', 'asd', '2021-05-25', 'xx', '5beb55023bfa4e0f8ae24acb84b864f4', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_business_acceptance` VALUES ('5', '已完成', '', '', '', null, null);

-- ----------------------------
-- Table structure for f_business_info
-- ----------------------------
DROP TABLE IF EXISTS `f_business_info`;
CREATE TABLE `f_business_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `order_num` varchar(255) DEFAULT NULL COMMENT '工单号',
  `business_belong_area` varchar(255) DEFAULT NULL COMMENT '业务所属地市',
  `product_num` int(11) DEFAULT NULL COMMENT '产品编号',
  `net_service_level` varchar(255) DEFAULT NULL COMMENT '业务的网络服务级别',
  `business_status` varchar(255) DEFAULT NULL COMMENT '业务状态',
  `acceptance_status` varchar(255) DEFAULT NULL COMMENT '验收状态',
  `open_date` varchar(255) DEFAULT NULL COMMENT '开通日期',
  `business_describe` varchar(255) DEFAULT NULL COMMENT '业务描述',
  `client_business_tech_linker` varchar(255) DEFAULT NULL COMMENT '客户的业务技术联系人',
  `client_business_tech_linker_phone` varchar(255) DEFAULT NULL COMMENT '客户业务技术联系人电话',
  `client_business_tech_linker_email` varchar(255) DEFAULT NULL COMMENT '客户的业务技术联系人EMAIL',
  `oa_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'OA文号',
  `sign_way` varchar(255) DEFAULT NULL COMMENT '信令方式',
  `sign_num` varchar(255) DEFAULT NULL COMMENT '信令点编码',
  `sign_agreement` varchar(255) DEFAULT NULL COMMENT '信令协议',
  `part_machine_room_name` varchar(255) DEFAULT NULL COMMENT '局端机房名称',
  `insert_net_type` varchar(255) DEFAULT NULL COMMENT '接入网元类型',
  `insert_net_name` varchar(255) DEFAULT NULL COMMENT '接入网元名称',
  `relay_num` varchar(255) DEFAULT NULL COMMENT '中继群号',
  `relay_name` varchar(255) DEFAULT NULL COMMENT '中继名称或路由名称',
  `relay_port` varchar(255) DEFAULT NULL COMMENT '中继端口',
  `pre_camera` varchar(255) DEFAULT NULL COMMENT '与MGW（UMG）/IP前置机相连的GW名',
  `call_phone_type` varchar(255) DEFAULT NULL COMMENT '呼出号码形式',
  `client_machine_room_address` varchar(255) DEFAULT NULL COMMENT '客户机房地址',
  `call_way` varchar(255) DEFAULT NULL COMMENT '拨号方式',
  `call_area` varchar(255) DEFAULT NULL COMMENT '呼出范围',
  `is_enable_international_call` varchar(255) DEFAULT NULL COMMENT '是否开通国际长途来话',
  `client_call_way` varchar(255) DEFAULT NULL COMMENT '客户端拨打方式',
  `num_info` varchar(255) DEFAULT NULL COMMENT '号码信息',
  `client_main_num` int(11) DEFAULT NULL COMMENT '客户总机号码',
  `client_part_num` int(11) DEFAULT NULL COMMENT '客户分机号码',
  `client_fax_num` int(11) DEFAULT NULL COMMENT '客户传真号码',
  `calculate_explain` varchar(255) DEFAULT NULL COMMENT '计费说明',
  `client_ip` varchar(255) DEFAULT NULL COMMENT '客户端IP地址',
  `client_device_property` varchar(255) DEFAULT NULL COMMENT '客户端设备产权',
  `client_device_factory` varchar(255) DEFAULT NULL COMMENT '客户端设备厂家',
  `client_device_model` varchar(255) DEFAULT NULL COMMENT '客户端设备型号',
  `two_m_circuit_num` int(11) DEFAULT NULL COMMENT '2M电路数',
  `transfer_circuit_num` varchar(255) DEFAULT NULL COMMENT '传输电路编号',
  `insert_net_device` varchar(255) DEFAULT NULL COMMENT '专线接入方式 传送网络接入设备类型',
  `transfer_net_device_name` varchar(255) DEFAULT NULL COMMENT '传送网络接入设备名称',
  `transfer_net_device_port` varchar(255) DEFAULT NULL COMMENT '传送网络接入设备端口',
  `insert_device_port_ethernet` varchar(255) DEFAULT NULL COMMENT '传送网络接入设备端口以太网TAG属性',
  `transfer_net_device_port_vlan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送网络接入设备端口VLAN',
  `transfer_net_device_port_in_vlan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送网络接入设备端口内层VLAN',
  `transfer_net_devicec_port_out_vlan` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送网络接入设备端口外层VLAN',
  `DDF_port_position` varchar(255) DEFAULT NULL COMMENT 'DDF/ODF架端口位置',
  `business_info_type` int(11) DEFAULT NULL COMMENT '业务信息类别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_business_info
-- ----------------------------
INSERT INTO `f_business_info` VALUES ('1', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for f_business_need_type
-- ----------------------------
DROP TABLE IF EXISTS `f_business_need_type`;
CREATE TABLE `f_business_need_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_need_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务需求类型',
  `son_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '子类型',
  `money` decimal(11,2) DEFAULT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=576 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_business_need_type
-- ----------------------------
INSERT INTO `f_business_need_type` VALUES ('1', '互联网专业版', '10', '750.00');
INSERT INTO `f_business_need_type` VALUES ('2', '互联网专业版', '20', '1400.00');
INSERT INTO `f_business_need_type` VALUES ('3', '互联网专业版', '30', '2033.33');
INSERT INTO `f_business_need_type` VALUES ('4', '互联网专业版', '40', '2666.67');
INSERT INTO `f_business_need_type` VALUES ('5', '互联网专业版', '50', '3300.00');
INSERT INTO `f_business_need_type` VALUES ('6', '互联网专业版', '60', '4020.00');
INSERT INTO `f_business_need_type` VALUES ('7', '互联网专业版', '70', '4740.00');
INSERT INTO `f_business_need_type` VALUES ('8', '互联网专业版', '80', '5460.00');
INSERT INTO `f_business_need_type` VALUES ('9', '互联网专业版', '90', '6180.00');
INSERT INTO `f_business_need_type` VALUES ('10', '互联网专业版', '100', '6900.00');
INSERT INTO `f_business_need_type` VALUES ('11', '互联网专业版', '120', '8220.00');
INSERT INTO `f_business_need_type` VALUES ('12', '互联网专业版', '140', '9540.00');
INSERT INTO `f_business_need_type` VALUES ('13', '互联网专业版', '150', '10200.00');
INSERT INTO `f_business_need_type` VALUES ('14', '互联网专业版', '160', '10860.00');
INSERT INTO `f_business_need_type` VALUES ('15', '互联网专业版', '180', '12180.00');
INSERT INTO `f_business_need_type` VALUES ('16', '互联网专业版', '200', '13500.00');
INSERT INTO `f_business_need_type` VALUES ('17', '互联网专业版', '250', '16666.67');
INSERT INTO `f_business_need_type` VALUES ('18', '互联网专业版', '300', '19833.33');
INSERT INTO `f_business_need_type` VALUES ('19', '互联网专业版', '350', '23000.00');
INSERT INTO `f_business_need_type` VALUES ('20', '互联网专业版', '400', '26166.67');
INSERT INTO `f_business_need_type` VALUES ('21', '互联网专业版', '450', '29333.33');
INSERT INTO `f_business_need_type` VALUES ('22', '互联网专业版', '500', '32500.00');
INSERT INTO `f_business_need_type` VALUES ('23', '互联网专业版', '600', '38034.35');
INSERT INTO `f_business_need_type` VALUES ('24', '互联网专业版', '700', '43568.70');
INSERT INTO `f_business_need_type` VALUES ('25', '互联网专业版', '800', '49103.05');
INSERT INTO `f_business_need_type` VALUES ('26', '互联网专业版', '900', '54637.40');
INSERT INTO `f_business_need_type` VALUES ('27', '互联网专业版', '1000', '60171.76');
INSERT INTO `f_business_need_type` VALUES ('28', '互联网专业版', '1002', '60282.44');
INSERT INTO `f_business_need_type` VALUES ('29', '互联网专业版', '1004', '60393.13');
INSERT INTO `f_business_need_type` VALUES ('30', '互联网专业版', '1006', '60503.82');
INSERT INTO `f_business_need_type` VALUES ('31', '互联网专业版', '1008', '60614.50');
INSERT INTO `f_business_need_type` VALUES ('32', '互联网专业版', '1010', '60725.19');
INSERT INTO `f_business_need_type` VALUES ('33', '互联网专业版', '1012', '60835.88');
INSERT INTO `f_business_need_type` VALUES ('34', '互联网专业版', '1014', '60946.56');
INSERT INTO `f_business_need_type` VALUES ('35', '互联网专业版', '1016', '61057.25');
INSERT INTO `f_business_need_type` VALUES ('36', '互联网专业版', '1018', '61167.94');
INSERT INTO `f_business_need_type` VALUES ('37', '互联网专业版', '1020', '61278.63');
INSERT INTO `f_business_need_type` VALUES ('38', '互联网专业版', '1022', '61389.31');
INSERT INTO `f_business_need_type` VALUES ('39', '互联网专业版', '1024', '61500.00');
INSERT INTO `f_business_need_type` VALUES ('40', '互联网专业版', '1026', '61604.17');
INSERT INTO `f_business_need_type` VALUES ('41', '互联网专业版', '1028', '61708.33');
INSERT INTO `f_business_need_type` VALUES ('42', '互联网专业版', '1030', '61812.50');
INSERT INTO `f_business_need_type` VALUES ('43', '互联网专业版', '1032', '61916.67');
INSERT INTO `f_business_need_type` VALUES ('44', '互联网专业版', '1034', '62020.83');
INSERT INTO `f_business_need_type` VALUES ('45', '互联网专业版', '1036', '62125.00');
INSERT INTO `f_business_need_type` VALUES ('46', '互联网专业版', '1038', '62229.17');
INSERT INTO `f_business_need_type` VALUES ('47', '互联网专业版', '1040', '62333.33');
INSERT INTO `f_business_need_type` VALUES ('48', '互联网专业版', '1042', '62437.50');
INSERT INTO `f_business_need_type` VALUES ('49', '互联网专业版', '1044', '62541.67');
INSERT INTO `f_business_need_type` VALUES ('50', '互联网专业版', '1046', '62645.83');
INSERT INTO `f_business_need_type` VALUES ('51', '互联网专业版', '1048', '62750.00');
INSERT INTO `f_business_need_type` VALUES ('52', '互联网专业版', '1050', '62854.17');
INSERT INTO `f_business_need_type` VALUES ('53', '互联网专业版', '1052', '62958.33');
INSERT INTO `f_business_need_type` VALUES ('54', '互联网专业版', '1054', '63062.50');
INSERT INTO `f_business_need_type` VALUES ('55', '互联网专业版', '1056', '63166.67');
INSERT INTO `f_business_need_type` VALUES ('56', '互联网专业版', '1058', '63270.83');
INSERT INTO `f_business_need_type` VALUES ('57', '互联网专业版', '1060', '63375.00');
INSERT INTO `f_business_need_type` VALUES ('58', '互联网专业版', '1062', '63479.17');
INSERT INTO `f_business_need_type` VALUES ('59', '互联网专业版', '1064', '63583.33');
INSERT INTO `f_business_need_type` VALUES ('60', '互联网专业版', '1066', '63687.50');
INSERT INTO `f_business_need_type` VALUES ('61', '互联网专业版', '1068', '63791.67');
INSERT INTO `f_business_need_type` VALUES ('62', '互联网专业版', '1070', '63895.83');
INSERT INTO `f_business_need_type` VALUES ('63', '互联网专业版', '1072', '64000.00');
INSERT INTO `f_business_need_type` VALUES ('64', '互联网专业版', '1074', '64104.17');
INSERT INTO `f_business_need_type` VALUES ('65', '互联网专业版', '1076', '64208.33');
INSERT INTO `f_business_need_type` VALUES ('66', '互联网专业版', '1078', '64312.50');
INSERT INTO `f_business_need_type` VALUES ('67', '互联网专业版', '1080', '64416.67');
INSERT INTO `f_business_need_type` VALUES ('68', '互联网专业版', '1082', '64520.83');
INSERT INTO `f_business_need_type` VALUES ('69', '互联网专业版', '1084', '64625.00');
INSERT INTO `f_business_need_type` VALUES ('70', '互联网专业版', '1086', '64729.17');
INSERT INTO `f_business_need_type` VALUES ('71', '互联网专业版', '1088', '64833.33');
INSERT INTO `f_business_need_type` VALUES ('72', '互联网专业版', '1090', '64937.50');
INSERT INTO `f_business_need_type` VALUES ('73', '互联网专业版', '1092', '65041.67');
INSERT INTO `f_business_need_type` VALUES ('74', '互联网专业版', '1094', '65145.83');
INSERT INTO `f_business_need_type` VALUES ('75', '互联网专业版', '1096', '65250.00');
INSERT INTO `f_business_need_type` VALUES ('76', '互联网专业版', '1098', '65354.17');
INSERT INTO `f_business_need_type` VALUES ('77', '互联网专业版', '1100', '65458.33');
INSERT INTO `f_business_need_type` VALUES ('78', '互联网专业版', '1102', '65562.50');
INSERT INTO `f_business_need_type` VALUES ('79', '互联网专业版', '1104', '65666.67');
INSERT INTO `f_business_need_type` VALUES ('80', '互联网专业版', '1106', '65770.83');
INSERT INTO `f_business_need_type` VALUES ('81', '互联网专业版', '1108', '65875.00');
INSERT INTO `f_business_need_type` VALUES ('82', '互联网专业版', '1110', '65979.17');
INSERT INTO `f_business_need_type` VALUES ('83', '互联网专业版', '1112', '66083.33');
INSERT INTO `f_business_need_type` VALUES ('84', '互联网专业版', '1114', '66187.50');
INSERT INTO `f_business_need_type` VALUES ('85', '互联网专业版', '1116', '66291.67');
INSERT INTO `f_business_need_type` VALUES ('86', '互联网专业版', '1118', '66395.83');
INSERT INTO `f_business_need_type` VALUES ('87', '互联网专业版', '1120', '66500.00');
INSERT INTO `f_business_need_type` VALUES ('88', '互联网专业版', '1122', '66604.17');
INSERT INTO `f_business_need_type` VALUES ('89', '互联网专业版', '1124', '66708.33');
INSERT INTO `f_business_need_type` VALUES ('90', '互联网专业版', '1126', '66812.50');
INSERT INTO `f_business_need_type` VALUES ('91', '互联网专业版', '1128', '66916.67');
INSERT INTO `f_business_need_type` VALUES ('92', '互联网专业版', '1130', '67020.83');
INSERT INTO `f_business_need_type` VALUES ('93', '互联网专业版', '1132', '67125.00');
INSERT INTO `f_business_need_type` VALUES ('94', '互联网专业版', '1134', '67229.17');
INSERT INTO `f_business_need_type` VALUES ('95', '互联网专业版', '1136', '67333.33');
INSERT INTO `f_business_need_type` VALUES ('96', '互联网专业版', '1138', '67437.50');
INSERT INTO `f_business_need_type` VALUES ('97', '互联网专业版', '1140', '67541.67');
INSERT INTO `f_business_need_type` VALUES ('98', '互联网专业版', '1142', '67645.83');
INSERT INTO `f_business_need_type` VALUES ('99', '互联网专业版', '1144', '67750.00');
INSERT INTO `f_business_need_type` VALUES ('100', '互联网专业版', '1146', '67854.17');
INSERT INTO `f_business_need_type` VALUES ('101', '互联网专业版', '1148', '67958.33');
INSERT INTO `f_business_need_type` VALUES ('102', '互联网专业版', '1150', '68062.50');
INSERT INTO `f_business_need_type` VALUES ('103', '互联网专业版', '1152', '68166.67');
INSERT INTO `f_business_need_type` VALUES ('104', '互联网专业版', '1154', '68270.83');
INSERT INTO `f_business_need_type` VALUES ('105', '互联网专业版', '1156', '68375.00');
INSERT INTO `f_business_need_type` VALUES ('106', '互联网专业版', '1158', '68479.17');
INSERT INTO `f_business_need_type` VALUES ('107', '互联网专业版', '1160', '68583.33');
INSERT INTO `f_business_need_type` VALUES ('108', '互联网专业版', '1162', '68687.50');
INSERT INTO `f_business_need_type` VALUES ('109', '互联网专业版', '1164', '68791.67');
INSERT INTO `f_business_need_type` VALUES ('110', '互联网专业版', '1166', '68895.83');
INSERT INTO `f_business_need_type` VALUES ('111', '互联网专业版', '1168', '69000.00');
INSERT INTO `f_business_need_type` VALUES ('112', '互联网专业版', '1170', '69104.17');
INSERT INTO `f_business_need_type` VALUES ('113', '互联网专业版', '1172', '69208.33');
INSERT INTO `f_business_need_type` VALUES ('114', '互联网专业版', '1174', '69312.50');
INSERT INTO `f_business_need_type` VALUES ('115', '互联网专业版', '1176', '69416.67');
INSERT INTO `f_business_need_type` VALUES ('116', '互联网专业版', '1178', '69520.83');
INSERT INTO `f_business_need_type` VALUES ('117', '互联网专业版', '1180', '69625.00');
INSERT INTO `f_business_need_type` VALUES ('118', '互联网专业版', '1182', '69729.17');
INSERT INTO `f_business_need_type` VALUES ('119', '互联网专业版', '1184', '69833.33');
INSERT INTO `f_business_need_type` VALUES ('120', '互联网专业版', '1186', '69937.50');
INSERT INTO `f_business_need_type` VALUES ('121', '互联网专业版', '1188', '70041.67');
INSERT INTO `f_business_need_type` VALUES ('122', '互联网专业版', '1190', '70145.83');
INSERT INTO `f_business_need_type` VALUES ('123', '互联网专业版', '1192', '70250.00');
INSERT INTO `f_business_need_type` VALUES ('124', '互联网专业版', '1194', '70354.17');
INSERT INTO `f_business_need_type` VALUES ('125', '互联网专业版', '1196', '70458.33');
INSERT INTO `f_business_need_type` VALUES ('126', '互联网专业版', '1198', '70562.50');
INSERT INTO `f_business_need_type` VALUES ('127', '互联网专业版', '1200', '70666.67');
INSERT INTO `f_business_need_type` VALUES ('128', '互联网专业版', '1202', '70770.83');
INSERT INTO `f_business_need_type` VALUES ('129', '互联网专业版', '1204', '70875.00');
INSERT INTO `f_business_need_type` VALUES ('130', '互联网专业版', '1206', '70979.17');
INSERT INTO `f_business_need_type` VALUES ('131', '互联网专业版', '1208', '71083.33');
INSERT INTO `f_business_need_type` VALUES ('132', '互联网专业版', '1210', '71187.50');
INSERT INTO `f_business_need_type` VALUES ('133', '互联网专业版', '1212', '71291.67');
INSERT INTO `f_business_need_type` VALUES ('134', '互联网专业版', '1214', '71395.83');
INSERT INTO `f_business_need_type` VALUES ('135', '互联网专业版', '1216', '71500.00');
INSERT INTO `f_business_need_type` VALUES ('136', '互联网专业版', '1218', '71604.17');
INSERT INTO `f_business_need_type` VALUES ('137', '互联网专业版', '1220', '71708.33');
INSERT INTO `f_business_need_type` VALUES ('138', '互联网专业版', '1222', '71812.50');
INSERT INTO `f_business_need_type` VALUES ('139', '互联网专业版', '1224', '71916.67');
INSERT INTO `f_business_need_type` VALUES ('140', '互联网专业版', '1226', '72020.83');
INSERT INTO `f_business_need_type` VALUES ('141', '互联网专业版', '1228', '72125.00');
INSERT INTO `f_business_need_type` VALUES ('142', '互联网专业版', '1230', '72229.17');
INSERT INTO `f_business_need_type` VALUES ('143', '互联网专业版', '1232', '72333.33');
INSERT INTO `f_business_need_type` VALUES ('144', '互联网专业版', '1234', '72437.50');
INSERT INTO `f_business_need_type` VALUES ('145', '互联网专业版', '1236', '72541.67');
INSERT INTO `f_business_need_type` VALUES ('146', '互联网专业版', '1238', '72645.83');
INSERT INTO `f_business_need_type` VALUES ('147', '互联网专业版', '1240', '72750.00');
INSERT INTO `f_business_need_type` VALUES ('148', '互联网专业版', '1242', '72854.17');
INSERT INTO `f_business_need_type` VALUES ('149', '互联网专业版', '1244', '72958.33');
INSERT INTO `f_business_need_type` VALUES ('150', '互联网专业版', '1246', '73062.50');
INSERT INTO `f_business_need_type` VALUES ('151', '互联网专业版', '1248', '73166.67');
INSERT INTO `f_business_need_type` VALUES ('152', '互联网专业版', '1250', '73270.83');
INSERT INTO `f_business_need_type` VALUES ('153', '互联网专业版', '1252', '73375.00');
INSERT INTO `f_business_need_type` VALUES ('154', '互联网专业版', '1254', '73479.17');
INSERT INTO `f_business_need_type` VALUES ('155', '互联网专业版', '1256', '73583.33');
INSERT INTO `f_business_need_type` VALUES ('156', '互联网专业版', '1258', '73687.50');
INSERT INTO `f_business_need_type` VALUES ('157', '互联网专业版', '1260', '73791.67');
INSERT INTO `f_business_need_type` VALUES ('158', '互联网专业版', '1262', '73895.83');
INSERT INTO `f_business_need_type` VALUES ('159', '互联网专业版', '1264', '74000.00');
INSERT INTO `f_business_need_type` VALUES ('160', '互联网专业版', '1266', '74104.17');
INSERT INTO `f_business_need_type` VALUES ('161', '互联网专业版', '1268', '74208.33');
INSERT INTO `f_business_need_type` VALUES ('162', '互联网专业版', '1270', '74312.50');
INSERT INTO `f_business_need_type` VALUES ('163', '互联网专业版', '1272', '74416.67');
INSERT INTO `f_business_need_type` VALUES ('164', '互联网专业版', '1274', '74520.83');
INSERT INTO `f_business_need_type` VALUES ('165', '互联网专业版', '1276', '74625.00');
INSERT INTO `f_business_need_type` VALUES ('166', '互联网专业版', '1278', '74729.17');
INSERT INTO `f_business_need_type` VALUES ('167', '互联网专业版', '1280', '74833.33');
INSERT INTO `f_business_need_type` VALUES ('168', '互联网专业版', '1282', '74937.50');
INSERT INTO `f_business_need_type` VALUES ('169', '互联网专业版', '1284', '75041.67');
INSERT INTO `f_business_need_type` VALUES ('170', '互联网专业版', '1286', '75145.83');
INSERT INTO `f_business_need_type` VALUES ('171', '互联网专业版', '1288', '75250.00');
INSERT INTO `f_business_need_type` VALUES ('172', '互联网专业版', '1290', '75354.17');
INSERT INTO `f_business_need_type` VALUES ('173', '互联网专业版', '1292', '75458.33');
INSERT INTO `f_business_need_type` VALUES ('174', '互联网专业版', '1294', '75562.50');
INSERT INTO `f_business_need_type` VALUES ('175', '互联网专业版', '1296', '75666.67');
INSERT INTO `f_business_need_type` VALUES ('176', '互联网专业版', '1298', '75770.83');
INSERT INTO `f_business_need_type` VALUES ('177', '互联网专业版', '1300', '75875.00');
INSERT INTO `f_business_need_type` VALUES ('178', '互联网专业版', '1302', '75979.17');
INSERT INTO `f_business_need_type` VALUES ('179', '互联网专业版', '1304', '76083.33');
INSERT INTO `f_business_need_type` VALUES ('180', '互联网专业版', '1306', '76187.50');
INSERT INTO `f_business_need_type` VALUES ('181', '互联网专业版', '1308', '76291.67');
INSERT INTO `f_business_need_type` VALUES ('182', '互联网专业版', '1310', '76395.83');
INSERT INTO `f_business_need_type` VALUES ('183', '互联网专业版', '1312', '76500.00');
INSERT INTO `f_business_need_type` VALUES ('184', '互联网专业版', '1314', '76604.17');
INSERT INTO `f_business_need_type` VALUES ('185', '互联网专业版', '1316', '76708.33');
INSERT INTO `f_business_need_type` VALUES ('186', '互联网专业版', '1318', '76812.50');
INSERT INTO `f_business_need_type` VALUES ('187', '互联网专业版', '1320', '76916.67');
INSERT INTO `f_business_need_type` VALUES ('188', '互联网专业版', '1322', '77020.83');
INSERT INTO `f_business_need_type` VALUES ('189', '互联网专业版', '1324', '77125.00');
INSERT INTO `f_business_need_type` VALUES ('190', '互联网专业版', '1326', '77229.17');
INSERT INTO `f_business_need_type` VALUES ('191', '互联网专业版', '1328', '77333.33');
INSERT INTO `f_business_need_type` VALUES ('192', '互联网专业版', '1330', '77437.50');
INSERT INTO `f_business_need_type` VALUES ('193', '互联网专业版', '1332', '77541.67');
INSERT INTO `f_business_need_type` VALUES ('194', '互联网专业版', '1334', '77645.83');
INSERT INTO `f_business_need_type` VALUES ('195', '互联网专业版', '1336', '77750.00');
INSERT INTO `f_business_need_type` VALUES ('196', '互联网专业版', '1338', '77854.17');
INSERT INTO `f_business_need_type` VALUES ('197', '互联网专业版', '1340', '77958.33');
INSERT INTO `f_business_need_type` VALUES ('198', '互联网专业版', '1342', '78062.50');
INSERT INTO `f_business_need_type` VALUES ('199', '互联网专业版', '1344', '78166.67');
INSERT INTO `f_business_need_type` VALUES ('200', '互联网专业版', '1346', '78270.83');
INSERT INTO `f_business_need_type` VALUES ('201', '互联网专业版', '1348', '78375.00');
INSERT INTO `f_business_need_type` VALUES ('202', '互联网专业版', '1350', '78479.17');
INSERT INTO `f_business_need_type` VALUES ('203', '互联网专业版', '1352', '78583.33');
INSERT INTO `f_business_need_type` VALUES ('204', '互联网专业版', '1354', '78687.50');
INSERT INTO `f_business_need_type` VALUES ('205', '互联网专业版', '1356', '78791.67');
INSERT INTO `f_business_need_type` VALUES ('206', '互联网专业版', '1358', '78895.83');
INSERT INTO `f_business_need_type` VALUES ('207', '互联网专业版', '1360', '79000.00');
INSERT INTO `f_business_need_type` VALUES ('208', '互联网专业版', '1362', '79104.17');
INSERT INTO `f_business_need_type` VALUES ('209', '互联网专业版', '1364', '79208.33');
INSERT INTO `f_business_need_type` VALUES ('210', '互联网专业版', '1366', '79312.50');
INSERT INTO `f_business_need_type` VALUES ('211', '互联网专业版', '1368', '79416.67');
INSERT INTO `f_business_need_type` VALUES ('212', '互联网专业版', '1370', '79520.83');
INSERT INTO `f_business_need_type` VALUES ('213', '互联网专业版', '1372', '79625.00');
INSERT INTO `f_business_need_type` VALUES ('214', '互联网专业版', '1374', '79729.17');
INSERT INTO `f_business_need_type` VALUES ('215', '互联网专业版', '1376', '79833.33');
INSERT INTO `f_business_need_type` VALUES ('216', '互联网专业版', '1378', '79937.50');
INSERT INTO `f_business_need_type` VALUES ('217', '互联网专业版', '1380', '80041.67');
INSERT INTO `f_business_need_type` VALUES ('218', '互联网专业版', '1382', '80145.83');
INSERT INTO `f_business_need_type` VALUES ('219', '互联网专业版', '1384', '80250.00');
INSERT INTO `f_business_need_type` VALUES ('220', '互联网专业版', '1386', '80354.17');
INSERT INTO `f_business_need_type` VALUES ('221', '互联网专业版', '1388', '80458.33');
INSERT INTO `f_business_need_type` VALUES ('222', '互联网专业版', '1390', '80562.50');
INSERT INTO `f_business_need_type` VALUES ('223', '互联网专业版', '1392', '80666.67');
INSERT INTO `f_business_need_type` VALUES ('224', '互联网专业版', '1394', '80770.83');
INSERT INTO `f_business_need_type` VALUES ('225', '互联网专业版', '1396', '80875.00');
INSERT INTO `f_business_need_type` VALUES ('226', '互联网专业版', '1398', '80979.17');
INSERT INTO `f_business_need_type` VALUES ('227', '互联网专业版', '1400', '81083.33');
INSERT INTO `f_business_need_type` VALUES ('228', '互联网专业版', '1402', '81187.50');
INSERT INTO `f_business_need_type` VALUES ('229', '互联网专业版', '1404', '81291.67');
INSERT INTO `f_business_need_type` VALUES ('230', '互联网专业版', '1406', '81395.83');
INSERT INTO `f_business_need_type` VALUES ('231', '互联网专业版', '1408', '81500.00');
INSERT INTO `f_business_need_type` VALUES ('232', '互联网专业版', '1410', '81604.17');
INSERT INTO `f_business_need_type` VALUES ('233', '互联网专业版', '1412', '81708.33');
INSERT INTO `f_business_need_type` VALUES ('234', '互联网专业版', '1414', '81812.50');
INSERT INTO `f_business_need_type` VALUES ('235', '互联网专业版', '1416', '81916.67');
INSERT INTO `f_business_need_type` VALUES ('236', '互联网专业版', '1418', '82020.83');
INSERT INTO `f_business_need_type` VALUES ('237', '互联网专业版', '1420', '82125.00');
INSERT INTO `f_business_need_type` VALUES ('238', '互联网专业版', '1422', '82229.17');
INSERT INTO `f_business_need_type` VALUES ('239', '互联网专业版', '1424', '82333.33');
INSERT INTO `f_business_need_type` VALUES ('240', '互联网专业版', '1426', '82437.50');
INSERT INTO `f_business_need_type` VALUES ('241', '互联网专业版', '1428', '82541.67');
INSERT INTO `f_business_need_type` VALUES ('242', '互联网专业版', '1430', '82645.83');
INSERT INTO `f_business_need_type` VALUES ('243', '互联网专业版', '1432', '82750.00');
INSERT INTO `f_business_need_type` VALUES ('244', '互联网专业版', '1434', '82854.17');
INSERT INTO `f_business_need_type` VALUES ('245', '互联网专业版', '1436', '82958.33');
INSERT INTO `f_business_need_type` VALUES ('246', '互联网专业版', '1438', '83062.50');
INSERT INTO `f_business_need_type` VALUES ('247', '互联网专业版', '1440', '83166.67');
INSERT INTO `f_business_need_type` VALUES ('248', '互联网专业版', '1442', '83270.83');
INSERT INTO `f_business_need_type` VALUES ('249', '互联网专业版', '1444', '83375.00');
INSERT INTO `f_business_need_type` VALUES ('250', '互联网专业版', '1446', '83479.17');
INSERT INTO `f_business_need_type` VALUES ('251', '互联网专业版', '1448', '83583.33');
INSERT INTO `f_business_need_type` VALUES ('252', '互联网专业版', '1450', '83687.50');
INSERT INTO `f_business_need_type` VALUES ('253', '互联网专业版', '1452', '83791.67');
INSERT INTO `f_business_need_type` VALUES ('254', '互联网专业版', '1454', '83895.83');
INSERT INTO `f_business_need_type` VALUES ('255', '互联网专业版', '1456', '84000.00');
INSERT INTO `f_business_need_type` VALUES ('256', '互联网专业版', '1458', '84104.17');
INSERT INTO `f_business_need_type` VALUES ('257', '互联网专业版', '1460', '84208.33');
INSERT INTO `f_business_need_type` VALUES ('258', '互联网专业版', '1462', '84312.50');
INSERT INTO `f_business_need_type` VALUES ('259', '互联网专业版', '1464', '84416.67');
INSERT INTO `f_business_need_type` VALUES ('260', '互联网专业版', '1466', '84520.83');
INSERT INTO `f_business_need_type` VALUES ('261', '互联网专业版', '1468', '84625.00');
INSERT INTO `f_business_need_type` VALUES ('262', '互联网专业版', '1470', '84729.17');
INSERT INTO `f_business_need_type` VALUES ('263', '互联网专业版', '1472', '84833.33');
INSERT INTO `f_business_need_type` VALUES ('264', '互联网专业版', '1474', '84937.50');
INSERT INTO `f_business_need_type` VALUES ('265', '互联网专业版', '1476', '85041.67');
INSERT INTO `f_business_need_type` VALUES ('266', '互联网专业版', '1478', '85145.83');
INSERT INTO `f_business_need_type` VALUES ('267', '互联网专业版', '1480', '85250.00');
INSERT INTO `f_business_need_type` VALUES ('268', '互联网专业版', '1482', '85354.17');
INSERT INTO `f_business_need_type` VALUES ('269', '互联网专业版', '1484', '85458.33');
INSERT INTO `f_business_need_type` VALUES ('270', '互联网专业版', '1486', '85562.50');
INSERT INTO `f_business_need_type` VALUES ('271', '互联网专业版', '1488', '85666.67');
INSERT INTO `f_business_need_type` VALUES ('272', '互联网专业版', '1490', '85770.83');
INSERT INTO `f_business_need_type` VALUES ('273', '互联网专业版', '1492', '85875.00');
INSERT INTO `f_business_need_type` VALUES ('274', '互联网专业版', '1494', '85979.17');
INSERT INTO `f_business_need_type` VALUES ('275', '互联网专业版', '1496', '86083.33');
INSERT INTO `f_business_need_type` VALUES ('276', '互联网专业版', '1498', '86187.50');
INSERT INTO `f_business_need_type` VALUES ('277', '互联网专业版', '1500', '86291.67');
INSERT INTO `f_business_need_type` VALUES ('278', '互联网专业版', '1502', '86395.83');
INSERT INTO `f_business_need_type` VALUES ('279', '互联网专业版', '1504', '86500.00');
INSERT INTO `f_business_need_type` VALUES ('280', '互联网专业版', '1506', '86604.17');
INSERT INTO `f_business_need_type` VALUES ('281', '互联网专业版', '1508', '86708.33');
INSERT INTO `f_business_need_type` VALUES ('282', '互联网专业版', '1510', '86812.50');
INSERT INTO `f_business_need_type` VALUES ('283', '互联网专业版', '1512', '86916.67');
INSERT INTO `f_business_need_type` VALUES ('284', '互联网专业版', '1514', '87020.83');
INSERT INTO `f_business_need_type` VALUES ('285', '互联网专业版', '1516', '87125.00');
INSERT INTO `f_business_need_type` VALUES ('286', '互联网专业版', '1518', '87229.17');
INSERT INTO `f_business_need_type` VALUES ('287', '互联网专业版', '1520', '87333.33');
INSERT INTO `f_business_need_type` VALUES ('288', '互联网专业版', '1522', '87437.50');
INSERT INTO `f_business_need_type` VALUES ('289', '互联网专业版', '1524', '87541.67');
INSERT INTO `f_business_need_type` VALUES ('290', '互联网专业版', '1526', '87645.83');
INSERT INTO `f_business_need_type` VALUES ('291', '互联网专业版', '1528', '87750.00');
INSERT INTO `f_business_need_type` VALUES ('292', '互联网专业版', '1530', '87854.17');
INSERT INTO `f_business_need_type` VALUES ('293', '互联网专业版', '1532', '87958.33');
INSERT INTO `f_business_need_type` VALUES ('294', '互联网专业版', '1534', '88062.50');
INSERT INTO `f_business_need_type` VALUES ('295', '互联网专业版', '1536', '88166.67');
INSERT INTO `f_business_need_type` VALUES ('296', '互联网专业版', '1538', '88270.83');
INSERT INTO `f_business_need_type` VALUES ('297', '互联网专业版', '1540', '88375.00');
INSERT INTO `f_business_need_type` VALUES ('298', '互联网专业版', '1542', '88479.17');
INSERT INTO `f_business_need_type` VALUES ('299', '互联网专业版', '1544', '88583.33');
INSERT INTO `f_business_need_type` VALUES ('300', '互联网专业版', '1546', '88687.50');
INSERT INTO `f_business_need_type` VALUES ('301', '互联网专业版', '1548', '88791.67');
INSERT INTO `f_business_need_type` VALUES ('302', '互联网专业版', '1550', '88895.83');
INSERT INTO `f_business_need_type` VALUES ('303', '互联网专业版', '1552', '89000.00');
INSERT INTO `f_business_need_type` VALUES ('304', '互联网专业版', '1554', '89104.17');
INSERT INTO `f_business_need_type` VALUES ('305', '互联网专业版', '1556', '89208.33');
INSERT INTO `f_business_need_type` VALUES ('306', '互联网专业版', '1558', '89312.50');
INSERT INTO `f_business_need_type` VALUES ('307', '互联网专业版', '1560', '89416.67');
INSERT INTO `f_business_need_type` VALUES ('308', '互联网专业版', '1562', '89520.83');
INSERT INTO `f_business_need_type` VALUES ('309', '互联网专业版', '1564', '89625.00');
INSERT INTO `f_business_need_type` VALUES ('310', '互联网专业版', '1566', '89729.17');
INSERT INTO `f_business_need_type` VALUES ('311', '互联网专业版', '1568', '89833.33');
INSERT INTO `f_business_need_type` VALUES ('312', '互联网专业版', '1570', '89937.50');
INSERT INTO `f_business_need_type` VALUES ('313', '互联网专业版', '1572', '90041.67');
INSERT INTO `f_business_need_type` VALUES ('314', '互联网专业版', '1574', '90145.83');
INSERT INTO `f_business_need_type` VALUES ('315', '互联网专业版', '1576', '90250.00');
INSERT INTO `f_business_need_type` VALUES ('316', '互联网专业版', '1578', '90354.17');
INSERT INTO `f_business_need_type` VALUES ('317', '互联网专业版', '1580', '90458.33');
INSERT INTO `f_business_need_type` VALUES ('318', '互联网专业版', '1582', '90562.50');
INSERT INTO `f_business_need_type` VALUES ('319', '互联网专业版', '1584', '90666.67');
INSERT INTO `f_business_need_type` VALUES ('320', '互联网专业版', '1586', '90770.83');
INSERT INTO `f_business_need_type` VALUES ('321', '互联网专业版', '1588', '90875.00');
INSERT INTO `f_business_need_type` VALUES ('322', '互联网专业版', '1590', '90979.17');
INSERT INTO `f_business_need_type` VALUES ('323', '互联网专业版', '1592', '91083.33');
INSERT INTO `f_business_need_type` VALUES ('324', '互联网专业版', '1594', '91187.50');
INSERT INTO `f_business_need_type` VALUES ('325', '互联网专业版', '1596', '91291.67');
INSERT INTO `f_business_need_type` VALUES ('326', '互联网专业版', '1598', '91395.83');
INSERT INTO `f_business_need_type` VALUES ('327', '互联网专业版', '1600', '91500.00');
INSERT INTO `f_business_need_type` VALUES ('328', '互联网专业版', '1602', '91604.17');
INSERT INTO `f_business_need_type` VALUES ('329', '互联网专业版', '1604', '91708.33');
INSERT INTO `f_business_need_type` VALUES ('330', '互联网专业版', '1606', '91812.50');
INSERT INTO `f_business_need_type` VALUES ('331', '互联网专业版', '1608', '91916.67');
INSERT INTO `f_business_need_type` VALUES ('332', '互联网专业版', '1610', '92020.83');
INSERT INTO `f_business_need_type` VALUES ('333', '互联网专业版', '1612', '92125.00');
INSERT INTO `f_business_need_type` VALUES ('334', '互联网专业版', '1614', '92229.17');
INSERT INTO `f_business_need_type` VALUES ('335', '互联网专业版', '1616', '92333.33');
INSERT INTO `f_business_need_type` VALUES ('336', '互联网专业版', '1618', '92437.50');
INSERT INTO `f_business_need_type` VALUES ('337', '互联网专业版', '1620', '92541.67');
INSERT INTO `f_business_need_type` VALUES ('338', '互联网专业版', '1622', '92645.83');
INSERT INTO `f_business_need_type` VALUES ('339', '互联网专业版', '1624', '92750.00');
INSERT INTO `f_business_need_type` VALUES ('340', '互联网专业版', '1626', '92854.17');
INSERT INTO `f_business_need_type` VALUES ('341', '互联网专业版', '1628', '92958.33');
INSERT INTO `f_business_need_type` VALUES ('342', '互联网专业版', '1630', '93062.50');
INSERT INTO `f_business_need_type` VALUES ('343', '互联网专业版', '1632', '93166.67');
INSERT INTO `f_business_need_type` VALUES ('344', '互联网专业版', '1634', '93270.83');
INSERT INTO `f_business_need_type` VALUES ('345', '互联网专业版', '1636', '93375.00');
INSERT INTO `f_business_need_type` VALUES ('346', '互联网专业版', '1638', '93479.17');
INSERT INTO `f_business_need_type` VALUES ('347', '互联网专业版', '1640', '93583.33');
INSERT INTO `f_business_need_type` VALUES ('348', '互联网专业版', '1642', '93687.50');
INSERT INTO `f_business_need_type` VALUES ('349', '互联网专业版', '1644', '93791.67');
INSERT INTO `f_business_need_type` VALUES ('350', '互联网专业版', '1646', '93895.83');
INSERT INTO `f_business_need_type` VALUES ('351', '互联网专业版', '1648', '94000.00');
INSERT INTO `f_business_need_type` VALUES ('352', '互联网专业版', '1650', '94104.17');
INSERT INTO `f_business_need_type` VALUES ('353', '互联网专业版', '1652', '94208.33');
INSERT INTO `f_business_need_type` VALUES ('354', '互联网专业版', '1654', '94312.50');
INSERT INTO `f_business_need_type` VALUES ('355', '互联网专业版', '1656', '94416.67');
INSERT INTO `f_business_need_type` VALUES ('356', '互联网专业版', '1658', '94520.83');
INSERT INTO `f_business_need_type` VALUES ('357', '互联网专业版', '1660', '94625.00');
INSERT INTO `f_business_need_type` VALUES ('358', '互联网专业版', '1662', '94729.17');
INSERT INTO `f_business_need_type` VALUES ('359', '互联网专业版', '1664', '94833.33');
INSERT INTO `f_business_need_type` VALUES ('360', '互联网专业版', '1666', '94937.50');
INSERT INTO `f_business_need_type` VALUES ('361', '互联网专业版', '1668', '95041.67');
INSERT INTO `f_business_need_type` VALUES ('362', '互联网专业版', '1670', '95145.83');
INSERT INTO `f_business_need_type` VALUES ('363', '互联网专业版', '1672', '95250.00');
INSERT INTO `f_business_need_type` VALUES ('364', '互联网专业版', '1674', '95354.17');
INSERT INTO `f_business_need_type` VALUES ('365', '互联网专业版', '1676', '95458.33');
INSERT INTO `f_business_need_type` VALUES ('366', '互联网专业版', '1678', '95562.50');
INSERT INTO `f_business_need_type` VALUES ('367', '互联网专业版', '1680', '95666.67');
INSERT INTO `f_business_need_type` VALUES ('368', '互联网专业版', '1682', '95770.83');
INSERT INTO `f_business_need_type` VALUES ('369', '互联网专业版', '1684', '95875.00');
INSERT INTO `f_business_need_type` VALUES ('370', '互联网专业版', '1686', '95979.17');
INSERT INTO `f_business_need_type` VALUES ('371', '互联网专业版', '1688', '96083.33');
INSERT INTO `f_business_need_type` VALUES ('372', '互联网专业版', '1690', '96187.50');
INSERT INTO `f_business_need_type` VALUES ('373', '互联网专业版', '1692', '96291.67');
INSERT INTO `f_business_need_type` VALUES ('374', '互联网专业版', '1694', '96395.83');
INSERT INTO `f_business_need_type` VALUES ('375', '互联网专业版', '1696', '96500.00');
INSERT INTO `f_business_need_type` VALUES ('376', '互联网专业版', '1698', '96604.17');
INSERT INTO `f_business_need_type` VALUES ('377', '互联网专业版', '1700', '96708.33');
INSERT INTO `f_business_need_type` VALUES ('378', '互联网专业版', '1702', '96812.50');
INSERT INTO `f_business_need_type` VALUES ('379', '互联网专业版', '1704', '96916.67');
INSERT INTO `f_business_need_type` VALUES ('380', '互联网专业版', '1706', '97020.83');
INSERT INTO `f_business_need_type` VALUES ('381', '互联网专业版', '1708', '97125.00');
INSERT INTO `f_business_need_type` VALUES ('382', '互联网专业版', '1710', '97229.17');
INSERT INTO `f_business_need_type` VALUES ('383', '互联网专业版', '1712', '97333.33');
INSERT INTO `f_business_need_type` VALUES ('384', '互联网专业版', '1714', '97437.50');
INSERT INTO `f_business_need_type` VALUES ('385', '互联网专业版', '1716', '97541.67');
INSERT INTO `f_business_need_type` VALUES ('386', '互联网专业版', '1718', '97645.83');
INSERT INTO `f_business_need_type` VALUES ('387', '互联网专业版', '1720', '97750.00');
INSERT INTO `f_business_need_type` VALUES ('388', '互联网专业版', '1722', '97854.17');
INSERT INTO `f_business_need_type` VALUES ('389', '互联网专业版', '1724', '97958.33');
INSERT INTO `f_business_need_type` VALUES ('390', '互联网专业版', '1726', '98062.50');
INSERT INTO `f_business_need_type` VALUES ('391', '互联网专业版', '1728', '98166.67');
INSERT INTO `f_business_need_type` VALUES ('392', '互联网专业版', '1730', '98270.83');
INSERT INTO `f_business_need_type` VALUES ('393', '互联网专业版', '1732', '98375.00');
INSERT INTO `f_business_need_type` VALUES ('394', '互联网专业版', '1734', '98479.17');
INSERT INTO `f_business_need_type` VALUES ('395', '互联网专业版', '1736', '98583.33');
INSERT INTO `f_business_need_type` VALUES ('396', '互联网专业版', '1738', '98687.50');
INSERT INTO `f_business_need_type` VALUES ('397', '互联网专业版', '1740', '98791.67');
INSERT INTO `f_business_need_type` VALUES ('398', '互联网专业版', '1742', '98895.83');
INSERT INTO `f_business_need_type` VALUES ('399', '互联网专业版', '1744', '99000.00');
INSERT INTO `f_business_need_type` VALUES ('400', '互联网专业版', '1746', '99104.17');
INSERT INTO `f_business_need_type` VALUES ('401', '互联网专业版', '1748', '99208.33');
INSERT INTO `f_business_need_type` VALUES ('402', '互联网专业版', '1750', '99312.50');
INSERT INTO `f_business_need_type` VALUES ('403', '互联网专业版', '1752', '99416.67');
INSERT INTO `f_business_need_type` VALUES ('404', '互联网专业版', '1754', '99520.83');
INSERT INTO `f_business_need_type` VALUES ('405', '互联网专业版', '1756', '99625.00');
INSERT INTO `f_business_need_type` VALUES ('406', '互联网专业版', '1758', '99729.17');
INSERT INTO `f_business_need_type` VALUES ('407', '互联网专业版', '1760', '99833.33');
INSERT INTO `f_business_need_type` VALUES ('408', '互联网专业版', '1762', '99937.50');
INSERT INTO `f_business_need_type` VALUES ('409', '互联网专业版', '1764', '100041.67');
INSERT INTO `f_business_need_type` VALUES ('410', '互联网专业版', '1766', '100145.83');
INSERT INTO `f_business_need_type` VALUES ('411', '互联网专业版', '1768', '100250.00');
INSERT INTO `f_business_need_type` VALUES ('412', '互联网专业版', '1770', '100354.17');
INSERT INTO `f_business_need_type` VALUES ('413', '互联网专业版', '1772', '100458.33');
INSERT INTO `f_business_need_type` VALUES ('414', '互联网专业版', '1774', '100562.50');
INSERT INTO `f_business_need_type` VALUES ('415', '互联网专业版', '1776', '100666.67');
INSERT INTO `f_business_need_type` VALUES ('416', '互联网专业版', '1778', '100770.83');
INSERT INTO `f_business_need_type` VALUES ('417', '互联网专业版', '1780', '100875.00');
INSERT INTO `f_business_need_type` VALUES ('418', '互联网专业版', '1782', '100979.17');
INSERT INTO `f_business_need_type` VALUES ('419', '互联网专业版', '1784', '101083.33');
INSERT INTO `f_business_need_type` VALUES ('420', '互联网专业版', '1786', '101187.50');
INSERT INTO `f_business_need_type` VALUES ('421', '互联网专业版', '1788', '101291.67');
INSERT INTO `f_business_need_type` VALUES ('422', '互联网专业版', '1790', '101395.83');
INSERT INTO `f_business_need_type` VALUES ('423', '互联网专业版', '1792', '101500.00');
INSERT INTO `f_business_need_type` VALUES ('424', '互联网专业版', '1794', '101604.17');
INSERT INTO `f_business_need_type` VALUES ('425', '互联网专业版', '1796', '101708.33');
INSERT INTO `f_business_need_type` VALUES ('426', '互联网专业版', '1798', '101812.50');
INSERT INTO `f_business_need_type` VALUES ('427', '互联网专业版', '1800', '101916.67');
INSERT INTO `f_business_need_type` VALUES ('428', '互联网专业版', '1802', '102020.83');
INSERT INTO `f_business_need_type` VALUES ('429', '互联网专业版', '1804', '102125.00');
INSERT INTO `f_business_need_type` VALUES ('430', '互联网专业版', '1806', '102229.17');
INSERT INTO `f_business_need_type` VALUES ('431', '互联网专业版', '1808', '102333.33');
INSERT INTO `f_business_need_type` VALUES ('432', '互联网专业版', '1810', '102437.50');
INSERT INTO `f_business_need_type` VALUES ('433', '互联网专业版', '1812', '102541.67');
INSERT INTO `f_business_need_type` VALUES ('434', '互联网专业版', '1814', '102645.83');
INSERT INTO `f_business_need_type` VALUES ('435', '互联网专业版', '1816', '102750.00');
INSERT INTO `f_business_need_type` VALUES ('436', '互联网专业版', '1818', '102854.17');
INSERT INTO `f_business_need_type` VALUES ('437', '互联网专业版', '1820', '102958.33');
INSERT INTO `f_business_need_type` VALUES ('438', '互联网专业版', '1822', '103062.50');
INSERT INTO `f_business_need_type` VALUES ('439', '互联网专业版', '1824', '103166.67');
INSERT INTO `f_business_need_type` VALUES ('440', '互联网专业版', '1826', '103270.83');
INSERT INTO `f_business_need_type` VALUES ('441', '互联网专业版', '1828', '103375.00');
INSERT INTO `f_business_need_type` VALUES ('442', '互联网专业版', '1830', '103479.17');
INSERT INTO `f_business_need_type` VALUES ('443', '互联网专业版', '1832', '103583.33');
INSERT INTO `f_business_need_type` VALUES ('444', '互联网专业版', '1834', '103687.50');
INSERT INTO `f_business_need_type` VALUES ('445', '互联网专业版', '1836', '103791.67');
INSERT INTO `f_business_need_type` VALUES ('446', '互联网专业版', '1838', '103895.83');
INSERT INTO `f_business_need_type` VALUES ('447', '互联网专业版', '1840', '104000.00');
INSERT INTO `f_business_need_type` VALUES ('448', '互联网专业版', '1842', '104104.17');
INSERT INTO `f_business_need_type` VALUES ('449', '互联网专业版', '1844', '104208.33');
INSERT INTO `f_business_need_type` VALUES ('450', '互联网专业版', '1846', '104312.50');
INSERT INTO `f_business_need_type` VALUES ('451', '互联网专业版', '1848', '104416.67');
INSERT INTO `f_business_need_type` VALUES ('452', '互联网专业版', '1850', '104520.83');
INSERT INTO `f_business_need_type` VALUES ('453', '互联网专业版', '1852', '104625.00');
INSERT INTO `f_business_need_type` VALUES ('454', '互联网专业版', '1854', '104729.17');
INSERT INTO `f_business_need_type` VALUES ('455', '互联网专业版', '1856', '104833.33');
INSERT INTO `f_business_need_type` VALUES ('456', '互联网专业版', '1858', '104937.50');
INSERT INTO `f_business_need_type` VALUES ('457', '互联网专业版', '1860', '105041.67');
INSERT INTO `f_business_need_type` VALUES ('458', '互联网专业版', '1862', '105145.83');
INSERT INTO `f_business_need_type` VALUES ('459', '互联网专业版', '1864', '105250.00');
INSERT INTO `f_business_need_type` VALUES ('460', '互联网专业版', '1866', '105354.17');
INSERT INTO `f_business_need_type` VALUES ('461', '互联网专业版', '1868', '105458.33');
INSERT INTO `f_business_need_type` VALUES ('462', '互联网专业版', '1870', '105562.50');
INSERT INTO `f_business_need_type` VALUES ('463', '互联网专业版', '1872', '105666.67');
INSERT INTO `f_business_need_type` VALUES ('464', '互联网专业版', '1874', '105770.83');
INSERT INTO `f_business_need_type` VALUES ('465', '互联网专业版', '1876', '105875.00');
INSERT INTO `f_business_need_type` VALUES ('466', '互联网专业版', '1878', '105979.17');
INSERT INTO `f_business_need_type` VALUES ('467', '互联网专业版', '1880', '106083.33');
INSERT INTO `f_business_need_type` VALUES ('468', '互联网专业版', '1882', '106187.50');
INSERT INTO `f_business_need_type` VALUES ('469', '互联网专业版', '1884', '106291.67');
INSERT INTO `f_business_need_type` VALUES ('470', '互联网专业版', '1886', '106395.83');
INSERT INTO `f_business_need_type` VALUES ('471', '互联网专业版', '1888', '106500.00');
INSERT INTO `f_business_need_type` VALUES ('472', '互联网专业版', '1890', '106604.17');
INSERT INTO `f_business_need_type` VALUES ('473', '互联网专业版', '1892', '106708.33');
INSERT INTO `f_business_need_type` VALUES ('474', '互联网专业版', '1894', '106812.50');
INSERT INTO `f_business_need_type` VALUES ('475', '互联网专业版', '1896', '106916.67');
INSERT INTO `f_business_need_type` VALUES ('476', '互联网专业版', '1898', '107020.83');
INSERT INTO `f_business_need_type` VALUES ('477', '互联网专业版', '1900', '107125.00');
INSERT INTO `f_business_need_type` VALUES ('478', '互联网专业版', '1902', '107229.17');
INSERT INTO `f_business_need_type` VALUES ('479', '互联网专业版', '1904', '107333.33');
INSERT INTO `f_business_need_type` VALUES ('480', '互联网专业版', '1906', '107437.50');
INSERT INTO `f_business_need_type` VALUES ('481', '互联网专业版', '1908', '107541.67');
INSERT INTO `f_business_need_type` VALUES ('482', '互联网专业版', '1910', '107645.83');
INSERT INTO `f_business_need_type` VALUES ('483', '互联网专业版', '1912', '107750.00');
INSERT INTO `f_business_need_type` VALUES ('484', '互联网专业版', '1914', '107854.17');
INSERT INTO `f_business_need_type` VALUES ('485', '互联网专业版', '1916', '107958.33');
INSERT INTO `f_business_need_type` VALUES ('486', '互联网专业版', '1918', '108062.50');
INSERT INTO `f_business_need_type` VALUES ('487', '互联网专业版', '1920', '108166.67');
INSERT INTO `f_business_need_type` VALUES ('488', '互联网专业版', '1922', '108270.83');
INSERT INTO `f_business_need_type` VALUES ('489', '互联网专业版', '1924', '108375.00');
INSERT INTO `f_business_need_type` VALUES ('490', '互联网专业版', '1926', '108479.17');
INSERT INTO `f_business_need_type` VALUES ('491', '互联网专业版', '1928', '108583.33');
INSERT INTO `f_business_need_type` VALUES ('492', '互联网专业版', '1930', '108687.50');
INSERT INTO `f_business_need_type` VALUES ('493', '互联网专业版', '1932', '108791.67');
INSERT INTO `f_business_need_type` VALUES ('494', '互联网专业版', '1934', '108895.83');
INSERT INTO `f_business_need_type` VALUES ('495', '互联网专业版', '1936', '109000.00');
INSERT INTO `f_business_need_type` VALUES ('496', '互联网专业版', '1938', '109104.17');
INSERT INTO `f_business_need_type` VALUES ('497', '互联网专业版', '1940', '109208.33');
INSERT INTO `f_business_need_type` VALUES ('498', '互联网专业版', '1942', '109312.50');
INSERT INTO `f_business_need_type` VALUES ('499', '互联网专业版', '1944', '109416.67');
INSERT INTO `f_business_need_type` VALUES ('500', '互联网专业版', '1946', '109520.83');
INSERT INTO `f_business_need_type` VALUES ('501', '互联网专业版', '1948', '109625.00');
INSERT INTO `f_business_need_type` VALUES ('502', '互联网专业版', '1950', '109729.17');
INSERT INTO `f_business_need_type` VALUES ('503', '互联网专业版', '1952', '109833.33');
INSERT INTO `f_business_need_type` VALUES ('504', '互联网专业版', '1954', '109937.50');
INSERT INTO `f_business_need_type` VALUES ('505', '互联网专业版', '1956', '110041.67');
INSERT INTO `f_business_need_type` VALUES ('506', '互联网专业版', '1958', '110145.83');
INSERT INTO `f_business_need_type` VALUES ('507', '互联网专业版', '1960', '110250.00');
INSERT INTO `f_business_need_type` VALUES ('508', '互联网专业版', '1962', '110354.17');
INSERT INTO `f_business_need_type` VALUES ('509', '互联网专业版', '1964', '110458.33');
INSERT INTO `f_business_need_type` VALUES ('510', '互联网专业版', '1966', '110562.50');
INSERT INTO `f_business_need_type` VALUES ('511', '互联网专业版', '1968', '110666.67');
INSERT INTO `f_business_need_type` VALUES ('512', '互联网专业版', '1970', '110770.83');
INSERT INTO `f_business_need_type` VALUES ('513', '互联网专业版', '1972', '110875.00');
INSERT INTO `f_business_need_type` VALUES ('514', '互联网专业版', '1974', '110979.17');
INSERT INTO `f_business_need_type` VALUES ('515', '互联网专业版', '1976', '111083.33');
INSERT INTO `f_business_need_type` VALUES ('516', '互联网专业版', '1978', '111187.50');
INSERT INTO `f_business_need_type` VALUES ('517', '互联网专业版', '1980', '111291.67');
INSERT INTO `f_business_need_type` VALUES ('518', '互联网专业版', '1982', '111395.83');
INSERT INTO `f_business_need_type` VALUES ('519', '互联网专业版', '1984', '111500.00');
INSERT INTO `f_business_need_type` VALUES ('520', '互联网专业版', '1986', '111604.17');
INSERT INTO `f_business_need_type` VALUES ('521', '互联网专业版', '1988', '111708.33');
INSERT INTO `f_business_need_type` VALUES ('522', '互联网专业版', '1990', '111812.50');
INSERT INTO `f_business_need_type` VALUES ('523', '互联网专业版', '1992', '111916.67');
INSERT INTO `f_business_need_type` VALUES ('524', '互联网专业版', '1994', '112020.83');
INSERT INTO `f_business_need_type` VALUES ('525', '互联网专业版', '1996', '112125.00');
INSERT INTO `f_business_need_type` VALUES ('526', '互联网专业版', '1998', '112229.17');
INSERT INTO `f_business_need_type` VALUES ('527', '互联网专业版', '2000', '112333.33');
INSERT INTO `f_business_need_type` VALUES ('528', '互联网基础版', '10', '500.00');
INSERT INTO `f_business_need_type` VALUES ('529', '互联网基础版', '20', '950.00');
INSERT INTO `f_business_need_type` VALUES ('530', '互联网基础版', '30', '1366.67');
INSERT INTO `f_business_need_type` VALUES ('531', '互联网基础版', '40', '1783.33');
INSERT INTO `f_business_need_type` VALUES ('532', '互联网基础版', '50', '2200.00');
INSERT INTO `f_business_need_type` VALUES ('533', '互联网基础版', '60', '2700.00');
INSERT INTO `f_business_need_type` VALUES ('534', '互联网基础版', '70', '3200.00');
INSERT INTO `f_business_need_type` VALUES ('535', '互联网基础版', '80', '3700.00');
INSERT INTO `f_business_need_type` VALUES ('536', '互联网基础版', '90', '4200.00');
INSERT INTO `f_business_need_type` VALUES ('537', '互联网基础版', '100', '4700.00');
INSERT INTO `f_business_need_type` VALUES ('538', '互联网基础版', '120', '5680.00');
INSERT INTO `f_business_need_type` VALUES ('539', '互联网基础版', '140', '6660.00');
INSERT INTO `f_business_need_type` VALUES ('540', '互联网基础版', '150', '7150.00');
INSERT INTO `f_business_need_type` VALUES ('541', '互联网基础版', '160', '7640.00');
INSERT INTO `f_business_need_type` VALUES ('542', '互联网基础版', '180', '8620.00');
INSERT INTO `f_business_need_type` VALUES ('543', '互联网基础版', '200', '9600.00');
INSERT INTO `f_business_need_type` VALUES ('544', '互联网基础版', '250', '11166.67');
INSERT INTO `f_business_need_type` VALUES ('545', '互联网基础版', '300', '12733.33');
INSERT INTO `f_business_need_type` VALUES ('546', '互联网基础版', '350', '14300.00');
INSERT INTO `f_business_need_type` VALUES ('547', '互联网基础版', '400', '15866.67');
INSERT INTO `f_business_need_type` VALUES ('548', '互联网基础版', '450', '17433.33');
INSERT INTO `f_business_need_type` VALUES ('549', '互联网基础版', '500', '19000.00');
INSERT INTO `f_business_need_type` VALUES ('550', '互联网基础版', '600', '21862.60');
INSERT INTO `f_business_need_type` VALUES ('551', '互联网基础版', '700', '24725.19');
INSERT INTO `f_business_need_type` VALUES ('552', '互联网基础版', '800', '27587.79');
INSERT INTO `f_business_need_type` VALUES ('553', '互联网基础版', '900', '30450.38');
INSERT INTO `f_business_need_type` VALUES ('554', '互联网基础版', '1000', '33312.98');
INSERT INTO `f_business_need_type` VALUES ('555', '互联网超值版', '20', '260.00');
INSERT INTO `f_business_need_type` VALUES ('556', '互联网超值版', '30', '307.00');
INSERT INTO `f_business_need_type` VALUES ('557', '互联网超值版', '40', '353.00');
INSERT INTO `f_business_need_type` VALUES ('558', '互联网超值版', '50', '400.00');
INSERT INTO `f_business_need_type` VALUES ('559', '互联网超值版', '60', '460.00');
INSERT INTO `f_business_need_type` VALUES ('560', '互联网超值版', '70', '520.00');
INSERT INTO `f_business_need_type` VALUES ('561', '互联网超值版', '80', '580.00');
INSERT INTO `f_business_need_type` VALUES ('562', '互联网超值版', '90', '640.00');
INSERT INTO `f_business_need_type` VALUES ('563', '互联网超值版', '100', '700.00');
INSERT INTO `f_business_need_type` VALUES ('564', '互联网超值版', '120', '800.00');
INSERT INTO `f_business_need_type` VALUES ('565', '互联网超值版', '140', '900.00');
INSERT INTO `f_business_need_type` VALUES ('566', '互联网超值版', '150', '950.00');
INSERT INTO `f_business_need_type` VALUES ('567', '互联网超值版', '160', '1000.00');
INSERT INTO `f_business_need_type` VALUES ('568', '互联网超值版', '180', '1100.00');
INSERT INTO `f_business_need_type` VALUES ('569', '互联网超值版', '200', '1200.00');
INSERT INTO `f_business_need_type` VALUES ('570', '互联网超值版', '250', '1467.00');
INSERT INTO `f_business_need_type` VALUES ('571', '互联网超值版', '300', '1733.00');
INSERT INTO `f_business_need_type` VALUES ('572', '互联网超值版', '350', '2000.00');
INSERT INTO `f_business_need_type` VALUES ('573', '互联网超值版', '400', '2267.00');
INSERT INTO `f_business_need_type` VALUES ('574', '互联网超值版', '450', '2533.00');
INSERT INTO `f_business_need_type` VALUES ('575', '互联网超值版', '500', '2800.00');

-- ----------------------------
-- Table structure for f_business_role
-- ----------------------------
DROP TABLE IF EXISTS `f_business_role`;
CREATE TABLE `f_business_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '层级名称',
  `pid` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_business_role
-- ----------------------------
INSERT INTO `f_business_role` VALUES ('1', '市属', '37', '2');
INSERT INTO `f_business_role` VALUES ('2', '顺德', '37', '2');
INSERT INTO `f_business_role` VALUES ('3', '南海', '37', '2');
INSERT INTO `f_business_role` VALUES ('4', '禅城', '37', '2');
INSERT INTO `f_business_role` VALUES ('5', '三水', '37', '2');
INSERT INTO `f_business_role` VALUES ('6', '高明', '37', '2');
INSERT INTO `f_business_role` VALUES ('7', '顺德中区政企中心', '2', '3');
INSERT INTO `f_business_role` VALUES ('8', '顺德北区政企中心', '2', '3');
INSERT INTO `f_business_role` VALUES ('9', '顺德东区政企中心', '2', '3');
INSERT INTO `f_business_role` VALUES ('10', '顺德西区政企中心', '2', '3');
INSERT INTO `f_business_role` VALUES ('11', '顺德南区政企中心', '2', '3');
INSERT INTO `f_business_role` VALUES ('12', '南海中区政企中心', '3', '3');
INSERT INTO `f_business_role` VALUES ('13', '南海东区政企中心', '3', '3');
INSERT INTO `f_business_role` VALUES ('14', '南海南区政企中心', '3', '3');
INSERT INTO `f_business_role` VALUES ('15', '南海西区政企中心', '3', '3');
INSERT INTO `f_business_role` VALUES ('16', '南海北区政企中心', '3', '3');
INSERT INTO `f_business_role` VALUES ('17', '禅城东区政企中心', '4', '3');
INSERT INTO `f_business_role` VALUES ('18', '禅城西区政企中心', '4', '3');
INSERT INTO `f_business_role` VALUES ('19', '三水南区政企中心', '5', '3');
INSERT INTO `f_business_role` VALUES ('20', '三水北区政企中心', '5', '3');
INSERT INTO `f_business_role` VALUES ('21', '高明东区政企中心', '6', '3');
INSERT INTO `f_business_role` VALUES ('22', '顺德中区政企中心客户经理', '7', '4');
INSERT INTO `f_business_role` VALUES ('23', '顺德北区政企中心客户经理', '8', '4');
INSERT INTO `f_business_role` VALUES ('24', '顺德东区政企中心客户经理', '9', '4');
INSERT INTO `f_business_role` VALUES ('25', '顺德西区政企中心客户经理', '10', '4');
INSERT INTO `f_business_role` VALUES ('26', '顺德南区政企中心客户经理', '11', '4');
INSERT INTO `f_business_role` VALUES ('27', '南海中区政企中心客户经理', '12', '4');
INSERT INTO `f_business_role` VALUES ('28', '南海东区政企中心客户经理', '13', '4');
INSERT INTO `f_business_role` VALUES ('29', '南海南区政企中心客户经理', '14', '4');
INSERT INTO `f_business_role` VALUES ('30', '南海西区政企中心客户经理', '15', '4');
INSERT INTO `f_business_role` VALUES ('31', '南海北区政企中心客户经理', '16', '4');
INSERT INTO `f_business_role` VALUES ('32', '禅城东区政企中心客户经理', '17', '4');
INSERT INTO `f_business_role` VALUES ('33', '禅城西区政企中心客户经理', '18', '4');
INSERT INTO `f_business_role` VALUES ('34', '三水南区政企中心客户经理', '19', '4');
INSERT INTO `f_business_role` VALUES ('35', '三水北区政企中心客户经理', '20', '4');
INSERT INTO `f_business_role` VALUES ('36', '高明东区政企中心客户经理', '21', '4');
INSERT INTO `f_business_role` VALUES ('37', '市公司', '0', '1');
INSERT INTO `f_business_role` VALUES ('38', '市政企', '1', '3');
INSERT INTO `f_business_role` VALUES ('39', '市政企客户经理', '38', '4');
INSERT INTO `f_business_role` VALUES ('40', '行销', '0', '1');
INSERT INTO `f_business_role` VALUES ('41', '代理商', '0', '1');

-- ----------------------------
-- Table structure for f_check_data_apply
-- ----------------------------
DROP TABLE IF EXISTS `f_check_data_apply`;
CREATE TABLE `f_check_data_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `pipeline_lightline_is_over` varchar(255) DEFAULT NULL COMMENT '*管道光缆是否完工',
  `esop_contract_is_upload` varchar(255) DEFAULT NULL COMMENT '*ESOP合同是否上传',
  `build_resource_cover_level` varchar(255) DEFAULT NULL COMMENT '楼宇资源覆盖程度',
  `lightline_is_file` varchar(255) DEFAULT NULL COMMENT '光路是否归档',
  `ip_resource_check` varchar(255) DEFAULT NULL COMMENT 'IP资源审核',
  `plan_start_time` varchar(255) DEFAULT NULL COMMENT '计划预约开通时间',
  `computer_room_is_over` varchar(255) DEFAULT NULL COMMENT '机房是否装修完毕',
  `computer_room_position_is_get` varchar(255) DEFAULT NULL COMMENT '机房位置是否具备',
  `computer_table_position_is_get` varchar(255) DEFAULT NULL COMMENT '机柜位置是否具备',
  `electric_situation` varchar(255) DEFAULT NULL COMMENT '电源情况',
  `property_in_time` varchar(255) DEFAULT NULL COMMENT '物业协商进场时间',
  `client_in_time` varchar(255) DEFAULT NULL COMMENT '客户协商进场时间',
  `property_connect_people` varchar(255) DEFAULT NULL COMMENT '物业联系人',
  `property_connect_phone` varchar(255) DEFAULT NULL COMMENT '物业联系人手机',
  `client_connect_people` varchar(255) DEFAULT NULL COMMENT '客户联系人',
  `client_connect_phone` varchar(255) DEFAULT NULL COMMENT '客户联系人手机',
  `all_file` varchar(1000) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_check_data_apply
-- ----------------------------
INSERT INTO `f_check_data_apply` VALUES ('20', '无管道光缆建设', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('21', '无管道光缆建设', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('22', '无管道光缆建设', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('23', '无管道光缆建设', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('24', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('25', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('26', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('27', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('28', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('29', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('30', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('31', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('32', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_check_data_apply` VALUES ('33', '是', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for f_client_info
-- ----------------------------
DROP TABLE IF EXISTS `f_client_info`;
CREATE TABLE `f_client_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(255) DEFAULT NULL COMMENT '客户名称',
  `client_no` varchar(255) DEFAULT NULL COMMENT '客户编号',
  `client_link_people` varchar(255) DEFAULT NULL COMMENT '客户联系人',
  `client_level` varchar(255) DEFAULT NULL COMMENT '客户等级',
  `client_link_people_phone` varchar(255) DEFAULT NULL COMMENT '客户联系人电话',
  `client_manager` varchar(255) DEFAULT NULL COMMENT '客户经理',
  `client_manager_phone` varchar(255) DEFAULT NULL COMMENT '客户经理电话',
  `pid` int(11) DEFAULT '0' COMMENT '父级Id',
  `pids` varchar(255) DEFAULT NULL,
  `client_address` varchar(255) DEFAULT NULL COMMENT '客户地址',
  `out_inner_type` varchar(255) DEFAULT NULL COMMENT '内外部分类',
  `all_division_attr` varchar(255) DEFAULT NULL COMMENT '总部分部属性',
  `client_province_city_attr` varchar(255) DEFAULT NULL COMMENT '客户省市属性',
  `belong_city` varchar(255) DEFAULT NULL COMMENT '所属地市',
  `belong_region` varchar(255) DEFAULT NULL COMMENT '所属区域',
  `belong_company` varchar(255) DEFAULT NULL COMMENT '所属分公司',
  `client_lontitude` varchar(255) DEFAULT NULL COMMENT '客户地址经度',
  `client_latitude` varchar(255) DEFAULT NULL COMMENT '客户地址纬度',
  `client_people_email` varchar(255) DEFAULT NULL COMMENT '客户联系人email',
  `belong_replace_company` varchar(255) DEFAULT NULL COMMENT '所属代维公司',
  `group_no` varchar(255) DEFAULT NULL COMMENT '集团编码',
  `client_service_level` varchar(255) DEFAULT NULL COMMENT '客户服务等级',
  `files` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_client_info
-- ----------------------------
INSERT INTO `f_client_info` VALUES ('2', '中国移动', null, 'xxxx', 'A+', '1666666', 'xxx', '1666666', '0', null, '佛山市', '内部客户', '集团客户总部', '省管客户', '佛山', '禅城西区', '市属集团', '', '', '', '', null, '钻石', '7c4f048793444688857336732b928310');
INSERT INTO `f_client_info` VALUES ('6', '广东移动', null, 'xxxx', 'A+', '1666666', 'xxx', '1888888888', '2', '[0],[2],', '佛山市', '内部客户', '集团客户总部', '省管客户', '省级', '市属组', '省级', '', '', '', '', '88888', '钻石', null);
INSERT INTO `f_client_info` VALUES ('7', '佛山移动', null, 'xxx', 'A+', '1111', 'xxx', '1888888888', '6', '[0],[2],[6],', '佛山市', '内部客户', '集团客户总部', '省管客户', '佛山', '禅城西区', '市属集团', '', '', '', '', '88888', '银牌', null);

-- ----------------------------
-- Table structure for f_consult_before_info
-- ----------------------------
DROP TABLE IF EXISTS `f_consult_before_info`;
CREATE TABLE `f_consult_before_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT NULL COMMENT '所处状态',
  `client_manage_name` varchar(11) DEFAULT NULL COMMENT '客户经理',
  `client_manage_phone` varchar(255) DEFAULT NULL COMMENT '客户经理电话',
  `address` varchar(255) DEFAULT NULL COMMENT '业务接入地址',
  `business_apply_region` varchar(255) DEFAULT NULL COMMENT '业务接入区域',
  `business_apply_network` varchar(255) DEFAULT NULL COMMENT '业务接入片区',
  `business_need_type` varchar(255) DEFAULT NULL COMMENT '业务需求类型',
  `audio_line_number` int(11) DEFAULT NULL COMMENT '语音需开通外线数量（铁通直线号码）',
  `audio_out_number` int(11) DEFAULT NULL COMMENT '语音需开通外线数量（客户分级号码）',
  `audio_other_number` int(11) DEFAULT NULL COMMENT '语音-是否保留其他运营商外线数量（电信）',
  `audio_is_v` varchar(255) DEFAULT NULL COMMENT '语音-是否做综合集团V网',
  `audio_machine_need` varchar(255) DEFAULT NULL COMMENT '语音-机柜需求',
  `ip_need_num` varchar(255) DEFAULT NULL COMMENT '专线-IP需求数量',
  `a_address` varchar(255) DEFAULT NULL COMMENT 'A端地址',
  `z_address` varchar(255) DEFAULT NULL COMMENT 'z端地址',
  `implement_point_type` varchar(255) DEFAULT NULL COMMENT '接入点类型',
  `implement_name` varchar(255) DEFAULT NULL COMMENT '接入点名称',
  `network_service_level` varchar(255) DEFAULT NULL COMMENT '网络服务等级',
  `implement_type` varchar(255) DEFAULT NULL COMMENT '接入方式',
  `generic_cabling` varchar(255) DEFAULT NULL COMMENT '综合布线',
  `top_band` varchar(255) DEFAULT NULL COMMENT '上行宽带',
  `bottom_band` varchar(255) DEFAULT NULL COMMENT '下行宽带',
  `business_need_remark` varchar(255) DEFAULT NULL COMMENT '业务需求描述',
  `files` varchar(255) DEFAULT NULL,
  `floor_number` int(11) DEFAULT NULL COMMENT '楼宇编码',
  `floor_resource` varchar(255) DEFAULT NULL COMMENT '楼宇实际资源情况',
  `estimate_time` varchar(255) DEFAULT NULL COMMENT '预估工期',
  `estimate_price` decimal(10,2) DEFAULT NULL COMMENT '预估造价',
  `estimate_investment` decimal(10,2) DEFAULT NULL COMMENT '预估投资',
  `seven_address` varchar(255) DEFAULT NULL COMMENT '七级地址  佛山市',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_consult_before_info
-- ----------------------------

-- ----------------------------
-- Table structure for f_cover_order
-- ----------------------------
DROP TABLE IF EXISTS `f_cover_order`;
CREATE TABLE `f_cover_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bussiness_apply_company` varchar(255) DEFAULT NULL COMMENT '业务发起分公司',
  `bussiness_apply_region` varchar(255) DEFAULT NULL COMMENT '业务接入区域',
  `bussiness_apply_network` varchar(255) DEFAULT NULL COMMENT '业务接入片区',
  `property_company` varchar(255) DEFAULT NULL COMMENT '物业公司',
  `property_link_person` varchar(255) DEFAULT NULL COMMENT '物业联系人',
  `property_link_phone` varchar(255) DEFAULT NULL COMMENT '物业联系人电话',
  `big_device` varchar(255) DEFAULT NULL COMMENT '是否有大设备',
  `baimi_is_resource` varchar(255) DEFAULT NULL COMMENT '百米是否有资源',
  `verify_id` int(11) DEFAULT NULL COMMENT '审批id',
  `build_company` varchar(255) DEFAULT NULL COMMENT '建设单位',
  `all_file` varchar(255) DEFAULT NULL,
  `order_num` varchar(255) DEFAULT NULL,
  `network_type` varchar(255) DEFAULT NULL,
  `design_id` int(11) DEFAULT NULL COMMENT '设计方案ID',
  `work_id` int(11) DEFAULT NULL COMMENT '施工ID',
  `finish_id` int(11) DEFAULT NULL COMMENT '完工ID',
  `supplement_archive_id` int(11) DEFAULT NULL COMMENT '补充归档ID',
  `current_process` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '当前环节',
  `status` int(11) DEFAULT '1' COMMENT '1:正常，2：退单，3：退回上一步，4：挂起，5：保存，',
  `verify_status` int(11) unsigned DEFAULT '0' COMMENT '审核状态（1:市公司审核，2分公司审核，3客户经理审核 , 4成功 5驳回）',
  `abnormal_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常原因',
  `abnormal_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人',
  `abnormal_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人电话',
  `abnormal_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常备注',
  `estimate_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '预计完成时间',
  `back_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '退单原因',
  `hang_file` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起证明',
  `order_start_time` varchar(0) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '工单开始时间',
  `hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '申请挂起时间',
  `relieve_hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '解挂时间',
  `branch_verify_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '分公司审核时间',
  `hang_reason` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起原因',
  `hang_num_of_client` int(11) DEFAULT '0' COMMENT '客户原因挂起天数',
  `hang_num_of_other` int(11) DEFAULT '0' COMMENT '非客户原因挂起天数',
  `is_need_supply_cable` varchar(255) DEFAULT NULL,
  `client_manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_cover_order
-- ----------------------------
INSERT INTO `f_cover_order` VALUES ('68', '[禅城]-12（3123）-互联网数据专线', '南海分公司', '', '', '', '', '', '', '', null, null, null, 'GCJS-20210616-0001', '本地网', '28', '13', '33', '7', '核查数据', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, '0', '0', null, '331');
INSERT INTO `f_cover_order` VALUES ('69', '[禅城]-12（3123）-互联网数据专线', '南海分公司', '', '', '', '', '', '', '', null, null, null, 'GCJS-20210616-0001', '驻地网', '15', '19', '34', '8', '核查数据', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, '0', '0', null, '331');

-- ----------------------------
-- Table structure for f_create_order
-- ----------------------------
DROP TABLE IF EXISTS `f_create_order`;
CREATE TABLE `f_create_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `full_service_no` varchar(255) DEFAULT NULL COMMENT '全业务工单号',
  `integrated_order_no` varchar(255) DEFAULT NULL COMMENT '一体化单号',
  `online_system_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '线上系统工单号',
  `online_system_send_people` varchar(255) DEFAULT NULL COMMENT '线上系统派单人',
  `online_system_send_people_phone` varchar(255) DEFAULT NULL COMMENT '线上系统派单人电话',
  `esop_no` varchar(255) DEFAULT NULL COMMENT 'ESOP订单编号',
  `order_source` varchar(255) DEFAULT NULL COMMENT '工单来源',
  `order_value` varchar(255) DEFAULT NULL COMMENT '工单价值',
  `online_system_send_time` varchar(255) DEFAULT NULL COMMENT '线上系统派单时间',
  `urgency_degree` varchar(255) DEFAULT NULL COMMENT '紧急程度',
  `finish_time` varchar(255) DEFAULT NULL COMMENT '要求完成时间',
  `send_people` varchar(255) DEFAULT NULL COMMENT '派单人',
  `send_people_phone` varchar(255) DEFAULT NULL COMMENT '派单人电话',
  `product_no` varchar(255) DEFAULT NULL COMMENT '产品编号',
  `project_name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `city_or_region` varchar(255) DEFAULT NULL COMMENT '市/区',
  `bussiness_need_type` varchar(255) DEFAULT NULL COMMENT '业务需求类型',
  `client_id` int(11) DEFAULT NULL COMMENT '客户名称',
  `bussiness_apply_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '业务发起分公司',
  `bussiness_apply_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '业务接入区域',
  `bussiness_apply_network` varchar(255) DEFAULT NULL COMMENT '业务接入网络',
  `bussiness_access_address` varchar(255) DEFAULT NULL COMMENT '业务接入地址',
  `network_service_level` varchar(255) DEFAULT NULL COMMENT '网络服务等级',
  `is_provide_route` varchar(255) DEFAULT NULL COMMENT '是否免费提供路由',
  `implement_type` varchar(255) DEFAULT NULL COMMENT '接入方式',
  `top_band` varchar(255) DEFAULT NULL COMMENT '上行带宽',
  `bottom_band` varchar(255) DEFAULT NULL COMMENT '下行带宽',
  `generic_cabling` varchar(255) DEFAULT NULL COMMENT '综合布线',
  `is_have_ready_implement` varchar(255) DEFAULT NULL COMMENT '是否有预接入单',
  `a_is_need_construction` varchar(255) DEFAULT NULL COMMENT 'A端是否需建设',
  `client_address_of_a` varchar(255) DEFAULT NULL COMMENT 'A端客户接入地址',
  `z_is_need_construction` varchar(255) DEFAULT NULL COMMENT 'Z端是否需建设',
  `client_address_of_z` varchar(255) DEFAULT NULL COMMENT 'Z端客户接入地址',
  `bussiness_need_remark` varchar(255) DEFAULT NULL COMMENT '业务需求描述',
  `supervision_unit` int(11) DEFAULT NULL COMMENT '监理单位',
  `design_unit` int(11) DEFAULT NULL COMMENT '设计单位',
  `construction_unit` int(11) DEFAULT NULL COMMENT '施工单位',
  `engineer_info` varchar(255) DEFAULT NULL COMMENT '工程信息说明',
  `order_type` varchar(255) DEFAULT NULL COMMENT '工单类型',
  `next_step_deal_day` varchar(255) DEFAULT NULL COMMENT '下环节处理时限（天）',
  `implement_point_type` varchar(255) DEFAULT NULL COMMENT '接入点类型',
  `implement_name` varchar(255) DEFAULT NULL COMMENT '接入点名称',
  `home_precoverage_site` varchar(255) DEFAULT NULL COMMENT '归属预覆盖站点',
  `home_precoverage_site_place` varchar(255) DEFAULT NULL COMMENT '预覆盖站点地址',
  `files` text COMMENT '附件列表',
  `design_project_id` int(11) DEFAULT NULL COMMENT '设计方案ID',
  `verify_project_id` int(11) DEFAULT NULL COMMENT '审批方案id',
  `feedback_project_progress_id` int(11) DEFAULT NULL,
  `organization_id` int(11) DEFAULT NULL,
  `confirm_id` int(11) DEFAULT NULL,
  `online_id` int(11) DEFAULT NULL,
  `bussiness_acceptance_id` int(11) DEFAULT NULL,
  `archive_id` int(11) DEFAULT NULL,
  `client_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '客户名称',
  `is_big_device` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `audio_line_number` int(11) DEFAULT NULL,
  `audio_out_number` int(11) DEFAULT NULL,
  `audio_other_number` int(11) DEFAULT NULL,
  `audio_is_v` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `audio_machine_need` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `line_need_provide_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `power_need_provide_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL,
  `ip_num` int(11) DEFAULT NULL,
  `check_id` int(11) DEFAULT NULL,
  `install_device_id` int(11) DEFAULT NULL,
  `jump_id` int(11) DEFAULT NULL,
  `end_id` int(11) DEFAULT NULL,
  `abnormal_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常原因',
  `abnormal_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人',
  `abnormal_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人电话',
  `current_process` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '当前环节',
  `status` int(11) DEFAULT '1' COMMENT '工单状态（1:正常，2：退单，3：退回上一步，4：挂起，5保存，6退回开通单）',
  `verify_status` int(11) unsigned DEFAULT '0' COMMENT '审核状态（1:市公司审核，2分公司审核，3客户经理审核 , 4成功 5驳回）',
  `abnormal_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常备注',
  `estimate_time` varchar(255) DEFAULT NULL COMMENT '预计完成时间',
  `back_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '退单原因',
  `hang_file` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起证明',
  `order_start_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '工单开始时间',
  `hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '申请挂起时间',
  `relieve_hang_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '解挂时间',
  `branch_verify_time` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '分公司审核时间',
  `is_submit` int(255) unsigned DEFAULT '0',
  `hang_reason` text CHARACTER SET utf8 COLLATE utf8_0900_ai_ci COMMENT '挂起原因',
  `hang_num_of_client` int(11) DEFAULT '0' COMMENT '客户原因挂起天数',
  `hang_num_of_other` int(11) DEFAULT '0' COMMENT '非客户原因挂起天数',
  `is_need_supply_cable` varchar(255) DEFAULT NULL,
  `client_manager_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_create_order
-- ----------------------------
INSERT INTO `f_create_order` VALUES ('84', 'GCJS-20210616-0002', '', '', '', '', '', '', '', '', '', '', null, null, '', '[南海]-111（11）-互联网数据专线', '', '', null, '南海分公司', '南海东部-桂城|平洲', '南海东区政企中心（桂城、平洲）', '南海分公司-桂城-234-111--', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, '        						', '', '', '', '', '', '', null, '13', null, null, null, null, null, null, null, null, '是', null, null, null, '', null, '', '', null, null, null, null, null, '（临时退单）工单转派开通', '', '', '审批方案', '3', '8', '', null, '', null, '2021-06-16', null, null, null, '1', null, '0', '0', null, null);
INSERT INTO `f_create_order` VALUES ('85', 'GCJS-20210616-0003', '', '', '', '', '', '', '', '', '', '', null, null, '', '[123][123]-[禅城]-123（123）-互联网数据专线', '', '', null, '南海分公司', '南海东部-桂城|平洲', '南海东区政企中心（桂城、平洲）', '南海分公司-桂城-123-123-123-123', '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, '        						', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, '是', null, null, null, '', null, '', '', null, null, null, null, null, null, null, null, '设计方案', '1', '0', null, null, null, null, '2021-06-16', null, null, null, '1', null, '0', '0', null, null);

-- ----------------------------
-- Table structure for f_device_install
-- ----------------------------
DROP TABLE IF EXISTS `f_device_install`;
CREATE TABLE `f_device_install` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `device_test` varchar(255) DEFAULT NULL COMMENT '*设备调试',
  `device_test_complete_time` varchar(255) DEFAULT NULL COMMENT '*设备调试完成时间',
  `device_whole_picture_file` varchar(1000) DEFAULT NULL COMMENT '*设备整体照片',
  `device_tag_picture_file` varchar(1000) DEFAULT NULL COMMENT '*设备标签照片',
  `business_test_complete_picture_file` varchar(1000) DEFAULT NULL COMMENT '*业务调试完成照片',
  `problem_feed_back` varchar(255) DEFAULT NULL COMMENT '问题反馈',
  `problem_point_file` varchar(1000) DEFAULT NULL COMMENT '问题点',
  `all_file` varchar(1000) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_device_install
-- ----------------------------
INSERT INTO `f_device_install` VALUES ('14', '', '', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for f_end_lightline_work
-- ----------------------------
DROP TABLE IF EXISTS `f_end_lightline_work`;
CREATE TABLE `f_end_lightline_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `in_punch_card` varchar(255) DEFAULT NULL COMMENT '*进场打卡',
  `in_time` varchar(255) DEFAULT NULL COMMENT '*进场时间',
  `a_point_fibre_picture_file` varchar(1000) DEFAULT NULL COMMENT '*A端光交箱/分纤箱正面图',
  `a_point_lightline_picture_file` varchar(1000) DEFAULT NULL COMMENT '*A端光缆成端照片',
  `a_point_lightline_tag_file` varchar(1000) DEFAULT NULL COMMENT '*A端光缆标签',
  `z_point_in_lightline_tag_file` varchar(1000) DEFAULT NULL COMMENT '*Z端入户光缆标签',
  `z_point_odb_picture_file` varchar(1000) DEFAULT NULL COMMENT '*Z端ODB正面图',
  `z_point_odb_lightline_picture_file` varchar(1000) DEFAULT NULL COMMENT '*Z端ODB光缆成端图',
  `other_file` varchar(1000) DEFAULT NULL COMMENT '其他',
  `device_test` varchar(255) DEFAULT NULL COMMENT '*设备调试',
  `device_test_complete_time` varchar(255) DEFAULT NULL COMMENT '*设备调试完成时间',
  `device_whole_picture_file` varchar(1000) DEFAULT NULL COMMENT '*设备整体照片',
  `device_tag_picture_file` varchar(1000) DEFAULT NULL COMMENT '*设备标签照片',
  `business_test_complete_picture_file` varchar(1000) DEFAULT NULL COMMENT '*业务调试完成照片',
  `problem_feed_back` varchar(255) DEFAULT NULL COMMENT '问题反馈',
  `problem_point_file` varchar(1000) DEFAULT NULL COMMENT '问题点',
  `all_file` varchar(1000) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_end_lightline_work
-- ----------------------------
INSERT INTO `f_end_lightline_work` VALUES ('24', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_end_lightline_work` VALUES ('25', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_end_lightline_work` VALUES ('26', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_end_lightline_work` VALUES ('27', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_end_lightline_work` VALUES ('28', null, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for f_feedback_project_progress
-- ----------------------------
DROP TABLE IF EXISTS `f_feedback_project_progress`;
CREATE TABLE `f_feedback_project_progress` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `project_totality_progress` varchar(255) DEFAULT NULL COMMENT '工程总体进度(%)',
  `line_system_dispatch_time` varchar(255) DEFAULT NULL COMMENT '线上系统派单时间',
  `last_update_time` varchar(255) DEFAULT NULL COMMENT '最后更新时间',
  `scene_engineer` varchar(255) DEFAULT NULL COMMENT '现场监理员',
  `engineer_phone` varchar(255) DEFAULT NULL COMMENT '监理员联系电话',
  `engineer_sign_time` varchar(255) DEFAULT NULL COMMENT '监理签收时间',
  `in_connect_pipeline_status` varchar(255) DEFAULT NULL COMMENT '红线外接入管道任务状态',
  `in_connect_pipeline_start_time` varchar(255) DEFAULT NULL COMMENT '红线外接入管道开始时间',
  `in_connect_pipeline_complete_time` varchar(255) DEFAULT NULL COMMENT '红线外接入管道完成时间',
  `in_connect_pipeline_file` varchar(255) DEFAULT NULL COMMENT '红线外接入管道附件',
  `out_device_install_status` varchar(255) DEFAULT NULL COMMENT '红线内设备安装任务状态',
  `out_device_install_start_time` varchar(255) DEFAULT NULL COMMENT '红线内设备安装开始时间',
  `out_device_install_complete_time` varchar(255) DEFAULT NULL COMMENT '红线内设备安装完成时间',
  `out_device_install_file` varchar(255) DEFAULT NULL COMMENT '红线内设备安装附件',
  `project_resource_input_status` varchar(255) DEFAULT NULL COMMENT '工程资源录入任务状态',
  `project_resource_input_start_time` varchar(255) DEFAULT NULL COMMENT '工程资源录入开始时间',
  `project_resource_input_complete_time` varchar(255) DEFAULT NULL COMMENT '工程资源录入完成时间',
  `project_resource_input_file` varchar(255) DEFAULT NULL COMMENT '工程资源录入附件',
  `network_data_configure_status` varchar(255) DEFAULT NULL COMMENT '入网和数据配置任务状态',
  `network_data_configure_start_time` varchar(255) DEFAULT NULL COMMENT '入网和数据配置开始时间',
  `network_data_configure_complete_time` varchar(255) DEFAULT NULL COMMENT '入网和数据配置完成时间',
  `network_data_configure_file` varchar(255) DEFAULT NULL COMMENT '入网和数据配置附件',
  `circuit_manage_status` varchar(255) DEFAULT NULL COMMENT '光/电路调度任务状态',
  `circuit_manage_start_time` varchar(255) DEFAULT NULL COMMENT '光/电路调度开始时间',
  `circuit_manage_complete_time` varchar(255) DEFAULT NULL COMMENT '光/电路调度完成时间',
  `circuit_manage_file` varchar(255) DEFAULT NULL COMMENT '光/电路调度附件',
  `service_manage_status` varchar(255) DEFAULT NULL COMMENT '业务调测任务状态',
  `service_manage_start_time` varchar(255) DEFAULT NULL COMMENT '业务调测开始时间',
  `service_manage_complete_time` varchar(255) DEFAULT NULL COMMENT '业务调测完成时间',
  `service_manage_file` varchar(255) DEFAULT NULL COMMENT '业务调测附件',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `next_progress_limit_day` varchar(11) DEFAULT NULL COMMENT '下环节处理时限(天)',
  `main_circuit_num` varchar(255) DEFAULT NULL COMMENT '主光路流水号',
  `son_circuit_num` varchar(255) DEFAULT NULL COMMENT '子光路流水号',
  `pipeline_construct_length` varchar(255) DEFAULT NULL COMMENT '管道建设长度(KM)',
  `circuit_construct_length` varchar(255) DEFAULT NULL COMMENT '光缆建设长度(KM)',
  `files` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_feedback_project_progress
-- ----------------------------
INSERT INTO `f_feedback_project_progress` VALUES ('5', '11', '2021-05-18', '2021-05-24', '长大', '1555', '2021-05-03', '', '2021-05-18', '2021-05-18', null, '', '2021-05-18', '2021-05-25', null, '', '2021-05-24', '2021-05-29', null, '', '2021-05-26', '2021-05-27', null, '', '2021-05-21', '2021-05-29', null, '', '2021-05-27', '2021-05-24', null, 'xxxx', '22', '11', '112', '232', '2131', '5beb55023bfa4e0f8ae24acb84b864f4,99e18ff1cff04d06a22b89b344e929a5');
INSERT INTO `f_feedback_project_progress` VALUES ('6', '10', '2021-05-18', '2021-05-25', '11', '1555', '', '', '2021-05-12', '2021-05-17', '5beb55023bfa4e0f8ae24acb84b864f4', '', '2021-05-19', '2021-05-11', '5beb55023bfa4e0f8ae24acb84b864f4', '', '2021-05-18', '2021-05-25', '5beb55023bfa4e0f8ae24acb84b864f4', '', '2021-05-12', '2021-05-18', '5beb55023bfa4e0f8ae24acb84b864f4', '', '2021-05-27', '2021-05-17', '5beb55023bfa4e0f8ae24acb84b864f4', '', '2021-05-18', '2021-05-18', '5beb55023bfa4e0f8ae24acb84b864f4', 'xx', 'xx', 'xx', 'xx', 'xx', 'xx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_feedback_project_progress` VALUES ('7', 'x', '2021-05-11', '2021-05-18', 'x', '1555', '2021-06-02', '', '2021-05-11', '2021-06-01', null, '', '2021-05-18', '2021-05-18', null, '', '2021-04-27', '2021-05-19', null, '', '2021-05-18', '2021-05-18', null, '', '2021-05-19', '2021-06-02', null, '', '2021-05-26', '2021-05-26', null, 'xxx', '22', '11', '11', '232', '2131', '5beb55023bfa4e0f8ae24acb84b864f4');

-- ----------------------------
-- Table structure for f_floor_info
-- ----------------------------
DROP TABLE IF EXISTS `f_floor_info`;
CREATE TABLE `f_floor_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `floor_no` varchar(255) DEFAULT NULL,
  `floor_name` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longtitude` varchar(255) DEFAULT NULL,
  `resource_cover_condition` varchar(255) DEFAULT NULL,
  `floor_type` varchar(255) DEFAULT NULL,
  `floor_attr` varchar(255) DEFAULT NULL,
  `floor_classification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=688 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_floor_info
-- ----------------------------
INSERT INTO `f_floor_info` VALUES ('459', '947670', '龙江中心东面商铺', '佛山市顺德区龙江镇文华路龙江中心东面商铺(中小企)', '22.878567361447595', '113.09814570904257', '5-厚覆盖-入楼成端', '多栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('460', '947671', '龙江中心北面商铺', '佛山市顺德区龙江镇文华路龙江中心北面商铺(中小企)', '22.879501549314396', '113.09750920993342', '5-厚覆盖-入楼成端', '多栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('461', '947668', '龙江中心西面商铺', '佛山市顺德区龙江镇文华路龙江中心西面商铺(中小企)', '22.8793218228065', '113.09638708285573', '5-厚覆盖-入楼成端', '多栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('462', '947669', '龙江中心南面商铺', '佛山市顺德区龙江镇文华路龙江中心南面商铺(中小企)', '22.878381315077268', '113.09696474491997', '5-厚覆盖-入楼成端', '多栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('463', '877619', '龙江万洋众创园15栋', '佛山市顺德区龙江镇西区一路8号万洋众创园15栋', '22.888571950220429', '113.05498212933498', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('464', '1585607', '龙江万洋众创园12栋', '佛山市顺德区龙江镇西区一路8号万洋众创园12栋', '22.884908244487439', '113.04277518516348', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('465', '849609', '伦教保发珠宝产业园15栋（蓝宝楼）', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）15栋（蓝宝楼）(中小企)', '22.882782307550334', '113.1881651166436', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('466', '849612', '伦教保发珠宝产业园16栋（珊瑚楼）', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）16栋（珊瑚楼）(中小企)', '22.883306960572179', '113.18871235017719', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('467', '866855', '伦教保发珠宝产业园17栋（绿宝楼）', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）17栋（绿宝楼）(中小企)', '22.88281999151321', '113.18878587798563', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('468', '849492', '伦教保发珠宝产业中心2栋(钯金楼)', '佛山市顺德区伦教街道翡翠路保发珠宝产业中心（困难装机）2栋(钯金楼)(中小企)', '22.883690358611685', '113.18490138891429', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('469', '849493', '伦教保发珠宝产业中心3栋（环保中心）', '佛山市顺德区伦教街道翡翠路保发珠宝产业中心（困难装机）3栋（环保中心）(中小企)', '22.883210166897308', '113.18502058865909', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('470', '849490', '伦教保发珠宝产业中心4栋（水晶楼）', '佛山市顺德区伦教街道翡翠路保发珠宝产业中心（困难装机）4栋（水晶楼）(中小企)', '22.884304970437066', '113.18519729762643', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('471', '849520', '伦教保发珠宝产业中心5栋（红宝楼）', '佛山市顺德区伦教街道翡翠路保发珠宝产业中心（困难装机）5栋（红宝楼）(中小企)', '22.88427153708329', '113.18473833729519', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('472', '680488', '桂城泓健商务中心A座', '佛山市南海区桂城街道石龙北路泓健商务中心A座(中小企)', '23.042842689186675', '113.19319820671511', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('473', '520509', '桂城泓健商务中心B座', '佛山市南海区桂城街道石龙北路泓健商务中心B座(中小企)', '23.043272591458597', '113.19350191815372', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('474', '700228', '桂城孔溪泓健综合楼C区', '佛山市南海区桂城街道夏东路孔溪泓健综合楼C区单栋(中小企)', '23.042487649241538', '113.19336173683297', '5-厚覆盖-入楼成端', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('475', '796128', '桂城泓健综合楼C座', '佛山市南海区桂城街道石龙北路泓健商务中心C座(中小企)', '23.042700797323147', '113.19358546217372', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('476', '785630', '泓健商务楼（重复）', '佛山市南海区桂城街道大路边街石龙北路泓健商务楼1楼C18号', '23.042357140582806', '113.19322194626889', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('477', '483807', '容桂锦绣园1座', '佛山市顺德区容桂街道华滘路18号顺德锦绣园1座(中小企)', '22.756458605199734', '113.32349215028242', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('478', '483805', '容桂锦绣园2座', '佛山市顺德区容桂街道华滘路18号顺德锦绣园2座(中小企)', '22.75694546499459', '113.32365448519987', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('479', '1278834', '容桂锦绣园3座', '佛山市顺德区容桂街道华滘路18号容桂锦绣园3座(中小企)', '22.757289374503924', '113.32378564748923', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('480', '483806', '容桂锦绣园4座', '佛山市顺德区容桂街道华滘路18号顺德锦绣园4座(中小企)', '22.75755785672044', '113.32367192833466', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('481', '1512291', '大沥沥西恒福装饰材料市场B区', '佛山市南海区大沥镇（S263）广云路沥西恒福装饰材料市场(困难装机千)B区(中小企)', '23.120882860869917', '113.1174265714738', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('482', '1512292', '大沥沥西恒福装饰材料市场C区', '佛山市南海区大沥镇（S263）广云路沥西恒福装饰材料市场(困难装机千)C区(中小企)', '23.121161580800878', '113.11766759605274', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('483', '1506213', '丹灶南丰住房A栋', '佛山市南海区丹灶镇南社大道南丰住房B栋A栋', '23.060283735263739', '112.97493614101879', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('484', '1526118', '丹灶南丰住房B栋', '佛山市南海区丹灶镇南社大道南丰住房B栋B栋', '23.06018824173878', '112.97496216553502', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('485', '1498200', '大塘宏大金谷1号综合楼', '佛山市三水区大塘镇兴唐路宏大金谷创新科技城1号综合楼', '23.444942142924004', '112.95555121388913', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('486', '1498201', '大塘宏大金谷2号综合楼', '佛山市三水区大塘镇兴唐路宏大金谷创新科技城2号综合楼', '23.444928523254459', '112.95630675098266', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('487', '1498202', '大塘宏大金谷1号厂房', '佛山市三水区大塘镇兴唐路宏大金谷创新科技城1号厂房', '23.445721130453927', '112.95625790704389', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('488', '1498203', '大塘宏大金谷2号厂房', '佛山市三水区大塘镇兴唐路宏大金谷创新科技城2号厂房', '23.445734242891814', '112.9554849455349', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('489', '1457124', '北滘伊戈尔公司宿舍A栋', '佛山市顺德区北滘镇环镇东路4号伊戈尔公司宿舍A栋(中小企)', '22.920357894161915', '113.24485534807796', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('490', '1457123', '北滘伊戈尔公司宿舍B栋', '佛山市顺德区北滘镇环镇东路4号伊戈尔公司宿舍B栋(中小企)', '22.920121973938039', '113.24493814785127', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('491', '1320141', '北滘伊戈尔公司宿舍C栋', '佛山市顺德区北滘镇环镇东路4号伊戈尔公司宿舍C栋(中小企)', '22.91989473092459', '113.24503880654877', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('492', '1431362', '张槎丰富汽配宿舍楼A栋', '佛山市禅城区张槎街道华宝南路6号丰富汽配有限公司宿舍楼A栋(中小企)', '23.02152547994836', '113.06724969487355', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('493', '819924', '张槎丰富汽配宿舍楼B栋', '佛山市禅城区张槎街道华宝南路6号丰富汽配有限公司宿舍楼B栋(中小企)', '23.021768429780388', '113.0672228236602', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('494', '1431361', '张槎丰富汽配B2栋', '佛山市禅城区张槎街道华宝南路6号丰富汽配有限公司B2栋(中小企)', '23.023035529397079', '113.06610263472283', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('495', '1408513', '里水道道通国际汽配城3栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城3栋(中小企)', '23.233283925896975', '113.16768625063796', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('496', '1408555', '里水道道通国际汽配城4栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城4栋(中小企)', '23.23276334936229', '113.16778334912842', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('497', '1408512', '里水道道通国际汽配城5栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城5栋(中小企)', '23.23224710712143', '113.16787855054814', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('498', '1408557', '里水道道通国际汽配城6栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城6栋(中小企)', '23.233455624046749', '113.16824180387985', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('499', '1408558', '里水道道通国际汽配城7栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城7栋(中小企)', '23.23319898338119', '113.16828438300048', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('500', '1408559', '里水道道通国际汽配城8栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城8栋(中小企)', '23.23293852655689', '113.16833700792627', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('501', '1408561', '里水道道通国际汽配城9栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城9栋(中小企)', '23.232688936198096', '113.16837849793477', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('502', '1408556', '里水道道通国际汽配城10栋', '佛山市南海区里水镇佛山一环高速道道通国际汽配城10栋(中小企)', '23.232436599072267', '113.168437902497', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('503', '1371208', '乐从顺海楼A座', '佛山市顺德区乐从镇新村一街13号顺海楼A座(中小企)', '22.958867046359776', '113.12616680371639', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('504', '1371209', '乐从顺海楼B座', '佛山市顺德区乐从镇新村一街13号顺海楼B座(中小企)', '22.9589778631734', '113.12615840217008', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('505', '1371207', '乐从顺海楼C座', '佛山市顺德区乐从镇新村一街13号顺海楼C座(中小企)', '22.95908548250431', '113.12615378655905', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('506', '804928', '勒流东菱帝苑裙楼', '佛山市顺德区勒流街道政和北路15号东菱帝苑裙楼(中小企)', '22.862321808725377', '113.13374018840482', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('507', '1316680', '大沥广佛智能家居城2栋', '佛山市南海区大沥镇岭南路86号广佛智能家居城2栋(中小企)', '23.12439654821264', '113.15356581753183', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('508', '1181676', '勒流番村员工宿舍A座', '佛山市顺德区勒流街道众裕路番村立交旁番村员工宿舍A座', '22.804861268048904', '113.19800052308058', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('509', '1181677', '勒流番村员工宿舍B座', '佛山市顺德区勒流街道众裕路番村立交旁番村员工宿舍B座', '22.804763109681294', '113.19808917293099', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('510', '1176978', '祖庙海三渔邨', '佛山市禅城区祖庙街道鲤鱼沙路海三渔邨单栋(中小企)', '23.048207802175896', '113.13502733332861', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('511', '1146374', '大沥日发市场新铺3座', '佛山市南海区大沥镇广佛路日发市场新铺3座(中小企)', '23.111239390883076', '113.13653253067511', '6-厚覆盖-垂直覆盖', '多栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('512', '1496523', '大沥日发市场新铺4座', '佛山市南海区大沥镇广佛路日发市场新铺4座(中小企)', '23.111615683246766', '113.13631079449874', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('513', '1496524', '大沥日发市场新铺5座', '佛山市南海区大沥镇广佛路日发市场新铺5座(中小企)', '23.111940261334433', '113.13572881711503', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('514', '688535', '大沥日发市场新铺6座', '佛山市南海区大沥镇广佛路日发市场新铺6座(中小企)', '23.111578280015949', '113.13587107299668', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('515', '1496527', '大沥日发市场新铺7座', '佛山市南海区大沥镇广佛路日发市场新铺7座(中小企)', '23.111165322187796', '113.13584661349334', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('516', '1496528', '大沥日发市场新铺8座', '佛山市南海区大沥镇广佛路日发市场新铺8座(中小企)', '23.110906776012649', '113.13593363206114', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('517', '1496492', '大沥大发市场芦村新铺130-139号', '佛山市南海区大沥镇广佛路大发市场芦村新铺130-139号单栋(中小企)', '23.11060390970872', '113.13598393649883', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('518', '857531', '狮山长华国际商业中心1栋', '佛山市南海区狮山镇科技北路1号长华国际商业中心1座(中小企)', '23.12136345289438', '113.00606720541808', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('519', '850185', '狮山长富假日天玺公寓1栋', '佛山市南海区狮山镇孝贤路2号长富西站假日天玺公寓1栋(中小企)', '23.080763701084448', '113.05114946742673', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('520', '850087', '桂城三山智汇广场2座', '佛山市南海区桂城街道环岛西路三山智汇广场2座(中小企)', '23.035650372789499', '113.22596598785163', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('521', '717711', '狮山圣地广场', '佛山市南海区狮山镇北湖一路圣地广场单栋(中小企)', '23.0747560882794', '113.05909376729781', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('522', '1161324', '桂城三山智汇广场5座', '佛山市南海区桂城街道环岛西路三山智汇广场5座(中小企)', '23.03525301567189', '113.22638124788694', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('523', '1161263', '桂城三山智汇广场4座', '佛山市南海区桂城街道环岛西路三山智汇广场4座(中小企)', '23.03502512364438', '113.22631539863112', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('524', '1161260', '桂城三山智汇广场6座', '佛山市南海区桂城街道环岛西路三山智汇广场6座(中小企)', '23.035168906438196', '113.22673463536478', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('525', '1597286', '云东海华大星晖教师宿舍', '佛山市三水区云东海街道映海路华大星晖高级中学教师宿舍', '23.201471817863437', '112.93913467060253', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('526', '1573387', '杏坛河北五路2号', '佛山市顺德区杏坛镇河北五路御生堂沐足保健按摩单栋', '22.790153903211907', '113.16405311134275', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('527', '1533054', '勒流锦力新都汇二期1号楼', '佛山市顺德区勒流街道港口西路锦力新都汇二期1号楼', '22.86830938710198', '113.16137751687394', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('528', '1531262', '勒流小熊电器总部研发楼', '佛山市顺德区勒流街道富裕大道小熊电器智能总部研发楼', '22.810512054593834', '113.21502281306994', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('529', '1530410', '大沥东风商业楼', '佛山市南海区大沥镇洞庭路黄岐村漖表东风新二村东风商业楼(千)单栋', '23.113114811770598', '113.20594093895893', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('530', '1512712', '北滘博智林机器人科研楼公寓B座', '佛山市顺德区北滘镇南平路博智林机器人科研楼公寓B座', '22.930880266711719', '113.28419835963841', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('531', '1507230', '勒流江凯商务公寓', '佛山市顺德区勒流街道江村大道北江凯商务公寓单栋', '22.859666841847088', '113.17322382068758', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('532', '1505055', '勒流医院宿舍1座', '佛山市顺德区勒流街道沿江中路2号勒流医院宿舍1座', '22.86565649746829', '113.14265110087738', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('533', '1505022', '北滘明峰工业园宿舍楼', '佛山市顺德区北滘镇经二路明峰工业园宿舍楼', '22.911854488565866', '113.17443566438154', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('534', '1500958', '乐平凯乐德公租房3座', '佛山市三水区乐平镇拓业大道4号凯乐德公租房3座', '23.24728588362711', '113.01927254125062', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('535', '1497277', '大沥绿茵广场', '佛山市南海区大沥镇穗盐路绿茵广场(千)单栋', '23.089361572261553', '113.16072774176962', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('536', '1492794', '勒流小熊电器总部宿舍楼', '佛山市顺德区勒流街道富裕大道小熊电器智能总部宿舍楼(中小企)', '22.81096971779412', '113.21492160553309', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('537', '1489729', '乐平昊拓汽车配件宿舍楼', '佛山市三水区乐平镇兴业北路乐平昊拓汽车配件宿舍楼', '23.22789204301461', '112.9915352089279', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('538', '1486682', '杏坛入乡大道北三路一号之一', '佛山市顺德区杏坛镇百安路入乡大道北三路一号之一单栋(中小企)', '22.820777652008038', '113.12533972597005', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('539', '1483926', '里水宇能国际二期一号楼', '佛山市南海区里水镇下亨一路宇能国际二期(千)一号楼(中小企)', '23.16108366280353', '113.16859362993873', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('540', '1470512', '乐从佛山市消防救援支队办公楼', '佛山市顺德区乐从镇裕和路佛山市消防救援支队办公楼', '22.96258242101119', '113.15518718788253', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '党政机关');
INSERT INTO `f_floor_info` VALUES ('541', '1455691', '张槎金腾商业楼', '佛山市禅城区张槎街道江湾二路金腾商业楼单栋(中小企)', '23.018956555857796', '113.09197033059586', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('542', '1454192', '荷城凌云山营地教育宿舍5', '佛山市高明区荷城街道石洲大道凌云山营地教育宿舍5(中小企)', '22.981421387571556', '112.7631280302331', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '休闲娱乐旅游');
INSERT INTO `f_floor_info` VALUES ('543', '1438231', '明城宏基豪庭1座', '佛山市高明区明城镇城七路32号宏基豪庭1座(中小企)', '22.862708976318446', '112.71128182347532', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('544', '1429177', '北滘博智林机器人科研楼公寓E座', '佛山市顺德区北滘镇南平路博智林机器人科研楼公寓E座', '22.930059900544657', '113.28366393840779', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('545', '1429150', '北滘博智林机器人科研楼公寓C座', '佛山市顺德区北滘镇南平路博智林机器人科研楼公寓C座', '22.93096183391675', '113.28491541662967', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('546', '1429146', '北滘博智林机器人科研公寓A座', '佛山市顺德区北滘镇南平路博智林机器人科研楼公寓A座', '22.9307978601492', '113.28344805134613', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('547', '1429125', '北滘博智林机器人科研楼公寓D座', '佛山市顺德区北滘镇南平路博智林机器人科研楼公寓D座', '22.930242829008617', '113.28491415692', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('548', '1428442', '龙江集北工业一路18号', '佛山市顺德区龙江镇集北工业一路18号单栋(中小企)', '22.87097560629989', '113.10282709906082', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('549', '1427376', '伦教科达陶瓷基地宿舍楼', '佛山市顺德区伦教街道均益北路3A号科达陶瓷基地宿舍楼(中小企)', '22.87284004298091', '113.19041770011596', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('550', '1411772', '更合金百川化工宿舍楼', '佛山市高明区更合镇更合大道463号佛山金百川科技有限公司宿舍楼(中小企)', '22.809117537515499', '112.5460464189204', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('551', '1396221', '乐从罗浮宫家具博览中心员工宿舍楼', '佛山市顺德区乐从镇佛山大道南罗浮宫国际家具博览中心员工宿舍楼(中小企)', '22.951084074452575', '113.09461353192458', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('552', '1396221', '乐从罗浮宫家具博览中心员工宿舍楼', '佛山市顺德区乐从镇佛山大道南罗浮宫国际家具博览中心员工宿舍楼(中小企)', '22.951084074452575', '113.09461353192458', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('553', '1395599', '里水丽枫酒店A座', '佛山市南海区里水镇里水大道中丽枫酒店(千)A座(中小企)', '23.179304881411889', '113.15543546873535', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('554', '1378801', '荷城碧桂园凤凰酒店别墅6座', '佛山市高明区荷城街道碧桂路碧桂园凤凰酒店别墅(千)6座', '22.869387731276505', '112.84968523830725', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '休闲娱乐旅游');
INSERT INTO `f_floor_info` VALUES ('555', '1376072', '桂城总商会大厦1栋', '佛山市南海区桂城街道平洲人民路桂城总商会大厦1栋(中小企)', '23.036919390048224', '113.21774594760699', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('556', '1376072', '桂城总商会大厦1栋', '佛山市南海区桂城街道平洲人民路桂城总商会大厦1栋(中小企)', '23.036919390048224', '113.21774594760699', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('557', '1372823', '伦教青森酒店', '佛山市顺德区伦教街道长丰大道南38号青森酒店单栋(中小企)', '22.86423010714546', '113.27617357590496', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('558', '1356135', '大良新能源科创中心', '佛山市顺德区大良街道会萃智路1号新能源科创中心(千)单栋(中小企)', '22.83967577130599', '113.30270589767922', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('559', '1354289', '杏坛行鼎商业大厦', '佛山市顺德区杏坛镇新齐宁路17号行鼎商业大厦单栋(中小企)', '22.78091867385861', '113.16776696925852', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('560', '1348931', '乐从永翔商业楼', '佛山市顺德区乐从镇葛仙路3号永翔商业楼单栋(中小企)', '22.960989967892624', '113.07558595637515', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('561', '1348930', '乐从东箭汽车公司宿舍楼', '佛山市顺德区乐从镇佛山一环辅路杨窖北沙工业区10号东箭公司（千）宿舍楼(中小企)', '22.9370542674503', '113.06223727042273', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('562', '1348670', '北滘威灵电机宿舍楼', '佛山市顺德区北滘镇兴业路27号威灵电机制造有限公司宿舍楼(中小企)', '22.910315859594659', '113.23591794371098', '6-厚覆盖-垂直覆盖', '多栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('563', '1348363', '狮山鸿运公寓', '佛山市南海区狮山镇佛山一环辅路鸿运公寓单栋(中小企)', '23.130217040907789', '113.01965988395581', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('564', '693229', '广东汇车港汽配城15座', '佛山市南海区狮山镇罗村联和大道汇车港汽配城15座(中小企)', '23.066053792733717', '113.09368405193762', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('565', '1321169', '里水北汽福田汽车宿舍楼', '佛山市南海区里水镇文金横路北汽福田汽车(千)宿舍楼(中小企)', '23.24772449719969', '113.17119345446143', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('566', '1305822', '狮山繁星电影民宿', '佛山市南海区狮山镇佛山一环辅路繁星电影民宿单栋(中小企)', '23.130430899073244', '113.01978983222316', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('567', '1297623', '勒流光电产业园综合楼', '佛山市顺德区勒流街道南国西路富安工业园B区光电产业园（困难装机）综合楼(中小企)', '22.814578378619737', '113.20652791497865', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('568', '1278834', '容桂锦绣园3座', '佛山市顺德区容桂街道华滘路18号容桂锦绣园3座(中小企)', '22.757289374503924', '113.32378564748923', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('569', '1266975', '狮山加藤利食品公司宿舍楼', '佛山市南海区狮山镇创业北路16号加藤利酒店单栋(中小企)', '23.18318490674192', '113.08125681326806', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('570', '1266778', '容桂美芝精密公司宿舍楼1座', '佛山市顺德区容桂街道科苑二路美芝精密公司宿舍楼1座(中小企)', '22.77473597936799', '113.33185505661872', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('571', '1252456', '龙江君悦汇商务大厦', '佛山市顺德区龙江镇文华路39号君悦汇商务大厦单栋(中小企)', '22.8784683705802', '113.07740362557183', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('572', '1243101', '里水浪博鞋厂宿舍楼', '佛山市南海区里水镇草场大道浪博鞋厂宿舍楼(中小企)', '23.19447600842233', '113.20414115294038', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('573', '1236236', '龙江好年华酒店', '佛山市顺德区龙江镇南方大路北五巷4号之一好年华酒店单栋(中小企)', '22.862645548854368', '113.04036358896508', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('574', '1205188', '大良石湖路6号商业楼', '佛山市顺德区大良街道石湖路6号商业楼单栋(中小企)', '22.851386436732367', '113.2458148392516', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('575', '1181677', '勒流番村员工宿舍B座', '佛山市顺德区勒流街道众裕路番村立交旁番村员工宿舍B座', '22.804763109681294', '113.19808917293099', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('576', '1181676', '勒流番村员工宿舍A座', '佛山市顺德区勒流街道众裕路番村立交旁番村员工宿舍A座', '22.804861268048904', '113.19800052308058', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('577', '1178502', '杏坛雁园大道23号', '佛山市顺德区杏坛镇雁园大道23号(千)单栋(中小企)', '22.79621995968859', '113.17034487724735', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('578', '1171592', '龙江亚洲国际家居市场5座', '佛山市顺德区龙江镇盈科大道亚洲国际家居装饰材料市场（困难装机）5座(中小企)', '22.89342232223166', '113.05869261710676', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('579', '1171590', '龙江亚洲国际家居市场6座', '佛山市顺德区龙江镇盈科大道亚洲国际家居装饰材料市场（困难装机）6座(中小企)', '22.89321311488988', '113.05925051222366', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('580', '1171510', '龙江亚洲国际家居市场2座', '佛山市顺德区龙江镇盈科大道亚洲国际家居装饰材料市场（困难装机）2座(中小企)', '22.89274825103544', '113.05832982228582', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('581', '1171509', '龙江亚洲国际家居市场3座', '佛山市顺德区龙江镇盈科大道亚洲国际家居装饰材料市场（困难装机）3座(中小企)', '22.892535793465478', '113.0589515822251', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('582', '1171394', '龙江亚洲国际家居市场1座', '佛山市顺德区龙江镇盈科大道亚洲国际家居装饰材料市场（困难装机）1座(中小企)', '22.893212848227223', '113.05801795072549', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('583', '1167964', '九江侨联宾馆', '佛山市南海区九江镇儒林西路6号侨联宾馆单栋(中小企)', '22.837428526097278', '113.02155021714337', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('584', '1161261', '桂城三山智汇广场3座', '佛山市南海区桂城街道环岛西路三山智汇广场3座(中小企)', '23.035351050353478', '113.22608753364722', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('585', '1161259', '桂城三山智汇广场7座', '佛山市南海区桂城街道环岛西路三山智汇广场7座(中小企)', '23.03566330546799', '113.22616078771826', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('586', '1156297', '祖庙季华五路11号', '佛山市禅城区祖庙街道季华五路11号单栋', '23.01800585959671', '113.11237755446672', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('587', '1151231', '九江大伸工业区富邦酒店', '佛山市南海区九江镇九江大道大伸工业区富邦酒店单栋(中小企)', '22.85279451443395', '113.01955474852704', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('588', '1140198', '北滘工业大道22号', '佛山市顺德区北滘镇北滘工业大道22号1座', '22.916980202177869', '113.21424431914828', '5-厚覆盖-入楼成端', '单栋单用户', '商住一体', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('589', '1138705', '南庄季华西路10号', '佛山市禅城区南庄镇季华西路10号单栋', '23.0062862038732', '113.00578443138005', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('590', '1135025', '狮山奥园广场', '佛山市南海区狮山镇科技北路6号奥园广场4座(中小企)', '23.12974760495855', '113.00637599993068', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('591', '1120990', '均安尚墅君庭北面商铺', '佛山市顺德区均安镇百安北路20号尚墅君庭（困难装机千)北面商铺(中小企)', '22.72535834766454', '113.15315921720682', '5-厚覆盖-入楼成端', '多栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('592', '1111954', '龙江丽星公寓', '佛山市顺德区龙江镇保涌工业大道1号丽星公寓单栋(中小企)', '22.88197291913982', '113.04882374063881', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('593', '1103699', '龙江世博汇B座', '佛山市顺德区龙江镇精美路18号世博汇（困难装机）B座(中小企)', '22.897469047636159', '113.05790410592978', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('594', '1103698', '龙江世博汇A座', '佛山市顺德区龙江镇精美路18号世博汇（困难装机）A座(中小企)', '22.896472831293236', '113.05758686617836', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('595', '1134485', '乐从越东电商物流园公寓', '佛山市顺德区乐从镇新桂路205号越东电商物流园公寓单栋(中小企)', '22.9035316293713', '113.10154078555253', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('596', '1091914', '石湾市一医院实习生宿舍楼', '佛山市禅城区石湾街道岭南大道北81号佛山市第一人民医院实习生宿舍楼', '23.013179907492846', '113.13195935738611', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('597', '1089025', '大沥阿拉卓盈酒店', '佛山市南海区大沥镇广佛路101-102号阿拉卓盈酒店单栋(中小企)', '23.119205937566535', '113.19992321143123', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('598', '1022519', '乐从拓邦楼B座', '佛山市顺德区乐从镇葛仙路4号拓邦楼B座公寓(中小企)', '22.960491660034085', '113.0757096800434', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('599', '1015142', '桂城福爱嘉大厦', '佛山市南海区桂城街道海一路福爱嘉大厦单栋(中小企)', '23.048553267083738', '113.14481875134718', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('600', '976060', '陈村智光培训中心', '佛山市顺德区陈村镇兴业七路以东智光用电服务有限公司培训中心单栋宿舍(中小企)', '22.98290848946904', '113.23490650830748', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('601', '946958', '大良伊之密集团宿舍楼2栋', '佛山市顺德区大良街道顺昌路五沙伊之密集团宿舍楼2栋(中小企)', '22.81722120932376', '113.35032826900869', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('602', '939099', '大良伊之密集团宿舍楼1栋', '佛山市顺德区大良街道顺昌路五沙伊之密集团宿舍楼1栋(中小企)', '22.81771158680808', '113.35003807844774', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('603', '923001', '大沥威尔斯商业广场D栋', '佛山市南海区大沥镇西湖路18号威尔斯商业广场D栋(中小企)', '23.116981012202424', '113.18057166044643', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '休闲娱乐旅游');
INSERT INTO `f_floor_info` VALUES ('604', '913384', '乐从金沙天地B3座', '佛山市顺德区乐从镇金沙路金沙天地B3座(中小企)', '22.92874144765162', '113.0729410434076', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('605', '866862', '乐从广永财富大厦B栋', '佛山市顺德区乐从镇乐从大道南广永财富大厦（困难装机）B栋(中小企)', '22.951219638561395', '113.11594231372672', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('606', '866861', '乐从广永财富大厦A栋', '佛山市顺德区乐从镇乐从大道南广永财富大厦（困难装机）A栋(中小企)', '22.95069509605949', '113.11569384525839', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('607', '866851', '大良大信新都汇', '佛山市顺德区大良街道彩虹路1号大信新都汇（困难装机）单栋(中小企)', '22.80284046017062', '113.30259754848541', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('608', '850184', '狮山长富假日天玺公寓5栋', '佛山市南海区狮山镇孝贤路2号长富西站假日天玺公寓5栋(中小企)', '23.081191039118499', '113.04988835973434', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('609', '849717', '大沥百鸿大厦', '佛山市南海区大沥镇岭南路77号百鸿大厦单栋(中小企)', '23.116848256190577', '113.15014902916501', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('610', '849621', '伦教保发珠宝产业中心8栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）8栋公寓(中小企)', '22.88408338941905', '113.18803039400896', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('611', '849611', '伦教保发珠宝产业园14栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）14栋(创意中心)(中小企)', '22.883671470978123', '113.18639951590875', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('612', '849610', '伦教保发珠宝产业园13栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）13栋（钻石楼）(中小企)', '22.88285904815524', '113.18668738797295', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('613', '849608', '伦教保发珠宝产业园11栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）11栋（展示中心）(中小企)', '22.88331566535893', '113.18778458306264', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('614', '849607', '伦教保发珠宝产业园10栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）10栋（黄金楼）(中小企)', '22.882789458263326', '113.18759823874305', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('615', '849605', '伦教保发珠宝产业园12栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）12栋（珍珠楼）(中小企)', '22.883868444340707', '113.18771565635925', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('616', '849582', '伦教保发珠宝产业园9栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）9栋（宿舍楼）(中小企)', '22.88333955112824', '113.18915731855258', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('617', '849478', '伦教保发珠宝产业园6栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）6栋（翡翠楼）(中小企)', '22.884162431759305', '113.18650343141539', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('618', '849477', '伦教保发珠宝产业园7栋', '佛山市顺德区伦教街道翡翠路羊额村委会1号保发珠宝产业园（困难装机）7栋（宿舍楼）(中小企)', '22.883572185256793', '113.18854779812743', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('619', '849418', '伦教保发珠宝产业中心1座（白银楼）', '佛山市顺德区伦教街道翡翠路保发珠宝产业中心（困难装机）1座(中小企)', '22.88280965752526', '113.18508805261866', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('620', '842963', '伦教保发珠宝城售楼中心', '佛山市顺德区伦教街道翡翠路1号保发珠宝城（困难装机）售楼中心（小微)(中小企)', '22.88392000110891', '113.18735422911147', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('621', '840203', '北滘蚬华多媒体公司宿舍楼C座', '佛山市顺德区北滘镇三乐东路18号蚬华多媒体制品有限公司宿舍楼C座', '22.911377252087776', '113.24029287172293', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('622', '837340', '乐从信保广场4号楼', '佛山市顺德区乐从镇天虹路46号信保大厦南座(中小企)', '22.96824741599866', '113.14694893986222', '6-厚覆盖-垂直覆盖（插旗）', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('623', '831923', '陈村福朋喜来登酒店', '佛山市顺德区陈村镇文登路1号福朋喜来登酒店单栋', '22.97787732246923', '113.17948762051305', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('624', '815764', '狮山和信广场二期', '佛山市南海区狮山镇红星南路61号和信广场二期单栋(中小企)', '23.128298028942316', '113.01186995607772', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('625', '815050', '桂城城智大厦主楼', '佛山市南海区桂城街道海五路城智大厦(困难装机)主楼(中小企)', '23.061304209487948', '113.14302750893893', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('626', '814947', '大沥盐步美思汇广场', '佛山市南海区大沥镇穗盐西路盐步美思汇广场单栋(中小企)', '23.10094705645447', '113.17802098844912', '6-厚覆盖-垂直覆盖', '单栋单用户', '商住一体', '居民小区');
INSERT INTO `f_floor_info` VALUES ('627', '774235', '乐从信保大厦北座', '佛山市顺德区乐从镇天虹路46号信保大厦北座(中小企)', '22.968371707043699', '113.14791328164339', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('628', '771696', '南庄华寓精品公寓', '佛山市禅城区南庄镇陶兴大道华寓精品公寓单栋', '22.99150244202115', '113.02194839364855', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('629', '757473', '张槎乐俊装饰材料城3座', '佛山市禅城区张槎街道青柯路33号乐俊装饰材料城3座(中小企)', '23.022968327512804', '113.0897678216914', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('630', '727285', '乐从乐的商城A区', '佛山市顺德区乐从镇新马路乐的商城(千)A区(中小企)', '22.964813889685887', '113.09227646283368', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('631', '720770', '南庄东方誉采酒店', '佛山市禅城区南庄镇紫洞南路陶瓷总部特区E1栋广东东方誉采酒店(中小企)', '23.00383798049481', '113.01477302450079', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('632', '717896', '大沥坚美商务大厦', '佛山市南海区大沥镇城南一路坚美商务大厦单栋(中小企)', '23.11180033211312', '113.11971901668905', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('633', '717599', '大沥海北广场二期', '佛山市南海区大沥镇伯奇路海北广场二期(千)单栋(中小企)', '23.137018616552898', '113.19496643843782', '6-厚覆盖-垂直覆盖', '多栋多用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('634', '717142', '乐从新城中欧中心F座', '佛山市顺德区乐从镇岭南大道2号中欧中心F座(中小企)', '22.975650272486879', '113.13167032998659', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('635', '717135', '乐从新城中欧中心E座', '佛山市顺德区乐从镇岭南大道2号中欧中心E座(中小企)', '22.976136081402847', '113.13165746389712', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('636', '717131', '乐从新城中欧中心D座', '佛山市顺德区乐从镇岭南大道2号中欧中心D座', '22.97662662969109', '113.13166783518629', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('637', '716870', '大良恒德商厦', '佛山市顺德区大良街道新桂南路30号恒德商厦单栋(中小企)', '22.82345648970058', '113.27772858589465', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('638', '703778', '乐从艾尚酒店', '佛山市顺德区乐从镇乐从家具大道皇朝家私实惠店后楼艾尚酒店单栋(中小企)', '22.94447059494914', '113.09926949590833', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('639', '692961', '龙江世博汇C座', '佛山市顺德区龙江镇精美路18号世博汇（困难装机）C座(中小企)', '22.898484260301819', '113.05826708509555', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('640', '689898', '龙江韦富家具公司宿舍楼', '佛山市顺德区龙江镇排沙工业路9号韦富家具有限公司宿舍楼(中小企)', '22.8475284394657', '113.05011008819648', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('641', '685408', '狮山天智印刷公司宿舍楼', '佛山市南海区狮山镇小塘三环西路3号天智印刷科技公司宿舍楼(中小企)', '23.160296580909497', '112.9727417840341', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('642', '667630', '容桂SKG硅谷孵化园', '佛山市顺德区容桂街道天河路1号SKG硅谷孵化园（困难装机）单栋(中小企)', '22.754905878297476', '113.3124992704718', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('643', '650778', '石湾盈科亿家卫浴世界B2栋', '佛山市禅城区石湾街道季华四路盈科亿家卫浴世界（困难装机）B2栋(中小企)', '23.01648620333401', '113.10314693838274', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '购物');
INSERT INTO `f_floor_info` VALUES ('644', '646222', '乐从金乐大厦', '佛山市顺德区乐从镇新马路73号金乐大厦单栋(中小企)', '22.963519148374357', '113.09406420728385', '6-厚覆盖-垂直覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('645', '634609', '伦教汇泉商厦', '佛山市顺德区伦教街道振兴路38号汇泉商厦（困难装机）单栋(中小企)', '22.882664496491686', '113.21916580191869', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('646', '523456', '大沥富丽金酒店', '佛山市南海区大沥镇城南二路富丽金酒店1号楼', '23.110510871093387', '113.1231588060955', '6-厚覆盖-垂直覆盖（插旗）', '单栋单用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('647', '520353', '桂城金百福都市广场投建综合楼A栋', '佛山市南海区桂城街道东平路20号金百福都市广场投建综合楼A栋', '23.031032313022558', '113.17679438018927', '6-厚覆盖-垂直覆盖', '单栋多用户', '家用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('648', '516605', '九江中国城大酒店', '佛山市南海区九江镇奇腾路19号中国城大酒店1号楼', '22.83844025050926', '113.02709396272386', '5-厚覆盖-入楼成端', '单栋单用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('649', '514382', '荷城碧桂园凤凰酒店', '佛山市高明区荷城街道碧桂路188号碧桂园凤凰酒店单栋(中小企)', '22.86972478967421', '112.8480183709942', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('650', '509958', '大良李兆基中学宿舍楼8座', '佛山市顺德区大良街道东乐路18号李兆基中学(千)宿舍楼8座(中小企)', '22.843410321158435', '113.27311511134012', '5-厚覆盖-入楼成端', '单栋多用户', '家用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('651', '509957', '大良李兆基中学11座', '佛山市顺德区大良街道东乐路18号李兆基中学(千)11座(中小企)', '22.842935463701904', '113.27570420846954', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '教育科研');
INSERT INTO `f_floor_info` VALUES ('652', '509362', '大良明景糖尿病医院门诊部', '佛山市顺德区大良街道G105国道仙泉路口旁明景糖尿病医院门诊部单栋(中小企)', '22.806415236833286', '113.28276133943798', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('653', '501930', '乐从金威郦都6座', '佛山市顺德区乐从镇金瑞一路3号金威郦都(千)6座', '22.952817558944969', '113.09163113982528', '无覆盖', '#N/A', '#N/A', '#N/A');
INSERT INTO `f_floor_info` VALUES ('654', '500268', '乐从新城中欧中心G座', '佛山市顺德区乐从镇岭南大道2号中欧中心G座（小微）(中小企)', '22.97610040998152', '113.13322181079393', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('655', '499268', '乐从新联楼B2座', '佛山市顺德区乐从镇新马路A121号新联楼B2座(中小企)', '22.96356973501909', '113.09137413781967', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('656', '499263', '乐从新天地新时代商业城', '佛山市顺德区乐从镇新马路B161号新天地新时代商业城单栋', '22.965083175041629', '113.09148850804883', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('657', '497322', '大良顺德大融城', '佛山市顺德区大良街道南国东路30号顺德大融城单栋(中小企)', '22.832678601830687', '113.27942112939432', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('658', '496858', '大良新基时代广场', '佛山市顺德区大良街道马地街2号新基时代广场1号楼（小微）(中小企)', '22.842757911330126', '113.25927328334422', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('659', '488738', '容桂银海酒店', '佛山市顺德区容桂街道容桂大道中129号银海酒店单栋(中小企)', '22.75813071486603', '113.26591298728562', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('660', '487973', '容桂广东实验中学顺德学校学生宿舍', '佛山市顺德区容桂街道外环路广东实验中学顺德学校学生宿舍1座(中小企)', '22.798112353480425', '113.3340229812537', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '教育科研');
INSERT INTO `f_floor_info` VALUES ('661', '487947', '南庄中国陶瓷总部基地西区A座', '佛山市禅城区南庄镇季华西路68号中国陶瓷产业总部基地西区A座(中小企)', '23.007027356720028', '113.01494862456888', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('662', '295236', '石湾美居国际建材中心5座', '佛山市禅城区石湾街道绿景西路美居国际建材中心5座', '23.00844408460449', '113.1046317689365', '5-厚覆盖-入楼成端', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('663', '287692', '乐从星耀101广场西区', '佛山市顺德区乐从镇裕和路114号星耀101广场（千）单栋', '22.97180039754792', '113.12169817440544', '6-厚覆盖-垂直覆盖', '单栋多用户', '商住一体', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('664', '287233', '大沥宝盈广场', '佛山市南海区大沥镇体育西路2号宝盈广场单栋(中小企)', '23.123179363378595', '113.1096637716496', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('665', '284772', '狮山金盛广场', '佛山市南海区狮山镇府前路49号金盛广场单栋(中小企)', '23.063215859026156', '113.05917971629593', '6-厚覆盖-垂直覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('666', '264509', '祖庙松源商厦', '佛山市禅城区祖庙街道佛平路松源商厦单栋', '23.041850928522977', '113.1374855472622', '5-厚覆盖-入楼成端', '单栋多用户', '商住一体', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('667', '218342', '石湾华海渔港', '佛山市禅城区石湾街道黎明二路华海渔港单栋(中小企)', '22.993522887174835', '113.14195048987519', '6-厚覆盖-垂直覆盖', '单栋多用户', '家用', '居民小区');
INSERT INTO `f_floor_info` VALUES ('668', '634833', '祖庙岭南站', '佛山市禅城区祖庙街道祖庙路29号岭南站单栋(中小企)', '23.033292971612207', '113.1193441750565', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('669', '1431788', '杨和基业工业园7号车间', '佛山市高明区杨和镇高明大道中大坑洞村7号车间', '22.86133118613255', '112.74112479841003', '7-厚覆盖-水平覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('670', '758581', '世博商业中心', '佛山市禅城区石湾街道黎明一路23号首层', '22.998015414993558', '113.11977239077149', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('671', '803902', '石湾卓远国际副楼', '佛山市禅城区石湾街道季华五路2号卓远国际商务大厦副楼', '23.01678597850704', '113.11073536963403', '7-厚覆盖-水平覆盖', '单栋单用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('672', '517700', '石湾时代香海彼岸9座', '佛山市禅城区石湾街道华祥路时代香海彼岸（千）9座', '23.00301325147517', '113.16497955130152', '7-厚覆盖-水平覆盖', '单栋单用户', '家用', '居住楼');
INSERT INTO `f_floor_info` VALUES ('673', '505703', '石湾澜石(国际)金属交易中心1座', '佛山市禅城区石湾街道魁奇路澜石(国际)金属交易中心（困难装机）1座（小微）(中小企)', '22.995142614093159', '113.12235824413692', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('674', '809367', '石湾华艺装饰北区4号楼', '佛山市禅城区石湾街道雾岗路33号华艺装饰城北区4号楼', '23.00646443319203', '113.1019019779352', '7-厚覆盖-水平覆盖', '多栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('675', '797016', '南庄中源商贸大厦', '佛山市禅城区南庄镇南庄大道中中源商贸大厦单栋(中小企)', '22.99050014880353', '113.04879957147613', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('676', '298385', '南庄永光出租公寓', '佛山市禅城区南庄镇吉利大道西龙津村永光出租公寓单栋', '22.958100311961269', '113.01903915093274', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('677', '205416', '南庄新中源公寓1座', '佛山市禅城区南庄镇陶博大道10号华夏新中源公寓1座(中小企)', '22.969440436130815', '113.02420766640158', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '宾馆餐饮');
INSERT INTO `f_floor_info` VALUES ('678', '715802', '南庄岭南国际车城3号楼', '佛山市禅城区南庄镇季华西路128号岭南国际车城3号楼', '23.007373611617515', '113.03742172436032', '7-厚覆盖-水平覆盖', '多栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('679', '809168', '南庄涟岸花园149座', '佛山市禅城区南庄镇科润路10号涟岸花园149座', '23.0159434302747', '113.0375330794933', '7-厚覆盖-水平覆盖', '单栋多用户', '商住一体', '居住楼');
INSERT INTO `f_floor_info` VALUES ('680', '758525', '科明达国际商务中心', '', '22.963287028627659', '113.02894388412814', '7-厚覆盖-水平覆盖', '多栋多用户', '商用', '商业楼宇');
INSERT INTO `f_floor_info` VALUES ('681', '789695', '佛山科技学院弼唐东一街俊业百货', '佛山市禅城区张槎街道江湾一路18号俊业百货', '23.026529758820098', '113.10339432985623', '7-厚覆盖-水平覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('682', '766025', '陈村顺联国际机械城22座', '佛山市顺德区陈村镇兴业四路3期顺联国际机械城3期内22座(中小企)', '22.98589296426259', '113.23940125187193', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('683', '815221', '容桂天富来八期2栋', '佛山市顺德区容桂街道昌宝东路天富来八期2座(中小企)', '22.767671263370035', '113.32669724354605', '7-厚覆盖-水平覆盖', '单栋单用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('684', '815222', '容桂天富来八期3栋', '佛山市顺德区容桂街道昌宝东路天富来八期3座(中小企)', '22.767667655411477', '113.3254651031031', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('685', '815223', '容桂天富来八期1栋', '佛山市顺德区容桂街道昌宝东路天富来八期1座(中小企)', '22.768016213972428', '113.32555013467008', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('686', '815271', '容桂天富来八期4栋', '佛山市顺德区容桂街道昌宝东路天富来八期4座(中小企)', '22.76734917470453', '113.32651071967982', '7-厚覆盖-水平覆盖', '单栋多用户', '商用', '开发区、工业园');
INSERT INTO `f_floor_info` VALUES ('687', '720770', '南庄东方誉采酒店', '佛山市禅城区南庄镇紫洞南路陶瓷总部特区E1栋广东东方誉采酒店(中小企)', '23.00383798049481', '113.01477302450079', '6-厚覆盖-垂直覆盖', '单栋多用户', '商用', '宾馆餐饮');

-- ----------------------------
-- Table structure for f_integration_test
-- ----------------------------
DROP TABLE IF EXISTS `f_integration_test`;
CREATE TABLE `f_integration_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `big_project_name` varchar(255) DEFAULT NULL COMMENT '大项目名称',
  `point_name` varchar(255) DEFAULT NULL COMMENT '点位名称',
  `all_business_order_num` varchar(255) DEFAULT NULL COMMENT '全业务工单号',
  `region` varchar(255) DEFAULT NULL COMMENT '区域',
  `batch` varchar(255) DEFAULT NULL COMMENT '批次',
  `esop_segment` varchar(255) DEFAULT NULL COMMENT 'ESOP所在环节',
  `fk_segment` varchar(255) DEFAULT NULL COMMENT '服开所在环节',
  `all_business_segment` varchar(255) DEFAULT NULL COMMENT '全业务所在环节',
  `base_dig_work_over_time` varchar(255) DEFAULT NULL COMMENT '基础开挖手井施工完成时间',
  `floor_cage_install_over_time` varchar(255) DEFAULT NULL COMMENT '地笼安装完成时间',
  `base_pour_over_time` varchar(255) DEFAULT NULL COMMENT '基础浇筑完成时间',
  `take_electric_dig_over_time` varchar(255) DEFAULT NULL COMMENT '取电开挖完成时间',
  `pole_and_box_install_over_time` varchar(255) DEFAULT NULL COMMENT '立杆及箱体安装完成时间',
  `device_install_over_time` varchar(255) DEFAULT NULL COMMENT '设备安装完成时间',
  `is_electric_over_time` varchar(255) DEFAULT NULL COMMENT '是否通电完成时间',
  `device_test_over_time` varchar(255) DEFAULT NULL COMMENT '设备调试完成时间',
  `install_way_over_time` varchar(255) DEFAULT NULL COMMENT '安装方式完成时间',
  `integration_over_time` varchar(255) DEFAULT NULL COMMENT '集成计划完成时间',
  `is_over` varchar(255) DEFAULT NULL COMMENT '是否完成',
  `responsible_unit` varchar(255) DEFAULT NULL COMMENT '负责单位',
  `connect_people` varchar(255) DEFAULT NULL COMMENT '联系人',
  `connect_phone` varchar(255) DEFAULT NULL COMMENT '联系电话',
  `cancle_reason` varchar(255) DEFAULT NULL COMMENT '取消原因',
  `had_back_all_business_order_num` varchar(255) DEFAULT NULL COMMENT '曾退全业务单号',
  `operate_journal` varchar(255) DEFAULT NULL COMMENT '操作日志',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_integration_test
-- ----------------------------
INSERT INTO `f_integration_test` VALUES ('102', 'xxx', 'xx', 'QK-GCJS-20210603-0071', 'aaaa', 'aaaaqwes', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('103', 'xxx', 'xx', 'QK-GCJS-20210603-0072', 'aaaa', 'aaaaqwedwq', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('104', 'xxx', 'xx', 'QK-GCJS-20210603-0073', 'aaaa', 'aaaaasdasfewr', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('105', 'xxx', 'xx', 'QK-GCJS-20210603-0074', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('106', 'xxx', 'xx', 'QK-GCJS-20210603-0075', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('107', 'xxx', 'xx', 'QK-GCJS-20210603-0076', 'aaaa', 'aaaaqweg', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('108', 'xxx', 'xx', 'QK-GCJS-20210603-0077', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('109', 'xxx', 'xx', 'QK-GCJS-20210603-0078', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('110', 'xxx', 'xx', 'QK-GCJS-20210603-0079', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('111', 'xxx', 'xx', 'QK-GCJS-20210603-0080', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('112', 'xxx', 'xx', 'QK-GCJS-20210603-0081', 'aaaa', 'aaaa', 'aaaa', null, '资源判断', null, null, 'aaaa', null, null, null, null, 'aaaa', null, null, null, 'aaaa', 'aaaa', 'aaaa', 'aaaa', null, 'aaaa');
INSERT INTO `f_integration_test` VALUES ('113', 'xxx', 'xx', 'QK-GCJS-20210603-0082', 'xxx', 'bbb', 'ccc', null, '资源判断', null, null, 'ddd', null, null, null, null, 'eeee', null, null, null, null, null, null, null, null, null);
INSERT INTO `f_integration_test` VALUES ('114', '测试', '测试', 'QK-GCJS-20210604-0001', '禅城', null, null, null, '资源判断', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `f_integration_test` VALUES ('115', 'xxx', 'xx', 'QK-GCJS-20210604-0002', 'xxx', null, null, null, '资源判断', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `f_integration_test` VALUES ('116', 'xxx', 'xx', 'QK-GCJS-20210604-0003', 'xxx', null, null, null, '资源判断', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for f_jump_fibre
-- ----------------------------
DROP TABLE IF EXISTS `f_jump_fibre`;
CREATE TABLE `f_jump_fibre` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `a_point_address` varchar(255) DEFAULT NULL COMMENT '*a端地址',
  `a_point_picture_file` varchar(1000) DEFAULT NULL COMMENT '*a端照片',
  `z_point_address` varchar(255) DEFAULT NULL COMMENT '*z端地址',
  `z_point_picture_file` varchar(1000) DEFAULT NULL COMMENT '*z端照片',
  `lightline_num` varchar(255) DEFAULT NULL COMMENT '*光路数',
  `core_num` varchar(255) DEFAULT NULL COMMENT '*芯数',
  `use_type` varchar(255) DEFAULT NULL COMMENT '用途',
  `work_result_feed_back` varchar(255) DEFAULT NULL COMMENT '实施结果反馈',
  `all_file` varchar(1000) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_jump_fibre
-- ----------------------------
INSERT INTO `f_jump_fibre` VALUES ('14', '-----', '', '-----', '', '', '', '', '', null);
INSERT INTO `f_jump_fibre` VALUES ('15', '-----', '', '-----', '', '', '', '', '', null);
INSERT INTO `f_jump_fibre` VALUES ('16', '-----', '', '-----', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for f_line_system_confirm
-- ----------------------------
DROP TABLE IF EXISTS `f_line_system_confirm`;
CREATE TABLE `f_line_system_confirm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `files` varchar(1000) DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_line_system_confirm
-- ----------------------------
INSERT INTO `f_line_system_confirm` VALUES ('1', 'xxx', '5beb55023bfa4e0f8ae24acb84b864f4,99e18ff1cff04d06a22b89b344e929a5');
INSERT INTO `f_line_system_confirm` VALUES ('2', 'xxx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_line_system_confirm` VALUES ('3', 'xxx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_line_system_confirm` VALUES ('4', 'xxx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_line_system_confirm` VALUES ('5', 'xx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_line_system_confirm` VALUES ('6', 'xx', '5beb55023bfa4e0f8ae24acb84b864f4');
INSERT INTO `f_line_system_confirm` VALUES ('7', 'xxx', null);

-- ----------------------------
-- Table structure for f_local_pipeline_lightline_work
-- ----------------------------
DROP TABLE IF EXISTS `f_local_pipeline_lightline_work`;
CREATE TABLE `f_local_pipeline_lightline_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `in_punch_card_file` varchar(255) DEFAULT NULL COMMENT '*进场打卡',
  `in_time` varchar(255) DEFAULT NULL COMMENT '*进场时间',
  `pipeline_build_state` varchar(255) DEFAULT NULL COMMENT '管道完成情况',
  `pipeline_write_name` varchar(255) DEFAULT NULL COMMENT '管道录入名称',
  `pipeline_over_mile` varchar(255) DEFAULT NULL COMMENT '管道完工长度',
  `pipeline_all_pay` varchar(255) DEFAULT NULL COMMENT '管道完工总投资',
  `pipeline_page_file` varchar(255) DEFAULT NULL COMMENT '管道完工图纸',
  `cable_build_state` varchar(255) DEFAULT NULL COMMENT '光缆完成情况',
  `cable_write_name` varchar(255) DEFAULT NULL COMMENT '光缆录入名称',
  `cable_over_mile` varchar(255) DEFAULT NULL COMMENT '光缆完工长度（千米）',
  `cable_all_pay` varchar(255) DEFAULT NULL COMMENT '光缆完工总投资（万元）',
  `cable_page_file` varchar(255) DEFAULT NULL COMMENT '光缆完工图纸',
  `overtime_reason` varchar(255) DEFAULT NULL COMMENT '超时原因',
  `problem_feedback` varchar(255) DEFAULT NULL COMMENT '问题反馈',
  `problem_addr` varchar(255) DEFAULT NULL COMMENT '问题点',
  `all_file` text COMMENT '附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='本地网光缆建设';

-- ----------------------------
-- Records of f_local_pipeline_lightline_work
-- ----------------------------
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('2', null, '2021-05-1300:00:00', '次有资源开通', '2021-05-2000:00:00', null, null, '无资源开通', '2021-05-2100:00:00', '物资原因', '超时原因', '问题反馈', null, '49d46281658745a5b56a60055c2854a2,edf15630790e4a859a75407b79f8c0ff', null, null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('3', null, '2021-05-1300:00:00', '无资源开通', '2021-05-2000:00:00', null, null, '次有资源开通', '2021-05-2100:00:00', '物资原因', '超时原因', '问题反馈', null, 'edf15630790e4a859a75407b79f8c0ff', null, null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('4', null, '2021-06-23', '建设中', '123', '123', '123', '570838e54f7e4cd5b3bd132c96af8c11', '', '234', '123', '123', '570838e54f7e4cd5b3bd132c96af8c11', '物业原因', '1231', '302969cf36e34d1d99d57ee23217e7d1', null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('5', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('6', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('7', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('8', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('9', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('10', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('11', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('12', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);
INSERT INTO `f_local_pipeline_lightline_work` VALUES ('13', null, '', '', '', '', '', '', '', '', '', '', '', '', '', null, null);

-- ----------------------------
-- Table structure for f_organize_mutual
-- ----------------------------
DROP TABLE IF EXISTS `f_organize_mutual`;
CREATE TABLE `f_organize_mutual` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `expect_mutual_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '计划交维时间',
  `mutual_file` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '交维附件',
  `keep_unit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '维护单位',
  `client_is_sign_confirm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户是否签署开通确认单',
  `modify_line_system_order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改线上系统单号',
  `modify_project_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改项目名称',
  `modify_product_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改产品编号',
  `files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '其它附件',
  `gx_system_order_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管线系统光路调单号',
  `rounte_files` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '跳纤路由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of f_organize_mutual
-- ----------------------------
INSERT INTO `f_organize_mutual` VALUES ('16', '', null, '', '请选择', '', '', '', null, '', null);
INSERT INTO `f_organize_mutual` VALUES ('17', '', null, '', '请选择', '', '', '', null, '', null);
INSERT INTO `f_organize_mutual` VALUES ('18', '', null, '', '请选择', '', '', '', null, '', null);

-- ----------------------------
-- Table structure for f_over_work_confirm
-- ----------------------------
DROP TABLE IF EXISTS `f_over_work_confirm`;
CREATE TABLE `f_over_work_confirm` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `pipeline_is_over` varchar(255) DEFAULT NULL COMMENT '管线是否完工',
  `all_file` varchar(255) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_over_work_confirm
-- ----------------------------
INSERT INTO `f_over_work_confirm` VALUES ('17', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('18', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('19', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('20', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('21', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('22', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('23', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('24', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('25', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('26', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('27', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('28', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('29', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('30', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('31', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('32', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('33', '是', null);
INSERT INTO `f_over_work_confirm` VALUES ('34', '是', null);

-- ----------------------------
-- Table structure for f_pipeline_lightline_work
-- ----------------------------
DROP TABLE IF EXISTS `f_pipeline_lightline_work`;
CREATE TABLE `f_pipeline_lightline_work` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `in_punch_card_file` varchar(255) DEFAULT NULL COMMENT '*进场打卡',
  `in_time` varchar(255) DEFAULT NULL COMMENT '*进场时间',
  `pipeline_build` varchar(255) DEFAULT NULL COMMENT '*管道建设',
  `pipeline_complete_time` varchar(255) DEFAULT NULL COMMENT '*管道完成时间',
  `pipeline_picture_file` varchar(255) DEFAULT NULL COMMENT '管道照片',
  `other_file` varchar(255) DEFAULT NULL COMMENT '其他',
  `lightline_build` varchar(255) DEFAULT NULL COMMENT '*光缆建设',
  `lightline_complete_time` varchar(255) DEFAULT NULL COMMENT '*光缆完成时间',
  `overtime_sort` varchar(255) DEFAULT NULL COMMENT '*超时分类',
  `overtime_reason` varchar(255) DEFAULT NULL COMMENT '*超时原因',
  `problem_feedback` varchar(255) DEFAULT NULL COMMENT '问题反馈',
  `problem_poiont_file` varchar(255) DEFAULT NULL COMMENT '问题点',
  `all_file` varchar(255) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_pipeline_lightline_work
-- ----------------------------
INSERT INTO `f_pipeline_lightline_work` VALUES ('12', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('13', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('14', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('15', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('16', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('17', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('18', null, '', '', '', null, null, '', '', null, '', '', null, null);
INSERT INTO `f_pipeline_lightline_work` VALUES ('19', null, '', '', '', null, null, '', '', null, '', '', null, null);

-- ----------------------------
-- Table structure for f_resource_judge
-- ----------------------------
DROP TABLE IF EXISTS `f_resource_judge`;
CREATE TABLE `f_resource_judge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `building_resource` varchar(255) DEFAULT NULL COMMENT '楼宇资源',
  `is_directbulid` varchar(255) DEFAULT NULL COMMENT '是否直接装维',
  `big_device` varchar(255) DEFAULT NULL COMMENT '是否大设备',
  `baimi_is_resource` varchar(255) DEFAULT NULL COMMENT '几百米内容是否有资源',
  `network_build_pipe` varchar(255) DEFAULT NULL COMMENT '驻地网是否需建设管道',
  `local_build_pipe` varchar(255) DEFAULT NULL COMMENT '本地网是否需建设管道',
  `local_net` varchar(255) DEFAULT NULL COMMENT '本地网',
  `premise_net` varchar(255) DEFAULT NULL COMMENT '驻地网',
  `resource_stand` varchar(255) DEFAULT NULL COMMENT '资源标准',
  `resource_situation` varchar(255) DEFAULT NULL COMMENT '资源到达情况',
  `files` varchar(255) DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_resource_judge
-- ----------------------------
INSERT INTO `f_resource_judge` VALUES ('47', '禅城分公司-祖庙-季华路-测试楼-八层-801', '', '否', '', '', '是', '否', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('48', '禅城分公司-祖庙-季华路-测试楼-八层-801', '', '否', '', '', '否', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('49', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('50', '禅城分公司-祖庙-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('51', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('52', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('53', '南海分公司-桂城-123-123-123-213', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('54', '南海分公司-桂城-12-123-123-23', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('55', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('56', '南海分公司-桂城-123-1123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('57', '南海分公司-桂城----', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('58', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('59', '南海分公司-桂城-123-213-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('60', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('61', '南海分公司-桂城----', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('62', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('63', '南海分公司-桂城-123-123-23-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('64', '禅城分公司-祖庙-213-123-123-213', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('65', '禅城分公司-祖庙-123-213-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('66', '南海分公司-桂城-123-123-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('67', '南海分公司-桂城-123-123-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('68', '南海分公司-桂城-123-123-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('69', '南海分公司-桂城-123-123-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('70', '南海分公司-桂城-123-123-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('71', '南海分公司-桂城-123-123-213-213', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('72', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('73', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('74', '南海分公司-桂城-123-123-123-213', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('75', '南海分公司-桂城-qe-qwe-qwe-qwe', '', '是', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('76', '南海分公司-桂城----', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('77', '南海分公司-桂城-123-213-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('78', '南海分公司-桂城----', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('79', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('80', '南海分公司-桂城-123-213-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('81', '南海分公司-桂城-11-11-11-11', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('82', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('83', '南海分公司-桂城----', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('84', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('85', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('86', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('87', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('88', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('89', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('90', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('91', '南海分公司-桂城-213-123-123-123', '', '否', '', '', '是', '否', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('92', '禅城分公司-祖庙-213-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('93', '南海分公司-桂城----', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('94', '南海分公司-桂城-23-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('95', '南海分公司-桂城-asd-asd-sad-asd', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('96', '南海分公司-桂城-asd-asd-sad-asd', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('97', '南海分公司-桂城-asd-asd-sad-asd', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('98', '南海分公司-桂城-asd-asd-sad-asd', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('99', '南海分公司-桂城-asd-asd-sad-asd', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('100', '南海分公司-桂城-asd-asd-asd-asd', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('101', '南海分公司-桂城-asd-asd-asd-asd', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('102', '禅城分公司-祖庙-123-213-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('103', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('104', '南海分公司-桂城----', '', '', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('105', '南海分公司-桂城-1-1-1-1', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('106', '南海分公司-桂城-123-23-123-123', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('107', '南海分公司-桂城-234-234-234-234', '', '', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('108', '南海分公司-桂城-123-123-123-123', '', '否', '', '', '是', '是', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('109', '南海分公司-桂城-234-111--', '', '是', '', '', '', '', '', '', '', '', null);
INSERT INTO `f_resource_judge` VALUES ('110', '南海分公司-桂城-123-123-123-123', '', '是', '', '', '', '', '', '', '', '', null);

-- ----------------------------
-- Table structure for f_supply_cover_order_archive
-- ----------------------------
DROP TABLE IF EXISTS `f_supply_cover_order_archive`;
CREATE TABLE `f_supply_cover_order_archive` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `all_file` varchar(255) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_supply_cover_order_archive
-- ----------------------------
INSERT INTO `f_supply_cover_order_archive` VALUES ('7', '302969cf36e34d1d99d57ee23217e7d1');
INSERT INTO `f_supply_cover_order_archive` VALUES ('8', '');

-- ----------------------------
-- Table structure for f_unit_list
-- ----------------------------
DROP TABLE IF EXISTS `f_unit_list`;
CREATE TABLE `f_unit_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '单位名称',
  `unit_name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL COMMENT '联系邮件',
  `phone` varchar(255) DEFAULT NULL COMMENT '值班电话',
  `type` varchar(255) DEFAULT NULL COMMENT '类型（1：设计，2：施工，3：监理）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_unit_list
-- ----------------------------
INSERT INTO `f_unit_list` VALUES ('1', '单位1', '8888888@qq', '123124', '1');
INSERT INTO `f_unit_list` VALUES ('2', '单位2', '8888888@qq', '12312', '2');
INSERT INTO `f_unit_list` VALUES ('3', '单位3', '8888888@qq', '12312', '3');
INSERT INTO `f_unit_list` VALUES ('4', '单位4', '8888888@qq', '123123', '4');

-- ----------------------------
-- Table structure for f_verify_project
-- ----------------------------
DROP TABLE IF EXISTS `f_verify_project`;
CREATE TABLE `f_verify_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result` varchar(255) DEFAULT NULL,
  `suggest` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COLLATE=utf8_0900_ai_ci;

-- ----------------------------
-- Records of f_verify_project
-- ----------------------------
INSERT INTO `f_verify_project` VALUES ('11', '11', '111');
INSERT INTO `f_verify_project` VALUES ('12', '123', '123');
INSERT INTO `f_verify_project` VALUES ('13', '123', '123123');
INSERT INTO `f_verify_project` VALUES ('14', '213', '123');
INSERT INTO `f_verify_project` VALUES ('15', '123', '123');
INSERT INTO `f_verify_project` VALUES ('16', '234', '234');
INSERT INTO `f_verify_project` VALUES ('17', '111', '11');
INSERT INTO `f_verify_project` VALUES ('18', '11', '111');
INSERT INTO `f_verify_project` VALUES ('19', '123123', '123');
INSERT INTO `f_verify_project` VALUES ('20', '123', '');
INSERT INTO `f_verify_project` VALUES ('21', '', '');
INSERT INTO `f_verify_project` VALUES ('22', '', '');
INSERT INTO `f_verify_project` VALUES ('23', '11', '');
INSERT INTO `f_verify_project` VALUES ('24', '', '');
INSERT INTO `f_verify_project` VALUES ('25', '', '');
INSERT INTO `f_verify_project` VALUES ('26', '', '');
INSERT INTO `f_verify_project` VALUES ('27', '', '');
INSERT INTO `f_verify_project` VALUES ('28', '', '');
INSERT INTO `f_verify_project` VALUES ('29', '', '');
INSERT INTO `f_verify_project` VALUES ('30', '', '');
INSERT INTO `f_verify_project` VALUES ('31', '', '');

-- ----------------------------
-- Table structure for local_pipe_design_scheme
-- ----------------------------
DROP TABLE IF EXISTS `local_pipe_design_scheme`;
CREATE TABLE `local_pipe_design_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_build_pipeline` varchar(255) DEFAULT NULL COMMENT '是否建设管道',
  `pipeline_build_num` varchar(255) DEFAULT NULL COMMENT '管道建设编号',
  `pipeline_design_name` varchar(255) DEFAULT NULL COMMENT '管道设计名称',
  `pipeline_design_length` varchar(255) DEFAULT NULL COMMENT '管道设计长度',
  `implement_way_pipe` varchar(255) DEFAULT NULL COMMENT '实施方式',
  `pipeline_all_invest` varchar(255) DEFAULT NULL COMMENT '管道总投资(预算)',
  `implement_difficulty_level_pipe` varchar(255) DEFAULT NULL COMMENT '实施难度级别',
  `pipeline_design_paper_files` varchar(255) DEFAULT NULL COMMENT '管道设计图纸',
  `is_build_lightline` varchar(255) DEFAULT NULL COMMENT '是否光缆建设',
  `lightline_build_num` varchar(255) DEFAULT NULL COMMENT '光缆建设编号',
  `lightline_design_name` varchar(255) DEFAULT NULL COMMENT '光缆设计名称',
  `lightline_design_length` varchar(255) DEFAULT NULL COMMENT '光缆设计长度',
  `implement_way_light` varchar(255) DEFAULT NULL COMMENT '实施方式',
  `lightline_all_invest` varchar(255) DEFAULT NULL COMMENT '光缆总投资(预算)',
  `implement_difficulty_level_ligth` varchar(255) DEFAULT NULL COMMENT '实施难度级别',
  `lightline_design_paper_files` varchar(255) DEFAULT NULL COMMENT '光缆设计图纸',
  `up_connect_fibre_point` varchar(255) DEFAULT NULL COMMENT '上联接入分纤点',
  `up_device_type` varchar(255) DEFAULT NULL COMMENT '上联设备类型',
  `up_device_name` varchar(255) DEFAULT NULL COMMENT '上联设备名称',
  `design_unit` varchar(255) DEFAULT NULL COMMENT '设计单位',
  `manage_unit` varchar(255) DEFAULT NULL COMMENT '监理单位',
  `work_unit` varchar(255) DEFAULT NULL COMMENT '施工单位',
  `all_files` varchar(255) DEFAULT NULL COMMENT '附件列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of local_pipe_design_scheme
-- ----------------------------
INSERT INTO `local_pipe_design_scheme` VALUES ('14', '否', '123', '123', '123', '否', '123', '无法建设', '', '是', '12', '123', '123', '否', '123', '无法建设', '302969cf36e34d1d99d57ee23217e7d1,302969cf36e34d1d99d57ee23217e7d1', '123', '123', '123', '123', '213', '213', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('15', '否', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '7d46a175745c4425b3a79eaef83027c4,302969cf36e34d1d99d57ee23217e7d1', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('16', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '7d46a175745c4425b3a79eaef83027c4,302969cf36e34d1d99d57ee23217e7d1', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('17', '', '', '', '', '', '', '', '570838e54f7e4cd5b3bd132c96af8c11', '', '', '', '', '', '', '', '302969cf36e34d1d99d57ee23217e7d1', '', '', '', '', '', '', '302969cf36e34d1d99d57ee23217e7d1');
INSERT INTO `local_pipe_design_scheme` VALUES ('18', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('19', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '');
INSERT INTO `local_pipe_design_scheme` VALUES ('20', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('21', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('22', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('23', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('24', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('25', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('26', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('27', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `local_pipe_design_scheme` VALUES ('28', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父部门id',
  `pids` varchar(255) DEFAULT NULL COMMENT '父级ids',
  `simplename` varchar(45) DEFAULT NULL COMMENT '简称',
  `fullname` varchar(255) DEFAULT NULL COMMENT '全称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '版本（乐观锁保留字段）',
  `dept_no` varchar(255) DEFAULT NULL,
  `person` varchar(255) DEFAULT NULL COMMENT '负责人',
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=200 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES ('1', '1', '0', null, '佛山分公司', '佛山分公司', null, null, null, null, null);
INSERT INTO `sys_dept` VALUES ('45', '27', '1', '[0],[1],', '顺德区分公司', '顺德', '无', null, 'SD', '张三', '1');
INSERT INTO `sys_dept` VALUES ('46', '28', '1', '[0],[1],', '南海区分公司', '南海', '无', null, 'NH', '张三', '1');
INSERT INTO `sys_dept` VALUES ('47', '29', '1', '[0],[1],', '禅城区分公司', '禅城', '无', null, 'CC', '张三', '1');
INSERT INTO `sys_dept` VALUES ('48', '30', '1', '[0],[1],', '三水区分公司', '三水', '无', null, 'SS', '李四', '1');
INSERT INTO `sys_dept` VALUES ('49', '31', '1', '[0],[1],', '高明区分公司', '高明', '无', null, 'GM', '李四', '1');
INSERT INTO `sys_dept` VALUES ('165', '2', '0', null, '铁通公司', '铁通公司', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('166', '1', '165', '[0],[165],', '设计', '设计', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('167', '2', '165', '[0],[165],', '审核交维', '审核交维', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('168', '3', '165', '[0],[165],', '施工', '施工', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('169', '3', '0', null, '本地网现场设计公司', '本地网现场设计公司', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('170', '1', '169', '[0],[169],', '设计', '设计', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('171', '4', '0', null, '驻地网现场设计公司', '驻地网现场设计公司', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('172', '1', '171', '[0],[171],', '设计', '设计', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('173', '5', '0', null, '本地网管道光缆施工公司', '本地网管道光缆施工公司', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('174', '1', '173', '[0],[173],', '施工', '施工', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('175', '6', '0', null, '驻地网管道光缆施工公司', '驻地网管道光缆施工公司', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('176', '1', '175', '[0],[175],', '施工', '施工', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('177', '1', '47', '[0],[47],', '工程', '工程', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('178', '32', '1', '[0],[1],', '调度中心', '调度中心', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('179', '33', '1', '[0],[1],', '集客', '集客', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('180', '34', '1', '[0],[1],', '顺德政企', '顺德政企', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('181', '35', '1', '[0],[1],', '南海政企', '南海政企', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('182', '36', '1', '[0],[1],', '禅城政企', '禅城政企', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('184', '37', '1', '[0],[1],', '三水政企', '三水政企', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('185', '38', '1', '[0],[1],', '高明政企', '高明政企', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('186', '39', '1', '[0],[1],', '高明西区', '高明西区', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('187', '40', '1', '[0],[1],', '高明东区', '高明东区', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('188', '41', '1', '[0],[1],', '高明西区客户经理', '高明西区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('189', '42', '1', '[0],[1],', '高明东区客户经理', '高明东区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('190', '43', '1', '[0],[1],', '禅城西区客户经理', '禅城西区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('191', '44', '1', '[0],[1],', '禅城东区客户经理', '禅城东区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('192', '45', '1', '[0],[1],', '行销经理', '行销经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('193', '46', '1', '[0],[1],', '南海西区客户经理', '南海西区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('194', '47', '1', '[0],[1],', '南海区属', '南海区属', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('195', '48', '1', '[0],[1],', '南海西区', '南海西区', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('196', '49', '1', '[0],[1],', '顺德中区', '顺德中区', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('197', '50', '1', '[0],[1],', '顺德南区', '顺德南区', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('198', '51', '1', '[0],[1],', '顺德西区客户经理', '顺德西区客户经理', null, null, null, null, '1');
INSERT INTO `sys_dept` VALUES ('199', '52', '1', '[0],[1],', '顺德中区客户经理', '顺德中区客户经理', null, null, null, null, '1');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) DEFAULT NULL COMMENT '父级字典',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES ('29', '0', '0', '性别', null);
INSERT INTO `sys_dict` VALUES ('30', '1', '29', '男', null);
INSERT INTO `sys_dict` VALUES ('31', '2', '29', '女', null);
INSERT INTO `sys_dict` VALUES ('35', '0', '0', '账号状态', null);
INSERT INTO `sys_dict` VALUES ('36', '1', '35', '启用', null);
INSERT INTO `sys_dict` VALUES ('37', '2', '35', '冻结', null);
INSERT INTO `sys_dict` VALUES ('38', '3', '35', '已删除', null);
INSERT INTO `sys_dict` VALUES ('39', '0', '0', '这是一个字典测试', null);
INSERT INTO `sys_dict` VALUES ('40', '1', '39', '测试1', null);
INSERT INTO `sys_dict` VALUES ('41', '2', '39', '测试2', null);
INSERT INTO `sys_dict` VALUES ('42', '0', '0', '测试', null);
INSERT INTO `sys_dict` VALUES ('43', '1', '42', '测试1', null);
INSERT INTO `sys_dict` VALUES ('44', '2', '42', '测试2', null);

-- ----------------------------
-- Table structure for sys_login_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_login_log`;
CREATE TABLE `sys_login_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '管理员id',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否执行成功',
  `message` text COMMENT '具体消息',
  `ip` varchar(255) DEFAULT NULL COMMENT '登录ip',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9319 DEFAULT CHARSET=utf8 COMMENT='登录记录';

-- ----------------------------
-- Records of sys_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `code` varchar(255) DEFAULT NULL COMMENT '菜单编号',
  `pcode` varchar(255) DEFAULT NULL COMMENT '菜单父编号',
  `pcodes` varchar(255) DEFAULT NULL COMMENT '当前菜单的所有父菜单编号',
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(255) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(255) DEFAULT NULL COMMENT 'url地址',
  `num` int(65) DEFAULT NULL COMMENT '菜单排序号',
  `levels` int(65) DEFAULT NULL COMMENT '菜单层级',
  `ismenu` int(11) DEFAULT NULL COMMENT '是否是菜单（1：是  0：不是）',
  `tips` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` int(65) DEFAULT NULL COMMENT '菜单状态 :  1:启用   0:不启用',
  `isopen` int(11) DEFAULT NULL COMMENT '是否打开:    1:打开   0:不打开',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1017312761643802905 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('105', 'system', '0', '[0],', '系统管理', 'fa-user', '#', '103', '1', '1', null, '1', '1');
INSERT INTO `sys_menu` VALUES ('106', 'mgr', 'system', '[0],[system],', '用户管理', '', '/mgr', '1', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('107', 'mgr_add', 'mgr', '[0],[system],[mgr],', '添加用户', null, '/mgr/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('108', 'mgr_edit', 'mgr', '[0],[system],[mgr],', '修改用户', null, '/mgr/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('109', 'mgr_delete', 'mgr', '[0],[system],[mgr],', '删除用户', null, '/mgr/delete', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('110', 'mgr_reset', 'mgr', '[0],[system],[mgr],', '重置密码', null, '/mgr/reset', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('111', 'mgr_freeze', 'mgr', '[0],[system],[mgr],', '冻结用户', null, '/mgr/freeze', '5', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('112', 'mgr_unfreeze', 'mgr', '[0],[system],[mgr],', '解除冻结用户', null, '/mgr/unfreeze', '6', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('113', 'mgr_setRole', 'mgr', '[0],[system],[mgr],', '分配角色', null, '/mgr/setRole', '7', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('114', 'role', 'system', '[0],[system],', '角色管理', null, '/role', '2', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('115', 'role_add', 'role', '[0],[system],[role],', '添加角色', null, '/role/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('116', 'role_edit', 'role', '[0],[system],[role],', '修改角色', null, '/role/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('117', 'role_remove', 'role', '[0],[system],[role],', '删除角色', null, '/role/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('118', 'role_setAuthority', 'role', '[0],[system],[role],', '配置权限', null, '/role/setAuthority', '4', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('119', 'menu', 'system', '[0],[system],', '菜单管理', null, '/menu', '4', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('120', 'menu_add', 'menu', '[0],[system],[menu],', '添加菜单', null, '/menu/add', '1', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('121', 'menu_edit', 'menu', '[0],[system],[menu],', '修改菜单', null, '/menu/edit', '2', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('122', 'menu_remove', 'menu', '[0],[system],[menu],', '删除菜单', null, '/menu/remove', '3', '3', '0', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('128', 'log', 'system', '[0],[system],', '业务日志', null, '/log', '6', '2', '1', null, '1', '0');
INSERT INTO `sys_menu` VALUES ('130', 'druid', 'system', '[0],[system],', '监控管理', null, '/druid', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('131', 'dept', 'system', '[0],[system],', '部门管理', '', '/dept', '3', '2', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('132', 'dict', 'system', '[0],[system],', '字典管理', null, '/dict', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('133', 'loginLog', 'system', '[0],[system],', '登录日志', null, '/loginLog', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('134', 'log_clean', 'log', '[0],[system],[log],', '清空日志', null, '/log/delLog', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('135', 'dept_add', 'dept', '[0],[system],[dept],', '添加部门', null, '/dept/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('136', 'dept_update', 'dept', '[0],[system],[dept],', '修改部门', null, '/dept/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('137', 'dept_delete', 'dept', '[0],[system],[dept],', '删除部门', null, '/dept/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('138', 'dict_add', 'dict', '[0],[system],[dict],', '添加字典', null, '/dict/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('139', 'dict_update', 'dict', '[0],[system],[dict],', '修改字典', null, '/dict/update', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('140', 'dict_delete', 'dict', '[0],[system],[dict],', '删除字典', null, '/dict/delete', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('141', 'notice', 'system', '[0],[system],', '通知管理', null, '/notice', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('142', 'notice_add', 'notice', '[0],[system],[notice],', '添加通知', null, '/notice/add', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('143', 'notice_update', 'notice', '[0],[system],[notice],', '修改通知', null, '/notice/update', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('144', 'notice_delete', 'notice', '[0],[system],[notice],', '删除通知', null, '/notice/delete', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('145', 'hello', '0', '[0],', '地图资源', 'fa-map', '/base/map', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('148', 'code', '0', '[0],', '代码生成', 'fa-code', '/code', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('149', 'api_mgr', '0', '[0],', '接口文档', 'fa-leaf', '/swagger-ui.html', '2', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('150', 'to_menu_edit', 'menu', '[0],[system],[menu],', '菜单编辑跳转', '', '/menu/menu_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('151', 'menu_list', 'menu', '[0],[system],[menu],', '菜单列表', '', '/menu/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('152', 'to_dept_update', 'dept', '[0],[system],[dept],', '修改部门跳转', '', '/dept/dept_update', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('153', 'dept_list', 'dept', '[0],[system],[dept],', '部门列表', '', '/dept/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('154', 'dept_detail', 'dept', '[0],[system],[dept],', '部门详情', '', '/dept/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('155', 'to_dict_edit', 'dict', '[0],[system],[dict],', '修改菜单跳转', '', '/dict/dict_edit', '4', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('156', 'dict_list', 'dict', '[0],[system],[dict],', '字典列表', '', '/dict/list', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('157', 'dict_detail', 'dict', '[0],[system],[dict],', '字典详情', '', '/dict/detail', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('158', 'log_list', 'log', '[0],[system],[log],', '日志列表', '', '/log/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('159', 'log_detail', 'log', '[0],[system],[log],', '日志详情', '', '/log/detail', '3', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('160', 'del_login_log', 'loginLog', '[0],[system],[loginLog],', '清空登录日志', '', '/loginLog/delLoginLog', '1', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('161', 'login_log_list', 'loginLog', '[0],[system],[loginLog],', '登录日志列表', '', '/loginLog/list', '2', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('162', 'to_role_edit', 'role', '[0],[system],[role],', '修改角色跳转', '', '/role/role_edit', '5', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('163', 'to_role_assign', 'role', '[0],[system],[role],', '角色分配跳转', '', '/role/role_assign', '6', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('164', 'role_list', 'role', '[0],[system],[role],', '角色列表', '', '/role/list', '7', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('165', 'to_assign_role', 'mgr', '[0],[system],[mgr],', '分配角色跳转', '', '/mgr/role_assign', '8', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('166', 'to_user_edit', 'mgr', '[0],[system],[mgr],', '编辑用户跳转', '', '/mgr/user_edit', '9', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('167', 'mgr_list', 'mgr', '[0],[system],[mgr],', '用户列表', '', '/mgr/list', '10', '3', '0', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802751', '/grab_sheet/landRentInfo/contractPage', '/uploadData', '[0],[/uploadData],', '录入合同（土地）', '', '/grab_sheet/landRentInfo/contractPage', '99', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802754', '/grab_sheet/landRentInfo/contractPageHome', '/uploadData', '[0],[/uploadData],', '录入合同（房屋）', '', '/grab_sheet/landRentInfo/contractPageHome', '99', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802782', '/teshu', '0', '[0],', '指派', 'fa-rocket', '/teshu', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802783', '/blackboard/assertReportStatics', '0', '[0],', '统计', 'fa-bar-chart', '/blackboard/assertReportStatics', '1', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802840', '/workOrder/createOrderList', '/primary', '[0],[/primary],', '创建开通单', '99', '/workOrder/createOrderList', '8', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802842', '/qyw/engineering/index', '0', '[0],', '设计方案', '', '/qyw/engineering/index', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802843', '/projectProgress', '0', '[0],', '工程反馈', '', '/projectProgress', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802844', '/projectProgress/projectProgress', '/projectProgress', '[0],[/projectProgress],', '工程任务建设任务单', '', '/projectProgress/projectProgress', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802845', '/projectProgress/feedbackProjectProgress', '/projectProgress', '[0],[/projectProgress],', '反馈工程进度', '', '/projectProgress/feedbackProjectProgress', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802846', '/qyw/engineering/', '0', '[0],', '设计', '', '/qyw/engineering/', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802847', '/qyw/engineering/index1', '/primary', '[0],[/primary],', '设计方案', '', '/qyw/engineering/index', '9', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802848', '/qyw/engineering/design1', '/qyw/engineering/', '[0],[/qyw/engineering/],', '设计方案', '', '/qyw/engineering/design', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802849', '/qyw/engineering/newProject', '/qyw/engineering/', '[0],[/qyw/engineering/],', '新建派发', '', '/qyw/engineering/newProject', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802850', '/qyw/engineering/huang', '/qyw/engineering/', '[0],[/qyw/engineering/],', '挂起', '', '/qyw/engineering/huang', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802851', '/qyw/engineering/return', '/qyw/engineering/', '[0],[/qyw/engineering/],', '返回上一步', '', '/qyw/engineering/return', '5', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802852', '/qyw/engineering/break', '/qyw/engineering/', '[0],[/qyw/engineering/],', '退单', '', '/qyw/engineering/break', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802853', '/qyw/engineering/break_reason', '/qyw/engineering/', '[0],[/qyw/engineering/],', '退单原因', '', '/qyw/engineering/break_reason', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802854', '/workOrder/maintenanceWorkOrderQuery', '0', '[0],', '已交维工单查询', '', '/workOrder/maintenanceWorkOrderQuery', '5', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802855', '/qyw/delivery/organizationList', '/primary', '[0],[/primary],', '组织交维', '', '/qyw/delivery/organizationList', '16', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802856', '/qyw/delivery/confirmList', '/primary', '[0],[/primary],', '确认交维', '', '/qyw/delivery/confirmList', '16', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802857', '/workOrder/lineSystemConfirmList', '0', '[0],', '线上系统结单确认列表', '', '/workOrder/lineSystemConfirmList', '7', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802858', '/workOrder/bussinessAcceptanceList', '0', '[0],', '商务验收', '', '/workOrder/businessAcceptanceList', '8', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802859', '/workOrder/archive/archiveList', '/primary', '[0],[/primary],', '归档', '', '/workOrder/archive/archiveList', '17', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802860', '/qyw/beforeInfo/beforeInfo', '0', '[0],', '前勘单', '', '/qyw/beforeInfo/beforeInfo', '7', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802861', '/qyw/engineering/verifyList', '/primary', '[0],[/primary],', '审批方案', '', '/qyw/engineering/verifyList', '10', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802862', '/qyw/pipelineBuild/index', '0', '[0],', '管道光缆建设首页', '', '/qyw/pipelineBuild/index', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802863', '/qyw/pipelineBuild/pipelineConstruction', '0', '[0],', '管道光缆施工', '', '/qyw/pipelineBuild/pipelineConstruction', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802864', '/workOrder/PieLine/endPointPieLineList', '/primary', '[0],[/primary],', '末端光缆施工', '', '/workOrder/PieLine/endPointPieLineList', '13', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802865', '/qyw/beforeInfo/build', '0', '[0],', '建设前勘单', '', '/qyw/beforeInfo/build', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802867', '/workOrder/PieLine/installDeviceList', '/primary', '[0],[/primary],', '安装设备', '', '/workOrder/PieLine/installDeviceList', '14', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802868', '/qyw/beforeInfo/consultList', '0', '[0],', '咨询前勘单', '', '/qyw/beforeInfo/consultList', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802869', '/workOrder/PieLine/jumpFibreList', '/primary', '[0],[/primary],', '跳纤', '', '/workOrder/PieLine/jumpFibreList', '12', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802870', '/qyw/engineering/system_design_list', '/primary', '[0],[/primary],', '系统方案设计', '', '/qyw/engineering/system_design_list', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802871', '/qyw/engineering/scene_design_list', '/primary', '[0],[/primary],', '铁通现场前勘工单', '', '/qyw/engineering/scene_design_list', '5', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802872', '/qyw/engineering/computer_verify_list', '/primary', '[0],[/primary],', '网管审批', '', '/qyw/engineering/computer_verify_list', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802873', '/qyw/check/checkList', '/primary', '[0],[/primary],', '核查数据', '', '/qyw/check/checkList', '11', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802874', '/workOrder/PieLine/installDeviceList', '0', '[0],', '安装设备', '', '/workOrder/PieLine/installDeviceList', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802875', '/qyw/ttDesignResourceJudge/resourceList', '/primary', '[0],[/primary],', '资源判断列表', '', '/qyw/ttDesignResourceJudge/resourceList', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802876', '/qyw/coverOrder/LocalCoverList', '/fuzhu', '[0],[/fuzhu],', '本地网预覆盖工单', '', '/qyw/coverOrder/LocalCoverList', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802877', '/qyw/coverOrder/CompoundCoverList', '/fuzhu', '[0],[/fuzhu],', '驻地网预覆盖工单', '', '/qyw/coverOrder/CompoundCoverList', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802878', '/qyw/pipelineBuild/local_design_scheme_list', '/fuzhu', '[0],[/fuzhu],', '本地网设计方案', '', '/qyw/pipelineBuild/local_design_scheme_list', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802879', '/qyw/pipelineBuild/compound_design_scheme_list', '/fuzhu', '[0],[/fuzhu],', '驻地网设计方案', '', '/qyw/pipelineBuild/compound_design_scheme_list', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802880', '/qyw/pipelineBuild/overConfirmList', '/fuzhu', '[0],[/fuzhu],', '本地网管道光缆完工', '', '/qyw/pipelineBuild/overConfirmList', '7', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802881', '/qyw/pipelineBuild/supplyCoverOrderArchiveList', '/fuzhu', '[0],[/fuzhu],', '本地网补充覆盖工单归档', '', '/qyw/pipelineBuild/supplyCoverOrderArchiveList', '8', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802882', '/qyw/pipelineBuild/pipeline_lightline_work_list', '/fuzhu', '[0],[/fuzhu],', '驻地网管道光缆建设', '', '/qyw/pipelineBuild/pipeline_lightline_work_list', '6', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802883', '/qyw/pipelineBuild/local_pipeline_lightline_work_list', '/fuzhu', '[0],[/fuzhu],', '本地网管道光缆建设', '', '/qyw/pipelineBuild/local_pipeline_lightline_work_list', '5', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802884', '/aa', '0', '[0],', '错误页面', '', '/aa', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802885', '/qyw/beforeInfo/bigBusiness', '0', '[0],', '商机列表', '', '/qyw/beforeInfo/bigBusiness', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802886', '/flowInfo/OrderStatistics', '0', '[0],', '工单统计', '', '/flowInfo/OrderStatistics', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802887', '/qyw/verify/verifyList', '0', '[0],', '工单审核列表', 'fa-table', '/qyw/verify/verifyList', '7', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802888', '/qyw/engineering/local_scene_design_list', '/primary', '[0],[/primary],', '本地网现场前勘工单', '', '/qyw/engineering/local_scene_design_list', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802889', '/qyw/engineering/compound_scene_design_list', '/primary', '[0],[/primary],', '驻地网现场前勘工单', '', '/qyw/engineering/compound_scene_design_list', '4', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802890', '/aaaa', '0', '[0],', '商机单', 'fa-reorder', '/aaaa', '4', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802891', '/qyw/business/getBusinessDataPage', '/aaaa', '[0],[/aaaa],', '转派', '', '/qyw/business/getBusinessDataPage', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802892', '/qyw/business/businessUserPage', '/aaaa', '[0],[/aaaa],', '角色配置', '', '/qyw/business/businessUserPage', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802893', '/qyw/bigProjectCount/integrationTest', '0', '[0],', '集成测表格', '', '/qyw/bigProjectCount/integrationTest', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802894', '/qyw/beforeInfo/BuildList', '/primary', '[0],[/primary],', '前堪单列表', '', '/qyw/beforeInfo/BuildList', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802895', '/primary', '0', '[0],', '主流程', 'fa-tasks', '/primary', '2', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802896', '/fuzhu', '0', '[0],', '子流程', 'fa-server', '/fuzhu', '3', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802897', '/sta', '0', '[0],', '工程侧统计', '', '/sta', '99', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802898', '/qyw/statistics/dxm_table', '/sta', '[0],[/sta],', '大项目', '', '/qyw/statistics/dxm_table', '1', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802899', '/qyw/statistics/jk_table', '/sta', '[0],[/sta],', '业务侧', '', '/qyw/statistics/jk_table', '2', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802900', '/qyw/statistics/zx_table', '/sta', '[0],[/sta],', '建设侧', '', '/qyw/statistics/zx_table', '3', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802901', 'qyw/hangup/undo/index', '0', '[0],', '解除挂起审核', 'fa-undo', 'qyw/hangup/undo/index', '6', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802902', '/qyw/pipelineBuild/CompoundOverConfirmList', '/fuzhu', '[0],[/fuzhu],', '驻地网管道光缆完工', '', '/qyw/pipelineBuild/CompoundOverConfirmList', '8', '2', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802903', '/qyw/hangUp/getHangUpListPage', '0', '[0],', '挂起审核', 'fa-list', '/qyw/hangUp/getHangUpListPage', '5', '1', '1', null, '1', null);
INSERT INTO `sys_menu` VALUES ('1017312761643802904', '/qyw/pipelineBuild/compoundSupplyCoverOrderArchiveList', '/fuzhu', '[0],[/fuzhu],', '驻地网补充覆盖工单归档	', '', '/qyw/pipelineBuild/compoundSupplyCoverOrderArchiveList', '99', '2', '1', null, '1', null);

-- ----------------------------
-- Table structure for sys_notice
-- ----------------------------
DROP TABLE IF EXISTS `sys_notice`;
CREATE TABLE `sys_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `content` text COMMENT '内容',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `creater` int(11) DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='通知表';

-- ----------------------------
-- Records of sys_notice
-- ----------------------------

-- ----------------------------
-- Table structure for sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_operation_log`;
CREATE TABLE `sys_operation_log` (
  `id` int(65) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `logtype` varchar(255) DEFAULT NULL COMMENT '日志类型',
  `logname` varchar(255) DEFAULT NULL COMMENT '日志名称',
  `userid` int(65) DEFAULT NULL COMMENT '用户id',
  `classname` varchar(255) DEFAULT NULL COMMENT '类名称',
  `method` text COMMENT '方法名称',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `succeed` varchar(255) DEFAULT NULL COMMENT '是否成功',
  `message` text COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5714 DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of sys_operation_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_relation
-- ----------------------------
DROP TABLE IF EXISTS `sys_relation`;
CREATE TABLE `sys_relation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menuid` bigint(11) DEFAULT NULL COMMENT '菜单id',
  `roleid` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34115 DEFAULT CHARSET=utf8 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of sys_relation
-- ----------------------------
INSERT INTO `sys_relation` VALUES ('32236', '1017312761643802890', '44');
INSERT INTO `sys_relation` VALUES ('32237', '1017312761643802891', '44');
INSERT INTO `sys_relation` VALUES ('32238', '1017312761643802892', '44');
INSERT INTO `sys_relation` VALUES ('32775', '1017312761643802887', '45');
INSERT INTO `sys_relation` VALUES ('33290', '145', '47');
INSERT INTO `sys_relation` VALUES ('33291', '1017312761643802895', '47');
INSERT INTO `sys_relation` VALUES ('33292', '1017312761643802840', '47');
INSERT INTO `sys_relation` VALUES ('33293', '1017312761643802873', '47');
INSERT INTO `sys_relation` VALUES ('33294', '1017312761643802894', '47');
INSERT INTO `sys_relation` VALUES ('33295', '1017312761643802895', '49');
INSERT INTO `sys_relation` VALUES ('33296', '1017312761643802871', '49');
INSERT INTO `sys_relation` VALUES ('33297', '1017312761643802895', '50');
INSERT INTO `sys_relation` VALUES ('33298', '1017312761643802847', '50');
INSERT INTO `sys_relation` VALUES ('33299', '1017312761643802855', '50');
INSERT INTO `sys_relation` VALUES ('33300', '1017312761643802856', '50');
INSERT INTO `sys_relation` VALUES ('33301', '1017312761643802872', '50');
INSERT INTO `sys_relation` VALUES ('33302', '1017312761643802875', '50');
INSERT INTO `sys_relation` VALUES ('33313', '1017312761643802895', '46');
INSERT INTO `sys_relation` VALUES ('33314', '1017312761643802861', '46');
INSERT INTO `sys_relation` VALUES ('33315', '1017312761643802897', '46');
INSERT INTO `sys_relation` VALUES ('33316', '1017312761643802898', '46');
INSERT INTO `sys_relation` VALUES ('33317', '1017312761643802899', '46');
INSERT INTO `sys_relation` VALUES ('33318', '1017312761643802900', '46');
INSERT INTO `sys_relation` VALUES ('33319', '1017312761643802895', '51');
INSERT INTO `sys_relation` VALUES ('33320', '1017312761643802888', '51');
INSERT INTO `sys_relation` VALUES ('33321', '1017312761643802896', '51');
INSERT INTO `sys_relation` VALUES ('33322', '1017312761643802878', '51');
INSERT INTO `sys_relation` VALUES ('33325', '1017312761643802895', '53');
INSERT INTO `sys_relation` VALUES ('33326', '1017312761643802889', '53');
INSERT INTO `sys_relation` VALUES ('33327', '1017312761643802896', '53');
INSERT INTO `sys_relation` VALUES ('33328', '1017312761643802879', '53');
INSERT INTO `sys_relation` VALUES ('33331', '1017312761643802895', '55');
INSERT INTO `sys_relation` VALUES ('33332', '1017312761643802864', '55');
INSERT INTO `sys_relation` VALUES ('33333', '1017312761643802867', '55');
INSERT INTO `sys_relation` VALUES ('33334', '1017312761643802869', '55');
INSERT INTO `sys_relation` VALUES ('33498', '1017312761643802903', '63');
INSERT INTO `sys_relation` VALUES ('33499', '1017312761643802903', '64');
INSERT INTO `sys_relation` VALUES ('33500', '1017312761643802903', '65');
INSERT INTO `sys_relation` VALUES ('33501', '1017312761643802903', '66');
INSERT INTO `sys_relation` VALUES ('33502', '1017312761643802901', '68');
INSERT INTO `sys_relation` VALUES ('33503', '1017312761643802903', '68');
INSERT INTO `sys_relation` VALUES ('33504', '145', '48');
INSERT INTO `sys_relation` VALUES ('33505', '1017312761643802890', '48');
INSERT INTO `sys_relation` VALUES ('33506', '1017312761643802891', '48');
INSERT INTO `sys_relation` VALUES ('33507', '1017312761643802892', '48');
INSERT INTO `sys_relation` VALUES ('33508', '1017312761643802895', '48');
INSERT INTO `sys_relation` VALUES ('33509', '1017312761643802894', '48');
INSERT INTO `sys_relation` VALUES ('33510', '1017312761643802901', '48');
INSERT INTO `sys_relation` VALUES ('33511', '1017312761643802903', '48');
INSERT INTO `sys_relation` VALUES ('33660', '145', '60');
INSERT INTO `sys_relation` VALUES ('33661', '1017312761643802890', '60');
INSERT INTO `sys_relation` VALUES ('33662', '1017312761643802891', '60');
INSERT INTO `sys_relation` VALUES ('33663', '1017312761643802901', '60');
INSERT INTO `sys_relation` VALUES ('33664', '1017312761643802903', '60');
INSERT INTO `sys_relation` VALUES ('33671', '1017312761643802890', '56');
INSERT INTO `sys_relation` VALUES ('33672', '1017312761643802891', '56');
INSERT INTO `sys_relation` VALUES ('33673', '1017312761643802890', '57');
INSERT INTO `sys_relation` VALUES ('33674', '1017312761643802891', '57');
INSERT INTO `sys_relation` VALUES ('33675', '1017312761643802896', '52');
INSERT INTO `sys_relation` VALUES ('33676', '1017312761643802880', '52');
INSERT INTO `sys_relation` VALUES ('33677', '1017312761643802881', '52');
INSERT INTO `sys_relation` VALUES ('33678', '1017312761643802883', '52');
INSERT INTO `sys_relation` VALUES ('33679', '1017312761643802896', '54');
INSERT INTO `sys_relation` VALUES ('33680', '1017312761643802882', '54');
INSERT INTO `sys_relation` VALUES ('33681', '1017312761643802902', '54');
INSERT INTO `sys_relation` VALUES ('33682', '1017312761643802904', '54');
INSERT INTO `sys_relation` VALUES ('33683', '105', '1');
INSERT INTO `sys_relation` VALUES ('33684', '106', '1');
INSERT INTO `sys_relation` VALUES ('33685', '107', '1');
INSERT INTO `sys_relation` VALUES ('33686', '108', '1');
INSERT INTO `sys_relation` VALUES ('33687', '109', '1');
INSERT INTO `sys_relation` VALUES ('33688', '110', '1');
INSERT INTO `sys_relation` VALUES ('33689', '111', '1');
INSERT INTO `sys_relation` VALUES ('33690', '112', '1');
INSERT INTO `sys_relation` VALUES ('33691', '113', '1');
INSERT INTO `sys_relation` VALUES ('33692', '165', '1');
INSERT INTO `sys_relation` VALUES ('33693', '166', '1');
INSERT INTO `sys_relation` VALUES ('33694', '167', '1');
INSERT INTO `sys_relation` VALUES ('33695', '114', '1');
INSERT INTO `sys_relation` VALUES ('33696', '115', '1');
INSERT INTO `sys_relation` VALUES ('33697', '116', '1');
INSERT INTO `sys_relation` VALUES ('33698', '117', '1');
INSERT INTO `sys_relation` VALUES ('33699', '118', '1');
INSERT INTO `sys_relation` VALUES ('33700', '162', '1');
INSERT INTO `sys_relation` VALUES ('33701', '163', '1');
INSERT INTO `sys_relation` VALUES ('33702', '164', '1');
INSERT INTO `sys_relation` VALUES ('33703', '119', '1');
INSERT INTO `sys_relation` VALUES ('33704', '120', '1');
INSERT INTO `sys_relation` VALUES ('33705', '121', '1');
INSERT INTO `sys_relation` VALUES ('33706', '122', '1');
INSERT INTO `sys_relation` VALUES ('33707', '150', '1');
INSERT INTO `sys_relation` VALUES ('33708', '151', '1');
INSERT INTO `sys_relation` VALUES ('33709', '131', '1');
INSERT INTO `sys_relation` VALUES ('33710', '135', '1');
INSERT INTO `sys_relation` VALUES ('33711', '136', '1');
INSERT INTO `sys_relation` VALUES ('33712', '137', '1');
INSERT INTO `sys_relation` VALUES ('33713', '152', '1');
INSERT INTO `sys_relation` VALUES ('33714', '153', '1');
INSERT INTO `sys_relation` VALUES ('33715', '154', '1');
INSERT INTO `sys_relation` VALUES ('33716', '133', '1');
INSERT INTO `sys_relation` VALUES ('33717', '160', '1');
INSERT INTO `sys_relation` VALUES ('33718', '161', '1');
INSERT INTO `sys_relation` VALUES ('33719', '141', '1');
INSERT INTO `sys_relation` VALUES ('33720', '142', '1');
INSERT INTO `sys_relation` VALUES ('33721', '143', '1');
INSERT INTO `sys_relation` VALUES ('33722', '144', '1');
INSERT INTO `sys_relation` VALUES ('33723', '145', '1');
INSERT INTO `sys_relation` VALUES ('33724', '1017312761643802887', '1');
INSERT INTO `sys_relation` VALUES ('33725', '1017312761643802890', '1');
INSERT INTO `sys_relation` VALUES ('33726', '1017312761643802891', '1');
INSERT INTO `sys_relation` VALUES ('33727', '1017312761643802892', '1');
INSERT INTO `sys_relation` VALUES ('33728', '1017312761643802895', '1');
INSERT INTO `sys_relation` VALUES ('33729', '1017312761643802840', '1');
INSERT INTO `sys_relation` VALUES ('33730', '1017312761643802847', '1');
INSERT INTO `sys_relation` VALUES ('33731', '1017312761643802855', '1');
INSERT INTO `sys_relation` VALUES ('33732', '1017312761643802856', '1');
INSERT INTO `sys_relation` VALUES ('33733', '1017312761643802859', '1');
INSERT INTO `sys_relation` VALUES ('33734', '1017312761643802861', '1');
INSERT INTO `sys_relation` VALUES ('33735', '1017312761643802864', '1');
INSERT INTO `sys_relation` VALUES ('33736', '1017312761643802867', '1');
INSERT INTO `sys_relation` VALUES ('33737', '1017312761643802869', '1');
INSERT INTO `sys_relation` VALUES ('33738', '1017312761643802870', '1');
INSERT INTO `sys_relation` VALUES ('33739', '1017312761643802871', '1');
INSERT INTO `sys_relation` VALUES ('33740', '1017312761643802872', '1');
INSERT INTO `sys_relation` VALUES ('33741', '1017312761643802873', '1');
INSERT INTO `sys_relation` VALUES ('33742', '1017312761643802875', '1');
INSERT INTO `sys_relation` VALUES ('33743', '1017312761643802888', '1');
INSERT INTO `sys_relation` VALUES ('33744', '1017312761643802889', '1');
INSERT INTO `sys_relation` VALUES ('33745', '1017312761643802894', '1');
INSERT INTO `sys_relation` VALUES ('33746', '1017312761643802896', '1');
INSERT INTO `sys_relation` VALUES ('33747', '1017312761643802876', '1');
INSERT INTO `sys_relation` VALUES ('33748', '1017312761643802877', '1');
INSERT INTO `sys_relation` VALUES ('33749', '1017312761643802878', '1');
INSERT INTO `sys_relation` VALUES ('33750', '1017312761643802879', '1');
INSERT INTO `sys_relation` VALUES ('33751', '1017312761643802880', '1');
INSERT INTO `sys_relation` VALUES ('33752', '1017312761643802881', '1');
INSERT INTO `sys_relation` VALUES ('33753', '1017312761643802882', '1');
INSERT INTO `sys_relation` VALUES ('33754', '1017312761643802883', '1');
INSERT INTO `sys_relation` VALUES ('33755', '1017312761643802902', '1');
INSERT INTO `sys_relation` VALUES ('33756', '1017312761643802904', '1');
INSERT INTO `sys_relation` VALUES ('33863', '145', '70');
INSERT INTO `sys_relation` VALUES ('33864', '1017312761643802890', '70');
INSERT INTO `sys_relation` VALUES ('33865', '1017312761643802891', '70');
INSERT INTO `sys_relation` VALUES ('33866', '145', '71');
INSERT INTO `sys_relation` VALUES ('33867', '1017312761643802890', '71');
INSERT INTO `sys_relation` VALUES ('33868', '1017312761643802891', '71');
INSERT INTO `sys_relation` VALUES ('33869', '145', '72');
INSERT INTO `sys_relation` VALUES ('33870', '1017312761643802890', '72');
INSERT INTO `sys_relation` VALUES ('33871', '1017312761643802891', '72');
INSERT INTO `sys_relation` VALUES ('33872', '145', '73');
INSERT INTO `sys_relation` VALUES ('33873', '1017312761643802890', '73');
INSERT INTO `sys_relation` VALUES ('33874', '1017312761643802891', '73');
INSERT INTO `sys_relation` VALUES ('33875', '145', '74');
INSERT INTO `sys_relation` VALUES ('33876', '1017312761643802890', '74');
INSERT INTO `sys_relation` VALUES ('33877', '1017312761643802891', '74');
INSERT INTO `sys_relation` VALUES ('33878', '145', '75');
INSERT INTO `sys_relation` VALUES ('33879', '1017312761643802890', '75');
INSERT INTO `sys_relation` VALUES ('33880', '1017312761643802891', '75');
INSERT INTO `sys_relation` VALUES ('33881', '145', '76');
INSERT INTO `sys_relation` VALUES ('33882', '1017312761643802890', '76');
INSERT INTO `sys_relation` VALUES ('33883', '1017312761643802891', '76');
INSERT INTO `sys_relation` VALUES ('33884', '145', '77');
INSERT INTO `sys_relation` VALUES ('33885', '1017312761643802890', '77');
INSERT INTO `sys_relation` VALUES ('33886', '1017312761643802891', '77');
INSERT INTO `sys_relation` VALUES ('33887', '145', '78');
INSERT INTO `sys_relation` VALUES ('33888', '1017312761643802890', '78');
INSERT INTO `sys_relation` VALUES ('33889', '1017312761643802891', '78');
INSERT INTO `sys_relation` VALUES ('33890', '145', '79');
INSERT INTO `sys_relation` VALUES ('33891', '1017312761643802890', '79');
INSERT INTO `sys_relation` VALUES ('33892', '1017312761643802891', '79');
INSERT INTO `sys_relation` VALUES ('33893', '145', '80');
INSERT INTO `sys_relation` VALUES ('33894', '1017312761643802890', '80');
INSERT INTO `sys_relation` VALUES ('33895', '1017312761643802891', '80');
INSERT INTO `sys_relation` VALUES ('33896', '145', '81');
INSERT INTO `sys_relation` VALUES ('33897', '1017312761643802890', '81');
INSERT INTO `sys_relation` VALUES ('33898', '1017312761643802891', '81');
INSERT INTO `sys_relation` VALUES ('33899', '145', '82');
INSERT INTO `sys_relation` VALUES ('33900', '1017312761643802890', '82');
INSERT INTO `sys_relation` VALUES ('33901', '1017312761643802891', '82');
INSERT INTO `sys_relation` VALUES ('33902', '145', '83');
INSERT INTO `sys_relation` VALUES ('33903', '1017312761643802890', '83');
INSERT INTO `sys_relation` VALUES ('33904', '1017312761643802891', '83');
INSERT INTO `sys_relation` VALUES ('33905', '145', '84');
INSERT INTO `sys_relation` VALUES ('33906', '1017312761643802890', '84');
INSERT INTO `sys_relation` VALUES ('33907', '1017312761643802891', '84');
INSERT INTO `sys_relation` VALUES ('33908', '145', '85');
INSERT INTO `sys_relation` VALUES ('33909', '1017312761643802890', '85');
INSERT INTO `sys_relation` VALUES ('33910', '1017312761643802891', '85');
INSERT INTO `sys_relation` VALUES ('33911', '145', '86');
INSERT INTO `sys_relation` VALUES ('33912', '1017312761643802890', '86');
INSERT INTO `sys_relation` VALUES ('33913', '1017312761643802891', '86');
INSERT INTO `sys_relation` VALUES ('33914', '145', '87');
INSERT INTO `sys_relation` VALUES ('33915', '1017312761643802890', '87');
INSERT INTO `sys_relation` VALUES ('33916', '1017312761643802891', '87');
INSERT INTO `sys_relation` VALUES ('33917', '145', '88');
INSERT INTO `sys_relation` VALUES ('33918', '1017312761643802890', '88');
INSERT INTO `sys_relation` VALUES ('33919', '1017312761643802891', '88');
INSERT INTO `sys_relation` VALUES ('33920', '145', '89');
INSERT INTO `sys_relation` VALUES ('33921', '1017312761643802890', '89');
INSERT INTO `sys_relation` VALUES ('33922', '1017312761643802891', '89');
INSERT INTO `sys_relation` VALUES ('33923', '145', '90');
INSERT INTO `sys_relation` VALUES ('33924', '1017312761643802890', '90');
INSERT INTO `sys_relation` VALUES ('33925', '1017312761643802891', '90');
INSERT INTO `sys_relation` VALUES ('33931', '145', '91');
INSERT INTO `sys_relation` VALUES ('33932', '1017312761643802890', '91');
INSERT INTO `sys_relation` VALUES ('33933', '1017312761643802891', '91');
INSERT INTO `sys_relation` VALUES ('33934', '1017312761643802895', '91');
INSERT INTO `sys_relation` VALUES ('33935', '1017312761643802894', '91');
INSERT INTO `sys_relation` VALUES ('33936', '1017312761643802901', '91');
INSERT INTO `sys_relation` VALUES ('33937', '1017312761643802903', '91');
INSERT INTO `sys_relation` VALUES ('33938', '145', '92');
INSERT INTO `sys_relation` VALUES ('33939', '1017312761643802890', '92');
INSERT INTO `sys_relation` VALUES ('33940', '1017312761643802891', '92');
INSERT INTO `sys_relation` VALUES ('33941', '1017312761643802895', '92');
INSERT INTO `sys_relation` VALUES ('33942', '1017312761643802894', '92');
INSERT INTO `sys_relation` VALUES ('33943', '1017312761643802901', '92');
INSERT INTO `sys_relation` VALUES ('33944', '1017312761643802903', '92');
INSERT INTO `sys_relation` VALUES ('33945', '145', '93');
INSERT INTO `sys_relation` VALUES ('33946', '1017312761643802890', '93');
INSERT INTO `sys_relation` VALUES ('33947', '1017312761643802891', '93');
INSERT INTO `sys_relation` VALUES ('33948', '1017312761643802895', '93');
INSERT INTO `sys_relation` VALUES ('33949', '1017312761643802894', '93');
INSERT INTO `sys_relation` VALUES ('33950', '1017312761643802901', '93');
INSERT INTO `sys_relation` VALUES ('33951', '1017312761643802903', '93');
INSERT INTO `sys_relation` VALUES ('33952', '145', '94');
INSERT INTO `sys_relation` VALUES ('33953', '1017312761643802890', '94');
INSERT INTO `sys_relation` VALUES ('33954', '1017312761643802891', '94');
INSERT INTO `sys_relation` VALUES ('33955', '1017312761643802895', '94');
INSERT INTO `sys_relation` VALUES ('33956', '1017312761643802894', '94');
INSERT INTO `sys_relation` VALUES ('33957', '1017312761643802901', '94');
INSERT INTO `sys_relation` VALUES ('33958', '1017312761643802903', '94');
INSERT INTO `sys_relation` VALUES ('33959', '145', '95');
INSERT INTO `sys_relation` VALUES ('33960', '1017312761643802890', '95');
INSERT INTO `sys_relation` VALUES ('33961', '1017312761643802891', '95');
INSERT INTO `sys_relation` VALUES ('33962', '1017312761643802895', '95');
INSERT INTO `sys_relation` VALUES ('33963', '1017312761643802894', '95');
INSERT INTO `sys_relation` VALUES ('33964', '1017312761643802901', '95');
INSERT INTO `sys_relation` VALUES ('33965', '1017312761643802903', '95');
INSERT INTO `sys_relation` VALUES ('33966', '145', '96');
INSERT INTO `sys_relation` VALUES ('33967', '1017312761643802890', '96');
INSERT INTO `sys_relation` VALUES ('33968', '1017312761643802891', '96');
INSERT INTO `sys_relation` VALUES ('33969', '1017312761643802895', '96');
INSERT INTO `sys_relation` VALUES ('33970', '1017312761643802894', '96');
INSERT INTO `sys_relation` VALUES ('33971', '1017312761643802901', '96');
INSERT INTO `sys_relation` VALUES ('33972', '1017312761643802903', '96');
INSERT INTO `sys_relation` VALUES ('33973', '145', '97');
INSERT INTO `sys_relation` VALUES ('33974', '1017312761643802890', '97');
INSERT INTO `sys_relation` VALUES ('33975', '1017312761643802891', '97');
INSERT INTO `sys_relation` VALUES ('33976', '1017312761643802895', '97');
INSERT INTO `sys_relation` VALUES ('33977', '1017312761643802894', '97');
INSERT INTO `sys_relation` VALUES ('33978', '1017312761643802901', '97');
INSERT INTO `sys_relation` VALUES ('33979', '1017312761643802903', '97');
INSERT INTO `sys_relation` VALUES ('33980', '145', '98');
INSERT INTO `sys_relation` VALUES ('33981', '1017312761643802890', '98');
INSERT INTO `sys_relation` VALUES ('33982', '1017312761643802891', '98');
INSERT INTO `sys_relation` VALUES ('33983', '1017312761643802895', '98');
INSERT INTO `sys_relation` VALUES ('33984', '1017312761643802894', '98');
INSERT INTO `sys_relation` VALUES ('33985', '1017312761643802901', '98');
INSERT INTO `sys_relation` VALUES ('33986', '1017312761643802903', '98');
INSERT INTO `sys_relation` VALUES ('33987', '145', '99');
INSERT INTO `sys_relation` VALUES ('33988', '1017312761643802890', '99');
INSERT INTO `sys_relation` VALUES ('33989', '1017312761643802891', '99');
INSERT INTO `sys_relation` VALUES ('33990', '1017312761643802895', '99');
INSERT INTO `sys_relation` VALUES ('33991', '1017312761643802894', '99');
INSERT INTO `sys_relation` VALUES ('33992', '1017312761643802901', '99');
INSERT INTO `sys_relation` VALUES ('33993', '1017312761643802903', '99');
INSERT INTO `sys_relation` VALUES ('33994', '145', '100');
INSERT INTO `sys_relation` VALUES ('33995', '1017312761643802890', '100');
INSERT INTO `sys_relation` VALUES ('33996', '1017312761643802891', '100');
INSERT INTO `sys_relation` VALUES ('33997', '1017312761643802895', '100');
INSERT INTO `sys_relation` VALUES ('33998', '1017312761643802894', '100');
INSERT INTO `sys_relation` VALUES ('33999', '1017312761643802901', '100');
INSERT INTO `sys_relation` VALUES ('34000', '1017312761643802903', '100');
INSERT INTO `sys_relation` VALUES ('34001', '145', '101');
INSERT INTO `sys_relation` VALUES ('34002', '1017312761643802890', '101');
INSERT INTO `sys_relation` VALUES ('34003', '1017312761643802891', '101');
INSERT INTO `sys_relation` VALUES ('34004', '1017312761643802895', '101');
INSERT INTO `sys_relation` VALUES ('34005', '1017312761643802894', '101');
INSERT INTO `sys_relation` VALUES ('34006', '1017312761643802901', '101');
INSERT INTO `sys_relation` VALUES ('34007', '1017312761643802903', '101');
INSERT INTO `sys_relation` VALUES ('34008', '145', '102');
INSERT INTO `sys_relation` VALUES ('34009', '1017312761643802890', '102');
INSERT INTO `sys_relation` VALUES ('34010', '1017312761643802891', '102');
INSERT INTO `sys_relation` VALUES ('34011', '1017312761643802895', '102');
INSERT INTO `sys_relation` VALUES ('34012', '1017312761643802894', '102');
INSERT INTO `sys_relation` VALUES ('34013', '1017312761643802901', '102');
INSERT INTO `sys_relation` VALUES ('34014', '1017312761643802903', '102');
INSERT INTO `sys_relation` VALUES ('34015', '145', '103');
INSERT INTO `sys_relation` VALUES ('34016', '1017312761643802890', '103');
INSERT INTO `sys_relation` VALUES ('34017', '1017312761643802891', '103');
INSERT INTO `sys_relation` VALUES ('34018', '1017312761643802895', '103');
INSERT INTO `sys_relation` VALUES ('34019', '1017312761643802894', '103');
INSERT INTO `sys_relation` VALUES ('34020', '1017312761643802901', '103');
INSERT INTO `sys_relation` VALUES ('34021', '1017312761643802903', '103');
INSERT INTO `sys_relation` VALUES ('34022', '145', '104');
INSERT INTO `sys_relation` VALUES ('34023', '1017312761643802890', '104');
INSERT INTO `sys_relation` VALUES ('34024', '1017312761643802891', '104');
INSERT INTO `sys_relation` VALUES ('34025', '1017312761643802895', '104');
INSERT INTO `sys_relation` VALUES ('34026', '1017312761643802894', '104');
INSERT INTO `sys_relation` VALUES ('34027', '1017312761643802901', '104');
INSERT INTO `sys_relation` VALUES ('34028', '1017312761643802903', '104');
INSERT INTO `sys_relation` VALUES ('34029', '145', '105');
INSERT INTO `sys_relation` VALUES ('34030', '1017312761643802890', '105');
INSERT INTO `sys_relation` VALUES ('34031', '1017312761643802891', '105');
INSERT INTO `sys_relation` VALUES ('34032', '1017312761643802895', '105');
INSERT INTO `sys_relation` VALUES ('34033', '1017312761643802894', '105');
INSERT INTO `sys_relation` VALUES ('34034', '1017312761643802901', '105');
INSERT INTO `sys_relation` VALUES ('34035', '1017312761643802903', '105');
INSERT INTO `sys_relation` VALUES ('34036', '145', '106');
INSERT INTO `sys_relation` VALUES ('34037', '1017312761643802890', '106');
INSERT INTO `sys_relation` VALUES ('34038', '1017312761643802891', '106');
INSERT INTO `sys_relation` VALUES ('34039', '145', '107');
INSERT INTO `sys_relation` VALUES ('34040', '1017312761643802890', '107');
INSERT INTO `sys_relation` VALUES ('34041', '1017312761643802891', '107');
INSERT INTO `sys_relation` VALUES ('34042', '145', '108');
INSERT INTO `sys_relation` VALUES ('34043', '1017312761643802890', '108');
INSERT INTO `sys_relation` VALUES ('34044', '1017312761643802891', '108');
INSERT INTO `sys_relation` VALUES ('34045', '1017312761643802895', '108');
INSERT INTO `sys_relation` VALUES ('34046', '1017312761643802894', '108');
INSERT INTO `sys_relation` VALUES ('34047', '1017312761643802901', '108');
INSERT INTO `sys_relation` VALUES ('34048', '1017312761643802903', '108');
INSERT INTO `sys_relation` VALUES ('34049', '145', '109');
INSERT INTO `sys_relation` VALUES ('34050', '1017312761643802890', '109');
INSERT INTO `sys_relation` VALUES ('34051', '1017312761643802891', '109');
INSERT INTO `sys_relation` VALUES ('34052', '145', '110');
INSERT INTO `sys_relation` VALUES ('34053', '1017312761643802890', '110');
INSERT INTO `sys_relation` VALUES ('34054', '1017312761643802891', '110');
INSERT INTO `sys_relation` VALUES ('34055', '145', '111');
INSERT INTO `sys_relation` VALUES ('34056', '1017312761643802890', '111');
INSERT INTO `sys_relation` VALUES ('34057', '1017312761643802891', '111');
INSERT INTO `sys_relation` VALUES ('34058', '145', '112');
INSERT INTO `sys_relation` VALUES ('34059', '1017312761643802890', '112');
INSERT INTO `sys_relation` VALUES ('34060', '1017312761643802891', '112');
INSERT INTO `sys_relation` VALUES ('34061', '1017312761643802895', '112');
INSERT INTO `sys_relation` VALUES ('34062', '1017312761643802894', '112');
INSERT INTO `sys_relation` VALUES ('34063', '1017312761643802901', '112');
INSERT INTO `sys_relation` VALUES ('34064', '1017312761643802903', '112');
INSERT INTO `sys_relation` VALUES ('34065', '145', '113');
INSERT INTO `sys_relation` VALUES ('34066', '1017312761643802890', '113');
INSERT INTO `sys_relation` VALUES ('34067', '1017312761643802891', '113');
INSERT INTO `sys_relation` VALUES ('34068', '145', '114');
INSERT INTO `sys_relation` VALUES ('34069', '1017312761643802890', '114');
INSERT INTO `sys_relation` VALUES ('34070', '1017312761643802891', '114');
INSERT INTO `sys_relation` VALUES ('34071', '145', '115');
INSERT INTO `sys_relation` VALUES ('34072', '1017312761643802890', '115');
INSERT INTO `sys_relation` VALUES ('34073', '1017312761643802891', '115');
INSERT INTO `sys_relation` VALUES ('34074', '145', '116');
INSERT INTO `sys_relation` VALUES ('34075', '1017312761643802890', '116');
INSERT INTO `sys_relation` VALUES ('34076', '1017312761643802891', '116');
INSERT INTO `sys_relation` VALUES ('34077', '145', '117');
INSERT INTO `sys_relation` VALUES ('34078', '1017312761643802890', '117');
INSERT INTO `sys_relation` VALUES ('34079', '1017312761643802891', '117');
INSERT INTO `sys_relation` VALUES ('34080', '145', '118');
INSERT INTO `sys_relation` VALUES ('34081', '1017312761643802890', '118');
INSERT INTO `sys_relation` VALUES ('34082', '1017312761643802891', '118');
INSERT INTO `sys_relation` VALUES ('34083', '1017312761643802895', '118');
INSERT INTO `sys_relation` VALUES ('34084', '1017312761643802894', '118');
INSERT INTO `sys_relation` VALUES ('34085', '1017312761643802901', '118');
INSERT INTO `sys_relation` VALUES ('34086', '1017312761643802903', '118');
INSERT INTO `sys_relation` VALUES ('34087', '145', '119');
INSERT INTO `sys_relation` VALUES ('34088', '1017312761643802890', '119');
INSERT INTO `sys_relation` VALUES ('34089', '1017312761643802891', '119');
INSERT INTO `sys_relation` VALUES ('34090', '1017312761643802895', '119');
INSERT INTO `sys_relation` VALUES ('34091', '1017312761643802894', '119');
INSERT INTO `sys_relation` VALUES ('34092', '1017312761643802901', '119');
INSERT INTO `sys_relation` VALUES ('34093', '1017312761643802903', '119');
INSERT INTO `sys_relation` VALUES ('34094', '145', '120');
INSERT INTO `sys_relation` VALUES ('34095', '1017312761643802890', '120');
INSERT INTO `sys_relation` VALUES ('34096', '1017312761643802891', '120');
INSERT INTO `sys_relation` VALUES ('34097', '1017312761643802895', '120');
INSERT INTO `sys_relation` VALUES ('34098', '1017312761643802894', '120');
INSERT INTO `sys_relation` VALUES ('34099', '1017312761643802901', '120');
INSERT INTO `sys_relation` VALUES ('34100', '1017312761643802903', '120');
INSERT INTO `sys_relation` VALUES ('34101', '145', '121');
INSERT INTO `sys_relation` VALUES ('34102', '1017312761643802890', '121');
INSERT INTO `sys_relation` VALUES ('34103', '1017312761643802891', '121');
INSERT INTO `sys_relation` VALUES ('34104', '1017312761643802895', '121');
INSERT INTO `sys_relation` VALUES ('34105', '1017312761643802894', '121');
INSERT INTO `sys_relation` VALUES ('34106', '1017312761643802901', '121');
INSERT INTO `sys_relation` VALUES ('34107', '1017312761643802903', '121');
INSERT INTO `sys_relation` VALUES ('34108', '145', '122');
INSERT INTO `sys_relation` VALUES ('34109', '1017312761643802890', '122');
INSERT INTO `sys_relation` VALUES ('34110', '1017312761643802891', '122');
INSERT INTO `sys_relation` VALUES ('34111', '1017312761643802895', '122');
INSERT INTO `sys_relation` VALUES ('34112', '1017312761643802894', '122');
INSERT INTO `sys_relation` VALUES ('34113', '1017312761643802901', '122');
INSERT INTO `sys_relation` VALUES ('34114', '1017312761643802903', '122');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `num` int(11) DEFAULT NULL COMMENT '序号',
  `pid` int(11) DEFAULT NULL COMMENT '父角色id',
  `name` varchar(255) DEFAULT NULL COMMENT '角色名称',
  `deptid` int(11) DEFAULT NULL COMMENT '部门名称',
  `tips` varchar(255) DEFAULT NULL COMMENT '提示',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(暂时没用）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '1', '0', '分公司管理员', '24', 'administrator', '1');
INSERT INTO `sys_role` VALUES ('44', '99', '0', '商机人员', null, null, null);
INSERT INTO `sys_role` VALUES ('45', '99', '0', '集中办', null, null, null);
INSERT INTO `sys_role` VALUES ('46', null, '0', '禅城分公司工程主管', null, null, null);
INSERT INTO `sys_role` VALUES ('47', null, '0', '市公司调度中心操作员', null, null, null);
INSERT INTO `sys_role` VALUES ('48', null, '62', '市公司集客客户经理', null, null, null);
INSERT INTO `sys_role` VALUES ('49', null, '0', '铁通公司设计操作员', null, null, null);
INSERT INTO `sys_role` VALUES ('50', null, '0', '铁通公司审核交维操作员', null, null, null);
INSERT INTO `sys_role` VALUES ('51', null, '0', '本地网设计', null, null, null);
INSERT INTO `sys_role` VALUES ('52', null, '0', '本地网管道光缆建设', null, null, null);
INSERT INTO `sys_role` VALUES ('53', null, '0', '驻地网设计', null, null, null);
INSERT INTO `sys_role` VALUES ('54', null, '0', '驻地网管道光缆建设', null, null, null);
INSERT INTO `sys_role` VALUES ('55', null, '0', '铁通施工', null, null, null);
INSERT INTO `sys_role` VALUES ('62', null, '0', '挂起审核角色', null, null, null);
INSERT INTO `sys_role` VALUES ('63', '1', '62', '禅城区分公司', null, null, null);
INSERT INTO `sys_role` VALUES ('64', '2', '62', '南海区分公司', null, null, null);
INSERT INTO `sys_role` VALUES ('65', '3', '62', '顺德区分公司', null, null, null);
INSERT INTO `sys_role` VALUES ('66', '4', '62', '三水区分公司', null, null, null);
INSERT INTO `sys_role` VALUES ('67', '5', '62', '高明区分公司', null, null, null);
INSERT INTO `sys_role` VALUES ('68', '6', '62', '市公司', null, null, null);
INSERT INTO `sys_role` VALUES ('69', '7', '0', '商机类角色', null, '0', null);
INSERT INTO `sys_role` VALUES ('70', '2', '106', '市属', null, '2', null);
INSERT INTO `sys_role` VALUES ('71', '3', '106', '顺德区分公司', null, '2', null);
INSERT INTO `sys_role` VALUES ('72', '4', '106', '南海区分公司', null, '2', null);
INSERT INTO `sys_role` VALUES ('73', '5', '106', '禅城区分公司', null, '2', null);
INSERT INTO `sys_role` VALUES ('74', '6', '106', '三水区分公司', null, '2', null);
INSERT INTO `sys_role` VALUES ('75', '7', '106', '高明区分公司', null, '2', null);
INSERT INTO `sys_role` VALUES ('76', null, '71', '顺德中区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('77', null, '71', '顺德北区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('78', null, '71', '顺德东区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('79', null, '71', '顺德西区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('80', null, '71', '顺德南区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('81', null, '72', '南海中区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('82', null, '72', '南海东区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('83', null, '72', '南海南区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('84', null, '72', '南海西区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('85', null, '72', '南海北区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('86', null, '73', '禅城东区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('87', null, '73', '禅城西区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('88', null, '74', '三水南区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('89', null, '74', '三水北区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('90', null, '75', '高明东区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('91', null, '76', '顺德中区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('92', null, '77', '顺德北区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('93', null, '78', '顺德东区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('94', null, '79', '顺德西区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('95', null, '80', '顺德南区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('96', null, '81', '南海中区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('97', null, '82', '南海东区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('98', null, '83', '南海南区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('99', null, '84', '南海西区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('100', null, '85', '南海北区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('101', null, '86', '禅城东区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('102', null, '87', '禅城西区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('103', null, '88', '三水南区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('104', null, '89', '三水北区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('105', null, '90', '高明东区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('106', '1', '69', '市公司集客主任/主管', null, '1', null);
INSERT INTO `sys_role` VALUES ('107', null, '70', '市政企', null, '3', null);
INSERT INTO `sys_role` VALUES ('108', null, '107', '市政企客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('109', null, '69', '行销', null, '1', null);
INSERT INTO `sys_role` VALUES ('110', null, '69', '代理商', null, '1', null);
INSERT INTO `sys_role` VALUES ('111', null, '75', '高明西区政企中心', null, '3', null);
INSERT INTO `sys_role` VALUES ('112', null, '111', '高明西区政企中心客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('113', null, '74', '三水区属', null, '3', null);
INSERT INTO `sys_role` VALUES ('114', null, '73', '禅城区属', null, '3', null);
INSERT INTO `sys_role` VALUES ('115', null, '72', '南海区属', null, '3', null);
INSERT INTO `sys_role` VALUES ('116', null, '71', '顺德区属', null, '3', null);
INSERT INTO `sys_role` VALUES ('117', null, '74', '高明区属', null, '3', null);
INSERT INTO `sys_role` VALUES ('118', null, '113', '三水区属客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('119', null, '114', '禅城区属客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('120', null, '115', '南海区属客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('121', null, '116', '顺德区属客户经理', null, '4', null);
INSERT INTO `sys_role` VALUES ('122', null, '117', '高明区属客户经理', null, '4', null);

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  `account` varchar(45) DEFAULT NULL COMMENT '账号',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT 'md5密码盐',
  `name` varchar(45) DEFAULT NULL COMMENT '名字',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男 2：女）',
  `email` varchar(45) DEFAULT NULL COMMENT '电子邮件',
  `phone` varchar(45) DEFAULT NULL COMMENT '电话',
  `roleid` varchar(255) DEFAULT NULL COMMENT '角色id',
  `deptid` int(11) DEFAULT NULL COMMENT '部门id',
  `status` int(11) DEFAULT NULL COMMENT '状态(1：启用  2：冻结  3：删除）',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `version` int(11) DEFAULT NULL COMMENT '保留字段(支部ID）',
  `position` varchar(255) DEFAULT NULL,
  `bid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=370 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'girl.gif', 'admin', '109408f605c451c93c2de9c0606f122a', 'rfil5', '超级管理员', '2019-06-10 00:00:00', '1', 'abc@123.com', '18022231602', '1', '1', '1', '2016-01-29 08:49:53', '25', null, '37');
INSERT INTO `sys_user` VALUES ('327', null, 'center_admin', 'ec59d203eb35836f6f77099804354d44', '356p9', '集中办管理员', null, null, 'admin', '18888888888', '45', '1', '1', '2021-06-07 10:58:04', null, null, null);
INSERT INTO `sys_user` VALUES ('328', null, 'city_operator', '77dc37aa5a715b8796c099e9a74a09c7', 'zkbcq', '市公司调度中心操作员', null, null, 'admin@qq', '18888888888', '47', '178', '1', '2021-06-09 16:19:30', null, null, null);
INSERT INTO `sys_user` VALUES ('329', null, 'tie_design_operator', '1e50c76d3ad70993752928b8f97119ae', '18nlr', '铁通公司设计操作员', null, null, 'admin', '18888888888', '49', '166', '1', '2021-06-09 16:24:32', null, null, null);
INSERT INTO `sys_user` VALUES ('330', null, 'tie_verify_operator', '7f8656afa08a5f399072d8f48b2838f5', 'bah51', '铁通公司审核交维操作员', null, null, 'admin', '18888888888', '50', '167', '1', '2021-06-09 16:27:06', null, null, null);
INSERT INTO `sys_user` VALUES ('331', null, 'city_client_manager', 'd3f778c3ebefd8f6017fab0506194e95', 'fi7r3', '市公司集客客户经理', null, null, 'admin', '18888888888', '48', '179', '1', '2021-06-09 16:54:44', null, null, null);
INSERT INTO `sys_user` VALUES ('332', null, 'cc_eng_zg', '9694e6275b86b10c3364dc9a58b70828', 'yi9l0', '禅城分公司工程主管', null, null, 'admin', '18888888888', '46', '177', '1', '2021-06-09 17:05:48', null, null, null);
INSERT INTO `sys_user` VALUES ('333', null, 'local_design', '3a1d2967a48dd17f6a121dd56364d44c', 'djmfo', '本地网设计', null, null, 'admin', '18888888888', '51', '170', '1', '2021-06-09 17:13:21', null, null, null);
INSERT INTO `sys_user` VALUES ('334', null, 'local_work', '19bcbc776297a7aecf0acb45a8e522fa', 'xh4iv', '本地网管道光缆建设', null, null, 'admin', '18888888888', '52', '174', '1', '2021-06-09 17:17:16', null, null, null);
INSERT INTO `sys_user` VALUES ('335', null, 'compound_design', 'd86ce4a1c8e6bec76d3242f73ab13eac', '4dkrz', '驻地网设计', null, null, 'admin', '18888888888', '53', '172', '1', '2021-06-09 17:18:52', null, null, null);
INSERT INTO `sys_user` VALUES ('336', null, 'compound_work', '6797c086686f1a3309fef1645214d5b8', '34mqc', '驻地网管道光缆建设', null, null, 'admin', '18888888888', '54', '176', '1', '2021-06-09 17:25:29', null, null, null);
INSERT INTO `sys_user` VALUES ('337', null, 'tie_work', '6deed150140f947a4520852454a049cd', 'hdrxf', '铁通施工', null, null, 'admin', '18888888888', '55', '168', '1', '2021-06-09 17:26:41', null, null, null);
INSERT INTO `sys_user` VALUES ('340', null, 'shi_admin', '3c6fbb5d3ec335779ef5a2f17788326d', '1qvfa', '市公司管理员', null, null, null, null, '68', '1', '1', null, null, null, null);
INSERT INTO `sys_user` VALUES ('341', null, 'yxy', 'cffab9aa96f6aae33e04dbe0a8369c23', 'z55im', '袁昕宇', null, null, 'admin', '13825586338', '106', '179', '1', '2021-06-15 08:54:22', null, null, null);
INSERT INTO `sys_user` VALUES ('342', null, 'lyf', 'a44f0f8aec7dc1d6309db78294a24608', '13l3g', '李扬丰', null, null, 'admin', '13923112386', '106', '179', '1', '2021-06-15 08:58:43', null, null, null);
INSERT INTO `sys_user` VALUES ('343', null, 'bpx', 'e95185bdae86e04ec6c6a493ca0236b0', 'nvxgq', '白沛鑫', null, null, 'admin@qq', '18820869028', '106', '179', '1', '2021-06-15 09:00:01', null, null, null);
INSERT INTO `sys_user` VALUES ('344', null, 'cjb', '53aaf28afc183dccd9043eb91f247254', 'uam8s', '陈建波', null, null, 'admin', '18888888888', '106', '179', '1', '2021-06-15 09:02:57', null, null, null);
INSERT INTO `sys_user` VALUES ('345', null, 'nh_hang_admin', '116e7fe82f2df42e94e52499ceeb85ec', 'qhhxn', '南海挂起审核管理员', null, null, 'admin', '18888888888', '64', '46', '1', '2021-06-15 10:00:06', null, null, null);
INSERT INTO `sys_user` VALUES ('346', null, 'cc_hang_admin', '8313bba7ffd381a0bd5d9f47230b489e', 'tzn7w', '禅城挂起审核', null, null, 'admin', '18820869028', '63', '47', '1', '2021-06-15 11:04:55', null, null, null);
INSERT INTO `sys_user` VALUES ('347', null, 'wuqi', 'b5ebaf98545f99dc79f432cbd32ecfde', 'g1qfp', '吴琪', null, null, 'admin', '13929183637', '71', '180', '1', '2021-06-15 16:53:37', null, null, null);
INSERT INTO `sys_user` VALUES ('348', null, 'linzhe', 'a50b7cd0f7a2ef3a16937d5bf194b0c3', 'cs7nb', '林喆', null, null, 'admin', '13923141155', '71', '180', '1', '2021-06-15 16:57:32', null, null, null);
INSERT INTO `sys_user` VALUES ('349', null, 'huangzhifeng', '43487a86aae51277310662a2a3351c34', 'cc3m6', '黄芷枫', null, null, 'admin', '18820873838', '72', '181', '1', '2021-06-15 16:58:56', null, null, null);
INSERT INTO `sys_user` VALUES ('350', null, 'dengchuangye', 'bf73e796668c726861504502bf50498d', 'jmzn3', '邓创业', null, null, 'admin', '13928669029', '72', '181', '1', '2021-06-15 16:59:35', null, null, null);
INSERT INTO `sys_user` VALUES ('351', null, 'hongshangchu', '180a0a7f50cf3cdd71b2567fb1274228', 'yla0i', '洪珊瑚', null, null, 'admin', '13929939939', '73', '182', '1', '2021-06-15 17:00:47', null, null, null);
INSERT INTO `sys_user` VALUES ('352', null, 'lishengyou', '261cecfffe2085bc42e09bbd6404685b', 'gamvz', '李申由', null, null, 'admin', '13928569992', '74', '184', '1', '2021-06-15 17:01:42', null, null, null);
INSERT INTO `sys_user` VALUES ('353', null, 'fengweisheng', '43e80cd01b7098a711f5336dcb6864fc', 'mly2y', '冯伟生', null, null, 'admin', '13923108819', '75', '185', '1', '2021-06-15 17:06:47', null, null, null);
INSERT INTO `sys_user` VALUES ('354', null, 'qumingyi', 'fad00d104453c16ee989ce69048b7a61', 'n58re', '区敏毅', null, null, 'admin', '13925966663', '111', '186', '1', '2021-06-15 17:07:26', null, null, null);
INSERT INTO `sys_user` VALUES ('355', null, 'kangweijian', '72aa9f747a2e110317bace2c7a574f4f', 'atbuz', '康伟坚', null, null, 'admin', '13923109010', '90', '187', '1', '2021-06-15 17:08:20', null, null, null);
INSERT INTO `sys_user` VALUES ('356', null, 'liaojiehao', 'ebc0af3520875daf26dec7b4fa9a1490', 'kh5am', '廖结好', null, null, 'admin', '13928505590', '112', '188', '1', '2021-06-15 17:09:09', null, null, null);
INSERT INTO `sys_user` VALUES ('357', null, 'chensiqing', 'f33562f1c1df5c0a1c99e6bcead05e44', 's1gv6', '陈斯勤', null, null, 'admin', '13928504445', '105', '189', '1', '2021-06-15 17:09:50', null, null, null);
INSERT INTO `sys_user` VALUES ('358', null, 'chenhairong', '50efc9958e213f6dd23a036e9a1373f5', 'ihw2r', '陈海容', null, null, 'admin', '13929939057', '102', '190', '1', '2021-06-15 17:10:40', null, null, null);
INSERT INTO `sys_user` VALUES ('359', null, 'chenhuiyan', '321096609b4cb3ae2eede2ad336fe869', '7nl7j', '陈慧妍', null, null, 'admin', '13925992889', '101', '191', '1', '2021-06-15 17:12:37', null, null, null);
INSERT INTO `sys_user` VALUES ('360', null, 'liubaoyi', 'cbcf6f080404e13e1a7f07e76fab8823', 'nq1g9', '刘宝仪', null, null, 'admin', '13928230233', '109', '192', '1', '2021-06-15 17:13:24', null, null, null);
INSERT INTO `sys_user` VALUES ('361', null, 'linzhiqiang', '93fe592218aadce0661d8c6851a8984a', 'iba9s', '林志强', null, null, 'admin', '13929183981', '109', '192', '1', '2021-06-15 17:15:35', null, null, null);
INSERT INTO `sys_user` VALUES ('362', null, 'zhangzhengyang', '0f838ab2f2f40db3aa9b856f0b859ae2', 'jj11t', '张振洋', null, null, 'admin', '13927798221', '99', '193', '1', '2021-06-15 17:19:14', null, null, null);
INSERT INTO `sys_user` VALUES ('363', null, 'lihanming', '8310da44e2a2f61919c1ea636825ae36', 'esbpu', '黎汉明', null, null, 'admin', '13925991020', '115', '194', '1', '2021-06-15 17:20:00', null, null, null);
INSERT INTO `sys_user` VALUES ('364', null, 'chenlijia', 'a455a6f9fe339fa3243bf69d2eeb5380', '8ljcp', '陈丽佳', null, null, 'admin', '18312288825', '84', '195', '1', '2021-06-15 17:20:58', null, null, null);
INSERT INTO `sys_user` VALUES ('365', null, 'gongfenglian', '98ce8bb2b0080707e33c2f995ce5546d', 'tzi6j', '龚凤莲', null, null, 'admin', '13929183466', '76', '196', '1', '2021-06-15 17:21:50', null, null, null);
INSERT INTO `sys_user` VALUES ('366', null, 'qiuyue', '10c553af74f65ae72d95c6da86cebe77', 'bp43m', '邱越', null, null, 'admin', '13929183516', '80', '197', '1', '2021-06-15 17:23:30', null, null, null);
INSERT INTO `sys_user` VALUES ('367', null, 'maijianqiang', 'e37c21a82be412cf1dd3118743fc1d22', 'qimvy', '麦健强', null, null, 'admin', '13929183019', '94', '198', '1', '2021-06-15 17:26:14', null, null, null);
INSERT INTO `sys_user` VALUES ('368', null, 'zhijianfei', 'e37c21a82be412cf1dd3118743fc1d22', 'qimvy', '植剑飞', null, null, 'admin', '13929125808', '91', '199', '1', '2021-06-15 17:27:47', null, null, null);
-- ----------------------------
-- Table structure for t_guns_file
-- ----------------------------
DROP TABLE IF EXISTS `t_guns_file`;
CREATE TABLE `t_guns_file` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_id` varchar(32) DEFAULT NULL COMMENT '文件id，唯一标识',
  `filename` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `file_path` varchar(255) DEFAULT NULL COMMENT '文件保存路径',
  `mime_type` varchar(100) DEFAULT NULL,
  `thumb_path` varchar(255) DEFAULT NULL COMMENT '略缩图地址，文件则省略该字段、视频则为图片地址',
  `size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  `md5` varchar(35) DEFAULT NULL COMMENT '文件md5值',
  `type` varchar(20) DEFAULT NULL,
  `node` varchar(255) DEFAULT NULL,
  `upload_people` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_fileid` (`file_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=23192 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_guns_file
-- ----------------------------
INSERT INTO `t_guns_file` VALUES ('23186', '7d46a175745c4425b3a79eaef83027c4', 'aaa.jpg', '/uploads/20210527/7d46a175745c4425b3a79eaef83027c4.jpg', 'image/jpeg', '/uploads/20210527/thumbnails/thumb_7d46a175745c4425b3a79eaef83027c4.jpg', '16110', '2021-05-27 09:57:42', 'ce24aee526a9eb4d22f45e14bde32a6d', 'image', null, '超级管理员');
INSERT INTO `t_guns_file` VALUES ('23187', '302969cf36e34d1d99d57ee23217e7d1', 'chinaTelecom_logo.jpg', '/uploads/20210527/302969cf36e34d1d99d57ee23217e7d1.jpg', 'image/jpeg', '/uploads/20210527/thumbnails/thumb_302969cf36e34d1d99d57ee23217e7d1.jpg', '5014', '2021-05-27 09:57:43', '5b7d950a0b63d7d25ee49632e763fdfc', 'image', null, '超级管理员');
INSERT INTO `t_guns_file` VALUES ('23188', '570838e54f7e4cd5b3bd132c96af8c11', 'share.jpg', '/uploads/20210527/570838e54f7e4cd5b3bd132c96af8c11.jpg', 'image/jpeg', '/uploads/20210527/thumbnails/thumb_570838e54f7e4cd5b3bd132c96af8c11.jpg', '190567', '2021-05-27 09:57:50', '73b6d9d8f1cc0f4767b4d623aedbd56', 'image', null, '超级管理员');
INSERT INTO `t_guns_file` VALUES ('23189', '43d88c2653ad4c798cc3a68cdef3ce21', '平面图.png', '/uploads/20210527/43d88c2653ad4c798cc3a68cdef3ce21.png', 'image/png', '/uploads/20210527/thumbnails/thumb_43d88c2653ad4c798cc3a68cdef3ce21.jpg', '90360', '2021-05-27 09:57:50', '544bfaf860dc0fe853e15eaff230aeb3', 'image', null, '超级管理员');
INSERT INTO `t_guns_file` VALUES ('23190', '836febfc49924a0cbc89c98563b3f6d1', '188楼宇编码.xlsx', '/uploads/20210602/836febfc49924a0cbc89c98563b3f6d1.xlsx', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', '', '31561', '2021-06-02 14:40:19', 'ac844c60da98f9bc118b44ba06bcaba', 'image', null, '超级管理员');
INSERT INTO `t_guns_file` VALUES ('23191', '0868d1f5e8704971be5a240a6a4eb5bf', '188楼宇编码 - 副本.xlsx', '/uploads/20210602/0868d1f5e8704971be5a240a6a4eb5bf.xlsx', 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet', '', '31669', '2021-06-02 14:40:23', 'ed1d5a9d456ba7f2d09542bad8316ead', 'image', null, '超级管理员');

-- ----------------------------
-- Table structure for yd_compound_scene_scheme_design
-- ----------------------------
DROP TABLE IF EXISTS `yd_compound_scene_scheme_design`;
CREATE TABLE `yd_compound_scene_scheme_design` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cilent_pipeline_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户管线接入方式',
  `cilent_device_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户设备接入方式',
  `local_net_device_supplyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '驻地网主设备提供方',
  `is_new_physics_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新建物理地址',
  `client_computer_room_longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房经度',
  `client_computer_room_dimension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房纬度',
  `connect_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接入等级',
  `is_new_fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新增分光器',
  `fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分光器',
  `excavate_pipeline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开挖管道',
  `unexcavate_pipeline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '非挖管道（顶管）',
  `excavate_pipeline_length` decimal(10,2) DEFAULT NULL COMMENT '开挖管道长度',
  `unexcavate_pipeline_length` decimal(10,2) DEFAULT NULL COMMENT '非挖管道（顶管）长度',
  `excavate_pipeline_pore_length` decimal(10,2) DEFAULT NULL COMMENT '开挖管道管孔长度',
  `unexcavate_pipeline_pore_length` decimal(10,2) DEFAULT NULL COMMENT '非挖管道（顶管）管孔长度',
  `jia_device_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '甲供设备费(管道详细费用)',
  `yi_device_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '乙供材料费(管道详细费用)',
  `construction_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '施工费（不含乙供材料费）(管道详细费用)',
  `design_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '设计费(管道详细费用)',
  `manage_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '监理费(管道详细费用)',
  `all_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '总投资（元）(管道详细费用)',
  `fibre_core_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(纤芯)',
  `fibre_core_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(纤芯)',
  `fibre_core_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(纤芯)',
  `fibre_core_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(纤芯)',
  `length_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(长度：皮长公里)',
  `length_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(长度：皮长公里)',
  `lenth_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(长度：皮长公里)',
  `length_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(长度：皮长公里)',
  `fibre_core_length_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(纤芯长度：芯，公里)',
  `fibre_core_length_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(纤芯长度：芯，公里)',
  `fibre_core_length_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(纤芯长度：芯，公里)',
  `fibre_core_length_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(纤芯长度：芯，公里)',
  `jia_device_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '甲供设备费(光缆详细费用)',
  `yi_device_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙供材料费(光缆详细费用)',
  `construction_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '施工费（不含乙供材料费）(光缆详细费用)',
  `design_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设计费(光缆详细费用)',
  `manage_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监理费(光缆详细费用)',
  `all_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总投资（元）(光缆详细费用)',
  `sdn_m_quantity` int(11) DEFAULT NULL COMMENT '155m/622m SDH数量（端）',
  `sdn_m_price` decimal(10,2) DEFAULT NULL COMMENT '单价(155m/622m)',
  `sdn_g_quantity` int(11) DEFAULT NULL COMMENT '2.5G SDH数量（端）',
  `sdn_g_price` decimal(10,2) DEFAULT NULL COMMENT '单价(2.5G SDH数量（端）)',
  `sdn_g_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(2.5G SDH数量（端）)',
  `ptn_ge_quantity` int(11) DEFAULT NULL COMMENT 'GE PTN数量（端）',
  `ptn_ge_price` decimal(10,2) DEFAULT NULL COMMENT '单价(GE PTN数量)',
  `ptn_ten_ge_quantity` int(11) DEFAULT NULL COMMENT '10GE PTN数量',
  `ptn_ten_ge_price` decimal(10,2) DEFAULT NULL COMMENT '单价(10GE PTN数量)',
  `ptn_ten_ge_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(10GE PTN数量)',
  `pbx_quantity` int(11) DEFAULT NULL COMMENT 'PBX数量（台）',
  `pbx_price` decimal(10,2) DEFAULT NULL COMMENT '单价(PBX数量)',
  `pbx_all_capacity` int(11) DEFAULT NULL COMMENT 'PBX总容量（线）',
  `pbx_all_capacity_price` decimal(10,2) DEFAULT NULL COMMENT '单价(PBX总容量)',
  `pbx_all_capacity_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(PBX总容量)',
  `onu_ftth_quantity` int(11) DEFAULT NULL COMMENT 'FTTH ONU数量（个）(ONU)',
  `onu_price` decimal(10,2) DEFAULT NULL COMMENT '单价(ONU)',
  `onu_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(ONU)',
  `fgq_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(分光器)',
  `fgq_price` decimal(10,2) DEFAULT NULL COMMENT '单价(分光器)',
  `fgq_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(分光器)',
  `lyq_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(路由器)',
  `lyq_price` decimal(10,2) DEFAULT NULL COMMENT '单价(路由器)',
  `lyq_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(路由器)',
  `jhj_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(交换机)',
  `jhj_price` decimal(10,2) DEFAULT NULL COMMENT '单价(交换机)',
  `jhj_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(交换机)',
  `multiple_set_quantity` int(11) DEFAULT NULL COMMENT '线数（线）(综合布线)',
  `multiple_set_price` decimal(10,2) DEFAULT NULL COMMENT '单价(综合布线)',
  `multiple_set_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(综合布线)',
  `conver_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(协议转换器/光纤收发器)',
  `conver_price` decimal(10,2) DEFAULT NULL COMMENT '单价(协议转换器/光纤收发器)',
  `conver_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(协议转换器/光纤收发器)',
  `jia_device_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '甲供设备费(驻地网详细费用)',
  `yi_device_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙供材料费(驻地网详细费用)',
  `construction_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '施工费(驻地网详细费用)',
  `design_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设计费(驻地网详细费用)',
  `manage_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监理费(驻地网详细费用)',
  `all_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总投资（元）(驻地网详细费用)',
  `other_construct_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建设内容',
  `other_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(其他建设内容)',
  `other_scheme_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方案审核编码',
  `other_business_confirm_file` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传业务确认',
  `other_design_scheme_file` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传设计方案',
  `other_project_paper_file` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传工程图纸',
  `other_project_budget_file` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传工程预算',
  `next_progress_deal_time` int(11) DEFAULT NULL COMMENT '下环节处理时限(天)',
  `order_resource_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工单资源情况',
  `resource_arrive_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源到达情况',
  `building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼宇名称',
  `building_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼宇编码',
  `all_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传附件',
  `resource_standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源标准',
  `resource_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源到达情况',
  `is_tiaoqian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否跳纤',
  `is_submit` int(11) DEFAULT '0' COMMENT '是否提交状态',
  `a_address` varchar(255) DEFAULT NULL,
  `a_point` varchar(255) DEFAULT NULL,
  `a_lontitude` varchar(255) DEFAULT NULL,
  `a_latitude` varchar(255) DEFAULT NULL,
  `z_address` varchar(255) DEFAULT NULL,
  `z_point` varchar(255) DEFAULT NULL,
  `z_lontitude` varchar(255) DEFAULT NULL,
  `z_latitude` varchar(255) DEFAULT NULL,
  `abnormal_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常原因',
  `abnormal_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人',
  `abnormal_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人电话',
  `status` int(11) DEFAULT '1' COMMENT '工单状态（1:正常，2：退单，3：退回上一步，4：挂起，5保存，6退回开通单）',
  `verify_status` int(11) unsigned DEFAULT '0' COMMENT '审核状态（1:市公司审核，2分公司审核，3客户经理审核 , 4成功 5驳回）',
  `back_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '退单原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yd_compound_scene_scheme_design
-- ----------------------------
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('54', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '123', '123', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('55', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('56', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('57', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '123', '123', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('58', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '11', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('59', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '123', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('60', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, '（临时退单）工单信息错误/客户需求变更', '123', '111', '2', '9', '123');
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('61', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('62', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('63', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('64', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('65', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('66', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('67', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('68', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('69', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('70', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('71', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('72', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('73', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('74', null, null, null, null, null, null, null, null, null, '123', '123123', '213.00', '123.00', '123.00', '123.00', null, null, null, null, null, null, '123', '11', '11', '11', '11', '1', '11', '11', '11', '1', '11', '11', null, null, null, null, null, null, '1', null, '1', null, null, '1', null, '1', null, null, '1', null, '1', null, null, '1', null, null, '1', null, null, '1', null, null, '1', null, null, '1', null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('75', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, '111', '123', '3', '9', '123123');
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('76', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('77', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('78', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('79', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('80', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('81', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('82', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('83', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('84', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('85', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('86', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('87', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('88', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('89', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('90', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('91', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('92', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', '', null, null, null, null, null, null, null, null, null, null, '1', '0', null);
INSERT INTO `yd_compound_scene_scheme_design` VALUES ('93', null, null, null, null, null, null, null, null, null, '', '', null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '1', '南海区----', '', '', '', '南海区----', '', '', '', null, null, null, '1', '0', null);

-- ----------------------------
-- Table structure for yd_confirm_mutual
-- ----------------------------
DROP TABLE IF EXISTS `yd_confirm_mutual`;
CREATE TABLE `yd_confirm_mutual` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `is_add_fgq` varchar(11) DEFAULT NULL COMMENT '是否新增分光器',
  `fgq` varchar(255) DEFAULT NULL COMMENT '分光器',
  `mutual_time` varchar(255) DEFAULT NULL COMMENT '交维时间',
  `mutual_report_file` varchar(255) DEFAULT NULL COMMENT '交维报告',
  `confirm_mutual_file` varchar(255) DEFAULT NULL COMMENT '确认交维附件',
  `service_start_confirm` varchar(255) DEFAULT NULL COMMENT '业务开通确认单',
  `mutual_is_pass` varchar(255) DEFAULT NULL COMMENT '交维是否通过',
  `is_remain_problem` varchar(255) DEFAULT NULL COMMENT '是否有遗留问题',
  `remain_problem` varchar(255) DEFAULT NULL COMMENT '遗留问题',
  `mutual_suggestion` varchar(255) DEFAULT NULL COMMENT '交维意见',
  `is_complete_acceptance` varchar(255) DEFAULT NULL COMMENT '是否完成商务验收',
  `acceptance_participate_people` varchar(255) DEFAULT NULL COMMENT '商务验收参与人员（格式：姓名（电话））',
  `acceptance_participate_time` varchar(255) DEFAULT NULL COMMENT '商务验收时间',
  `client_acceptance_suggestion` varchar(255) DEFAULT NULL COMMENT '客户商务验收意见',
  `client_confirm_file` varchar(255) DEFAULT NULL COMMENT '用户确认书',
  `acceptance_participate_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yd_confirm_mutual
-- ----------------------------
INSERT INTO `yd_confirm_mutual` VALUES ('23', '', '', '', null, null, '', '', '', '', '', '', '', '', '', null, '');
INSERT INTO `yd_confirm_mutual` VALUES ('24', '', '', '', null, null, '', '', '', '', '', '', '', '', '', null, '');

-- ----------------------------
-- Table structure for yd_design_scheme
-- ----------------------------
DROP TABLE IF EXISTS `yd_design_scheme`;
CREATE TABLE `yd_design_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cilent_pipeline_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户管线接入方式',
  `cilent_device_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户设备接入方式',
  `local_net_device_supplyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主设备提供方',
  `is_new_physics_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新建物理地址',
  `z_computer_room_longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房经度',
  `z_computer_room_dimension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房纬度',
  `connect_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接入等级',
  `is_new_fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新增分光器',
  `fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分光器',
  `a_computer_room_longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端机房经度',
  `a_computer_room_dimension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端机房纬度',
  `sdh_count_m` int(10) DEFAULT NULL COMMENT '155/622m SDH数量',
  `sdh_count_g` int(10) DEFAULT NULL COMMENT '2.5G SDH数量',
  `ptn_count_one` int(10) DEFAULT NULL COMMENT 'GE PTN数量',
  `ptn_count_ten` int(10) DEFAULT NULL COMMENT '10 GE PTN数量',
  `pbx_count` int(10) DEFAULT NULL COMMENT 'pbx数量',
  `pbx_volume` double(10,2) DEFAULT NULL COMMENT 'pbx容量',
  `onu_count` int(10) DEFAULT NULL COMMENT 'ONU数量',
  `fgq_count` int(11) DEFAULT NULL COMMENT '分光器数量',
  `router_count` int(11) DEFAULT NULL COMMENT '路由器数量',
  `switchboard_count` int(11) DEFAULT NULL COMMENT '交换机数量',
  `wiring_count` int(11) DEFAULT NULL COMMENT '综合布线数量',
  `fibre_converter_count` int(11) DEFAULT NULL COMMENT '协议转换器/光纤收发器数量',
  `build_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建设内容',
  `scheme_verify_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方案审核编码',
  `business_ensure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务确认文件',
  `design_scheme` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设计方案文件',
  `engineer_budget` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工程预算文件',
  `deal_segment` int(11) DEFAULT NULL COMMENT '下环节处理时限',
  `resource_arrive` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源到达情况',
  `resource_standard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源标准',
  `is_tiaoxian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否跳纤',
  `z_building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'z端楼宇名称',
  `z_building_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'z端楼宇编码',
  `z_building_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'z端楼宇地址',
  `a_building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'a端楼宇名称',
  `a_building_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'a端楼宇编码',
  `a_building_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'a端机房地址',
  `cover_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '预覆盖站点地址',
  `all_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yd_design_scheme
-- ----------------------------
INSERT INTO `yd_design_scheme` VALUES ('4', '光纤', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '123', '123', '', '', '', '1231', '', '', '是', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('5', '光纤', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '123', '123', '', '', '', '1231', '', '', '是', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('6', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('7', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '否', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('8', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('9', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('10', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '是', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('11', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('12', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '是', '', '', '', '', '', '', '', '');
INSERT INTO `yd_design_scheme` VALUES ('13', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for yd_local_scene_scheme_design
-- ----------------------------
DROP TABLE IF EXISTS `yd_local_scene_scheme_design`;
CREATE TABLE `yd_local_scene_scheme_design` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `z_point_name` varchar(255) DEFAULT NULL COMMENT 'z端站点名称',
  `z_point_longitude` varchar(255) DEFAULT NULL COMMENT 'z端站点经度',
  `z_point_latitude` varchar(255) DEFAULT NULL COMMENT 'z端站点纬度',
  `z_point_business_address` varchar(255) DEFAULT NULL COMMENT 'z端业务接入地址',
  `a_point_name` varchar(255) DEFAULT NULL COMMENT 'a端站点名称',
  `a_point_longitude` varchar(255) DEFAULT NULL COMMENT 'a端站点经度',
  `a_point_latitude` varchar(255) DEFAULT NULL COMMENT 'a端站点纬度',
  `a_point_business_address` varchar(255) DEFAULT NULL COMMENT 'a端业务接入地址',
  `cilent_connect_people` varchar(255) DEFAULT NULL COMMENT '客户联系人',
  `cilent_connect_phone` varchar(255) DEFAULT NULL COMMENT '客户联系方式',
  `cilent_manager_connect_people` varchar(255) DEFAULT NULL COMMENT '客户经理联系人',
  `cilent_manager_connect_phone` varchar(255) DEFAULT NULL COMMENT '客户经理联系方式',
  `compound_design_connect_people` varchar(255) DEFAULT NULL COMMENT '驻地网设计院联系人',
  `compound_design_connect_phone` varchar(255) DEFAULT NULL COMMENT '驻地网设计院联系方式',
  `local_design_connect_people` varchar(255) DEFAULT NULL COMMENT '本地网设计院联系人',
  `local_design_connect_phone` varchar(255) DEFAULT NULL COMMENT '本地网设计院联系方式',
  `up_connect_fibre_point` varchar(255) DEFAULT NULL COMMENT '上联接入分纤点',
  `up_device_type` varchar(255) DEFAULT NULL COMMENT '上联设备类型',
  `up_device_name` varchar(255) DEFAULT NULL COMMENT '上联设备名称',
  `is_build_pipeline_pipe` varchar(255) DEFAULT NULL COMMENT '是否建设管道(管道）',
  `pipeline_length_pipe` varchar(255) DEFAULT NULL COMMENT '管道长度(管道）',
  `implement_way_pipe` varchar(255) DEFAULT NULL COMMENT '实施方式(管道）',
  `pipeline_all_invest_pipe` varchar(255) DEFAULT NULL COMMENT '管道总投资（估算)(单位：万元)(管道）',
  `implement_difficulty_level_pipe` varchar(255) DEFAULT NULL COMMENT '实施难度级别(管道）',
  `pipeline_survey_situation_remark_pipe` varchar(255) DEFAULT NULL COMMENT '管道勘查情况说明(管道）',
  `is_build_pipeline_light` varchar(255) DEFAULT NULL COMMENT '是否建设管道(光缆)',
  `pipeline_length_light` varchar(255) DEFAULT NULL COMMENT '管道长度(光缆)',
  `implement_way_light` varchar(255) DEFAULT NULL COMMENT '实施方式(光缆)',
  `pipeline_all_invest_light` varchar(255) DEFAULT NULL COMMENT '光缆总投资（估算）(单位：万元)(光缆)',
  `implement_difficulty_level_light` varchar(255) DEFAULT NULL COMMENT '实施难度级别(光缆)',
  `pipeline_survey_situation_remark_light` varchar(255) DEFAULT NULL COMMENT '光缆勘查情况说明(光缆)',
  `location_files` varchar(255) DEFAULT NULL COMMENT '定位截图',
  `initial_pipeline_build_map_files` varchar(255) DEFAULT NULL COMMENT '初步管道建设地图标示图',
  `initial_lightline_build_map_files` varchar(255) DEFAULT NULL COMMENT '初步光缆建设地图标示图',
  `scene_import_position_files` varchar(255) DEFAULT NULL COMMENT '现场重点位置照片',
  `other` varchar(255) DEFAULT NULL COMMENT '其它',
  `all_files` varchar(255) DEFAULT NULL COMMENT '附件列表',
  `is_submit` int(11) DEFAULT '0' COMMENT '是否提交状态',
  `abnormal_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常原因',
  `abnormal_link_people` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人',
  `abnormal_link_people_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '异常联系人电话',
  `status` int(11) DEFAULT '1' COMMENT '工单状态（1:正常，2：退单，3：退回上一步，4：挂起，5保存，6退回开通单）',
  `verify_status` int(11) unsigned DEFAULT '0' COMMENT '审核状态（1:市公司审核，2分公司审核，3客户经理审核 , 4成功 5驳回）',
  `back_cause` varchar(255) CHARACTER SET utf8 COLLATE utf8_0900_ai_ci DEFAULT NULL COMMENT '退单原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yd_local_scene_scheme_design
-- ----------------------------
INSERT INTO `yd_local_scene_scheme_design` VALUES ('36', '', '', '', '南海区----', '', '', '', '南海区----', '', '', '', '', '', '', '', '', '', '', '', '', '', '开挖', '', '', '', '', '', '开挖', '', '', '', '', '', '', '', '', null, '1', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('37', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('38', '', '', '', '南海区----', '', '', '', '南海区----', '', '', '', '', '', '', '', '', '', '', '', '', '', '开挖', '', '', '', '', '', '开挖', '', '', '', '', '', '', '', '', null, '1', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('39', '', '', '', '南海区----', '', '', '', '南海区----', '', '', '', '', '', '', '', '', '', '', '', '', '', '开挖', '', '', '', '', '', '开挖', '', '', '', '', '', '', '', '', null, '1', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('40', '', '', '', '南海区----', '', '', '', '南海区----', '', '', '', '', '', '', '', '', '', '', '', '', '', '开挖', '', '', '', '', '', '顶管', '', '', '', '', '', '', '', '', null, '1', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('41', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, '1', '0', null);
INSERT INTO `yd_local_scene_scheme_design` VALUES ('42', '', '', '', '南海区----', '', '', '', '南海区----', '', '', '', '', '', '', '', '', '', '', '', '', '', '开挖', '', '', '', '', '', '管道,杆路', '', '', '', '', '', '', '', '', null, '1', null, null, null, '1', '0', null);

-- ----------------------------
-- Table structure for yd_scene_design_scheme
-- ----------------------------
DROP TABLE IF EXISTS `yd_scene_design_scheme`;
CREATE TABLE `yd_scene_design_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cilent_pipeline_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户管线接入方式',
  `cilent_device_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户设备接入方式',
  `local_net_device_supplyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '驻地网主设备提供方',
  `is_new_physics_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新建物理地址',
  `client_computer_room_longitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房经度',
  `client_computer_room_dimension` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '客户端机房纬度',
  `connect_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '接入等级',
  `is_new_fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新增分光器',
  `fgq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分光器',
  `excavate_pipeline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开挖管道',
  `unexcavate_pipeline` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '非挖管道（顶管）',
  `excavate_pipeline_length` decimal(10,2) DEFAULT NULL COMMENT '开挖管道长度',
  `unexcavate_pipeline_length` decimal(10,2) DEFAULT NULL COMMENT '非挖管道（顶管）长度',
  `excavate_pipeline_pore_length` decimal(10,2) DEFAULT NULL COMMENT '开挖管道管孔长度',
  `unexcavate_pipeline_pore_length` decimal(10,2) DEFAULT NULL COMMENT '非挖管道（顶管）管孔长度',
  `jia_device_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '甲供设备费(管道详细费用)',
  `yi_device_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '乙供材料费(管道详细费用)',
  `construction_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '施工费（不含乙供材料费）(管道详细费用)',
  `design_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '设计费(管道详细费用)',
  `manage_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '监理费(管道详细费用)',
  `all_charge_pipeline` decimal(10,2) DEFAULT NULL COMMENT '总投资（元）(管道详细费用)',
  `fibre_core_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(纤芯)',
  `fibre_core_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(纤芯)',
  `fibre_core_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(纤芯)',
  `fibre_core_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(纤芯)',
  `length_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(长度：皮长公里)',
  `length_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(长度：皮长公里)',
  `lenth_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(长度：皮长公里)',
  `length_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(长度：皮长公里)',
  `fibre_core_length_pipe_deployment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '管道内或已有挂线下布放(纤芯长度：芯，公里)',
  `fibre_core_length_pole` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '立杆架空(纤芯长度：芯，公里)',
  `fibre_core_length_out_wall` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '外墙架空(纤芯长度：芯，公里)',
  `fibre_core_length_buried` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '直埋光缆(纤芯长度：芯，公里)',
  `jia_device_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '甲供设备费(光缆详细费用)',
  `yi_device_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙供材料费(光缆详细费用)',
  `construction_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '施工费（不含乙供材料费）(光缆详细费用)',
  `design_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设计费(光缆详细费用)',
  `manage_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监理费(光缆详细费用)',
  `all_charge_light` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总投资（元）(光缆详细费用)',
  `sdn_m_quantity` int(11) DEFAULT NULL COMMENT '155m/622m SDH数量（端）',
  `sdn_m_price` decimal(10,2) DEFAULT NULL COMMENT '单价(155m/622m)',
  `sdn_g_quantity` int(11) DEFAULT NULL COMMENT '2.5G SDH数量（端）',
  `sdn_g_price` decimal(10,2) DEFAULT NULL COMMENT '单价(2.5G SDH数量（端）)',
  `sdn_g_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(2.5G SDH数量（端）)',
  `ptn_ge_quantity` int(11) DEFAULT NULL COMMENT 'GE PTN数量（端）',
  `ptn_ge_price` decimal(10,2) DEFAULT NULL COMMENT '单价(GE PTN数量)',
  `ptn_ten_ge_quantity` int(11) DEFAULT NULL COMMENT '10GE PTN数量',
  `ptn_ten_ge_price` decimal(10,2) DEFAULT NULL COMMENT '单价(10GE PTN数量)',
  `ptn_ten_ge_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(10GE PTN数量)',
  `pbx_quantity` int(11) DEFAULT NULL COMMENT 'PBX数量（台）',
  `pbx_price` decimal(10,2) DEFAULT NULL COMMENT '单价(PBX数量)',
  `pbx_all_capacity` int(11) DEFAULT NULL COMMENT 'PBX总容量（线）',
  `pbx_all_capacity_price` decimal(10,2) DEFAULT NULL COMMENT '单价(PBX总容量)',
  `pbx_all_capacity_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(PBX总容量)',
  `onu_ftth_quantity` int(11) DEFAULT NULL COMMENT 'FTTH ONU数量（个）(ONU)',
  `onu_price` decimal(10,2) DEFAULT NULL COMMENT '单价(ONU)',
  `onu_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(ONU)',
  `fgq_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(分光器)',
  `fgq_price` decimal(10,2) DEFAULT NULL COMMENT '单价(分光器)',
  `fgq_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(分光器)',
  `lyq_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(路由器)',
  `lyq_price` decimal(10,2) DEFAULT NULL COMMENT '单价(路由器)',
  `lyq_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(路由器)',
  `jhj_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(交换机)',
  `jhj_price` decimal(10,2) DEFAULT NULL COMMENT '单价(交换机)',
  `jhj_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(交换机)',
  `multiple_set_quantity` int(11) DEFAULT NULL COMMENT '线数（线）(综合布线)',
  `multiple_set_price` decimal(10,2) DEFAULT NULL COMMENT '单价(综合布线)',
  `multiple_set_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(综合布线)',
  `conver_quantity` int(11) DEFAULT NULL COMMENT '数量（个）(协议转换器/光纤收发器)',
  `conver_price` decimal(10,2) DEFAULT NULL COMMENT '单价(协议转换器/光纤收发器)',
  `conver_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(协议转换器/光纤收发器)',
  `jia_device_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '甲供设备费(驻地网详细费用)',
  `yi_device_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '乙供材料费(驻地网详细费用)',
  `construction_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '施工费(驻地网详细费用)',
  `design_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设计费(驻地网详细费用)',
  `manage_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '监理费(驻地网详细费用)',
  `all_charge_local` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总投资（元）(驻地网详细费用)',
  `other_construct_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建设内容',
  `other_invest` decimal(10,2) DEFAULT NULL COMMENT '投资（元）(其他建设内容)',
  `other_scheme_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '方案审核编码',
  `order_resource_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工单资源情况',
  `resource_arrive_situation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资源到达情况',
  `building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼宇名称',
  `building_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '楼宇编码',
  `a_building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端楼宇名称',
  `a_building_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端楼宇编码',
  `a_computer_room_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端机房详细地址',
  `z_building_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Z端楼宇名称',
  `z_building_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Z端楼宇编码',
  `z_computer_room_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Z端机房详细地址',
  `all_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上传附件',
  `point_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '站点名称',
  `point_lon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '站点经度',
  `point_lat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '站点纬度',
  `pre_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前堪人',
  `pre_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '前堪人联系电话',
  `is_need_bdwbl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否需要本地网补缆',
  `gl_long` decimal(10,2) DEFAULT NULL COMMENT '光缆长度',
  `is_need_net` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否需本地网',
  `is_over` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否满足进场施工',
  `is_new_add_gj` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否新立光交',
  `is_glkw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否过路开挖',
  `is_have_hw` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '红线外端口是否充足',
  `problem` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '问题反馈',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `lygm_pictures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '路由概貌图',
  `axt_pictures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Z端目标点位/箱体图',
  `zxt_pictures` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A端大网箱体图',
  `resource_standard` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '资源标准',
  `resource_situation` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '资源到达情况',
  `wy_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物业联系人电话',
  `wy_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '物业联系人',
  `is_tiaoqian` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否跳迁',
  `a_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `a_point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `a_lontitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `a_latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `z_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `z_point` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `z_lontitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `z_latitude` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `lay_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yd_scene_design_scheme
-- ----------------------------
INSERT INTO `yd_scene_design_scheme` VALUES ('86', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '123', '123', '123', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('87', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '123', '123', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('88', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '123', '123', '123', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('89', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '24', '2123', '123', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('90', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '123', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('91', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '22', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('92', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '123', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('93', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('94', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('95', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '');
INSERT INTO `yd_scene_design_scheme` VALUES ('96', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱,井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('97', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱,井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '利旧管道,利旧杆路');
INSERT INTO `yd_scene_design_scheme` VALUES ('98', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, '1111.00', null, '', '箱,井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('99', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('100', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('101', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('102', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('103', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('104', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('105', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('106', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('107', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('108', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱,井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('109', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');
INSERT INTO `yd_scene_design_scheme` VALUES ('110', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '', null, null, null, '', '', null, null, null, '', '箱,井', null, '', '', '', '', '', '', '', '', '', '', null, '南海区----', '', '', '', '南海区----', '', '', '', '挂墙,浅埋');

-- ----------------------------
-- Table structure for yd_system_design_scheme
-- ----------------------------
DROP TABLE IF EXISTS `yd_system_design_scheme`;
CREATE TABLE `yd_system_design_scheme` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '序号',
  `cilent_pipeline_way` varchar(255) DEFAULT NULL COMMENT '客户管线接入方式',
  `cilent_device_way` varchar(255) DEFAULT NULL COMMENT '客户设备接入方式',
  `local_net_device_supplyer` varchar(255) DEFAULT NULL COMMENT '主设备提供方',
  `is_new_physics_address` varchar(255) DEFAULT NULL COMMENT '是否新建物理地址',
  `z_computer_room_longitude` varchar(255) DEFAULT NULL COMMENT '客户端机房经度',
  `z_computer_room_dimension` varchar(255) DEFAULT NULL COMMENT '客户端机房纬度',
  `connect_level` varchar(255) DEFAULT NULL COMMENT '接入等级',
  `is_new_fgq` varchar(255) DEFAULT NULL COMMENT '是否新增分光器',
  `fgq` varchar(255) DEFAULT NULL COMMENT '分光器',
  `a_computer_room_longitude` varchar(255) DEFAULT NULL COMMENT 'A端机房经度',
  `a_computer_room_dimension` varchar(255) DEFAULT NULL COMMENT 'A端机房纬度',
  `sdh_count_m` int(10) DEFAULT NULL COMMENT '155/622m SDH数量',
  `sdh_count_g` int(10) DEFAULT NULL COMMENT '2.5G SDH数量',
  `ptn_count_one` int(10) DEFAULT NULL COMMENT 'GE PTN数量',
  `ptn_count_ten` int(10) DEFAULT NULL COMMENT '10 GE PTN数量',
  `pbx_count` int(10) DEFAULT NULL COMMENT 'pbx数量',
  `pbx_volume` double(10,2) DEFAULT NULL COMMENT 'pbx容量',
  `onu_count` int(10) DEFAULT NULL COMMENT 'ONU数量',
  `fgq_count` int(11) DEFAULT NULL COMMENT '分光器数量',
  `router_count` int(11) DEFAULT NULL COMMENT '路由器数量',
  `switchboard_count` int(11) DEFAULT NULL COMMENT '交换机数量',
  `wiring_count` int(11) DEFAULT NULL COMMENT '综合布线数量',
  `fibre_converter_count` int(11) DEFAULT NULL COMMENT '协议转换器/光纤收发器数量',
  `build_content` varchar(255) DEFAULT NULL COMMENT '建设内容',
  `scheme_verify_code` varchar(255) DEFAULT NULL COMMENT '方案审核编码',
  `business_ensure` varchar(255) DEFAULT NULL COMMENT '业务确认文件',
  `design_scheme` varchar(255) DEFAULT NULL COMMENT '设计方案文件',
  `engineer_budget` varchar(255) DEFAULT NULL COMMENT '工程预算文件',
  `deal_segment` int(11) DEFAULT NULL COMMENT '下环节处理时限',
  `resource_arrive` varchar(255) DEFAULT NULL COMMENT '资源到达情况',
  `resource_standard` varchar(255) DEFAULT NULL COMMENT '资源标准',
  `is_tiaoxian` varchar(255) DEFAULT NULL COMMENT '是否跳纤',
  `z_building_name` varchar(255) DEFAULT NULL COMMENT 'z端楼宇名称',
  `z_building_code` varchar(255) DEFAULT NULL COMMENT 'z端楼宇编码',
  `z_building_addr` varchar(255) DEFAULT NULL COMMENT 'z端楼宇地址',
  `a_building_name` varchar(255) DEFAULT NULL COMMENT 'a端楼宇名称',
  `a_building_code` varchar(255) DEFAULT NULL COMMENT 'a端楼宇编码',
  `a_building_addr` varchar(255) DEFAULT NULL COMMENT 'a端机房地址',
  `cover_addr` varchar(255) DEFAULT NULL COMMENT '预覆盖站点地址',
  `all_file` varchar(255) DEFAULT NULL COMMENT '附件',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of yd_system_design_scheme
-- ----------------------------
INSERT INTO `yd_system_design_scheme` VALUES ('1', '光纤', 'SDH', '移动', '是', 'Z端机房经度', 'Z端机房纬度Z端机房经度', 'Z端机房经度', '是', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', null, null, null, null, null, null, null, null, null, null, null, null, 'Z端机房经度', 'Z端机房经度', 'e8ce1c066eed48d194b97925b4255286', 'bf76da875e6f458f8fec986271c47760', 'da22808429354eccbe932ee9beaffd1d', '4', '光纤', 'PTN', '移动', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', 'Z端机房经度', '3161228836d044bf8ac81ffcad0bdb46,d7c819343b43448d8adc03bd58a3d7a0');
INSERT INTO `yd_system_design_scheme` VALUES ('2', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '312', '123', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '123', '光纤', 'SDH', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('3', '光纤', 'SDH', '', '', '123', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '234', '123', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '11', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('4', '光纤', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '123', '123', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '302969cf36e34d1d99d57ee23217e7d1', '1231', '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('5', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('6', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('7', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('8', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('9', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('10', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('11', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('12', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('13', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('14', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');
INSERT INTO `yd_system_design_scheme` VALUES ('15', '', '', '', '', '', '', '', '', '', '', '', null, null, null, null, null, null, null, null, null, null, null, null, '', '', '', '', '', null, '', '', '', '', '', '', '', '', '', '', '');

-- ----------------------------
-- Table structure for yd_tietong_verify
-- ----------------------------
DROP TABLE IF EXISTS `yd_tietong_verify`;
CREATE TABLE `yd_tietong_verify` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `result` varchar(255) DEFAULT NULL,
  `opinion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yd_tietong_verify
-- ----------------------------
INSERT INTO `yd_tietong_verify` VALUES ('29', '1', null);
INSERT INTO `yd_tietong_verify` VALUES ('30', '11', null);
INSERT INTO `yd_tietong_verify` VALUES ('31', '1231', null);
INSERT INTO `yd_tietong_verify` VALUES ('32', '111', null);
INSERT INTO `yd_tietong_verify` VALUES ('33', '12312123', '123');
INSERT INTO `yd_tietong_verify` VALUES ('34', '123', '');
INSERT INTO `yd_tietong_verify` VALUES ('35', '123', '');
INSERT INTO `yd_tietong_verify` VALUES ('36', '12312', '123');
INSERT INTO `yd_tietong_verify` VALUES ('37', '12312', '123');
INSERT INTO `yd_tietong_verify` VALUES ('38', '211', '');
INSERT INTO `yd_tietong_verify` VALUES ('39', '123', '1111');
INSERT INTO `yd_tietong_verify` VALUES ('40', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('41', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('42', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('43', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('44', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('45', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('46', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('47', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('48', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('49', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('50', '', '');
INSERT INTO `yd_tietong_verify` VALUES ('51', '', '');

-- ----------------------------
-- Function structure for getDatasById
-- ----------------------------
DROP FUNCTION IF EXISTS `getDatasById`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getDatasById`(`busi_id` int) RETURNS varchar(1000) CHARSET utf8
BEGIN
 #Routine body goes here...
 DECLARE ptemp VARCHAR(1000);
  DECLARE ctemp VARCHAR(1000);
 SET ptemp = '#';
  SET ctemp = busi_id; 
 WHILE ctemp IS NOT NULL DO
      SET ptemp = concat(ptemp, ',', ctemp);
      SELECT group_concat(id)
      INTO ctemp
      FROM sys_role
      WHERE FIND_IN_SET(pid, ctemp) > 0;
 END WHILE;
 RETURN ptemp;
END
;;
DELIMITER ;

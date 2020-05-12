/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - crm_ex
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crm_ex` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crm_ex`;

/*Table structure for table `tbl_customer` */

DROP TABLE IF EXISTS `tbl_customer`;

CREATE TABLE `tbl_customer` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `modifydate` datetime DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `name` varchar(50) NOT NULL,
  `region` varchar(50) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  `sa` int(1) DEFAULT NULL,
  `redit` int(1) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `web` varchar(50) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL COMMENT '0:正常 1：流失',
  `source` varchar(32) DEFAULT NULL COMMENT '客户来源',
  `uid` varchar(32) DEFAULT NULL COMMENT '客户经理',
  `ctid` varchar(32) DEFAULT NULL COMMENT '客户类型',
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `ctid` (`ctid`),
  CONSTRAINT `tbl_customer_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_customer_ibfk_2` FOREIGN KEY (`ctid`) REFERENCES `tbl_customer_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_customer` */

insert  into `tbl_customer`(`id`,`createdate`,`modifydate`,`code`,`name`,`region`,`manager`,`sa`,`redit`,`level`,`tel`,`addr`,`web`,`memo`,`status`,`source`,`uid`,`ctid`) values ('cst20190801172808','2019-08-04 09:38:47','2019-08-07 09:38:55',NULL,'江苏教育科教有限公司-1','常州','樊建华',1,NULL,'ct1001','18961297987','江苏.常州','http://www.czteach.com','测试客户信息','1',NULL,NULL,NULL),('cst20190802110140','2019-08-04 09:38:51','2019-08-15 09:38:59',NULL,'江苏教育科教有限公司-2',NULL,'tom',NULL,NULL,'ct1002','110','总经理',NULL,NULL,'0',NULL,NULL,NULL),('cst20190802110141','2019-08-04 09:38:53','2019-08-22 09:39:02',NULL,'江苏教育科教有限公司-3',NULL,NULL,NULL,NULL,'ct1003',NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL),('cst20190802110142','2019-08-03 09:39:05','2019-08-09 09:39:09',NULL,'江苏教育科教有限公司-4',NULL,NULL,NULL,NULL,'ct1001',NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL),('cst20190823095236',NULL,NULL,NULL,'江苏教育科教有限公司-5',NULL,'32332',NULL,NULL,NULL,'33232','323232',NULL,NULL,'0',NULL,NULL,NULL),('cst20190823095241',NULL,NULL,NULL,'江苏教育科教有限公司-6',NULL,'32332',NULL,NULL,NULL,'33232','323232',NULL,NULL,'0',NULL,NULL,NULL),('cst20190823095305',NULL,NULL,NULL,'江苏教育科教有限公司-7',NULL,'32332',NULL,NULL,NULL,'33232','323232',NULL,NULL,'0',NULL,NULL,NULL);

/*Table structure for table `tbl_customer_communication` */

DROP TABLE IF EXISTS `tbl_customer_communication`;

CREATE TABLE `tbl_customer_communication` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `title` varchar(300) DEFAULT NULL COMMENT '主题',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `addr` varchar(32) DEFAULT NULL COMMENT '交流地点',
  `memo` varchar(1024) DEFAULT NULL COMMENT '交流内容',
  `result` varchar(1023) DEFAULT NULL COMMENT '结果',
  `cid` varchar(32) DEFAULT NULL COMMENT '客户ID',
  `cuid` varchar(32) DEFAULT NULL COMMENT '创建人员',
  `ccreatedate` datetime DEFAULT NULL,
  `duid` varchar(32) DEFAULT NULL COMMENT '交流人员',
  `dcreatedate` datetime DEFAULT NULL COMMENT '交流时间',
  PRIMARY KEY (`id`),
  KEY `fk_communication_cid` (`cid`),
  KEY `fk_communication_uid` (`cuid`),
  KEY `duid` (`duid`),
  CONSTRAINT `fk_communication_cid` FOREIGN KEY (`cid`) REFERENCES `tbl_customer` (`id`),
  CONSTRAINT `fk_communication_uid` FOREIGN KEY (`cuid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_customer_communication_ibfk_1` FOREIGN KEY (`duid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_customer_communication` */

insert  into `tbl_customer_communication`(`id`,`createdate`,`updatedate`,`title`,`status`,`addr`,`memo`,`result`,`cid`,`cuid`,`ccreatedate`,`duid`,`dcreatedate`) values ('20190802090930',NULL,NULL,NULL,NULL,'fdsa','fdsafdsafdsafas',NULL,'cst20190801172808','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL),('clc20190802091430',NULL,NULL,NULL,NULL,'江苏常州','发大水嚅艺术团哈士奇工魂牵梦萦',NULL,'cst20190801172808','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL),('clc20190802091803',NULL,NULL,NULL,NULL,'魂牵梦萦','魂牵梦萦',NULL,'cst20190801172808','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL),('clc20190802091929',NULL,NULL,NULL,NULL,'魂牵梦萦','魂牵梦萦城区发大水魂牵梦萦城区',NULL,'cst20190801172808','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL),('clc20190802092006',NULL,NULL,NULL,NULL,'魂牵梦萦fd','a村魂牵梦萦城区魂牵梦萦城区',NULL,'cst20190801172808','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL),('clc20190807105556',NULL,NULL,NULL,NULL,'dsfs','fdsfdsfsdfds',NULL,'cst20190802110141','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL);

/*Table structure for table `tbl_customer_linkman` */

DROP TABLE IF EXISTS `tbl_customer_linkman`;

CREATE TABLE `tbl_customer_linkman` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `gender` varchar(20) NOT NULL,
  `tel1` varchar(20) DEFAULT NULL,
  `tel2` varchar(100) DEFAULT NULL,
  `tel3` varchar(20) NOT NULL,
  `memo` varchar(20) DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fk_linkman` (`name`),
  KEY `cid` (`cid`),
  CONSTRAINT `tbl_customer_linkman_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `tbl_customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_customer_linkman` */

/*Table structure for table `tbl_customer_lost_communication` */

DROP TABLE IF EXISTS `tbl_customer_lost_communication`;

CREATE TABLE `tbl_customer_lost_communication` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `addr` varchar(32) DEFAULT NULL COMMENT '交流地点',
  `memo` varchar(1024) DEFAULT NULL COMMENT '交流内容',
  `cid` varchar(32) DEFAULT NULL COMMENT '客户ID',
  `uid` varchar(32) DEFAULT NULL COMMENT '参与的交流的工作人员',
  KEY `cid` (`cid`),
  KEY `uid` (`uid`),
  CONSTRAINT `tbl_customer_lost_communication_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `tbl_customer` (`id`),
  CONSTRAINT `tbl_customer_lost_communication_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_customer_lost_communication` */

insert  into `tbl_customer_lost_communication`(`id`,`createdate`,`updatedate`,`addr`,`memo`,`cid`,`uid`) values ('lcst20190824095357',NULL,NULL,'中成药','城区魂牵梦萦城区魂牵梦萦','cst20190801172808','0c9f7ee9243111e990d23c970e4745df');

/*Table structure for table `tbl_customer_type` */

DROP TABLE IF EXISTS `tbl_customer_type`;

CREATE TABLE `tbl_customer_type` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `modifydate` datetime DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_customer_type` */

insert  into `tbl_customer_type`(`id`,`createdate`,`modifydate`,`name`,`memo`) values ('ct1001','2019-08-03 10:44:21','2019-08-03 10:44:22','中型客户',NULL),('ct1002','2019-08-03 10:44:24','2019-08-03 10:44:26','大客户',NULL),('ct1003','2019-08-03 10:44:28','2019-08-03 10:44:30','优质客户',NULL),('ct1004','2019-08-03 10:44:38','2019-08-03 10:44:40','战略合作伙伴',NULL),('cy1000','2019-08-03 10:44:17','2019-08-03 10:44:19','小客户',NULL);

/*Table structure for table `tbl_opt_log` */

DROP TABLE IF EXISTS `tbl_opt_log`;

CREATE TABLE `tbl_opt_log` (
  `id` varchar(32) NOT NULL,
  `url` varchar(128) DEFAULT NULL COMMENT '操作资源',
  `ip` varchar(32) DEFAULT NULL COMMENT '操作IP',
  `datas` text COMMENT '请求数据',
  `user` varchar(100) DEFAULT NULL COMMENT '操作者',
  `date` datetime DEFAULT NULL COMMENT '操作日期',
  `ret` varchar(10) DEFAULT NULL COMMENT '操作结果',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_opt_log` */

insert  into `tbl_opt_log`(`id`,`url`,`ip`,`datas`,`user`,`date`,`ret`) values ('opt1571619742035','http://localhost/user/user_main_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:02:22','ok'),('opt1571619742787','http://localhost/user/user_menu','127.0.0.1',NULL,'樊建华','2019-10-21 01:02:23','ok'),('opt1571619742851','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:02:23','ok'),('opt1571619742857','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:02:23','ok'),('opt1571619878019','http://localhost/service/listview','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:38','ok'),('opt1571619878813','http://localhost/service/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:39','ok'),('opt1571619893482','http://localhost/user/user_main_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:53','ok'),('opt1571619894074','http://localhost/user/user_menu','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:54','ok'),('opt1571619894157','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:54','ok'),('opt1571619894168','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:54','ok'),('opt1571619895615','http://localhost/sale/sale_chance_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:56','ok'),('opt1571619895797','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:04:56','ok'),('opt1571619907389','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:07','ok'),('opt1571619908104','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:08','ok'),('opt1571619908594','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:09','ok'),('opt1571619910239','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:10','ok'),('opt1571619910831','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:11','ok'),('opt1571619918490','http://localhost/sale/sale_plan_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:18','ok'),('opt1571619918620','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:19','ok'),('opt1571619932293','http://localhost/role/role_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:32','ok'),('opt1571619932395','http://localhost/role/role_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:32','ok'),('opt1571619933408','http://localhost/resource/resource_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:33','ok'),('opt1571619933492','http://localhost/static/lay-ui/lay/modules/treeSelect.js','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:33','ok'),('opt1571619933503','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:34','ok'),('opt1571619933537','http://localhost/resource/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:34','ok'),('opt1571619935764','http://localhost/role/role_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:36','ok'),('opt1571619935873','http://localhost/role/role_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:36','ok'),('opt1571619936787','http://localhost/resource/resource_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:37','ok'),('opt1571619936926','http://localhost/resource/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:37','ok'),('opt1571619938188','http://localhost/optlog/optlog_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:38','ok'),('opt1571619938287','http://localhost/optlog/optlog_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:05:38','ok'),('opt1571620038706','http://localhost/user/user_main_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:19','ok'),('opt1571620040603','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:21','ok'),('opt1571620040640','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:21','ok'),('opt1571620040738','http://localhost/user/user_menu','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:21','ok'),('opt1571620041215','http://localhost/optlog/optlog_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:21','ok'),('opt1571620041624','http://localhost/optlog/optlog_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:22','ok'),('opt1571620055738','http://localhost/optlog/optlog_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:07:36','ok'),('opt1571620085036','http://localhost/user/user_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:05','ok'),('opt1571620085253','http://localhost/user/user_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:05','ok'),('opt1571620086450','http://localhost/role/role_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:06','ok'),('opt1571620086602','http://localhost/role/role_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:07','ok'),('opt1571620088593','http://localhost/resource/resource_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:09','ok'),('opt1571620088821','http://localhost/static/lay-ui/lay/modules/treeSelect.js','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:09','ok'),('opt1571620088846','http://localhost/404.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:09','ok'),('opt1571620088938','http://localhost/resource/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:09','ok'),('opt1571620090704','http://localhost/user/user_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:11','ok'),('opt1571620090871','http://localhost/user/user_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:11','ok'),('opt1571620093140','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:13','ok'),('opt1571620098596','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:19','ok'),('opt1571620098613','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:19','ok'),('opt1571620102622','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:23','ok'),('opt1571620102623','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:23','ok'),('opt1571620102643','http://localhost/role/role_list','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:23','ok'),('opt1571620107941','http://localhost/sale/sale_chance_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:28','ok'),('opt1571620108608','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:29','ok'),('opt1571620111658','http://localhost/sale/sale_chance_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:32','ok'),('opt1571620114175','http://localhost/role/role_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:34','ok'),('opt1571620114369','http://localhost/role/role_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:34','ok'),('opt1571620115418','http://localhost/resource/resource_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:35','ok'),('opt1571620115628','http://localhost/resource/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:36','ok'),('opt1571620117198','http://localhost/optlog/optlog_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:37','ok'),('opt1571620117376','http://localhost/optlog/optlog_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:08:37','ok'),('opt1571620146578','http://localhost/resource/resource_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:07','ok'),('opt1571620146715','http://localhost/resource/pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:07','ok'),('opt1571620148391','http://localhost/role/role_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:08','ok'),('opt1571620148522','http://localhost/role/role_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:09','ok'),('opt1571620154607','http://localhost/product/product_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:15','ok'),('opt1571620154839','http://localhost/500.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:15','ok'),('opt1571620155741','http://localhost/order/order_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:16','ok'),('opt1571620155870','http://localhost/500.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:16','ok'),('opt1571620158827','http://localhost/report/customer_compose_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:19','ok'),('opt1571620158901','http://localhost/report/cutomer_compose_pager','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:19','ok'),('opt1571620160584','http://localhost/500.html','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:21','ok'),('opt1571620163592','http://localhost/report/customer_service_view','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:24','ok'),('opt1571620163721','http://localhost/report/service_satisfaction_report','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:24','ok'),('opt1571620163733','http://localhost/report/service_compose_report','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:24','ok'),('opt1571620163737','http://localhost/report/service_completion_degree_report','127.0.0.1',NULL,'樊建华','2019-10-21 01:09:24','ok'),('opt1572070578745','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:19','ok'),('opt1572070580167','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:20','ok'),('opt1572070587133','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:27','ok'),('opt1572070588324','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-26 06:16:28','ok'),('opt1572070588753','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:29','ok'),('opt1572070588851','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:29','ok'),('opt1572070589069','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:29','ok'),('opt1572070589346','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:29','ok'),('opt1572070589351','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:29','ok'),('opt1572070589754','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:30','ok'),('opt1572070589781','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:30','ok'),('opt1572070591249','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:31','ok'),('opt1572070591283','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:31','ok'),('opt1572070591349','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:31','ok'),('opt1572070597979','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-26 06:16:38','ok'),('opt1572147374415','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:14','ok'),('opt1572147377408','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:17','ok'),('opt1572147380264','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:20','ok'),('opt1572147393092','http://localhost/sale/sale_plan_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:33','ok'),('opt1572147396506','http://localhost/customer/customer_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:36','ok'),('opt1572147398425','http://localhost/customer/customer_lost_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:36:38','ok'),('opt1572147494106','http://localhost/customer/customer_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:14','ok'),('opt1572147511895','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:32','ok'),('opt1572147512850','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:38:33','ok'),('opt1572147512884','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:38:33','ok'),('opt1572147512898','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:38:33','ok'),('opt1572147512928','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:38:33','ok'),('opt1572147512954','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:38:33','ok'),('opt1572147515870','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:36','ok'),('opt1572147515913','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:36','ok'),('opt1572147515966','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:36','ok'),('opt1572147516489','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:36','ok'),('opt1572147516535','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:37','ok'),('opt1572147516995','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:37','ok'),('opt1572147517008','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:37','ok'),('opt1572147518576','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:39','ok'),('opt1572147518593','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:39','ok'),('opt1572147518795','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:39','ok'),('opt1572147522037','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:38:42','ok'),('opt1572147852749','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:13','ok'),('opt1572147854061','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:14','ok'),('opt1572147858115','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:18','ok'),('opt1572147861072','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:21','ok'),('opt1572147861275','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:21','ok'),('opt1572147861520','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:22','ok'),('opt1572147862255','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:22','ok'),('opt1572147862278','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:22','ok'),('opt1572147879259','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:44:39','ok'),('opt1572147946068','http://localhost/report/customer_compose_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:45:46','ok'),('opt1572147972896','http://localhost/role/list','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:46:13','ok'),('opt1572148339076','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:19','ok'),('opt1572148339603','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:20','ok'),('opt1572148339604','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:20','ok'),('opt1572148339623','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:20','ok'),('opt1572148339829','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:20','ok'),('opt1572148339972','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:20','ok'),('opt1572148342443','http://localhost/404.html','0:0:0:0:0:0:0:1','v=5.0.9','樊建华','2019-10-27 03:52:22','ok'),('opt1572148342483','http://localhost/404.html','0:0:0:0:0:0:0:1','v=3.1.1','樊建华','2019-10-27 03:52:22','ok'),('opt1572148342547','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:23','ok'),('opt1572148343458','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:23','ok'),('opt1572148344189','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:24','ok'),('opt1572148344452','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:52:24','ok'),('opt1572148344631','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:25','ok'),('opt1572148344671','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:25','ok'),('opt1572148344691','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:25','ok'),('opt1572148344737','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:25','ok'),('opt1572148344937','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:25','ok'),('opt1572148345717','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:52:26','ok'),('opt1572148560091','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:00','ok'),('opt1572148560593','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:56:01','ok'),('opt1572148563000','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 03:56:03','ok'),('opt1572148563372','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:03','ok'),('opt1572148563410','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:03','ok'),('opt1572148564313','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:04','ok'),('opt1572148564692','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:05','ok'),('opt1572148565319','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:05','ok'),('opt1572148565399','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:05','ok'),('opt1572148565837','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:06','ok'),('opt1572148565932','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:06','ok'),('opt1572148570463','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 03:56:10','ok'),('opt1572148881428','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:21','ok'),('opt1572148885305','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:25','ok'),('opt1572148885410','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:01:25','ok'),('opt1572148886186','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:01:26','ok'),('opt1572148886836','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:27','ok'),('opt1572148886894','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:27','ok'),('opt1572148886943','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:27','ok'),('opt1572148888081','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:28','ok'),('opt1572148888115','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:28','ok'),('opt1572148892278','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:01:32','ok'),('opt1572149004681','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:25','ok'),('opt1572149005643','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:26','ok'),('opt1572149007858','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:28','ok'),('opt1572149007956','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:03:28','ok'),('opt1572149007966','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:03:28','ok'),('opt1572149008035','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:03:28','ok'),('opt1572149008153','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:03:28','ok'),('opt1572149008823','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:03:29','ok'),('opt1572149008862','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:29','ok'),('opt1572149008936','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:29','ok'),('opt1572149008965','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:29','ok'),('opt1572149009315','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:29','ok'),('opt1572149009327','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:03:29','ok'),('opt1572149241131','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:21','ok'),('opt1572149242324','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:22','ok'),('opt1572149244211','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:24','ok'),('opt1572149244287','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:24','ok'),('opt1572149244290','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:24','ok'),('opt1572149244325','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:24','ok'),('opt1572149244332','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:24','ok'),('opt1572149244339','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:24','ok'),('opt1572149246244','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:26','ok'),('opt1572149246283','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 04:07:26','ok'),('opt1572149246627','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:27','ok'),('opt1572149246726','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:27','ok'),('opt1572149249273','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:29','ok'),('opt1572149249293','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 04:07:29','ok'),('opt1572154254549','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:55','ok'),('opt1572154255326','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:55','ok'),('opt1572154258046','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:58','ok'),('opt1572154258178','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 05:30:58','ok'),('opt1572154258235','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 05:30:58','ok'),('opt1572154258257','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 05:30:58','ok'),('opt1572154258265','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 05:30:58','ok'),('opt1572154258323','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 05:30:58','ok'),('opt1572154259360','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:59','ok'),('opt1572154259396','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:59','ok'),('opt1572154259452','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:30:59','ok'),('opt1572154259840','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:31:00','ok'),('opt1572154259880','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:31:00','ok'),('opt1572154377786','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:32:58','ok'),('opt1572154380140','http://localhost/sale/sale_plan_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:33:00','ok'),('opt1572154382071','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:33:02','ok'),('opt1572154389207','http://localhost/sale/sale_plan_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:33:09','ok'),('opt1572154526289','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:26','ok'),('opt1572154527076','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:27','ok'),('opt1572154529032','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:29','ok'),('opt1572154535199','http://localhost/sale/sale_plan_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:35','ok'),('opt1572154536958','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:37','ok'),('opt1572154549002','http://localhost/sale/sale_plan_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:35:49','ok'),('opt1572155276304','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:47:56','ok'),('opt1572155278152','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:47:58','ok'),('opt1572155281648','http://localhost/sale/sale_chance_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:48:02','ok'),('opt1572155295088','http://localhost/sale/sale_chance_pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 05:48:15','ok'),('opt1572178004627','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:45','ok'),('opt1572178006179','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:46','ok'),('opt1572178015496','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:55','ok'),('opt1572178015546','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 12:06:56','ok'),('opt1572178015580','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 12:06:56','ok'),('opt1572178015589','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 12:06:56','ok'),('opt1572178015590','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 12:06:56','ok'),('opt1572178016252','http://localhost/webjars/springfox-swagger-ui/favicon-16x16.png','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 12:06:56','ok'),('opt1572178016277','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:56','ok'),('opt1572178016350','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:56','ok'),('opt1572178016392','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:56','ok'),('opt1572178016675','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:57','ok'),('opt1572178016682','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:57','ok'),('opt1572178016727','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:57','ok'),('opt1572178016807','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:57','ok'),('opt1572178017768','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-300.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:58','ok'),('opt1572178017783','http://localhost/webjars/springfox-swagger-ui/fonts/open-sans-v15-latin-700.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:58','ok'),('opt1572178017795','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:06:58','ok'),('opt1572178019522','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:07:00','ok'),('opt1572178025968','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:07:06','ok'),('opt1572178052553','http://localhost/order/order_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:07:33','ok'),('opt1572179117201','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:17','ok'),('opt1572179118802','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:19','ok'),('opt1572179121127','http://localhost/report/customer_compose_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:21','ok'),('opt1572179121290','http://localhost/report/cutomer_compose_pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:21','ok'),('opt1572179123459','http://localhost/500.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:23','ok'),('opt1572179126643','http://localhost/customer/customer_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:27','ok'),('opt1572179127486','http://localhost/customer/customer_pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:27','ok'),('opt1572179131504','http://localhost/customerlinkman/linkman_pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 12:25:32','ok'),('opt1572182211430','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:51','ok'),('opt1572182212300','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:52','ok'),('opt1572182214358','http://localhost/customer/customer_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:54','ok'),('opt1572182214792','http://localhost/customer/customer_pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:55','ok'),('opt1572182215740','http://localhost/customer/customer_lost_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:56','ok'),('opt1572182218389','http://localhost/service/listview','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:58','ok'),('opt1572182218754','http://localhost/service/pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:16:59','ok'),('opt1572182219891','http://localhost/service/distributionview','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:00','ok'),('opt1572182220124','http://localhost/service/pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:00','ok'),('opt1572182221136','http://localhost/service/detailview','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:01','ok'),('opt1572182221443','http://localhost/service/pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:01','ok'),('opt1572182222659','http://localhost/service/feedbackview','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:03','ok'),('opt1572182222903','http://localhost/service/pager','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:03','ok'),('opt1572182224312','http://localhost/service/fileview','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:04','ok'),('opt1572182224443','http://localhost/service/listpager.do','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:04','ok'),('opt1572182224460','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:04','ok'),('opt1572182230059','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:10','ok'),('opt1572182230109','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 13:17:10','ok'),('opt1572182230134','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 13:17:10','ok'),('opt1572182230142','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 13:17:10','ok'),('opt1572182230147','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 13:17:10','ok'),('opt1572182230154','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-27 13:17:10','ok'),('opt1572182230449','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:10','ok'),('opt1572182230476','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:10','ok'),('opt1572182230493','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:10','ok'),('opt1572182230661','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:11','ok'),('opt1572182230671','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-27 13:17:11','ok'),('opt1572225329033','http://localhost/user/user_main_view','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:29','ok'),('opt1572225330195','http://localhost/user/user_menu','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:30','ok'),('opt1572225332088','http://localhost/swagger-ui.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:32','ok'),('opt1572225332128','http://localhost/webjars/springfox-swagger-ui/swagger-ui.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-28 01:15:32','ok'),('opt1572225332133','http://localhost/webjars/springfox-swagger-ui/swagger-ui-standalone-preset.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-28 01:15:32','ok'),('opt1572225332134','http://localhost/webjars/springfox-swagger-ui/swagger-ui-bundle.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-28 01:15:32','ok'),('opt1572225332147','http://localhost/webjars/springfox-swagger-ui/springfox.js','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-28 01:15:32','ok'),('opt1572225332163','http://localhost/webjars/springfox-swagger-ui/springfox.css','0:0:0:0:0:0:0:1','v=2.9.2','樊建华','2019-10-28 01:15:32','ok'),('opt1572225332543','http://localhost/swagger-resources/configuration/ui','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:33','ok'),('opt1572225332571','http://localhost/swagger-resources/configuration/security','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:33','ok'),('opt1572225332596','http://localhost/swagger-resources','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:33','ok'),('opt1572225332747','http://localhost/csrf','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:33','ok'),('opt1572225332768','http://localhost/404.html','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:33','ok'),('opt1572225334559','http://localhost/webjars/springfox-swagger-ui/fonts/source-code-pro-v7-latin-600.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:35','ok'),('opt1572225334990','http://localhost/webjars/springfox-swagger-ui/fonts/titillium-web-v6-latin-regular.woff2','0:0:0:0:0:0:0:1',NULL,'樊建华','2019-10-28 01:15:35','ok');

/*Table structure for table `tbl_resource` */

DROP TABLE IF EXISTS `tbl_resource`;

CREATE TABLE `tbl_resource` (
  `id` varchar(32) NOT NULL COMMENT 'ID',
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `name` varchar(50) NOT NULL COMMENT '资源名称',
  `url` varchar(100) NOT NULL COMMENT '资源路径',
  `pid` varchar(32) DEFAULT NULL COMMENT '资源的父ID',
  `gnum` int(4) DEFAULT NULL COMMENT '组内序号',
  `valid` int(1) DEFAULT '1' COMMENT '是否可用',
  `type` int(1) DEFAULT '0' COMMENT '1：视图 0：功能点',
  `level` int(2) DEFAULT '0' COMMENT '层次，1为顶层',
  `icon` varchar(100) DEFAULT NULL COMMENT '菜单ICON',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `FK_PID` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_resource` */

insert  into `tbl_resource`(`id`,`createdate`,`updatedate`,`name`,`url`,`pid`,`gnum`,`valid`,`type`,`level`,`icon`,`memo`) values ('09b070ee1a0111e99cd73c970e4745df',NULL,NULL,'角色管理-分页','/role/role_pager','6ac75256180a11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('0f13cd101f7911e9bfa23c970e4745df',NULL,NULL,'用户管理-删除','/user/user_delete','6ac74fab180a11e99cd73c970e4745df',5,1,0,0,NULL,NULL),('0f14b1321ec511e99cd73c970e4745df',NULL,NULL,'用户管理-个人中心','/user/user_center_view','6ac74fab180a11e99cd73c970e4745df',3,1,0,0,NULL,NULL),('129008b617fb11e99cd73c970e4745df',NULL,NULL,'营销管理','','6ac75256180a11e99cd73c970e47457',1,1,1,1,'fa fa-street-view',NULL),('12900b2517fb11e99cd73c970e4745df',NULL,NULL,'销售机会管理','/sale/sale_chance_view','129008b617fb11e99cd73c970e4745df',1,1,1,0,NULL,NULL),('12900bef17fb11e99cd73c970e4745df',NULL,NULL,'销售计划管理','/sale/sale_plan_view','129008b617fb11e99cd73c970e4745df',2,1,1,0,NULL,NULL),('13a6e95f17fc11e99cd73c970e4745df',NULL,NULL,'销售机会-分页','/sale/sale_chance_pager','12900b2517fb11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('13a6ec3517fc11e99cd73c970e4745df',NULL,NULL,'销售机会-新建','/sale/sale_plan_save','12900b2517fb11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('13a6ece717fc11e99cd73c970e4745df',NULL,NULL,'销售机会-编辑','/sale/sale_plan_update','12900b2517fb11e99cd73c970e4745df',3,1,0,0,NULL,NULL),('13a6ed9017fc11e99cd73c970e4745df',NULL,NULL,'销售机会-删除','/sale/sale_chance_delete','12900b2517fb11e99cd73c970e4745df',4,1,0,0,NULL,NULL),('189c89ed193711e99cd73c970e4745df',NULL,NULL,'分配服务','/service/distributionview','f730d959180911e99cd73c970e4745df',2,1,1,0,NULL,NULL),('20190804164404',NULL,NULL,'服务分析','/report/customer_service_view','f730f02f180911e99cd73c970e4745df',2,1,1,0,NULL,NULL),('21421421421421421421',NULL,NULL,'日志信息','/optlog/optlog_view','f730f192180911e99cd73c970e4745df',4,1,1,0,NULL,NULL),('267931a51f7911e9bfa23c970e4745df',NULL,NULL,'用户管理-新增','/user/user_add','6ac74fab180a11e99cd73c970e4745df',7,1,0,0,NULL,NULL),('282795c8193711e99cd73c970e4745df',NULL,NULL,'处理服务','/service/detailview','f730d959180911e99cd73c970e4745df',3,1,1,0,NULL,NULL),('341b965e193711e99cd73c970e4745df',NULL,NULL,'服务回访','/service/feedbackview','f730d959180911e99cd73c970e4745df',4,1,1,0,NULL,NULL),('34956af51f7811e9bfa23c970e4745df',NULL,NULL,'角色管理-角色列表','/role/role_list','6ac75256180a11e99cd73c970e4745df',6,1,0,0,NULL,NULL),('39fef6671ec311e99cd73c970e4745df',NULL,NULL,'资源管理-编辑','/resouce/update','A730f192180911e99cd73c970e4745df',2,1,0,0,NULL,NULL),('3a7e00e91eef11e99cd73c970e4745df',NULL,NULL,'客户管理-取得客户详情','/customer/customer_detail','5ef6d21d17fb11e99cd73c970e4745df',6,1,0,0,NULL,NULL),('4352643576453276459870',NULL,NULL,'系统管理-日志管理-分页列表','/optlog/optlog_page','21421421421421421421',NULL,1,0,0,NULL,NULL),('439d100c193711e99cd73c970e4745df',NULL,NULL,'归档服务','/service/fileview','f730d959180911e99cd73c970e4745df',5,1,1,0,NULL,NULL),('48f159f71ec311e99cd73c970e4745df',NULL,NULL,'资源管理-删除','/resource/delete','A730f192180911e99cd73c970e4745df',3,1,0,0,NULL,NULL),('4c5eba261ec411e99cd73c970e4745df',NULL,NULL,'销售机会-取得','/sale/sale_chance_get','129008b617fb11e99cd73c970e4745df',4,1,0,0,NULL,NULL),('5b2627ed198d11e99cd73c970e4745df',NULL,NULL,'销售计划-详细','/sale/sale_plan_detail_view','12900bef17fb11e99cd73c970e4745df',5,1,0,0,NULL,NULL),('5ef6cf6a17fb11e99cd73c970e4745df',NULL,NULL,'客户管理','','6ac75256180a11e99cd73c970e47457',2,1,1,1,'fa fa-address-card',NULL),('5ef6d21d17fb11e99cd73c970e4745df',NULL,NULL,'客户信息','/customer/customer_view','5ef6cf6a17fb11e99cd73c970e4745df',1,1,1,0,NULL,NULL),('5ef6d2de17fb11e99cd73c970e4745df',NULL,NULL,'流失信息','/customer/customer_lost_view','5ef6cf6a17fb11e99cd73c970e4745df',2,1,1,0,NULL,NULL),('645cdf9f1ec311e99cd73c970e4745df',NULL,NULL,'角色管理-新增','/role/role_add','6ac75256180a11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('649354ec1edd11e99cd73c970e4745df',NULL,NULL,'销售计划-分页','/sale/sale_plan_pager','12900bef17fb11e99cd73c970e4745df',4,1,0,0,NULL,NULL),('67e2ad1a46f811e9bbac3c970e4745df',NULL,NULL,'基础数据-产品信息-视图','/product/product_view','990bec39180a11e99cd73c970e4745df',1,1,1,0,NULL,NULL),('6a5f84391ec411e99cd73c970e4745df',NULL,NULL,'销售计划-详细','/sale/sale_plan_detail','12900bef17fb11e99cd73c970e4745df',4,1,0,0,NULL,NULL),('6ac74fab180a11e99cd73c970e4745df',NULL,NULL,'用户管理','/user/user_view','f730f192180911e99cd73c970e4745df',1,1,1,0,'fa fa-user-circle-o',NULL),('6ac75256180a11e99cd73c970e47457',NULL,NULL,'全部资源','','fanjianhua',NULL,1,1,0,NULL,NULL),('6ac75256180a11e99cd73c970e4745df',NULL,NULL,'角色管理','/role/role_view','f730f192180911e99cd73c970e4745df',2,1,1,0,NULL,NULL),('7460759d1ec311e99cd73c970e4745df',NULL,NULL,'角色管理-编辑','/role/role_update','6ac75256180a11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('7f1ac67f46f811e9bbac3c970e4745df',NULL,NULL,'基础数据-产品信息-分页','/product/pager','990bec39180a11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('836392c21ec311e99cd73c970e4745df',NULL,NULL,'角色管理-删除','/role/role_delete','6ac75256180a11e99cd73c970e4745df',3,1,0,0,NULL,NULL),('88fb14371ec411e99cd73c970e4745df',NULL,NULL,'销售机会-终止开发','/sale/sale_chance_close','129008b617fb11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('9819468e448e11e9af4e3c970e4745df',NULL,NULL,'客户分析','/report/customer_compose_view','f730f02f180911e99cd73c970e4745df',1,1,1,0,NULL,NULL),('990bec39180a11e99cd73c970e4745df',NULL,NULL,'产品信息','/product/product_view','f730f110180911e99cd73c970e4745df',1,1,1,0,NULL,NULL),('990beed4180a11e99cd73c970e4745df',NULL,NULL,'订单信息','/order/order_view','f730f110180911e99cd73c970e4745df',1,1,1,0,NULL,NULL),('9f2d3f961eef11e99cd73c970e4745df',NULL,NULL,'客户管理-联系人-分页','/customerlinkman/linkman_pager','5ef6d21d17fb11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('A730f192180911e99cd73c970e4745df',NULL,NULL,'资源管理','/resource/resource_view','f730f192180911e99cd73c970e4745df',3,1,1,0,NULL,NULL),('b1830499448e11e9af4e3c970e4745df',NULL,NULL,'客户贡献分析','/report/customer_contribution_view','f730f02f180911e99cd73c970e4745df',1,1,1,0,NULL,NULL),('b1db4a311ec411e99cd73c970e4745df',NULL,NULL,'销售计划-执行','/sale/sale_chance_end','12900bef17fb11e99cd73c970e4745df',5,1,0,0,NULL,NULL),('ba38c14d1eef11e99cd73c970e4745df',NULL,NULL,'客户信息-联系人-新增','/customerlinkman/linkman_add','5ef6d21d17fb11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('d66289a119fe11e99cd73c970e4745df',NULL,NULL,'用户管理-分页','/user/user_pager','6ac74fab180a11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('dd25a4091f7811e9bfa23c970e4745df',NULL,NULL,'用户管理-更新','/user/user_update','6ac74fab180a11e99cd73c970e4745df',3,1,0,0,NULL,NULL),('DESbef17fb11e99cd73c970e4745df',NULL,NULL,'资源管理-新增','/resource/add','A730f192180911e99cd73c970e4745df',1,1,0,0,NULL,NULL),('e7e1a6341eec11e99cd73c970e4745df',NULL,NULL,'客户管理-客户详情','/customer/customer_detail_view','5ef6d21d17fb11e99cd73c970e4745df',6,1,1,0,NULL,NULL),('e97cc42117fb11e99cd73c970e4745df',NULL,NULL,'客户管理-分页','/customer/customer_pager','5ef6d21d17fb11e99cd73c970e4745df',1,1,0,0,NULL,NULL),('e97cd3b817fb11e99cd73c970e4745df',NULL,NULL,'客户管理-新建','/customer/customer_add','5ef6d21d17fb11e99cd73c970e4745df',2,1,0,0,NULL,NULL),('e97cd4c017fb11e99cd73c970e4745df',NULL,NULL,'客户管理-编辑','/customer/customer_update','5ef6d21d17fb11e99cd73c970e4745df',3,1,0,0,NULL,NULL),('e97cd55a17fb11e99cd73c970e4745df',NULL,NULL,'客户管理-删除','/customer/customer_delete','5ef6d21d17fb11e99cd73c970e4745df',4,1,0,0,NULL,NULL),('edddd24c1f7f11e9bfa23c970e4745df',NULL,NULL,'用户管理-主页','/user/user_main_view','6ac74fab180a11e99cd73c970e4745df',7,1,0,0,NULL,NULL),('eebf6034193611e99cd73c970e4745df',NULL,NULL,'服务信息','/service/listview','f730d959180911e99cd73c970e4745df',1,1,1,0,NULL,NULL),('f5afcc841ec711e99cd73c970e4745df',NULL,NULL,'角色管理-权限分配','/role/role_resoure_update','6ac75256180a11e99cd73c970e4745df',5,1,0,0,NULL,NULL),('f730d959180911e99cd73c970e4745df',NULL,NULL,'服务管理','','6ac75256180a11e99cd73c970e47457',3,1,1,1,'fa fa-volume-control-phone',NULL),('f730f02f180911e99cd73c970e4745df',NULL,NULL,'统计报表','','6ac75256180a11e99cd73c970e47457',4,1,1,1,'fa fa-area-chart',NULL),('f730f110180911e99cd73c970e4745df',NULL,NULL,'基础数据','','6ac75256180a11e99cd73c970e47457',5,1,1,1,'fa fa-folder-o',NULL),('f730f192180911e99cd73c970e4745df',NULL,NULL,'系统管理','','6ac75256180a11e99cd73c970e47457',6,1,1,1,'fa fa-university',NULL);

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `tag` varchar(100) DEFAULT NULL,
  `memo` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role` */

insert  into `tbl_role`(`id`,`createdate`,`updatedate`,`name`,`tag`,`memo`) values ('1868e69b260411e990d23c970e4745df',NULL,'2019-09-02 12:43:05','测试角色','ROLE_TESTER','大规模'),('1e9ed0db211411e9bfa23c970e4745df',NULL,'2019-09-02 12:43:14','管理系统员','ROLE_SYSTEM','管理系统中的用户.角色与权限的分配，保证系统正常运行。'),('2ed1be91211411e9bfa23c970e4745df',NULL,'2019-09-02 12:43:21','销售总监','ROLE_SALE_MANAGER','创建销售机会;对销售机会指派给指定客户经理,维护客户信息,创建服务'),('3e15c4df211411e9bfa23c970e4745df',NULL,'2019-09-02 12:43:16','客户经理','ROLE_CUSTOMER_MANAGER','维护客户信息,接受客户服务要求,处理指派给自身的服务,创建销售机会,处理客户流失'),('46d03442211411e9bfa23c970e4745df',NULL,'2019-09-02 12:43:19','高管','ROLE_MANAGER','查看客户组成、客户贡献、客户服务与客户流失');

/*Table structure for table `tbl_role_resource` */

DROP TABLE IF EXISTS `tbl_role_resource`;

CREATE TABLE `tbl_role_resource` (
  `rid` varchar(32) NOT NULL,
  `aid` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  PRIMARY KEY (`rid`,`aid`),
  KEY `FK_Reference_10` (`aid`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`rid`) REFERENCES `tbl_role` (`id`),
  CONSTRAINT `fk_aid` FOREIGN KEY (`aid`) REFERENCES `tbl_resource` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_role_resource` */

insert  into `tbl_role_resource`(`rid`,`aid`,`createdate`,`updatedate`) values ('1868e69b260411e990d23c970e4745df','09b070ee1a0111e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','0f13cd101f7911e9bfa23c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','0f14b1321ec511e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','21421421421421421421',NULL,NULL),('1868e69b260411e990d23c970e4745df','267931a51f7911e9bfa23c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','34956af51f7811e9bfa23c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','39fef6671ec311e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','3a7e00e91eef11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','4352643576453276459870',NULL,NULL),('1868e69b260411e990d23c970e4745df','48f159f71ec311e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','5ef6cf6a17fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','5ef6d21d17fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','5ef6d2de17fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','645cdf9f1ec311e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','6ac74fab180a11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','6ac75256180a11e99cd73c970e47457',NULL,NULL),('1868e69b260411e990d23c970e4745df','6ac75256180a11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','7460759d1ec311e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','836392c21ec311e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','990bec39180a11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','990beed4180a11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','9f2d3f961eef11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','A730f192180911e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','ba38c14d1eef11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','d66289a119fe11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','dd25a4091f7811e9bfa23c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','DESbef17fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','e7e1a6341eec11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','e97cc42117fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','e97cd3b817fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','e97cd4c017fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','e97cd55a17fb11e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','edddd24c1f7f11e9bfa23c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','f5afcc841ec711e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','f730f110180911e99cd73c970e4745df',NULL,NULL),('1868e69b260411e990d23c970e4745df','f730f192180911e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','09b070ee1a0111e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','0f13cd101f7911e9bfa23c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','0f14b1321ec511e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','129008b617fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','12900b2517fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','12900bef17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','13a6e95f17fc11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','13a6ec3517fc11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','13a6ece717fc11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','13a6ed9017fc11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','189c89ed193711e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','20190804164404',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','21421421421421421421',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','267931a51f7911e9bfa23c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','282795c8193711e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','341b965e193711e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','34956af51f7811e9bfa23c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','39fef6671ec311e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','3a7e00e91eef11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','4352643576453276459870',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','439d100c193711e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','48f159f71ec311e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','4c5eba261ec411e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','5b2627ed198d11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','5ef6cf6a17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','5ef6d21d17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','5ef6d2de17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','645cdf9f1ec311e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','649354ec1edd11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','67e2ad1a46f811e9bbac3c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','6a5f84391ec411e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','6ac74fab180a11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','6ac75256180a11e99cd73c970e47457',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','6ac75256180a11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','7460759d1ec311e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','7f1ac67f46f811e9bbac3c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','836392c21ec311e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','88fb14371ec411e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','9819468e448e11e9af4e3c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','990bec39180a11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','990beed4180a11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','9f2d3f961eef11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','A730f192180911e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','b1830499448e11e9af4e3c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','b1db4a311ec411e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','ba38c14d1eef11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','d66289a119fe11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','dd25a4091f7811e9bfa23c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','DESbef17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','e7e1a6341eec11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','e97cc42117fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','e97cd3b817fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','e97cd4c017fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','e97cd55a17fb11e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','edddd24c1f7f11e9bfa23c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','eebf6034193611e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','f5afcc841ec711e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','f730d959180911e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','f730f02f180911e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','f730f110180911e99cd73c970e4745df',NULL,NULL),('1e9ed0db211411e9bfa23c970e4745df','f730f192180911e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','129008b617fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','12900b2517fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','12900bef17fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','13a6e95f17fc11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','13a6ec3517fc11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','13a6ece717fc11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','13a6ed9017fc11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','189c89ed193711e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','282795c8193711e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','341b965e193711e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','3a7e00e91eef11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','439d100c193711e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','4c5eba261ec411e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','5b2627ed198d11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','5ef6cf6a17fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','5ef6d21d17fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','5ef6d2de17fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','649354ec1edd11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','6a5f84391ec411e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','6ac75256180a11e99cd73c970e47457',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','88fb14371ec411e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','9819468e448e11e9af4e3c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','9f2d3f961eef11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','b1830499448e11e9af4e3c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','b1db4a311ec411e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','ba38c14d1eef11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','e7e1a6341eec11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','e97cc42117fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','e97cd3b817fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','e97cd4c017fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','e97cd55a17fb11e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','eebf6034193611e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','f730d959180911e99cd73c970e4745df',NULL,NULL),('2ed1be91211411e9bfa23c970e4745df','f730f02f180911e99cd73c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','6ac75256180a11e99cd73c970e47457',NULL,NULL),('46d03442211411e9bfa23c970e4745df','9819468e448e11e9af4e3c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','990bec39180a11e99cd73c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','990beed4180a11e99cd73c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','b1830499448e11e9af4e3c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','f730f02f180911e99cd73c970e4745df',NULL,NULL),('46d03442211411e9bfa23c970e4745df','f730f110180911e99cd73c970e4745df',NULL,NULL);

/*Table structure for table `tbl_sale_chance` */

DROP TABLE IF EXISTS `tbl_sale_chance`;

CREATE TABLE `tbl_sale_chance` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL COMMENT '机会来源',
  `cname` varchar(100) DEFAULT NULL COMMENT '客户名称',
  `lname` varchar(20) DEFAULT NULL COMMENT '联系人',
  `ltel1` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `ltel2` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `caddr` varchar(20) DEFAULT NULL COMMENT '客户联系地址',
  `summay` varchar(100) DEFAULT NULL COMMENT '摘要',
  `detail` varchar(500) DEFAULT NULL COMMENT '需求详情',
  `cuid` varchar(32) DEFAULT NULL COMMENT '机会创建者',
  `auid` varchar(32) DEFAULT NULL COMMENT '指派者',
  `duid` varchar(32) DEFAULT NULL COMMENT '被指派的客户经理',
  `status` varchar(20) NOT NULL DEFAULT '0' COMMENT '0:待指派1：已指派 2：关闭3：开发成功',
  PRIMARY KEY (`id`),
  KEY `OPT_CST_NO` (`cname`),
  KEY `fk_user` (`cuid`),
  KEY `auid` (`auid`),
  KEY `duid` (`duid`),
  CONSTRAINT `fk_user` FOREIGN KEY (`cuid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_sale_chance_ibfk_1` FOREIGN KEY (`auid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_sale_chance_ibfk_2` FOREIGN KEY (`duid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_sale_chance` */

insert  into `tbl_sale_chance`(`id`,`createdate`,`updatedate`,`source`,`cname`,`lname`,`ltel1`,`ltel2`,`caddr`,`summay`,`detail`,`cuid`,`auid`,`duid`,`status`) values ('17ed74c8149e49eab7ccb3edf27ac5db','2019-09-02 10:16:57',NULL,'ss','江苏教育科教有限公司-1','2121',NULL,NULL,NULL,'21212','2121',NULL,NULL,NULL,'0'),('3c21aeb648c84abdbd4e1fbe9cd5b562','2019-09-02 10:19:43',NULL,'ss','江苏教育科教有限公司-1','2121',NULL,NULL,NULL,'21212','2121',NULL,NULL,NULL,'0'),('7d56c141ac474b7981b39357b24ce924','2019-09-02 11:51:07','2019-09-02 11:51:07','33','dfsfvsfsa','321321',NULL,NULL,NULL,'321321','23432',NULL,NULL,NULL,'0'),('86e7a5816dc94799bd23a019da985a6f','2019-09-02 10:18:01',NULL,'ss','江苏教育科教有限公司-1','2121',NULL,NULL,NULL,'21212','2121',NULL,NULL,NULL,'0'),('c0898b8a0ba64414afb3104573404dd1','2019-09-02 11:40:53','2019-09-02 11:40:53','3','323232','3232',NULL,NULL,NULL,'3232','33323232',NULL,NULL,NULL,'0'),('d6c8817527c3426ea0c3ee5f306d1298','2019-09-02 11:39:59','2019-09-02 11:39:59','ad','江苏教育科教有限公司-7','sadsa',NULL,NULL,NULL,'sadada','122121',NULL,NULL,NULL,'0'),('org1567425154945','2019-09-02 11:53:54','2019-09-02 11:53:54','2332','23233','3232',NULL,NULL,NULL,'323223','332',NULL,NULL,NULL,'0'),('sal1567425368290','2019-09-02 11:56:08','2019-09-02 11:56:08','fdsa','fdsa','3232',NULL,NULL,NULL,'3232','2323',NULL,NULL,NULL,'0'),('sc20190801055007','2019-09-02 17:20:52',NULL,'老带新用户','江苏教育科教有限公司','tom','110',NULL,'总经理','买1台 IPHONE MX','一次喝菜时聊起的',NULL,NULL,NULL,'3'),('sc20190801175257','2019-09-02 17:20:54',NULL,'33332','222','32332','33232',NULL,'323232','3233232','323232',NULL,NULL,NULL,'3'),('sc20190824174427','2019-09-02 17:20:56',NULL,'dsss','江苏教育科教有限公司-1','dsfa','2212121',NULL,'212','122121','2121212121',NULL,NULL,NULL,'2');

/*Table structure for table `tbl_sale_plan` */

DROP TABLE IF EXISTS `tbl_sale_plan`;

CREATE TABLE `tbl_sale_plan` (
  `id` varchar(32) NOT NULL COMMENT '计划编号',
  `createdate` datetime DEFAULT NULL COMMENT '计划制定时间',
  `modifydate` datetime DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL COMMENT '机会编号',
  `cuid` varchar(32) DEFAULT NULL COMMENT '销售计划制定者',
  `auid` varchar(32) DEFAULT NULL COMMENT '指派者',
  `acreatedate` datetime DEFAULT NULL COMMENT '指派时间',
  `duid` varchar(32) DEFAULT NULL COMMENT '被指派者',
  `dcreatedate` varchar(1000) DEFAULT NULL COMMENT '实施时间',
  `status` int(1) DEFAULT '0' COMMENT '计划状态 0：正在执行 1：执行成功 2：执行失败',
  `result` varchar(1000) DEFAULT NULL COMMENT '执行结果',
  PRIMARY KEY (`id`),
  KEY `pla_chc_id` (`cid`),
  KEY `pla_user` (`cuid`),
  KEY `auid` (`auid`),
  KEY `duid` (`duid`),
  CONSTRAINT `tbl_sale_plan_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `tbl_sale_chance` (`id`),
  CONSTRAINT `tbl_sale_plan_ibfk_2` FOREIGN KEY (`cuid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_sale_plan_ibfk_3` FOREIGN KEY (`auid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_sale_plan_ibfk_4` FOREIGN KEY (`duid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_sale_plan` */

insert  into `tbl_sale_plan`(`id`,`createdate`,`modifydate`,`cid`,`cuid`,`auid`,`acreatedate`,`duid`,`dcreatedate`,`status`,`result`) values ('sp20190802105519',NULL,NULL,'sc20190801055007',NULL,NULL,NULL,NULL,'一起喝酒，唱K',0,'喝的很开心，期待下回一起打牌'),('sp20190823095225',NULL,NULL,'sc20190801175257',NULL,NULL,NULL,NULL,'fdsafa',1,'fdssfd');

/*Table structure for table `tbl_service` */

DROP TABLE IF EXISTS `tbl_service`;

CREATE TABLE `tbl_service` (
  `id` varchar(32) NOT NULL COMMENT '服务编号',
  `createdate` datetime NOT NULL COMMENT '创建日期',
  `modifydate` datetime DEFAULT NULL,
  `cid` varchar(32) DEFAULT NULL COMMENT '客户编号',
  `stid` varchar(20) NOT NULL DEFAULT '0' COMMENT '服务类型',
  `type` varchar(32) DEFAULT NULL COMMENT '服务类型',
  `summary` varchar(20) NOT NULL COMMENT '服务摘要',
  `status` varchar(20) NOT NULL COMMENT '服务状态 0:新建(待分配) 1：以分配(待处理) 2:以处理(待反馈) 3:处理完成（待归档） 4:以归档',
  `detail` varchar(500) NOT NULL COMMENT '服务详情',
  `cuid` varchar(32) NOT NULL COMMENT '创建人编号',
  `fauid` varchar(32) DEFAULT NULL COMMENT '服务反馈指派者',
  `facreatetime` datetime DEFAULT NULL COMMENT '服务反馈指派日期',
  `fduid` varchar(32) DEFAULT NULL COMMENT '服务反馈处理人编号',
  `fdcreatetime` datetime DEFAULT NULL COMMENT '服务反馈调查日期',
  `fresult` varchar(100) DEFAULT NULL COMMENT '服务反馈调查结果',
  `fsatisfy` int(1) DEFAULT NULL COMMENT '反馈的服务满意度',
  PRIMARY KEY (`id`),
  KEY `SVC_CREATE_NO` (`cuid`),
  KEY `SVC_DEAL_NO` (`fduid`),
  KEY `FK_Reference_6` (`cid`),
  KEY `stid` (`stid`),
  KEY `fauid` (`fauid`),
  KEY `type` (`type`),
  CONSTRAINT `tbl_service_ibfk_1` FOREIGN KEY (`stid`) REFERENCES `tbl_service_type` (`id`),
  CONSTRAINT `tbl_service_ibfk_2` FOREIGN KEY (`cid`) REFERENCES `tbl_customer` (`id`),
  CONSTRAINT `tbl_service_ibfk_3` FOREIGN KEY (`cuid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_service_ibfk_4` FOREIGN KEY (`fduid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_service_ibfk_5` FOREIGN KEY (`fauid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_service_ibfk_6` FOREIGN KEY (`type`) REFERENCES `tbl_service_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_service` */

insert  into `tbl_service`(`id`,`createdate`,`modifydate`,`cid`,`stid`,`type`,`summary`,`status`,`detail`,`cuid`,`fauid`,`facreatetime`,`fduid`,`fdcreatetime`,`fresult`,`fsatisfy`) values ('svc20190806142317','2019-06-01 14:22:58',NULL,'cst20190802110140','tst1001',NULL,'fdsa','3','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,3),('svc20190806142328','2019-07-08 00:00:00',NULL,'cst20190802110140','tst1000',NULL,'fdsa','4','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,4),('svc20190806142347','2019-06-17 00:00:00',NULL,'cst20190802110140','tst1001',NULL,'fdsa','3','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,5),('svc20190806142357','2019-06-25 00:00:00',NULL,'cst20190802110140','tst1002',NULL,'fdsa','4','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,3),('svc20190806142403','2019-08-04 00:00:00',NULL,'cst20190802110140','tst1001',NULL,'fdsa','4','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,4),('svc20190806142413','2019-07-08 00:00:00',NULL,'cst20190802110140','tst1002',NULL,'fdsa','4','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,5),('svc20190806142419','2019-08-05 00:00:00',NULL,'cst20190802110140','tst1000',NULL,'fdsa','3','fdsafdsa','0c9f7ee9243111e990d23c970e4745df',NULL,NULL,NULL,NULL,NULL,3);

/*Table structure for table `tbl_service_items` */

DROP TABLE IF EXISTS `tbl_service_items`;

CREATE TABLE `tbl_service_items` (
  `id` varchar(32) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `sid` varchar(32) DEFAULT NULL COMMENT '服务ID',
  `auid` varchar(32) DEFAULT NULL COMMENT '指派者',
  `acreatedate` datetime DEFAULT NULL COMMENT '指派日期',
  `amemo` varchar(500) DEFAULT NULL COMMENT '指派备注',
  `duid` varchar(32) DEFAULT NULL COMMENT '实施者',
  `dcreatedate` datetime DEFAULT NULL COMMENT '实施时间',
  `dresult` varchar(500) DEFAULT NULL COMMENT '实施结果',
  KEY `sid` (`sid`),
  KEY `auid` (`auid`),
  KEY `duid` (`duid`),
  CONSTRAINT `tbl_service_items_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `tbl_service` (`id`),
  CONSTRAINT `tbl_service_items_ibfk_2` FOREIGN KEY (`auid`) REFERENCES `tbl_user` (`id`),
  CONSTRAINT `tbl_service_items_ibfk_3` FOREIGN KEY (`duid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_service_items` */

/*Table structure for table `tbl_service_type` */

DROP TABLE IF EXISTS `tbl_service_type`;

CREATE TABLE `tbl_service_type` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `memo` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_service_type` */

insert  into `tbl_service_type`(`id`,`createdate`,`updatedate`,`name`,`memo`) values ('tst1000','2019-08-06 14:35:03','2019-08-06 14:35:06','咨询',NULL),('tst1001','2019-08-06 14:35:08','2019-08-06 14:35:11','建议',NULL),('tst1002','2019-08-06 14:35:13','2019-08-06 14:35:16','投诉',NULL);

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` varchar(32) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `code` varchar(32) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `moblie` varchar(100) DEFAULT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL DEFAULT '12345678',
  `gender` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `addr` varchar(100) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL COMMENT '0:正常 1：禁用',
  `rid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_rid` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user` */

insert  into `tbl_user`(`id`,`createdate`,`updatedate`,`code`,`email`,`moblie`,`name`,`password`,`gender`,`tel`,`addr`,`remark`,`state`,`rid`) values ('0c9f7ee9243111e990d23c970e4745df',NULL,NULL,'1234','hewlh@163.com','18961297987','rose','e10adc3949ba59abbe56e057f20f883e','1','110','江苏南通','好人','0','1868e69b260411e990d23c970e4745df'),('113f7229249c11e990d23c970e4745df',NULL,NULL,'1122',NULL,NULL,'jacks','a3ee8eafa6c67af865dfb153c86a6920','0','18961297987','','','0','1868e69b260411e990d23c970e4745df'),('3ca0c5310d2211e9beb53c970e4745df',NULL,NULL,'7895',NULL,NULL,'MIKE','cb3c95b7667de147854dcdcfa090c0e1','0','13584329668','FDSAFDSA','','0','46d03442211411e9bfa23c970e4745df'),('4d1021b722aa11e9bfa23c970e4745df',NULL,NULL,'7894',NULL,NULL,'Jack','cb3c95b7667de147854dcdcfa090c0e1','0','123456','','','0','3e15c4df211411e9bfa23c970e4745df'),('9d414de2fdb111e792a33c970e4745df',NULL,NULL,'9900',NULL,NULL,'李四','cb3c95b7667de147854dcdcfa090c0e1','0','323232','3232332','','0','2ed1be91211411e9bfa23c970e4745df'),('ad0f52d8211411e9bfa23c970e4745df',NULL,NULL,'7788',NULL,NULL,'樊建华','a3ee8eafa6c67af865dfb153c86a6920','0','18961297987','江苏常州','','0','1e9ed0db211411e9bfa23c970e4745df');

/*Table structure for table `tbl_user_role` */

DROP TABLE IF EXISTS `tbl_user_role`;

CREATE TABLE `tbl_user_role` (
  `rid` varchar(32) NOT NULL COMMENT '引用角色主键',
  `uid` varchar(32) NOT NULL COMMENT '引用用户主键',
  PRIMARY KEY (`rid`,`uid`),
  KEY `fk_uid` (`uid`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`rid`) REFERENCES `tbl_role` (`id`),
  CONSTRAINT `fk_uid` FOREIGN KEY (`uid`) REFERENCES `tbl_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_user_role` */

insert  into `tbl_user_role`(`rid`,`uid`) values ('1868e69b260411e990d23c970e4745df','0c9f7ee9243111e990d23c970e4745df');

/* Procedure structure for procedure `serviceComposeProc` */

/*!50003 DROP PROCEDURE IF EXISTS  `serviceComposeProc` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `serviceComposeProc`(in bdate datetime,in edate datetime)
BEGIN
	
	
    END */$$
DELIMITER ;

/* Procedure structure for procedure `testProc` */

/*!50003 DROP PROCEDURE IF EXISTS  `testProc` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `testProc`()
BEGIN
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

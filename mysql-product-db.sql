/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - productdb
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`productdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `productdb`;

/*Table structure for table `tbl_order_product` */

DROP TABLE IF EXISTS `tbl_order_product`;

CREATE TABLE `tbl_order_product` (
  `pid` varchar(32) NOT NULL COMMENT '商品ID',
  `oid` varchar(32) NOT NULL COMMENT '订单ID',
  `count` int(10) DEFAULT NULL COMMENT '商品计数',
  PRIMARY KEY (`pid`,`oid`),
  KEY `fk_oid` (`oid`),
  CONSTRAINT `fk_oid` FOREIGN KEY (`oid`) REFERENCES `tbl_orders` (`id`),
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `tbl_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_order_product` */

insert  into `tbl_order_product`(`pid`,`oid`,`count`) values ('1112','ord20190826',10),('1113','ord20190825',2),('1113','ord20190826',32),('1114','ord20190825',4),('1114','ord20190826',333),('1115','ord20190825',4),('1115','ord20190826',32),('1116','ord20190825',4),('1116','ord20190826',100);

/*Table structure for table `tbl_orders` */

DROP TABLE IF EXISTS `tbl_orders`;

CREATE TABLE `tbl_orders` (
  `id` varchar(32) NOT NULL,
  `oname` varchar(200) DEFAULT NULL,
  `odate` datetime DEFAULT NULL,
  `oaddr` varchar(500) DEFAULT NULL,
  `ostatus` tinyint(1) DEFAULT NULL,
  `ocstname` varchar(100) DEFAULT NULL COMMENT '客户姓名',
  `ocid` varchar(32) DEFAULT NULL COMMENT '客户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_orders` */

insert  into `tbl_orders`(`id`,`oname`,`odate`,`oaddr`,`ostatus`,`ocstname`,`ocid`) values ('ord20190825','大宗商品','2019-08-25 14:19:50','江苏常州',1,'樊建华','cst20190801172808'),('ord20190826','测试订单','2019-08-27 11:43:00','江苏海门',1,'Jack','cst20190802110140');

/*Table structure for table `tbl_product` */

DROP TABLE IF EXISTS `tbl_product`;

CREATE TABLE `tbl_product` (
  `id` varchar(32) NOT NULL,
  `pcode` varchar(8) DEFAULT NULL,
  `pname` varchar(100) DEFAULT NULL,
  `pprice` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tbl_product` */

insert  into `tbl_product`(`id`,`pcode`,`pname`,`pprice`) values ('1112','2222','方便面',10),('1113','3333','茶叶蛋',5),('1114','4444','火腿肠',20),('1115','5555','母鸡腿',30),('1116','6666','酸菜',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

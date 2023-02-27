/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 8.0.31 : Database - music
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `music`;

/*Table structure for table `downloadhistory` */

DROP TABLE IF EXISTS `downloadhistory`;

CREATE TABLE `downloadhistory` (
  `dlhid` int NOT NULL AUTO_INCREMENT,
  `dlhsong` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `dlhsinger` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `album` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `dlhtime` time NOT NULL,
  PRIMARY KEY (`dlhid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `downloadhistory` */

insert  into `downloadhistory`(`dlhid`,`dlhsong`,`dlhsinger`,`album`,`dlhtime`) values (1,'稻香23233','周杰伦','魔杰座','00:03:42'),(2,'告白气球','周杰伦','魔羯座','00:03:15'),(3,'阳光开朗大男孩','卦者灵风','阳光开朗大男孩','00:03:26'),(4,'爱如火','那艺娜','爱如火','00:02:42'),(5,'一路之下','张杰','未.LIVE','00:03:58'),(6,'乌梅子酱','李荣浩','纵横四海','00:04:17'),(7,'无人区玫瑰','一颗狼星','无人区玫瑰','00:04:00'),(8,'就让这大雨全都落下','容祖儿','联名','00:04:14'),(9,'我落泪情绪零碎','周杰伦','跨时代','00:04:17'),(10,'兰亭序','周杰伦','魔杰座','00:04:13'),(11,'我们的歌','王力宏','改变自己','00:04:07'),(12,'晴天','周杰伦','叶惠美','00:04:29'),(13,'王妃','萧敬腾','王妃','00:03:41');

/*Table structure for table `searches` */

DROP TABLE IF EXISTS `searches`;

CREATE TABLE `searches` (
  `sid` int NOT NULL AUTO_INCREMENT,
  `ssong` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `ssinger` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `salbum` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `stime` time DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `searches` */

insert  into `searches`(`sid`,`ssong`,`ssinger`,`salbum`,`stime`) values (1,'稻香','周杰伦','魔羯座','00:00:00'),(9,'逆战','张杰','不知道','00:03:52'),(10,'逆战','张杰','不知道','00:03:52');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `username` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`username`,`password`,`id`) values ('admin','$2a$10$oeorNQVddeualFABNb18n.6F0z9qSzdP2GcM.9sGBDkryqhu/RkVy',1),('feige','$2a$10$oeorNQVddeualFABNb18n.6F0z9qSzdP2GcM.9sGBDkryqhu/RkVy',2),('zhangsan','$2a$10$oeorNQVddeualFABNb18n.6F0z9qSzdP2GcM.9sGBDkryqhu/RkVy',4),('lisi','$2a$10$oeorNQVddeualFABNb18n.6F0z9qSzdP2GcM.9sGBDkryqhu/RkVy',5),('wangwu','$2a$10$xBNoBN/HKFZ0wBEzEINGLOsZHx93cpscysIC.3IURyalmtmcN7vJu',6),('jiege','$2a$10$twnT6aa.BPOmdW02O0O5TeaWpXC236oNUXBiy0RvlqP6btkir/7IK',7),('haha','$2a$10$.tTYp2ksuHQljs4olWzXQ.P5O54Z2JfZYjmMJ9HMvzQ.e8aMfCX1O',9),('laoliu','$2a$10$8ekwa9snIKMqyskGhkr2kuX5BcMttcdBJ3ufySZXjYJIPyNmV4tce',13);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

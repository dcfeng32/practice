/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `qihangkt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `qihangkt`;

CREATE TABLE IF NOT EXISTS `t_resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `path` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_resource` DISABLE KEYS */;
INSERT INTO `t_resource` (`id`, `path`) VALUES
	(9, '/admin/admin.html'),
	(10, '/admin/userManager.html'),
	(11, '/admin/roleManager.html'),
	(12, 'admin/addUser.html'),
	(14, '/admin/updateUser.html'),
	(15, '/admin/delUser.html'),
	(16, '/admin/batchDelUsers.html'),
	(17, '/admin/userSearch.html');
/*!40000 ALTER TABLE `t_resource` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `name`, `code`) VALUES
	(1, '超级管理员', 'admin'),
	(2, '教师', 'teacher'),
	(3, '学生', 'student');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_role_resource` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `rid` int(10) DEFAULT NULL,
  `resid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_role_resource_t_role` (`rid`),
  KEY `FK_t_role_resource_t_resource` (`resid`),
  CONSTRAINT `FK_t_role_resource_t_resource` FOREIGN KEY (`resid`) REFERENCES `t_resource` (`id`),
  CONSTRAINT `FK_t_role_resource_t_role` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_role_resource` DISABLE KEYS */;
INSERT INTO `t_role_resource` (`id`, `rid`, `resid`) VALUES
	(1, 2, 12),
	(2, 2, 14),
	(3, 2, 17),
	(4, 2, 15),
	(5, 2, 10),
	(6, 3, 17),
	(7, 3, 10),
	(8, 2, 10),
	(9, 2, 16),
	(10, 2, 11),
	(11, 2, 9);
/*!40000 ALTER TABLE `t_role_resource` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL COMMENT '0:未激活；1：已经激活',
  `add_Date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `email`, `phone`, `enable`, `add_Date`) VALUES
	(45, '111', '111', '111', '111', 1, '2019-05-30'),
	(47, '333', '333', '333', '333', 1, '2019-05-30');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) DEFAULT NULL,
  `rid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_t_user_role_t_user` (`uid`),
  KEY `FK_t_user_role_t_role` (`rid`),
  CONSTRAINT `FK_t_user_role_t_role` FOREIGN KEY (`rid`) REFERENCES `t_role` (`id`),
  CONSTRAINT `FK_t_user_role_t_user` FOREIGN KEY (`uid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` (`id`, `uid`, `rid`) VALUES
	(66, 45, 2),
	(69, 47, 1);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

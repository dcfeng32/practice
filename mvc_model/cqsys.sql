/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `cqsys` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `cqsys`;

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`username`, `password`) VALUES
	('1', '1');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `menu_info` (
  `menu_id` int(11) NOT NULL,
  `men_menu_id` int(11) DEFAULT NULL,
  `menu_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `menu_url` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  `menu_remark` varchar(2000) COLLATE utf8_bin DEFAULT NULL,
  `menu_mark` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`menu_id`),
  KEY `FK_Reference_1` (`men_menu_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`men_menu_id`) REFERENCES `menu_info` (`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40000 ALTER TABLE `menu_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `menu_info` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `role_info` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `role_desc` varchar(500) COLLATE utf8_bin NOT NULL,
  `role_mark` varchar(5) COLLATE utf8_bin NOT NULL COMMENT ' 1有效 0无效',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40000 ALTER TABLE `role_info` DISABLE KEYS */;
INSERT INTO `role_info` (`role_id`, `role_name`, `role_desc`, `role_mark`) VALUES
	(3, '红红', '涂山，我罩的', '1'),
	(92, '小白', '天天熬夜加班', '1'),
	(93, '大牛', '天天加班', '1');
/*!40000 ALTER TABLE `role_info` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `role_menu` (
  `role_menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_menu_id`),
  KEY `FK_Reference_2` (`menu_id`),
  KEY `FK_Reference_3` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`menu_id`) REFERENCES `menu_info` (`menu_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40000 ALTER TABLE `role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_menu` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_number` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_pw` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_name` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `user_sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_address` varchar(300) COLLATE utf8_bin DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_phone` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `user_mark` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_4` (`role_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

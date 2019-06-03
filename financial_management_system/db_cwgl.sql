/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `db_cwgl` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_cwgl`;

CREATE TABLE IF NOT EXISTS `t_admin` (
  `userId` int(11) NOT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `userPw` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` (`userId`, `userName`, `userPw`) VALUES
	(1, 'a', 'a');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_bumen` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `mingcheng` varchar(50) DEFAULT NULL,
  `renshu` varchar(50) DEFAULT NULL,
  `xishu` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_bumen` DISABLE KEYS */;
INSERT INTO `t_bumen` (`id`, `mingcheng`, `renshu`, `xishu`, `del`) VALUES
	(1, '采购部', '10', '1.2', 'no'),
	(2, '技术部', '30', '2.0', 'no'),
	(4, '行政部', '30', '1.5', 'no'),
	(5, 'HR', '100', '1.2', 'yes');
/*!40000 ALTER TABLE `t_bumen` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_gongzi` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `zhigong_id` int(4) DEFAULT NULL,
  `jiben` decimal(8,2) DEFAULT NULL,
  `gongling` decimal(8,2) DEFAULT NULL,
  `zhiwu` decimal(8,2) DEFAULT NULL,
  `butie` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_gongzi` DISABLE KEYS */;
INSERT INTO `t_gongzi` (`id`, `zhigong_id`, `jiben`, `gongling`, `zhiwu`, `butie`) VALUES
	(1, 1, 2000.00, 300.00, 150.00, 220.00),
	(3, 2, 5000.00, 600.00, 500.00, 300.00),
	(4, 8, 5000.00, 100.00, 100.00, 100.00);
/*!40000 ALTER TABLE `t_gongzi` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_zhigong` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `bumen_id` int(4) DEFAULT NULL,
  `bianhao` varchar(50) DEFAULT NULL,
  `loginpw` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `ruzhi` varchar(50) DEFAULT NULL,
  `del` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_zhigong` DISABLE KEYS */;
INSERT INTO `t_zhigong` (`id`, `bumen_id`, `bianhao`, `loginpw`, `xingming`, `xingbie`, `ruzhi`, `del`) VALUES
	(1, 1, '201905', 'a', '赵明', '男', '2008-04-01', 'no'),
	(2, 1, '201302', 'a', '刘红', '男', '2013-04-01', 'no'),
	(3, 2, '030024', '030024', '张三', '男', '2015-04-18', 'yes'),
	(5, 1, '201100211', 'a', '张三', '男', '2015-05-06', 'no'),
	(6, 1, '123', '123', 'lisi', '男', '2018-05-07', 'no'),
	(7, 1, '123456', '123', '雅雅', '女', '2019-04-29', 'yse'),
	(8, 2, '25646', '123', '东方', '女', '2019-04-28', 'no');
/*!40000 ALTER TABLE `t_zhigong` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

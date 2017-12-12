-- --------------------------------------------------------
-- Vært:                         127.0.0.1
-- Server-version:               5.7.19-log - MySQL Community Server (GPL)
-- ServerOS:                     Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for springbootdb
DROP DATABASE IF EXISTS `springbootdb`;
CREATE DATABASE IF NOT EXISTS `springbootdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `springbootdb`;

-- Dumping structure for tabel springbootdb.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `locationID` int(11) NOT NULL AUTO_INCREMENT,
  `bookcase` varchar(50) NOT NULL DEFAULT '0',
  `shelf` varchar(50) NOT NULL DEFAULT '0',
  `box` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`locationID`),
  UNIQUE KEY `bookcase_shelf_box` (`bookcase`,`shelf`,`box`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tabel springbootdb.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `productID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `costPrice` int(11) DEFAULT NULL,
  `salesPrice` int(11) DEFAULT NULL,
  `productNumber` int(11) DEFAULT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tabel springbootdb.product_location
DROP TABLE IF EXISTS `product_location`;
CREATE TABLE IF NOT EXISTS `product_location` (
  `pLocationID` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL DEFAULT '0',
  `location` int(11) NOT NULL DEFAULT '0',
  `product` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pLocationID`),
  KEY `productFK` (`product`),
  KEY `locationFK` (`location`),
  CONSTRAINT `locationFK` FOREIGN KEY (`location`) REFERENCES `location` (`locationID`),
  CONSTRAINT `productFK` FOREIGN KEY (`product`) REFERENCES `product` (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for tabel springbootdb.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `admin` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.6.5-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database footballfields
CREATE DATABASE IF NOT EXISTS `footballfields` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `footballfields`;

-- Dump della struttura di tabella footballfields.associate
CREATE TABLE IF NOT EXISTS `associate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first` varchar(20) NOT NULL,
  `last` varchar(20) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `id_fields` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella footballfields.booking
CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` varchar(5) NOT NULL,
  `id_field` int(11) NOT NULL,
  `id_associate` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_associate` (`id_associate`),
  KEY `FK_booking_field` (`id_field`),
  CONSTRAINT `FK_booking_field` FOREIGN KEY (`id_field`) REFERENCES `field` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`id_associate`) REFERENCES `associate` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella footballfields.features
CREATE TABLE IF NOT EXISTS `features` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `indoor` tinyint(1) NOT NULL,
  `heating` tinyint(1) NOT NULL,
  `ac` tinyint(1) NOT NULL,
  `id_field` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fields` (`id_field`) USING BTREE,
  CONSTRAINT `FK_features_field` FOREIGN KEY (`id_field`) REFERENCES `field` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella footballfields.field
CREATE TABLE IF NOT EXISTS `field` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_fields` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fields` (`id_fields`),
  CONSTRAINT `field_ibfk_1` FOREIGN KEY (`id_fields`) REFERENCES `fields` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella footballfields.fields
CREATE TABLE IF NOT EXISTS `fields` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '0',
  `open` varchar(5) NOT NULL DEFAULT '0',
  `close` varchar(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

-- Dump della struttura di tabella footballfields.login
CREATE TABLE IF NOT EXISTS `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(8) NOT NULL DEFAULT '',
  `id_associate` int(11) NOT NULL DEFAULT 0,
  `ruolo` enum('admin','user') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__associate` (`id_associate`),
  CONSTRAINT `FK__associate` FOREIGN KEY (`id_associate`) REFERENCES `associate` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- L’esportazione dei dati non era selezionata.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

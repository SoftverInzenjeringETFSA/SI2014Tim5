-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 31, 2015 at 12:05 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tim5`
--
CREATE SCHEMA IF NOT EXISTS `tim5` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf';
grant all on tim5.* to 'EtfSI2014'@'localhost';
USE `tim5` ;
-- --------------------------------------------------------

--
-- Table structure for table `dug`
--

CREATE TABLE IF NOT EXISTS `dug` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `JELIIZMIREN` bit(1) DEFAULT NULL,
  `AKADEMSKAGODINA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VRIJEDNOST` double DEFAULT NULL,
  `TIPDUGA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `literaturaId` int(11) DEFAULT NULL,
  `studentId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id_fk` (`studentId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=15 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `literaturaId`, `studentId`) VALUES
(5, b'0', '2014/2015', 18000, 'dugZaSkolarinu', 0, 15),
(7, b'0', '2014/2015', 1620, 'dugZaSkolarinu', 0, 18),
(8, b'0', '2014/2015', 735, 'dugZaSkolarinu', 0, 1),
(9, b'0', '2014/2015', 4500, 'dugZaSkolarinu', 0, 20);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PREZIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `JMBG` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ADRESA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TELEFON` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `MAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TIPKORISNIKA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `KORISNICKOIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `LOZINKA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `KORISNICKOIME_UNIQUE` (`KORISNICKOIME`),
  UNIQUE KEY `JMBG_UNIQUE` (`JMBG`),
  UNIQUE KEY `TELEFON_UNIQUE` (`TELEFON`),
  UNIQUE KEY `MAIL_UNIQUE` (`MAIL`)
) ENGINE=InnoDB  DEFAULT CHARSET=ucs2 COLLATE=ucs2_slovenian_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `MAIL`, `TIPKORISNIKA`, `KORISNICKOIME`, `LOZINKA`) VALUES
(1, 'Faris', 'Džafić', '0611993176507', 'Visoko', '062/961-960', 'faris.dzafic@outlook.com', 'Korisnik', 'fdzafic', 'Admin123'),
(2, 'Admin', 'Admin', '0906992174152', 'Admin', '063/961-960', 'sitim52014@gmail.com', 'Administrator', 'Admin', 'Admin123'),
(4, 'Amra', 'Dautbegović', '0906992147158', 'Sarajevo', '061/987-963', 'amra@amra.com', 'Korisnik', 'adautbegovic', 'admin'),
(6, 'Dino', 'Hurem', '0906991174152', 'Sarajevo', '061/789-987', 'dino@dino.com', 'Korisnik', 'dhurem', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `literatura`
--

CREATE TABLE IF NOT EXISTS `literatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `NAZIV` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `AUTOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `KOLICINA` int(11) DEFAULT NULL,
  `CIJENA` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ISBN_UNIQUE` (`ISBN`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=17 ;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `ISBN`, `NAZIV`, `AUTOR`, `KOLICINA`, `CIJENA`) VALUES
(13, '978-3-16-148410-0', 'Severinine zgode i nezgode', 'Neki lik', 20, 50);

-- --------------------------------------------------------

--
-- Table structure for table `rata`
--

CREATE TABLE IF NOT EXISTS `rata` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `VRIJEDNOST` double DEFAULT NULL,
  `JELIUPLACENA` bit(1) DEFAULT NULL,
  `DATUMZADUZENJA` datetime DEFAULT NULL,
  `DATUMRAZDUZENJA` datetime DEFAULT NULL,
  `ROKUPLATE` datetime DEFAULT NULL,
  `dugId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `dug_id_fk` (`dugId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=49 ;

--
-- Dumping data for table `rata`
--

INSERT INTO `rata` (`id`, `VRIJEDNOST`, `JELIUPLACENA`, `DATUMZADUZENJA`, `DATUMRAZDUZENJA`, `ROKUPLATE`, `dugId`) VALUES
(17, 4500, b'0', '2015-05-30 14:33:50', NULL, '2015-08-28 14:33:50', 5),
(18, 4500, b'0', '2015-05-30 14:33:50', NULL, '2015-08-28 14:33:50', 5),
(19, 4500, b'0', '2015-05-30 14:33:50', NULL, '2015-08-28 14:33:50', 5),
(20, 4500, b'0', '2015-05-30 14:33:50', NULL, '2015-08-28 14:33:50', 5),
(25, 405, b'0', '2015-05-30 15:13:43', NULL, '2015-08-28 15:13:43', 7),
(26, 405, b'0', '2015-05-30 15:13:43', NULL, '2015-08-28 15:13:43', 7),
(27, 405, b'0', '2015-05-30 15:13:43', NULL, '2015-08-28 15:13:43', 7),
(28, 405, b'0', '2015-05-30 15:13:43', NULL, '2015-08-28 15:13:43', 7),
(29, 245, b'0', '2015-05-30 15:25:32', NULL, '2015-08-28 15:25:32', 8),
(30, 245, b'0', '2015-05-30 15:25:32', NULL, '2015-08-28 15:25:32', 8),
(31, 245, b'0', '2015-05-30 15:25:32', NULL, '2015-08-28 15:25:32', 8),
(32, 245, b'1', '2015-05-30 15:25:32', '2015-05-30 15:29:12', '2015-08-28 15:25:32', 8),
(33, 1125, b'0', '2015-05-30 15:42:58', NULL, '2015-08-28 15:42:58', 9),
(34, 1125, b'0', '2015-05-30 15:42:58', NULL, '2015-08-28 15:42:58', 9),
(35, 1125, b'0', '2015-05-30 15:42:58', NULL, '2015-08-28 15:42:58', 9),
(36, 1125, b'0', '2015-05-30 15:42:58', NULL, '2015-08-28 15:42:58', 9);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `PREZIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `JMBG` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `MAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `ADRESA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `OPCINA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `TELEFON` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `INDEKS` int(11) DEFAULT NULL,
  `TROSKOVISKOLARINE` double DEFAULT NULL,
  `TROSKOVILITERATURE` double DEFAULT NULL,
  `IMERODITELJA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `MJESTORODJENJA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `OPCINARODJENJA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `DRZAVARODJENJA` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `POPUST` double DEFAULT NULL,
  `GODINASTUDIJA` varchar(255) COLLATE utf8_slovenian_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `JMBG_UNIQUE` (`JMBG`),
  UNIQUE KEY `INDEKS_UNIQUE` (`INDEKS`),
  UNIQUE KEY `TELEFON_UNIQUE` (`TELEFON`),
  UNIQUE KEY `MAIL_UNIQUE` (`MAIL`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=24 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`) VALUES
(1, 'Šaban', 'Šabanović', '0906993174156', 'saban@saban.com', 'Šaban', 'Šaban', '062/454-969', 45698, 1400, 0, 'Šaban', 'Šaban', 'Šaban', 'Šaban', 30, NULL),
(15, 'Faris', 'Džafić', '0906992174152', 'fdzafic1@etf.unsa.ba', 'Visoko', 'Visoko', '062/961-960', 15987, 18000, 0, 'Romeo', 'Visoko', 'Visoko', 'Bosna i Hercegovina', 0, NULL),
(18, 'Sabina', 'Grošić', '0906992174153', 'sgrosic1@etf.unsa.ba', 'Grošić', 'Grošić', '062/456-969', 12345, 1800, 0, 'Grošić', 'Bihać', 'Grošić', 'Grošić', 10, NULL),
(20, 'Faris', 'Faris', '0906993174158', 'asd@asd.com', 'Faris', 'Faris', '066/987-987', 15647, 9000, 0, 'Faris', 'Faris', 'Faris', 'Faris', 50, 'Prva_BSC');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dug`
--
ALTER TABLE `dug`
  ADD CONSTRAINT `student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rata`
--
ALTER TABLE `rata`
  ADD CONSTRAINT `dug_id_fk` FOREIGN KEY (`dugId`) REFERENCES `dug` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

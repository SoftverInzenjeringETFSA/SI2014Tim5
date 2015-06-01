-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2015 at 02:02 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=23 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `literaturaId`, `studentId`) VALUES
(5, b'0', '2014/2015', 13500, 'dugZaSkolarinu', 0, 15),
(7, b'0', '2014/2015', 1620, 'dugZaSkolarinu', 0, 18),
(8, b'0', '2014/2015', 735, 'dugZaSkolarinu', 0, 1),
(9, b'0', '2014/2015', 4500, 'dugZaSkolarinu', 0, 20),
(15, b'0', '2014/2015', 12.5, 'dugZaLiteraturu', 0, 18),
(16, b'0', '2014/2015', 37.5, 'dugZaLiteraturu', 0, 20),
(17, b'0', '2014/2015', 900, 'dugZaSkolarinu', 0, 24),
(18, b'0', '2014/2015', 4050, 'dugZaSkolarinu', 0, 25),
(19, b'0', '2014/2015', 2025, 'dugZaSkolarinu', 0, 26),
(20, b'0', '2014/2015', 4500, 'dugZaSkolarinu', 0, 27),
(21, b'0', '2014/2015', 25, 'dugZaLiteraturu', 0, 27),
(22, b'0', '2014/2015', 12.5, 'dugZaLiteraturu', 0, 1);

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
) ENGINE=InnoDB  DEFAULT CHARSET=ucs2 COLLATE=ucs2_slovenian_ci AUTO_INCREMENT=20 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `MAIL`, `TIPKORISNIKA`, `KORISNICKOIME`, `LOZINKA`) VALUES
(18, 'Admin', 'Admin', '0906992174174', 'Admin', '062/919-916', 'sitim52014@gmail.com', 'Administrator', 'Admin', 'e64b78fc3bc91bcbc7dc232ba8ec59e0'),
(19, 'Faris', 'Džafić', '0906992174152', 'Visoko', '062/961-960', 'fdzafic1@etf.unsa.ba', 'Administrator', 'fdzafic', 'e64b78fc3bc91bcbc7dc232ba8ec59e0');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=14 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=81 ;

--
-- Dumping data for table `rata`
--

INSERT INTO `rata` (`id`, `VRIJEDNOST`, `JELIUPLACENA`, `DATUMZADUZENJA`, `DATUMRAZDUZENJA`, `ROKUPLATE`, `dugId`) VALUES
(17, 4500, b'0', '2015-05-30 14:33:50', NULL, '2015-08-28 14:33:50', 5),
(18, 4500, b'1', '2015-05-30 14:33:50', '2015-06-01 13:57:57', '2015-08-28 14:33:50', 5),
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
(36, 1125, b'0', '2015-05-30 15:42:58', NULL, '2015-08-28 15:42:58', 9),
(49, 12.5, b'1', '2015-05-31 12:12:47', '2015-05-31 14:04:07', '2015-08-29 12:12:47', 15),
(50, 12.5, b'1', '2015-05-31 12:12:47', '2015-05-31 14:03:10', '2015-08-29 12:12:47', 15),
(51, 12.5, b'0', '2015-05-31 12:12:47', NULL, '2015-08-29 12:12:47', 15),
(52, 12.5, b'1', '2015-05-31 12:12:47', '2015-05-31 14:04:10', '2015-08-29 12:12:47', 15),
(53, 12.5, b'0', '2015-05-31 12:17:53', NULL, '2015-08-29 12:17:53', 16),
(54, 12.5, b'0', '2015-05-31 12:17:53', NULL, '2015-08-29 12:17:53', 16),
(55, 12.5, b'1', '2015-05-31 12:17:53', '2015-05-31 14:30:04', '2015-08-29 12:17:53', 16),
(56, 12.5, b'0', '2015-05-31 12:17:53', NULL, '2015-08-29 12:17:53', 16),
(57, 300, b'0', '2015-05-31 13:24:07', NULL, '2015-08-29 13:24:07', 17),
(58, 300, b'0', '2015-05-31 13:24:07', NULL, '2015-08-29 13:24:07', 17),
(59, 300, b'1', '2015-05-31 13:24:07', '2015-05-31 21:13:38', '2015-08-29 13:24:07', 17),
(60, 300, b'0', '2015-05-31 13:24:07', NULL, '2015-08-29 13:24:07', 17),
(61, 1012.5, b'0', '2015-05-31 13:34:41', NULL, '2015-08-29 13:34:41', 18),
(62, 1012.5, b'0', '2015-05-31 13:34:41', NULL, '2015-08-29 13:34:41', 18),
(63, 1012.5, b'0', '2015-05-31 13:34:41', NULL, '2015-08-29 13:34:41', 18),
(64, 1012.5, b'0', '2015-05-31 13:34:41', NULL, '2015-08-29 13:34:41', 18),
(65, 1012.5, b'0', '2015-05-31 13:43:49', NULL, '2015-08-29 13:43:49', 19),
(66, 1012.5, b'1', '2015-05-31 13:43:49', '2015-06-01 13:57:34', '2015-08-29 13:43:49', 19),
(67, 1012.5, b'0', '2015-05-31 13:43:49', NULL, '2015-08-29 13:43:49', 19),
(68, 1012.5, b'1', '2015-05-31 13:43:49', '2015-06-01 13:57:31', '2015-08-29 13:43:49', 19),
(69, 1125, b'0', '2015-05-31 13:46:42', NULL, '2015-08-29 13:46:42', 20),
(70, 1125, b'0', '2015-05-31 13:46:42', NULL, '2015-08-29 13:46:42', 20),
(71, 1125, b'0', '2015-05-31 13:46:42', NULL, '2015-08-29 13:46:42', 20),
(72, 1125, b'0', '2015-05-31 13:46:42', NULL, '2015-08-29 13:46:42', 20),
(73, 12.5, b'0', '2015-05-31 13:46:49', NULL, '2015-08-29 13:46:49', 21),
(74, 12.5, b'1', '2015-05-31 13:46:49', '2015-06-01 13:29:30', '2015-08-29 13:46:49', 21),
(75, 12.5, b'0', '2015-05-31 13:46:49', NULL, '2015-08-29 13:46:49', 21),
(76, 12.5, b'1', '2015-05-31 13:46:49', '2015-06-01 13:29:34', '2015-08-29 13:46:49', 21),
(77, 12.5, b'1', '2015-06-01 13:28:04', '2015-06-01 13:28:40', '2015-08-30 13:28:04', 22),
(78, 12.5, b'1', '2015-06-01 13:28:04', '2015-06-01 13:28:49', '2015-08-30 13:28:04', 22),
(79, 12.5, b'0', '2015-06-01 13:28:04', NULL, '2015-08-30 13:28:04', 22),
(80, 12.5, b'1', '2015-06-01 13:28:04', '2015-06-01 13:28:43', '2015-08-30 13:28:04', 22);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=28 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`) VALUES
(1, 'Šaban', 'Šabanović', '0906993174156', 'saban@saban.com', 'Šaban', 'Šaban', '062/454-969', 45698, 1400, 50, 'Šaban', 'Šaban', 'Šaban', 'Šaban', 30, NULL),
(15, 'Faris', 'Džafić', '0906992174152', 'fdzafic1@etf.unsa.ba', 'Visoko', 'Visoko', '062/961-960', 15987, 18000, 0, 'Romeo', 'Visoko', 'Visoko', 'Bosna i Hercegovina', 0, NULL),
(18, 'Sabina', 'Grošić', '0906992174153', 'sgrosic1@etf.unsa.ba', 'Grošić', 'Grošić', '062/456-969', 12345, 1800, 0, 'Grošić', 'Bihać', 'Grošić', 'Grošić', 10, NULL),
(20, 'Faris', 'Faris', '0906993174158', 'asd@asd.com', 'Faris', 'Faris', '066/987-987', 15647, 9000, 50, 'Faris', 'Faris', 'Faris', 'Faris', 50, 'Prva_BSC'),
(24, 'Ramiz', 'Ramiz', '0906994175165', 'ramiz@ramiz.com', 'Ramiz', 'Ramiz', '061/456-987', 142536, 1200, 0, 'Ramiz', 'Ramiz', 'Ramiz', 'Ramiz', 0, 'Prva_BSC'),
(25, 'Mujo', 'Mujo', '0906997123456', 'mujo@mujo.com', 'Mujo', 'Mujo', '012/789-987', 56565, 4500, 0, 'Mujo', 'Mujo', 'Mujo', 'Mujo', 10, 'Prva_BSC'),
(26, 'Suljo', 'Suljo', '0907993456852', 'suljo@suljo.com', 'Suljo', 'Suljo', '012/369-965', 456879, 4500, 0, 'Suljo', 'Suljo', 'Suljo', 'Suljo', 10, 'Prva_BSC'),
(27, 'Hamo', 'Hamo', '0904992174152', 'hmo@hmo.com', 'Hamo', 'Hamo', '123/987-987', 19876, 4500, 50, 'Hamo', 'Hamo', 'Hamo', 'Hamo', 10, 'Prva_BSC');

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

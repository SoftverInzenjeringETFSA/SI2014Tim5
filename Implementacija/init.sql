-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 02, 2015 at 10:22 PM
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
CREATE DATABASE IF NOT EXISTS `tim5` DEFAULT CHARACTER SET utf8 COLLATE utf8_slovenian_ci;
USE `tim5`;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=33 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `literaturaId`, `studentId`) VALUES
(25, b'0', '2014/2015', 450, 'dugZaSkolarinu', 0, 28),
(26, b'0', '2014/2015', 25, 'dugZaLiteraturu', 13, 28),
(32, b'0', '2014/2015', 2500, 'dugZaSkolarinu', 0, 30);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=117 ;

--
-- Dumping data for table `rata`
--

INSERT INTO `rata` (`id`, `VRIJEDNOST`, `JELIUPLACENA`, `DATUMZADUZENJA`, `DATUMRAZDUZENJA`, `ROKUPLATE`, `dugId`) VALUES
(89, 450, b'1', '2015-06-01 18:46:33', '2015-06-02 13:48:08', '2015-08-30 18:46:33', 25),
(90, 450, b'0', '2015-06-01 18:46:33', NULL, '2015-08-30 18:46:33', 25),
(91, 450, b'1', '2015-06-01 18:46:33', '2015-06-01 18:46:59', '2015-08-30 18:46:33', 25),
(92, 450, b'1', '2015-06-01 18:46:33', '2015-06-01 20:23:19', '2015-08-30 18:46:33', 25),
(93, 12.5, b'0', '2015-06-01 18:46:51', NULL, '2015-08-30 18:46:51', 26),
(94, 12.5, b'1', '2015-06-01 18:46:51', '2015-06-01 20:23:21', '2015-08-30 18:46:51', 26),
(95, 12.5, b'1', '2015-06-01 18:46:51', '2015-06-01 18:46:58', '2015-08-30 18:46:51', 26),
(96, 12.5, b'0', '2015-06-01 18:46:51', NULL, '2015-08-30 18:46:51', 26),
(113, 625, b'0', '2015-06-02 22:12:48', NULL, '2015-08-31 22:12:48', 32),
(114, 625, b'0', '2015-06-02 22:12:48', NULL, '2015-08-31 22:12:48', 32),
(115, 625, b'0', '2015-06-02 22:12:48', NULL, '2015-08-31 22:12:48', 32),
(116, 625, b'0', '2015-06-02 22:12:48', NULL, '2015-08-31 22:12:48', 32);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_slovenian_ci AUTO_INCREMENT=31 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`) VALUES
(28, 'Dženana', 'Bričić', '0906992174158', 'dzenan@test.com', 'Sarajevo', 'Sarajevo', '062/987-635', 14759, 1800, 50, 'Aziz', 'Gračanica', 'Gračanica', 'BiH', 10, 'Prva_BSC'),
(30, 'Faris', 'Džafić', '0906992174152', 'fdzafic1@etf.unsa.ba', 'Visoko', 'Visoko', '062/961-960', 15987, 2500, 0, 'Faris', 'Visoko', 'Visoko', 'BiH', 50, 'Treca_BSC');

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

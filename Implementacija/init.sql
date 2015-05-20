-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 20, 2015 at 01:24 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE SCHEMA IF NOT EXISTS `tim5` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf';
grant all on tim5.* to 'EtfSI2014'@'localhost';
USE `tim5` ;
--
-- Database: `tim5`
--

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=7 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `literaturaId`, `studentId`) VALUES
(5, b'0', '2014/2015', 18490512.795399997, 'dugZaSkolarinu', 0, 10),
(6, b'0', '2014/2015', 81, 'dugZaSkolarinu', 0, 11);

-- --------------------------------------------------------

--
-- Table structure for table `izvjestaj`
--

CREATE TABLE IF NOT EXISTS `izvjestaj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATUM` datetime DEFAULT NULL,
  `SADRZAJ` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `korisnikId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `korisnik_id_fk` (`korisnikId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE IF NOT EXISTS `korisnik` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PREZIME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `JMBG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ADRESA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TELEFON` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MAIL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TIPKORISNIKA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KORISNICKOIME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `LOZINKA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3 ;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `MAIL`, `TIPKORISNIKA`, `KORISNICKOIME`, `LOZINKA`) VALUES
(1, 'dino', 'hurem', '2311991170041', 'aef', '062/772-669', 'aef', 'Administrator', 'user', 'lozinka'),
(2, 'admin', 'admin', '2311991170041', 'aef', '062/772-669', 'aef', 'Administrator', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `literatura`
--

CREATE TABLE IF NOT EXISTS `literatura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `NAZIV` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `AUTOR` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KOLICINA` int(11) DEFAULT NULL,
  `CIJENA` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=11 ;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `ISBN`, `NAZIV`, `AUTOR`, `KOLICINA`, `CIJENA`) VALUES
(2, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(3, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(4, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(5, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(6, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(7, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(10, '123fasdfsd', 'Dzenanine zgode i nezgode', 'Dzenana', 12, 69);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=13 ;

--
-- Dumping data for table `rata`
--

INSERT INTO `rata` (`id`, `VRIJEDNOST`, `JELIUPLACENA`, `DATUMZADUZENJA`, `DATUMRAZDUZENJA`, `ROKUPLATE`, `dugId`) VALUES
(9, 20.25, b'0', '2015-05-20 01:12:38', NULL, '2015-08-18 01:12:38', 6),
(10, 20.25, b'0', '2015-05-20 01:12:38', NULL, '2015-08-18 01:12:38', 6),
(11, 20.25, b'0', '2015-05-20 01:12:38', NULL, '2015-08-18 01:12:38', 6),
(12, 20.25, b'0', '2015-05-20 01:12:38', NULL, '2015-08-18 01:12:38', 6);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `PREZIME` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `JMBG` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MAIL` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ADRESA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OPCINA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `TELEFON` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `INDEKS` int(11) DEFAULT NULL,
  `TROSKOVISKOLARINE` double DEFAULT NULL,
  `TROSKOVILITERATURE` double DEFAULT NULL,
  `IMERODITELJA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `MJESTORODJENJA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `OPCINARODJENJA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `DRZAVARODJENJA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `POPUST` double DEFAULT NULL,
  `GODINASTUDIJA` int(11) DEFAULT NULL,
  `DUGID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=12 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`, `DUGID`) VALUES
(1, 'ttttt', '', '', '', '', '', '', 1111, 900, 0, '', '', '', '', 10, 0, 0),
(2, 'Azra', 'Jarebicaa', 'fsdfsdfe', 'sdfsdfsd', 'fdsfsd', 'fdsfsdfsd', 'fsdfsdffs', 112123, 12, 0, 'sdffsdf', 'asdadas', 'asdffsd', 'fsdfsd', 0, 0, 0),
(3, 'Amra', 'Dautbegovic', 'fsdfsdfe', 'sdfsdfsd', 'fdsfsd', 'fdsfsdfsd', 'fsdfsdffs', 112123, 12, 0, 'sdffsdf', 'asdadas', 'asdffsd', 'fsdfsd', 0, 0, 0),
(4, 'Lazar', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 12341, 12345, 0, 'xxxxx', 'xxxxx', 'xxxxx', 'xxxxx', 20, 0, 0),
(5, 'cccca', 'cccca', '', '', '', '', 'cccca', 123, 11111, 0, 'cccca', 'cccca', 'cccca', 'cccca', 11, 0, 0),
(6, 'aaaa', 'aaaa', '', '', '', '', '', 123, 123, 0, 'aaaa', '', '', '', 1211, 0, 0),
(7, 'asdasdas', '', '', '', '', '', '', 121111, 61.41, 0, '', '', '', '', 11, 0, 0),
(8, 'asdasd', '', '', '', '', '', '', 123, 109.47, 0, '', '', '', '', 11, 0, 0),
(9, 'Azra2', '', '', '', '', '', '', 69, 106.8, 0, '', '', '', '', 11, 0, 0),
(10, 'lalalala', 'lalalal', '', '', '', '', '', 9999, -151053.94, 0, '', '', '', '', 12341, 0, 0),
(11, 'Faris', 'Dzafic', '', '', '', '', '', 12121, 90, 0, '', 'Visoko', '', '', 10, 0, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dug`
--
ALTER TABLE `dug`
  ADD CONSTRAINT `student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `izvjestaj`
--
ALTER TABLE `izvjestaj`
  ADD CONSTRAINT `korisnik_id_fk` FOREIGN KEY (`korisnikId`) REFERENCES `korisnik` (`id`);

--
-- Constraints for table `rata`
--
ALTER TABLE `rata`
  ADD CONSTRAINT `dug_id_fk` FOREIGN KEY (`dugId`) REFERENCES `dug` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

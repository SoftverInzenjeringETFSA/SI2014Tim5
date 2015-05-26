-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2015 at 06:48 PM
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=5 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `literaturaId`, `studentId`) VALUES
(1, b'0', '2014/2015', 1800, 'dugZaSkolarinu', 0, 12),
(2, b'1', '2014/2015', 0, 'dugZaSkolarinu', 0, 13),
(3, b'0', '2014/2015', 1500, 'dugZaSkolarinu', 0, 14),
(4, b'0', '2014/2015', 50, 'dugZaLiteraturu', 0, 14);

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
(1, 'Faris', 'Džafić', '0906992174152', 'Visoko', '062/961-960', 'faris.dzafic@outlook.com', 'Korisnik', 'fdzafic', 'Admin123');
INSERT INTO `korisnik` (`id`, `IME`, `PREZIME`, `JMBG`, `ADRESA`, `TELEFON`, `MAIL`, `TIPKORISNIKA`, `KORISNICKOIME`, `LOZINKA`) VALUES
(2, 'Admin', 'Admin', '0906992174152', 'Admin', '063/961-960', 'sitim52014@gmail.com', 'Administrator', 'Admin', 'Admin123');

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=14 ;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `ISBN`, `NAZIV`, `AUTOR`, `KOLICINA`, `CIJENA`) VALUES
(11, 'ISBN 978-0-300-14424-6', 'Pinokio', 'Neki lik', 10, 15),
(12, 'ISBN 978-0-300-14424-6', 'Lesi se vraca kuci', 'Neki lik', 10, 20),
(13, 'ISBN 978-0-300-14424-6', 'Severinine zgode i nezgode', 'Neki lik', 20, 50);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=17 ;

--
-- Dumping data for table `rata`
--

INSERT INTO `rata` (`id`, `VRIJEDNOST`, `JELIUPLACENA`, `DATUMZADUZENJA`, `DATUMRAZDUZENJA`, `ROKUPLATE`, `dugId`) VALUES
(1, 450, b'0', '2015-05-24 18:17:40', NULL, '2015-08-22 18:17:40', 1),
(2, 450, b'0', '2015-05-24 18:17:40', NULL, '2015-08-22 18:17:40', 1),
(3, 450, b'0', '2015-05-24 18:17:40', NULL, '2015-08-22 18:17:40', 1),
(4, 450, b'0', '2015-05-24 18:17:40', NULL, '2015-08-22 18:17:40', 1),
(5, 500, b'1', '2015-05-24 18:18:16', '2015-05-24 18:39:09', '2015-08-22 18:18:16', 2),
(6, 500, b'1', '2015-05-24 18:18:16', '2015-05-24 18:39:11', '2015-08-22 18:18:16', 2),
(7, 500, b'1', '2015-05-24 18:18:16', '2015-05-24 18:39:13', '2015-08-22 18:18:16', 2),
(8, 500, b'1', '2015-05-24 18:18:16', '2015-05-24 18:39:14', '2015-08-22 18:18:16', 2),
(9, 500, b'0', '2015-05-24 18:18:45', NULL, '2015-08-22 18:18:45', 3),
(10, 500, b'0', '2015-05-24 18:18:45', NULL, '2015-08-22 18:18:45', 3),
(11, 500, b'1', '2015-05-24 18:18:45', '2015-05-24 18:32:23', '2015-08-22 18:18:45', 3),
(12, 500, b'0', '2015-05-24 18:18:45', NULL, '2015-08-22 18:18:45', 3),
(13, 12.5, b'0', '2015-05-24 18:35:55', NULL, '2015-08-22 18:35:55', 4),
(14, 12.5, b'0', '2015-05-24 18:35:55', NULL, '2015-08-22 18:35:55', 4),
(15, 12.5, b'0', '2015-05-24 18:35:55', NULL, '2015-08-22 18:35:55', 4),
(16, 12.5, b'0', '2015-05-24 18:35:55', NULL, '2015-08-22 18:35:55', 4);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=15 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`, `DUGID`) VALUES
(12, 'Amra', 'Dautbegović', '0906992174152', 'amra@amra.com', 'Sarajevo', 'Centar', '066/878-999', 12345, 1800, 0, 'Roditelj', 'Sarajevo', 'Centar', 'BiH', 0, 0, 0),
(13, 'Azra', 'Jarebica', '0906992174152', 'azra@azra.com', 'Sarajevo', 'Centar', '066/878-999', 54321, 2000, 0, 'Roditelj', 'Sarajevo', 'Centar', 'BiH', 0, 0, 0),
(14, 'Dino', 'Hurem', '0906992174152', 'dino@dino.com', 'Sarajevo', 'Centar', '066/878-999', 54321, 2000, 0, 'Roditelj', 'Sarajevo', 'Centar', 'BiH', 0, 0, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dug`
--
ALTER TABLE `dug`
  ADD CONSTRAINT `student_id_fk` FOREIGN KEY (`studentId`) REFERENCES `student` (`id`);

--
-- Constraints for table `rata`
--
ALTER TABLE `rata`
  ADD CONSTRAINT `dug_id_fk` FOREIGN KEY (`dugId`) REFERENCES `dug` (`id`);
  
ALTER TABLE `tim5`.`korisnik` 
ADD UNIQUE INDEX `id_UNIQUE` (`id` ASC),
ADD UNIQUE INDEX `KORISNICKOIME_UNIQUE` (`KORISNICKOIME` ASC);


/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

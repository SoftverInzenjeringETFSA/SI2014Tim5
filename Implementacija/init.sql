-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2015 at 02:52 PM
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
  `LITERATURAID` bigint(20) DEFAULT NULL,
  `JELIIZMIREN` bit(1) DEFAULT NULL,
  `AKADEMSKAGODINA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `VRIJEDNOST` double DEFAULT NULL,
  `TIPDUGA` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KORISNIKID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Dumping data for table `dug`
--

INSERT INTO `dug` (`id`, `LITERATURAID`, `JELIIZMIREN`, `AKADEMSKAGODINA`, `VRIJEDNOST`, `TIPDUGA`, `KORISNIKID`) VALUES
(1, NULL, b'1', 'asd', 12, 'dugZaLiteraturu', 1);

-- --------------------------------------------------------

--
-- Table structure for table `izvjestaj`
--

CREATE TABLE IF NOT EXISTS `izvjestaj` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DATUM` datetime DEFAULT NULL,
  `SADRZAJ` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `KORISNIKID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=10 ;

--
-- Dumping data for table `literatura`
--

INSERT INTO `literatura` (`id`, `ISBN`, `NAZIV`, `AUTOR`, `KOLICINA`, `CIJENA`) VALUES
(1, 'asd', 'asd', 'asd', 1, 42.3),
(2, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(3, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(4, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(5, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(6, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(7, 'asdq1', 'Sabinine zgode i nezgode', 'Sabina', 1212, 123.1),
(8, 'xxx', 'asd', 'asd', 1, 42.3),
(9, 'esafsd', 'dfsfsd', 'fsdfsdf', 213, 1312);

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
  `DUGID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `IME`, `PREZIME`, `JMBG`, `MAIL`, `ADRESA`, `OPCINA`, `TELEFON`, `INDEKS`, `TROSKOVISKOLARINE`, `TROSKOVILITERATURE`, `IMERODITELJA`, `MJESTORODJENJA`, `OPCINARODJENJA`, `DRZAVARODJENJA`, `POPUST`, `GODINASTUDIJA`, `DUGID`) VALUES
(1, 'Faris', 'Dzafic', 'fsdfsdfe', 'sdfsdfsd', 'fdsfsd', 'fdsfsdfsd', 'fsdfsdffs', 11234, 12, 0, 'sdffsdf', 'asdadas', 'asdffsd', 'fsdfsd', 0, 0, 0),
(2, 'Azra', 'Jarebicaa', 'fsdfsdfe', 'sdfsdfsd', 'fdsfsd', 'fdsfsdfsd', 'fsdfsdffs', 112123, 12, 0, 'sdffsdf', 'asdadas', 'asdffsd', 'fsdfsd', 0, 0, 0),
(3, 'Amra', 'Dautbegovic', 'fsdfsdfe', 'sdfsdfsd', 'fdsfsd', 'fdsfsdfsd', 'fsdfsdffs', 112123, 12, 0, 'sdffsdf', 'asdadas', 'asdffsd', 'fsdfsd', 0, 0, 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

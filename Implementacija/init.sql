-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tim5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tim5
-- -----------------------------------------------------

CREATE USER 'EtfSI2014'@'localhost' IDENTIFIED BY '2014SIEtf';
grant all on tim5.* to 'EtfSI2014'@'localhost';
CREATE SCHEMA IF NOT EXISTS `tim5` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `tim5` ;


-- -----------------------------------------------------
-- Table `tim5`.`Studenti`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Studenti` (
  `studentId` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `imeRoditelja` VARCHAR(45) NULL,
  `brojTelefona` VARCHAR(45) NULL,
  `jmbg` VARCHAR(45) NULL,
  `mjestoRodjenja` VARCHAR(45) NULL,
  `opcinaRodjenja` VARCHAR(45) NULL,
  `drzavaRodjenja` VARCHAR(45) NULL,
  `mjestoPrebivalista` VARCHAR(45) NULL,
  `opcinaPrebivalista` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  PRIMARY KEY (`studentId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim5`.`Literatura`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Literatura` (
  `literaturaId` INT NOT NULL AUTO_INCREMENT,
  `isbn` VARCHAR(45) NULL,
  `naziv` VARCHAR(45) NULL,
  `autor` VARCHAR(45) NULL,
  `kolicina` INT NULL,
  `cijena` DOUBLE NULL,
  PRIMARY KEY (`literaturaId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim5`.`Dugovi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Dugovi` (
  `dugId` INT NOT NULL AUTO_INCREMENT,
  `vrijednost` DOUBLE NULL,
  `daLiJeIzmiren` TINYINT(1) NULL,
  `tipDuga` VARCHAR(45) NULL,
  `studentId` INT NOT NULL,
  `literaturaId` INT NOT NULL,
  PRIMARY KEY (`dugId`, `studentId`, `literaturaId`),
  INDEX `fk_Dugovi_Studenti_idx` (`studentId` ASC),
  INDEX `fk_Dugovi_Literatura1_idx` (`literaturaId` ASC),
  CONSTRAINT `fk_Dugovi_Studenti`
    FOREIGN KEY (`studentId`)
    REFERENCES `tim5`.`Studenti` (`studentId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dugovi_Literatura1`
    FOREIGN KEY (`literaturaId`)
    REFERENCES `tim5`.`Literatura` (`literaturaId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim5`.`Rate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Rate` (
  `rataId` INT NOT NULL AUTO_INCREMENT,
  `vrijednost` DOUBLE NULL,
  `datumZaduzenja` DATE NULL,
  `datumRazduzenja` DATE NULL,
  `rokOtplate` DATE NULL,
  `jeLiUplacena` TINYINT(1) NULL,
  `dugId` INT NOT NULL,
  PRIMARY KEY (`rataId`, `dugId`),
  INDEX `fk_Rate_Dugovi1_idx` (`dugId` ASC),
  CONSTRAINT `fk_Rate_Dugovi1`
    FOREIGN KEY (`dugId`)
    REFERENCES `tim5`.`Dugovi` (`dugId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim5`.`Korisnici`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Korisnici` (
  `korisnikId` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NULL,
  `prezime` VARCHAR(45) NULL,
  `jmbg` VARCHAR(45) NULL,
  `adresa` VARCHAR(45) NULL,
  `mail` VARCHAR(45) NULL,
  `telefon` VARCHAR(45) NULL,
  `korisnickoIme` VARCHAR(45) NULL,
  `lozinka` VARCHAR(45) NULL,
  `tipKorisnika` VARCHAR(45) NULL,
  PRIMARY KEY (`korisnikId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tim5`.`Izvjestaji`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tim5`.`Izvjestaji` (
  `izvjestajId` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NULL,
  `sadrzaj` VARCHAR(45) NULL,
  `korisnikId` INT NOT NULL,
  PRIMARY KEY (`izvjestajId`, `korisnikId`),
  INDEX `fk_Izvjestaji_Korisnici1_idx` (`korisnikId` ASC),
  CONSTRAINT `fk_Izvjestaji_Korisnici1`
    FOREIGN KEY (`korisnikId`)
    REFERENCES `tim5`.`Korisnici` (`korisnikId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
ALTER SCHEMA `tim5`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_bin ;
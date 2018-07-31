-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Escuela9
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Escuela9
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Escuela9` DEFAULT CHARACTER SET utf8 ;
USE `Escuela9` ;

-- -----------------------------------------------------
-- Table `Escuela9`.`cursos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`cursos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`alumnos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `legajo` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `cursos_id` INT NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `telefono1` VARCHAR(45) NULL,
  `telefono2` VARCHAR(45) NULL,
  `domicilio` VARCHAR(45) NULL,
  `localidad` VARCHAR(45) NULL,
  `procedencia` VARCHAR(45) NULL,
  `observaciones` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_alumnos_cursos1_idx` (`cursos_id` ASC),
  CONSTRAINT `fk_alumnos_cursos1`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `Escuela9`.`cursos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`documentaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`documentaciones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `foto` MEDIUMBLOB NOT NULL,
  `alumnos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_documentaciones_alumnos1_idx` (`alumnos_id` ASC),
  CONSTRAINT `fk_documentaciones_alumnos1`
    FOREIGN KEY (`alumnos_id`)
    REFERENCES `Escuela9`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`docentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`docentes` (
  `id` INT ZEROFILL NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`documentacion_has_alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`documentacion_has_alumnos` (
  `documentacion_id` INT NOT NULL,
  `alumnos_id` INT NOT NULL,
  PRIMARY KEY (`documentacion_id`, `alumnos_id`),
  INDEX `fk_documentacion_has_alumnos_alumnos1_idx` (`alumnos_id` ASC),
  INDEX `fk_documentacion_has_alumnos_documentacion1_idx` (`documentacion_id` ASC),
  CONSTRAINT `fk_documentacion_has_alumnos_documentacion1`
    FOREIGN KEY (`documentacion_id`)
    REFERENCES `Escuela9`.`documentaciones` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_documentacion_has_alumnos_alumnos1`
    FOREIGN KEY (`alumnos_id`)
    REFERENCES `Escuela9`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`padres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`padres` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `apellido` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `nacionalidad` VARCHAR(45) NOT NULL,
  `ocupacion` VARCHAR(45) NULL,
  `domicilio` VARCHAR(80) NULL,
  `localidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`autorizados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`autorizados` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombreApellido` VARCHAR(45) NOT NULL,
  `parentesco` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`alumnos_has_autorizados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`alumnos_has_autorizados` (
  `alumnos_id` INT NOT NULL,
  `autorizados_id` INT NOT NULL,
  PRIMARY KEY (`alumnos_id`, `autorizados_id`),
  INDEX `fk_alumnos_has_autorizados_autorizados1_idx` (`autorizados_id` ASC),
  INDEX `fk_alumnos_has_autorizados_alumnos1_idx` (`alumnos_id` ASC),
  CONSTRAINT `fk_alumnos_has_autorizados_alumnos1`
    FOREIGN KEY (`alumnos_id`)
    REFERENCES `Escuela9`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alumnos_has_autorizados_autorizados1`
    FOREIGN KEY (`autorizados_id`)
    REFERENCES `Escuela9`.`autorizados` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`materias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`materias` (
  `idmaterias` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmaterias`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`horario_docente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`horario_docente` (
  `id_horario` INT NOT NULL AUTO_INCREMENT,
  `dia` VARCHAR(45) NOT NULL,
  `hora_inicio` TIME NOT NULL,
  `hora_fin` TIME NOT NULL,
  `cursos_id` INT NOT NULL,
  `docentes_id` INT ZEROFILL NOT NULL,
  `materias_idmaterias` INT NOT NULL,
  PRIMARY KEY (`id_horario`),
  INDEX `fk_horario_docente_cursos1_idx` (`cursos_id` ASC),
  INDEX `fk_horario_docente_docentes1_idx` (`docentes_id` ASC),
  INDEX `fk_horario_docente_materias1_idx` (`materias_idmaterias` ASC),
  CONSTRAINT `fk_horario_docente_cursos1`
    FOREIGN KEY (`cursos_id`)
    REFERENCES `Escuela9`.`cursos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_docente_docentes1`
    FOREIGN KEY (`docentes_id`)
    REFERENCES `Escuela9`.`docentes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario_docente_materias1`
    FOREIGN KEY (`materias_idmaterias`)
    REFERENCES `Escuela9`.`materias` (`idmaterias`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Escuela9`.`padres_has_alumnos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Escuela9`.`padres_has_alumnos` (
  `padres_id` INT NOT NULL,
  `alumnos_id` INT NOT NULL,
  PRIMARY KEY (`padres_id`, `alumnos_id`),
  INDEX `fk_padres_has_alumnos_alumnos1_idx` (`alumnos_id` ASC),
  INDEX `fk_padres_has_alumnos_padres1_idx` (`padres_id` ASC),
  CONSTRAINT `fk_padres_has_alumnos_padres1`
    FOREIGN KEY (`padres_id`)
    REFERENCES `Escuela9`.`padres` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_padres_has_alumnos_alumnos1`
    FOREIGN KEY (`alumnos_id`)
    REFERENCES `Escuela9`.`alumnos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

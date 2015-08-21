SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tb_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_evento` (
  `id_evento` INT NOT NULL AUTO_INCREMENT,
  `nm_evento` VARCHAR(45) NOT NULL,
  `dt_evento` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_evento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_ciclo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_ciclo` (
  `id_ciclo` INT NOT NULL AUTO_INCREMENT,
  `num_ciclo` INT NOT NULL,
  PRIMARY KEY (`id_ciclo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_turno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_turno` (
  `id_turno` INT NOT NULL AUTO_INCREMENT,
  `nm_turno` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_turno`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tb_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_pessoa` (
  `id_pessoa` INT NOT NULL AUTO_INCREMENT,
  `nm_pessoa` VARCHAR(45) NOT NULL,
  `email_pessoa` VARCHAR(45) NOT NULL,
  `dtNasc_pessoa` VARCHAR(10) NOT NULL,
  `curso_pessoa` VARCHAR(45) NOT NULL,
  `contribuicao_pessoa` VARCHAR(100),
  `turno_pessoa` VARCHAR(45) NOT NULL,
  `ciclo_pessoa` INT NOT NULL,
  `caminho_imagem` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pessoa`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nm_usuario` VARCHAR(45) NOT NULL,
  `senha_usuario` VARCHAR(45) NOT NULL,
  `email_usuario` VARCHAR(45) NOT NULL,
  `caminhoImagem_usuario` VARCHAR(250) NOT NULL,
  PRIMARY KEY (`id_usuario`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `mydb`.`tb_item_evento_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tb_item_evento_pessoa` (
  `id_item` INT NOT NULL AUTO_INCREMENT,
  `id_pessoa` INT NOT NULL,
  `id_evento` INT NOT NULL,
  PRIMARY KEY (`id_item`),
  INDEX `fk_pessoa_idx` (`id_pessoa` ASC),
  INDEX `fk_evento_idx` (`id_evento` ASC),
  CONSTRAINT `fk_pessoa`
    FOREIGN KEY (`id_pessoa`)
    REFERENCES `mydb`.`tb_pessoa` (`id_pessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_evento`
    FOREIGN KEY (`id_evento`)
    REFERENCES `mydb`.`tb_evento` (`id_evento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- INSERT INTO tb_ciclo VALUES (NULL,1),(NULL,2),(NULL,3),(NULL,4),(NULL,5),(NULL,6);
-- INSERT INTO tb_turno VALUES (NULL,'Manhã'),(NULL,'Tarde'),(NULL,'Noite');
-- INSERT INTO tb_evento VALUES (NULL, 'Hallowen', '25/07/2015');
-- INSERT INTO tb_evento VALUES (NULL, 'Teste', '23/07/2015');
-- INSERT INTO tb_evento VALUES (NULL, 'Dançando', '03/08/2016');
-- INSERT INTO tb_evento VALUES (NULL, 'Volta as Aulas', '18/07/2015');
-- INSERT INTO tb_pessoa VALUES (NULL, 'Lucas Santos', 'lucas_ss.arts@live.com', '05/03/1996', 'ADS', 'Tarde', 3, '');
-- INSERT INTO tb_pessoa VALUES (NULL, 'Vinicius', 'vinicius_furuka@hotmail.com.br', '06/09/1995', 'ADS', 'Noite', 2, '');
-- INSERT INTO tb_pessoa VALUES (NULL, 'Elizeu', 'mad.eliseu@hotmail.com', '06/09/1995', 'ADS', 'Noite', 2, '‪');
-- INSERT INTO tb_pessoa VALUES (NULL, 'Monica', 'monica_ms@hotmail.com', '01/08/1985', 'ADS', 'Noite', 2, '‪');
-- INSERT INTO tb_pessoa VALUES (NULL, 'Samuel', 'samuel_santana@hotmail.com', '24/06/1975', 'GE', 'Noite', 5, '‪');
-- INSERT INTO tb_item_evento_pessoa VALUES (null, 7, 3);
-- INSERT INTO tb_usuario VALUES (NULL, 'fatec', 'fatec', 'email', '1958561395');

-- DELETE FROM tb_usuario WHERE id_usuario = 1;
-- DELETE FROM tb_pessoa WHERE id_pessoa = 1;
-- DELETE FROM tb_evento WHERE id_evento = 1;
-- DELETE FROM tb_item_evento_pessoa WHERE id_item = 2;

SELECT * FROM tb_item_evento_pessoa;
SELECT * FROM tb_pessoa;
SELECT * FROM tb_evento;
-- SELECT * FROM tb_ciclo;
-- SELECT * FROM tb_turno;
SELECT * FROM tb_usuario;
-- DROP DATABASE mydb;
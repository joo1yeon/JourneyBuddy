-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `enjoytrip` ;

-- -----------------------------------------------------
-- Schema enjoytrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoytrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enjoytrip` ;

-- -----------------------------------------------------
-- Table `enjoytrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `enjoytrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `enjoytrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `enjoytrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `enjoytrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `enjoytrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`user` (
  `user_id` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(255) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `email_id` VARCHAR(45) NOT NULL,
  `email_domain` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `birth_date` varchar(20) NOT NULL,
  `register_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `token` VARCHAR(1000),
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`board` (
  `article_no` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NOT NULL,
  `subject` VARCHAR(45) NOT NULL,
  `content` VARCHAR(2000) NOT NULL,
  `hit` INT NULL DEFAULT '0',
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`article_no`),
  INDEX `board_to_user_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `board_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplace`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplace` (
  `hotplace_id` INT NOT NULL AUTO_INCREMENT,
  `place` VARCHAR(45) NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  `contents` VARCHAR(45) NOT NULL,
  `score` INT NOT NULL,
  `img` VARCHAR(45) NULL DEFAULT NULL,
  `start_date` TIMESTAMP NOT NULL,
  `end_date` TIMESTAMP NOT NULL,
  `hit` INT NULL DEFAULT '0',
  `rcmd_cnt` INT NULL DEFAULT '0',
  PRIMARY KEY (`hotplace_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplace_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplace_comment` (
  `hotplace_comment_id` INT NOT NULL AUTO_INCREMENT,
  `hotplace_id` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `contents` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`hotplace_comment_id`),
  INDEX `hotplace_comment_to_hotplace_hotplace_id_fk_idx` (`hotplace_id` ASC) VISIBLE,
  CONSTRAINT `hotplace_comment_to_hotplace_hotplace_id_fk`
    FOREIGN KEY (`hotplace_id`)
    REFERENCES `enjoytrip`.`hotplace` (`hotplace_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`hotplace_rcmd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`hotplace_rcmd` (
  `hotplace_rcmd_id` INT NOT NULL,
  `hotplace_id` INT NOT NULL,
  `rcmd_user` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`hotplace_rcmd_id`),
  INDEX `hotplace_rcmd_to_hotplace_hotplace_id_fk_idx` (`hotplace_id` ASC) VISIBLE,
  CONSTRAINT `hotplace_rcmd_to_hotplace_hotplace_id_fk`
    FOREIGN KEY (`hotplace_id`)
    REFERENCES `enjoytrip`.`hotplace` (`hotplace_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`sns_login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`sns_login` (
  `token` VARCHAR(45) NOT NULL,
  `service` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`token`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`trip_plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`trip_plan` (
  `trip_plan_id` INT NOT NULL AUTO_INCREMENT,
  `writer` VARCHAR(45) NOT NULL,
  `title` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`trip_plan_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoytrip`.`trip_plan_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoytrip`.`trip_plan_detail` (
  `trip_plan_detail_id` INT NOT NULL AUTO_INCREMENT,
  `plan_num` INT NOT NULL,
  `writer` VARCHAR(45) NOT NULL,
  `content_id` int NOT NULL,
  `time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `info` VARCHAR(45) NOT NULL,
  `sequence` INT NOT NULL,
  PRIMARY KEY (`trip_plan_detail_id`),
  INDEX `trip_plan_detail_to_trip_plan_plan_num_fk_idx` (`plan_num` ASC) VISIBLE,
  CONSTRAINT `trip_plan_detail_to_trip_plan_plan_num_fk`
    FOREIGN KEY (`plan_num`)
    REFERENCES `enjoytrip`.`trip_plan` (`trip_plan_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    )
ENGINE = InnoDB
AUTO_INCREMENT = 9
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- -----------------------------------------------------
-- Table `enjoytrip`.`file_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `enjoytrip`.`file_info` ;

CREATE TABLE IF NOT EXISTS `enjoytrip`.`file_info` (
  `idx` INT NOT NULL AUTO_INCREMENT,
  `user_id` VARCHAR(45) NULL,
  `save_folder` VARCHAR(45) NULL,
  `original_file` VARCHAR(50) NULL,
  `save_file` VARCHAR(50) NULL,
  PRIMARY KEY (`idx`),
  CONSTRAINT `file_info_to_user_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoytrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

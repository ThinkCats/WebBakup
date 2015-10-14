CREATE SCHEMA `thinkdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;


CREATE TABLE `thinkweb`.`th_user` (
  `uid` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `user_name` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `user_type` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`uid`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE `thinkweb`.`th_role` (
  `rold_id` BIGINT(20) NOT NULL COMMENT '',
  `role_name` VARCHAR(45) NULL COMMENT '',
  `description` VARCHAR(100) NULL COMMENT '',
  PRIMARY KEY (`rold_id`)  COMMENT '');

CREATE TABLE `thinkweb`.`th_auth` (
  `auth_id` BIGINT(20) NOT NULL COMMENT '',
  `name` VARCHAR(45) NULL COMMENT '',
  `url` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`auth_id`)  COMMENT '');

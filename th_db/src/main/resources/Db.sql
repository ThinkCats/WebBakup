

CREATE TABLE `thinkweb`.`th_user` (
  `uid` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `user_name` VARCHAR(45) NULL COMMENT '',
  `password` VARCHAR(45) NULL COMMENT '',
  `user_type` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`uid`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

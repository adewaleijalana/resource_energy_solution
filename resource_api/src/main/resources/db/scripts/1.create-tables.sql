CREATE TABLE video
( id VARCHAR(40) NOT NULL ,
  title VARCHAR(255) NOT NULL ,
  video_type VARCHAR(15) NOT NULL ,
  genre VARCHAR(15) NOT NULL ,
  maximum_age INT(5) NULL ,
  year_released VARCHAR(4) NULL ,
  last_modified_date DATETIME NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(50) NOT NULL ,
  last_modified_by VARCHAR(50) NULL ,
  version BIGINT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;


CREATE TABLE renting_rate
( id VARCHAR(40) NOT NULL ,
  video_type VARCHAR(20) NOT NULL ,
  rate DECIMAL(18) NOT NULL ,
  last_modified_date DATETIME NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(40) NOT NULL ,
  last_modified_by VARCHAR(40) NULL ,
  version BIGINT(5) NOT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;


CREATE TABLE renting_history
( id VARCHAR(40) NOT NULL ,
  video_title VARCHAR(255) NOT NULL ,
  username VARCHAR(255) NOT NULL ,
  number_of_days INT(15) NOT NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(255) NOT NULL ,
  last_modified_by VARCHAR(255) NULL ,
  last_modified_date DATETIME NULL ,
  version BIGINT(5) NOT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;

ALTER TABLE renting_history ADD renting_fee DECIMAL(20,2) NOT NULL AFTER number_of_days;

CREATE TABLE app_user
( id VARCHAR(40) NOT NULL ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL ,
  last_modified_date DATETIME NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(255) NOT NULL ,
  last_modified_by VARCHAR(40) NULL ,
  version BIGINT(5) NOT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;

CREATE TABLE app_role
( id VARCHAR(40) NOT NULL ,
  name VARCHAR(255) NOT NULL ,
  last_modified_date DATETIME NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(40) NOT NULL ,
  last_modified_by VARCHAR(40) NULL ,
  version BIGINT(5) NOT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;

CREATE TABLE app_user_roles
( id VARCHAR(40) NOT NULL ,
  app_user_id VARCHAR(40) NOT NULL ,
  app_role_id VARCHAR(40) NOT NULL ,
  last_modified_date DATETIME NULL ,
  created_date DATETIME NULL ,
  created_by VARCHAR(40) NOT NULL ,
  last_modified_by VARCHAR(40) NULL ,
  version BIGINT(5) NOT NULL ,
  PRIMARY KEY (id(40))) ENGINE = InnoDB;
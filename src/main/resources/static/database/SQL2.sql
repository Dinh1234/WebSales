use teamwork;
ALTER TABLE `teamwork`.`app_user` 
ADD COLUMN `DEL_FLAG` Varchar(1) NOT NULL AFTER `Locale`,
ADD COLUMN `CREATE_USER` Varchar(50) NOT NULL AFTER `DEL_FLAG`,
ADD COLUMN `CREATE_PROGRAM` Varchar(50) NOT NULL AFTER `CREATE_USER`,
ADD COLUMN `CREATE_DATE` Datetime NOT NULL AFTER `CREATE_PROGRAM`,
ADD COLUMN `UPDATE_USER` Varchar(50) NOT NULL AFTER `CREATE_DATE`,
ADD COLUMN `UPDATE_PROGRAM` Varchar(50) NOT NULL AFTER `UPDATE_USER`,
ADD COLUMN `UPDATE_DATE` Datetime NOT NULL AFTER `UPDATE_PROGRAM`;

ALTER TABLE `teamwork`.`user_role` 
ADD COLUMN `DEL_FLAG` Varchar(1) NOT NULL AFTER `ROLE_ID`,
ADD COLUMN `CREATE_USER` Varchar(50) NOT NULL AFTER `DEL_FLAG`,
ADD COLUMN `CREATE_PROGRAM` Varchar(50) NOT NULL AFTER `CREATE_USER`,
ADD COLUMN `CREATE_DATE` Datetime NOT NULL AFTER `CREATE_PROGRAM`,
ADD COLUMN `UPDATE_USER` Varchar(50) NOT NULL AFTER `CREATE_DATE`,
ADD COLUMN `UPDATE_PROGRAM` Varchar(50) NOT NULL AFTER `UPDATE_USER`,
ADD COLUMN `UPDATE_DATE` Datetime NOT NULL AFTER `UPDATE_PROGRAM`;

ALTER TABLE `teamwork`.`app_role` 
ADD COLUMN `DEL_FLAG` Varchar(1) NOT NULL AFTER `ROLE_NAME`,
ADD COLUMN `CREATE_USER` Varchar(50) NOT NULL AFTER `DEL_FLAG`,
ADD COLUMN `CREATE_PROGRAM` Varchar(50) NOT NULL AFTER `CREATE_USER`,
ADD COLUMN `CREATE_DATE` Datetime NOT NULL AFTER `CREATE_PROGRAM`,
ADD COLUMN `UPDATE_USER` Varchar(50) NOT NULL AFTER `CREATE_DATE`,
ADD COLUMN `UPDATE_PROGRAM` Varchar(50) NOT NULL AFTER `UPDATE_USER`,
ADD COLUMN `UPDATE_DATE` Datetime NOT NULL AFTER `UPDATE_PROGRAM`;


CREATE TABLE `teamwork`.`CATEGORY` (
	`ID` varchar(20) NOT NULL,
	`NAME` varchar(50)  NULL ,
	`KEY` varchar(10) NOT NULL,
	`VALUE` varchar(50) NOT NULL,
	`ORDER` int  NULL,
	`DEL_FLAG` Varchar(1) NOT NULL,
	`CREATE_USER` varchar(50)  NOT NULL,
	`CREATE_PROGRAM` varchar(50)  NOT NULL,
	`CREATE_DATE` Datetime NOT NULL,
	`UPDATE_USER` varchar(50)  NOT NULL,
	`UPDATE_PROGRAM` varchar(50)  NOT NULL,
	`UPDATE_DATE` Datetime NOT NULL,
	PRIMARY KEY (`ID`, `KEY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teamwork`.`SUBJECT` (  
	`ID` varchar(20) NOT NULL,
	`NAME` varchar(50)  NOT NULL ,
	`DEL_FLAG` Varchar(1) NOT NULL,
	`CREATE_USER` varchar(50)  NOT NULL,
	`CREATE_PROGRAM` varchar(50)  NOT NULL,
	`CREATE_DATE` Datetime NOT NULL,
	`UPDATE_USER` varchar(50)  NOT NULL,
	`UPDATE_PROGRAM` varchar(50)  NOT NULL,
	`UPDATE_DATE` Datetime NOT NULL,
PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teamwork`.`QUESTION_BASIC` (  
	`ID` varchar(20) NOT NULL,
	`SUBJECT_ID` varchar(20) NOT NULL ,
    `TIME_START_EXAM` varchar(16) NOT NULL COMMENT 'yyyy/MM/dd HH:mm',
	`TIME_OVER_EXAM` varchar(3)  NOT NULL COMMENT '15,30,45,60,120,...',
    `DEL_FLAG` Varchar(1) NOT NULL,
	`CREATE_USER` varchar(50)  NOT NULL,
	`CREATE_PROGRAM` varchar(50)  NOT NULL,
	`CREATE_DATE` Datetime NOT NULL,
	`UPDATE_USER` varchar(50)  NOT NULL,
	`UPDATE_PROGRAM` varchar(50)  NOT NULL,
	`UPDATE_DATE` Datetime NOT NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `fk_subject1` FOREIGN KEY (`SUBJECT_ID`) REFERENCES `SUBJECT` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `teamwork`.`QUESTION_DETAIL` (  
	`ID` varchar(20) NOT NULL,
	`QUESTION_ID` varchar(20) NOT NULL ,
    `ID_REFERENCE` varchar(20) NULL COMMENT 'refer question',
	`TYPE` varchar(10) NULL,
    `QUESTION` TEXT(2000) NULL,
	`AWSER` varchar(50) NULL,
    `DEL_FLAG` Varchar(1) NOT NULL,
	`CREATE_USER` varchar(50)  NOT NULL,
	`CREATE_PROGRAM` varchar(50)  NOT NULL,
	`CREATE_DATE` Datetime NOT NULL,
	`UPDATE_USER` varchar(50)  NOT NULL,
	`UPDATE_PROGRAM` varchar(50)  NOT NULL,
	`UPDATE_DATE` Datetime NOT NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `fk_question_detail1` FOREIGN KEY (`QUESTION_ID`) REFERENCES `QUESTION_BASIC` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
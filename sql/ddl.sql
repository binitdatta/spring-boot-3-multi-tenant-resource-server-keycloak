
create database ROLLINGSTONE_2023;

CREATE TABLE `ROLLINGSTONE_USER` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `SEX` varchar(1) NOT NULL,
  `MEMBER_TYPE` varchar(100) NOT NULL,
  `ACCOUNT_NUMBER` varchar(100) NOT NULL,
  `REGISTRATION_DATE` date NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

INSERT INTO `ROLLINGSTONE_USER`
(
`first_name`,
`last_name`,
`member_type`,
`registration_date`,
`sex`,
`user_name`,
`account_number`)
VALUES
(
'Steve',
'Smith',
'G',
'2015-01-01',
'M',
'mhitter',
'10001');

DROP TABLE ROLLINGSTONE_CUSTOMER_MASTER

CREATE TABLE `ROLLINGSTONE_CUSTOMER_MASTER` (
  `CUSTOMER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CUSTOMER_NO` varchar(100) NOT NULL,
  `FIRST_NAME` varchar(100) NOT NULL,
  `MIDDLE_NAME` varchar(100) NOT NULL,
  `LAST_NAME` varchar(100) NOT NULL,
  `DATE_OF_BIRTH` DATETIME NOT NULL,
  `DATE_OF_JOINING` DATETIME NOT NULL,
  `LOYALTY_POINTS` DECIMAL(12,2) NOT NULL,
  `LOYALTY_STATUS` varchar(100) NOT NULL,
   USER_PROFILE_ID BIGINT(20) NOT NULL,
  `CREATED_BY` varchar(100) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_BY` varchar(100) NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`CUSTOMER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `ROLLINGSTONE_CUSTOMER_ADDRESS` (
  `ADDRESS_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `HOUSE_NUMBER` varchar(100) NOT NULL,
  `STREET` varchar(100) NOT NULL,
  `CITY` varchar(100) NOT NULL,
  `STATE` varchar(100) NOT NULL,
   `ZIP` varchar(100) NOT NULL,
  `HOME_PHONE` varchar(100) NOT NULL,
  `MOBILE_PHONE` varchar(100) NOT NULL,
  `EMAIL` varchar(100) NOT NULL,
  `CUSTOMER_ID` BIGINT(20) NOT NULL,
  `CREATED_BY` varchar(100) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_BY` varchar(100) NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`ADDRESS_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


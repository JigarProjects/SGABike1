create table BIKE ( ID INTEGER NOT NULL AUTO_INCREMENT,
					          NAME varchar(100) NOT NULL,
					          DESCRIPTION varchar(100),
                    PRIMARY KEY (id) );

CREATE table USER (
  USERID INTEGER NOT NULL AUTO_INCREMENT,
  NAME varchar(250) NOT NULL,
  ID INT(10)
);
//ID CAN STORE UPTO 4294967295 records.
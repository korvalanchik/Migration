CREATE TABLE worker(ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    NAME varchar(1000) NOT NULL,
                    BIRTHDAY date,
                    LEVEL ENUM ('Trainee', 'Junior', 'Middle', 'Senior') NOT NULL,
                    SALARY int,
                    CONSTRAINT CHK_worker CHECK (CHAR_LENGTH(NAME)>=2 AND BIRTHDAY>'1900-01-01' AND SALARY>=100 AND SALARY<=100000));

CREATE TABLE client(ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                    NAME varchar(1000) NOT NULL,
                    CONSTRAINT CHK_client CHECK (CHAR_LENGTH(NAME)>=2));

CREATE TABLE project(ID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
                     CLIENT_ID int,
                     START_DATE date,
                     FINISH_DATE date);

CREATE TABLE project_worker(PROJECT_ID int NOT NULL,
                            WORKER_ID int NOT NULL, PRIMARY KEY(PROJECT_ID, WORKER_ID));

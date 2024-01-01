INSERT INTO client ( `NAME` )
VALUES
	( 'Kolya' ),
	( 'Sirozha' ),
	( 'Vasya' ),
	( 'Kolya S.' ),
	( 'Sirozha' ),
	( 'Vasya P.' ),
	( 'Dima' ),
	( 'Grisha' ),
	( 'Natasha' ),
	( 'Kiryusha' ),
	( 'Tanya' );
	
INSERT INTO worker ( `NAME`, `BIRTHDAY`, `LEVEL`, `SALARY` )
VALUES
	( 'Vasily Andreevich', '1993-07-05', 'Junior', 770 ),
	( 'Piotr Grigorovich', '1969-02-12', 'Junior', 800 ),
	( 'Aleksiy Semenovich', '1963-11-02', 'Junior', 850 ),
	( 'Masha', '2001-12-03', 'Trainee', 300 ),
	( 'Petya', '1992-07-05', 'Trainee', 150 ),
	( 'Sasha', '2001-12-03', 'Trainee', 270 ),
	( 'Valerii Petrovich', '2000-02-29', 'Trainee', 350 ),
	( 'Simon Vasilyovich ', '1979-05-22', 'Middle', 1400 ),
	( 'Stepan Andriyovich', '1909-01-01', 'Middle', 1450 ),
	( 'Mihaylo Sergiyovich', '1966-09-17', 'Middle', 1860 ),
	( 'Taras Grigorovuich', '1914-03-09', 'Senior', 2200 ),
	( 'Volodimir Oleksandrovich', '1978-01-25', 'Senior', 2200 );	

INSERT INTO project ( CLIENT_ID, START_DATE, FINISH_DATE )
VALUES
	( 1, '2004-04-03', '2004-07-03' ),
	( 2, '2004-01-06', '2004-05-10' ),
	( 3, '2004-10-11', '2004-12-31' ),
	( 4, '2004-12-13', '2005-12-31' ),
	( 1, '2006-01-04', '2006-10-01' ),
	( 5, '2008-11-22', '2016-12-22' ),
	( 6, '2009-09-17', '2012-02-10' ),
	( 7, '2009-06-18', '2009-07-19' ),
	( 8, '2009-08-30', '2010-08-01' ),
	( 3, '2010-01-01', '2013-01-02' ),
	( 9, '2010-02-03', '2011-02-03' ),
	( 4, '2012-01-06', '2016-01-31' ),
	( 11, '2014-05-13', '2014-12-10' ),
	( 10, '2014-05-19', '2014-10-10' ),
	( 1, '2016-11-03', '2020-10-30' ),
	( 3, '2001-01-01', '2009-02-02' ),
	( 5, '2016-03-20', '2018-07-01' );
	
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 1, 9 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 2, 6 ),
	( 2, 7 ),
	( 2, 10 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 3, 7 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 4, 4 ),
	( 4, 5 ),
	( 4, 8 ),
	( 4, 12 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 5, 1 ),
	( 5, 3 ),
	( 5, 9 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 6, 4 ),
	( 6, 5 ),
	( 6, 10 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 7, 6 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 8, 2 ),
	( 8, 3 ),
	( 8, 8 ),
	( 8, 12 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 9, 5 ),
	( 9, 7 ),
	( 9, 8 ),
	( 9, 10 ),
	( 9, 12 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 10, 2 ),
	( 10, 3 ),
	( 10, 11 ),
	( 10, 4 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 11, 6 ),
	( 11, 7 ),
	( 11, 9 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 12, 1 ),
	( 12, 2 ),
	( 12, 4 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 13, 9 ),
	( 13, 10 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 14, 8 ),
	( 14, 6 ),
	( 14, 11 ),
	( 14, 12 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 15, 1 ),
	( 15, 4 ),
	( 15, 11 );
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 16, 5 ),
	( 16, 10 );
	
INSERT INTO project_worker ( PROJECT_ID, WORKER_ID )
VALUES
	( 17, 2 ),
	( 17, 4 ),
	( 17, 6 ),
	( 17, 8 ),
	( 17, 12 );
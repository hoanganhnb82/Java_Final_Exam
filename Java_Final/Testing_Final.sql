Create DATABASE FinalTestingJava;

use FinalTestingJava;



CREATE TABLE Project (
    ProjectID INT UNSIGNED,
    TeamSize INT NOT NULL,
    IDManager TINYINT UNSIGNED,
    IDEmployee TINYINT UNSIGNED,
    FOREIGN KEY(IDManager) REFERENCES Manager(IDManager),
    FOREIGN KEY(IDEmployee) REFERENCES Employee(IDEmployee),
    PRIMARY KEY(ProjectID,IDManager,IDEmployee)
);

CREATE TABLE Employee (
    IDEmployee TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    EmpName VARCHAR(50) UNIQUE KEY NOT NULL,
    EmEmail VARCHAR(50) UNIQUE KEY NOT NULL,
    EmPassword VARCHAR(50) NOT NULL CHECK (LENGTH(`EmPassword`) >= 6),
    EmRole ENUM('Employee', 'Manager'),
    ProjectID INT UNSIGNED REFERENCES Project(ProjectID),
    ProSkill VARCHAR(50) NOT NULL
);

CREATE TABLE Manager(
	IDManager		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	ManName 		VARCHAR(50) UNIQUE KEY NOT NULL,
	ManEmail 		VARCHAR(50) UNIQUE KEY NOT NULL,
    ManPassword		VARCHAR(50) NOT NULL CHECK(length(`ManPassword`) >= 6),
    ManRole			ENUM('Employee', 'Manager'),
    ExpInYear INT
);


/*============================== INSERT DATABASE =======================================*/
/*======================================================================================*/
INSERT INTO Project  ( ProjectID,	TeamSize,	 IDManager,			IDEmployee	) 
VALUES
					(1,		3,				1,				1),
                    (1,		4,				1,				3),
                    (1,		4,				1,				5),
                    (2,		2,				2,				2),
                    (2,		4,				2,				4);

INSERT INTO Employee  ( EmpName, 			EmEmail,				 EmPassword,	 EmRole		,		ProjectID,	ProSkill	) 
VALUES
					('Nguyen Thi My',	'mynt2407@gmail.com', 'Mynguyen123',		'Employee',			1,       "DEV"	),
					('Nguyen Ngoc Duy',	'duynn03@gmail.com', 'duyNguyen',			'Employee',			2,       "DESIGN"	),
                    ('Nguyen Hung Manh','hungmanh@gmail.com', 'hunGmanh1',			'Employee',			1,       "DESIGN"	),
                    ('Tong Thi Nhung',	'nhung@gmail.com', 		'nhungtOng',		'Employee'	,			2,       "DEV"),
                    ('Tran Thi Kim Anh','kimoanh.tran@gmail.com', 'tran.kim',		'Employee'	,			1,       "DEV");

INSERT INTO Manager  ( ManName, 			ManEmail,				 ManPassword,			ManRole,		ExpInYear	) 
VALUES
					('Nguyen Thi Hanh',	'hanh.nt@gmail.com', 'Mynguyen123',		'Manager',			3),
					('Nguyen Hoang Anh','anh.nhh@gmail.com', 'duyNguyen',		'Manager',			2	);
                    

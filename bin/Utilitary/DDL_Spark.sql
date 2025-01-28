-- database: ../../database/MathSpark.sqlite
DROP TABLE IF EXISTS Grades_activity_game1;
DROP TABLE IF EXISTS Grades_activity_game2;
DROP TABLE IF EXISTS Game2;
DROP TABLE IF EXISTS Game1;
DROP TABLE IF EXISTS Activity;
DROP TABLE IF EXISTS Student_course;
DROP TABLE IF EXISTS Course;            
DROP TABLE IF EXISTS Institution;   
DROP TABLE IF EXISTS Persona;        
DROP TABLE IF EXISTS Permission_role;
DROP TABLE IF EXISTS Role;          
DROP TABLE IF EXISTS Permission;     
DROP TABLE IF EXISTS Catalog;
DROP TABLE IF EXISTS Catalog_level;

CREATE TABLE IF NOT EXISTS
    Persona (
        id_person INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        last_name TEXT NOT NULL,
        DNI VARCHAR(10) UNIQUE NOT NULL,
        email TEXT NOT NULL,
        password TEXT NOT NULL,
        birthdate DATE,
        id_role INTEGER NOT NULL REFERENCES Role (id_role),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_DNI ON Persona (DNI);

CREATE INDEX indx_id_ ON Persona (id_person);

CREATE TABLE IF NOT EXISTS
    Role (
        id_role INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_role ON Role (id_role);

CREATE TABLE IF NOT EXISTS
    Institution (
        id_institution INTEGER PRIMARY KEY AUTOINCREMENT,
        id_manager INTEGER NOT NULL REFERENCES Persona (id_person),
        name TEXT NOT NULL,
        amie VARCHAR(8) UNIQUE NOT NULL,
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_institution ON Institution (id_institution);

CREATE INDEX indx_amie ON Institution (amie);

CREATE TABLE IF NOT EXISTS
    Permission_role (
        id_permission_role INTEGER PRIMARY KEY AUTOINCREMENT,
        id_role INTEGER NOT NULL REFERENCES Role (id_role),
        id_permission INTEGER NOT NULL REFERENCES Permission (id_permission),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_permission_role ON Permission_role (id_permission_role);

CREATE TABLE IF NOT EXISTS
    Permission (
        id_permission INTEGER PRIMARY KEY AUTOINCREMENT,
        name VARCHAR(30) NOT NULL,
        description TEXT NOT NULL,
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_permission ON Permission (id_permission);

CREATE TABLE IF NOT EXISTS
    Course (
        id_course INTEGER PRIMARY KEY AUTOINCREMENT,
        id_teacher INTEGER NOT NULL REFERENCES Persona (id_person),
        id_catalog_level INTEGER NOT NULL REFERENCES Catalog (id_catalog),
        id_catalog_parallel INTEGER NOT NULL REFERENCES Catalog (id_catalog),
        id_institution INTEGER NOT NULL REFERENCES Institution (id_institution),
        id_catalog_time INTEGER NOT NULL REFERENCES Catalog (id_catalog),
        id_catalog_period INTEGER NOT NULL REFERENCES Catalog (id_catalog),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_course ON Course (id_course);

CREATE TABLE IF NOT EXISTS
    Activity (
        id_activity INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        id_course INTEGER NOT NULL REFERENCES Course (id_course),
        id_catalog_activity_type INTEGER NOT NULL REFERENCES Catalog (id_catalog),
        description TEXT NOT NULL,
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_activity ON Activity (id_activity);

CREATE TABLE IF NOT EXISTS
    Student_course (
        id_student_course INTEGER PRIMARY KEY AUTOINCREMENT,
        id_student INTEGER NOT NULL REFERENCES Persona (id_person),
        id_course INTEGER NOT NULL REFERENCES Course (id_course),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_student_course ON Student_course (id_student_course);

CREATE TABLE IF NOT EXISTS
    Catalog_level (
        id_catalog_level INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT NOT NULL,
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_catalog_level ON Catalog_level (id_catalog_level);

CREATE TABLE IF NOT EXISTS
    Catalog (
        id_catalog INTEGER PRIMARY KEY AUTOINCREMENT,
        name VARCHAR(50) NOT NULL,
        id_catalog_level INTEGER REFERENCES Catalog_level(id_catalog_level),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE INDEX indx_id_catalog ON Catalog (id_catalog);

CREATE TABLE IF NOT EXISTS
    Grades_activity_game1 (
        id_grade_activity_game1 INTEGER PRIMARY KEY AUTOINCREMENT,
        id_Student_course INTEGER NOT NULL REFERENCES Student_course (id_student_course),
        answer1 TEXT NOT NULL,
        id_game1 INTEGER NOT NULL REFERENCES Game1 (id_game1),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );

CREATE TABLE IF NOT EXISTS
    Grades_activity_game2 (
        id_grade_activity_game2 INTEGER PRIMARY KEY AUTOINCREMENT,
        id_Student_course INTEGER NOT NULL REFERENCES Student_course (id_student_course),
        answer1 TEXT NOT NULL,
        id_game2 INTEGER NOT NULL REFERENCES Game2 (id_game2),
        state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
        date_created DATETIME DEFAULT (datetime('now', 'localtime')),
        date_updated DATETIME
    );
CREATE TABLE IF NOT EXISTS Game1 (
    id_game1 INTEGER PRIMARY KEY AUTOINCREMENT,
    question TEXT NOT NULL,
    answer1 TEXT NOT NULL,
    answer2 TEXT NOT NULL,
    correct_answer TEXT NOT NULL,
    state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
    date_created DATETIME DEFAULT (datetime('now', 'localtime')),
    date_updated DATETIME
);
CREATE TABLE IF NOT EXISTS Game2 (
    id_game2 INTEGER PRIMARY KEY AUTOINCREMENT,
    question TEXT NOT NULL,
    answer1 TEXT NOT NULL,
    answer2 TEXT NOT NULL,
    answer3 TEXT NOT NULL,
    correct_answer TEXT NOT NULL,
    state INTEGER DEFAULT 1 CONSTRAINT states CHECK (state IN (0, 1)),
    date_created DATETIME DEFAULT (datetime('now', 'localtime')),
    date_updated DATETIME
);
SELECT
                    p.id_person, 
                    p.name, 
                    p.last_name, 
                    p.DNI, 
                    p.email, 
                    p.password, 
                    p.id_role,
                    r.name,  
                    p.state 
                    FROM  vw_persona p 
                    JOIN Role r ON p.id_role=r.id_role 
                    WHERE p.state= 1 AND p.DNI = "112";
SELECT p.id_person, p.name, p.last_name, p.DNI, p.email, p.password, p.id_role,r.name, p.state FROM  vw_persona p JOIN Role r ON p.id_role=r.id_role WHERE p.state= 1 AND p.DNI = 1255553;
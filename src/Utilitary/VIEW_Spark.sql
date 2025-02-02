-- database: ../../database/MathSpark.sqlite
DROP VIEW vw_persona;
CREATE VIEW vw_persona AS
SELECT 
    p.id_person,
    p.name,
    p.last_name,
    p.DNI,
    p.email,
    p.password
    p.id_role,
    r.name,
    p.state,
    p.date_created,
    p.date_updated
FROM 
    Persona p
    JOIN Role r ON p.id_role = r.id_role;

CREATE VIEW vw_role AS
SELECT 
    r.id_role,
    r.name AS role_name,
    r.state,
    COUNT(pr.id_permission_role) AS permission_count,
    r.date_created,
    r.date_updated
FROM 
    Role r
    LEFT JOIN Permission_role pr ON r.id_role = pr.id_role
GROUP BY 
    r.id_role, r.name, r.state, r.date_created, r.date_updated;

CREATE VIEW vw_permission_role AS
SELECT 
    pr.id_permission_role,
    r.name AS role_name,
    p.name AS permission_name,
    p.description,
    pr.state,
    pr.date_created,
    pr.date_updated
FROM 
    Permission_role pr
    JOIN Role r ON pr.id_role = r.id_role
    JOIN Permission p ON pr.id_permission = p.id_permission;

CREATE VIEW vw_institution AS
SELECT 
    i.id_institution,
    i.name AS institution_name,
    i.amie,
    CONCAT(p.name, ' ', p.last_name) AS manager_name,
    i.state,
    i.date_created,
    i.date_updated
FROM 
    Institution i
    JOIN Persona p ON i.id_manager = p.id_person;

CREATE VIEW vw_course AS
SELECT 
    c.id_course,
    CONCAT(p.name, ' ', p.last_name) AS teacher_name,
    inst.name AS institution_name,
    cat_lvl.name AS grade_level,
    cat_par.name AS parallel,
    cat_time.name AS schedule,
    cat_period.name AS period,
    c.state,
    c.date_created,
    c.date_updated
FROM 
    Course c
    JOIN Persona p ON c.id_teacher = p.id_person
    JOIN Institution inst ON c.id_institution = inst.id_institution
    JOIN Catalog cat_lvl ON c.id_catalog_level = cat_lvl.id_catalog
    JOIN Catalog cat_par ON c.id_catalog_parallel = cat_par.id_catalog
    JOIN Catalog cat_time ON c.id_catalog_time = cat_time.id_catalog
    JOIN Catalog cat_period ON c.id_catalog_period = cat_period.id_catalog;

CREATE VIEW vw_activity AS
SELECT 
    a.id_activity,
    a.name AS activity_name,
    c.id_course,
    inst.name AS institution_name,
    cat.name AS activity_type,
    a.description,
    a.state,
    a.date_created,
    a.date_updated
FROM 
    Activity a
    JOIN Course c ON a.id_course = c.id_course
    JOIN Institution inst ON c.id_institution = inst.id_institution
    JOIN Catalog cat ON a.id_catalog_activity_type = cat.id_catalog;

CREATE VIEW vw_student_course AS
SELECT 
    sc.id_student_course,
    CONCAT(p.name, ' ', p.last_name) AS student_name,
    c.id_course,
    inst.name AS institution_name,
    sc.state,
    sc.date_created,
    sc.date_updated
FROM 
    Student_course sc
    JOIN Persona p ON sc.id_student = p.id_person
    JOIN Course c ON sc.id_course = c.id_course
    JOIN Institution inst ON c.id_institution = inst.id_institution;

CREATE VIEW vw_grades_activity_game1 AS
SELECT 
    gag1.id_grade_activity_game1,
    CONCAT(p.name, ' ', p.last_name) AS student_name,
    g1.question,
    g1.answer1 AS option1,
    g1.answer2 AS option2,
    g1.correct_answer,
    gag1.answer1 AS student_answer,
    CASE 
        WHEN gag1.answer1 = g1.correct_answer THEN 'Correct'
        ELSE 'Incorrect'
    END AS result,
    gag1.date_created,
    gag1.date_updated
FROM 
    Grades_activity_game1 gag1
    JOIN Student_course sc ON gag1.id_student_course = sc.id_student_course
    JOIN Persona p ON sc.id_student = p.id_person
    JOIN Game1 g1 ON gag1.id_game1 = g1.id_game1;

CREATE VIEW vw_grades_activity_game2 AS
SELECT 
    gag2.id_grade_activity_game2,
    CONCAT(p.name, ' ', p.last_name) AS student_name,
    g2.question,
    g2.answer1 AS option1,
    g2.answer2 AS option2,
    g2.answer3 AS option3,
    g2.correct_answer,
    gag2.answer1 AS student_answer,
    CASE 
        WHEN gag2.answer1 = g2.correct_answer THEN 'Correct'
        ELSE 'Incorrect'
    END AS result,
    gag2.date_created,
    gag2.date_updated
FROM 
    Grades_activity_game2 gag2
    JOIN Student_course sc ON gag2.id_student_course = sc.id_student_course
    JOIN Persona p ON sc.id_student = p.id_person
    JOIN Game2 g2 ON gag2.id_game2 = g2.id_game2;


CREATE VIEW vw_catalog AS
SELECT 
    c.id_catalog,
    c.name AS catalog_name,
    cl.id_catalog_level,
    cl.name AS catalog_level_name,
    c.state AS catalog_state,
    c.date_created AS catalog_date_created,
    c.date_updated AS catalog_date_updated,
    cl.state AS catalog_level_state,
    cl.date_created AS catalog_level_date_created,
    cl.date_updated AS catalog_level_date_updated
FROM 
    Catalog c
    LEFT JOIN Catalog_level cl ON c.id_catalog_level = cl.id_catalog_level;


CREATE VIEW vw_catalog_level AS
SELECT 
    id_catalog_level,
    name AS catalog_level_name,
    state AS catalog_level_state,
    date_created AS catalog_level_date_created,
    date_updated AS catalog_level_date_updated
FROM 
    Catalog_level;




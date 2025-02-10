-- database: ../../database/MathSpark.sqlite
DROP VIEW vw_persona;
CREATE VIEW vw_persona AS
SELECT 
    p.id_person,
    p.name,
    p.last_name,
    p.DNI,
    p.email,
    p.password,
    p.id_role,
    r.name,
    p.state,
    p.date_created,
    p.date_updated
FROM 
    Persona p
    JOIN Role r ON p.id_role = r.id_role;


DROP VIEW vw_role;
CREATE VIEW vw_role AS
SELECT 
    r.id_role AS ID,
    r.name AS Role,
    COUNT(pr.id_permission_role) AS permission_count
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



CREATE VIEW vw_catalog_level AS
SELECT 
    id_catalog_level AS ID,
    name AS NOMBRE,
    state AS catalog_level_state,
    date_created AS catalog_level_date_created,
    date_updated AS catalog_level_date_updated
FROM 
    Catalog_level;


DROP VIEW vw_persona;

PRAGMA table_info(vw_catalog);
 
--view terminada
DROP VIEW vw_docente;
CREATE VIEW vw_docente AS
SELECT
    c.id_course AS ID,
    CONCAT(p.name, ' ' , p.last_name) AS PROFESOR,
    ins.name AS INSTITUCION,
    ins.amie AS AMIE,
    cat_per.name AS PERIODO,
    cat_t.name AS JORNADA,
    CONCAT(cat_l.name,' ', cat_p.name) AS CURSO
FROM
    Course c
    JOIN Persona p ON c.id_teacher = p.id_person
    JOIN Institution ins ON c.id_institution = ins.id_institution
    JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog
    JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog
    JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog
    JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog;



/*
    VISTA RECTORES DESDE LA PERSPECTIVA DEL ADMINISTRADOR
    ID_ADMINISTRADOR CON REFERENICA DE PERSONA

    --ID, INSTITUTION, NOMBRE DEL RECTOR, JORNADA 
*/

DROP VIEW vw_rectores;

CREATE VIEW vw_rectores AS
SELECT 
    p.id_person AS ID,
    CONCAT(p.name,' ', p.last_name ) AS RECTOR,
    p.DNI AS CEDULA,
    p.email AS CORREO,
    i.name AS INSTITUCION,
    i.amie AS AMIE
    -- c.id_catalog_period AS periodo,  
    -- c.id_catalog_time AS jornada    
FROM 
    Persona p
    JOIN Role r ON p.id_role = r.id_role
    JOIN Institution_manage im ON p.id_person = im.id_manager
    JOIN Institution i ON im.id_institution = i.id_institution
    --LEFT JOIN Course c ON c.id_institution = i.id_institution  
WHERE r.name = 'Rector' AND p.state = 1;


--vista para los roles
DROP VIEW vw_roles;
CREATE VIEW vw_roles AS
SELECT 
    r.id_role AS id_rol,
    r.name AS nombre_rol,
    r.id_hierarchy AS jerarquia
FROM 
    Role r
WHERE 
    r.state = 1;  -- Asegúrate de que solo tomas roles activos



-- PERMISOS VISTA
DROP VIEW vw_permisos;
CREATE VIEW vw_permisos AS
SELECT 
    p.id_permission AS ID,
    p.name AS PERMISO,
    p.description AS DESCRIPCION,
    p.name_method AS METODO
FROM 
    Permission p
WHERE 
    p.state = 1;  -- Solo permisos activos



--PERMISOS ROLES

DROP VIEW vw_permiso_rol;
CREATE VIEW vw_permiso_rol AS
SELECT 
    pr.id_permission_role AS ID,
    r.name AS ROL,
    p.name AS PERMISO
FROM 
    Permission_role pr
    JOIN Role r ON pr.id_role = r.id_role  -- Relaciona con la tabla Role para obtener el nombre del rol
    JOIN Permission p ON pr.id_permission = p.id_permission  -- Relaciona con la tabla Permission para obtener el nombre del permiso
WHERE 
    pr.state = 1;  -- Solo asociaciones activas




-- tabla estudiantes
DROP VIEW IF EXISTS vw_estudiante;
CREATE VIEW vw_estudiante AS
SELECT
    sc.id_student_course AS ID,
    CONCAT(p.name, ' ', p.last_name) AS ESTUDIANTE,
    p.DNI AS CEDULA,
    p.email AS CORREO,
    i.name AS INSTITUCION,
    i.amie AS AMIE,
    cat_per.name AS PERIODO,
    cat_t.name AS JORNADA,
    CONCAT(cat_l.name, ' ', cat_p.name) AS CURSO,
     CONCAT(prof.name, ' ', prof.last_name) AS PROFESOR,
    sc.state AS ESTADO
FROM
    Student_course sc
    JOIN Persona p ON sc.id_student = p.id_person
    JOIN Course c ON sc.id_course = c.id_course
    JOIN Institution i ON c.id_institution = i.id_institution
    JOIN Catalog cat_l ON c.id_catalog_level = cat_l.id_catalog
    JOIN Catalog cat_p ON c.id_catalog_parallel = cat_p.id_catalog
    JOIN Catalog cat_t ON c.id_catalog_time = cat_t.id_catalog
    JOIN Catalog cat_per ON c.id_catalog_period = cat_per.id_catalog
    JOIN Persona prof ON c.id_teacher = prof.id_person
WHERE p.state = 1 AND p.id_role = 4 AND prof.id_role = 3 AND sc.state = 1;  -- Solo estudiantes activos

SELECT * FROM vw_estudiante

-- database: ../../database/MathSpark.sqlite
INSERT INTO
    Catalog_level (name)
VALUES
    ('Grado'),
    ('Paralelo'),
    ('Jornada'),
    ('Periodo'),
    ('Tipo de actividad');

INSERT INTO
    Catalog (name, id_catalog_level)
VALUES
    ('1° Grado', 1),
    ('2° Grado', 1),
    ('3° Grado', 1),
    ('4° Grado', 1),
    ('Inicial II', 1),
    ('A', 2),
    ('B', 2),
    ('C', 2),
    ('D', 2),
    ('E', 2),
    ('F', 2),
    ('G', 2),
    ('H', 2),
    ('Matutina', 3),
    ('Vespertina', 3),
    ('Nocturna', 3),
    ('2024-S', 4),
    ('2024-C', 4),
    ('2025-S', 4),
    ('2025-C', 4),
    ('2026-S', 4),
    ('2026-C', 4),
    ('2027-S', 4),
    ('2027-C', 4),
    ('Diagnostico', 5),
    ('Tarea', 5);

INSERT INTO
    ROLE (name)
VALUES
    ('Administrador'),
    ('Rector'),
    ('Docente'),
    ('Estudiante');

INSERT INTO
    Permission (name, description)
VALUES
    (
        'Administrar Docentes',
        'Permite al usuario administrar docentes'
    ),
    (
        'Administrar Estudiantes',
        'Permite al usuario administrar estudiantes'
    ),
    (
        'Administrar Rector',
        'Permite al usuario administrar rector'
    ),
    (
        'Administrar Pruebas Generales',
        'Permite al usuario administrar pruebas generales'
    ),
    (
        'Administrar Pruebas Individuales',
        'Permite al usuario administrar pruebas individuales'
    ),
    (
        'Administrar Grados',
        'Permite al usuario administrar grados'
    ),
    (
        'Administrar Instituciones',
        'Permite al usuario administrar instituciones'
    ),
    (
        'Visualizar Reportes',
        'Permite al usuario visualizar reportes'
    ),
    (
        'Realizar Actividades',
        'Permite al usuario realizar actividades'
    );

INSERT INTO
    Permission_role (id_role, id_permission)
VALUES
    (1, 1),
    (1, 2),
    (1, 3),
    (1, 4),
    (1, 5),
    (1, 6),
    (1, 7),
    (1, 8),
    (1, 9),
    (2, 1),
    (2, 2),
    (2, 3),
    (2, 4),
    (2, 5),
    (2, 6),
    (2, 7),
    (2, 8),
    (2, 9),
    (3, 1),
    (3, 2),
    (3, 3),
    (3, 4),
    (3, 5),
    (3, 6),
    (3, 7),
    (3, 8),
    (3, 9),
    (4, 8),
    (4, 9);

INSERT INTO
    Persona (
        name,
        last_name,
        DNI,
        email,
        password,
        id_role,
        birthdate
    )
VALUES
    (
        'admin',
        'admin',
        '1255553',
        'admin@gmail.com',
        'admin',
        1,
        '1990-01-01'
    ),
    (
        'rector',
        'rector',
        '48465',
        'rector@gmail.com',
        'rector',
        2,
        '1990-01-01'
    ),
    (
        'docente',
        'docente',
        '6453564',
        'docente@gmail.com',
        'docente',
        3,
        '1990-01-01'
    ),
    (
        'docente2',
        'docente2',
        'QWEQE',
        'docente2@gmail.com',
        'docente',
        3,
        '1990-01-01'
    ),
    (
        'estudiante_grado1',
        'estudiante1',
        '112',
        'estudiante',
        'estudiante',
        4,
        '1990-01-01'
    ),
    (
        'estudiante_grado2',
        'estudiante2',
        '1231',
        'estudiante',
        'estudiante',
        4,
        '1990-01-01'
    ),
    (
        'estudiante_grado3',
        'estudiante3',
        '123456',
        'estudiante',
        'estudiante',
        4,
        '1990-01-01'
    ),
    (
        'estudiante_grado4',
        'estudiante4',
        '12312312',
        'estudiante',
        'estudiante',
        4,
        '1990-01-01'
    ),
    (
        'estudiante_grado5',
        'estudiante5',
        '34512',
        'estudiante',
        'estudiante',
        4,
        '1990-01-01'
    );

INSERT INTO
    Institution (id_manager, name, amie)
VALUES
    (2, 'Instituto Nacional', '17H01524'),
    (2, 'Escuela Nacional', '17H01525'),
    (2, 'Colegio Nacional', '17H01526'),
    (2, 'Unidad Educativa Nacional', '17H01527'),
    (2, 'Centro Educativo Nacional', '17H01528');

INSERT INTO
    Course (
        id_teacher,
        id_catalog_level,
        id_catalog_parallel,
        id_institution,
        id_catalog_time,
        id_catalog_period
    )
VALUES
    (3, 2, 6, 1, 14, 17),
    (4, 3, 6, 1, 14, 17);

INSERT INTO
    Student_course (id_student, id_course)
VALUES
    (5, 1),
    (6, 1),
    (7, 1),
    (8, 1),
    (9, 1),
    (5, 2),
    (6, 2),
    (7, 2),
    (8, 2),
    (9, 2);

INSERT INTO
    Activity (
        name,
        id_course,
        id_catalog_activity_type,
        description
    )
VALUES
    ('Actividad 1', 1, 25, 'Actividad 1'),
    ('Actividad 2', 1, 25, 'Actividad 2'),
    ('Actividad 3', 1, 25, 'Actividad 3'),
    ('Actividad 4', 1, 25, 'Actividad 4'),
    ('Actividad 5', 1, 25, 'Actividad 5'),
    ('Actividad 1', 2, 25, 'Actividad 1'),
    ('Actividad 2', 2, 26, 'Actividad 2'),
    ('Actividad 3', 2, 26, 'Actividad 3'),
    ('Actividad 4', 2, 26, 'Actividad 4'),
    ('Actividad 5', 2, 26, 'Actividad 5');

INSERT INTO
    Game1 (
        id_game1,
        question,
        answer1,
        answer2,
        correct_answer
    )
VALUES
    (1, '2+2', '3', '4', '4'),
    (2, '3+3', '5', '6', '6'),
    (3, '4+4', '7', '8', '8'),
    (4, '5+5', '9', '10', '10'),
    (5, '6+6', '11', '12', '12');

INSERT INTO
    Grades_activity_game1 (id_Student_course, id_Game1, answer1)
VALUES
    (1, 1, '4'),
    (1, 2, '6'),
    (1, 3, '8'),
    (1, 4, '10'),
    (1, 5, '12'),
    (2, 1, '4'),
    (2, 2, '6'),
    (2, 3, '8'),
    (2, 4, '10'),
    (9, 5, '12');


CREATE VIEW vw_persona AS
SELECT 
    p.id_person,
    p.name AS first_name,
    p.last_name,
    p.DNI,
    p.email,
    p.birthdate,
    r.name AS role_name,
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


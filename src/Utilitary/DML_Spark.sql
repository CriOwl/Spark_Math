-- database: ../../database/MathSpark.sqlite
INSERT INTO
    Catalog_level (name)
VALUES
    ('Grado'),
    ('Paralelo'),
    ('Jornada'),
    ('Periodo'),
    ('Tipo de actividad'),
    ('Jerarquia');

INSERT INTO
    Catalog (name, id_catalog_level)
VALUES
    ('1° Grado', 1),
    ('2° Grado', 1),
    ('3° Grado', 1),
    ('4° Grado', 1),
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
    ('Tarea', 5),
    ('Nivel 1', 6),
    ('Nivel 2', 6),
    ('Nivel 3', 6),
    ('Nivel 4', 6),
    ('Nivel 5', 6);

INSERT INTO
    ROLE (name,id_hierarchy)
VALUES
    ('Administrador',26),
    ('Rector',27),
    ('Docente',28),
    ('Estudiante',29);

INSERT INTO
    Permission (name, description,name_method)
VALUES
    (
        'Administrar Docentes',
        'Permite al usuario administrar docentes',
        'DocentePanel'
    ),
    (
        'Administrar Roles',
        'Permite al usuario administrar docentes',
        'RolPanel'
    ),
    (
        'Administrar Permisos',
        'Permite al usuario administrar docentes',
        'PermisoPanel'
    ),
    (
        'Asociar Permisos a Roles',
        'Permite al usuario administrar docentes',
        'RolPermisoPanel'
    ),
    (
        'Administrar Estudiantes',
        'Permite al usuario administrar estudiantes',
        'AdminPanel'
    ),
    (
        'Administrar Rector',
        'Permite al usuario administrar rector',
        'AdminPanel'
    ),
    (
        'Administrar Grados',
        'Permite al usuario administrar grados',
        'admin_course'
    ),
    (
        'Administrar Instituciones',
        'Permite al usuario administrar instituciones',
        'InstitucionPanel'
    ),
    (
        'Juego1',
        'Permite al usuario jugar para el diagnostico',
        'Juego1'
    ),
    (
        'Juego2',
        'Permite al usuario jugar para el diagnostico',
        'Juego2'
    ),
    (
        'Juego3',
        'Permite al usuario jugar para el diagnostico',
        'Juego3'
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
    (1, 9);


INSERT INTO
    Persona (
        name,
        last_name,
        DNI,
        email,
        password,
        id_role
    )
VALUES
    (
        'admin',
        'admin',
        '1700000001',
        'admin@gmail.com',
        'admin',
        1
    ),
    (
        'rector',
        'rector',
        '1700000002',
        'rector@gmail.com',
        'rector',
        2
    ),
    (
        'docente',
        'docente',
        '1700000003',
        'docente@gmail.com',
        'docente',
        3
    ),
    (
        'docente2',
        'docente2',
        '1700000004',
        'docente2@gmail.com',
        'docente',
        3
    ),
    (
        'estudiante_grado1',
        'estudiante1',
        '1700000005',
        'estudiante@gmail.com',
        'estudiante',
        4
    ),
    (
        'estudiante_grado2',
        'estudiante2',
        '1700000006',
        'estudiante2@gmail.com',
        'estudiante',
        4
    ),
    (
        'estudiante_grado3',
        'estudiante3',
        '1700000007',
        'estudiante3@gmail.com',
        'estudiante',
        4
    ),
    (
        'estudiante_grado4',
        'estudiante4',
        '1700000008',
        'estudiante4@gmail.com',
        'estudiante',
        4
    ),
    (
        'estudiante_grado5',
        'estudiante5',
        '1700000009',
        'estudiante5@gmail.com',
        'estudiante',
        4
    );

INSERT INTO
    Institution (name, amie)
VALUES
    ( 'Instituto Nacional', '17H01524'),
    ( 'Escuela Nacional', '17H01525'),
    ( 'Colegio Nacional', '17H01526'),
    ( 'Unidad Educativa Nacional', '17H01527'),
    ( 'Centro Educativo Nacional', '17H01528');

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
INSERT INTO Institution_manage (id_institution_manage, id_institution, id_manager) VALUES
(1, 1, 1),
(2,2,2);
INSERT INTO
    ROLE (name,id_hierarchy)
VALUES
    ('Conserje',2);
SELECT * FROM pragma_table_info('vw_persona');

SELECT 
                r.id_role, 
                r.name, 
                r.state, 
                r.id_hierarchy 
                FROM role r 
                WHERE r.state = 1 AND r.name LIKE '%a%';
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



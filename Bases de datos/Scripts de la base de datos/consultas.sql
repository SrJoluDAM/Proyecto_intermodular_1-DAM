SELECT * FROM libros;
SELECT * FROM autores;
SELECT * FROM socios;

-- Libros por autor
SELECT l.titulo, a.nombre
FROM libros l
JOIN autores a ON l.id_autores = a.id_autores;

-- Libros de un autor
SELECT *
FROM libros
WHERE id_autores = 1;

-- Reservas activas
SELECT *
FROM reserva
WHERE estado = 1;

-- Libros reservados
SELECT l.titulo
FROM libros l
JOIN reserva r ON l.id_libros = r.id_libros
WHERE r.estado = 1;

-- Quién reserva qué
SELECT s.nombre, s.apellido, l.titulo
FROM reserva r
JOIN socios s ON r.id_socios = s.id_socios
JOIN libros l ON r.id_libros = l.id_libros
WHERE r.estado = 1;

-- Préstamos activos
SELECT *
FROM prestamo
WHERE fecha_devolucion IS NULL;

-- Estadísticas
SELECT COUNT(*) AS total_libros FROM libros;
SELECT COUNT(*) AS total_socios FROM socios;
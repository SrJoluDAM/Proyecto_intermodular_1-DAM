-- =========================
-- CREAR BASE DE DATOS
-- =========================

CREATE DATABASE IF NOT EXISTS gestor_biblioteca;
USE gestor_biblioteca;

-- =====================
-- TABLAS
-- =====================

CREATE TABLE `autores` (
  `id_autores` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `nacionalidad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_autores`)
);

CREATE TABLE `ejemplar` (
  `id_ejemplar` int(11) NOT NULL AUTO_INCREMENT,
  `id_libros` int(11) NOT NULL,
  `fecha_reserva` date DEFAULT NULL,
  `fecha_expiracion` date DEFAULT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_ejemplar`)
);

CREATE TABLE `escriben` (
  `id_autores` int(11) NOT NULL,
  `id_libros` int(11) NOT NULL
);

CREATE TABLE `libros` (
  `id_libros` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(50) DEFAULT NULL,
  `anio_publicacion` varchar(20) DEFAULT NULL,
  `editorial` varchar(20) DEFAULT NULL,
  `id_autores` int(11) NOT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_libros`)
);

CREATE TABLE `prestamo` (
  `id_prestamo` int(11) NOT NULL AUTO_INCREMENT,
  `id_ejemplar` int(11) NOT NULL,
  `id_socios` int(11) NOT NULL,
  `fecha_incio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_devolucion` date DEFAULT NULL,
  PRIMARY KEY (`id_prestamo`)
);

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL AUTO_INCREMENT,
  `id_libros` int(11) NOT NULL,
  `id_socios` int(11) NOT NULL,
  `fecha_reserva` date DEFAULT NULL,
  `fecha_expiracion` date DEFAULT NULL,
  `estado` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id_reserva`)
);

CREATE TABLE `socios` (
  `id_socios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_socios`)
);

-- =====================
-- ÍNDICES Y FOREIGN KEYS
-- =====================

ALTER TABLE `ejemplar`
  ADD KEY `id_libros` (`id_libros`);

ALTER TABLE `escriben`
  ADD KEY `id_autores` (`id_autores`),
  ADD KEY `id_libros` (`id_libros`);

ALTER TABLE `libros`
  ADD KEY `id_autores` (`id_autores`);

ALTER TABLE `prestamo`
  ADD KEY `id_ejemplar` (`id_ejemplar`),
  ADD KEY `id_socios` (`id_socios`);

-- FOREIGN KEYS

ALTER TABLE `ejemplar`
  ADD CONSTRAINT `ejemplar_ibfk_1` FOREIGN KEY (`id_libros`) REFERENCES `libros` (`id_libros`);

ALTER TABLE `escriben`
  ADD CONSTRAINT `escriben_ibfk_1` FOREIGN KEY (`id_autores`) REFERENCES `autores` (`id_autores`),
  ADD CONSTRAINT `escriben_ibfk_2` FOREIGN KEY (`id_libros`) REFERENCES `libros` (`id_libros`);

ALTER TABLE `libros`
  ADD CONSTRAINT `libros_ibfk_1` FOREIGN KEY (`id_autores`) REFERENCES `autores` (`id_autores`);

ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`id_ejemplar`) REFERENCES `ejemplar` (`id_ejemplar`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`id_socios`) REFERENCES `socios` (`id_socios`);

COMMIT;
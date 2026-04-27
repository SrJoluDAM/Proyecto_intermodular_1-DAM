-- AUTORES
INSERT INTO `autores` (`nombre`, `nacionalidad`) VALUES
('Stephen King', 'Portland, Mine, Estados Unidos'),
('J.K. Rowling', 'Yate, Reino Unido'),
('George Orwell', 'Motihari, India');

-- LIBROS
INSERT INTO `libros` (`titulo`, `anio_publicacion`, `editorial`, `id_autores`, `estado`) VALUES
('IT', '1986', 'Viking Press', 1, NULL),
('El resplandor', '1977', 'Doubleday', 1, NULL),
('Misery', '1987', 'Viking Press', 1, NULL),
('Carrie', '1974', 'Doubleday', 1, NULL),
('Cementerio de animales', '1983', 'Doubleday', 1, NULL),
('Harry Potter y la piedra filosofal', '1997', 'Bloomsbury', 2, NULL),
('Harry Potter y la cámara secreta', '1998', 'Bloomsbury', 2, NULL),
('Harry Potter y el prisionero de Azkaban', '1999', 'Bloomsbury', 2, NULL),
('Harry Potter y el cáliz de fuego', '2000', 'Bloomsbury', 2, NULL),
('Harry Potter y la Orden del Fénix', '2003', 'Bloomsbury', 2, NULL),
('1984', '1949', 'Secker & Warburg', 3, NULL),
('Rebelión en la granja', '1945', 'Secker & Warburg', 3, NULL),
('Homenaje a Cataluña', '1938', 'Secker & Warburg', 3, NULL),
('Subir a por aire', '1939', 'Victor Gollancz Ltd', 3, NULL),
('Sin blanca en París y Londres', '1933', 'Victor Gollancz Ltd', 3, NULL);

-- SOCIOS
INSERT INTO `socios` (`nombre`, `apellido`, `email`) VALUES
('Jose', 'Montero', 'socio1@socio.com'),
('Juan', 'Perez', 'socio2@socio.com'),
('Pepe', 'Ruiz', 'socio3@socio.com'),
('Ana', 'Rodriguez', 'socio4@socio.com'),
('Luis', 'Guitierrez', 'socio5@socio.com');
# Gestor de Biblioteca – Modelo Entidad-Relación

# Descripción

Este trabajo consiste en el diseño de un modelo entidad-relación (ER) para una base de datos de una biblioteca. La idea es representar cómo se organizan los libros, los usuarios, los préstamos y las reservas dentro del sistema.


# Entidades

# LIBRO

Representa los libros de la biblioteca.

Atributos:

 id_libro (PK)
 título
 ISBN
 año_publicación
 editorial

# AUTOR

Representa a los autores de los libros.

Atributos:

 id_autor (PK)
 nombre
 nacionalidad

# EJEMPLAR

Son las copias físicas de un libro.

Atributos:

 id_ejemplar (PK)
 estado
 ubicación
 id_libro (FK)

# USUARIO

Personas que usan la biblioteca.

Atributos:

 id_usuario (PK)
 nombre
 apellidos
 email
 teléfono

# PRÉSTAMO

Registra cuando un usuario se lleva un ejemplar.

Atributos:

 id_prestamo (PK)
 fecha_inicio
 fecha_fin
 fecha_devolución
 id_usuario (FK)
 id_ejemplar (FK)

#  RESERVA

Sirve para cuando un usuario quiere reservar un libro.

Atributos:

 id_reserva (PK)
 fecha_reserva
 estado
 fecha_expiración
 id_usuario (FK)
 id_libro (FK)


# Relaciones

# AUTOR – LIBRO

 Tipo: N:M
  Un autor puede escribir varios libros y un libro puede tener varios autores.

Por eso se crea una tabla intermedia:

 LIBRO_AUTOR (id_libro, id_autor)


# LIBRO – EJEMPLAR

 Tipo: 1:N
  Un libro puede tener muchos ejemplares, pero cada ejemplar pertenece a un solo libro.


# USUARIO – PRÉSTAMO

 Tipo: 1:N
  Un usuario puede hacer varios préstamos.



# EJEMPLAR – PRÉSTAMO

 Tipo: 1:N
  Un ejemplar se puede prestar varias veces a lo largo del tiempo.



# USUARIO – RESERVA

 Tipo: 1:N
  Un usuario puede hacer varias reservas.



# LIBRO – RESERVA

 Tipo: 1:N
  Un libro puede tener varias reservas.



#  Decisiones tomadas

 He usado una relación N:M entre autor y libro porque es más realista.
 La entidad "reserva" no es una relación simple porque tiene atributos propios.
 Se diferencia entre libro y ejemplar porque no es lo mismo el libro en sí que sus copias físicas.



# Conclusión

Este modelo representa de forma básica cómo funcionaría una biblioteca. Creo que cumple con lo que se pide y está normalizado a un nivel inicial.


# Mejoras posibles

 Añadir categorías de libros
 Control de multas
 Gestión de empleados


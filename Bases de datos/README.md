# Gestor de Biblioteca - Base de Datos

Este proyecto es la base de datos de un gestor de biblioteca hecha en MySQL.
Por ahora no está conectada a ningún programa, es solo la estructura y los datos.

---

## ¿Que contiene?

- Tablas para gestionar libros, autores, socios y préstamos
- Relaciones entre las tablas con claves foráneas
- Algunos datos de prueba ya insertados

---

## Tablas

- **autores** - Guarda el nombre y la nacionalidad de los autores
- **libros** - Guarda los libros con su título, editorial, año y autor
- **ejemplar** - Cada copia física de un libro que hay en la biblioteca
- **socios** - Los usuarios registrados en la biblioteca
- **prestamo** - Registra cuando un socio saca un libro y cuando lo devuelve
- **escriben** - Relaciona los autores con sus libros

---

## Requisitos

- XAMPP (MySQL + phpMyAdmin)
- MySQL 5.7 o superior

---

## Como importar la base de datos

1. Abre XAMPP y arranca Apache y MySQL
2. Entra en phpMyAdmin (http://localhost/phpmyadmin)
3. Crea una base de datos llamada `gestor_biblioteca`
4. Ve a la pestaña **Importar** y selecciona el archivo `.sql`
5. Dale a continuar y listo

---

## Datos de prueba

La base de datos ya viene con algunos datos de ejemplo:

- 3 autores (Stephen King, J.K. Rowling, George Orwell)
- 15 libros repartidos entre los autores
- 5 socios de prueba

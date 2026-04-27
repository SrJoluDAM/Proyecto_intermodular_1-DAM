# Gestor de Biblioteca

Este programa es un gestor de biblioteca hecho con base de datos en MySQL. 
Permite gestionar libros, autores, socios y préstamos.

---

## ¿Que hace el programa?

- Guardar libros y sus autores
- Registrar socios de la biblioteca
- Gestionar préstamos y devoluciones de libros
- Controlar los ejemplares disponibles

---

## Base de datos

La base de datos se llama `gestor_biblioteca` y tiene las siguientes tablas:

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

---


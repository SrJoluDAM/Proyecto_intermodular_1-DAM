## Gestor de Biblioteca (Java + JDBC + MySQL)
# Descripción

Aplicación de consola en Java que simula un sistema de gestión de biblioteca. Permite gestionar libros, autores, socios y reservas, conectándose a una base de datos MySQL mediante JDBC.

# Ejecución
Crear la base de datos en MySQL usando el script SQL del proyecto.
Configurar credenciales en ConexionDB.java.
Ejecutar la clase Main.java.
 Funcionalidades
 Listar libros con autor y estado (DISPONIBLE / RESERVADO)
 Gestión de socios (añadir, eliminar, listar)
 Reservar libros para socios
 Devolver libros y actualizar estado
 Validaciones de socios y reservas
 Base de datos

El proyecto utiliza MySQL con JDBC.

Tablas principales:

libros
autores
socios
reserva
ejemplar
prestamo

Operaciones: SELECT, INSERT, UPDATE, DELETE.

 # Arquitectura
Conexion → conexión a BD
DAO → acceso a datos
model → entidades
service → lógica de negocio
menu → interfaz por consola
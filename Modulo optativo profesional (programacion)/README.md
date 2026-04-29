## Gestor de Biblioteca (Java + JDBC + MySQL)

# Arquitectura del proyecto 

El proyecto sigue una arquitectura en capas:

Conexion → gestiona la conexión con la base de datos MySQL mediante JDBC.
model → contiene las entidades (Libros, Socios, Autores, etc.).
DAO → realiza las operaciones CRUD sobre la base de datos.
service → contiene la lógica de negocio (reservas, validaciones, devoluciones).
menu → interfaz de usuario por consola, desde donde se ejecuta la aplicación.

Esta estructura separa responsabilidades, facilitando el mantenimiento y la escalabilidad del sistema.

# MPO (Mejora del Proyecto)

En la parte de mejora del proyecto se ha implementado:

Sistema completo de reservas de libros con control de estado (DISPONIBLE / RESERVADO).
Validación de socios antes de realizar operaciones.
Evitar reservas duplicadas de un mismo libro.
Mensajes de error y control de flujo más claros (ej: socio no encontrado o libro no reservado).
Gestión básica de socios (alta y baja desde el sistema).
Integración completa entre Java y MySQL mediante JDBC.
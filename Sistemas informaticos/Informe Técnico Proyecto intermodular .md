## 📄 Informe Técnico del Entorno de Ejecución

Gestor de Biblioteca

1. Tipo de sistema donde se ejecuta.

La aplicación desarrollada es un gestor de biblioteca hecho en Java que se ejecuta como programa de escritorio.

Este sistema está pensado para ejecutarse en:

Un ordenador personal (PC) con base de datos local mediante XAMPP.

Justificación:

Es una aplicación de escritorio, no es una aplicación web.
Se ejecuta directamente en el ordenador del usuario.
La base de datos se gestiona de forma local usando XAMPP, lo que simplifica la instalación.

2. Requisitos de hardware

Requisitos mínimos:

CPU: Intel Core i3 o similar
RAM: 4 GB
Disco duro: 500 MB libres

Requisitos recomendados:

CPU: Intel Core i5 o superior
RAM: 8 GB
Disco duro: 1 GB libre

Justificación:

La aplicación usa Java y una base de datos MySQL a través de XAMPP, por lo que necesita recursos básicos pero no elevados.

3. Sistema operativo recomendado

Sistema principal:

Windows 10 o superior

Alternativa:

Linux (Ubuntu)

Justificación:

XAMPP funciona correctamente en Windows.
Es fácil de instalar y usar.
Java es compatible con ambos sistemas.

4. Instalación del entorno

A continuación se explican los pasos para instalar y ejecutar la aplicación.

Paso 1: Instalar Java

Descargar Java JDK (versión 17 o superior).

Instalarlo.

Configurar variables de entorno si es necesario.

Paso 2: Instalar XAMPP

Descargar e instalar XAMPP.

Abrir el panel de control de XAMPP.

Iniciar el servicio MySQL.

Paso 3: Crear la base de datos

Abrir el navegador y entrar en:

http://localhost/phpmyadmin

Crear una base de datos llamada:

CREATE DATABASE biblioteca;

Crear las tablas:
socios
libros
reservas
prestamo
ejemplar
autores

Paso 4: Configurar el proyecto

Clonar o descargar el proyecto desde GitHub.

Abrirlo en IntelliJ IDEA.

Configurar la conexión JDBC:

String url = "jdbc:mysql://localhost:3306/biblioteca";

String user = "root";

String password = "";

(En XAMPP por defecto el usuario es root y sin contraseña)

Añadir el driver JDBC si no está incluido.

Paso 5: Ejecutar la aplicación

Ejecutar la clase principal (Main).
Comprobar que conecta con la base de datos.
Verificar que se pueden ver y reservar libros.

5. Permisos y estructura

Los permisos serán los del propio administrador, ya que solo el encargado, será capaz de utilizar el gestor.

Base de datos:

Nombre: Gestor biblioteca

Tablas:

socios
libros
reservas
autores
prestamos
ejemplar

Estructura del proyecto:

/src → código Java  
/db → scripts SQL  

Copias de seguridad:

Se recomienda exportar la base de datos desde phpMyAdmin.
Guardar copias periódicas.

6. Mantenimiento básico

Mantener actualizado Java.

Comprobar que XAMPP (MySQL) está en funcionamiento.

Revisar la base de datos periódicamente.

Realizar copias de seguridad.

En caso de error:

Verificar que MySQL está iniciado en XAMPP.
Comprobar la conexión JDBC.
Revisar usuario y contraseña.
Reiniciar XAMPP y la aplicación.


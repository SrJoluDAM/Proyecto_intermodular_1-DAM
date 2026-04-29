Titulo del proyecto

📚 Gestión de Biblioteca
Sistema de gestión de biblioteca desarrollado en Java que permite administrar de forma digital el catálogo de libros, los socios registrados y los préstamos activos de una biblioteca.

❓ ¿Qué problema resuelve?

Las bibliotecas tradicionales gestionan sus recursos de forma manual, lo que genera errores, pérdida de información y lentitud en los procesos. Este sistema digitaliza y centraliza la gestión de libros, socios y préstamos, permitiendo un control más eficiente y fiable.

Permite:
1.- Evitar la pérdida de registros de préstamos
2.- Consultar rápidamente la disponibilidad de un libro
3.- Llevar un control actualizado de los socios.

🛠️ Tecnologias usadas.

Java 17+

IntelliJ IDEA (para la creación de la aplicación)

Visual Studio Code

MySQL (Para la creación de base de datos)

Git+Github (Para el control de versiones)

Aplicacion Draw.io para diagrama entidad-relación.

⚙️ Instalación y ejecución

 1. Instalar Java
Descargar e instalar Java JDK (versión 17 o superior).

Comprobar instalación con:

java -version

 2. Instalar y configurar XAMPP
    
Descargar e instalar XAMPP.
Abrir el panel de control.
Iniciar el servicio MySQL.

 3. Crear la base de datos

Abrir el navegador y entrar en:

http://localhost/phpmyadmin

Crear una base de datos llamada:

CREATE DATABASE biblioteca;

Importar las tablas del proyecto(en la carpeta Base de datos--> Scripts SQL)

🔹 4. Configurar el proyecto

Abrir el proyecto en IntelliJ IDEA.

Configurar la conexión JDBC en el código:

String url = "jdbc:mysql://localhost:3306/biblioteca";
String user = "root";
String password = "";

▶️ 5. Ejecutar la aplicación

Ejecutar la clase principal (Main).

Comprobar que:

La aplicación arranca
Se conecta a la base de datos
Permite ver y reservar libros

⚠️ Problemas comunes
MySQL no iniciado → Iniciar desde XAMPP
Error de conexión → Revisar usuario/contraseña
Base de datos no existe → Crear biblioteca

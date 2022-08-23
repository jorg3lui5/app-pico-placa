# APIPicoPlaca

Para que este aplicativo se ejecute correctamente, se necesita tener instalado lo siguiente:

- Java 11.0.15
- Maven 3.8.5

# Ejecutar API

1. Compilar y generar package. Ejecutar comandos dentro de la carpeta del proyecto
- mvn clean package

2. Ejecutar la api:
- mvn spring-boot:run

3. Comprobación Local:
http://localhost:8080/pico-placa/api/swagger-ui.html


# Base de datos

La base de datos, es una BD postgresql que está desplegada en la nube con Google Cloud.

Credenciales:
- Host: 34.134.8.121
- Database: postgres
- User: picoplaca
- Port: 5432
- Password: picoplaca

Para acceder a la base de datos se puede usar:
- pgAdmin
- DBeaver, etc


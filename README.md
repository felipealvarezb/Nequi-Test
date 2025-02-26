# Nequi-Test

Este es un proyecto desarrollado en **Spring Boot** con una arquitectura por capas. Utiliza **MySQL** como base de datos y está dockerizado para facilitar su despliegue.
Este proyecto se encuentra desplegado en una instancia de EC2 en AWS. Se puede probar los endpoints en la instancia desplegada con la colección de postman que se encuentra
en la carpeta postman


## 📌 Arquitectura

El proyecto sigue una arquitectura por capas:

- **Controller**: Maneja las peticiones HTTP.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Se encarga de la comunicación con la base de datos.
- **Model**: Define las entidades del dominio.
- **DTO**: Define los modelos para creación y actualización, como también para respuesta
- **Mappers**: Define los mapeos de DTO's a entidades y de entidades a ResponseDTO's
- **Exception**: Define las clases para el manejo de excepciones cunado se lanza un EntityNotFound o MethodArgumentNotValid
  

### 📊 Modelo Entidad-Relación

A continuación, se muestra el modelo de entidad-relación del proyecto:
<img width="1181" alt="Captura de pantalla 2025-02-25 a la(s) 5 07 28 p m" src="https://github.com/user-attachments/assets/3d088036-fc9b-44e3-8072-9575a17819cd" />


## 🚀 Configuración del Proyecto

## Requisitos previos

Antes de desplegar la aplicación, asegúrate de tener instalado lo siguiente en tu sistema:

1. **Java Development Kit (JDK) 21 o superior**  
   [Descargar JDK](https://adoptium.net/)

2. **Maven** (para compilar y ejecutar el proyecto)  
   [Descargar Maven](https://maven.apache.org/download.cgi)

3. **Docker y Docker Compose** (para la base de datos)  
   [Instalar Docker](https://docs.docker.com/get-docker/)

4. **Postman o cURL** (opcional, para probar los endpoints)

---

## Configuración inicial

### 1. Clonar el repositorio
Clona este repositorio en tu máquina local:

```bash
git clone https://github.com/felipealvarezb/Nequi-Test
```
### 2. Crear y ejecutar el contenedor de MySQL
Descargar e iniciar un contenedor de MySql en el puerto 3306

Credenciales por defecto:
Usuario: user - Contraseña: password


```bash
docker-compose up -d
docker ps 
```
### 3. Compilar el proyecto

Para compilar el proyecto, ejecuta:

```bash
./mvnw clean install
./mvnw spring-boot:run
```


## 📜 API Endpoints

Puedes probar los endpoints con Postman o Swagger (`http://localhost:8080/swagger-ui.html`).

Algunos endpoints principales:
- **Franchise**:
  - `GET /api/v1/franchise` → Obtener todas las franquicias.
  - `POST /api/v1/franchise` → Crear una franquicia.
  - `PUT /api/v1/franchise/{id}` → Actualizar una franquicia.
  - `DELETE /api/v1/franchise/{id}` → Eliminar una franquicia.

- **Branches**:
  - `GET /api/v1/branches` → Obtener todas las sucursales.
  - `POST /api/v1/branches` → Crear una sucursal.
  - `PUT /api/v1/branches/{id}` → Actualizar una sucursal.
  - `DELETE /api/v1/branches/{id}` → Eliminar una sucursal.

- **Products**:
  - `GET /api/v1/product` → Obtener todos los productos.
  - `GET /api/v1/product/branch/{branchId}` → Obtener los productos de una franquicia ordenados de mayor a menor por stock
  - `POST /api/v1/product` → Crear un producto.
  - `PUT /api/v1/product/{id}` → Actualizar un producto.
  - `DELETE /api/v1/product/{id}` → Eliminar un producto.

---

## 🛠 Tecnologías Utilizadas

- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Docker & Docker Compose**
- **Lombok**

---

## 📌 Autor

Desarrollado por **Felipe Álvarez** 🚀.

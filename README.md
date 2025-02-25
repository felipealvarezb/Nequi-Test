# Nequi-Test

Este es un proyecto desarrollado en **Spring Boot** con una arquitectura por capas. Utiliza **MySQL** como base de datos y está dockerizado para facilitar su despliegue.

## 📌 Arquitectura

El proyecto sigue una arquitectura por capas:

- **Controller**: Maneja las peticiones HTTP.
- **Service**: Contiene la lógica de negocio.
- **Repository**: Se encarga de la comunicación con la base de datos.
- **Model**: Define las entidades del dominio.

### 📊 Modelo Entidad-Relación

A continuación, se muestra el modelo de entidad-relación del proyecto:
<img width="1181" alt="Captura de pantalla 2025-02-25 a la(s) 5 07 28 p m" src="https://github.com/user-attachments/assets/3d088036-fc9b-44e3-8072-9575a17819cd" />

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
- **MySQL 8**
- **Docker & Docker Compose**
- **Swagger (Springdoc OpenAPI)**

---

## 📌 Autor

Desarrollado por **Felipe Álvarez** 🚀.

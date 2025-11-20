# 📚 API REST - Gestión de Cursos Online

Este proyecto consiste en una API RESTful robusta desarrollada con **Java** y **Spring Boot 3** para la administración de un catálogo educativo. Implementa un ciclo completo de desarrollo Backend, incluyendo persistencia de datos, lógica de negocio segura y documentación automática.

---

## 🚀 Tecnologías y Herramientas

* **Lenguaje:** Java 21
* **Framework:** Spring Boot 3.4.x
* **Base de Datos:** H2 Database (En memoria)
* **ORM:** Spring Data JPA & Hibernate
* **Documentación:** OpenAPI (Swagger UI)
* **Herramientas:** Maven, Lombok

---

## 🏗️ Arquitectura y Patrones de Diseño

El sistema sigue una **Arquitectura en Capas (N-Tier)** para asegurar la escalabilidad y el mantenimiento:

1.  **Controller Layer:** Maneja las peticiones HTTP y la interacción con el cliente.
2.  **Service Layer:** Contiene la lógica de negocio y las reglas de validación.
3.  **Repository Layer:** Abstracción de la capa de datos usando interfaces de JPA.
4.  **Domain & DTOs:** Separación estricta entre las Entidades de base de datos y los Objetos de Transferencia de Datos (DTO).

### ✨ Características Destacadas

* **Patrón DTO (Data Transfer Object):** Se implementó para desacoplar la base de datos de la API pública, mejorando la seguridad y evitando la exposición de datos sensibles.
* **Validaciones Robustas:** Uso de `Jakarta Validation` (`@NotBlank`, `@Min`, `@NotNull`) para asegurar la integridad de los datos de entrada.
* **Manejo Global de Excepciones:** Implementación de `@RestControllerAdvice` para capturar errores y devolver respuestas JSON estandarizadas (ej: *400 Bad Request* con detalles del error).
* **Data Seeding:** Carga automática de 25 cursos de prueba al iniciar la aplicación mediante scripts SQL.
* **Consultas Personalizadas:** Filtros dinámicos por título, rangos de precio y combinaciones de ambos.

---

## 🛠️ Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/feraruc125-wq/Entrega_Final_RucciFernando_api_cursos.git](https://github.com/feraruc125-wq/Entrega_Final_RucciFernando_api_cursos.git)
    ```
2.  **Abrir el proyecto** en IntelliJ IDEA (o Eclipse).
3.  Esperar a que Maven descargue las dependencias.
4.  Ejecutar la clase principal `ApiCursosApplication`.

La aplicación iniciará en el puerto `8080`.

---

## 🔗 Pruebas y Documentación

### 1. Swagger UI (Documentación Interactiva)
Prueba los endpoints visualmente sin escribir código:
👉 **http://localhost:8080/swagger-ui/index.html**

### 2. Consola H2 (Base de Datos)
Accede a las tablas en tiempo real:
* **URL:** `http://localhost:8080/h2-console`
* **JDBC URL:** `jdbc:h2:mem:cursosdb`
* **User:** `sa`
* **Password:** (dejar vacío)

---

## 📡 Endpoints Principales

| Método | Endpoint | Descripción |
| :--- | :--- | :--- |
| `GET` | `/api/cursos` | Obtiene todos los cursos. |
| `GET` | `/api/cursos?precio=0` | Filtra cursos gratuitos. |
| `GET` | `/api/cursos?titulo=Java` | Busca por coincidencia en el título. |
| `POST` | `/api/cursos` | Crea un curso (Requiere Body JSON). |
| `PUT` | `/api/cursos/{id}` | Edita un curso existente. |
| `DELETE` | `/api/cursos/{id}` | Elimina un curso. |

### Ejemplo de JSON para Crear (POST):
```json
{
  "titulo": "Curso de Spring Boot Avanzado",
  "precio": 150.00,
  "descripcion": "Aprende APIs REST y Microservicios",
  "nivel": "Avanzado"
}

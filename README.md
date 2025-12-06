# Student CRUD - Spring Boot (Maven)

Un proyecto RESTful desarrollado en Spring Boot que permite gestionar estudiantes mediante operaciones CRUD para el "Proyecto Final".

## Requisitos
- Java 17+
- Maven
- Spring Boot

## Ejecutar
1. `mvn clean package`
2. `mvn spring-boot:run`  (o ejecutar la clase `StudentCrudApplication` desde IntelliJ)
3. API base: `http://localhost:8080/api/students`

## Endpoints
- `POST /api/students` : crear estudiante
- `GET  /api/students` : listar todos
- `GET  /api/students/{id}` : obtener por id
- `PUT  /api/students/{id}` : actualizar
- `DELETE /api/students/{id}` : eliminar

## Probar en postman
- Puedes importar estos endpoints manualmente o usar esta URL base:
- http://localhost:8080/students

## Tests
Ejecutar `mvn test`. Hay pruebas unitarias (service) y de integración ligera (controller con MockMvc).

## Estructura
Sugerencia de paquetes: controller, service, repository, model, dto, exception, util.

## Autores
- Kevin Leandro Ramirez Arango
- Kevin Andres Fuquen Morales
- Proyecto Academico - Ingenieria de Software


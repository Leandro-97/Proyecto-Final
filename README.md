# Student CRUD - Spring Boot (Maven)

Proyecto de ejemplo para el "Tercer Proyecto — CRUD de estudiantes".

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

## Tests
Ejecutar `mvn test`. Hay pruebas unitarias (service) y de integración ligera (controller con MockMvc).

## Estructura
Sugerencia de paquetes: controller, service, repository, model, dto, exception, util.


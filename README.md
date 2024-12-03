# Simple spring boot app

- Run with `mvn clean spring-boot:run`

### Docs:
- View docs via http://localhost:8080/v3/api-docs
- View swagger docs via http://localhost:8080/swagger-ui/index.html

### Usage:
- Access via http://localhost:8080/
- Get: localhost:8080/items
- Post : localhost:8080/items + payload
- Put : e.g. localhost:8080/items?id=Dried%20Red%20Chilli + payload
- Delete : localhost:8080/items?id=Dried%20Red%20Chilli

### Tests

- Run with `mvn test`. Note the rest assured tests will fail if the service is not already running.

### To-do:
- Dockerise
- Structure DB
- Update configuration

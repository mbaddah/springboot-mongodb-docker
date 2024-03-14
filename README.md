# Simple spring boot app

- Run with `mvn clean spring-boot:run`

### Docs:
- View docs via http://localhost:8080/v3/api-docs
- View swagger docs via http://localhost:8080/swagger-ui/index.html

### Deploy MongoDB, Grafana, Prometheus via docker-compose
- Run `docker-compose up -d` to spin up instance of mongodb, grafana and prometheus

- Grafana/Prom setup:
- Login to grafana via localhost:3000 `admin/admin`
- Add local prometheus source http://host.docker.internal:9090 (or http://prometheus:9090) 
- Add mongodb dashboard (#2583)
- ** Fix scraping

### Usage:
- Access app via http://localhost:8080/
- Post : localhost:8080/items + payload
- Put : e.g. localhost:8080/items?id=Dried%20Red%20Chilli + payload
- Delete : localhost:8080/items?id=Dried%20Red%20Chilli

### To-do:
- Add tests
- Structure DB
- Update configuration
- Develop web interface
- Automate prom/grafana setup

### References:
- https://github.com/grafana/grafana/issues/46434
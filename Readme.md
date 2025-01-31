USAGE
-----

##### Required steps:
1. In the first command line tool **start BE microservice** with `mvn -f ./chrisblog-microservices_be spring-boot:run`
1. In the second command line tool **start FE microservice** with `mvn -f ./chrisblog-microservices_fe spring-boot:run`
1. In the browser visit **blog page** with `http://localhost:8080`
1. Clean up environment
    * In the second command line tool stop FE microservice with ctrl + C
    * In the first command line tool stop BE miroservice with ctrl + C

##### Opional steps:
1. In a browser check BE API documentaton with `http://localhost:8081/swagger-ui/index.html`
1. In a Rest Client (e.g. Postman) display articles with (GET method) `http://localhost:8081/api/v1/article?categoryId=0&page=1&sorting=date_decreasing`
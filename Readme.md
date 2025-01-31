USAGE
-----

Usage steps:
1. In the first command line tool **start BE microservice** with `mvn -f ./chrisblog-microservices_be spring-boot:run`
1. In the second command line tool **start FE microservice** with `mvn -f ./chrisblog-microservices_fe spring-boot:run`
1. In the browser visit **blog page** with `http://localhost:8080`
1. Clean up environment
    * In the second command line tool stop FE microservice with ctrl + C
    * In the first command line tool stop BE miroservice with ctrl + C
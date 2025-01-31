USAGE
-----

##### Required steps:
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose -f .\docker-compose\docker-compose.yaml up -d --build`
1. In the browser visit **blog page** with `http://localhost:8080`
1. Clean up environment
    * In a command line tool **remove Docker containers** with `docker-compose -f .\docker-compose\docker-compose.yaml down --rmi all`
    * Stop **Docker** tool

##### Opional steps:
1. In a browser check BE API documentaton with `http://localhost:8081/swagger-ui/index.html`
1. In a Rest Client (e.g. Postman) display articles with (GET method) `http://localhost:8081/api/v1/article?categoryId=0&page=1&sorting=date_decreasing`
USAGE DOCKER COMPOSE
--------------------

##### Required steps:
1. Start **Docker** tool
1. In a command line tool **start Docker containers** with `docker-compose -f .\docker-compose\docker-compose.yaml up -d --build`
1. In a browser visit **Discovery page** with `http://localhost:8761`
    * Expected HTML page with Discovery dashboard
1. In the browser visit **Blog page via API Gateway** with `http://localhost:8762`
    * Expected HTML page with Blog page
1. In a browser **check logs, traces, and metrics in Grafana** with `http://localhost:3000`
    * Expected HTML page with Grafana dashboard (please check section EXAMPLE).
1. Clean up environment
    * In a command line tool **remove Docker containers** with `docker-compose -f .\docker-compose\docker-compose.yaml down --rmi all`
    * Stop **Docker** tool

##### Opional steps:
1. In a browser check BE API documentaton with `http://localhost:8081/swagger-ui/index.html`
1. In a Rest Client (e.g. Postman) display articles with (GET method) `http://localhost:8081/api/v1/article?categoryId=0&page=1&sorting=date_decreasing`


USAGE KUBERNETES (KIND)
---------------------------

> **Usage Kubernetes** means that all services are started as Kubernetes pods. 

> Please **clone/download** project, open **project's main folder** in your favorite **command line tool** and then **proceed with steps below**.

> **Prerequisites**:  
* **Operating System** (tested on Windows 11)
* **Git** (tested on version 2.33.0.windows.2)
* **Kind** (tested on version 0.26.0)

##### Required steps:
1. Start **Docker** tool
1. In the first command line tool create and start cluster **Kind** with `kind create cluster --name helloworld`
1. In the second command line tool **start Kubernetes Pods** with `kubectl apply -f ./k8s --recursive`
1. In the second command line tool **check status of Kubernetes Pods** with `kubectl get pods`
   * Expected mysql, be and fe as **READY 1/1** (it can take few minutes)
1. In the second command line tool **forward port of Discovery service** with `kubectl port-forward service/discovery 8761:8761`
1. In the third command line tool **forward port of Gateway service** with `kubectl port-forward service/gateway 8762:8762`
1. In the fourth command line tool**forward port of Grafana service** with `kubectl port-forward service/grafana 3000:3000`
1. In a browser visit **Discovery page** with `http://localhost:8761`
    * Expected HTML page with Discovery dashboard
1. In the browser visit **Blog page via API Gateway** with `http://localhost:8762`
    * Expected HTML page with Blog page
1. In a browser **check logs, traces, and metrics in Grafana** with `http://localhost:3000`
    * Expected HTML page with Grafana dashboard (please check section EXAMPLE).
1. Clean up environment 
     * In the fourth command line tool **stop forwarding port of Grafana service** with `ctrl + C`
     * In the third command line tool **stop forwarding port of Gateway service** with `ctrl + C`
     * In the second command line tool **stop forwarding port of Discovery service** with `ctrl + C`
     * In the second command line tool **remove Kubernetes Pods** with `kubectl delete -f ./k8s --recursive`
     * In the first command line tool delete cluster **Kind** with `kind delete cluster --name helloworld`
     * Stop **Docker** tool

##### Optional steps:
1. In a command line tool build Docker BE image with `docker build -f chrisblog-microservices_BE/Dockerfile -t wisniewskikr/chrisblog-microservices_be:0.0.1 ./chrisblog-microservices_BE`
1. In a command line tool push Docker BE image to Docker Repository with `docker push wisniewskikr/chrisblog-microservices_be:0.0.1` 
1. In a command line tool build Docker FE image with `docker build -f chrisblog-microservices_FE/Dockerfile -t wisniewskikr/chrisblog-microservices_fe:0.0.1 ./chrisblog-microservices_FE`
1. In a command line tool push Docker FE image to Docker Repository with `docker push wisniewskikr/chrisblog-microservices_fe:0.0.1` 
1. In a command line tool build Docker GATEWAY image with `docker build -f chrisblog-microservices_GATEWAY/Dockerfile -t wisniewskikr/chrisblog-microservices_gateway:0.0.1 ./chrisblog-microservices_GATEWAY`
1. In a command line tool push Docker GATEWAY image to Docker Repository with `docker push wisniewskikr/chrisblog-microservices_gateway:0.0.1`
1. In a command line tool build Docker DISCOVERY image with `docker build -f chrisblog-microservices_DISCOVERY/Dockerfile -t wisniewskikr/chrisblog-microservices_discovery:0.0.1 ./chrisblog-microservices_DISCOVERY`
1. In a command line tool push Docker DISCOVERY image to Docker Repository with `docker push wisniewskikr/chrisblog-microservices_discovery:0.0.1`  
1. In the first command line tool with administrator privileges check clusers with `kind get clusters`
1. In a command line tool check Kubernetes Deployments with `kubectl get deployments`
1. In a command line tool check Kubernetes Deployments details with **kubectl describe deployment {deployment-name}**
1. In a command line tool check Kubernetes Services with `kubectl get services`
1. In a command line tool check Kubernetes Services details with **kubectl describe service {service-name}**
1. In a command line tool check Kubernetes Pods with `kubectl get pods`
1. In a command line tool check Kubernetes Pods details with **kubectl describe pod {pod-name}**
1. In a command line tool check Kubernetes Pods logs with **kubectl logs {pod-name}**


TODO
----

* Change DB from H2 to MySql
* Implement Flyway tool
* Add Servie Discovery
* Add Api Gateway
* Add Grafana
* Add Kubernetes configuration
* Update Readme file
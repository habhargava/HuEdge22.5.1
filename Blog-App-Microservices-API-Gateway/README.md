# Blog Application (Microservices)


### End Points

#### API Gateway
> http://localhost:8080/

Circuit Breaker Implemented

#### User Service
> http://localhost:8083/users

#### Post Service
> http://localhost:8082/posts

#### Comment Service
> http://localhost:8081/comments

#### Recommendation Service
> http://localhost:8084/feed

#### Eureka Server
> http://localhost:8761/

![eureka-server](eureka-server.png)

### Swagger UI

> http://localhost:port_number/swagger-ui.html

### Swagger API Docs

> http://localhost:port_number/v2/api-docs

### Actuators

> http://localhost:port_number/actuator/info, http://localhost:port_number/actuator/health etc..

## Architecture Diagram

![architecture](architecture.png)

## ER Diagram

![er-diagram](er-diagram.png)

## API Gateway

![api-gateway](api-gateway.svg)

#### Spring Cloud Gateway

![spring-cloud-gateway](spring-cloud-gateway.webp)

## Load Balancer

![load-balancer](load-balancer.jpg)

## Circuit Breaker

#### Resilience4j

![resilience4j](resilience4j.jpg)

##### Closed State

![closed-state](closed-state.png)

##### Open State

![open-state](open-state.png)

##### Half Open State

![half-open-state](half-open-state.png)

# Transaction Report Service

## Tech Stack

- Java21
- SpringBoot 3.1.5
- Open API
- MapStruct

## PSP Client API

- The PSP Client API token remains valid for a duration of 10 minutes.
- This token is cached for **9 minutes and 45 seconds** (15 sec buffer to avoid a staled token), and it is automatically
  added as an authorization header to each request through an interceptor.

## REPORT API

- Access swagger ui to test api after run project. [swagger-ui-link](http://localhost:8080/swagger-ui/index.html)
- Please find api-contract.yml [here](src/main/resources/api-contract.yml)

![img.png](doc/swagger.png)

## TODO
- x-api-key for service-to-service communication


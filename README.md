# Transaction Report Service

🚀 **Live URL : https://transaction-report-service.onrender.com/swagger-ui/index.html**


**Test Data**

| Key           | Value                 |
|---------------|-----------------------|
| transactionId | 981862-1499180435-111 |
| fromDate      | 2016-01-01            |
| toDate        | 2023-11-13            |

<br/>

**The Transaction Report Service** consumes the PSP client API and delivers transaction reports.

## Tech Stack

- Java21 
- SpringBoot 3.1.5
- Open API
- MapStruct

## About PSP Client API
- The Transaction Report Service consumes the PSP client API and delivers transaction reports.
- Following authorization to the PSP API, an access token is generated and remains valid for 10 minutes.
-The **Transaction Report Service** caches this token for **9 minutes and 45 seconds** (with a 15-second buffer to avoid using a stale token) and automatically adds it as an authorization header to each request for the PSP API through an interceptor.

## Run/Testing the Application

- **No manual login/authentication is required**. In the absence of a token, interceptors will automatically set it during
  the call.
- The token will be cached for a duration of 9 minutes and 45 seconds. Upon expiration, it will be evicted, and a new
  token will be provided.
- **Local test:** Access Swagger UI to test the API after running the project at http://localhost:8080/swagger-ui/index.html
- Please find api-contract.yml [here](src/main/resources/api-contract.yml)

<br/> 

 

### Overall

![img.png](doc/swagger.png)
 

## TODO

- FeignClient Decoder/Deserializer for different TransactionLists
- api-key for secure service-to-service communication
- Fail test scenarios.
- Remove underscore from response dtos.


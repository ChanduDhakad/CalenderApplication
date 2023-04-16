# CalenderApplication

# FirApplication
the Masai FIR application aims to simplify the process of filing FIRs and tracking their progress while providing a user-friendly interface and robust security feature



# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Modules

- Login Module
- Feedback Module
- User Module
- Bus Module
- Route Module
- Admin Module
- CurrentUser module






# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

    spring.datasource.url=jdbc:mysql://localhost:3306/RoamBusDB;
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```

# CalenderApplication

MasaiCalender Application - REST API
This project is a REST API for the MasaiCalender application. The API allows users to create and manage events, as well as register and log in to the application


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

- User Module
- Event Module

# Validation
- This project uses validation annotations to ensure that user input is in the correct format. The following validations are implemented:

- First Name: Must not contain numbers or special characters
- Last Name: Must not contain numbers or special characters
- Mobile Number: Must have 10 digits
- Password: Must be alphanumeric and contain 6-12 characters with at least one special character, one upper case, one lowercase, and one digit
- Date of Birth: Must not be in the future


# Exception Handling
- Custom exceptions are used for handling errors in the application.
- A global exception handler is used to handle exceptions globally.
# Authentication
- Basic authentication is implemented for user registration and login




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

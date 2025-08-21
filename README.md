# Tour Package Management Assignment

## Overview

This project is an assignment task provided by **Map My Tour**, aiming to develop a **Tour Package Management System**. 
The system is built using **Java** and follows the **Spring Boot** framework, focusing on managing various tour packages efficiently.

## Features

- **Tour Package Management**: Search packages by location, by ID, get all packages, and create a package.
- **Exception Handling**: Handled all API error responses and exceptions.
- **Swagger Implementation**: Implemented Swagger to document the API.
- **Create DTO**: Used to handle controllers separately.


## Technologies Used

- **Backend**: Java, Spring Boot
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **API Documentation**: Swagger UI


## Installation

### Steps

1. Clone the repository:

```bash
git clone https://github.com/nikhil-khure/Tour_Package_Managment_Assignment.git
cd Tour_Package_Managment_Assignment
```

2. Configure the database in `application.properties`:

```properties
 #Database connectivity
spring.datasource.url = jdbc:postgresql://localhost:5432/TourPackageDB
spring.datasource.username=postgres
spring.datasource.password=1234

 #Spring jpa settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

```

3. Build and run the application:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Application will run at: `http://localhost:8080`

## API Documentation

Swagger UI: [http://localhost:8080/swagger-ui/index.html]

## API Testing

### Using cURL Commands

1. **Get all packages**

```bash
curl -X GET http://localhost:8080/api/tours
```

2. **Get package by ID**

```bash
curl -X GET http://localhost:8080/api/tours/1
```

3. **Search packages by location**

```bash
curl -X GET "http://localhost:8080/api/tours/search?location=Leh"
```

4. **Create a new package**

```bash
curl -X POST http://localhost:8080/api/tours \
-H "Content-Type: application/json" \
-d '{
    "imgurl": "https://images.unsplash.com/photo-1598275277521-1885382d523a",
    "discountInPercentage": 17,
    "title": "Himalayan Trek Adventure",
    "description": "14-day trek through the Himalayas",
    "duration": "14Days/13Nights",
    "actualPrice": 1200}'
```
###

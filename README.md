# Microservice
## Project Overview
This project consists of two microservices:
1) Microservice1Demo - A **User Service** that manages user data.
2) Microservice2Demo - An **Order Service** that handles orders and retrieves user data from Microservice1.
These two microservices communicate via HTTP REST calls to get user data from Microservice1Demo and associate it with orders in Microservice2Demo.

## How It Works
1) Microservice2 makes a REST call to Microservice1 to get user details based on the user ID stored with the order.
2) The combined data of the order and user is returned to the client.

## Technologies Used
1) Java 17+
2) Spring Boot (for creating the microservices)
3) JPA (for database interaction in Microservice1 and Microservice2)
4) MySQL (as the database for Microservice1 and Microservice2)
5) REST API (for communication between the two services)
6) Maven (for project build management)

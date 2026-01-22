# ECommerce Application

A full-featured Spring Boot REST API for an e-commerce platform. This application provides complete functionality for managing users, products, shopping carts, and orders.

## Overview

This project is built using **Spring Boot 4.0.0** with **Java 21** and uses **PostgreSQL** as the database. It follows a clean layered architecture with clear separation of concerns.

## Features

- **User Management**: User registration, authentication, and role-based access control
- **Product Management**: Add, update, and retrieve product information
- **Shopping Cart**: Add/remove items from cart with cart management functionality
- **Order Management**: Create orders, track order status, and view order history
- **Address Management**: Store and manage customer delivery addresses

## Project Structure

```
ECommerce-Application/
├── src/
│   ├── main/
│   │   ├── java/com/app/ecommerceapplication/
│   │   │   ├── ECommerceApplication.java          # Main application entry point
│   │   │   ├── controller/                         # REST API endpoints
│   │   │   │   ├── CartController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   ├── ProductController.java
│   │   │   │   └── UserController.java
│   │   │   ├── service/                            # Business logic
│   │   │   │   ├── CartService.java
│   │   │   │   ├── OrderService.java
│   │   │   │   ├── ProductService.java
│   │   │   │   └── UserService.java
│   │   │   ├── repository/                         # Data access layer
│   │   │   │   ├── CartItemRepository.java
│   │   │   │   ├── OrderRepository.java
│   │   │   │   ├── ProductRepository.java
│   │   │   │   └── UserRepository.java
│   │   │   ├── model/                              # JPA entities
│   │   │   │   ├── User.java
│   │   │   │   ├── Product.java
│   │   │   │   ├── CartItem.java
│   │   │   │   ├── Order.java
│   │   │   │   ├── OrderItem.java
│   │   │   │   ├── Address.java
│   │   │   │   ├── UserRole.java
│   │   │   │   └── OrderStatus.java
│   │   │   └── dto/                                # Data Transfer Objects
│   │   │       ├── UserRequest.java
│   │   │       ├── UserResponse.java
│   │   │       ├── ProductRequest.java
│   │   │       ├── ProductResponse.java
│   │   │       ├── CartItemRequest.java
│   │   │       ├── OrderItemDTO.java
│   │   │       ├── OrderResponse.java
│   │   │       └── AddressDTO.java
│   │   └── resources/
│   │       └── application.yml                     # Application configuration
│   └── test/
│       └── java/com/app/ecommerceapplication/
│           └── ECommerceApplicationTests.java
├── pom.xml                                         # Maven configuration
├── mvnw / mvnw.cmd                                 # Maven wrapper
└── Docs/                                           # Documentation
```

## Architecture

The application follows a **3-tier architecture**:

1. **Controller Layer**: Handles HTTP requests and responses
2. **Service Layer**: Contains business logic and operations
3. **Repository Layer**: Data access and persistence logic

### Key Components

- **Controllers**: Handle API endpoints for users, products, cart, and orders
- **Services**: Implement business logic for each domain
- **Repositories**: Spring Data JPA repositories for database operations
- **Models**: JPA entities mapped to database tables
- **DTOs**: Transfer objects for request/response payloads

## Technology Stack

- **Framework**: Spring Boot 4.0.0
- **Language**: Java 21
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **ORM**: Hibernate/Spring Data JPA
- **API**: RESTful Web Services

## Prerequisites

- Java 21 or higher
- Maven 3.6+
- PostgreSQL 12+
- Git

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/prateek-code-22/ECommerce-Application.git
cd ECommerce-Application
```

### 2. Configure Database

Update `src/main/resources/application.yml` with your PostgreSQL credentials:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/ecomdb
    username: your_username
    password: your_password
```

### 3. Build the Project

```bash
./mvnw clean build
```

Or on Windows:

```bash
mvnw.cmd clean build
```

### 4. Run the Application

```bash
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Users
- `POST /api/users/register` - Register a new user
- `GET /api/users/{id}` - Get user details
- `PUT /api/users/{id}` - Update user information

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product details
- `POST /api/products` - Create a new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Cart
- `GET /api/cart` - Get user's cart
- `POST /api/cart/add` - Add item to cart
- `DELETE /api/cart/remove/{itemId}` - Remove item from cart

### Orders
- `POST /api/orders/create` - Create a new order
- `GET /api/orders/{id}` - Get order details
- `GET /api/orders/user/{userId}` - Get user's order history

## Database Schema

The application uses the following main entities:

- **Users**: Stores user information and authentication details
- **Products**: Catalog of available products
- **CartItems**: User's shopping cart items
- **Orders**: Order information and history
- **OrderItems**: Line items in orders
- **Addresses**: Delivery and billing addresses

## Configuration

Key configuration properties in `application.yml`:

```yaml
spring:
  application:
    name: ECommerce-Application
  jpa:
    database: POSTGRESQL
    hibernate:
      ddl-auto: update  # Auto-update database schema
  datasource:
    url: jdbc:postgresql://localhost:5432/ecomdb
    username: admin
    password: root
```

## Development

### Running Tests

```bash
./mvnw test
```

### Building for Production

```bash
./mvnw clean package -DskipTests
```

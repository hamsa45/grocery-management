# 🛒 Grocery Management System

A RESTful API-based **Online Grocery Ordering System** built with Spring Boot. This application allows users to manage customers, grocery items, and orders through a comprehensive backend system.

## 📋 Table of Contents
- [Features](#-features)
- [Technologies Used](#-technologies-used)
- [Folder Structure](#-folder-structure)
- [Prerequisites](#-prerequisites)
- [Installation & Setup](#-installation--setup)
- [Database Configuration](#-database-configuration)
- [How to Run](#-how-to-run)
- [API Endpoints](#-api-endpoints)
- [Future Enhancements](#-future-enhancements)
- [Author](#-author)

## ✨ Features

- **Customer Management**: Create, read, update, and delete customer information
- **Grocery Item Management**: Manage inventory with full CRUD operations
- **Order Management**: Process orders with multiple items
- **RESTful API Design**: Clean and intuitive REST endpoints
- **MySQL Database Integration**: Persistent data storage
- **Layered Architecture**: Follows best practices with Controller-Service-Repository pattern
- **DTO Pattern**: Secure data transfer using Data Transfer Objects
- **Lombok Integration**: Reduces boilerplate code
- **Spring Data JPA**: Simplified database operations
- **Unit Testing**: Includes test cases for service layer

## 🚀 Technologies Used

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 21 | Programming Language |
| Spring Boot | 3.5.7 | Backend Framework |
| Spring Data JPA | 3.5.7 | Database Access Layer |
| MySQL | 8.x | Relational Database |
| Lombok | Latest | Code Generation |
| Gradle | Latest | Build Tool |
| JUnit | 5.x | Testing Framework |

## 📁 Folder Structure

```
grocerymanagement/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── groceryapp/
│   │   │           └── grocerymanagement/
│   │   │               ├── controller/           # REST Controllers
│   │   │               │   ├── CustomerController.java
│   │   │               │   ├── GroceryItemController.java
│   │   │               │   └── OrderController.java
│   │   │               │
│   │   │               ├── dto/                  # Data Transfer Objects
│   │   │               │   ├── CustomerDto.java
│   │   │               │   ├── GroceryItemDto.java
│   │   │               │   ├── OrderItemRequestDto.java
│   │   │               │   ├── OrderItemResponseDto.java
│   │   │               │   ├── OrderRequestDto.java
│   │   │               │   └── OrderResponseDto.java
│   │   │               │
│   │   │               ├── entity/               # JPA Entities
│   │   │               │   ├── Customer.java
│   │   │               │   ├── GroceryItem.java
│   │   │               │   ├── Order.java
│   │   │               │   └── OrderItem.java
│   │   │               │
│   │   │               ├── mapper/               # Entity-DTO Mappers
│   │   │               │   ├── CustomerMapper.java
│   │   │               │   └── GroceryMapper.java
│   │   │               │
│   │   │               ├── repository/           # Data Access Layer
│   │   │               │   ├── CustomerRepository.java
│   │   │               │   ├── GroceryItemRepository.java
│   │   │               │   └── OrderRepository.java
│   │   │               │
│   │   │               ├── service/              # Business Logic Layer
│   │   │               │   ├── CustomerService.java
│   │   │               │   ├── GroceryItemService.java
│   │   │               │   ├── OrderService.java
│   │   │               │   └── impl/             # Service Implementations
│   │   │               │       ├── CustomerServiceImpl.java
│   │   │               │       ├── GroceryItemServiceImpl.java
│   │   │               │       └── OrderServiceImpl.java
│   │   │               │
│   │   │               └── GrocerymanagementApplication.java  # Main Application
│   │   │
│   │   └── resources/
│   │       ├── application.properties           # Application Configuration
│   │       ├── static/                          # Static Resources
│   │       └── templates/                       # Templates (if any)
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── groceryapp/
│                   └── grocerymanagement/
│                       ├── CustomerServiceTests.java
│                       └── GrocerymanagementApplicationTests.java
│
├── build.gradle                                  # Gradle Build Configuration
├── gradlew                                       # Gradle Wrapper (Unix)
├── gradlew.bat                                   # Gradle Wrapper (Windows)
├── settings.gradle                               # Gradle Settings
└── README.md                                     # Project Documentation
```

## 📌 Prerequisites

Before running this application, make sure you have:

- **Java Development Kit (JDK) 21** or higher
- **MySQL Server 8.x** installed and running
- **Gradle** (or use the included Gradle Wrapper)
- **Git** (for cloning the repository)
- An IDE like **IntelliJ IDEA**, **Eclipse**, or **VS Code**

## 🔧 Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/grocerymanagement.git
cd grocerymanagement
```

### 2. Create MySQL Database

```sql
CREATE DATABASE grocery_management;
```

### 3. Configure Database Connection

Create your own `application.properties` file from the template:

```bash
# Copy the template file
cp src/main/resources/application.properties.template src/main/resources/application.properties
```

Then update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/grocery_management?useSSL=false&serverTimezone=UTC
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

**Note:** The `application.properties` file is gitignored for security. Never commit sensitive credentials to version control.

### 4. Build the Project

```bash
./gradlew build
```

For Windows:
```bash
gradlew.bat build
```

## 🗄️ Database Configuration

The application uses **MySQL** as the primary database. The schema is automatically created/updated using Hibernate's `ddl-auto=update` setting.

**Database Schema includes:**
- `customer` - Stores customer information
- `grocery_item` - Stores grocery inventory
- `order` - Stores order information
- `order_item` - Stores individual items in each order

## ▶️ How to Run

### Using Gradle

```bash
./gradlew bootRun
```

For Windows:
```bash
gradlew.bat bootRun
```

### Using JAR File

```bash
./gradlew bootJar
java -jar build/libs/grocerymanagement-0.0.1-SNAPSHOT.jar
```

The application will start on **http://localhost:8080**

## 🌐 API Endpoints

### Customer Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/customers` | Create a new customer |
| GET | `/api/customers` | Get all customers |
| GET | `/api/customers/{id}` | Get customer by ID |
| PUT | `/api/customers/{id}` | Update customer |
| DELETE | `/api/customers/{id}` | Delete customer |

**Example Request (Create Customer):**
```json
POST /api/customers
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "1234567890",
  "address": "123 Main St"
}
```

### Grocery Item Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/grocery-items` | Add a new grocery item |
| GET | `/api/grocery-items` | Get all grocery items |
| GET | `/api/grocery-items/{id}` | Get grocery item by ID |
| PUT | `/api/grocery-items/{id}` | Update grocery item |
| DELETE | `/api/grocery-items/{id}` | Delete grocery item |

**Example Request (Add Grocery Item):**
```json
POST /api/grocery-items
{
  "name": "Organic Bananas",
  "category": "Fruits",
  "price": 2.99,
  "quantity": 100,
  "description": "Fresh organic bananas"
}
```

### Order Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/orders` | Create a new order |
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get order by ID |
| PUT | `/api/orders/{id}` | Update order |
| DELETE | `/api/orders/{id}` | Delete order |

**Example Request (Create Order):**
```json
POST /api/orders
{
  "customerId": 1,
  "orderDate": "2024-11-14",
  "orderItems": [
    {
      "groceryItemId": 1,
      "quantity": 5
    },
    {
      "groceryItemId": 2,
      "quantity": 3
    }
  ]
}
```

## 🧪 Running Tests

```bash
./gradlew test
```

Test reports will be generated in `build/reports/tests/test/index.html`

## 🔮 Future Enhancements

- [ ] Add user authentication and authorization (Spring Security)
- [ ] Implement shopping cart functionality
- [ ] Add payment gateway integration
- [ ] Create admin dashboard
- [ ] Add email notification service
- [ ] Implement order tracking system
- [ ] Add product reviews and ratings
- [ ] Create mobile-responsive frontend
- [ ] Implement search and filter functionality
- [ ] Add Docker containerization
- [ ] Deploy to cloud platform (AWS/Azure/Heroku)

## 👨‍💻 Author

**Your Name**

- GitHub: [@yourusername](https://github.com/yourusername)
- LinkedIn: [Your LinkedIn Profile](https://linkedin.com/in/yourprofile)
- Email: your.email@example.com

---

⭐ **If you find this project useful, please consider giving it a star!**

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

---

**Happy Coding! 🚀**


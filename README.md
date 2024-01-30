# Simple Inventory

Create a Spring Boot application to manage a simple inventory system for a store. The system should allow users to view a list of available products, add new products, and update existing ones. Each product should have a name, description, price, and quantity. Use Hibernate to persist the product information in a MySQL database.

## Prerequisites

- Java JDK 8 or higher
- MySQL database

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### 1. Clone the repository

Clone the repository to your local machine using the following command:


### 2. Set up the database

Create a new MySQL database named `test1`. You can use the following command in the MySQL shell:

```sql
CREATE DATABASE test1;
```

### 3. Configure the database connection

Open the application.properties file located in src/main/resources.
```
spring.datasource.url=jdbc:mysql://localhost:3306/test1
spring.datasource.username=root
spring.datasource.password=your-password
```
Replace your-password with your actual MySQL root password. If you're using a different username or port, update the properties accordingly.

### 4. Build the project
```
cd repo-name
mvn clean install
```

### 5. Run the application
Run the application using the following command:

```
mvn spring-boot:run
```
## SonarQube
![image](https://github.com/DerekAyala/inventory-task/assets/89038565/284bc1e4-5e67-4536-8c62-48dfcd5d49cf)
![image](https://github.com/DerekAyala/inventory-task/assets/89038565/5b016778-7c25-4580-a617-ac92c251ff82)



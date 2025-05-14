# REST Assured BDD Framework

This is a sample **REST API Test Automation Framework** using **Java**, **REST Assured**, **Cucumber BDD**, and **Maven**. The project demonstrates CRUD operations on product APIs.

---

## 📁 Project Structure
```

src/
│
├── main/java/com/example/productapi
│ ├── apirouting/ # Base REST call routing setup
│ ├── config/ # API and Global config files
│ ├── product/ # Product configuration classes
│ ├── modules/products/ # Business logic modules for product operations
│ ├── pojos/productPayloads/ # Request and response payload POJOs
│ ├── restAssuredApiCalls/ # Core REST Assured call utilities
│ ├── utils/sontopojo/ # JSON utility helpers
│
├── test/java/product/cucumber
│ ├── runners/ # Cucumber test runners
│ ├── stepdefinitions/ # Glue code for step definitions
│
├── resources/features/products/ # Feature files (Add, Get, Update, Delete)
│
├── pom.xml # Maven configuration
```

---

## ✅ Features Implemented

- **Add Product**
- **Get Products**
- **Update Product**
- **Delete Product**

Each feature is covered through:
- Cucumber feature file (`.feature`)
- Step Definitions in Java
- Modular and reusable code structure

---

## 🚀 Tools & Technologies

- Java 11+
- [REST Assured](https://rest-assured.io/)
- [Cucumber BDD](https://cucumber.io/)
- Maven
- JUnit
- Gherkin (for feature files)

---

## 🔧 Setup & Execution

### Prerequisites
- Java JDK 11 or higher
- Maven installed
- IDE (e.g., IntelliJ, Eclipse)

### Run Tests
To execute the tests via Maven:

```bash
mvn clean test


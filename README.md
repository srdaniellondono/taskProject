# 🚀 Task Management API

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![QA Automation](https://img.shields.io/badge/QA_Automation-FF6F00?style=for-the-badge&logo=testing-library&logoColor=white)

## 📖 About The Project

This project is a robust RESTful API built with **Java and Spring Boot** for task management.

Beyond just being a Backend application, this repository serves as a showcase of a **Quality-First approach to software engineering**. As a professional with a hybrid background in **QA Automation and Backend Development**, this project is built with clean architecture, security best practices (like environment variables management), and testability in mind.

It is designed to demonstrate how technical support and engineering teams can bridge the gap between code creation and quality assurance.

## ✨ Key Features
* **RESTful Endpoints:** Complete CRUD operations for Task management.
* **Data Persistence:** Integrated with PostgreSQL using Spring Data JPA and Hibernate.
* **Secure Configuration:** Zero hardcoded credentials. Managed entirely via Environment Variables.
* **QA Ready:** Structured to support comprehensive automated testing.

## 🛠️ Tech Stack
* **Backend:** Java 17+, Spring Boot 3+
* **Database:** PostgreSQL, Spring Data JPA, Hibernate
* **Tools:** Maven, IntelliJ IDEA, Git

## 🚦 Getting Started (Local Development)

To get a local copy up and running, follow these simple steps.

### Prerequisites
* Java JDK (17 or higher)
* Maven
* PostgreSQL installed and running locally on port `5432`.

### 1. Database Setup
Create a local database in PostgreSQL:
```sql
CREATE DATABASE task_db;
```

### 2. Clone the repo
```bash
git clone https://github.com/srdaniellondono/taskProject.git
```

### 3. Environment Variables
This project uses environment variables for database credentials to ensure security. Before running the application, configure the following variables in your IDE or system:

* `DB_USERNAME` = *your_postgres_username*
* `DB_PASSWORD` = *your_postgres_password*

*Note: If no variables are provided, the application will fail to authenticate by design.*

### 4. Run the Application
You can run the application directly from your IDE or use the Maven wrapper:
```bash
./mvnw spring-boot:run
```
The server will start on `http://localhost:8081`

## 🎯 QA & Testing Approach
This API is tested using **JUnit** and **Mockito** for unit testing, and structured to support API automation tools like **Postman** or **RestAssured**. This ensures high reliability, regression prevention, and low MTTR (Mean Time To Recovery) for bug fixing.

## 👨‍💻 Author

**Daniel Londoño Marín**
* QA Automation Engineer & Java Backend Developer
* 🔗 [LinkedIn](https://www.linkedin.com/in/danielbellanita/)
* 📧 danielbellanita@gmail.com
# 🛒 Online Shopping Web Application

## 📚 Project Overview
This project is a **Java-based web application** for online shopping, built using **Servlets, JSP**, and deployed on **Apache Tomcat**. The goal is to deeply understand the **core fundamentals of Java web development**, focusing on writing clean, testable, and maintainable code that follows **SOLID principles**.
It serves as a **real-world simulation** of an e-commerce system and is designed to provide practical hands-on experience with web technologies and backend systems.


## 🎯 Key Learning Objectives

### Web Technologies
- Understanding HTTP protocol, methods (`GET`, `POST`, etc.), and concepts like **URI vs URL**
- Lifecycle and usage of **Servlets** and `@WebServlet`
- Building views with **JSP**, using **Expression Language (EL)** and **JSTL**
- Introduction to **JSF** for future enhancement

### Java Web Application Core
- Using **Tomcat** as a web server & servlet container
- Request forwarding using `RequestDispatcher`
- Working with `HttpServletRequest` and `HttpServletResponse`
- Implementing **Servlet Filters** for cross-cutting concerns (e.g., logging, auth)

### Application Design
- Layered architecture: **Controller → Service → Repository**
- Interface-based programming & **Dependency Injection (DI)**
- Following **SOLID principles** and clean code practices

### Additional Features (To Be Implemented)
- 🧑‍💼 User Login / Logout
- 🛍️ Shopping Cart
- ✅ Checkout Process
- 📦 Order Placement & History
- 🔐 Authentication / Authorization
- ⚙️ Logging using Java Logging API
- 📦 CDI (Contexts and Dependency Injection)
- 🔄 Transaction Management

## 🏗️ Technologies Used
| Technology     | Description                           |
|----------------|---------------------------------------|
| Java 17        | Core programming language             |
| Jakarta Servlet API | For servlet development          |
| JSP + JSTL + EL| View rendering and dynamic UI         |
| Apache Tomcat  | Web server & Servlet container        |
| Maven          | Build and dependency management       |
| JUnit 3.8.1    | Unit testing                          |


## 📁 Project Structure (Overview)
```
src/
├── main/
│   ├── java/
│   │   └── com.faith.oneUmmah/
│   │       ├── dto/                 # Product DTOs
│   │       ├── service/             # Service interfaces and impl
│   │       ├── repository/          # Repository (in-memory for now)
│   │       └── web/                 # Servlets (e.g., HomeServlet)
│   └── webapp/
│       ├── WEB-INF/
│       │   └── home.jsp             # Product listing page
│       └── ...
└── test/                            # Unit tests
```

## 🧪 Testing Goals
- Unit testing for service and repository layers
- Integration tests for servlet behavior using mock requests
- Exception handling and input validation
- Manual testing in browser (end-to-end flow)

## 🔧 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/mynuddin62/online-shopping.git
   cd online-shopping
   ```

2. Build the project with Maven:
   ```bash
   mvn clean package
   ```

3. Deploy the generated `.war` (`shoppers.war`) to your Tomcat `webapps` directory.

4. Start Tomcat and navigate to:
   ```
   http://localhost:8080/shoppers/home
   ```

## 👨‍💻 Author

**Mynuddin**  
Software Engineer (Java) | FullStack web developer | Report Designer  
📬 Passionate about mastering Java Web Technologies


## 📄 License
This project is for learning purposes and is open for educational use.
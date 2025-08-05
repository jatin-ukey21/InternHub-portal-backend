````markdown
# InternHub Backend

This is the backend service for the **InternHub Portal**, built using **Spring Boot** and connected to a **MongoDB** database. It provides APIs to register internship applicants and retrieve submitted applications for the admin panel.

---

## 🛠 Tech Stack

- **Spring Boot**
- **Java 17+**
- **MongoDB** (NoSQL database)
- **Lombok** (for model boilerplate)
- **Spring Web**
- **Spring Data MongoDB**
- **CORS enabled** (to connect with React frontend)

---

## 📦 API Endpoints

### 🔹 `POST /api/registration`
- **Description:** Submits a new applicant form
- **Request Body (JSON):**
```json
{
  "name": "Kalpesh Ukey",
  "email": "kalpesh@gmail.com",
  "phone": "1111122222",
  "role": "Intern"
}
````

* **Behavior:**

  * Automatically sets `submittedAt` field to current timestamp on backend
  * Saves the record to MongoDB in the `applicants` collection

---

### 🔹 `GET /api/applicants`

* **Description:** Retrieves the list of all submitted applicants
* **Response:** Array of applicant objects

```json
[
  {
    "id": "abc123",
    "name": "Kalpesh Ukey",
    "email": "kalpesh@gmail.com",
    "phone": "1111122222",
    "role": "Intern",
    "submittedAt": "2025-08-05T14:30:00.000+00:00"
  }
]
```

---

## 🧹 Data Cleanup on Startup

The backend uses a **CommandLineRunner** to clear old data every time the application starts:

```java
@Component
public class DataCleanupRunner implements CommandLineRunner {
    private final ApplicantRepository applicantRepository;

    public DataCleanupRunner(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        applicantRepository.deleteAll();
        System.out.println("All applicants deleted on startup.");
    }
}
```

> 🔄 This ensures a **fresh database** every time you restart the backend — useful for testing/demo purposes.

---

## 🚀 Running the Project

### 📌 Prerequisites:

* Java 17+
* MongoDB running locally on port `27017` or configured URI
* Maven installed

### 🔧 Steps:

1. Clone the repo

   ```
   git clone https://github.com/jatin-ukey21/InternHub-portal-backend
   cd internhub-backend
   ```

2. Install dependencies & run

   ```
   ./mvnw spring-boot:run
   ```

3. The backend will be available at:

   ```
   http://localhost:8080
   ```

---

## 🔐 CORS Configuration

The backend allows Cross-Origin requests (CORS) so that your **React frontend** can access it without issues:

```java
@CrossOrigin(origins = "http://localhost:5173")
```

---

## 📁 Project Structure

```
src/
└── main/
    └── java/com/workskill/backend_internhub/
        ├── config/
        │   └── DataCleaner.java            # CommandLineRunner to clean DB on startup
        ├── controllers/
        │   └── ApplicantController.java    # REST API endpoints (GET, POST)
        ├── dto/
        │   └── ApplicantDTO.java           # DTO for form submission
        ├── entities/
        │   └── Applicant.java              # MongoDB document entity
        ├── repositories/
        │   └── ApplicantRepository.java    # MongoDB repository interface
        ├── services/
        │   ├── ApplicantService.java       # Business logic for applicant management
        │   └── BackendInternhubApplication.java  # Main class with @SpringBootApplication

    └── resources/
        ├── static/
        ├── templates/
        └── application.properties          # MongoDB connection and config

```

---

## ✨ Author

Made with Jatin Ukey

---

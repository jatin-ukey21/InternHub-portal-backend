# 🌐 InternHub Backend

This is the backend service for the **InternHub Portal**, built using **Spring Boot** and connected to **MongoDB**.

---

## 🛠 Tech Stack

- **Spring Boot**
- **Java 17**
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
```

- **Behavior:**
  - Automatically sets `submittedAt` field to current timestamp on backend
  - Saves the record to MongoDB in the `applicants` collection

---

### 🔹 `GET /api/applicants`

- **Description:** Retrieves the list of all submitted applicants
- **Response:** Array of applicant objects

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
public class DataCleaner implements CommandLineRunner {
    private final ApplicantRepository applicantRepository;

    public DataCleaner(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public void run(String... args) {
        applicantRepository.deleteAll();
        System.out.println("All applicants deleted on startup.");
    }
}
```

> 🔄 This ensures a **fresh database** every time you restart the backend — useful for testing/demo purposes.

---

## 🚀 Running the Project

### 📌 Prerequisites:

- Java 17+
- MongoDB running locally on port `27017` or configure your connection URI
- Maven installed

### 🔧 Steps:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/jatin-ukey21/InternHub-portal-backend
   cd internhub-backend
   ```

2. **Install dependencies & run:**

   ```bash
   ./mvnw spring-boot:run
   ```

3. **Backend runs at:**

   ```
   http://localhost:8080
   ```

---

## 🔐 CORS Configuration

CORS is enabled to allow your **React frontend** (running at `localhost:5173`) to communicate with the backend without issues:

```java
@CrossOrigin(origins = "http://localhost:5173")
```

---

## 📁 Folder Structure

```
src/
└── main/
    ├── java/com/workskill/backend_internhub/
    │   ├── config/
    │   │   └── DataCleaner.java               # Clears DB on startup
    │   ├── controllers/
    │   │   └── ApplicantController.java       # Handles API requests
    │   ├── dto/
    │   │   └── ApplicantDTO.java              # Data Transfer Object
    │   ├── entities/
    │   │   └── Applicant.java                 # MongoDB entity
    │   ├── repositories/
    │   │   └── ApplicantRepository.java       # MongoDB repository
    │   ├── services/
    │   │   ├── ApplicantService.java          # Business logic
    │   │   └── BackendInternhubApplication.java # Main app class
    └── resources/
        ├── static/
        ├── templates/
        └── application.properties             # MongoDB configs
```

---

## ✨ Author

Made by **Jatin Ukey**

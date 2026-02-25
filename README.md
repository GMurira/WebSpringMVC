🏃‍♂️ Runner Analytics
Spring Boot MVC Web Application

A robust Spring Boot MVC application for tracking running activities.
This project showcases modern Java backend development with automated data seeding, PostgreSQL integration, and a clean RESTful architecture.

🚀 Key Features

🗄 Database Persistence
Fully integrated with PostgreSQL for reliable and scalable data storage.

🔄 Automated Data Seeding
On startup, the app checks the database — if empty, it automatically loads initial data from:

src/main/resources/data/runs.json

📦 Spring Data JPA
Clean repository pattern for efficient data access and abstraction.

🌐 RESTful API
Structured endpoints to manage and retrieve running activity data.

📊 Structured Logging (SLF4J)
Clear logging for data migration, startup processes, and application health.

🛠️ Tech Stack
Technology	Purpose
Java 17+	Programming Language
Spring Boot	Core Framework
PostgreSQL	Relational Database
Jackson	JSON Serialization
Maven	Dependency Management
📂 Project Structure
src/main/
├── java/dev/murira/runner/
│   ├── run/
│   │   ├── Run.java                # Core Entity / Record
│   │   ├── Runs.java               # JSON Wrapper Record
│   │   └── RunJsonDataLoader.java  # JSON → Database Loader
│   └── controller/
│       └── RunRepository.java      # JPA Repository Interface
└── resources/
├── data/
│   └── runs.json               # Initial Seed Data
└── application.properties      # App & DB Configuration
🚦 Getting Started
✅ Prerequisites

JDK 17+

PostgreSQL (local or Docker)

Maven (or use the included Maven Wrapper)

⚙️ Configuration

Update your:

src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/runner_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
▶️ Installation & Run
1️⃣ Clone the Repository
git clone https://github.com/GMurira/WebSpringMVC.git
cd WebSpringMVC
2️⃣ Build the Project
./mvnw clean install
3️⃣ Run the Application
./mvnw spring-boot:run

Application runs at:

http://localhost:8080
🧪 Development Workflow
📥 Automatic Data Seeding

The RunJsonDataLoader class:

Uses ObjectMapper

Reads JSON from the classpath

Inserts data only if the database is empty

Example runs.json
{
"runs": [
{
"id": 1,
"title": "Evening Run",
"miles": 3.5,
"startedOn": "2024-06-01T18:00:00"
}
]
}
📡 Example API Endpoints
Method	Endpoint	Description
GET	/runs	Fetch all runs
GET	/runs/{id}	Fetch run by ID
POST	/runs	Create a new run
🐳 Docker Support (Optional Enhancement)

You can containerize the application and PostgreSQL using:

Docker

Docker Compose

If you'd like, I can generate a production-ready docker-compose.yml for this project.

🤝 Contributing

Fork the project

Create your feature branch

git checkout -b feature/AmazingFeature

Commit changes

git commit -m "Add AmazingFeature"

Push to branch

git push origin feature/AmazingFeature

Open a Pull Request

📌 Author

Geoffrey Nguyai Murira
Backend Developer | DevOps Enthusiast | Java & Cloud Engineer
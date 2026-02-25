🏃‍♂️ Runner Analytics - Spring Boot Web ApplicationA robust Spring Boot MVC application designed to track running activities. This project demonstrates modern Java development practices, including automated data seeding, PostgreSQL integration, and a RESTful architecture.🚀 Key FeaturesDatabase Persistence: Fully integrated with PostgreSQL for reliable data storage.Automated Data Loading: On startup, the application checks the database; if empty, it automatically seeds data from src/main/resources/data/runs.json.Spring Data JPA: Utilizes repository patterns for clean and efficient data access.RESTful API: Provides endpoints to manage and retrieve run data.Logging: Detailed SLF4J logging for monitoring data migration and application health.🛠️ Technology StackTechnologyPurposeJava 17+Programming LanguageSpring Boot 4.0Core FrameworkPostgreSQLRelational DatabaseJackson 3.xJSON MarshallingMavenDependency Management📂 Project StructurePlaintextsrc/main/
├── java/dev/murira/runner/
│   ├── run/
│   │   ├── Run.java                # Core Entity / Record
│   │   ├── Runs.java               # JSON Wrapper Record
│   │   └── RunJsonDataLoader.java  # Logic to load JSON to DB
│   └── controller/
│       └── RunRepository.java      # JPA Repository Interface
└── resources/
├── data/
│   └── runs.json               # Initial seed data
└── application.properties      # Database & App Config
🚦 Getting StartedPrerequisitesJDK 17 or higher.PostgreSQL instance running locally or via Docker.Maven installed.ConfigurationUpdate your src/main/resources/application.properties with your database credentials:Propertiesspring.datasource.url=jdbc:postgresql://localhost:5432/runner_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Installation & RunClone the repository:Bashgit clone https://github.com/GMurira/WebSpringMVC.git
cd WebSpringMVC
Build the project:Bash./mvnw clean install
Run the application:Bash./mvnw spring-boot:run
🧪 Development WorkflowData SeedingThe RunJsonDataLoader class handles the initial import. It uses the ObjectMapper to read from the classpath.JSON Schema (runs.json):JSON{
"runs": [
{
"id": 1,
"title": "Evening Run",
"miles": 3.5,
"startedOn": "2024-06-01T18:00:00"
}
]
}
🤝 ContributingFork the ProjectCreate your Feature Branch (git checkout -b feature/AmazingFeature)Commit your Changes (git commit -m 'Add some AmazingFeature')Push to the Branch (git push origin feature/AmazingFeature)Open a Pull RequestWould you like me to add a section on how to run this application using Docker and Docker Compose for the PostgreSQL database?
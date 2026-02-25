🏃‍♂️ Runner ApplicationA Spring Boot-based activity tracker designed to manage and persist running data. This application features an automated data loader that synchronizes JSON-based records into a relational database on startup.🚀 FeaturesAutomated Data Seeding: Automatically detects an empty database and populates it from src/main/resources/data/runs.json.RESTful API: Manage and query your running activities through standard HTTP endpoints.Modern Stack: Built with Spring Boot 4.0 and Jackson 3.x for high-performance JSON processing.Logging: Integrated SLF4J logging for monitoring data migration and application health.🛠️ Tech StackTechnologyPurposeJava 17+Core Programming LanguageSpring Boot 4.xApplication FrameworkJackson 3.xJSON Serialization/DeserializationSpring Data JPADatabase Abstraction & PersistenceH2 / PostgreSQLDatabase (Change as per your application.properties)📂 Project StructurePlaintextsrc/main/
        ├── java/dev/murira/runner/
        │   ├── run/
        │   │   ├── Run.java                # Entity/Record model
│   │   ├── Runs.java                # Wrapper for JSON lists
│   │   └── RunJsonDataLoader.java   # Startup data logic
│   └── controller/
        │       └── RunRepository.java       # Data Access Layer
└── resources/
        ├── data/
        │   └── runs.json                # Initial seed data
    └── application.properties       # App configuration
🚦 Getting StartedPrerequisitesJDK 17 or higherMaven 3.x or GradleInstallationClone the repositoryBashgit clone https://github.com/your-username/runner-app.git
cd runner-app
Add your dataEnsure your JSON file is located at src/main/resources/data/runs.json following this structure:JSON{
    "runs": [
    {
        "id": 1,
            "title": "Morning Jog",
            "miles": 5,
            "startedOn": "2024-05-20T08:00:00"
    }
  ]
}
Build and RunBash./mvnw spring-boot:run
🧪 Development NotesData Loading LogicThe RunJsonDataLoader component implements CommandLineRunner. Upon startup, it checks if the RunRepository is empty. If no records exist, it attempts to load the runs.json file from the classpath.Note: If you encounter a null src error, ensure the file path in RunJsonDataLoader matches the physical file location in the resources folder exactly.API Endpoints (Planned/Existing)GET /api/runs - Retrieve all runs.GET /api/runs/{id} - Find a specific run by ID.POST /api/runs - Manually add a new run.📄 LicenseThis project is licensed under the MIT License - see the LICENSE file for details.Would you like me to add a specific section for Docker setup or GitHub Actions CI/CD to this README?
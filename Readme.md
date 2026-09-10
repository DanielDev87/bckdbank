bank-core/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── bank/
│   │   │           └── core/
│   │   │               ├── BankCoreApplication.java
│   │   │               │
│   │   │               ├── config/                # Configuraciones globales (Security, CORS, Swagger)
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── JwtProperties.java
│   │   │               │
│   │   │               ├── controller/            # Capa REST (Controllers / DTOs de entrada)
│   │   │               │   ├── AuthController.java
│   │   │               │   ├── AccountController.java
│   │   │               │   └── TransactionController.java
│   │   │               │
│   │   │               ├── dto/                   # Data Transfer Objects (Requests & Responses)
│   │   │               │   ├── request/
│   │   │               │   │   ├── LoginRequest.java
│   │   │               │   │   ├── RegisterRequest.java
│   │   │               │   │   └── TransferRequest.java
│   │   │               │   └── response/
│   │   │               │       ├── AuthResponse.java
│   │   │               │       ├── AccountResponse.java
│   │   │               │       └── TransactionResponse.java
│   │   │               │
│   │   │               ├── entity/                # Entidades JPA (Mapeo a tablas MySQL)
│   │   │               │   ├── User.java
│   │   │               │   ├── Account.java
│   │   │               │   ├── Transaction.java
│   │   │               │   └── enums/
│   │   │               │       ├── Role.java
│   │   │               │       ├── AccountType.java
│   │   │               │       └── TransactionType.java
│   │   │               │
│   │   │               ├── repository/            # Interfases Spring Data JPA
│   │   │               │   ├── UserRepository.java
│   │   │               │   ├── AccountRepository.java
│   │   │               │   └── TransactionRepository.java
│   │   │               │
│   │   │               ├── service/               # Lógica de Negocio (Interfaces e Implementaciones)
│   │   │               │   ├── AuthService.java
│   │   │               │   ├── AccountService.java
│   │   │               │   ├── TransactionService.java
│   │   │               │   └── impl/
│   │   │               │       ├── AuthServiceImpl.java
│   │   │               │       ├── AccountServiceImpl.java
│   │   │               │       └── TransactionServiceImpl.java
│   │   │               │
│   │   │               ├── security/              # Componentes JWT y Spring Security
│   │   │               │   ├── JwtTokenProvider.java
│   │   │               │   ├── JwtAuthenticationFilter.java
│   │   │               │   └── CustomUserDetailsService.java
│   │   │               │
│   │   │               └── exception/             # Manejo global de errores y excepciones personalizadas
│   │   │                   ├── GlobalExceptionHandler.java
│   │   │                   ├── InsufficientBalanceException.java
│   │   │                   └── ResourceNotFoundException.java
│   │   │
│   │   └── resources/
│   │       ├── application.yml                    # Configuración de propiedades
│   │       ├── application-dev.yml                # Perfil de desarrollo
│   │       └── db/migration/                      # Scripts Flyway/Liquibase (Opcional pero recomendado)
│   │           └── V1__init_schema.sql
│   │
│   └── test/                                     # Pruebas unitarias e integración
│       └── java/
│           └── com/
│               └── bank/
│                   └── core/
│                       ├── service/
│                       └── controller/
│
├── pom.xml (o build.gradle)                       # Gestión de dependencias
└── Dockerfile                                    # Para la etapa de CI/CD


Presiona Ctrl + Shift + P (o Cmd + Shift + P en Mac) para abrir la paleta de comandos.Escribe y ejecuta: Java: Clean Java Language Server Workspace.Haz clic en Restart and Delete cuando te lo pida. Esto reiniciará el entorno de desarrollo y limpiará la caché.
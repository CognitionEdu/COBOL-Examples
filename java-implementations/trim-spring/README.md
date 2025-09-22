# COBOL Trim Function - Java Spring Implementation

This project is a Java Spring Boot implementation that replicates the functionality of the COBOL [`trim.cbl`](../../trim/trim.cbl) example from the CognitionEdu/COBOL-Examples repository.

## Original COBOL Functionality

The original COBOL program ([`trim/trim.cbl`](../../trim/trim.cbl)) demonstrates:
- `FUNCTION TRIM(string)` - Removes leading and trailing spaces
- `FUNCTION TRIM(string LEADING)` - Removes only leading spaces  
- `FUNCTION TRIM(string TRAILING)` - Removes only trailing spaces
- Works with both variables and string literals
- Visual output showing before/after with `--` delimiters

## Java Spring Implementation

### Features
- **REST API endpoints** for trim operations
- **Service layer** with trim logic matching COBOL behavior
- **Model classes** for structured responses
- **Unit tests** validating functionality
- **Console demo** replicating COBOL output format

### API Endpoints

- `POST /api/trim/both` - Trim leading and trailing spaces
- `POST /api/trim/leading` - Trim only leading spaces
- `POST /api/trim/trailing` - Trim only trailing spaces
- `GET /api/trim/demo` - Demonstrate all trim functions
- `GET /api/trim/console-demo` - Print COBOL-style output to console
- `GET /api/trim/health` - Service health check

### Running the Application

```bash
# Compile and run
mvn spring-boot:run

# Or build and run JAR
mvn clean package
java -jar target/trim-service-1.0.0.jar
```

### Testing the API

```bash
# Test trim both
curl -X POST http://localhost:8080/api/trim/both \
  -H "Content-Type: application/json" \
  -d '{"input": "    hello world       "}'

# Get demonstration
curl http://localhost:8080/api/trim/demo

# View console output
curl http://localhost:8080/api/trim/console-demo
```

### Example Output

The `/api/trim/demo` endpoint returns:
```json
[
  {
    "original": "    hello world       ",
    "trimmed": "hello world",
    "trimType": "BOTH"
  },
  {
    "original": "    hello world       ",
    "trimmed": "hello world       ",
    "trimType": "LEADING"
  },
  {
    "original": "    hello world       ",
    "trimmed": "    hello world",
    "trimType": "TRAILING"
  }
]
```

## Comparison with COBOL

| COBOL | Java Spring |
|-------|-------------|
| `FUNCTION TRIM(ws-string)` | `trimService.trimBoth(input)` |
| `FUNCTION TRIM(ws-string LEADING)` | `trimService.trimLeading(input)` |
| `FUNCTION TRIM(ws-string TRAILING)` | `trimService.trimTrailing(input)` |
| `DISPLAY "--" result "--"` | `formatOutput(input, result)` |
| Console output | REST API + Console demo |

## Project Structure

```
src/
├── main/java/com/example/trimservice/
│   ├── TrimServiceApplication.java     # Spring Boot main class
│   ├── controller/TrimController.java  # REST endpoints
│   ├── service/TrimService.java        # Business logic
│   └── model/TrimResult.java          # Response model
├── main/resources/
│   └── application.properties         # Configuration
└── test/java/com/example/trimservice/
    └── TrimServiceTest.java           # Unit tests
```

## Requirements

- Java 17+
- Maven 3.6+
- Spring Boot 3.1.5

## Author

Refactored from COBOL example by Erik Eriksen ([`trim/trim.cbl`](../../trim/trim.cbl)) into Java Spring implementation.

## Related Examples

- **Original COBOL Implementation**: [`trim/trim.cbl`](../../trim/trim.cbl) - The source COBOL program this Java version replicates
- **COBOL Documentation**: [`trim/README.md`](../../trim/README.md) - Detailed explanation of the COBOL TRIM function

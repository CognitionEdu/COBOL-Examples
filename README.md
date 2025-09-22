# COBOL Trim Function - Spring Boot Implementation

This Spring Boot application refactors the COBOL trim.cbl module into a Java web application that provides equivalent string trimming functionality.

## Overview

The original COBOL program `trim.cbl` demonstrates three trim operations:
- Default trim (both leading and trailing spaces)
- Leading-only trim  
- Trailing-only trim

This Spring Boot application replicates that functionality with REST endpoints and a web interface.

## Features

- **REST Endpoints**: Three endpoints that mirror COBOL trim functionality
  - `POST /trim/default` - Trims both leading and trailing spaces
  - `POST /trim/leading` - Trims only leading spaces
  - `POST /trim/trailing` - Trims only trailing spaces

- **Web Interface**: Interactive HTML page that displays before/after results with visual delimiters (--) similar to the COBOL display output

- **StringTrimService**: Core service class with methods corresponding to each trim operation

- **Comprehensive Testing**: Unit tests that verify the same behavior as the COBOL examples

## Technical Specifications

- Spring Boot 3.2.0
- Java 17
- Maven build system
- Thymeleaf for web templates
- JUnit 5 for testing

## Running the Application

1. Ensure Java 17 and Maven are installed
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. Open browser to `http://localhost:8080`

## Testing

Run unit tests with:
```bash
mvn test
```

## API Usage

### Request Format
```json
{
  "input": "    hello world       "
}
```

### Response Format
```json
{
  "original": "    hello world       ",
  "trimmed": "hello world",
  "operation": "default"
}
```

## COBOL Compatibility

This implementation maintains the same test cases and expected outputs as documented in the original COBOL program:

- Test string: `"    hello world       "`
- String literals: `"    String literal    "`
- Visual output format with `--` delimiters
- Exact behavior matching COBOL intrinsic TRIM function

## Project Structure

```
src/
├── main/
│   ├── java/com/example/trimservice/
│   │   ├── TrimServiceApplication.java
│   │   ├── controller/
│   │   │   ├── TrimController.java
│   │   │   └── WebController.java
│   │   └── service/
│   │       └── StringTrimService.java
│   └── resources/
│       └── templates/
│           └── index.html
└── test/
    └── java/com/example/trimservice/
        ├── controller/
        │   └── TrimControllerTest.java
        └── service/
            └── StringTrimServiceTest.java
```

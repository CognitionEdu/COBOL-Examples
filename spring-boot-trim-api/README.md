# COBOL Trim to Spring Boot 3 API

This Spring Boot 3 application converts the COBOL trim functionality from `trim.cbl` into a modern REST API.

## Overview

The original COBOL program demonstrates three string trimming operations:
- `FUNCTION TRIM(string)` - removes leading and trailing spaces
- `FUNCTION TRIM(string LEADING)` - removes only leading spaces  
- `FUNCTION TRIM(string TRAILING)` - removes only trailing spaces

This Spring Boot application provides equivalent functionality through REST endpoints.

## API Endpoints

### Base URL
```
http://localhost:8080/api/trim
```

### Endpoints

#### 1. Trim Both Leading and Trailing Spaces
```http
POST /api/trim/both
Content-Type: application/json

{
  "input": "    hello world       "
}
```

**Response:**
```json
{
  "original": "    hello world       ",
  "trimmed": "hello world",
  "operation": "both"
}
```

#### 2. Trim Leading Spaces Only
```http
POST /api/trim/leading
Content-Type: application/json

{
  "input": "    hello world       "
}
```

**Response:**
```json
{
  "original": "    hello world       ",
  "trimmed": "hello world       ",
  "operation": "leading"
}
```

#### 3. Trim Trailing Spaces Only
```http
POST /api/trim/trailing
Content-Type: application/json

{
  "input": "    hello world       "
}
```

**Response:**
```json
{
  "original": "    hello world       ",
  "trimmed": "    hello world",
  "operation": "trailing"
}
```

## Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Build and Run
```bash
# Navigate to the application directory
cd spring-boot-trim-api

# Build the application
./mvnw clean compile

# Run tests
./mvnw test

# Start the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

### Testing with curl

Test the endpoints using curl:

```bash
# Test trim both
curl -X POST http://localhost:8080/api/trim/both \
  -H "Content-Type: application/json" \
  -d '{"input":"    hello world       "}'

# Test trim leading
curl -X POST http://localhost:8080/api/trim/leading \
  -H "Content-Type: application/json" \
  -d '{"input":"    hello world       "}'

# Test trim trailing  
curl -X POST http://localhost:8080/api/trim/trailing \
  -H "Content-Type: application/json" \
  -d '{"input":"    hello world       "}'
```

## COBOL to Java Mapping

| COBOL Function | Java Method | Spring Endpoint |
|---|---|---|
| `FUNCTION TRIM(string)` | `String.trim()` | `POST /api/trim/both` |
| `FUNCTION TRIM(string LEADING)` | `String.stripLeading()` | `POST /api/trim/leading` |
| `FUNCTION TRIM(string TRAILING)` | `String.stripTrailing()` | `POST /api/trim/trailing` |

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/cobol/examples/trim/
│   │       ├── TrimApiApplication.java      # Main Spring Boot application
│   │       ├── controller/
│   │       │   └── TrimController.java      # REST endpoints
│   │       ├── service/
│   │       │   └── TrimService.java         # Business logic
│   │       └── dto/
│   │           ├── TrimRequest.java         # Request DTO
│   │           └── TrimResponse.java        # Response DTO
│   └── resources/
│       └── application.yml                  # Application configuration
└── test/
    └── java/
        └── com/cobol/examples/trim/
            ├── controller/
            │   └── TrimControllerTest.java  # Controller tests
            └── service/
                └── TrimServiceTest.java     # Service tests
```

## Features

- **Spring Boot 3**: Latest Spring Boot framework
- **REST API**: JSON request/response format
- **Validation**: Input validation with proper error handling
- **CORS Support**: Cross-origin requests enabled
- **Comprehensive Tests**: Unit tests for both service and controller layers
- **Maven Build**: Standard Maven project structure

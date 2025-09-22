# COBOL Trim Function - Java Spring Implementation

This is a Java Spring Boot implementation of the COBOL trim functionality from `trim.cbl`.

## Original COBOL Functionality
The original COBOL program demonstrates three types of string trimming:
- `function trim(string)` - trims both leading and trailing spaces
- `function trim(string leading)` - trims only leading spaces  
- `function trim(string trailing)` - trims only trailing spaces

## Java Implementation

### StringTrimService
Spring service component that provides three methods:
- `trimBoth(String)` - equivalent to COBOL `function trim(string)`
- `trimLeading(String)` - equivalent to COBOL `function trim(string leading)`
- `trimTrailing(String)` - equivalent to COBOL `function trim(string trailing)`

### Running the Demo
```bash
mvn spring-boot:run
```

This will output the same results as the original COBOL program.

### Running Tests
```bash
mvn test
```

## Design Decisions
- Used Java's built-in `String.trim()`, `String.stripLeading()`, and `String.stripTrailing()` methods
- Structured as Spring Boot application for easy dependency injection and testing
- Maintained exact output format to match COBOL program behavior
- Added null safety checks for robustness

## Expected Output
The Java implementation produces the same output as the original COBOL program:

```
--    hello world               --
--hello world--
--hello world               --
--    hello world--
******************************
    hello world               
******************************
hello world                   
******************************
hello world               
******************************
    hello world               
--    String literal    --
--String literal--
--String literal   --
--   String literal--
```

## Architecture
- **TrimApplication**: Main Spring Boot application class
- **StringTrimService**: Core service with trimming functionality
- **TrimDemoRunner**: CommandLineRunner that demonstrates the functionality
- **StringTrimServiceTest**: Comprehensive unit tests

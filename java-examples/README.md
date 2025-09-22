# COBOL Examples - Java Conversion

This directory contains Java implementations of all the COBOL example programs from the parent repository. Each Java program maintains the same functionality as its COBOL counterpart while demonstrating equivalent Java patterns and libraries.

## Overview

The conversion demonstrates how traditional COBOL programming concepts translate to modern Java:

- **COBOL ACCEPT statements** → Java Scanner class and console input
- **COBOL DISPLAY statements** → Java System.out.println()
- **COBOL record structures** → Java POJOs (Plain Old Java Objects)
- **COBOL REDEFINES** → Java ByteBuffer and union-like patterns
- **COBOL sub-programs** → Java methods and classes
- **COBOL database operations** → JDBC with PreparedStatement and ResultSet
- **COBOL JSON/XML generation** → Jackson and JAXB libraries

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher
- PostgreSQL database (for SQL examples)

## Building and Running

### Compile all examples:
```bash
mvn compile
```

### Run a specific example:
```bash
mvn exec:java -Dexec.mainClass="edu.cognition.examples.accept.AcceptExample"
```

### Or compile and run manually:
```bash
javac -cp "target/classes:$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q)" src/main/java/edu/cognition/examples/accept/AcceptExample.java
java -cp "target/classes:$(mvn dependency:build-classpath -Dmdep.outputFile=/dev/stdout -q)" edu.cognition.examples.accept.AcceptExample
```

## Examples Included

### User Input Examples (`accept/`)
- **AcceptExample.java** - Basic user input with Scanner
- **AcceptSecureExample.java** - Secure password input
- **AcceptFromExample.java** - Command-line arguments and environment variables

### Data Serialization Examples
- **JsonGenerateExample.java** (`json_generate/`) - JSON generation using Jackson
- **XmlGenerateExample.java** (`xml_generate/`) - XML generation using JAXB

### Database Examples (`sql/`)
- **SqlExample.java** - PostgreSQL database operations using JDBC
- **DatabaseRecord.java** - Java representation of database records

### String Processing Examples
- **TrimExample.java** (`trim/`) - String trimming operations
- **UnstringExample.java** (`unstring/`) - String parsing and tokenization

### Data Structure Examples
- **RedefinesExample.java** (`redefines/`) - Memory layout and data interpretation
- **SubProgramExample.java** (`sub_program/`) - Method calling and parameter passing

### System Examples
- **ScreenSizeExample.java** (`screen_size/`) - Terminal dimension detection

## Key Dependencies

- **PostgreSQL JDBC Driver** - Database connectivity
- **Jackson** - JSON processing
- **JAXB** - XML processing  
- **JLine** - Terminal operations

## Comparison with COBOL

Each Java example includes detailed comments explaining:
- How COBOL concepts map to Java equivalents
- Differences in approach between the languages
- Java-specific best practices and patterns

## Database Setup

For SQL examples, run the provided SQL script:
```sql
-- Use the create_test_db.sql from the parent sql/ directory
```

## Educational Value

These examples serve as a bridge for developers learning Java who have COBOL experience, or vice versa. They demonstrate:

1. **Language paradigm differences** - Procedural COBOL vs Object-Oriented Java
2. **Data handling** - Fixed-length records vs dynamic objects
3. **I/O operations** - COBOL ACCEPT/DISPLAY vs Java Scanner/System.out
4. **Database access** - Embedded SQL vs JDBC
5. **Error handling** - COBOL condition codes vs Java exceptions

Each example maintains the same input/output behavior as its COBOL counterpart, making it easy to compare approaches and understand the conversion process.

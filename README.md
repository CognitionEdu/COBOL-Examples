# COBOL Examples

This is a comprehensive collection of example and test COBOL programs demonstrating various features and capabilities of the COBOL programming language using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments. The repository serves as an educational resource for both newcomers to COBOL and experienced developers exploring advanced features like database integration, data serialization, and system interaction.

I'm currently in the process of updating each folder with a README.md file and more comments so that the examples are easier to follow along with.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Example Categories](#example-categories)
  - [Database Integration](#database-integration)
  - [Input/Output Operations](#inputoutput-operations)
  - [Data Serialization](#data-serialization)
  - [String Processing](#string-processing)
  - [Data Structures](#data-structures)
  - [Program Modularity](#program-modularity)
  - [Data Validation](#data-validation)
  - [File Operations](#file-operations)
  - [Screen/Display Operations](#screendisplay-operations)
  - [System Integration](#system-integration)
- [Compilation Instructions](#compilation-instructions)
- [Contributing](#contributing)

## Prerequisites

All programs were written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux. To run all examples, you'll need:

### Basic Requirements
- **GnuCOBOL compiler** - The open-source COBOL compiler
- **Linux environment** - Examples are tested on Linux distributions

### Optional External Libraries
Some examples require additional libraries to be installed and configured during GnuCOBOL compilation:

- **libxml2** - For XML generation examples (`--with-xml2`)
- **libjson-c** - For JSON generation examples (`--with-json`)
- **PostgreSQL + unixODBC** - For database examples (`--with-db`)
- **esqlOC precompiler** - For embedded SQL processing

### Verifying Your Installation
Check your GnuCOBOL installation and available libraries:
```bash
cobcrun --info
```

This should display information about your GnuCOBOL version and any configured libraries.

## Quick Start

To compile and run any COBOL program from this repository:

1. Navigate to an example directory:
   ```bash
   cd display_test
   ```

2. Compile the COBOL program:
   ```bash
   cobc -x display-test.cbl
   ```

3. Run the compiled executable:
   ```bash
   ./display-test
   ```

## Example Categories

### Database Integration

**Directory:** [`sql/`](sql/)

Demonstrates how to connect COBOL programs to PostgreSQL databases using embedded SQL and the esqlOC precompiler. Features include:
- Database connection and querying
- Variable-length string handling in SQL operations
- SQLCA (SQL Communication Area) usage
- ODBC integration patterns

**Key Learning:** Modern COBOL applications can integrate seamlessly with relational databases.

### Input/Output Operations

**Directories:** [`accept/`](accept/), [`read_command_args/`](read_command_args/)

Comprehensive examples of the `ACCEPT` statement for various input scenarios:
- Basic user input and secure password entry
- Command-line argument processing
- Environment variable access
- System information retrieval (date, time, user)
- Screen mode operations and cursor positioning

**Key Learning:** COBOL provides rich I/O capabilities beyond simple console input/output.

### Data Serialization

**Directories:** [`json_generate/`](json_generate/), [`xml_generate/`](xml_generate/)

Modern data interchange format support in COBOL:
- **JSON Generation:** Convert COBOL data structures to JSON using `JSON GENERATE`
- **XML Generation:** Create XML documents from COBOL records using `XML GENERATE`
- Field mapping and type conversion
- Integration with external libraries (libjson-c, libxml2)

**Key Learning:** COBOL can work with modern data formats for web services and API integration.

### String Processing

**Directories:** [`trim/`](trim/), [`unstring/`](unstring/)

Advanced string manipulation techniques:
- **TRIM Function:** Remove leading/trailing spaces with various options
- **UNSTRING Operation:** Parse delimited strings into multiple variables
- Multiple delimiter handling
- Pointer management and overflow detection
- String tokenization patterns

**Key Learning:** COBOL provides powerful built-in string processing capabilities.

### Data Structures

**Directories:** [`redifines/`](redifines/), [`search/`](search/)

Memory management and data organization:
- **REDEFINES:** Share memory between different data structures
- **Table Operations:** Binary search (`SEARCH ALL`) and sequential search (`SEARCH`)
- Indexed table management
- Data type conversion and interpretation

**Key Learning:** COBOL offers flexible data structure definitions and efficient search algorithms.

### Program Modularity

**Directory:** [`sub_program/`](sub_program/)

Inter-program communication and memory management:
- Sub-program calling with parameter passing
- `BY CONTENT` vs `BY REFERENCE` parameter modes
- Working-storage vs local-storage variable persistence
- Program cancellation and memory cleanup

**Key Learning:** COBOL supports modular programming with sophisticated parameter passing mechanisms.

### Data Validation

**Directories:** [`is_numeric/`](is_numeric/), [`numval_test/`](numval_test/), [`comp_test/`](comp_test/)

Data type validation and conversion:
- **Numeric Validation:** `IS NUMERIC` condition testing with various data formats
- **Type Conversion:** `NUMVAL` function for string-to-numeric conversion
- **COMP Data Types:** Binary data storage and display conversion
- Input sanitization techniques

**Key Learning:** COBOL provides robust data validation and type conversion capabilities.

### File Operations

**Directory:** [`merge_sort/`](merge_sort/)

Advanced file processing operations:
- **MERGE Operation:** Combine multiple sorted files
- **SORT Operation:** Sort file data on multiple keys
- File descriptor management
- Sequential file processing patterns

**Key Learning:** COBOL excels at batch file processing with built-in sort/merge capabilities.

### Screen/Display Operations

**Directories:** [`display_test/`](display_test/), [`screen_size/`](screen_size/), [`mouse/`](mouse/), [`display_timing/`](display_timing/)

Terminal and screen management:
- **Display Formatting:** Screen positioning, colors, and special effects
- **Screen Size Detection:** Terminal dimension retrieval
- **Mouse Interaction:** Simple drawing program with mouse input
- **Timing Operations:** Display timing and screen refresh

**Key Learning:** COBOL can create interactive terminal applications with rich display capabilities.

### System Integration

**Directory:** [`report_writer/`](report_writer/)

System-level operations and reporting:
- Report generation and formatting
- System resource interaction
- File system operations

**Key Learning:** COBOL integrates well with system-level operations and reporting requirements.

## Compilation Instructions

### Basic Compilation
For simple programs without external dependencies:
```bash
cobc -x program-name.cbl
```

### With External Libraries
For programs requiring specific libraries:
```bash
# JSON generation (requires libjson-c)
cobc -x json_program.cbl

# XML generation (requires libxml2)  
cobc -x xml_program.cbl

# Database operations (requires ODBC libraries)
cobc -x -static -locsql generated_sql_ex.cbl
```

### SQL Preprocessing
For embedded SQL programs:
```bash
# Preprocess embedded SQL
esqlOC -static -o generated_program.cbl source_program.cbl

# Compile the generated COBOL
cobc -x -static -locsql generated_program.cbl
```

### GnuCOBOL Configuration
To enable external libraries during GnuCOBOL compilation:
```bash
./configure --with-xml2 --with-json --with-db
make && make install
```

## Contributing

This repository demonstrates various COBOL programming techniques and patterns. Each example includes:
- Source code with explanatory comments
- README.md with usage instructions and expected output
- Compilation requirements and dependencies

When exploring the examples, start with basic I/O operations in the `accept/` and `display_test/` directories, then progress to more advanced topics like database integration and data serialization based on your learning objectives.  




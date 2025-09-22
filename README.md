# COBOL Examples

A comprehensive collection of COBOL programming examples demonstrating core language features, modern integrations, and best practices using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Table of Contents
- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Example Categories](#example-categories)
  - [User Input & Command Line Processing](#user-input--command-line-processing)
  - [String Processing & Manipulation](#string-processing--manipulation)
  - [Database Integration](#database-integration)
  - [Data Serialization](#data-serialization)
  - [Screen & Display Management](#screen--display-management)
  - [Data Structures & Search Operations](#data-structures--search-operations)
  - [File Operations & Data Processing](#file-operations--data-processing)
  - [Data Types & Conversion](#data-types--conversion)
  - [Program Structure & Modularity](#program-structure--modularity)
- [Compilation Guide](#compilation-guide)
- [Contributing](#contributing)

## Overview

This repository serves as an educational resource for COBOL developers learning to use GnuCOBOL in modern Linux environments. Each example directory contains working COBOL programs with detailed documentation, demonstrating specific language features and integration patterns.

**Target Audience:**
- COBOL students and educators seeking practical, well-documented examples
- Developers migrating to GnuCOBOL from other COBOL compilers
- System integrators connecting COBOL applications with modern technologies

**Key Features:**
- Executable examples with expected output documentation
- Integration patterns for databases, XML/JSON, and system resources
- Comprehensive setup and compilation instructions
- Progressive complexity from basic syntax to advanced integrations

## Prerequisites

**Base Requirements:**
- Linux operating system (Ubuntu/Debian recommended)
- [GnuCOBOL compiler](https://gnucobol.sourceforge.io/) installed

**For Advanced Examples:**
- **Database Integration:** PostgreSQL, unixODBC, odbc-postgresql driver, [esqlOC precompiler](https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/)
- **JSON Generation:** [libjson-c](https://github.com/json-c/json-c) library (configure GnuCOBOL with `--with-json`)
- **XML Generation:** [libxml2](https://github.com/GNOME/libxml2) library (configure GnuCOBOL with `--with-xml2`)

## Quick Start

1. **Clone the repository:**
   ```bash
   git clone https://github.com/CognitionEdu/COBOL-Examples.git
   cd COBOL-Examples
   ```

2. **Compile and run a basic example:**
   ```bash
   cd display_test
   cobc -x display-test.cbl
   ./display-test
   ```

3. **For examples requiring external libraries, see individual directory README files for specific setup instructions.**

## Example Categories

### User Input & Command Line Processing

Learn how to handle user input, command line arguments, and secure data entry in COBOL applications.

- **[accept/](accept/)** - Comprehensive ACCEPT statement examples including:
  - Basic user input with `ACCEPT ws-variable`
  - Screen mode operations with positioning and timeouts
  - Secure password input with the `SECURE` keyword
  - Environment variables and system information retrieval
  - Command line argument processing with `FROM COMMAND-LINE`, `FROM ARGUMENT-NUMBER`

- **[read_command_args/](read_command_args/)** - Additional command line argument processing examples

**Key Concepts:** ACCEPT statement variations, screen mode, secure input, environment access, argument parsing

### String Processing & Manipulation

Master COBOL's powerful string manipulation capabilities and validation functions.

- **[trim/](trim/)** - Intrinsic TRIM function examples:
  ```cobol
  FUNCTION TRIM(ws-variable)           *> Trim both leading/trailing
  FUNCTION TRIM(ws-variable LEADING)   *> Trim leading spaces only
  FUNCTION TRIM(ws-variable TRAILING)  *> Trim trailing spaces only
  ```

- **[unstring/](unstring/)** - String parsing and tokenization:
  ```cobol
  UNSTRING ws-source-str 
      DELIMITED BY '=' OR '<' OR '>'
      INTO ws-part-1 ws-part-2
      WITH POINTER ws-pointer
  END-UNSTRING
  ```

- **[is_numeric/](is_numeric/)** - Numeric validation techniques including space handling and trimming strategies

- **[numval_test/](numval_test/)** - Converting character strings to numeric values:
  ```cobol
  COMPUTE ws-total = FUNCTION NUMVAL(ws-x-val) + ws-9-val
  ```

**Key Concepts:** Intrinsic functions, string parsing, numeric validation, data conversion

### Database Integration

Connect COBOL applications to modern databases with full SQL support.

- **[sql/](sql/)** - PostgreSQL integration using esqlOC precompiler:
  - Database connection and query execution
  - Variable-length string handling in SQL operations
  - SQLCA (SQL Communication Area) usage
  - Embedded SQL preprocessing workflow

**Prerequisites:** PostgreSQL, unixODBC, odbc-postgresql, esqlOC precompiler

**Build Process:**
```bash
# Precompile embedded SQL
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
# Compile with OCSQL library
cobc -x -static -locsql generated_sql_ex.cbl
```

**Key Concepts:** Embedded SQL, database connectivity, precompiler usage, SQLCA structure

### Data Serialization

Generate modern data formats (JSON/XML) from COBOL data structures.

- **[json_generate/](json_generate/)** - JSON document generation:
  ```cobol
  JSON GENERATE ws-output FROM ws-record COUNT IN ws-length
  ```

- **[xml_generate/](xml_generate/)** - XML document generation:
  ```cobol
  XML GENERATE ws-output FROM ws-record WITH XML-DECLARATION
  ```

**Prerequisites:** Configure GnuCOBOL with `--with-json` and `--with-xml2` flags

**Key Concepts:** Data serialization, external library integration, structured data output

### Screen & Display Management

Control terminal display, handle screen positioning, and implement interactive features.

- **[screen_size/](screen_size/)** - Terminal dimension detection:
  ```cobol
  ACCEPT ws-num-lines FROM LINES 
  ACCEPT ws-num-cols FROM COLUMNS
  *> OR:
  CALL 'CBL_GET_SCR_SIZE' USING ws-num-lines ws-num-cols
  ```

- **[display_test/](display_test/)** - Advanced display formatting with positioning, colors, and screen effects

- **[mouse/](mouse/)** - Interactive mouse-driven drawing program demonstrating CRT status handling and cursor positioning

**Key Concepts:** Screen mode, terminal control, positioning, interactive input, mouse handling

### Data Structures & Search Operations

Implement efficient data structures and search algorithms in COBOL.

- **[search/](search/)** - Table search operations:
  ```cobol
  *> Binary search (requires sorted data with keys)
  SEARCH ALL ws-item-table
      AT END DISPLAY "Item not found"
      WHEN ws-item-id(idx) = ws-search-value
          DISPLAY "Item found"
  END-SEARCH
  
  *> Sequential search
  SET idx TO 1
  SEARCH ws-item-table
      AT END DISPLAY "Item not found"
      WHEN ws-item-id(idx) = ws-search-value
          DISPLAY "Item found"
  END-SEARCH
  ```

- **[redifines/](redifines/)** - Memory layout control and data structure overlays using the REDEFINES clause

**Key Concepts:** Indexed tables, binary vs sequential search, memory management, data structure design

### File Operations & Data Processing

Handle file I/O, sorting, and merging operations for data processing applications.

- **[merge_sort/](merge_sort/)** - File merging and sorting operations:
  ```cobol
  *> Merge multiple files
  MERGE fd-sorting-file
      ON ASCENDING KEY f-customer-id
      USING fd-test-file-1 fd-test-file-2 
      GIVING fd-merged-file
  
  *> Sort file data
  SORT fd-sorting-file
      ON DESCENDING KEY f-customer-contract-id
      USING fd-merged-file 
      GIVING fd-sorted-output
  ```

**Key Concepts:** File processing, MERGE statement, SORT statement, file descriptors

### Data Types & Conversion

Understand COBOL data types and conversion between different numeric representations.

- **[comp_test/](comp_test/)** - COMP vs DISPLAY data type conversions:
  ```cobol
  01  ws-comp-val     PIC 999 COMP.     *> Binary storage
  01  ws-disp-val     PIC 999.          *> Character storage
  01  ws-dyn-disp-val PIC ZZ9.          *> Dynamic display format
  ```

**Key Concepts:** COMP data types, numeric storage formats, data conversion, display formatting

### Program Structure & Modularity

Build modular COBOL applications with proper program organization and parameter passing.

- **[sub_program/](sub_program/)** - Sub-program calls and memory management:
  ```cobol
  *> Call by content (read-only)
  CALL 'sub-program' USING BY CONTENT ws-param1 ws-param2
  
  *> Call by reference (modifiable)
  CALL 'sub-program' USING BY REFERENCE ws-param1 ws-param2
  
  *> Reset sub-program working-storage
  CANCEL 'sub-program'
  ```

**Key Concepts:** Program modularity, parameter passing, WORKING-STORAGE vs LOCAL-STORAGE, memory management

## Compilation Guide

### Basic Compilation
```bash
# Simple program compilation
cobc -x program-name.cbl
./program-name
```

### Advanced Compilation Examples
```bash
# With external libraries (SQL)
cobc -x -static -locsql generated_sql_ex.cbl

# With preprocessing (SQL)
esqlOC -static -o generated.cbl source.cbl
cobc -x -static -locsql generated.cbl

# Check GnuCOBOL configuration
cobcrun --info
```

### GnuCOBOL Configuration for External Libraries
```bash
# Configure with JSON support
./configure --with-json

# Configure with XML support  
./configure --with-xml2

# Configure with database support
./configure --with-db

# After configuration, rebuild GnuCOBOL
make && make install
```

### Verification Commands
```bash
# Verify JSON library availability
cobcrun --info | grep -i json

# Verify XML library availability  
cobcrun --info | grep -i xml

# Check library dependencies
ldd ./compiled-program
```

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each directory is being updated with comprehensive README.md files and detailed code comments to enhance learning accessibility.

**Current Status:**
- ✅ Core examples documented with README files
- 🔄 Adding more detailed code comments
- 🔄 Expanding example coverage for advanced features

**How to Contribute:**
1. Fork the repository
2. Add new examples or improve existing documentation
3. Ensure all examples include README files with expected output
4. Test compilation and execution on Linux systems
5. Submit pull requests with clear descriptions

**Documentation Standards:**
- Each example directory should include a README.md with syntax examples and expected output
- Source code should include meaningful comments explaining COBOL-specific concepts
- Compilation instructions should be provided for examples requiring special setup

---

All programs were written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments and tested for compatibility and educational value.  




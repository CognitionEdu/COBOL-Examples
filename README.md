# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, system integration, and modern development practices using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers, covering everything from basic I/O operations to advanced database integration and data serialization. Each example includes detailed documentation, expected output, and compilation instructions to facilitate hands-on learning.

**Target Audience:**
- COBOL students and educators seeking practical examples
- Developers migrating to GnuCOBOL from other COBOL compilers  
- System integrators connecting COBOL applications with modern technologies

## Prerequisites

### Basic Setup
- **GnuCOBOL Compiler**: Install from [GnuCOBOL](https://gnucobol.sourceforge.io/)
- **Linux Environment**: Examples are designed for Linux (Ubuntu/Debian recommended)

### Advanced Examples Dependencies
Some examples require additional libraries during GnuCOBOL compilation:

- **SQL Examples**: PostgreSQL, unixODBC, odbc-postgresql, esqlOC precompiler
- **JSON Examples**: libjson-c library (`./configure --with-json`)
- **XML Examples**: libxml2 library (`./configure --with-xml2`)

## Quick Start

### Basic Compilation
Most examples can be compiled and run with:
```bash
cd example-directory
cobc -x program-name.cbl
./program-name
```

### Verify Your Setup
Check your GnuCOBOL installation:
```bash
cobcrun --info
```

## Example Categories

### 🔤 Basic I/O Operations
Learn fundamental input/output operations and user interaction patterns.

- **[accept/](accept/)** - User input with ACCEPT statement variations, including secure input and environment data retrieval
- **[display_test/](display_test/)** - Basic output formatting and display operations
- **[display_timing/](display_timing/)** - Timed display operations and screen control

### 🧵 String Processing  
Master COBOL's powerful string manipulation capabilities.

- **[trim/](trim/)** - Remove leading/trailing spaces using intrinsic TRIM function
- **[unstring/](unstring/)** - Parse delimited strings into multiple variables with various delimiter options

### 🔢 Data Validation & Conversion
Handle data validation and numeric conversions effectively.

- **[is_numeric/](is_numeric/)** - Validate numeric data using IS NUMERIC condition
- **[numval_test/](numval_test/)** - Convert character strings to numeric values using NUMVAL function

### 📊 Data Structures & Memory Management
Understand COBOL's approach to data organization and memory layout.

- **[search/](search/)** - Table search operations using SEARCH and SEARCH ALL (sequential and binary search)
- **[redefines/](redefines/)** - Memory layout control and data structure overlays using REDEFINES clause
- **[comp_test/](comp_test/)** - Computational data types and storage formats

### 🏗️ Program Structure
Learn modular programming and inter-program communication.

- **[sub_program/](sub_program/)** - Sub-program calls, parameter passing (BY CONTENT vs BY REFERENCE), and variable persistence

### 📁 File Operations
Handle file processing and data manipulation tasks.

- **[merge_sort/](merge_sort/)** - File merging and sorting operations
- **[report_writer/](report_writer/)** - Report generation using COBOL's report writer facility

### 🔗 System Integration
Connect COBOL programs with external systems and modern data formats.

- **[sql/](sql/)** - PostgreSQL database connectivity using esqlOC precompiler and ODBC
- **[json_generate/](json_generate/)** - Generate JSON documents from COBOL data structures
- **[xml_generate/](xml_generate/)** - Create XML documents with field mapping and attributes

### 🖥️ User Interface
Create interactive applications with screen and mouse control.

- **[screen_size/](screen_size/)** - Detect terminal dimensions using ACCEPT FROM LINES/COLUMNS and CBL_GET_SCR_SIZE
- **[mouse/](mouse/)** - Mouse event handling and simple drawing program example

### ⚙️ Command Line Processing
Process command-line arguments and system parameters.

- **[read_command_args/](read_command_args/)** - Parse command-line arguments and environment variables

## Learning Progression

### Beginner (Start Here)
1. **[display_test/](display_test/)** - Basic output
2. **[accept/](accept/)** - User input fundamentals  
3. **[is_numeric/](is_numeric/)** - Data validation basics
4. **[trim/](trim/)** - String manipulation introduction

### Intermediate
1. **[unstring/](unstring/)** - Advanced string parsing
2. **[search/](search/)** - Table operations
3. **[sub_program/](sub_program/)** - Modular programming
4. **[redefines/](redefines/)** - Memory management

### Advanced
1. **[sql/](sql/)** - Database integration
2. **[json_generate/](json_generate/)** - Modern data formats
3. **[xml_generate/](xml_generate/)** - Document generation
4. **[mouse/](mouse/)** - Interactive applications

## Compilation Notes

### Standard Examples
```bash
cobc -x program-name.cbl
```

### Examples with External Libraries
```bash
# SQL examples (after esqlOC preprocessing)
cobc -x -static -locsql generated_sql_ex.cbl

# JSON/XML examples require GnuCOBOL built with library support
# Check: cobcrun --info
```

### Preprocessing Required
```bash
# SQL examples need esqlOC preprocessing
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
```

## Documentation

Each example directory contains:
- **README.md** - Detailed explanation, syntax examples, and expected output
- **Source code** - Well-commented COBOL programs
- **Sample data** - Test files where applicable

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each example includes comprehensive comments and README files to enhance learning accessibility.

## License

See [LICENSE](LICENSE) file for details.

---

**Note**: All programs were written and tested using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments. While examples may work on other platforms, Linux is the primary target environment.  




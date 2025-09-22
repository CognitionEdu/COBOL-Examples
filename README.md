# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, modern integrations, and best practices using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers, from beginners learning basic I/O operations to advanced developers implementing database integration and modern data formats. Each example includes detailed documentation, expected output, and compilation instructions.

## Quick Start

### Prerequisites
- GnuCOBOL compiler installed
- Linux environment (primary target platform)
- For advanced examples: libxml2, libjson-c, PostgreSQL with ODBC drivers

### Basic Compilation
```bash
# Navigate to any example directory
cd example_directory/

# Compile the COBOL program
cobc -x program-name.cbl

# Run the compiled executable
./program-name
```

## Examples by Category

### 🔤 Input/Output Operations
- **[accept/](accept/)** - User input and system data retrieval using ACCEPT statements
- **[display_test/](display_test/)** - Screen positioning, formatting, and color output with DISPLAY

### 🧵 String Processing
- **[trim/](trim/)** - String manipulation using intrinsic TRIM function
- **[unstring/](unstring/)** - String parsing and tokenization with multiple delimiters
- **[is_numeric/](is_numeric/)** - Numeric validation techniques and edge cases

### 🔢 Data Conversion & Validation
- **[comp_test/](comp_test/)** - Converting between COMP and display value formats
- **[numval_test/](numval_test/)** - Converting PIC X to PIC 9 using NUMVAL function

### 🖥️ Screen & Terminal Operations
- **[screen_size/](screen_size/)** - Terminal dimension detection and screen mode handling

### 🔍 Data Structures & Search
- **[search/](search/)** - Table search operations (binary SEARCH ALL and sequential SEARCH)

### 🏗️ Program Architecture
- **[sub_program/](sub_program/)** - Inter-program communication, parameter passing, and memory management

### 🗄️ Database Integration
- **[sql/](sql/)** - PostgreSQL database connectivity using esqlOC precompiler and ODBC

### 📄 Modern Data Formats
- **[xml_generate/](xml_generate/)** - XML document generation using libxml2
- **[json_generate/](json_generate/)** - JSON serialization using libjson-c

### 📊 Advanced Features
- **[merge_sort/](merge_sort/)** - File merge and sort operations
- **[report_writer/](report_writer/)** - Report generation functionality

## Learning Path

**Beginner:** Start with basic I/O operations
1. [accept/](accept/) - Learn user input techniques
2. [display_test/](display_test/) - Master screen output formatting
3. [trim/](trim/) and [unstring/](unstring/) - String manipulation basics

**Intermediate:** Data handling and validation
4. [comp_test/](comp_test/) and [numval_test/](numval_test/) - Data conversion
5. [is_numeric/](is_numeric/) - Input validation
6. [search/](search/) - Data structure operations

**Advanced:** Integration and architecture
7. [sub_program/](sub_program/) - Program modularity
8. [sql/](sql/) - Database integration
9. [xml_generate/](xml_generate/) and [json_generate/](json_generate/) - Modern data formats

## External Dependencies

Some examples require additional libraries and configuration:

### XML Generation
- **Library:** libxml2
- **GnuCOBOL config:** `./configure --with-xml2`
- **Verification:** `cobcrun --info` should show XML library

### JSON Generation  
- **Library:** libjson-c
- **GnuCOBOL config:** `./configure --with-json`
- **Note:** May need `sudo ldconfig` after library installation

### Database Integration
- **Requirements:** PostgreSQL, unixODBC, odbc-postgresql, esqlOC precompiler
- **Build process:** Precompile with esqlOC, then compile with `-locsql`

## Important Notes

### COBOL Screen Mode
Several examples (accept/, screen_size/, display_test/) enter "COBOL screen mode" which uses ncurses for output instead of STDOUT. In this mode, screen coordinates must be specified for proper display positioning.

### Compilation Patterns
- **Standard:** `cobc -x program.cbl`
- **With libraries:** `cobc -x -static -locsql program.cbl`
- **Preprocessing:** `esqlOC -static -o output.cbl input.cbl`

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each example directory includes or will include a README.md file with detailed explanations, syntax examples, and expected output.

## Author

Examples written by Erik Eriksen using GnuCOBOL in Linux environments.  




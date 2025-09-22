# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, advanced integrations, and modern development practices using the [GnuCOBOL](https://gnucobol.sourceforge.io/) compiler on Linux.

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Quick Start](#quick-start)
- [Example Categories](#example-categories)
  - [Basic Examples](#basic-examples)
  - [Intermediate Examples](#intermediate-examples)
  - [Advanced Examples](#advanced-examples)
- [Compilation Guide](#compilation-guide)
- [External Dependencies](#external-dependencies)
- [Contributing](#contributing)

## Overview

This repository serves as a comprehensive educational resource for COBOL developers learning to use the GnuCOBOL compiler in Linux environments. The examples are organized by complexity and demonstrate:

- **Core COBOL language features** with executable, well-documented examples
- **Integration patterns** for databases (PostgreSQL), data formats (XML/JSON), and system resources
- **Best practices** for COBOL development in modern Linux environments
- **Progressive learning path** from basic syntax to advanced system integration

**Target Audience:**
- COBOL students and educators seeking practical, hands-on examples
- Developers migrating to GnuCOBOL from other COBOL compilers
- System integrators connecting COBOL applications with modern technologies

## Prerequisites

### Required Software
- **GnuCOBOL compiler** - Install from [gnucobol.sourceforge.io](https://gnucobol.sourceforge.io/)
- **Linux environment** (Ubuntu, CentOS, etc.)
- **Basic development tools** (make, gcc)

### Optional Dependencies (for advanced examples)
- **libxml2** - For XML generation examples
- **libjson-c** - For JSON generation examples
- **PostgreSQL + unixODBC + odbc-postgresql** - For database examples
- **esqlOC precompiler** - For embedded SQL processing

## Quick Start

1. **Clone the repository:**
   ```bash
   git clone https://github.com/CognitionEdu/COBOL-Examples.git
   cd COBOL-Examples
   ```

2. **Navigate to any example directory:**
   ```bash
   cd display_test
   ```

3. **Compile and run a COBOL program:**
   ```bash
   cobc -x display-test.cbl
   ./display-test
   ```

4. **Verify your GnuCOBOL installation:**
   ```bash
   cobcrun --info
   ```

## Example Categories

### Basic Examples
*Core COBOL concepts - Start here for fundamental language features*

| Directory | Description | Key Concepts |
|-----------|-------------|--------------|
| **[accept/](accept/)** | User input and system data retrieval patterns | ACCEPT statements, command-line args, environment variables |
| **[display_test/](display_test/)** | Display statement variations and screen positioning | Screen coordinates, colors, formatting options |
| **[comp_test/](comp_test/)** | Data type conversion between COMP and DISPLAY | Computational vs display formats, numeric conversion |
| **[is_numeric/](is_numeric/)** | Numeric validation techniques and edge cases | IS NUMERIC condition, space handling, validation patterns |
| **[numval_test/](numval_test/)** | String to numeric conversion using NUMVAL function | NUMVAL intrinsic function, type conversion |
| **[trim/](trim/)** | String trimming and whitespace manipulation | TRIM function variants, leading/trailing space removal |
| **[unstring/](unstring/)** | String parsing and tokenization with delimiters | UNSTRING statement, multiple delimiters, parsing techniques |
| **[redifines/](redifines/)** | Memory layout control and data structure overlays | REDEFINES clause, memory sharing, data interpretation |
| **[read_command_args/](read_command_args/)** | Command line argument processing and parsing | Command-line parameter handling, argument validation |

### Intermediate Examples
*Program structure, file operations, and screen handling*

| Directory | Description | Key Concepts |
|-----------|-------------|--------------|
| **[sub_program/](sub_program/)** | Inter-program communication and memory management | CALL statements, BY CONTENT vs BY REFERENCE, WORKING-STORAGE vs LOCAL-STORAGE |
| **[search/](search/)** | Table search operations (binary and sequential) | SEARCH and SEARCH ALL, indexed tables, key definitions |
| **[merge_sort/](merge_sort/)** | File sorting and merging operations | MERGE and SORT statements, file processing, work files |
| **[screen_size/](screen_size/)** | Terminal dimension detection and screen mode | Screen size detection, CBL_GET_SCR_SIZE, screen mode handling |
| **[display_timing/](display_timing/)** | Performance measurement and timing comparisons | Time functions, performance testing, display optimization |
| **[report_writer/](report_writer/)** | Report generation with formatting and headers | Report Writer feature, page formatting, headers and footers |

### Advanced Examples
*External libraries, database integration, and modern data formats*

| Directory | Description | Key Concepts | Dependencies |
|-----------|-------------|--------------|--------------|
| **[sql/](sql/)** | PostgreSQL database integration with embedded SQL | Embedded SQL, ODBC connectivity, database operations | PostgreSQL, unixODBC, esqlOC |
| **[xml_generate/](xml_generate/)** | XML document generation and serialization | XML GENERATE statement, document structure | libxml2 |
| **[json_generate/](json_generate/)** | JSON serialization of COBOL data structures | JSON GENERATE statement, modern data formats | libjson-c |
| **[mouse/](mouse/)** | Mouse interaction and event handling | Mouse events, screen interaction, CRT status | ncurses/pdcurses |

## Compilation Guide

### Basic Compilation
For most examples, use the standard compilation pattern:
```bash
cobc -x program-name.cbl
./program-name
```

### Advanced Examples with Libraries
For examples requiring external libraries:

**XML Generation:**
```bash
# Requires GnuCOBOL configured with --with-xml2
cobc -x xml_generate.cbl
```

**JSON Generation:**
```bash
# Requires GnuCOBOL configured with --with-json
cobc -x json_generate.cbl
```

**SQL Database Integration:**
```bash
# Precompile embedded SQL
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
# Compile with ODBC library
cobc -x -static -locsql generated_sql_ex.cbl
```

### Verification Commands
Check your GnuCOBOL configuration:
```bash
cobcrun --info
```

Look for these lines to verify library support:
```
JSON library             : json-c, version 0.15.99
XML library              : libxml2, version 2.9.3
```

## External Dependencies

### XML Support (xml_generate/)
1. **Install libxml2:**
   ```bash
   # Ubuntu/Debian
   sudo apt-get install libxml2-dev
   
   # CentOS/RHEL
   sudo yum install libxml2-devel
   ```

2. **Reconfigure GnuCOBOL:**
   ```bash
   ./configure --with-xml2
   make && sudo make install
   sudo ldconfig
   ```

### JSON Support (json_generate/)
1. **Install libjson-c:**
   ```bash
   # Ubuntu/Debian
   sudo apt-get install libjson-c-dev
   
   # CentOS/RHEL
   sudo yum install json-c-devel
   ```

2. **Reconfigure GnuCOBOL:**
   ```bash
   ./configure --with-json
   make && sudo make install
   sudo ldconfig
   ```

### Database Support (sql/)
1. **Install PostgreSQL and ODBC components:**
   ```bash
   # Ubuntu/Debian
   sudo apt-get install postgresql postgresql-client unixodbc unixodbc-dev odbc-postgresql
   
   # CentOS/RHEL
   sudo yum install postgresql postgresql-server unixODBC unixODBC-devel postgresql-odbc
   ```

2. **Install esqlOC precompiler:**
   - Download from: https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/
   - Follow installation instructions in the esqlOC documentation

3. **Configure ODBC connection:**
   - Set up PostgreSQL database and user credentials
   - Configure ODBC data source names (DSN) as needed

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each directory contains or will contain:
- **README.md** - Detailed explanation of concepts and usage
- **Source code** - Well-commented COBOL programs
- **Example output** - Expected program results
- **Compilation instructions** - Specific build requirements

### Learning Path Recommendation

1. **Start with Basic Examples** - Master fundamental COBOL syntax and concepts
2. **Progress to Intermediate Examples** - Learn program structure and file operations  
3. **Explore Advanced Examples** - Integrate with modern systems and data formats

### Getting Help

- Each example directory contains detailed documentation
- Source code includes comprehensive comments explaining key concepts
- Compilation instructions are provided for examples with special requirements
- Expected program output is documented to verify correct execution

---

**Repository maintained by Erik Eriksen**  
**All programs written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux**  




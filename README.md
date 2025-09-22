# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, modern integrations, and best practices using the GnuCOBOL compiler in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers at all levels, from newcomers exploring fundamental concepts to experienced programmers implementing advanced features like database connectivity, data serialization, and system integration. Each example is designed to be self-contained with clear documentation and executable demonstrations.

**Target Audience:**
- COBOL students and educators seeking hands-on examples
- Developers migrating to GnuCOBOL from other COBOL compilers  
- System integrators connecting COBOL applications with modern technologies
- Programmers exploring COBOL's capabilities in contemporary Linux environments

## Prerequisites

### GnuCOBOL Compiler
All examples require [GnuCOBOL](https://gnucobol.sourceforge.io/) installed and configured. For full functionality across all examples, compile GnuCOBOL with these configuration flags:

```bash
./configure --with-xml2 --with-json --with-db
make
make install
```

### External Dependencies

**For XML Generation Examples:**
- [libxml2](https://github.com/GNOME/libxml2) - XML document processing library
- Verify installation: `cobcrun --info` should show `XML library: libxml2, version X.X.X`

**For JSON Generation Examples:**
- [libjson-c](https://github.com/json-c/json-c) - JSON serialization library
- May require `sudo ldconfig` after installation
- Verify installation: `cobcrun --info` should show `JSON library: json-c, version X.X.X`

**For Database Integration Examples:**
- PostgreSQL database instance
- [unixODBC](http://www.unixodbc.org/) - ODBC driver manager
- odbc-postgresql - PostgreSQL ODBC driver
- [esqlOC Precompiler](https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/) - Embedded SQL preprocessor

## Quick Start

### Basic Compilation
```bash
# Navigate to any example directory
cd display_test/

# Compile the COBOL program
cobc -x display-test.cbl

# Run the executable
./display-test
```

### Advanced Examples with Dependencies
```bash
# SQL example with preprocessing
cd sql/
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
cobc -x -static -locsql generated_sql_ex.cbl
./generated_sql_ex
```

## Example Categories

### User Input & System Data
Learn various methods for accepting user input and retrieving system information.

- **[accept/](accept/)** - Comprehensive ACCEPT statement variations including user input, environment variables, system data, and screen mode operations
- **[read_command_args/](read_command_args/)** - Command-line argument processing and parsing techniques

### String Processing & Validation
Master COBOL's string manipulation and data validation capabilities.

- **[trim/](trim/)** - TRIM intrinsic function for removing leading/trailing spaces with various options
- **[unstring/](unstring/)** - String parsing with delimiters, multiple destination handling, and advanced tokenization
- **[is_numeric/](is_numeric/)** - Numeric validation techniques including space handling and preprocessing methods
- **[numval_test/](numval_test/)** - Converting character strings to numeric values using the NUMVAL function

### Data Generation & Serialization
Generate structured data formats for modern system integration.

- **[xml_generate/](xml_generate/)** - XML document creation from COBOL data structures with libxml2 integration
- **[json_generate/](json_generate/)** - JSON serialization using libjson-c library for web service compatibility

### Database Integration
Connect COBOL applications with relational databases.

- **[sql/](sql/)** - PostgreSQL connectivity using esqlOC precompiler, ODBC operations, and embedded SQL techniques

### Screen & Display Operations
Control terminal output, screen positioning, and user interface elements.

- **[screen_size/](screen_size/)** - Terminal dimension detection using ACCEPT FROM LINES/COLUMNS and CBL_GET_SCR_SIZE
- **[display_test/](display_test/)** - Advanced DISPLAY statement options including positioning, colors, and screen effects
- **[display_timing/](display_timing/)** - Performance comparison between different screen output methods
- **[mouse/](mouse/)** - Mouse interaction and simple drawing program demonstration

### Data Structures & Memory Management
Understand COBOL's approach to data organization and memory usage.

- **[redefines/](redefines/)** - Memory layout control with REDEFINES clause for data interpretation flexibility
- **[search/](search/)** - Table search operations including binary (SEARCH ALL) and sequential (SEARCH) methods

### Program Organization
Structure larger applications with modular programming techniques.

- **[sub_program/](sub_program/)** - Sub-program calling, parameter passing (BY CONTENT vs BY REFERENCE), and storage section behavior

### File Operations & Reporting
Handle file processing, data sorting, and report generation.

- **[merge_sort/](merge_sort/)** - File merging and sorting operations with MERGE and SORT statements
- **[report_writer/](report_writer/)** - Report generation using COBOL's Report Writer feature

### Data Type Operations
Work with different COBOL data types and conversion techniques.

- **[comp_test/](comp_test/)** - COMP (computational) data type usage and conversion between display and computational formats

## Build Instructions

### Standard Compilation Pattern
Most examples follow this basic pattern:
```bash
cd example_directory/
cobc -x program-name.cbl
./program-name
```

### Examples Requiring Special Compilation

**XML Generation:**
```bash
cd xml_generate/
cobc -x xml_generate.cbl
./xml_generate
```

**JSON Generation:**
```bash
cd json_generate/
cobc -x json_generate.cbl
./json_generate
```

**SQL Database Integration:**
```bash
cd sql/
# First, set up your PostgreSQL database using create_test_db.sql
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
cobc -x -static -locsql generated_sql_ex.cbl
./generated_sql_ex
```

### Troubleshooting Compilation Issues

1. **Missing XML/JSON support:** Recompile GnuCOBOL with `--with-xml2` and `--with-json` flags
2. **Library not found errors:** Run `sudo ldconfig` after installing external libraries
3. **SQL preprocessing fails:** Ensure esqlOC precompiler is installed and in your PATH
4. **ODBC connection issues:** Verify unixODBC and PostgreSQL ODBC driver installation

## Repository Structure

Each example directory contains:
- **Source files** (`.cbl`) - Main COBOL programs demonstrating specific features
- **README.md** - Detailed explanation, syntax examples, and expected output
- **Supporting files** - Test data, SQL scripts, or configuration files as needed

## Educational Approach

Examples are organized progressively from fundamental concepts to advanced integrations:

1. **Foundation** - Basic I/O, string processing, data validation
2. **Intermediate** - Data structures, file operations, screen control
3. **Advanced** - Database integration, data serialization, program organization

Each example includes:
- Clear syntax demonstrations
- Expected program output
- Common use cases and variations
- Integration with external systems where applicable

## Contributing

When adding new examples:
1. Follow the established directory structure
2. Include comprehensive README.md documentation
3. Provide sample input/output where applicable
4. Test compilation and execution on Linux with GnuCOBOL
5. Document any external dependencies or special compilation requirements

## License

This project is licensed under the terms specified in the [LICENSE](LICENSE) file.

---

*All programs were written and tested using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.*  




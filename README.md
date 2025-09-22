# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, advanced functionality, and modern integration patterns using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers at all skill levels. Each example is designed to demonstrate specific COBOL concepts with clear documentation, expected output, and compilation instructions. The examples progress from basic I/O operations to advanced features like database integration and data serialization.

**Target Audience:**
- COBOL students and educators seeking hands-on examples
- Developers migrating to GnuCOBOL from other COBOL compilers  
- System integrators connecting COBOL applications with modern technologies
- Anyone interested in learning COBOL programming concepts

## Prerequisites and Setup

### Basic Requirements
- **GnuCOBOL Compiler**: Install from [gnucobol.sourceforge.io](https://gnucobol.sourceforge.io/)
- **Linux Environment**: Examples are tested on Linux (Ubuntu/CentOS/etc.)
- **Terminal Access**: For compilation and execution

### Advanced Examples Requirements
Some examples require additional libraries and configuration:

- **Database Integration** (`sql/`): PostgreSQL, unixODBC, odbc-postgresql driver, esqlOC precompiler
- **XML Generation** (`xml_generate/`): libxml2 library, GnuCOBOL configured with `--with-xml2`
- **JSON Generation** (`json_generate/`): libjson-c library, GnuCOBOL configured with `--with-json`

## Basic Compilation and Execution

For most examples, compilation follows this pattern:

```bash
# Navigate to any example directory
cd display_test/

# Compile the COBOL program
cobc -x program-name.cbl

# Run the compiled executable
./program-name
```

**Note**: Some examples require additional compilation flags or preprocessing steps. Refer to individual README files for specific instructions.

## Example Categories

### Basic I/O and User Interaction
Learn fundamental input/output operations and user interaction patterns.

- **`accept/`** - Comprehensive ACCEPT statement examples including secure input, timeouts, and screen positioning
- **`display_test/`** - Basic DISPLAY statement usage and formatting
- **`display_timing/`** - Timed display operations and screen control

### String Processing and Manipulation
Master COBOL's string handling capabilities and intrinsic functions.

- **`trim/`** - TRIM function examples for removing leading/trailing spaces
- **`unstring/`** - String parsing with multiple delimiters and advanced UNSTRING techniques

### Data Structures and Memory Management
Understand COBOL data organization and memory layout control.

- **`redefines/`** - Memory overlay techniques using REDEFINES clause for different data interpretations
- **`search/`** - Table search operations including binary (SEARCH ALL) and sequential (SEARCH) methods
- **`comp_test/`** - Computational data types and storage formats

### Data Validation and Conversion
Learn data validation techniques and type conversion methods.

- **`is_numeric/`** - Numeric data validation using IS NUMERIC condition
- **`numval_test/`** - String to numeric conversion using NUMVAL intrinsic function

### Command Line Processing
Handle command-line arguments and environment variables.

- **`read_command_args/`** - Command-line argument processing and environment variable access

### Screen and Terminal Operations
Control terminal display, screen positioning, and user interface elements.

- **`screen_size/`** - Terminal dimension detection using ACCEPT FROM LINES/COLUMNS and CBL_GET_SCR_SIZE
- **`mouse/`** - Mouse input handling and simple drawing program demonstration

### Program Structure and Modularity
Understand program organization, sub-program calls, and memory management.

- **`sub_program/`** - Sub-program calls with parameter passing (BY CONTENT vs BY REFERENCE), working-storage vs local-storage persistence

### File Operations and Data Processing
Handle file I/O, sorting, and report generation.

- **`merge_sort/`** - File merging and sorting operations with MERGE and SORT statements
- **`report_writer/`** - Report generation using COBOL Report Writer facility

### Database Integration (Advanced)
Connect COBOL programs to PostgreSQL databases using embedded SQL.

- **`sql/`** - Database connectivity with esqlOC precompiler, ODBC operations, and variable-length string handling

**Prerequisites**: PostgreSQL, unixODBC, odbc-postgresql, esqlOC precompiler  
**Compilation**: `esqlOC -static -o generated.cbl source.cbl && cobc -x -static -locsql generated.cbl`

### Data Serialization (Advanced)
Generate modern data formats from COBOL data structures.

- **`xml_generate/`** - XML document generation using XML GENERATE statement with libxml2
- **`json_generate/`** - JSON serialization using JSON GENERATE statement with libjson-c

**Prerequisites**: External libraries and GnuCOBOL reconfiguration required (see individual README files)

## Learning Path Recommendations

### Beginner Path
1. Start with **`display_test/`** and **`accept/`** for basic I/O
2. Learn string handling with **`trim/`** and **`unstring/`**
3. Explore data validation using **`is_numeric/`** and **`numval_test/`**
4. Practice with **`comp_test/`** for data types

### Intermediate Path
1. Master data structures with **`redefines/`** and **`search/`**
2. Learn program organization with **`sub_program/`**
3. Handle command-line processing with **`read_command_args/`**
4. Explore file operations with **`merge_sort/`** and **`report_writer/`**

### Advanced Path
1. Set up external libraries for **`xml_generate/`** and **`json_generate/`**
2. Configure database connectivity for **`sql/`** examples
3. Experiment with **`screen_size/`** and **`mouse/`** for interactive applications

## Compilation Troubleshooting

### Common Issues
- **Missing external libraries**: Ensure libxml2, libjson-c are installed and GnuCOBOL is reconfigured
- **Screen mode problems**: Some examples enter "COBOL screen mode" requiring explicit positioning
- **Database connection errors**: Verify PostgreSQL, ODBC drivers, and connection strings
- **Precompiler not found**: Install esqlOC precompiler for SQL examples

### Verification Commands
Check your GnuCOBOL configuration:
```bash
cobcrun --info
```

Look for these lines to confirm library support:
```
XML library              : libxml2, version 2.9.x
JSON library             : json-c, version 0.15.x
```

## Cross-References and Related Concepts

- **Screen Mode**: Examples in `accept/`, `screen_size/`, and `mouse/` demonstrate screen positioning
- **Memory Management**: Compare `sub_program/` (working-storage persistence) with `redefines/` (memory overlays)
- **String Processing**: `trim/`, `unstring/`, and `numval_test/` show different string manipulation approaches
- **Data Validation**: `is_numeric/` and `numval_test/` provide complementary validation techniques
- **External Integration**: `sql/`, `xml_generate/`, and `json_generate/` show modern connectivity patterns

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each example directory is being updated with comprehensive README.md files and enhanced code comments to improve learning accessibility.

When exploring examples:
1. Read the individual README.md file in each directory first
2. Examine the source code comments for detailed explanations
3. Try compiling and running the examples to see expected output
4. Experiment with modifications to deepen understanding

## Additional Resources

- [GnuCOBOL Documentation](https://gnucobol.sourceforge.io/)
- [libxml2 Library](https://github.com/GNOME/libxml2)
- [libjson-c Library](https://github.com/json-c/json-c)
- [PostgreSQL Database](https://www.postgresql.org/)
- [unixODBC Project](http://www.unixodbc.org/)

---

*All programs were written and tested using GnuCOBOL in Linux environments.*  




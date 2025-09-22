# COBOL Examples

A comprehensive collection of COBOL programming examples demonstrating core language features, modern integrations, and best practices using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Overview

This repository serves as an educational resource for COBOL developers, covering everything from basic language constructs to advanced features like database integration, data serialization, and system interaction. Each example includes detailed documentation, expected output, and compilation instructions.

## Prerequisites

- **GnuCOBOL Compiler**: Install GnuCOBOL with appropriate library support
- **Linux Environment**: Examples are designed for Linux systems
- **Optional Libraries** (for specific examples):
  - `libxml2` - Required for XML generation examples
  - `libjson-c` - Required for JSON generation examples  
  - `unixODBC` + `odbc-postgresql` - Required for database examples
  - `esqlOC` precompiler - Required for embedded SQL processing

### GnuCOBOL Configuration

For full functionality, configure GnuCOBOL with external library support:

```bash
./configure --with-xml2 --with-json --with-db
make && make install
```

Verify installation with: `cobcrun --info`

## Quick Start

1. Navigate to any example directory: `cd example_directory`
2. Compile the COBOL program: `cobc -x program-name.cbl`
3. Run the compiled executable: `./program-name`

## Examples by Category

### 🔤 Input/Output Operations
Learn how to handle user input, screen output, and system interaction.

- **[accept/](accept/)** - ACCEPT statement variations including secure input, command-line arguments, and environment variables
- **[display_test/](display_test/)** - DISPLAY statement options with screen positioning, colors, and formatting
- **[screen_size/](screen_size/)** - Getting terminal dimensions using ACCEPT FROM LINES/COLUMNS and CBL_GET_SCR_SIZE
- **[mouse/](mouse/)** - Mouse event handling and cursor positioning

### 🔧 Data Manipulation & Validation
Master string processing, data conversion, and validation techniques.

- **[trim/](trim/)** - TRIM intrinsic function for removing leading/trailing spaces
- **[unstring/](unstring/)** - UNSTRING statement for parsing delimited data with multiple examples
- **[is_numeric/](is_numeric/)** - Data validation using IS NUMERIC with different input handling approaches
- **[numval_test/](numval_test/)** - Converting character data to numeric using NUMVAL function
- **[comp_test/](comp_test/)** - COMP data type usage and conversion between display and computational formats

### 🏗️ Program Structure & Memory Management
Understand modular programming and memory organization.

- **[sub_program/](sub_program/)** - Sub-program calls with BY CONTENT/BY REFERENCE parameter passing
- **[redifines/](redifines/)** - REDEFINES clause for memory overlay and data structure flexibility

### 🔍 Table Operations & Searching
Implement efficient data searching and table manipulation.

- **[search/](search/)** - SEARCH and SEARCH ALL for sequential and binary table searches
- **[merge_sort/](merge_sort/)** - MERGE and SORT statements for file processing and data organization

### 🌐 Modern Data Formats
Generate and process contemporary data formats.

- **[xml_generate/](xml_generate/)** - XML GENERATE statement for creating XML documents (requires libxml2)
- **[json_generate/](json_generate/)** - JSON GENERATE statement for JSON serialization (requires libjson-c)

### 🗄️ Database Integration
Connect COBOL applications with modern databases.

- **[sql/](sql/)** - PostgreSQL integration using esqlOC precompiler with embedded SQL examples

### 📄 File Processing & Reports
Handle file operations and report generation.

- **[report_writer/](report_writer/)** - Report generation using COBOL Report Writer features
- **[read_command_args/](read_command_args/)** - Command-line argument processing techniques
- **[display_timing/](display_timing/)** - Performance timing and display optimization

## Learning Progression

### Beginner Level
Start with basic I/O and data manipulation:
1. [display_test/](display_test/) - Basic output formatting
2. [accept/](accept/) - User input handling
3. [trim/](trim/) - String manipulation
4. [is_numeric/](is_numeric/) - Data validation

### Intermediate Level
Progress to program structure and data processing:
1. [sub_program/](sub_program/) - Modular programming
2. [unstring/](unstring/) - Advanced string parsing
3. [search/](search/) - Table operations
4. [redifines/](redifines/) - Memory management

### Advanced Level
Explore modern integrations and complex operations:
1. [sql/](sql/) - Database connectivity
2. [xml_generate/](xml_generate/) & [json_generate/](json_generate/) - Data serialization
3. [merge_sort/](merge_sort/) - File processing
4. [mouse/](mouse/) - Advanced user interface

## Compilation Notes

### Basic Compilation
Most examples compile with: `cobc -x program-name.cbl`

### Examples Requiring Special Libraries

**XML Generation:**
```bash
# Requires libxml2 and GnuCOBOL configured with --with-xml2
cobc -x xml_generate.cbl
```

**JSON Generation:**
```bash
# Requires libjson-c and GnuCOBOL configured with --with-json
cobc -x json_generate.cbl
```

**SQL Database Examples:**
```bash
# Requires esqlOC precompiler and OCSQL library
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
cobc -x -static -locsql generated_sql_ex.cbl
```

## COBOL Screen Mode

Several examples demonstrate "COBOL Screen Mode" which uses ncurses for enhanced display control. When screen mode is active:
- Screen coordinates must be specified for output positioning
- Enhanced formatting options become available
- Mouse and keyboard events can be captured

Examples using screen mode: [accept/](accept/), [display_test/](display_test/), [screen_size/](screen_size/), [mouse/](mouse/)

## Contributing

Each example directory contains its own README.md with detailed explanations, expected output, and specific compilation instructions. When adding new examples, please follow this documentation pattern.

## License

See [LICENSE](LICENSE) file for details.  




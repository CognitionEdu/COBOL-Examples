# COBOL Examples

A comprehensive collection of COBOL example programs demonstrating various language features, data structures, I/O operations, and programming techniques. These examples are designed to help developers learn COBOL concepts through practical, well-documented code samples.

All programs were written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux and are organized by functionality to make learning and reference easier.

## Prerequisites

- **GnuCOBOL Compiler**: Install GnuCOBOL from [https://gnucobol.sourceforge.io/](https://gnucobol.sourceforge.io/)
- **Linux Environment**: Examples are tested on Linux systems
- **Additional Libraries** (for specific examples):
  - `libjson-c` for JSON generation examples
  - `libxml2` for XML generation examples
  - `PostgreSQL` and `unixODBC` for SQL examples

## Basic Compilation

Most examples can be compiled using the standard GnuCOBOL compiler:

```bash
cobc -x example_program.cbl
./example_program
```

For examples requiring external libraries, see the specific requirements in each section below.

## Example Categories

### Input/Output Operations

#### [accept/](accept/)
Demonstrates various forms of the `ACCEPT` statement for user input, including:
- Basic input acceptance
- Secure input (password masking)
- Command-line argument processing
- Environment variable access
- Screen positioning and timing controls

#### [display_test/](display_test/)
Shows different `DISPLAY` statement options including:
- Screen positioning (`AT`, `LINE`, `COLUMN`)
- Screen formatting (`BLANK LINE`, `ERASE EOL`)
- Color control (`BACKGROUND-COLOR`, `FOREGROUND-COLOR`)
- Bell/alert functionality

#### [screen_size/](screen_size/)
Examples of detecting terminal dimensions using:
- `ACCEPT FROM LINES/COLUMNS` statements
- `CBL_GET_SCR_SIZE` system call
- Dynamic screen formatting based on terminal size

#### [read_command_args/](read_command_args/)
Command-line argument processing techniques:
- Reading full command line with `ACCEPT FROM COMMAND-LINE`
- Parsing and searching for specific arguments
- Case-insensitive argument detection

### String Processing

#### [trim/](trim/)
Demonstrates the intrinsic `TRIM` function for whitespace removal:
- Leading, trailing, and both-side trimming
- Working with string literals and variables
- Using `FUNCTION ALL INTRINSIC` for cleaner syntax

#### [unstring/](unstring/)
Comprehensive examples of the `UNSTRING` statement:
- Simple delimiter-based parsing
- Multiple delimiter handling
- Pointer tracking and field counting
- Complex string decomposition scenarios

#### [is_numeric/](is_numeric/)
Testing numeric content in alphanumeric fields:
- Basic `IS NUMERIC` condition testing
- Handling spaces in numeric validation
- Using `TRIM` function for numeric testing
- Right-justification and zero-filling techniques

### Data Structures & Types

#### [redifines/](redifines/)
Memory overlay techniques using `REDEFINES`:
- Sharing memory between different data structures
- Polymorphic data handling (person vs. corporation records)
- Converting between display and computational data types
- Memory-efficient data structure design

#### [search/](search/)
Table searching operations:
- Sequential search with `SEARCH`
- Binary search with `SEARCH ALL`
- Indexed table operations
- Multi-key search conditions

#### [comp_test/](comp_test/)
Computational data type handling:
- Converting between `COMP` and display formats
- Arithmetic operations on computational fields
- Dynamic display formatting with `PIC ZZ9`
- Input/output with different data representations

#### [numval_test/](numval_test/)
Numeric conversion using the `NUMVAL` function:
- Converting alphanumeric input to numeric values
- Arithmetic operations with converted data
- Mixed data type calculations

### File Operations

#### [merge_sort/](merge_sort/)
File processing with `SORT` and `MERGE` operations:
- Creating test data files
- Merging multiple sorted files
- Sorting on different key fields (ascending/descending)
- File status handling and error checking

#### [report_writer/](report_writer/)
Report generation using COBOL's Report Writer facility:
- Report section definitions
- Page formatting and headers
- Detail line generation
- Report initialization and termination

#### [sql/](sql/)
Database connectivity with PostgreSQL:
- **Prerequisites**: PostgreSQL, esqlOC precompiler, unixODBC, odbc-postgresql
- Embedded SQL in COBOL programs
- Database connection and querying
- Variable-length string handling in SQL operations
- **Build Process**: Requires esqlOC precompilation before COBOL compilation

### Program Structure

#### [sub_program/](sub_program/)
Modular programming with subprograms:
- Calling subprograms with parameters
- Parameter passing by content vs. reference
- Working-storage vs. local-storage variable persistence
- Program cancellation and memory management

### Data Generation

#### [json_generate/](json_generate/)
JSON document creation:
- **Prerequisites**: `libjson-c` library, GnuCOBOL configured with `--with-json`
- Converting COBOL data structures to JSON format
- JSON document validation and output

#### [xml_generate/](xml_generate/)
XML document creation:
- **Prerequisites**: `libxml2` library, GnuCOBOL configured with `--with-xml2`
- Converting COBOL records to XML format
- XML document structure and formatting

### Interactive Features

#### [mouse/](mouse/)
Mouse input handling in COBOL:
- Simple drawing program demonstrating mouse functionality
- Screen-based mouse interaction
- Coordinate tracking and display

### Performance & Timing

#### [display_timing/](display_timing/)
Performance comparison of display methods:
- Timing different screen positioning syntaxes
- Performance measurement and averaging
- Screen refresh rate testing
- Comparative analysis of display techniques

## Special Requirements

### JSON Examples
To compile and run JSON examples:
1. Install `libjson-c`: Follow instructions at [https://github.com/json-c/json-c](https://github.com/json-c/json-c)
2. Configure GnuCOBOL: `./configure --with-json`
3. Rebuild GnuCOBOL: `make && make install`
4. Verify: `cobcrun --info` should show JSON library support

### XML Examples
To compile and run XML examples:
1. Install `libxml2`: Available in most Linux distributions
2. Configure GnuCOBOL: `./configure --with-xml2`
3. Rebuild GnuCOBOL: `make && make install`
4. Verify: `cobcrun --info` should show XML library support

### SQL Examples
To compile and run SQL examples:
1. Install PostgreSQL database
2. Install unixODBC and PostgreSQL ODBC driver
3. Install esqlOC precompiler from [GnuCOBOL contrib](https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/)
4. Precompile: `esqlOC -static -o generated_sql_ex.cbl sql_example.cbl`
5. Compile: `cobc -x -static -locsql generated_sql_ex.cbl`

## Contributing

Each example directory contains or will contain its own README.md file with detailed explanations, example output, and specific compilation instructions. When adding new examples:

1. Create a descriptive directory name
2. Include a README.md with example output
3. Add comprehensive comments in the source code
4. Update this main README to include the new example in the appropriate category

## Learning Path

For those new to COBOL, consider exploring examples in this order:

1. **Basic I/O**: `accept`, `display_test`
2. **String Handling**: `trim`, `unstring`
3. **Data Types**: `comp_test`, `numval_test`, `is_numeric`
4. **Data Structures**: `redifines`, `search`
5. **File Operations**: `merge_sort`, `report_writer`
6. **Advanced Topics**: `sub_program`, `sql`, `json_generate`, `xml_generate`

Each example builds upon concepts from previous ones, providing a structured learning experience for COBOL development.  




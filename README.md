# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, advanced functionality, and modern integrations. This repository serves as a practical learning resource for COBOL developers using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Table of Contents

- [Overview](#overview)
- [Prerequisites and Setup](#prerequisites-and-setup)
- [Basic COBOL Examples](#basic-cobol-examples)
- [Input/Output Operations](#inputoutput-operations)
- [String Processing](#string-processing)
- [Data Conversion and Validation](#data-conversion-and-validation)
- [Advanced Features](#advanced-features)
- [Program Structure](#program-structure)
- [System Integration](#system-integration)
- [File Operations](#file-operations)
- [Compilation Guide](#compilation-guide)
- [Learning Path](#learning-path)

## Overview

This repository targets both newcomers to COBOL and experienced developers exploring GnuCOBOL's capabilities. Each example includes:

- Well-documented source code with explanatory comments
- Individual README files with syntax examples and expected output
- Compilation instructions and dependency requirements
- Practical demonstrations of real-world COBOL programming patterns

**Target Audience:**
- COBOL students and educators seeking hands-on examples
- Developers migrating to GnuCOBOL from other COBOL compilers
- System integrators connecting COBOL applications with modern technologies

## Prerequisites and Setup

### Basic Requirements
- **GnuCOBOL compiler** - Install from [gnucobol.sourceforge.io](https://gnucobol.sourceforge.io/)
- **Linux environment** - All examples tested on Linux systems
- **Basic compilation**: Most examples compile with `cobc -x program-name.cbl`

### Advanced Features Requirements
For examples using external libraries, GnuCOBOL must be configured with specific flags:

- **XML support**: `./configure --with-xml2` (requires libxml2)
- **JSON support**: `./configure --with-json` (requires libjson-c)
- **Database support**: `./configure --with-db` (requires unixODBC and PostgreSQL drivers)

After configuration changes, rebuild GnuCOBOL:
```bash
make && make install
```

Verify library support with: `cobcrun --info`

## Basic COBOL Examples

### Display Operations
- **[display_test/](display_test/)** - DISPLAY statement variations including screen positioning, colors, and formatting options
- **[display_timing/](display_timing/)** - Timing and display control demonstrations

### Data Types and Storage
- **[comp_test/](comp_test/)** - COMP (computational) data type conversions and display formatting
- **[redifines/](redifines/)** - REDEFINES clause for memory layout control and data structure overlays

## Input/Output Operations

### User Input Handling
- **[accept/](accept/)** - Comprehensive ACCEPT statement examples including:
  - Basic user input with various formatting options
  - Secure input masking with the SECURE keyword
  - Environment variable and system data retrieval
  - Command-line argument processing
  - Screen mode interactions and terminal control

### Command Line Processing
- **[read_command_args/](read_command_args/)** - Command-line argument parsing and processing techniques

## String Processing

### String Manipulation
- **[trim/](trim/)** - TRIM intrinsic function for removing leading/trailing spaces with examples of:
  - Default trimming (both leading and trailing)
  - Leading-only and trailing-only trimming
  - String literal processing
  - Integration with the `FUNCTION ALL INTRINSIC` repository setting

### String Parsing
- **[unstring/](unstring/)** - UNSTRING statement for parsing delimited data including:
  - Simple delimiter-based parsing
  - Multiple delimiter handling
  - Pointer management for sequential parsing
  - Overflow handling and error detection
  - Complex parsing scenarios with mixed delimiters

## Data Conversion and Validation

### Numeric Processing
- **[is_numeric/](is_numeric/)** - IS NUMERIC condition testing with various input formats and validation techniques
- **[numval_test/](numval_test/)** - NUMVAL intrinsic function for converting character strings to numeric values

## Advanced Features

### Database Integration
- **[sql/](sql/)** - PostgreSQL database connectivity using esqlOC precompiler:
  - Database connection and query execution
  - Variable-length string handling in SQL operations
  - SQLCA (SQL Communication Area) usage
  - Embedded SQL preprocessing workflow

**Prerequisites**: PostgreSQL, esqlOC precompiler, unixODBC, odbc-postgresql driver

### Data Serialization
- **[xml_generate/](xml_generate/)** - XML document generation using libxml2:
  - Data structure to XML conversion
  - XML declaration and formatting
  - Field mapping and attribute specification

- **[json_generate/](json_generate/)** - JSON document generation using libjson-c:
  - Data structure to JSON serialization
  - Nested object handling
  - Character count and output management

### Table Operations
- **[search/](search/)** - Table search operations demonstrating:
  - Sequential search (SEARCH) for unkeyed tables
  - Binary search (SEARCH ALL) for keyed, sorted tables
  - Multiple key matching and complex search conditions
  - Performance considerations and best practices

## Program Structure

### Modular Programming
- **[sub_program/](sub_program/)** - Sub-program calls and parameter passing:
  - BY CONTENT vs BY REFERENCE parameter passing
  - WORKING-STORAGE persistence between calls
  - LOCAL-STORAGE reset behavior
  - Sub-program cancellation and memory management

## System Integration

### Screen and Terminal Control
- **[screen_size/](screen_size/)** - Terminal dimension detection using:
  - ACCEPT FROM LINES/COLUMNS statements
  - CBL_GET_SCR_SIZE external function
  - Screen mode activation and management

### Mouse Interaction
- **[mouse/](mouse/)** - Mouse functionality demonstration with a simple drawing program showing:
  - Mouse event capture and processing
  - Screen coordinate handling
  - Interactive user interface development

## File Operations

### Data Processing
- **[merge_sort/](merge_sort/)** - File processing operations including:
  - MERGE statement for combining sorted files
  - SORT statement for ordering data
  - File descriptor management
  - Sequential file processing patterns

### Report Generation
- **[report_writer/](report_writer/)** - Report generation and formatting techniques

## Compilation Guide

### Standard Compilation
Most basic examples compile with:
```bash
cobc -x program-name.cbl
./program-name
```

### Library-Dependent Examples

**XML Examples:**
```bash
# Requires GnuCOBOL configured with --with-xml2
cobc -x xml_generate.cbl
```

**JSON Examples:**
```bash
# Requires GnuCOBOL configured with --with-json
cobc -x json_generate.cbl
```

**SQL Examples:**
```bash
# Precompile embedded SQL
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
# Compile with ODBC library
cobc -x -static -locsql generated_sql_ex.cbl
```

### Troubleshooting
- Verify library support: `cobcrun --info`
- Check for missing dependencies if compilation fails
- Ensure proper GnuCOBOL configuration for advanced features

## Learning Path

### Beginner Level
1. Start with **[display_test/](display_test/)** and **[accept/](accept/)** for basic I/O
2. Explore **[trim/](trim/)** and **[is_numeric/](is_numeric/)** for data handling
3. Practice with **[comp_test/](comp_test/)** for data type understanding

### Intermediate Level
1. Learn string processing with **[unstring/](unstring/)**
2. Understand data conversion with **[numval_test/](numval_test/)**
3. Explore table operations with **[search/](search/)**
4. Study modular programming with **[sub_program/](sub_program/)**

### Advanced Level
1. Database integration with **[sql/](sql/)**
2. Data serialization with **[xml_generate/](xml_generate/)** and **[json_generate/](json_generate/)**
3. System integration with **[screen_size/](screen_size/)** and **[mouse/](mouse/)**
4. File processing with **[merge_sort/](merge_sort/)**

## Contributing

Each directory contains detailed README files with:
- Syntax explanations and examples
- Expected program output
- Compilation instructions
- Implementation notes and best practices

The repository is actively maintained with ongoing documentation improvements to enhance learning accessibility.

---

*All programs written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.*  




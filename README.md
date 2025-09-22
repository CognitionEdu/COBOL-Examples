# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, advanced integrations, and modern development practices using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers, covering everything from basic language syntax to advanced features like database integration, XML/JSON serialization, and system interaction. Each example is designed to be self-contained, compilable, and educational.

**Target Audience:**
- COBOL students and educators
- Developers learning GnuCOBOL
- Programmers exploring COBOL integration with modern technologies
- System integrators working with legacy COBOL systems

## Prerequisites

### Basic Requirements
- **GnuCOBOL Compiler**: Install from [GnuCOBOL](https://gnucobol.sourceforge.io/)
- **Linux Environment**: Examples tested on Linux distributions
- **Basic compilation**: Most examples compile with `cobc -x program.cbl`

### Advanced Features (Optional Dependencies)

Some examples require additional libraries and configuration:

#### XML Generation Support
- **Library**: [libxml2](https://github.com/GNOME/libxml2)
- **GnuCOBOL Configuration**: `./configure --with-xml2`
- **Verification**: `cobcrun --info` should show `XML library: libxml2`
- **Required for**: `xml_generate/` examples

#### JSON Generation Support  
- **Library**: [libjson-c](https://github.com/json-c/json-c)
- **GnuCOBOL Configuration**: `./configure --with-json`
- **Post-install**: May need `sudo ldconfig` after library installation
- **Verification**: `cobcrun --info` should show `JSON library: json-c`
- **Required for**: `json_generate/` examples

#### Database Integration
- **PostgreSQL**: Database server installation
- **esqlOC Precompiler**: [Available here](https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/)
- **unixODBC**: ODBC driver manager
- **odbc-postgresql**: PostgreSQL ODBC driver
- **Compilation**: `esqlOC -static -o output.cbl input.cbl` then `cobc -x -static -locsql output.cbl`
- **Required for**: `sql/` examples

## Example Categories

### 🔤 Basic I/O and User Interaction
- **[accept/](accept/)** - ACCEPT statement variations for user input, command-line arguments, and system data
- **[display_test/](display_test/)** - Display statement examples and formatting
- **[display_timing/](display_timing/)** - Timing and display control demonstrations

### 🧵 String Processing and Manipulation
- **[trim/](trim/)** - TRIM intrinsic function for whitespace removal (leading, trailing, both)
- **[unstring/](unstring/)** - UNSTRING statement for delimiter-based string parsing
- **[is_numeric/](is_numeric/)** - Numeric validation techniques and edge cases
- **[numval_test/](numval_test/)** - NUMVAL function for string-to-numeric conversion

### 🗃️ Data Structures and Memory Management
- **[redefines/](redifines/)** - REDEFINES clause for memory layout manipulation and data interpretation
- **[comp_test/](comp_test/)** - COMP (computational) data types and conversions
- **[search/](search/)** - Table search operations (SEARCH and SEARCH ALL for sequential and binary search)

### 📁 File Operations and Data Processing
- **[merge_sort/](merge_sort/)** - MERGE and SORT statements for file processing and data organization
- **[report_writer/](report_writer/)** - Report generation and formatting capabilities
- **[read_command_args/](read_command_args/)** - Command-line argument processing techniques

### 🗄️ Database Integration
- **[sql/](sql/)** - PostgreSQL database connectivity using esqlOC precompiler with embedded SQL

### 📋 Data Serialization
- **[xml_generate/](xml_generate/)** - XML document generation using libxml2 integration
- **[json_generate/](json_generate/)** - JSON serialization using libjson-c integration

### 🖥️ Screen and System Interaction
- **[screen_size/](screen_size/)** - Terminal dimension detection and screen management
- **[mouse/](mouse/)** - Mouse input handling and simple drawing program

### 🔧 Program Structure and Modularity
- **[sub_program/](sub_program/)** - Sub-program calls, parameter passing (BY CONTENT vs BY REFERENCE), and memory management

## Quick Start

### Basic Example Compilation
```bash
# Navigate to any example directory
cd display_test/

# Compile the COBOL program
cobc -x display-test.cbl

# Run the executable
./display-test
```

### Advanced Examples with Dependencies

#### XML Generation
```bash
cd xml_generate/
cobc -x xml_generate.cbl
./xml_generate
```

#### Database Integration
```bash
cd sql/
# First, set up PostgreSQL and run create_test_db.sql
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
cobc -x -static -locsql generated_sql_ex.cbl
./generated_sql_ex
```

## Learning Path Recommendations

### Beginner (Core COBOL)
1. **display_test/** - Basic output
2. **accept/** - User input and system data
3. **trim/** - String manipulation basics
4. **is_numeric/** - Data validation
5. **comp_test/** - Data types and storage

### Intermediate (Data Processing)
1. **unstring/** - String parsing
2. **redefines/** - Memory layout control
3. **search/** - Table operations
4. **merge_sort/** - File processing
5. **sub_program/** - Modular programming

### Advanced (System Integration)
1. **screen_size/** - System interaction
2. **sql/** - Database connectivity
3. **xml_generate/** - Data serialization
4. **json_generate/** - Modern data formats
5. **mouse/** - Interactive applications

## Documentation

Many directories contain detailed README.md files with:
- Syntax examples and explanations
- Expected program output
- Compilation instructions
- Usage notes and best practices

**Directories with comprehensive documentation:**
- [accept/README.md](accept/README.md) - Complete ACCEPT statement reference
- [sql/README.md](sql/README.md) - Database setup and integration guide
- [xml_generate/README.md](xml_generate/README.md) - XML library configuration
- [json_generate/README.md](json_generate/README.md) - JSON library setup
- [trim/README.md](trim/README.md) - String manipulation techniques
- [unstring/README.md](unstring/README.md) - String parsing examples
- [search/README.md](search/README.md) - Table search operations
- [sub_program/README.md](sub_program/README.md) - Program modularity guide

## Contributing

This repository is actively maintained with ongoing improvements to documentation and code comments. Each example is designed to be educational and self-explanatory.

## Compilation Notes

- **Standard compilation**: `cobc -x program.cbl`
- **With external libraries**: `cobc -x -static -llibrary program.cbl`
- **SQL preprocessing**: `esqlOC -static -o output.cbl input.cbl`
- **Screen mode**: Some examples enter "COBOL screen mode" requiring specific display positioning

## License

See [LICENSE](LICENSE) file for details.

---

*All programs written using [GnuCOBOL](https://gnucobol.sourceforge.io/) in Linux environments.*  




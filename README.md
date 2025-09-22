# COBOL Examples

A comprehensive collection of educational COBOL programs demonstrating core language features, system integration, and modern development practices using the [GnuCOBOL](https://gnucobol.sourceforge.io/) compiler in Linux environments.

## Overview

This repository serves as a practical learning resource for COBOL developers, students, and educators. Each example includes well-documented source code with detailed explanations, expected output, and compilation instructions. The examples progress from basic language features to advanced topics like database integration and data serialization.

**Target Audience:**
- COBOL students and educators
- Developers learning GnuCOBOL
- System integrators connecting COBOL with modern technologies

## Prerequisites

### Required Software
- **GnuCOBOL Compiler**: Install from [gnucobol.sourceforge.io](https://gnucobol.sourceforge.io/)
- **Linux Environment**: Examples are designed for Linux systems

### Optional Dependencies (for specific examples)
- **libxml2**: Required for XML generation examples
  - Configure GnuCOBOL with: `./configure --with-xml2`
- **libjson-c**: Required for JSON generation examples  
  - Configure GnuCOBOL with: `./configure --with-json`
- **PostgreSQL + unixODBC**: Required for database examples
  - Install: `unixODBC`, `odbc-postgresql`, `esqlOC` precompiler

### Verification
Check your GnuCOBOL installation and available libraries:
```bash
cobcrun --info
```

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

3. **Explore examples by category** (see sections below)

## Example Categories

### 🔤 I/O Operations
Learn user input, screen control, and system interaction.

| Directory | Description | Documentation |
|-----------|-------------|---------------|
| **[accept/](accept/)** | User input and system data retrieval patterns | [📖 README](accept/README.md) |
| **[display_test/](display_test/)** | Basic output formatting and display techniques | *Basic example* |
| **[display_timing/](display_timing/)** | Timed display operations and screen control | *Basic example* |
| **[screen_size/](screen_size/)** | Terminal dimension detection and screen modes | [📖 README](screen_size/README.md) |
| **[mouse/](mouse/)** | Interactive mouse input and drawing program | [📖 README](mouse/README.md) |

### 🔧 String Processing
Master COBOL's powerful string manipulation capabilities.

| Directory | Description | Documentation |
|-----------|-------------|---------------|
| **[trim/](trim/)** | String trimming with intrinsic functions | [📖 README](trim/README.md) |
| **[unstring/](unstring/)** | String parsing and tokenization techniques | [📖 README](unstring/README.md) |
| **[is_numeric/](is_numeric/)** | Numeric validation and data type checking | *Basic example* |
| **[numval_test/](numval_test/)** | String-to-numeric conversion functions | *Basic example* |

### 📊 Data Structures & Operations
Explore tables, searches, and memory management.

| Directory | Description | Documentation |
|-----------|-------------|---------------|
| **[search/](search/)** | Table search operations (binary and sequential) | [📖 README](search/README.md) |
| **[redifines/](redifines/)** | Memory layout control and data structure overlays | [📖 README](redifines/README.md) |
| **[comp_test/](comp_test/)** | Computational data types and storage formats | *Basic example* |
| **[merge_sort/](merge_sort/)** | File merging and sorting operations | *Basic example* |

### 🏗️ Program Structure
Understand modular programming and system integration.

| Directory | Description | Documentation |
|-----------|-------------|---------------|
| **[sub_program/](sub_program/)** | Inter-program communication and memory management | [📖 README](sub_program/README.md) |
| **[read_command_args/](read_command_args/)** | Command-line argument processing | *Basic example* |
| **[report_writer/](report_writer/)** | Report generation and formatting | *Basic example* |

### 🌐 External Integration
Connect COBOL with databases and modern data formats.

| Directory | Description | Documentation |
|-----------|-------------|---------------|
| **[sql/](sql/)** | PostgreSQL database integration with esqlOC | [📖 README](sql/README.md) |
| **[xml_generate/](xml_generate/)** | XML document generation using libxml2 | [📖 README](xml_generate/README.md) |
| **[json_generate/](json_generate/)** | JSON serialization using libjson-c | [📖 README](json_generate/README.md) |

## Compilation Guide

### Basic Compilation
Most examples use the standard compilation pattern:
```bash
cd example_directory
cobc -x program-name.cbl
./program-name
```

### Examples with External Libraries

**XML Generation:**
```bash
cd xml_generate
cobc -x xml_generate.cbl
./xml_generate
```

**JSON Generation:**
```bash
cd json_generate  
cobc -x json_generate.cbl
./json_generate
```

**Database Integration:**
```bash
cd sql
# Precompile embedded SQL
esqlOC -static -o generated_sql_ex.cbl sql_example.cbl
# Compile with ODBC library
cobc -x -static -locsql generated_sql_ex.cbl
./generated_sql_ex
```

## Learning Path Recommendations

### Beginner Path
1. Start with **[display_test/](display_test/)** for basic output
2. Learn user input with **[accept/](accept/)** 
3. Practice string manipulation with **[trim/](trim/)**
4. Explore data validation with **[is_numeric/](is_numeric/)**

### Intermediate Path  
1. Master string processing with **[unstring/](unstring/)**
2. Learn table operations with **[search/](search/)**
3. Understand memory management with **[redifines/](redifines/)**
4. Practice modular programming with **[sub_program/](sub_program/)**

### Advanced Path
1. Database integration with **[sql/](sql/)**
2. Modern data formats: **[xml_generate/](xml_generate/)** and **[json_generate/](json_generate/)**
3. Interactive applications with **[mouse/](mouse/)**
4. System integration techniques

## Contributing

This repository is actively maintained with ongoing documentation improvements. Each example directory with a 📖 README contains comprehensive documentation including:
- Detailed syntax explanations
- Complete program output examples  
- Compilation and execution instructions
- Code comments and best practices

## Additional Resources

- [GnuCOBOL Documentation](https://gnucobol.sourceforge.io/doc/)
- [COBOL Programming Standards](https://www.ibm.com/docs/en/cobol-zos)
- [esqlOC Precompiler](https://sourceforge.net/p/gnucobol/contrib/HEAD/tree/trunk/esql/)

## License

See [LICENSE](LICENSE) file for details.  




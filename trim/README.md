# Intrinsic TRIM Function Example

The intrinsic ```TRIM``` function trims spaces from the string passed as a parameter. By default, it will trim 
both leading and trailing spaces. You can specify to only trim the leading or trailing spaces by also 
passing ```leading``` or ```trailing``` as a parameter.


Examples:

```function trim(ws-variable)```

```function trim(ws-variable leading)```

```function trim(ws-variable trailing)```

```function trim("  string literal  ")```




If you do not want to have to type ```function``` every time use an intrinsic function, you can add ```function all instrinsic``` 
to your ```repository``` paragraph in the ```configuration section```. 

Example:
```
       environment division. 
       
       configuration section.
       repository.
           function all intrinsic.      
```




```trim.cbl``` demonstrates a couple of examples of using the ```trim``` function.

## Python Migration

This directory also contains ```trim.py```, a Python migration that replicates the exact functionality and output of the COBOL program.

### Running the Programs

**COBOL Version:**
```bash
cobc -x trim.cbl -o trim_test
./trim_test
```

**Python Version:**
```bash
python3 trim.py
```

### Migration Notes
The Python version uses standard string methods (```strip()```, ```lstrip()```, ```rstrip()```) to replicate COBOL's intrinsic trim functions and maintains the exact output format including fixed-width string handling equivalent to COBOL PIC X(30).

### Testing
The migration includes comprehensive pytest tests to verify output matching:

```bash
# Install pytest (if not already installed)
pip3 install pytest

# Run tests
python3 -m pytest test_trim_migration.py -v
```

The test suite includes:
- **Output verification**: Compares COBOL and Python outputs character-by-character
- **Program execution**: Ensures both programs compile/run successfully
- **Function validation**: Tests individual Python trim functions

**Example of program output:**

```
--    hello world               --                                                                                                       
--hello world--
--hello world               --
--    hello world--
******************************
    hello world               
******************************
hello world                   
******************************
hello world                   
******************************
    hello world               
--    String literal    --
--String literal--
--String literal   --
--   String literal--

```




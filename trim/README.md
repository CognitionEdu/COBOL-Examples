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

## Java Migration

This directory also contains ```TrimFunctionTest.java```, which is a Java equivalent of the COBOL trim functionality. The Java version demonstrates the same string trimming operations using Java's built-in String methods:

- ```trim()``` - equivalent to COBOL's ```function trim(string)```
- ```stripLeading()``` - equivalent to COBOL's ```function trim(string leading)```
- ```stripTrailing()``` - equivalent to COBOL's ```function trim(string trailing)```

To compile and run the Java version:
```bash
javac TrimFunctionTest.java
java TrimFunctionTest
```

Both programs produce identical output, demonstrating the equivalence between COBOL and Java string trimming functionality.


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




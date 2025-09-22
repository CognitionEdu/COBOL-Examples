#!/usr/bin/env python3
"""
Python migration of trim.cbl
Author: Devin AI (migrated from Erik Eriksen's COBOL example)
Purpose: Demonstrate string trimming operations equivalent to COBOL's intrinsic trim function
"""

def trim_leading(s):
    """Equivalent to COBOL's TRIM(string LEADING)"""
    return s.lstrip()

def trim_trailing(s):
    """Equivalent to COBOL's TRIM(string TRAILING)"""
    return s.rstrip()

def trim_both(s):
    """Equivalent to COBOL's TRIM(string)"""
    return s.strip()

def main():
    ws_test_string_1 = "    hello world       ".ljust(30)
    
    ws_test_string_2 = " " * 30
    
    print(f"--{ws_test_string_1}--")
    print(f"--{trim_both(ws_test_string_1)}--")
    print(f"--{trim_leading(ws_test_string_1)}--")
    print(f"--{trim_trailing(ws_test_string_1)}--")
    
    ws_test_string_2 = "*" * 30
    print(ws_test_string_2)
    ws_test_string_2 = ws_test_string_1  # COBOL move operation
    print(ws_test_string_2)
    
    ws_test_string_2 = "*" * 30
    print(ws_test_string_2)
    ws_test_string_2 = trim_both(ws_test_string_1).ljust(30)
    print(ws_test_string_2)
    
    ws_test_string_2 = "*" * 30
    print(ws_test_string_2)
    ws_test_string_2 = trim_leading(ws_test_string_1).ljust(30)
    print(ws_test_string_2)
    
    ws_test_string_2 = "*" * 30
    print(ws_test_string_2)
    ws_test_string_2 = trim_trailing(ws_test_string_1).ljust(30)
    print(ws_test_string_2)
    
    print("--    String literal    --")
    print(f"--{trim_both('   String literal    ')}--")
    print(f"--{trim_leading('     String literal   ')}--")
    print(f"--{trim_trailing('   String literal    ')}--")

if __name__ == "__main__":
    main()

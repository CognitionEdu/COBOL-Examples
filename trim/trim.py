#!/usr/bin/env python3
"""Python migration of trim.cbl.

This module provides a Python implementation of COBOL's trim functionality,
demonstrating string trimming operations equivalent to COBOL's intrinsic
trim function.

Author: Devin AI (migrated from Erik Eriksen's COBOL example)
Purpose: Demonstrate string trimming operations equivalent to COBOL's intrinsic
trim function
"""


def trim_leading(s: str) -> str:
    """Remove leading whitespace from string.

    Equivalent to COBOL's TRIM(string LEADING).

    Args:
        s: Input string to trim.

    Returns:
        String with leading whitespace removed.
    """
    return s.lstrip()


def trim_trailing(s: str) -> str:
    """Remove trailing whitespace from string.

    Equivalent to COBOL's TRIM(string TRAILING).

    Args:
        s: Input string to trim.

    Returns:
        String with trailing whitespace removed.
    """
    return s.rstrip()


def trim_both(s: str) -> str:
    """Remove leading and trailing whitespace from string.

    Equivalent to COBOL's TRIM(string).

    Args:
        s: Input string to trim.

    Returns:
        String with leading and trailing whitespace removed.
    """
    return s.strip()


def main() -> None:
    """Main function demonstrating COBOL trim functionality in Python.

    This function replicates the exact behavior and output format of the
    original COBOL trim.cbl program, including fixed-width string handling
    using ljust(30) to match COBOL's PIC X(30) behavior.
    """
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

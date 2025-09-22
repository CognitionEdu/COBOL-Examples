#!/usr/bin/env python3
"""Pytest tests to verify COBOL and Python trim programs produce identical
output.

This module contains comprehensive tests to ensure that the Python migration
of the COBOL trim example produces exactly the same output as the original
COBOL program, including character-by-character verification.
"""

import os
import subprocess

import pytest


def run_cobol_program() -> str:
    """Compile and run the COBOL trim program, return its output.

    Returns:
        The stdout output from running the COBOL program.

    Raises:
        pytest.fail: If compilation or execution fails.
    """
    compile_result = subprocess.run(
        ["cobc", "-x", "trim.cbl", "-o", "trim_test"],
        capture_output=True,
        text=True,
        cwd=os.path.dirname(__file__),
    )

    if compile_result.returncode != 0:
        pytest.fail(f"COBOL compilation failed: {compile_result.stderr}")

    try:
        run_result = subprocess.run(
            ["./trim_test"],
            capture_output=True,
            text=True,
            cwd=os.path.dirname(__file__),
        )

        if run_result.returncode != 0:
            pytest.fail(f"COBOL program execution failed: {run_result.stderr}")

        return run_result.stdout

    finally:
        trim_test_path = os.path.join(os.path.dirname(__file__), "trim_test")
        if os.path.exists(trim_test_path):
            os.remove(trim_test_path)


def run_python_program() -> str:
    """Run the Python trim program, return its output.

    Returns:
        The stdout output from running the Python program.

    Raises:
        pytest.fail: If execution fails.
    """
    run_result = subprocess.run(
        ["python3", "trim.py"],
        capture_output=True,
        text=True,
        cwd=os.path.dirname(__file__),
    )

    if run_result.returncode != 0:
        pytest.fail(f"Python program execution failed: {run_result.stderr}")

    return run_result.stdout


def test_cobol_python_output_match() -> None:
    """Test that COBOL and Python programs produce identical output.

    This test compares the complete output of both programs line by line
    to ensure perfect compatibility between the COBOL original and Python
    migration.
    """
    cobol_output = run_cobol_program()
    python_output = run_python_program()

    cobol_lines = cobol_output.splitlines()
    python_lines = python_output.splitlines()

    assert len(cobol_lines) == len(python_lines), (
        f"Output line count differs: COBOL has {len(cobol_lines)} lines, "
        f"Python has {len(python_lines)} lines"
    )

    for i, (cobol_line, python_line) in enumerate(
        zip(cobol_lines, python_lines)
    ):
        assert cobol_line == python_line, (
            f"Line {i + 1} differs: \n"
            f"COBOL:  '{cobol_line}'\n"
            f"Python: '{python_line}'"
        )

    assert cobol_output == python_output, "Complete outputs do not match"


def test_cobol_program_runs() -> None:
    """Test that the COBOL program compiles and runs successfully.

    Verifies that the original COBOL program can be compiled and executed
    without errors and produces non-empty output.
    """
    output = run_cobol_program()
    assert output is not None
    assert len(output.strip()) > 0, "COBOL program should produce output"


def test_python_program_runs() -> None:
    """Test that the Python program runs successfully.

    Verifies that the Python migration can be executed without errors
    and produces non-empty output.
    """
    output = run_python_program()
    assert output is not None
    assert len(output.strip()) > 0, "Python program should produce output"


def test_trim_functions_exist() -> None:
    """Test that the Python trim functions are properly defined.

    Verifies that all required trim functions exist and work correctly
    with sample input data, ensuring the API matches expectations.
    """
    import sys

    sys.path.insert(0, os.path.dirname(__file__))

    try:
        import trim

        test_string = "  hello world  "

        assert hasattr(trim, "trim_both"), "trim_both function should exist"
        assert hasattr(
            trim, "trim_leading"
        ), "trim_leading function should exist"
        assert hasattr(
            trim, "trim_trailing"
        ), "trim_trailing function should exist"

        assert trim.trim_both(test_string) == "hello world"
        assert trim.trim_leading(test_string) == "hello world  "
        assert trim.trim_trailing(test_string) == "  hello world"

    finally:
        if os.path.dirname(__file__) in sys.path:
            sys.path.remove(os.path.dirname(__file__))


def test_main_function_execution() -> None:
    """Test that the main function executes without errors.

    This test ensures the main() function can be called directly and
    produces the expected output format, improving code coverage.
    """
    import sys
    from io import StringIO

    sys.path.insert(0, os.path.dirname(__file__))

    try:
        import trim

        captured_output = StringIO()
        original_stdout = sys.stdout
        sys.stdout = captured_output

        trim.main()

        sys.stdout = original_stdout
        output = captured_output.getvalue()

        lines = output.strip().split("\n")
        assert (
            len(lines) >= 10
        ), "Main function should produce multiple output lines"

        assert lines[0].startswith("--"), "First line should start with '--'"
        assert lines[0].endswith("--"), "First line should end with '--'"
        assert any(
            "*" in line for line in lines
        ), "Output should contain asterisk lines"
        assert any(
            "String literal" in line for line in lines
        ), "Output should contain string literal examples"

    finally:
        if os.path.dirname(__file__) in sys.path:
            sys.path.remove(os.path.dirname(__file__))


def test_module_execution_path() -> None:
    """Test the if __name__ == '__main__' execution path.

    This test verifies that the module can be executed as a script
    and produces the expected output, achieving 100% code coverage.
    """
    import subprocess

    result = subprocess.run(
        ["python3", "trim.py"],
        capture_output=True,
        text=True,
        cwd=os.path.dirname(__file__),
    )

    assert result.returncode == 0, f"Module execution failed: {result.stderr}"
    assert (
        len(result.stdout.strip()) > 0
    ), "Module execution should produce output"

    lines = result.stdout.strip().split("\n")
    assert (
        len(lines) >= 10
    ), "Module execution should produce multiple output lines"

    assert lines[0].startswith("--"), "First line should start with '--'"
    assert lines[0].endswith("--"), "First line should end with '--'"
    assert any(
        "*" in line for line in lines
    ), "Output should contain asterisk lines"
    assert any(
        "String literal" in line for line in lines
    ), "Output should contain string literal examples"


def test_name_main_guard_coverage() -> None:
    """Test the __name__ == '__main__' guard for 100% coverage.

    This test specifically covers the if __name__ == '__main__' execution
    path to achieve complete code coverage of trim.py.
    """
    import importlib.util
    import sys
    from io import StringIO

    # Load the trim module from file to simulate script execution
    spec = importlib.util.spec_from_file_location(
        "__main__", os.path.join(os.path.dirname(__file__), "trim.py")
    )
    assert spec is not None, "Failed to create module spec"
    assert spec.loader is not None, "Module spec has no loader"

    trim_module = importlib.util.module_from_spec(spec)

    captured_output = StringIO()
    original_stdout = sys.stdout
    sys.stdout = captured_output

    try:
        spec.loader.exec_module(trim_module)

        sys.stdout = original_stdout
        output = captured_output.getvalue()

        lines = output.strip().split("\n")
        assert (
            len(lines) >= 10
        ), "Main execution should produce multiple output lines"
        assert lines[0].startswith("--"), "First line should start with '--'"
        assert lines[0].endswith("--"), "First line should end with '--'"
        assert any(
            "*" in line for line in lines
        ), "Output should contain asterisk lines"
        assert any(
            "String literal" in line for line in lines
        ), "Output should contain string literal examples"

        assert "--    hello world               --" in lines[0]
        assert "--hello world--" in lines[1]

    finally:
        sys.stdout = original_stdout


if __name__ == "__main__":
    pytest.main([__file__, "-v"])

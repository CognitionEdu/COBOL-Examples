#!/usr/bin/env python3
"""
Pytest tests to verify COBOL and Python trim programs produce identical output.
"""

import subprocess
import tempfile
import os
import pytest


def run_cobol_program():
    """Compile and run the COBOL trim program, return its output."""
    compile_result = subprocess.run(
        ["cobc", "-x", "trim.cbl", "-o", "trim_test"],
        capture_output=True,
        text=True,
        cwd=os.path.dirname(__file__)
    )
    
    if compile_result.returncode != 0:
        pytest.fail(f"COBOL compilation failed: {compile_result.stderr}")
    
    try:
        run_result = subprocess.run(
            ["./trim_test"],
            capture_output=True,
            text=True,
            cwd=os.path.dirname(__file__)
        )
        
        if run_result.returncode != 0:
            pytest.fail(f"COBOL program execution failed: {run_result.stderr}")
        
        return run_result.stdout
    
    finally:
        trim_test_path = os.path.join(os.path.dirname(__file__), "trim_test")
        if os.path.exists(trim_test_path):
            os.remove(trim_test_path)


def run_python_program():
    """Run the Python trim program, return its output."""
    run_result = subprocess.run(
        ["python3", "trim.py"],
        capture_output=True,
        text=True,
        cwd=os.path.dirname(__file__)
    )
    
    if run_result.returncode != 0:
        pytest.fail(f"Python program execution failed: {run_result.stderr}")
    
    return run_result.stdout


def test_cobol_python_output_match():
    """Test that COBOL and Python programs produce identical output."""
    cobol_output = run_cobol_program()
    python_output = run_python_program()
    
    cobol_lines = cobol_output.splitlines()
    python_lines = python_output.splitlines()
    
    assert len(cobol_lines) == len(python_lines), (
        f"Output line count differs: COBOL has {len(cobol_lines)} lines, "
        f"Python has {len(python_lines)} lines"
    )
    
    for i, (cobol_line, python_line) in enumerate(zip(cobol_lines, python_lines)):
        assert cobol_line == python_line, (
            f"Line {i+1} differs:\n"
            f"COBOL:  '{cobol_line}'\n"
            f"Python: '{python_line}'"
        )
    
    assert cobol_output == python_output, "Complete outputs do not match"


def test_cobol_program_runs():
    """Test that the COBOL program compiles and runs successfully."""
    output = run_cobol_program()
    assert output is not None
    assert len(output.strip()) > 0, "COBOL program should produce output"


def test_python_program_runs():
    """Test that the Python program runs successfully."""
    output = run_python_program()
    assert output is not None
    assert len(output.strip()) > 0, "Python program should produce output"


def test_trim_functions_exist():
    """Test that the Python trim functions are properly defined."""
    import sys
    import os
    
    sys.path.insert(0, os.path.dirname(__file__))
    
    try:
        import trim
        
        test_string = "  hello world  "
        
        assert hasattr(trim, 'trim_both'), "trim_both function should exist"
        assert hasattr(trim, 'trim_leading'), "trim_leading function should exist"
        assert hasattr(trim, 'trim_trailing'), "trim_trailing function should exist"
        
        assert trim.trim_both(test_string) == "hello world"
        assert trim.trim_leading(test_string) == "hello world  "
        assert trim.trim_trailing(test_string) == "  hello world"
        
    finally:
        if os.path.dirname(__file__) in sys.path:
            sys.path.remove(os.path.dirname(__file__))


if __name__ == "__main__":
    pytest.main([__file__, "-v"])

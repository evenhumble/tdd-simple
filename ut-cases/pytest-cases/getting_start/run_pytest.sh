
echo "run test_pass_failed"
pytest test_pass_fail.py
pytest -v test_pass_fail.py

pytest --collect-only
pytest -k "named test " --collect only

# -k pass expression

## marker: pytest -m <marker_name>
## pytest command
# pytest -v sub_folder
# pytest <test_file>::test_method/testclass
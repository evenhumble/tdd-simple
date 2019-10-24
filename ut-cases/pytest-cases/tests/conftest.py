# -*- coding: utf-8 -*-
import pytest

TARGET_ENV = "OFF"


def pytest_addoption(parser):
    parser.addoption("--target_env", action="store", help="some boolean options", default="baz")


@pytest.fixture
def target_evn_config(request):
    TARGET_ENV = request.config.getoption("--target_env")
    print(TARGET_ENV)

# def pytest_runtest_setup(item):
#     print("this is testing conf tests")
#     print("setting up ", item)
#     print(item)

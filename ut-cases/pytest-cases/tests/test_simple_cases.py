# -*- coding: utf-8 -*-
from tests.conftest import TARGET_ENV


def inc(x):
    return x + 1


def test_inc():
    result = inc(10)
    assert result == 11


def test_target_env():
    assert TARGET_ENV == "OFF"
    print(TARGET_ENV)

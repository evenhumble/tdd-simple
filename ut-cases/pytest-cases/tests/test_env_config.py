# -*- coding: utf-8 -*-
from tests.env_config import test_env


def test_which_env():
    print(test_env.name)
    assert test_env.name == "beta"

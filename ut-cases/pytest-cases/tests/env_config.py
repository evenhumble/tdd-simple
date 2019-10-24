# -*- coding: utf-8 -*-
import os


class EnvTest:

    def __init__(self):
        self.name = "alfa"


class EnvBeta:

    def __init__(self):
        self.name = "beta"


class EnvStage:

    def __init__(self):
        self.name = "stage"


envs = {
    "Test": EnvTest(),
    "Stage": EnvStage(),
    "BETA": EnvBeta()
}

test_env = envs.get(os.getenv("target_env"))

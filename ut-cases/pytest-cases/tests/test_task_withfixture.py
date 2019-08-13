# -*- coding: utf-8 -*-
import pytest


@pytest.fixture()
def some_data_fixture():
    return [42, 34]


def test_some_data(some_data_fixture):
    assert len(some_data_fixture) == 2
    for item in some_data_fixture:
        print(item)


def tasks_db(tmpdir):
    print("start of testing")
    yield
    print("end of testing")


@pytest.fixture(scope="function")
def func_scope():
    print("function scope")


@pytest.fixture(scope="module")
def mod_scope():
    print("module scope")


@pytest.fixture(scope='session')
def session_scope():
    print("sessions class")


@pytest.fixture(scope='class')
def class_scope():
    print("scope class")


@pytest.mark.usefixtures('class_scope')
class TestScope():
    def test_3(self):
        print("test ")


def test_1(session_scope, mod_scope, func_scope):
    print("test 3")


def test_2(session_scope, mod_scope, func_scope):
    print("test2 in multiple fixtures")

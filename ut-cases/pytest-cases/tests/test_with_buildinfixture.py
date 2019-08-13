# -*- coding: utf-8 -*-

# tmpdir and temdir_factory
import json

import pytest


def test_tmpdir(tmpdir):
    print(tmpdir)
    a_file = tmpdir.join('something.txt')
    print(a_file)
    sub_folder = tmpdir.mkdir('anything')
    a_file.write("this is a file testing")


def test_tmpdir_factory(tmpdir_factory):
    a_di = tmpdir_factory.mktemp('mydir')
    base_temp = tmpdir_factory.getbasetemp()
    print("base:", base_temp)


@pytest.fixture(scope='module')
def write_json_to_file(tmpdir_factory):
    json_data = {
        'Ned': {"city": 'shanghai'}
    }
    json_file = tmpdir_factory.mktemp('data').join('json_file.json')
    with json_file.open('w') as f:
        json.dump(json_data, f, ensure_ascii='utf-8')
    return json_file


@pytest.mark.usefixtures('write_json_to_file')
def test_with_fixture():
    print("end of using tmpdir factory")

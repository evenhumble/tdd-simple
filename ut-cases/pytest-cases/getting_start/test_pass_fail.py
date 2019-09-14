# -*- coding: utf-8 -*-
import pytest


def test_pass():
    assert 1==1

def test_failed():
    assert 1!=1

@pytest.mark.run_these_please
def test_failed_tuple():
    assert (1,2,3)==(3,2,1)
# -*- coding: utf-8 -*-
import pytest
from pytest import approx

testdata ={
    (1,2,3),
    (4,5,6)
}

@pytest.mark.parametrize("testdata",testdata)
def test_with_parms(testdata):
    print(testdata)
    print("start testing")
    for testdatum in testdata:
        print(testdatum)
    print("end of testing")


@pytest.mark.parametrize("x,y,z",testdata)
def test_xyz(x,y,z):
    print("start test xyz")
    print(x,y,z)
    print(approx(z))
    print("end of test xyz")
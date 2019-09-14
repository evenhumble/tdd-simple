package io.hedwig.testngcases.demotests;

import org.testng.annotations.*;

@Listeners(value = {TmpSuiteListener.class})
public class TestNgDemo2 {
    @BeforeTest
    public void beforeTestRun(){
        System.out.println("do it before running tests .....");
    }

    @BeforeMethod
    public void beforeMethodRun(){
        System.out.println("do it before invoking test method.....");
    }
    @AfterMethod
    public void afterMethodRun(){
        System.out.println("do it after invoking test method.....");
    }
    @Test
    public void testTestNgMethod_Simple1(){
        System.out.println("run test1 .....");
    }
    @Test
    public void testTestNgMethod_Simple2(){
        System.out.println("run test2.....");
    }

    @AfterTest
    public void afterTestRun(){
        System.out.println("do it after tests");
    }
}

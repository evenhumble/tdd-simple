package io.hedwig.testngcases.demotests;

import org.testng.annotations.*;

@Listeners(value = {TmpSuiteListener.class})
public class TestNgDemo1 {

    @Test
    public void testTestNgMethod_Simple1(){
        System.out.println("run test1 .....");
    }
    @Test
    public void testTestNgMethod_Simple2(){
        System.out.println("run test2.....");
    }
}

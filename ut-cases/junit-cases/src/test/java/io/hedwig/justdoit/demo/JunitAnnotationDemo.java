package io.hedwig.justdoit.demo;

import org.junit.Before;
import org.junit.Test;

public class JunitAnnotationDemo {

    String testString="First";

    @Before
    public void setUp(){
        testString = this.testString + ",setup";
        System.out.println(this);
    }

    @Test
    public void testTestString_First(){
        System.out.println(testString);
    }

    @Test
    public void testTestString_Second(){
        System.out.println(testString);
    }
}

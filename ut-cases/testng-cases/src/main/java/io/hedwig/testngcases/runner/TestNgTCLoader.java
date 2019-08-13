package io.hedwig.testngcases.runner;

import io.hedwig.testngcases.runner.model.DHTestCase;
import io.hedwig.testngcases.runner.model.DHTestSuite;
import org.testng.TestNG;

import java.util.Collections;
import java.util.List;

public class TestNgTCLoader {

    public List<DHTestSuite> loadTestSuite(String packageName){

        return Collections.emptyList();
    }
    public List<DHTestCase> loadTestCases(String testClassName){
        return Collections.emptyList();
    }
    public DHTestSuite loadTestSuiteByClass(String className){

        return new DHTestSuite();
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
//        testNG.addClassLoader();
    }
}

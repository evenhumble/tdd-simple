package io.hedwig.testngcases.runner.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DHTestSuite {

    private String name;
    private List<DHTestCase> testCases = new ArrayList<DHTestCase>();
}

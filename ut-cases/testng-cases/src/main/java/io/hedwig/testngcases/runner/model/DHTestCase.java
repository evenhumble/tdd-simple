package io.hedwig.testngcases.runner.model;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DHTestCase {
    private String name;
    private String className;
    private String methodName;
    private Map<String,Object> parameters= new HashMap<String, Object>();
}

package io.hedwig.justdoit.perfdemo;

import io.hedwig.justdoit.demo.UUIDGenerator;

import java.util.UUID;

public class DemoPerfService {

    public String getServiceId(String userId){

        return UUID.randomUUID().toString();
    }
}

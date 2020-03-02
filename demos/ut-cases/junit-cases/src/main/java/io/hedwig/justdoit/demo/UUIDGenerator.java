package io.hedwig.justdoit.demo;

import java.util.UUID;

public class UUIDGenerator {
    public static String generateToDoId(){
       return UUID.randomUUID().toString();
    }
}

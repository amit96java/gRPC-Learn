package com.vinsguru.Sec02protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.InvalidProtocolBufferException;
import com.vinsguru.json.JPerson;
import com.vinsguru.models.Person;
//import com.vinsguru.models.Person;

public class L2PerformanceTest {
    public static void main(String[] args) {
        // json serialization-deserialization
        JPerson jPerson = new JPerson();
        jPerson.setName("sam");
        jPerson.setAge(10);
        ObjectMapper mapper = new ObjectMapper();
        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(jPerson);
                System.out.println("length of bytes in json "+bytes.length);
                JPerson jPerson1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };



        // protobuf serialization-deserialization
                Person sam = Person.newBuilder()
                .setName("sam")
                .setAge(10)
                .build();

        Runnable proto = () -> {
            try {
                byte[] bytes = sam.toByteArray();
                System.out.println("length of bytes in protobuf "+bytes.length);
                Person sam1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        runPerformanceTest(json, "JSON");
        runPerformanceTest(proto, "proto");
    }

    public static void runPerformanceTest(Runnable runnable, String method) {
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            runnable.run();
        }
        long time2 = System.currentTimeMillis();

        System.out.println(method+" : "+(time2-time1) + " ms");
    }
}

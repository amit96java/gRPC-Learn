package com.vinsguru.protobuf;

//import com.vinsguru.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class L1PersonDemo {
    public static void main(String[] args) throws IOException {
//        Person sam2 = Person.newBuilder()
//                .setName("sam")
//                .setAge(10)
//                .build();


        Path path = Paths.get("sam.ser");
//        Files.write(path, sam2.toByteArray());

        byte[] bytes = Files.readAllBytes(path);
//        Person newSam = Person.parseFrom(bytes);

//        System.out.println("new sam "+newSam);

    }
}

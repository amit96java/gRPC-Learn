package com.vinsguru.Sec02protobuf;

import com.vinsguru.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class L7VersionCompatibilityTest {
    public static void main(String[] args) throws IOException {
        Path pathV1 = Paths.get("tv-v1");
        Path pathV2 = Paths.get("tv-v2");

        // code for v1
//       Television television = Television.newBuilder()
//                .setBrand("sony")
//                .setYear(2024)
//                .build();
//
//
//        Files.write(pathV1, television.toByteArray());

        byte[] bytes = Files.readAllBytes(pathV1);
        System.out.println(Television.parseFrom(bytes));


        //code for v2
//        Television sonyV2 = Television.newBuilder()
//                .setBrand("sony")
//                .setModel(2024)
//                .setType(Type.OLED)
//                .build();
//        Files.write(pathV2, sonyV2.toByteArray());
//       byte[] sonyBytes =  Files.readAllBytes(pathV2);
//
//        System.out.println(Television.parseFrom(sonyBytes));
    }
}

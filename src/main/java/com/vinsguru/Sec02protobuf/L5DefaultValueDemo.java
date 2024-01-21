package com.vinsguru.Sec02protobuf;

import com.vinsguru.models.Person;

public class L5DefaultValueDemo {
    public static void main(String[] args) {
        Person person = Person.newBuilder().build();

        //there is no null in protobuf.
        System.out.println("city : "+person.getAddress().getCity());
        System.out.println(person.hasAddress());
    }
}

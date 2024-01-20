package com.vinsguru.protobuf;

import com.vinsguru.models.Address;
import com.vinsguru.models.Car;
import com.vinsguru.models.Dealer;
import com.vinsguru.models.Person;

import java.util.List;

public class L4MapDemo {
    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("mail street")
                .setCity("Atlanta")
                .build();
        Car car1 = Car.newBuilder()
                .setMake("Honda")
                .setModel("Accord")
                .setYear("2020")
                .build();

        Car car2 = Car.newBuilder()
                .setMake("Kia")
                .setModel("Sonet")
                .setYear("2024")
                .build();
        Dealer dealer = Dealer.newBuilder()
                .putModel(2005, car1)
                .putModel(2024, car2)
                .build();
        Person sam = Person.newBuilder()
                .setAge(20)
                .setName("sam")
                .setAddress(address)
                .addAllCar(List.of(car1, car2))
                .build();

//        System.out.println(dealer.getModelMap());
        System.out.println(dealer.getModelOrThrow(2024).getBodyStyle());
    }
}

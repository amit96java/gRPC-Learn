package com.vinsguru.Sec02protobuf;

import com.vinsguru.models.Credentials;
import com.vinsguru.models.EmailCredentials;
import com.vinsguru.models.PhoneOTP;

public class L6OneOfDemo {
    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("amit96pal.ap@gmail.com")
                .setPassword("amit123")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(72751187)
                .setCode(1234)
                .build();

//        Credentials credentials = Credentials.newBuilder()
//                .setEmailMode(emailCredentials)
//                .build();

        Credentials credentials = Credentials.newBuilder()
                .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {
        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println("email mode");
                break;
            case PHONEMODE:
                System.out.println("phone mode");
                break;
        }
        System.out.println(credentials.getEmailMode());
    }
}

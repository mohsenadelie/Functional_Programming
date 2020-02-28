package com.adeli.callback;

import java.util.function.Consumer;

//    JavaScript CallBack
//    function hello(firstName, lastName, callback) {
//        console.log(firstName);
//        if (lastName)
//            console.log(lastName);
//        else
//            callback();
//    };

public class Main {
    public static void main(String[] args) {
        hello("Mohsen", "Adeli", value -> {
            System.out.println("no lastName provided for " + value);
        });

        hello("Mohsen", null, value -> {
            System.out.println("no lastName provided for " + value);
        });

        hello2("Mohsen",
                null,
                () -> System.out.println("no lastName provided")
        );

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println("firstName: " + firstName);
        if (lastName != null) {
            System.out.println("lastName: " + lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println("firstName: " + firstName);
        if (lastName != null) {
            System.out.println("lastName: " + lastName);
        } else {
            callback.run();
        }
    }

}
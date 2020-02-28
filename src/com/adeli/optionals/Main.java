package com.adeli.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object value = Optional.ofNullable("hello")
                .orElseGet(() -> "default value");
        System.out.println(value);

        Optional.ofNullable("mohsen@gmail.com")
                .ifPresent(email -> System.out.println("send to " + email));

        // Nothing to output
        Optional.ofNullable(null)
                .ifPresent(email -> System.out.println("send to " + email));

        // In two condition has an output
        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email")
                );
    }
}

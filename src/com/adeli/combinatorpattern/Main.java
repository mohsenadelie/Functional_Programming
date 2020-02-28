package com.adeli.combinatorpattern;

import java.time.LocalDate;

import static com.adeli.combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Ali",
                "aligmail.com",
                "09129009001",
                LocalDate.of(2000,1,1)
        );

        System.out.println(new CustomerValidationService().isValid(customer));

        // Using combinator pattern
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);

        System.out.println(result);
    }
}

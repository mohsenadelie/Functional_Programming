package com.adeli.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        System.out.println("without predicate");
        System.out.println(isPhoneNumberValid("09361334286"));
        System.out.println(isPhoneNumberValid("093611111"));
        System.out.println(isPhoneNumberValid("09120000000"));

        System.out.println("with predicate");
        System.out.println(isPhoneNumberValidPredicate.test("09361334286"));
        System.out.println(isPhoneNumberValidPredicate.test("093611111"));
        System.out.println(isPhoneNumberValidPredicate.test("09120000000"));

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.and(containsNumber3).test("09361334286")
        );

        System.out.println(
                "Is phone number valid and contains number 3 = " +
                        isPhoneNumberValidPredicate.or(containsNumber3).test("09107609208")
        );

    }


    static boolean isPhoneNumberValid(String phoneNumber) {
        return (phoneNumber.startsWith("0936") && phoneNumber.length() == 11);
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("0936") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}

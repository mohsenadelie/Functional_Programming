package com.adeli.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.adeli.streams._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Hasan", MALE),
                new Person("Kati", FEMALE),
                new Person("Sahar", FEMALE),
                new Person("Reza", MALE),
                new Person("Maryam", FEMALE)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet()) // removes repeated items
                .forEach(System.out::println);

        System.out.println(people);

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        boolean containsOnlyKnownGender = people.stream()
                .noneMatch(personPredicate);

        System.out.println(containsOnlyKnownGender);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }

}

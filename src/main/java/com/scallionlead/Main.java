package com.scallionlead;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.scallionlead.Main.Gender.FEMALE;
import static com.scallionlead.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)

        );

        //Imperative Approach
        System.out.println("//Imperative Approach");
        List<Person> females = new ArrayList<Person>();

        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }

        //Declarative Approach
        System.out.println("//Declarative Approach");
//        people.stream().filter(person -> FEMALE.equals(person.gender)).forEach(System.out::println);
        final Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        List<Person> female2 = people.stream().filter(personPredicate).collect(Collectors.toList());
        female2.forEach(System.out::println);
    }


    @AllArgsConstructor
    @Getter
    @ToString
    static class Person {
        private final String name;
        private final Gender gender;

    }

    enum Gender {
        MALE, FEMALE
    }
}

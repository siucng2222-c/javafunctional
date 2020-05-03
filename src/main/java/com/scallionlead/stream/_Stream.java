package com.scallionlead.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static com.scallionlead.stream._Stream.Gender.*;


public class _Stream {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("BOB", PREFER_NOT_TO_SAY)

        );

        people.stream().map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        people.stream().map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        // Extract above lambda as separate variables
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;
        people.stream().map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

    }

    @AllArgsConstructor
    @Getter
    @ToString
    static class Person {
        private final String name;
        private final Gender gender;

    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}

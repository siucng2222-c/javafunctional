package com.scallionlead.callbacks;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Lambdas {
    public static void main(String[] args) {

        // Simple 1-liner lambda
        Function<String, String> upperCaseName = name -> name.toUpperCase();

        // Complex logic
        Function<String, String> upperCaseName2 = name -> {
            if(name == null || name.isBlank()) throw new IllegalStateException("name is null or blank");
            return name.toUpperCase();
        };

        // BiFunction lambda
        BiFunction<String, Integer, String> upperCaseName3 = (name, age) -> {
            System.out.println(age);
            return name.toUpperCase();
        };
        System.out.println(upperCaseName3.apply("jane", 43));

        //Primitives types in Lambda
        Integer ageObj = null;
        int ageInt = 0;
        System.out.println(upperCaseName3.apply("john", ageObj));
        System.out.println(upperCaseName3.apply("john", ageInt));

        Service svr = new Service();
        svr.bar.accept("voo");
    }

}


 class Service {

    public Consumer<String> bar = foo -> System.out.println("consume bar by foo " + foo);
}

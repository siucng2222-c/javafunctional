package com.scallionlead.optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        String halo = "Hello";
//        String halo = null;

        Object value = Optional.ofNullable(halo)
                .orElseGet(() -> "default value");
        System.out.println(value);

        try {
            Supplier<IllegalStateException> halo_is_null =
                    () -> new IllegalStateException("halo is null");
            Object value2 = Optional.ofNullable(halo)
                    .orElseThrow(halo_is_null);
//        .orElseThrow();
            System.out.println(value2);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        Optional.ofNullable(halo)
                .ifPresent(System.out::println);

//        String user_email = "john.doe@local.com";
        String user_email = null;
        Optional.ofNullable(user_email)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        ()-> System.out.println("Invalid email address..."));

    }
}

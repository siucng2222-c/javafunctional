package com.scallionlead.combinatorpattern;

import java.time.LocalDate;

import static com.scallionlead.combinatorpattern.CustomerRegistrationValidator.*;
import static com.scallionlead.combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+85211111111",
                LocalDate.of(2010, 1, 1)
        );

        // Can validate the customer, but don't know the reason when validation returns invalid
        System.out.println(new CustomerValidatorService().isValid(customer));

        // Using combinator pattern
        // apply CustomerRegistrationValidator Function interface
        System.out.println("=== 1st Try");
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .apply(customer);
        System.out.println(result);

        try {
            // Check result here will NOT apply() again
            System.out.println("=== 2nd Try");
            System.out.println(result);
            if(result != SUCCESS) {
                System.out.println("not success, throw IllegalStateException");
                throw new IllegalStateException(result.name());
            }
        } catch (IllegalStateException e) {
            // Question 1: This printStackTrace appear later than 3rd Try???
            System.out.println("catch exception... ");
            e.printStackTrace();
            System.out.println("Question.. The stackTrace got printed out after all below 3rd Try printouts?? ");
        }

        // Function interface is lazy load, validator methods will not run until we apply()
        // Below will not run
        System.out.println("=== 3rd Try");
        CustomerRegistrationValidator result2 = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult());
//        System.out.println(result2.apply(customer));

    }
}

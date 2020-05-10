package com.scallionlead.combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static com.scallionlead.combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static com.scallionlead.combinatorpattern.CustomerRegistrationValidator.ValidationResult.*;

// Combinator Pattern to implement validator and return reason when invalid
public interface CustomerRegistrationValidator
        extends Function<Customer, ValidationResult> {

    static CustomerRegistrationValidator isEmailValid(){

        // Question 2: Shouldn't the whole isEmailValid method "lazy load" by apply? The Statement here still got printed out in 3rd Try (without apply)...
        System.out.println("in isEmailValid...");
        return customer -> {
            // Verify if validation method only trigger by Function interface apply()
            System.out.println("Checking customer.email isEmailValid");
            return customer.getEmail().contains("@") ?
                    SUCCESS : EMAIL_NOT_VALID;
        };
    }

    static CustomerRegistrationValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+852") ?
                SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegistrationValidator isAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() >= 18 ?
                SUCCESS : IS_NOT_ADULT;
    }

    default CustomerRegistrationValidator and (CustomerRegistrationValidator other) {
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_ADULT
    }

}

package com.scallionlead.functionalinterface;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    // An operation that accept one argument

    public static void main(String[] args) {
        Customer maria = new Customer("Maria", "00000");
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Customer Functional interface
        greetCustomerConsumer.accept(maria);

        // Biconsumer Functional interface
        greetCustomerConsumerV2.accept(maria, false);
    }

    // Biconsumer
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
              System.out.printf("Hello %s, thanks for registering with phone number %s\n",
                    customer.getCustomerName(), showPhoneNumber ? customer.getCustomerPhoneNumber() : "******");


    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.printf("Hello %s, thanks for registering with phone number %s\n", customer.getCustomerName(), customer.getCustomerPhoneNumber());

    static void greetCustomer(Customer customer) {
        System.out.printf("Hello %s, thanks for registering with phone number %s\n", customer.getCustomerName(), customer.getCustomerPhoneNumber());
    }

    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.printf("Hello %s, thanks for registering with phone number %s\n",
                customer.getCustomerName(), showPhoneNumber ? customer.getCustomerPhoneNumber() : "******");
    }

    @AllArgsConstructor
    @ToString
    @Getter
    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;
    }
}

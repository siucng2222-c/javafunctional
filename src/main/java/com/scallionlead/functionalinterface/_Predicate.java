package com.scallionlead.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // Without Predicate
        System.out.println("// Without Predicate");
        System.out.println(isPhoneNumberValid("09012345678"));
        System.out.println(isPhoneNumberValid("07012345678"));
        System.out.println(isPhoneNumberValid("070124567"));

        // Use Predicate
        System.out.println("// Use Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("09012345678"));
        System.out.println(isPhoneNumberValidPredicate.test("07012345678"));
        System.out.println(isPhoneNumberValidPredicate.test("070124567"));

        // Chain Predicates with and
        System.out.println("// Chain Predicates with and");
        System.out.printf("Is phone number valid and contains number 3 = %b\n", isPhoneNumberValidPredicate.and(containsNumber3).test("09012345678"));
        System.out.printf("Is phone number valid and contains number 3 = %b\n", isPhoneNumberValidPredicate.and(containsNumber3).test("07012345678"));
        System.out.printf("Is phone number valid and contains number 3 = %b\n", isPhoneNumberValidPredicate.and(containsNumber3).test("070124567"));

        // Chain Predicates with or
        System.out.println("// Chain Predicates with or");
        System.out.printf("Is phone number valid or contains number 3 = %b\n", isPhoneNumberValidPredicate.or(containsNumber3).test("09012345678"));
        System.out.printf("Is phone number valid or contains number 3 = %b\n", isPhoneNumberValidPredicate.or(containsNumber3).test("07012345678"));
        System.out.printf("Is phone number valid or contains number 3 = %b\n", isPhoneNumberValidPredicate.or(containsNumber3).test("070124567"));
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}

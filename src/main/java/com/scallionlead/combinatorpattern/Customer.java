package com.scallionlead.combinatorpattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@ToString
public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate dob;

}

package com.scallionlead.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        // Represent a supplier of results
        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlListSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc:postgre://localhost:5432/testdb";
    }

    static Supplier<String> getDBConnectionUrlSupplier = () -> "jdbc:postgre://localhost:5432/testdb";
    static Supplier<List<String>> getDBConnectionUrlListSupplier = () ->
            List.of(
                    "jdbc:postgre://localhost:5432/testdb",
                    "jdbc:postgre://localhost:5432/testdb2"
            );
}

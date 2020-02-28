package com.adeli.functionalinterface;

import javax.swing.*;
import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println("with supplier");
        System.out.println(getDBConnectionUrl());

        System.out.println("with supplier");
        System.out.println(getDBConnectionUrlSupplier.get());

        System.out.println(getDBConnectionStringSupplier.get());
    }

    static String getDBConnectionUrl() {
        return "jdbc://localhost:5432/users"; // It's fake string
    }

    static Supplier<String> getDBConnectionUrlSupplier = () ->
            "jdbc://localhost:5432/users"; // It's fake string

    static Supplier<List<String>> getDBConnectionStringSupplier = () ->
            List.of("jdbc://localhost:5432/users",
                    "username",
                    "password");
}

package com.example.demo;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final LocalDate firstPurchaseDate;
    private final boolean onlineStore;
    private final boolean newCustomer;

    public Customer(String name, LocalDate firstPurchaseDate, boolean onlineStore, boolean newCustomer) {
        this.name = name;
        this.firstPurchaseDate = firstPurchaseDate;
        this.onlineStore = onlineStore;
        this.newCustomer = newCustomer;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFirstPurchaseDate() {
        return firstPurchaseDate;
    }

    public boolean isOnlineStore() {
        return onlineStore;
    }

    public boolean isNewCustomer() {
        return newCustomer;
    }
}

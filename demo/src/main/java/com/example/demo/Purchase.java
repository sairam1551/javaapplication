package com.example.demo;

import java.util.List;

public class Purchase {
    private Customer customer;
    private List<Item> items;

    public Purchase(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }
}

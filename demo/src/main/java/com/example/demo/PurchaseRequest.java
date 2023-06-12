package com.example.demo;

import java.util.List;

public class PurchaseRequest {

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Customer customer;
    private List<Item> items;
}

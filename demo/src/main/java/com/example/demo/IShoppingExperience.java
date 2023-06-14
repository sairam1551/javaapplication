package com.example.demo;

import java.util.List;

public interface IShoppingExperience {

    double applyDiscount(Purchase purchase);

    default double calculateTotalAmount(List<Item> items){
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

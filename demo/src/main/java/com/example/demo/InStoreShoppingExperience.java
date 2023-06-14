package com.example.demo;

public class InStoreShoppingExperience implements IShoppingExperience{
    @Override
    public double applyDiscount(Purchase purchase) {
        double totalAmount = calculateTotalAmount(purchase.getItems());
        double discountedAmount = totalAmount;
        if (totalAmount >= 100) {
            if (purchase.getItems().stream().anyMatch(item -> item.getType().equals("accessories"))) {
                discountedAmount -= (totalAmount * 0.10); // 10% discount on accessories for in-store purchases
            }
        }

        if (totalAmount >= 150) {
            discountedAmount -= 25; // $25 gift card on purchases above $150 for in-store purchases
        }

        if (purchase.getItems().stream().anyMatch(item -> item.getCategory().equals("women") || item.getCategory().equals("kids"))) {
            if (totalAmount >= 250) {
                discountedAmount -= (totalAmount * 0.10); // Additional discount for women and kids if purchase is above $250 for in-store purchases
            }
        }
        return discountedAmount;
    }
}

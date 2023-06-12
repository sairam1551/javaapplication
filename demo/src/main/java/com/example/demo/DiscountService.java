package com.example.demo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
public class DiscountService {
    public double applyDiscount(Purchase purchase) {
        double totalAmount = calculateTotalAmount(purchase.getItems());
        double discountedAmount = totalAmount;

        if (purchase.getCustomer().isOnlineStore()) {
            if (purchase.getCustomer().isNewCustomer()) {
                LocalDate currentDate = LocalDate.now();
                long daysSinceFirstPurchase = purchase.getCustomer().getFirstPurchaseDate().until(currentDate, ChronoUnit.DAYS);
                if(daysSinceFirstPurchase <= 30){
                    discountedAmount -= (totalAmount* 0.10); // Additional 10% discount for new customers within the first 30 days.
                }
            } else {
                if (totalAmount >= 150) {
                    discountedAmount -= 10; // $10 off for purchases above $150
                }
            }

            if (purchase.getItems().stream().anyMatch(item -> item.getCategory().equals("women") && item.getType().equals("accessories"))) {
                boolean hasNoDiscountBrands = purchase.getItems().stream().filter(item -> item.getCategory().equals("women") && item.getType().equals("accessories"))
                        .anyMatch(item -> item.getBrand().equalsIgnoreCase("Chanel") || item.getBrand().equalsIgnoreCase("Louis Vuitton"));

                if(!hasNoDiscountBrands){
                    discountedAmount -= (totalAmount * 0.10);
                }
                /*List<String> noDiscountBrands = List.of("Chanel", "Louis Vuitton", "CK");
                if (noDiscountBrands.stream().noneMatch(brand -> purchase.getItems().stream().anyMatch(item -> item.getType().equals(brand)))) {
                    discountedAmount -= (totalAmount * 0.10); // 10% discount on accessories
                }*/
            } else if (purchase.getItems().stream().anyMatch(item -> item.getCategory().equals("women") && item.getType().equals("clothes"))) {
                List<String> noDiscountBrands = List.of("Armani", "Balenciaga");
                if (noDiscountBrands.stream().noneMatch(brand -> purchase.getItems().stream().anyMatch(item -> item.getType().equals(brand)))) {
                    if (totalAmount >= 150) {
                        discountedAmount -= (totalAmount * 0.10); // Discount on clothes above $150 purchase
                    }
                }
            } else if (purchase.getItems().stream().anyMatch(item -> item.getCategory().equals("men") && item.getType().equals("active wear"))) {
                discountedAmount -= (totalAmount * 0.15); // 15% discount on men's active wear
            }
        } else {
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
        }

        double cashBack = discountedAmount * 0.10; // 10% cash-back voucher
        // Store the cash-back voucher for the customer

        return discountedAmount;
    }

    private double calculateTotalAmount(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}


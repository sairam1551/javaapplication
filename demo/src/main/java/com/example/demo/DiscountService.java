package com.example.demo;

public class DiscountService implements IShoppingExperience {
    IShoppingExperience iShoppingExperience;
    public double applyDiscount(Purchase purchase) {
        double totalAmount = calculateTotalAmount(purchase.getItems());

        if (purchase.getCustomer().isOnlineStore()) {
          iShoppingExperience = new OnlineShoppingExperience();

        } else {
            iShoppingExperience = new InStoreShoppingExperience();

        }
       double discountedAmount = iShoppingExperience.applyDiscount(purchase);

        double cashBack = discountedAmount * 0.10; // 10% cash-back voucher
        // Store the cash-back voucher for the customer

        return discountedAmount;
    }


}


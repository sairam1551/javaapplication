package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @PostMapping
    public double calculateDiscountedAmount(@RequestBody PurchaseRequest purchaseRequest){
        Customer customer = purchaseRequest.getCustomer();
        List<Item> items = purchaseRequest.getItems();

        DiscountService discountService = new DiscountService();

        Purchase purchase = new Purchase(customer, items);

        return discountService.applyDiscount(purchase);
    }
}

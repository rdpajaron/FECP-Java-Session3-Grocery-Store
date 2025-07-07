package org.example;

import java.util.HashMap;

public class StoreInventory {
    private String product;
    private int quantity;
    HashMap<String, Integer> productStock = new HashMap<>();
    StoreInventory(String product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public String addProduct(String product, int quantity){
        productStock.put(product, quantity);
        return "Product Added";
    }

}

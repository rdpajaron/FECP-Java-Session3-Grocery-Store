package org.example;

import java.util.HashMap;

public class StoreInventory {
    private String product;
    private int quantity;

    StoreInventory(String product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }



    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

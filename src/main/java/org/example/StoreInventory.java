package org.example;

import static org.example.GroceryInventorySystem.productStock;

public class StoreInventory {
    private String product;
    private int quantity;

    StoreInventory(String product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    StoreInventory(){

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

    public void viewInventory(){
        productStock.forEach((k, v) -> System.out.println(k + " - " + v + " pcs"));
    }

    public void addProduct(String product, int quantity){
        if(quantity < 1){
            System.out.println("Invalid Quantity!");
            return;
        }
        if(productStock.containsKey(product)){
            System.out.println("Product already exists in inventory!");
            return;
        }
        productStock.put(product, quantity);
    }

    public void updateStock(String product, int newQuantity){
        if(quantity < 1){
            System.out.println("Invalid Quantity!");
            return;
        }
        if(!productStock.containsKey(product)){
            System.out.println("Product does not exist!");
            return;
        }
        productStock.replace(product, newQuantity);
    }

    public void checkProduct(String product){
        if(!productStock.containsKey(product)){
            System.out.println("Product does not exist!");
            return;
        }
        System.out.println(product + " is in stock: " + productStock.get(product));
    }

    public void removeProduct(String product){
        productStock.remove(product);
        System.out.println("Product removed.");
    }

}

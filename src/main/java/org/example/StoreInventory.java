package org.example;

import static org.example.GroceryInventorySystem.productStock;

public class StoreInventory {

    public void viewInventory(){
        productStock.forEach((k, v) -> System.out.println(k + " - " + v + " pcs"));
    }

    public void addProduct(String product, int quantity){
        if(quantity < 1){
            System.out.println("Invalid Quantity!");
            return;
        }
        if(productStock.containsKey(product)){
            productStock.replace(product, quantity);
            return;
        }
        productStock.put(product.trim(), quantity);
        System.out.println("Product Added.");
    }



    public void updateStock(String product, int newQuantity){
        if(newQuantity < 0){
            System.out.println("Invalid Quantity!");
            return;
        }
        if(!productStock.containsKey(product)){
            System.out.println("Product not found.");
            return;
        }
        productStock.replace(product, newQuantity);
        System.out.println("Stock updated!");
    }

    public void checkProduct(String product){
        if(!productStock.containsKey(product)){
            System.out.println("Product not found");
            return;
        }
        System.out.println(product + " is in stock: " + productStock.get(product));
    }

    public void removeProduct(String product){
        if(!productStock.containsKey(product)){
            System.out.println("Product not found");
            return;
        }
        productStock.remove(product);
        System.out.println("Product removed.");
    }

}

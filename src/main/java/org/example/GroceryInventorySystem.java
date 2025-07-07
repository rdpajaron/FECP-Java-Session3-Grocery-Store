package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class GroceryInventorySystem {

    static HashMap<String, Integer> productStock = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        do{
            GroceryInventorySystem groceryInventorySystem = new GroceryInventorySystem();
            System.out.println(
                    """
                            --- Grocery Inventory Menu
                            1. View Inventory
                            2. Add Product
                            3. Check Product
                            4. Update Stock
                            5. Remove product
                            6. Exit"""
            );
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch(option){
                case 1:
                    groceryInventorySystem.viewInventory();
                    break;
                case 2://add product
                    System.out.print("Enter product name: ");
                    String product = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    groceryInventorySystem.addProduct(product, quantity);
                    break;
                case 3://check product
                    System.out.print("Enter product name to check: ");
                    product = scanner.nextLine();
                    groceryInventorySystem.checkProduct(product);
                    break;
                case 4://update stock
                    System.out.print("Enter product name to check: ");
                    product = scanner.nextLine();
                    System.out.println("Enter new stock quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    groceryInventorySystem.updateStock(product, newQuantity);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;

            }

        }while(option != 6);

    }

    public void viewInventory(){
        productStock.forEach((k, v) -> System.out.println(k + " - " + v + "pcs"));
    }

    public void addProduct(String product, int quantity){
        if(productStock.containsKey(product)){
            System.out.println("Product already exists in inventory!");
            return;
        }
        productStock.put(product, quantity);
    }

    public void updateStock(String product, int newQuantity){
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

}
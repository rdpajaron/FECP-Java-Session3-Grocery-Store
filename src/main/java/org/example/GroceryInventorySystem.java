package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class GroceryInventorySystem {

    static HashMap<String, Integer> productStock = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;
        String product;
        do{
            StoreInventory storeInventory = new StoreInventory();
            System.out.println(
                    """
                            \n--- Grocery Inventory Menu
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
                case 1://view inventory
                    storeInventory.viewInventory();
                    break;
                case 2://add product
                    System.out.print("Enter product name: ");
                    product = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    storeInventory.addProduct(product, quantity);
                    break;
                case 3://check product
                    System.out.print("Enter product name to check: ");
                    product = scanner.nextLine();
                    storeInventory.checkProduct(product);
                    break;
                case 4://update stock
                    System.out.print("Enter product name to check: ");
                    product = scanner.nextLine();
                    System.out.print("Enter new stock quantity: ");
                    int newQuantity = Integer.parseInt(scanner.nextLine());
                    storeInventory.updateStock(product, newQuantity);
                    break;
                case 5://remove product
                    System.out.print("Enter product name to remove: ");
                    product = scanner.nextLine();
                    storeInventory.removeProduct(product);
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }

        }while(option != 6);

    }

}
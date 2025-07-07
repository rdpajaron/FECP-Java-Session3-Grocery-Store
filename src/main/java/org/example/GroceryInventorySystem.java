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
                    "--- Grocery Inventory Menu\n" +
                            "1. View Inventory\n" +
                            "2. Add Product\n" +
                            "3. Check Product\n" +
                            "4. Update Stock\n" +
                            "5. Remove product\n" +
                            "6. Exit"
            );
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch(option){
                case 1:
//                    groceryInventorySystem.viewInventory();
                case 2://add product
                    System.out.print("Enter product name:");
                    String product = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    groceryInventorySystem.addProduct(product, quantity);
                case 3://update stock

                case 4:
                case 5:
                case 6:
                default:
                    System.out.println("Invalid option! Please try again.");
                    break;

            }

        }while(option != 6);

    }

    public void addProduct(String product, int quantity){
        if(productStock.containsKey(product)){
            System.out.println("Product already exists in inventory!");
        }
        productStock.put(product, quantity);
    }

}
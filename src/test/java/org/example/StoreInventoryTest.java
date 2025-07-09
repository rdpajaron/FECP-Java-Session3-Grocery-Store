package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StoreInventoryTest {

    StoreInventory storeInventory = new StoreInventory();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp(){
        storeInventory = new StoreInventory();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void clear(){
        GroceryInventorySystem.productStock.clear();
        System.setOut(originalOut);
    }

    @Test
    void viewInventory() {
        storeInventory.addProduct("Milk", 20);
        storeInventory.viewInventory();

        assertTrue(outContent.toString().contains("Milk - 20 pcs"));
    }

    @Test
    void addProductScenarios() {
        storeInventory.addProduct("Banana", 30);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Banana", 30);
        assertEquals(expected, GroceryInventorySystem.productStock);
    }

    @Test
    void addInvalidProductQuantity(){//add zero and negative quantity
        storeInventory.addProduct("Orange", -1);
        assertTrue(outContent.toString().contains("Invalid Quantity!"));
        assertTrue(GroceryInventorySystem.productStock.isEmpty());

        storeInventory.addProduct("Mango", 0);
        assertTrue(outContent.toString().contains("Invalid Quantity!"));
        assertTrue(GroceryInventorySystem.productStock.isEmpty());
    }

    @Test
    void addAlreadyExistingProduct(){
        storeInventory.addProduct("Milk", 20);
        storeInventory.addProduct("Milk", 50);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Milk", 50);
        assertEquals(expected, GroceryInventorySystem.productStock);
    }

    @Test
    void updateStock() {
        storeInventory.addProduct("Orange", 30);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("Orange", 30);
        assertEquals(expected, GroceryInventorySystem.productStock);

        storeInventory.updateStock("Orange", 15);
        expected.replace("Orange", 15);
        assertEquals(expected, GroceryInventorySystem.productStock);
    }

    @Test
    void updateStockWithInvalidQuantity(){
        storeInventory.addProduct("Orange", 30);
        storeInventory.updateStock("Orange", -1);
        assertTrue(outContent.toString().contains("Invalid Quantity!"));
        assertEquals(30, GroceryInventorySystem.productStock.get("Orange"));
    }

    @Test
    void updateStockWithNonExistingProduct(){
        storeInventory.updateStock("Cheese", 10);
        assertTrue(outContent.toString().contains("Product does not exist!"));
    }

    @Test
    void checkProductScenarios() {
        storeInventory.addProduct("Milk", 20);
        //check existing product
        storeInventory.checkProduct("Milk");
        assertTrue(outContent.toString().contains("Milk is in stock: 20"));

        //check non-existing product
        storeInventory.checkProduct("Ice Cream");
        assertTrue(outContent.toString().contains("Product not found"));
    }

    @Test
    void removeExistingProduct() {
        //remove existing product
        storeInventory.addProduct("Eggs", 30);
        assertTrue(GroceryInventorySystem.productStock.containsKey("Eggs"));
        assertEquals(30, GroceryInventorySystem.productStock.get("Eggs"));
        storeInventory.removeProduct("Eggs");
        assertFalse(GroceryInventorySystem.productStock.containsKey("Eggs"));
    }

    @Test
    void removeNonExistingProduct() {
        //remove non-existing product
        storeInventory.removeProduct("Pizza");
        assertTrue(outContent.toString().contains("Product not found"));
    }
}
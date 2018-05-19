package se.kth.iv1350.pointofsale.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import se.kth.iv1350.pointofsale.integration.Item;

class ScannedItemsTest {
	private HashMap<Item,Integer> scannedItemsNoArgs;


	@BeforeEach
	void setUp() throws Exception {
		scannedItemsNoArgs = new HashMap<>();

	}

	@AfterEach
	void tearDown() throws Exception {

	}

    @Test
    public void testAddForQuantity() {
        System.out.println("add");
		Item firstCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
		Item secondCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
        ScannedItems instance = new ScannedItems();
        instance.addToCart(firstCoconut, 1);
        instance.addToCart(secondCoconut, 1);
        instance.addToCart(firstCoconut, instance.quantityOfItem(firstCoconut) +1);
        int result = instance.quantityOfItem(firstCoconut);
        
        assertEquals(result, 2);
    }
    
    public void testAddForNullQuantity() {
        System.out.println("add");
		Item firstCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
		Item secondCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
        ScannedItems instance = new ScannedItems();
        instance.addToCart(firstCoconut, null);
        instance.addToCart(secondCoconut, null);
        instance.addToCart(firstCoconut, null);
        int result = instance.quantityOfItem(firstCoconut);
        
        assertEquals(result, null);
    }

    /**
     * Test of toString method, of class SoldItems.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
		Item firstCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
		Item secondCoconut = new Item(new ItemIdentifier(100), "Coconut", new AmountOfCash(10), "12%", "Origin: UK" );
        ScannedItems instance = new ScannedItems();
        instance.addToCart(firstCoconut,1);
        instance.addToCart(secondCoconut, 1);
        instance.addToCart(firstCoconut, instance.quantityOfItem(firstCoconut) +1);
        
        System.out.println(instance.toString());
        String expResult = "Item [Name:Coconut\n" + 
        		"Price:10.0\n" + 
        		"Taxrate:12%\n" + 
        		"Description:Origin: UK] x2\nItem [Name:Coconut\n" + 
        		"Price:10.0\n" + 
        		"Taxrate:12%\n" + 
        		"Description:Origin: UK] x1\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    @Test
    public void testToStringEqualsNull() {
        System.out.println("testToStringEqualsNull");
		Item firstCoconut = new Item(new ItemIdentifier(100), "Coconut", null, "12%", "Origin: UK" );
		Item secondCoconut = new Item(new ItemIdentifier(100), "Coconut", null, "12%", "Origin: UK" );
        ScannedItems instance = new ScannedItems();
        instance.addToCart(firstCoconut,1);
        instance.addToCart(secondCoconut, 1);
        instance.addToCart(firstCoconut, instance.quantityOfItem(firstCoconut) +1);
        
        System.out.println(instance.toString());
        String expResult = "Item [Name:Coconut\n" + 
        					  "Price:null\n" + 
        					  "Taxrate:12%\n" + 
        					  "Description:Origin: UK] x2\n"
        					+ "Item [Name:Coconut\n" + 
        					  "Price:null\n" + 
        					  "Taxrate:12%\n" + 
        					  "Description:Origin: UK] x1\n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testQuantityOfItemWithNull() {
		Item item = new Item(null, "Coconut", null, "12%", "Origin: UK" );
        ScannedItems instance = new ScannedItems();
        instance.increaseQuantityOfScannedItems(item);
        instance.increaseQuantityOfScannedItems(item);
		int expResult = 2;
		
		int result = instance.quantityOfItem(item);
		
		assertEquals(expResult, result);
    }
    
    
}

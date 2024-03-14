package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AppTest {
    private Cart cart;
    private CartItem CI, CI2;
    private Item item1, item2, item3, itemNULL;
    private Store store;
    private User user;


    @BeforeEach
    public void init() {
        cart = new Cart();
        item1 = new Item("item1", 6.99, 2);
        item2 = new Item("item2", 0.99, 2);
        item3 = new Item("item3", 0.99, 10);
        store = new Store();
        user = new User("Test", "TestAddress");
    }

    @Test
    public void isUserWorking(){
        String expectedName = "Test";
        String actualName = user.getName();
        String expectedAddress = "TestAddress";
        String actualAddress = user.getAddress();
        assertAll("user",
        () -> assertEquals(actualAddress, expectedAddress),
        () ->  assertEquals(actualName, expectedName),
        () -> assertNotNull(user.getId()),
        () -> assertNotNull(user.getName()),
        () -> assertNotNull(user.getAddress())
        );
    }

    @Test
    public void addItemToStore(){
        itemNULL = null;
        assertAll("Adding to store",
        ()-> assertDoesNotThrow(()->store.addItem(itemNULL)),
        ()-> assertDoesNotThrow(()->store.addItem(item1)),
        ()-> assertFalse(store.getItems().isEmpty())
        );
    }

    @Test
    public void testgetItemByIndexFromStore(){
        store.addItem(item1);
        store.addItem(item2);
        assertAll("IDTest", 
        () -> assertDoesNotThrow(()-> store.getItemByIndex(999)),
        () -> assertEquals(null, store.getItemByIndex(999)),
        () -> assertEquals(item2, store.getItemByIndex(1)));
    }

    @Test
    public void addToCartItem(){
        CI = new CartItem(item2, -5);
        int expectedNegative = 1;
        int actualNegative = CI.getQuantity();

        assertEquals(expectedNegative, actualNegative);

        CI2 = new CartItem(item1, 2);
        int expected = 2;
        int actual = CI2.getQuantity();

        assertEquals(expected, actual);
    }


    @Test
    public void addingItemToCart(){
        CI = new CartItem(item1, 2);
        cart.addItemToCart(CI);
        int expectedQuantity = 2;
        int actualQuantity = CI.getQuantity();
        int expectedStock = 0;
        int actualStock = item1.getStock();

        assertAll("Adding to cart normally",
        ()-> assertEquals(expectedQuantity, actualQuantity),
        ()-> assertEquals(expectedStock, actualStock),
        ()-> assertThrows(IllegalArgumentException.class, 
            ()-> CI = new CartItem(item1, 3)),
        ()-> assertFalse(cart.getContents().isEmpty())
        );
    }

    @Test
    public void addingTheSameItemMultipleTimesToCart(){
        CI = new CartItem(item2, 1);
        cart.addItemToCart(CI);
        cart.addItemToCart(CI);
        int expectedQuantityMultiple = 2;
        int actualQuantityMultiple = CI.getQuantity();
        int expectedStockMultiple = 0;
        int actualStockMultiple = item2.getStock();
        int cartArraylistSizeAfterAddingMultiple = 1;

        assertAll("Adding to cart multiple times",
        ()-> assertEquals(expectedQuantityMultiple, actualQuantityMultiple),
        ()-> assertEquals(expectedStockMultiple, actualStockMultiple),
        ()-> assertEquals(cartArraylistSizeAfterAddingMultiple ,cart.getContents().size())
        );
    }

    @Test
    public void removingFromCart(){
        CI = new CartItem(item3, 3);
        cart.addItemToCart(CI);
        cart.reduceItemByAmount(CI, 2);
        int expectedStock = 9;
        int actualStock = item3.getStock();
        int expectedQuantity = 1;
        int actualQuantity = CI.getQuantity();

        assertAll("CartRemoveTest", 
        () -> assertEquals(expectedStock, actualStock),
        () -> assertEquals(expectedQuantity, actualQuantity)
        
        );

        cart.reduceItemByAmount(CI, 2);
        assertTrue(cart.getContents().isEmpty());

    }

    @Test
    public void cartPrintOut(){
        String expected = "";
        assertAll("cartEmpty",
        () -> assertDoesNotThrow(()-> cart.toString()),
        ()-> assertEquals(expected, cart.toString())
        );

        String expectedAfterAdding = "item3, In cart: 2" + "\n";
        CI = new CartItem(item3, 2);
        cart.addItemToCart(CI);
        String actual = cart.toString();
        assertEquals(actual, expectedAfterAdding);
    }
}
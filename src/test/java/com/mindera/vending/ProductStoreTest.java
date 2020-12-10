package com.mindera.vending;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProductStoreTest extends AbstractTest {

    @Test
    public void getProducts() {
        assertEquals(4, productStore.getProducts().size());
        assertEquals("Cheap Chocolate Bar", productStore.getProducts().get(0).getDescription());
        assertEquals(50, productStore.getProducts().get(0).getPrice().intValue());
    }

    @Test
    public void getProduct() {
        assertNotNull(productStore.getById(1));
        assertNotNull(productStore.getById(2));
        assertNotNull(productStore.getById(3));
    }

    @Test(expected = RuntimeException.class)
    public void getProductDoesNotExists() {
        assertNotNull(productStore.getById(99));
    }
}
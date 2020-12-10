package com.mindera.vending;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class AbstractTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    protected final VendingMachine vendingMachine = new VendingMachine();
    protected final CoinStore coinStore = new CoinStore();
    protected final ProductStore productStore = new ProductStore();

    @Before
    public void init() {
        List<Product> productList = new ArrayList();
        productList.add(new Product(1, "Cheap Chocolate Bar", 50, 2));
        productList.add(new Product(2, "Expensive Chocolate Bar", 80, 2));
        productList.add(new Product(3, "Coke", 110, 1));
        productList.add(new Product(4, "Diet Coke", 120, 0));
        productStore.setProducts(productList);

        coinStore.add(200, 2);
        coinStore.add(100, 2);
        coinStore.add(50, 2);
        coinStore.add(20, 1);
        coinStore.add(5, 2);
        coinStore.add(1, 2);

        vendingMachine.setProductStore(productStore);
        vendingMachine.setCoinStore(coinStore);
    }
}
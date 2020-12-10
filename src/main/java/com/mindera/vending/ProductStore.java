package com.mindera.vending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages products
 */
public class ProductStore {
    private List<Product> products;
    private Map<Integer, Product> productMap = new HashMap();

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        for (Product product : products) {
            productMap.put(product.getId(), product);
        }
    }

    public Product getById(Integer Id) {
        if (productMap.get(Id) == null) {
            throw new RuntimeException("product with Id " + Id + " does not exsist in store");
        }
        return productMap.get(Id);
    }
}
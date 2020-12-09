package com.vending;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductStore {
    private List<Product> products;
    private Map<Integer, Product> productMap = new HashMap();

    public Product getById(Integer id) {
        return productMap.get(id);
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        for (Product product : products) {
            productMap.put(product.getId(), product);
        }
    }

    public Map<Integer, Product> getProductMap() {
        return this.productMap;
    }
}
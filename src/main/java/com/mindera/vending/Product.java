package com.mindera.vending;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Product that can be sold
 */
@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Integer id;
    private String description;
    private Integer price;
    private Integer stockCount;

    /**
     * Remove a product from the store
     */
    public void sell() {
        stockCount--;
    }
}

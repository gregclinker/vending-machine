package com.vending;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private Integer id;
    private String description;
    private Integer price;
    private Integer stockCount;

    public void sell() {
        stockCount--;
    }
}

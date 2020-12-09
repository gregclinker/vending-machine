package com.vending;

import lombok.Setter;

import java.util.List;

@Setter
public class VendingMachine {

    private CoinStore coinStore;
    private ProductStore productStore;

    public List<Integer> vend(Integer producId, Integer[] coins) {
        final Integer totalPence = coinStore.checkCoins(coins);
        final Product product = productStore.getProductMap().get(producId);
        if (product.getStockCount() == 0) {
            throw new SoldOutException();
        }
        if (product.getPrice() > totalPence) {
            throw new NotFullPaidException();
        }
        final List<Integer> change = coinStore.calculateChange(product.getPrice(), totalPence);
        product.sell();
        return change;
    }
}

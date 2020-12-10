package com.mindera.vending;

import com.mindera.vending.exception.NotFullPaidException;
import com.mindera.vending.exception.SoldOutException;
import lombok.Setter;

import java.util.List;

/**
 * Vending machine
 */
@Setter
public class VendingMachine {

    private CoinStore coinStore;
    private ProductStore productStore;

    /**
     * Vend a product by product Id with given coins
     * @param producId
     * @param coins
     * @return
     */
    public List<Integer> vend(Integer producId, Integer[] coins) {
        final Integer totalPence = coinStore.checkCoins(coins);
        final Product product = productStore.getById(producId);
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

package com.mindera.vending;

import com.mindera.vending.exception.InsufficientChangeException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Manages everything to do with coins
 */
public class CoinStore {

    static final List<Integer> VALID_COINS = Arrays.asList(new Integer[]{200, 100, 50, 20, 5, 1}); // valid coins in order

    private Map<Integer, Integer> coinMap; // map to keep count of coins

    public CoinStore() {
        coinMap = VALID_COINS.stream().collect(Collectors.toMap(Integer::intValue, s -> 0));
    }

    /**
     * Add a coin to the store
     * @param penceAmount
     * @param count
     */
    public void add(Integer penceAmount, Integer count) {
        coinMap.merge(penceAmount, count, Integer::sum);
    }

    /**
     * Add a single coin to the store
     * @param penceAmount
     */
    public void add(Integer penceAmount) {
        add(penceAmount, 1);
    }

    /**
     * Remove a coind from the store
     * @param penceAmount
     */
    public void remove(Integer penceAmount) {
        if (coinMap.get(penceAmount) == 0) {
            throw new InsufficientChangeException();
        }
        coinMap.put(penceAmount, coinMap.get(penceAmount) - 1);
    }

    /**
     * Check given coins are valid
     * @param coins
     * @return
     */
    public Integer checkCoins(Integer[] coins) {
        Integer totalPenceAmount = 0;
        for (int i = 0; i < coins.length; i++) {
            if (!VALID_COINS.contains(coins[i])) {
                throw new RuntimeException(coins[i] + " is an invalid coind amount");
            }
            add(coins[i]);
            totalPenceAmount += coins[i];
        }
        return totalPenceAmount;
    }

    /**
     * Calculate the most efficent change change
     * @param priceInPence
     * @param totalGivenInPence
     * @return
     */
    public List<Integer> calculateChange(Integer priceInPence, Integer totalGivenInPence) {
        List<Integer> change = new ArrayList();
        Integer amountLeft = totalGivenInPence - priceInPence;
        while (amountLeft > 0) {
            for (Integer coinAmountInPence : VALID_COINS) {
                // store is exahusted of change
                if (coinAmountInPence == 1 && coinMap.get(coinAmountInPence) == 0) {
                    throw new InsufficientChangeException();
                } else if (coinAmountInPence <= amountLeft && coinMap.get(coinAmountInPence) > 0) {
                    change.add(coinAmountInPence);
                    amountLeft -= coinAmountInPence;
                    remove(coinAmountInPence);
                }
            }
        }
        return change;
    }
}
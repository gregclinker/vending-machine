package com.vending;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoinStore {

    static final List<Integer> VALID_COINS = Arrays.asList(new Integer[]{200, 100, 50, 20, 5, 1});

    private Map<Integer, Integer> coinMap; // map to keep count of coins

    public CoinStore() {
        coinMap = VALID_COINS.stream().collect(Collectors.toMap(Integer::intValue, s -> 0));
    }

    public void add(Integer penceAmount, Integer count) {
        coinMap.merge(penceAmount, count, Integer::sum);
    }

    public void add(Integer penceAmount) {
        add(penceAmount, 1);
    }

    public void remove(Integer penceAmount) {
        if (coinMap.get(penceAmount) == 0) {
            throw new InsufficientChangeException();
        }
        coinMap.put(penceAmount, coinMap.get(penceAmount) - 1);
    }

    public Integer checkCoins(java.lang.Integer[] coins) {
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

    public List<Integer> calculateChange(Integer priceInPence, Integer totalGivenInPence) {
        List<Integer> change = new ArrayList();
        Integer amountLeft = totalGivenInPence - priceInPence;
        while (amountLeft > 0) {
            for (Integer coinAmountInPence : VALID_COINS) {
                // coind stored is exahusted of change
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
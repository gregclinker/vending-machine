package com.vending;

import org.junit.Test;

public class VendingMachineTest extends AbstractTest {

    @Test
    public void happyPath() {
        vendingMachine.vend(1, new Integer[]{50});
    }

    @Test(expected = NotFullPaidException.class)
    public void insufficentMoney() {
        vendingMachine.vend(1, new Integer[]{20});
    }

    @Test(expected = SoldOutException.class)
    public void soldOut() {
        vendingMachine.vend(1, new Integer[]{50});
        vendingMachine.vend(1, new Integer[]{50});
        vendingMachine.vend(1, new Integer[]{50});
    }

    @Test(expected = RuntimeException.class)
    public void invalidCoins() {
        vendingMachine.vend(1, new Integer[]{51});
    }

    @Test(expected = InsufficientChangeException.class)
    public void insufficientChange() {
        vendingMachine.vend(2, new Integer[]{100});
        vendingMachine.vend(2, new Integer[]{100});
    }
}
package com.mindera.vending;

import com.mindera.vending.exception.InsufficientChangeException;
import com.mindera.vending.exception.NotFullPaidException;
import com.mindera.vending.exception.SoldOutException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class VendingMachineTest extends AbstractTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void happyPath() {
        vendingMachine.vend(1, new Integer[]{50});
        assertEquals(1, productStore.getById(1).getStockCount().intValue());
        vendingMachine.vend(1, new Integer[]{50});
        assertEquals(0, productStore.getById(1).getStockCount().intValue());
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
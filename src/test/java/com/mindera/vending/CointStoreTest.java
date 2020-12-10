package com.mindera.vending;

import com.mindera.vending.exception.InsufficientChangeException;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CointStoreTest extends AbstractTest {

    @Test
    public void change1() {
        final List<Integer> change = coinStore.calculateChange(80, 100);
        assertEquals(1, change.size());
        assertEquals(20, change.get(0).intValue());

    }

    @Test
    public void change2() {
        final List<Integer> change1 = coinStore.calculateChange(80, 150);
        assertEquals(50, change1.get(0).intValue());
        assertEquals(20, change1.get(1).intValue());
    }

    @Test(expected = InsufficientChangeException.class)
    public void insufficientChange() {
        coinStore.calculateChange(80, 150);
        coinStore.calculateChange(80, 150);
    }
}
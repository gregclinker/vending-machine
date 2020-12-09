package com.vending;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class CointStoreTest extends AbstractTest {

    @Test
    public void change() {
        final List<Integer> change = coinStore.calculateChange(80, 100);
        assertEquals(1, change.size());
        assertEquals(20, change.get(0).intValue());

        init();
        final List<Integer> change1 = coinStore.calculateChange(80, 150);
        assertEquals(50, change1.get(0).intValue());
        assertEquals(20, change1.get(1).intValue());
    }

    @Test
    public void test1() {
        final List<Integer> list = Arrays.asList(new Integer[]{200, 100, 50, 20, 5, 1});
        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(Integer::intValue, s -> 0));

        collect.keySet().stream().forEach(System.out::println);
    }
}
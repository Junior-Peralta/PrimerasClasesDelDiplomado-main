package edu.juniorperalta.diplomado.week3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author aluis on 5/8/2022.
 */
class Exercise1Week3Test {

    private final Exercise1Week3 exercise1Week3 = new Exercise1Week3();

    @Test
    void noValueTest() {
        assertThrows(NullPointerException.class, () -> exercise1Week3.fizzbuzz1(null));
    }

    @Test
    void divisibleBy3Case1Test() { assertEquals(Exercise1Week3.BUZZ, exercise1Week3.fizzbuzz1(3));}

    @Test
    void divisibleBy5Case1Test() { assertEquals(Exercise1Week3.FIZZ, exercise1Week3.fizzbuzz1(5));}

    @Test
    void divisibleBy5And3Case1Test() { assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz1(15));}

    @Test
    void noDivisorTest() {
        assertEquals("4", exercise1Week3.fizzbuzz1(4));
    }

    @Test
    void useZeroTest(){
        assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz1(0));
    }

    @Test
    void negativeNumbers(){
        assertEquals(Exercise1Week3.FIZZBUZZ, exercise1Week3.fizzbuzz1(-15));
    }

    @Test
    void negativeNoDividerTest(){
        assertEquals("-4", exercise1Week3.fizzbuzz1(-4));
    }


}
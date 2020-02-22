package io.groud.leetcode.data_structures.recursive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Li.Wei by 2020/2/21
 */
class TopDownRecursiveTest {
    TopDownRecursive o = new TopDownRecursive();

    private static final int SUM = 55;
    private static final int SUM_INIT = 0;
    private static final int N = 10;

    @Test
    void sum() {
        assertEquals(SUM, o.sum(N));
    }

    @Test
    void sum2() {
        assertEquals(SUM, o.sum2(N, SUM_INIT));
    }

    @Test
    void sum2ToFor() {
        assertEquals(SUM, o.sum2ToFor(N, SUM_INIT));
    }

    @Test
    void sum1ToFor() {
        assertEquals(SUM, o.sum1ToFor(N));
    }
}
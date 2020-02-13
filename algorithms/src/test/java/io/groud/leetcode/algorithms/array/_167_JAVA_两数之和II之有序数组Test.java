package io.groud.leetcode.algorithms.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author Li.Wei by 2020/2/8
 */
class _167_JAVA_两数之和II之有序数组Test {
    private final _167_JAVA_两数之和II之有序数组 o = new _167_JAVA_两数之和II之有序数组();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{1, 2}, o.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, o.twoSum(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, o.twoSum(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 2}, o.twoSum(new int[]{0, 0, 3, 4}, 0));
    }

    @Test
    void twoSum1() {
        assertArrayEquals(new int[]{1, 2}, o.twoSum1(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, o.twoSum1(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, o.twoSum1(new int[]{-1, 0}, -1));
        assertArrayEquals(new int[]{1, 2}, o.twoSum1(new int[]{0, 0, 3, 4}, 0));
    }
}
package io.groud.leetcode.algo.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author Li.Wei by 2019/11/27
 */
class TwoSumTest {

    private final _1_JAVA_两数之和 a1JAVA两数之和 = new _1_JAVA_两数之和();

    private static final int[] ARRAY_NUMS_1 = {2, 7, 11, 15};
    private static final int TARGET_1 = 9;
    private static final int[] ASSERT_1 = new int[] {0, 1};

    private static final int[] ARRAY_NUMS_2 = {4, 5, 11, 15};
    private static final int TARGET_2 = 19;
    private static final int[] ASSERT_2 = new int[] {0, 3};

    @Test
    void twoSum() {
        assertArrayEquals(a1JAVA两数之和.twoSum(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(a1JAVA两数之和.twoSum(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }

    @Test
    void twoSum1() {
        assertArrayEquals(a1JAVA两数之和.twoSum1(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(a1JAVA两数之和.twoSum1(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }

    @Test
    void twoSum2() {
        assertArrayEquals(a1JAVA两数之和.twoSum2(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(a1JAVA两数之和.twoSum2(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }
}

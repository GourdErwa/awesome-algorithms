package io.groud.leetcode.algorithms.array;

import io.groud.leetcode.algorithms.array.TwoSum;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Li.Wei by 2019/11/27
 */
class TwoSumTest {

    private final TwoSum twoSum = new TwoSum();

    private static final int[] ARRAY_NUMS_1 = {2, 7, 11, 15};
    private static final int TARGET_1 = 9;
    private static final int[] ASSERT_1 = new int[]{0, 1};

    private static final int[] ARRAY_NUMS_2 = {4, 5, 11, 15};
    private static final int TARGET_2 = 19;
    private static final int[] ASSERT_2 = new int[]{0, 3};

    @Test
    void twoSum() {
        assertArrayEquals(twoSum.twoSum(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(twoSum.twoSum(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }

    @Test
    void twoSum1() {
        assertArrayEquals(twoSum.twoSum1(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(twoSum.twoSum1(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }

    @Test
    void twoSum2() {
        assertArrayEquals(twoSum.twoSum2(ARRAY_NUMS_1, TARGET_1), ASSERT_1);
        assertArrayEquals(twoSum.twoSum2(ARRAY_NUMS_2, TARGET_2), ASSERT_2);
    }
}
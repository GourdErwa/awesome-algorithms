package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others/
 * 747. 至少是其他数字两倍的最大数
 *
 * @author Li.Wei by 2020/2/6
 */
public class _747_JAVA_至少是其他数字两倍的最大数 {

    /**
     * 2 次循环比较，有一个条件不满足时跳出内层循环
     */
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        loop1:
        for (int i = 0; i < length; i++) {
            int tmp = nums[i] >> 1;
            for (int i1 = 0; i1 < length; i1++) {
                if (i1 != i && tmp < nums[i1]) {
                    continue loop1;// 不满足时跳出内层循环
                }
            }
            // 内层循环结束后表示满足，此时直接返回下标
            return i;
        }
        return -1;
    }

    /**
     * 循环一次记录临时变量第一大、第二大以及第一大数的数组下标
     * 最终比较第一大、第二大结果
     */
    public int dominantIndex1(int[] nums) {
        int max1 = 0; // 临时变量第一大数
        int max2 = 0; // 临时变量第二大数
        int max1Index = 0; // 临时变量第一大数对应数组下标

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (num > max1) { // 交换变量
                max2 = max1;
                max1 = num;
                max1Index = i;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max1 >> 1 >= max2) ? max1Index : -1;
    }

    public static void main(String[] args) {
        _747_JAVA_至少是其他数字两倍的最大数 java = new _747_JAVA_至少是其他数字两倍的最大数();
//        System.out.println(java.dominantIndex(new int[]{3, 6, 3, 22, 5, 6}));
//        System.out.println(java.dominantIndex(new int[]{1, 7, 3, 6, 5, 6}));
//        System.out.println(java.dominantIndex(new int[]{0, 0, 2, 3}));
        System.out.println(java.dominantIndex(new int[]{0, 0, 0, 1}));
    }
}

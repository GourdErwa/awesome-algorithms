package io.groud.leetcode.algo.array;

/**
 * @author Li.Wei by 2020/2/8
 */
public class _167_JAVA_两数之和II之有序数组 {

    /*
    缩小求和判断范围，第一个和与第二和的范围。
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0; // 查找数组中小于等于 target 的下标，称为第一个和所在范围
        int y = i; // 查找数组中小于等于 target/2 的下标，称为第二个和所在范围
        int tmp = numbers[i];

        // 使用小于等于判断，因为处理类似： -1 + 0 = -1
        while (tmp <= target && i < numbers.length - 1) {
            tmp = numbers[i];
            i++;
            if (tmp <= target >> 1) {
                y = i;
            }
        }
        for (int j = 0; j <= y; j++) { // 第一个和所在范围遍历
            int sum = numbers[j];
            for (int k = y - 1; k <= i; k++) { // 第二个和所在范围遍历
                if (sum + numbers[k] == target) {
                    return new int[]{++j, ++k};
                }
            }
        }
        return new int[0];
    }

    /*
    双指针，左右开始向中间遍历
     */
    public int[] twoSum1(int[] numbers, int target) {
        int min = 0;
        int max = numbers.length - 1;
        while (min < max) {
            int sum = numbers[min] + numbers[max];
            if (sum == target) {
                return new int[]{++min, ++max};
            } else if (sum > target) {
                max--;
            } else {
                min++;
            }
        }
        return new int[0];
    }
}

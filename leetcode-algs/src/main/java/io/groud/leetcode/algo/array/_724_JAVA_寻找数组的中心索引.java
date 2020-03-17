package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/ 724. 寻找数组的中心索引
 *
 * @author Li.Wei by 2020/2/6
 */
public class _724_JAVA_寻找数组的中心索引 {

    public int pivotIndex1(int[] nums) {
        int length = nums.length;
        if (length < 2) { // 长度为 0，1 判断直接返回 -1
            return -1;
        }
        int front = 0; // 前部分和
        int sum = 0; // 总

        for (int i : nums) {
            sum += i;
        }

        for (int i = 0; i < length; i++) {
            if (front == (sum - front - nums[i])) { // 相等判断
                return i;
            }
            front += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        _724_JAVA_寻找数组的中心索引 java = new _724_JAVA_寻找数组的中心索引();

        System.out.println(java.pivotIndex1(new int[] {1, 7, 3, 6, 5, 6}));
        System.out.println(java.pivotIndex1(new int[] {-1, -1, -1, 0, 1, 1}));
        System.out.println(java.pivotIndex1(new int[] {1, 0}));
    }
}

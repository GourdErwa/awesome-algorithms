package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/remove-element/
 *
 * @author Li.Wei by 2020/2/8
 */
public class _27_JAVA_移除元素 {
    public int removeElement(int[] nums, int val) {
        int i = 0; // 快指针
        int k = 0; // 慢指针
        while (i < nums.length) {
            int num = nums[i];
            if (num != val) { // 不相等时进行原地修改
                nums[k++] = num;
            }
            i++;
        }
        return k;
    }

    /*
    如果删除元素很少效率会高
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int k = nums.length - 1;
        while (i <= k) {
            if (nums[i] == val) { // 不相等时将值交换到末尾
                nums[i] = nums[k--];
            } else {
                i++;
            }
        }
        return k + 1;
    }

}

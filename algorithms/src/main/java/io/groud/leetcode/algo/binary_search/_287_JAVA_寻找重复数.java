package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 * <p>
 * tag：快慢指针、循环链表、二分查找、哈希表
 *
 * @author Li.Wei by 2020/3/12
 */
public class _287_JAVA_寻找重复数 {
    /**
     * 双指针-循环链表入门点问题
     * 思路：
     * 慢指针走一步、快指针走二步。直到快慢指针相遇。
     * 然后慢指针归 0 后继续走，快指针继续走，下一次相遇的点即为循环入门点。证明可画图推导
     */
    static class Solution {
        public int findDuplicate(int[] nums) {
            int slow = 0;
            int fast = 0;
            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            // 到此，快慢指针相遇在环形圈里面的某一点

            int i = 0;
            while (i != fast) {
                i = nums[i];
                fast = nums[fast];
            }
            return i;
        }
    }

    /**
     * 二分查找，抽屉原理
     * <p>
     * 思路：
     * n + 1 长度的数组放了 1-n 以内的数字
     * >假设长度为 11，数字都是 [1-10] 范围内的。[2,3,4,4,4,4,4,9,8,7,4]
     * 如果我们把长度二分后， 中间值下标 11/2 = 5 ，数组[5] = 4
     * 左边小于 4 的有 2 个
     */
    public static class Solution1 {

        public int findDuplicate(int[] nums) {
            int len = nums.length;
            int left = 1;
            int right = len - 1;
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                int cnt = 0;
                for (int num : nums) {
                    if (num < mid) cnt += 1;
                }
                // 根据抽屉原理，小于等于 4 的数的个数如果大于等于 4 个，
                // 此时重复元素一定出现在 [1, 3] 区间里
                if (cnt >= mid) {
                    // 重复的元素一定出现在 [left, mid - 1] 区间里
                    right = mid - 1;
                } else {
                    // if 分析正确了以后，else 搜索的区间就是 if 的反面
                    // [mid, right]
                    // 注意：此时需要调整中位数的取法为上取整
                    left = mid;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution1 o = new Solution1();
        System.out.println(o.findDuplicate(new int[]{1, 3, 4, 4, 4}));
    }
}

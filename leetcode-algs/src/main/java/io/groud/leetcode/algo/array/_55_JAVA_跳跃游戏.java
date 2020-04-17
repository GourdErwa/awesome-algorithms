package io.groud.leetcode.algo.array;

/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 *
 * 题目理解误区：
 * 只要能跳到最后一个位置即可。不是必须恰好能跳到最后一个位置。
 * 每一个位置由前面的位置的跳跃决定，我能跳 5 ，那么 5 之内的长度可以随便跳。
 *
 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
 * 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
 * 如果可以一直跳到最后，就成功了。
 *
 * @author Li.Wei by 2020/4/17
 */
public class _55_JAVA_跳跃游戏 {
    private static class Solution {
        public boolean canJump(int[] nums) {
            int length = nums.length;
            int max = 0; // 可以跳的最远距离
            for (int i = 0; i < length; i++) {
                if (i <= max) {
                    max = Math.max(nums[i] + i, max); // 更新当前格子可以跳的最远距离
                    if (max >= length - 1) { // 优化，提交结束跳跃
                        return true;
                    }
                }
            }
            return max >= length - 1;
        }
    }

    // 贪心算法 https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
    public class Solution1 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            int rightmost = 0;
            for (int i = 0; i < n; ++i) {
                if (i <= rightmost) {
                    rightmost = Math.max(rightmost, i + nums[i]);
                    if (rightmost >= n - 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[] {2, 3, 1, 1, 4}));
        System.out.println(!solution.canJump(new int[] {3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[] {1}));
    }
}

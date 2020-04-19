package io.groud.leetcode.algo.competition.spring;

/**
 * @author Li.Wei by 2020/4/18
 */
public class _2020_Spring_2 {

    // 回溯、bfs
    private static class Solution {
        public int numWays(int n, int[][] relation, int k) {

            int r = n - 1;// 传递目标

            // 超过 k 传递失败

            // 建立传递关系
            for (int[] ints : relation) {
                if (ints[0] == 0) { // bfs 起点
                    int next = ints[1]; // 下一个传递
                }
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.numWays(new int[] {4, 2, 1}));
        // System.out.println(solution.numWays(new int[] {2, 3, 10}));
    }
}

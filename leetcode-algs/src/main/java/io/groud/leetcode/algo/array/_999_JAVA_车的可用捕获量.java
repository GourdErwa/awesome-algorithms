package io.groud.leetcode.algo.array;

/**
 *
 * 有一个白色车 R
 * 也可能有空方块 .
 * 白色的象 B
 * 黑色的卒 p
 *
 * 大写字符表示白棋，小写字符表示黑棋。
 *
 * @author Li.Wei by 2020/3/26
 */
public class _999_JAVA_车的可用捕获量 {

    // 此解法仅模拟了一个车的场景
    class Solution {
        public int numRookCaptures(char[][] board) {
            if (board == null || board.length == 0) {
                return 0;
            }
            int rows = board.length;
            int cols = board[0].length;

            int ans = 0;
            for (int i = 0; i < rows; i++) {
                for (int y = 0; y < cols; y++) {
                    if (board[i][y] == 'R') {
                        for (int j = i - 1; j >= 0; j--) { // 左
                            if (board[j][y] == 'B') {
                                break;
                            }
                            if (board[j][y] == 'p') {
                                ans++;
                                break;
                            }
                        }
                        for (int j = i + 1; j < rows; j++) { // 右
                            if (board[j][y] == 'B') {
                                break;
                            }
                            if (board[j][y] == 'p') {
                                ans++;
                                break;
                            }
                        }
                        for (int j = y - 1; j >= 0; j--) { // 上
                            if (board[i][j] == 'B') {
                                break;
                            }
                            if (board[i][j] == 'p') {
                                ans++;
                                break;
                            }
                        }
                        for (int j = y + 1; j < cols; j++) { // 下
                            if (board[i][j] == 'B') {
                                break;
                            }
                            if (board[i][j] == 'p') {
                                ans++;
                                break;
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}

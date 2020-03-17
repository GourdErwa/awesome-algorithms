package io.groud.leetcode.algo.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/valid-sudoku/
 *
 * @author Li.Wei by 2020/3/7
 */
public class _36_JAVA_有效的数独 {

    // 实现比较复杂
    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            Set<Character> dup = new HashSet<>();
            Map<Integer, Set<Character>> rowDup = new HashMap<>();
            Map<Integer, Set<Character>> cloDup = new HashMap<>();
            int cRowStart;
            int cColStart;
            for (int i = 0; i < 9; i++) {

                cRowStart = i / 3 * 3; // 切换横坐标
                cColStart = (i % 3) * 3; // 切换纵坐标
                dup.clear();

                for (int r = cRowStart + 2; r >= cRowStart; r--) {
                    for (int c = cColStart + 2; c >= cColStart; c--) {
                        char c1 = board[r][c];
                        if (c1 == '.')
                            continue;

                        if (!dup.add(c1)) {
                            System.out.println("dup" + dup);
                            return false;
                        }

                        Set<Character> rowValues = rowDup.computeIfAbsent(r, integer -> new HashSet<>());
                        if (!rowValues.add(c1)) {
                            System.out.println("rowValues" + rowValues);
                            return false;
                        }

                        Set<Character> cloValues = cloDup.computeIfAbsent(c, integer -> new HashSet<>());
                        if (!cloValues.add(c1)) {
                            System.out.println("cloValues" + cloValues);
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    // TODO 位运算 待研究
    class Solution1 {
        public boolean isValidSudoku(char[][] board) {
            short[] row = new short[9], col = new short[9], cube = new short[9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    char c = board[i][j];
                    if (c == '.')
                        continue;

                    int num = c - '1';

                    // row 秘书行动
                    if (((row[i] >> num) & 1) == 1)
                        return false;
                    else
                        row[i] |= 1 << num;

                    // col 秘书
                    if (((col[j] >> num) & 1) == 1)
                        return false;
                    else
                        col[j] |= 1 << num;

                    // cube 秘书
                    int bi = (i / 3) * 3 + (j / 3);
                    if (((cube[bi] >> num) & 1) == 1)
                        return false;
                    else
                        cube[bi] |= 1 << num;
                }
            }
            return true;
        }
    }

    // 使用 boolean 数组记忆
    class Solution2 {
        public boolean isValidSudoku(char[][] board) {
            // 记录某行，某位数字是否已经被摆放
            boolean[][] row = new boolean[9][9];
            // 记录某列，某位数字是否已经被摆放
            boolean[][] col = new boolean[9][9];
            // 记录某 3x3 宫格内，某位数字是否已经被摆放
            boolean[][] block = new boolean[9][9];

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.')
                        continue;

                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3; // 确定数独区域

                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
            return true;
        }
    }
    /*
    [
    [".",".","4",  ".",".",".",  "6","3","."],
    [".",".",".",  ".",".",".",  ".",".","."],
    ["5",".",".",  ".",".",".",  ".","9","."],
    
    [".",".",".",  "5","6",".",  ".",".","."],
    ["4",".","3",  ".",".",".",  ".",".","1"],
    [".",".",".",  "7",".",".",  ".",".","."],
    
    [".",".",".",  "5",".",".",  ".",".","."],
    [".",".",".",  ".",".",".",  ".",".","."],
    [".",".",".",  ".",".",".",  ".",".","."]
    ]
     */

    /*
    [
    ["7",".",".",  ".","4",".",  ".",".","."],
    [".",".",".",  "8","6","5",  ".",".","."],
    [".","1",".",  "2",".",".",  ".",".","."],
    
    [".",".",".",  ".",".","9",  ".",".","."],
    [".",".",".",  ".","5",".",  "5",".","."],
    [".",".",".",  ".",".",".",  ".",".","."],
    
    [".",".",".",  ".",".",".",  "2",".","."],
    [".",".",".",  ".",".",".",  ".",".","."],
    [".",".",".",  ".",".",".",  ".",".","."]
    ]
     */
    public static void main(String[] args) {
        Solution s = new Solution();

        char[][] chars = {{'7', '.', '.', '.', '4', '.', '.', '.', '.'}, {'.', '.', '.', '8', '6', '5', '.', '.', '.'},
            {'.', '1', '.', '2', '.', '.', '.', '.', '.'},

            {'.', '.', '.', '.', '.', '9', '.', '.', '.'}, {'.', '.', '.', '.', '5', '.', '5', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

            {'.', '.', '.', '.', '.', '.', '2', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(s.isValidSudoku(chars));
    }
}

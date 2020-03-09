package io.groud.leetcode.algo.binary_search_tree;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 *
 * @author Li.Wei by 2020/2/20
 */
public class _95_JAVA_不同的二叉搜索树II {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<>();
        if (start > end) { //此时没有数字，将null加入到结果中
            allTrees.add(null);
            return allTrees;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // 得到所有可能的左子树
            List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);

            // 得到所有可能的右子树
            List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);

            // 合并左右子树(两两组合)
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    allTrees.add(node);
                }
            }
        }
        return allTrees;
    }

    public List<TreeNode> generateTrees(int n) {
        return n == 0 ? new LinkedList<>() : generateTreesHelper(1, n);
    }

}

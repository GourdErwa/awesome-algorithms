package io.groud.leetcode.algo.binary_search;

/**
 * @author Li.Wei by 2020/3/11
 */
public class _270_JAVA_最接近的二叉搜索树值 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 思路：复杂化
    class Solution {
        public int closestValue(TreeNode root, double target) {
            int ans = Integer.MAX_VALUE;
            while (root != null) {
                System.out.println(root.val);
                double diffNode = root.val - target;
                if (diffNode > 0D && root.left != null) { // 左子树
                    if (root.val > target && root.left.val < target)
                        ans = Math.min(diffNode > (target - root.left.val) ? root.val : root.left.val, ans);

                    root = root.left;
                } else if (diffNode < 0D && root.right != null) { // 右子树
                    if (root.val < target && root.right.val > target)
                        ans = Math.min(-diffNode > (root.right.val - target) ? root.val : root.right.val, ans);

                    root = root.right;
                } else
                    break;
            }
            return ans;
        }
    }

    class Solution1 {
        public int closestValue(TreeNode root, double target) {
            int val;
            int closest = root.val; // 最终返回记录
            while (root != null) {
                val = root.val;
                // 当前节点与已记录的最小差值节点比较
                closest = Math.abs(val - target) < Math.abs(closest - target) ? val : closest;
                // 利用查找树性质进行迭代
                root = target < val ? root.left : root.right;
            }
            return closest;
        }
    }
}

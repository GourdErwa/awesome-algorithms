package io.groud.leetcode.algo.binary_tree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/
 * <p>
 * tag：
 *
 * @author Li.Wei by 2020/2/20
 */
public class _297_JAVA_二叉树的序列化与反序列化 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /*
        1
       / \
      2   3
         / \
        4   5
     序列化为 "[1,2,3,null,null,4,5]"
    
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        return serializeHelp(root, new StringBuilder()).toString();
    }

    // 序列化递归辅助类
    public StringBuilder serializeHelp(TreeNode root, StringBuilder sb) {
        if (root == null) { // 当前节点为空时
            sb.append("null,");
            return sb;
        }
        sb.append(root.val).append(",");
        // if (root.left == null && root.right == null) return sb; // 叶子节点判断
        sb = serializeHelp(root.left, sb);
        sb = serializeHelp(root.right, sb);
        return sb;
    }

    // 反序列化
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        Deque<String> strings = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelp(strings);
    }

    // 反序列化递归辅助类
    public TreeNode deserializeHelp(Deque<String> data) {
        final String curr = data.pollFirst();
        if ("null".equals(curr))
            return null; // 当前节点为 null

        final TreeNode node = new TreeNode(Integer.valueOf(curr));
        node.left = deserializeHelp(data);
        node.right = deserializeHelp(data);
        return node;
    }

    /*
     *   [3]
     * [9, 20]
     *   [15, 7]
     *          16
     */
    public static void main(String[] args) {
        TreeNode treeNode16 = new TreeNode(16);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7, null, treeNode16);
        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);

        _297_JAVA_二叉树的序列化与反序列化 java = new _297_JAVA_二叉树的序列化与反序列化();

        String serialize = java.serialize(treeNode3);
        System.out.println(serialize);
        TreeNode treeNode = java.deserialize(serialize);
        System.out.println(treeNode);
    }
}

package com.yuankai.day;

public class Day26 {

    public void flatten(TreeNode root) {
        flatten(root);
    }
    public TreeNode faltten(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        node.left = null;
        node.right = left;
        TreeNode maxLeft = faltten(left);
        TreeNode maxRight = faltten(right);
        if (left == null || maxLeft == null || maxRight == null) {
            return node;
        }
        maxLeft.right = right;
        return maxRight;
    }
}

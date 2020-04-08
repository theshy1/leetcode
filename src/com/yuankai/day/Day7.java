package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-08
 *
 * 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class Day7 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode node = new TreeNode(0);
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        node.val = t1.val + t2.val;
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

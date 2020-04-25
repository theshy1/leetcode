package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-26
 */
public class Day15 {

    /**
     * 二叉树展开为链表
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     */
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    public TreeNode flatten(TreeNode node, TreeNode pre) {
        if (node == null) {
            return pre;
        }
        if (pre != null) {
            pre.right = node;
            pre.left = null;
        }
        return flatten(node.right, flatten(node.left, node));
    }
}

package com.yuankai.day;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuankai
 * @since 2020-04-19
 */
public class Day14 {

    /**
     * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/submissions/
     * 不同的二叉搜索树 II
     */
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> all_trees = new LinkedList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> left_trees = generateTrees(start, i - 1);
            List<TreeNode> right_trees = generateTrees(i + 1, end);
            for(TreeNode left: left_trees) {
                for(TreeNode right: right_trees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    all_trees.add(node);
                }
            }
        }
        return all_trees;
    }
}

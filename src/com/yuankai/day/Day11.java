package com.yuankai.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuankai
 * @since 2020-04-12
 */
public class Day11 {

    /**
     * 二叉搜索树的范围和
     * https://leetcode-cn.com/problems/range-sum-of-bst/submissions/
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (root.val >= L && root.val <= R) {
            res += root.val;
        }
        res += rangeSumBST(root.left, L, R);
        res += rangeSumBST(root.right, L, R);
        return res;
    }

    /**
     * 二叉搜索树中的搜索
     * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        return null;
    }

    /**
     * N叉树的后序遍历
     * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
     */
    public List<Integer> postorder(Node root) {
        if(root == null) {
            return new ArrayList();
        }
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Node> stock = new LinkedList<>();
        stock.add(root);
        while (!stock.isEmpty()) {
            Node node = stock.pollLast();
            node.children.forEach(child -> {
                stock.add(child);
            });
            res.addFirst(node.val);
        }
        return res;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

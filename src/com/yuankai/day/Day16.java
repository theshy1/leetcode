package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-27
 */
public class Day16 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, preorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int n, int start, int end) {
        if(start > end || n >= preorder.length) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[n]);
        int i = 0;
        for(;i<inorder.length;i++) {
            if(node.val == inorder[i]) {
                break;
            }
        }
        node.left = buildTree(preorder, inorder,n+1, start, i-1);
        node.right = buildTree(preorder, inorder,n+i-start+1, i+1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        Day16 day16 = new Day16();
        TreeNode treeNode = day16.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}

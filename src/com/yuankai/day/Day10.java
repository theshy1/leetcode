package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-11
 *
 * 最小高度树
 * https://leetcode-cn.com/problems/minimum-height-tree-lcci/submissions/
 */
public class Day10 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int min = (start + end + 1) / 2;
        TreeNode node = new TreeNode(nums[min]);
        node.left = sortedArrayToBST(nums, start, min-1);
        node.right = sortedArrayToBST(nums, min+1, end);
        return node;
    }
}

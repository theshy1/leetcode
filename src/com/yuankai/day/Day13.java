package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-14
 */
public class Day13 {

    /**
     * https://leetcode-cn.com/problems/path-sum-iii/
     * 路径总和
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSum2(root, sum)
                + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        } else if (root.val == sum) {
            return 1 + pathSum2(root.left, 0) + pathSum2(root.right, 0);
        } else {
            return pathSum2(root.left, sum - root.val) + pathSum2(root.right, sum - root.val);
        }
    }
    
}

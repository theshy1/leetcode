package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-05-03
 */
public class Day17 {

    /**
     * https://leetcode-cn.com/problems/house-robber-iii/submissions/
     * 打家劫舍
     */
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }
    public int[] dp(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);
        // 抢，下家就不能抢了
        int rob = root.val + left[1] + right[1];
        // 不抢，下家可以抢也可以不抢，看收益
        int no_rob= Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{rob, no_rob};
    }
}

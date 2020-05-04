package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-05-04
 */
public class Day18 {

    /**
     * 移动0
     * https://leetcode-cn.com/problems/move-zeroes/submissions/
     */
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        for(;i<nums.length;i++) {
            if (nums[i] != 0) {
                int k = nums[i];
                nums[i] = nums[j];
                nums[j] = k;
                j++;
            }
        }
    }
}

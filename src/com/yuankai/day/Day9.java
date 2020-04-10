package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-10
 *
 * 只出现一次的数字
 * https://leetcode-cn.com/problems/single-number/
 */
public class Day9 {

    /**
     * 因为n ^ 0 = n, n ^ n = 0，所有只需将所有数字做异或运算即可
     */
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for(int i = 1; i< nums.length; i++){
            n = n ^ nums[i];
        }
        return n;
    }
}

package com.yuankai.day;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 反转字符串里的单词
     * https://leetcode-cn.com/problems/reverse-words-in-a-string/
     */
    public String reverseWords(String s) {
        String[] ss = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].equals(" ") || ss[i].equals("")) {
                continue;
            }
            sb.append(ss[i]);
            if (i == 0) {
                return sb.toString();
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}

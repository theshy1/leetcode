package com.yuankai.day;

/**
 * @author yuankai
 * @since 2020-04-04
 */
public class Day5 {

    /**
     * 左旋转字符
     * https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
     */
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = n; i < chars.length + n; i++) {
            int a = i;
            if (a >= chars.length) {
                a = i - chars.length;
            }
            sb.append(chars[a]);
        }
        return sb.toString();
    }
}

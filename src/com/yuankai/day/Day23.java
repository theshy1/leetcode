package com.yuankai.day;

import java.util.Arrays;

public class Day23 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int len = Integer.MAX_VALUE;
        for (String str: strs) {
            len = Math.min(len, str.length());
        }
        for (int i = 0; i <= len; i++) {
            char c = strs[0].charAt(i);
            for (String str: strs) {
                if (i == str.length()) {
                    return str.substring(0, i-1);
                } else if (str.charAt(i) != c) {
                    return str.substring(0, i);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        //new Day23().longestCommonPrefix(new String[]{"flower","flow","flight"});
        new Day23().longestCommonPrefix(new String[]{"c", "c"});
    }
}

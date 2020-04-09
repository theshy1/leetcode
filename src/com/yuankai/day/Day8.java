package com.yuankai.day;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yuankai
 * @since 2020-04-09
 *
 * 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Day8 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtrack(res, new StringBuilder(), 0 ,0 , n);
        return res;
    }

    public void backtrack(List<String> res, StringBuilder cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            res.add(cur.toString());
            return;
        }
        if (left < max) {
            cur.append("(");
            backtrack(res, cur, left + 1, right, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (right < left) {
            cur.append(")");
            backtrack(res, cur, left, right + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

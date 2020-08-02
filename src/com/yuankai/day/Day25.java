package com.yuankai.day;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Day25 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> idx = new LinkedList<>();
        for (int num : nums) {
            idx.add(num);
        }
        backTrace(idx, new LinkedList<>(), ans);
        return ans;
    }

    public void backTrace(LinkedList<Integer> idx, List<Integer> cur, List<List<Integer>> ans) {
        if (idx.size() == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < idx.size(); i++) {
            int num = idx.pop();
            cur.add(num);
            backTrace(idx, cur, ans);
            cur.remove(Integer.valueOf(num));
            idx.add(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = new Day25().permute(nums);
        System.out.println(permute);
    }
}

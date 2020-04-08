package com.yuankai.day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yuankai
 * @since 2020-04-08
 *
 * 子集
 * https://leetcode-cn.com/problems/subsets/
 */
public class Day7_1 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.stream(nums).forEach(num -> {
            List<List<Integer>> tmp = new ArrayList<>();
            list.forEach(subList -> {
                List<Integer> integers = new ArrayList<>(subList);
                integers.add(num);
                tmp.add(integers);
            });
            list.addAll(tmp);
            List<Integer> subList = new ArrayList<>();
            subList.add(num);
            list.add(subList);
        });
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Day7_1().subsets(new int[]{1,3,4,5}));
    }
}

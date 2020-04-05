package com.yuankai.day;

import java.util.Arrays;

public class Day5_1 {

    /**
     * 912.排序数组
     * https://leetcode-cn.com/problems/sort-an-array/
     */
    public int[] sortArray(int[] nums) {
       return merge(nums, 0 , nums.length - 1);
    }

    // 归并排序
    public int[] merge(int[] nums, int n, int m) {
        if (n >= m) {
            return new int[]{nums[n]};
        }
        int p = (n + m) / 2;
        int[] a = merge(nums, n, p);
        int[] b = merge(nums, p + 1, m);
        int i = 0, j = 0;
        int[] tmp = new int[m - n + 1];
        while(i < a.length && j < b.length) {
            tmp[i + j] = a[i] > b[j] ? b[j++] : a[i++];
        }
        if (i < a.length) {
            System.arraycopy(a, i, tmp, i + j, a.length - i);
        }
        if (j < b.length) {
            System.arraycopy(b, j, tmp, i + j, b.length - j);
        }
        return tmp;
    }

    // 快速排序
    public void partition(int[] nums, int n, int m) {
        if (n >= m) {
            return ;
        }
        int p = nums[m], i = n, j = i;
        while(j < m) {
            if (nums[j] < p) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, i, m);
        partition(nums, n, i - 1);
        partition(nums, i + 1, m);
    }

    public void swap(int[] nums, int n, int m) {
        int temp = nums[n];
        nums[n] = nums[m];
        nums[m] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,2,6,898,3,66,42,7,43,1134,556};
        //System.out.println(Arrays.toString(new Day5_1().sortArray(nums)));
        new Day5_1().partition(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
}

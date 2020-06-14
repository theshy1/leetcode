package com.yuankai.day;

import java.util.Arrays;

public class Day22 {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = (target - sum) / (arr.length - i);
            if (x < arr[i]) {
                double t = (double) (target - sum) / (arr.length - i);
                if (t - x > 0.5) {
                    return x +1;
                } else {
                    return x;
                }
            }
            sum += arr[i];
        }
        return arr[arr.length - 1];
    }
}

package com.yuankai.day;

import java.util.Arrays;

public class Day1 {
    // 914. 卡牌分组
    public boolean hasGroupsSizeX(int[] deck) {
        // 计数
        int[] counter = new int[10000];
        for (int num: deck) {
            counter[num]++;
        }
        // 求最大公约数
        return Arrays.stream(counter).reduce(this::gcd).getAsInt() > 1;

    }
    private int gcd(int a, int b) {
        return b == 0? a: gcd(b, a % b);
    }
}

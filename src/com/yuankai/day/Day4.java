package com.yuankai.day;

import java.util.LinkedList;
import java.util.List;

public class Day4 {

    // 62.圆圈中最后剩下的数字 用链表会超时。。
    public int lastRemaining(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int size = n;
        int cur = -1;
        for (int i = 0; i < n - 1; i++) {
            cur = (cur + m) % size--;
            list.remove(cur--);
        }
        return list.get(0);
    }

    /*public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i < n+1; i++) {
            x = (x + m) % i;
        }
        return x;
    }*/
}

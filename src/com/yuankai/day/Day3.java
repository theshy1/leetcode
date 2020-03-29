package com.yuankai.day;

import java.util.ArrayDeque;
import java.util.Queue;

public class Day3 {

    // 1162.地图分析
    // 参考 https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/
    public int maxDistance(int[][] grid) {
        int[] dx = {1, 0 ,-1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<int[]> queue = new ArrayDeque();
        int size = grid.length;
        // 找出所有陆地入队
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        boolean isOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= size || newX < 0 || newY >= size || newY < 0 || grid[newX][newY] != 0) {
                    continue;
                }
                queue.offer(new int[]{newX, newY});
                grid[newX][newY] = grid[x][y] + 1;
                isOcean = true;
            }
        }
        if (point == null || !isOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] -1;
    }
}

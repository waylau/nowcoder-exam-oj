/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

/**
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * 例如：
 * 输入
 * [
 * [1,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,1,1],
 * [0,0,0,0,0],
 * [0,0,1,1,1]
 * ]
 * 对应的输出为3
 * (注：存储的01数据其实是字符'0','1')
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-02
 */
public class NC109NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = new char[5][5];

        grid[0] = new char[] {'1', '1', '0', '0', '0'};
        grid[1] = new char[] {'0', '1', '0', '1', '1'};
        grid[2] = new char[] {'0', '0', '0', '1', '1'};
        grid[3] = new char[] {'0', '0', '0', '0', '0'};
        grid[4] = new char[] {'0', '0', '1', '1', '1'};

        System.out.println(solve(grid));
    }

    private static int solve(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        char[][] visited = new char[row][column];

        int rootCount = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 当前元素符合根节点的条件
                if (grid[i][j] == '1' && visited[i][j] != '1') {
                    rootCount++;
                    solve(grid, visited, i, j);
                }
            }
        }

        return rootCount;
    }

    private static void solve(char[][] grid, char[][] visited, int x, int y) {
        // 如果当前是1，则继续往相邻查找
        if (grid[x][y] == '1' && visited[x][y] != '1') {

            // 标识为已经查找过
            visited[x][y] = '1';

            // 继续往相邻查找. 注意边界
            int row = grid.length;
            int column = grid[0].length;

            if (x + 1 < row) {
                solve(grid, visited, x + 1, y);
            }

            if (x - 1 >= 0) {
                solve(grid, visited, x - 1, y);
            }

            if (y + 1 < column) {
                solve(grid, visited, x, y + 1);
            }

            if (y - 1 >= 0) {
                solve(grid, visited, x, y - 1);
            }

        } else {
            // 标识为已经查找过
            visited[x][y] = '1';
        }
    }

}

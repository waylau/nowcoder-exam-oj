/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * NC39 N皇后问题
 * N 皇后问题是指在 n * n 的棋盘上要摆 n 个皇后
 * 要求：任何两个皇后不同行，不同列也不在同一条斜线上，
 * 求给一个整数 n ，返回 n 皇后的摆法数。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-02
 */
public class NC039NQueenProblem {

    private static List<int[][]> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(nqueen(3));
        System.out.println(nqueen(4));
        System.out.println(nqueen(8));
    }

    private static int nqueen(int n) {
        // 初始化棋盘
        int[][] chessboard = new int[n][n];
        solve(chessboard, 0);

        return result.size();
    }

    private static void solve(int[][] chessboard, int row) {
        int n = chessboard.length;

        // 终止条件
        if (row == n) {
            // 收集结果
            result.add(chessboard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(chessboard, row, col)) { // 验证合法就可以放
                chessboard[row][col] = 1; // 放置皇后

                // 尝试下一行
                solve(chessboard, row + 1);
                chessboard[row][col] = 0; // 回溯，撤销皇后
            }
        }
    }

    // 校验是否可以摆放
    static boolean isValid(int[][] chessboard, int row, int col) {
        int n = chessboard.length;

        // 无需检查行。因为在单层搜索的过程中，每一层递归，只会选for循环（也就是同一行）里的一个元素。
        // 检查列
        for (int i = 0; i < row; i++) { // 这是一个剪枝
            if (chessboard[i][col] == 1) {
                return false;
            }
        }
        // 检查 45度角是否有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        // 检查 135度角是否有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}

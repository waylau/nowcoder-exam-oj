 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ35 蛇形矩阵.
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * 
 * 输入描述：输入正整数N（N不大于100）
 * 输出描述：输出一个N行的蛇形矩阵。
 * 
 * 示例1
 * 
 * 输入：4
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ035SerpentineMatrix {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 蛇形矩阵可以采用二维数组表达
        int[][] out = new int[n][n];

        // 数据填充
        int value = 1;
        for (int i = 0; i < n; i++) {
            // 初始位置
            int x = i;
            int y = 0;

            while (y < n && x >= 0) {
                out[x][y] = value;

                x--;
                y++;
                value++;
            }
        }

        // 输出
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            // j遍历到n-i的位置即可，可以减少无效的遍历
            for (int j = 0; j < n - i; j++) {
                if (out[i][j] != 0) {
                    sb.append(out[i][j] + " ");
                }

            }

            System.out.println(sb.toString().trim());
        }

        // 关闭
        sc.close();
    }
}

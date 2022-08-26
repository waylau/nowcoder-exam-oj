/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ53 杨辉三角的变形.
 * 描述
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，
 * 左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * 输入描述:输入一个int整数
 * 输出描述:输出返回的int值
 * 示例1
 * 输入
 * 4
 * 输出
 * 3
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ053DeformationOfYanghuiTriangle {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 输出
        System.out.println(getResult(n));

        // 关闭
        in.close();
    }

    private static int getResult(int n) {
        int m = (n - 1) * 2 + 1; // 矩阵的列数。

        // 矩阵为空的赋值0；
        int[][] arr = new int[n][m];

        // 中间索引位置
        int mid = m / 2;

        //计算时先算第1行，
        arr[0][mid] = 1;

        // 起止位置
        int start = mid;
        int end = mid;

        // 再算第2到n行，因此类推，算到n行为止。
        for (int i = 1; i < n; i++) {
            start--;
            end++;
            for (int j = start; j <= end; j++) {
                // 上一行的左、中、右 值
                // 需要考虑边界
                int previousLeft = j - 1 < 0 ? 0 : arr[i - 1][j - 1];
                int previousMid = arr[i - 1][j];
                int previousRight = j + 1 > n ? 0 : arr[i - 1][j + 1];

                // 上一行的左、中、右 值相加
                arr[i][j] = previousLeft + previousMid + previousRight;
            }
        }

        // 取最后一行遍历，找出偶数后返回
        for (int i = 1; i < m; i++) {
            int v = arr[n - 1][i];

            // 判断是偶数
            if (v % 2 == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}

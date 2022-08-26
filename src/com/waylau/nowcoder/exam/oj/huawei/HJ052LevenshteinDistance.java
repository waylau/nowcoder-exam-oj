/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ52 计算字符串的编辑距离.
 * 描述：Levenshtein 距离，又称编辑距离，指的是两个字符串之间，
 * 由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * 编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 * Ex：
 * 字符串A: abcdefg
 * 字符串B: abcdef
 * 通过增加或是删掉字符 “g” 的方式达到目的。
 * 这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 * 数据范围：给定的字符串长度满足1≤len(str)≤1000
 * 输入描述：每组用例一共2行，为输入的两个字符串
 * 输出描述：每组用例输出一行，代表字符串的距离
 * 示例1
 * 输入：
 * abcdefg
 * abcdef
 * 输出：
 * 1
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ052LevenshteinDistance {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        String a =  in.nextLine();
        String b =  in.nextLine();

        // 输出
        System.out.println(getDistance(a, b));

        // 关闭
        in.close();
    }
    
    private static int getDistance(String a, String b) {
        int m = a.length() + 1;
        int n = b.length() + 1;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (a.charAt(i - 1) != b.charAt(j - 1)) {
                    int substitution = dp[i - 1][j - 1] + 1;
                    int deletion = dp[i - 1][j] + 1;
                    int insertion = dp[i][j - 1] + 1;

                    // 取三者的最小值
                    dp[i][j] = Math.min(Math.min(substitution, deletion), insertion);
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }

            }
        }

        return dp[m - 1][n - 1];
    }
}

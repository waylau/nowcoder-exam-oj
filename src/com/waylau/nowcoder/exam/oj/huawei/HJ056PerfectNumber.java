 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;
 

import java.util.Scanner;

/**
 * HJ56 完全数计算.
 * 描述:完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * 给定函数count(int n),用于计算n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * 返回n以内完全数的个数。 异常情况返回-1
 * 输入描述: 输入一个数字
 * 输出描述: 输出完全数的个数
 * 示例1
 * 输入
 * 1000
 * 输出
 * 3
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ056PerfectNumber {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 输出
        System.out.println(countPerfectNumber(n));

        // 关闭
        in.close();
    }

    private static int countPerfectNumber(int n) {
        int count = 0;
        // 从1算到n行为止。
        for (int i = 1; i <= n; i++) {
            // 所有真因子做累加
            int sum = 0;
            for (int j = 1; j < i; j++) {
                // 判断是否是约数
                if (i % j == 0) {
                    sum += j;
                }
            }

            // 是完全数
            if (i == sum) {
                count++;
            }

        }

        return count;
    }
}

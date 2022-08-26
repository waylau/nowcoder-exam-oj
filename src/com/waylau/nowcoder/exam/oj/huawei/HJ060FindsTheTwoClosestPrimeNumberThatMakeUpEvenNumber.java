/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ60 查找组成一个偶数最接近的两个素数。
 * 描述：任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，
 * 本题目要求输出组成指定偶数的两个素数差值最小的素数对
 * 输入描述: 输入一个偶数
 * 输出描述: 输出两个素数
 * 示例1
 * 输入
 * 20
 * 输出
 * 7
 * 13
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ060FindsTheTwoClosestPrimeNumberThatMakeUpEvenNumber {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 折半
        int n1 = n / 2;
        int n2 = n - n1;

        while (0 < n1 && n2 < n) {
            if (isPrime(n1) && isPrime(n2)) {
                // 输出
                System.out.println(n1);
                System.out.println(n2);

                break;
            }

            n1 -= 1;
            n2 += 1;
        }

        // 关闭
        in.close();
    }

    // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
    // 0和1既不是质数也不是合数，最小的质数是2
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }
}

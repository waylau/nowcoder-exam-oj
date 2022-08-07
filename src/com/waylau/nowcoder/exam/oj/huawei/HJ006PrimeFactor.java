/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ6 质数因子. 描述：输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举） （如180的质因子为2 2 3 3 5 ）
 * 输入描述：输入一个整数 输出描述：按照从小到大的顺序输出它的所有质数的因子，以空格隔开。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-06
 */
public class HJ006PrimeFactor {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		Long in = sc.nextLong();

		// 返回一个正确舍入的double值的正平方根
		long k = (long) Math.sqrt(in);

		// 从最小的质数开始尝试
		for (long i = 2; i <= k; i++) {

			// 不断尝试直到不能被除尽
			while (in % i == 0) {
				System.out.print(i + " ");
				in /= i;
			}
		}

		// 输出
		System.out.println(in == 1 ? "" : in + " ");
		
		// 关闭资源
		sc.close();
	}
}

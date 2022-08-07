/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;


/**
 * HJ15 求int型正整数在内存中存储时1的个数. 
 * 描述：输入一个 int 型的正整数，计算出该 int 型数据在内存中存储时 1 的个数。
 * 数据范围：保证在 32 位整型数字范围内
 * 输入描述：输入一个整数（int类型）
 * 输出描述：这个数转换成2进制后，输出1的个数
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ015FindTheNumberOfOneWhenIntegersStoredInMemory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 输入整数
		Integer in = sc.nextInt();

		// 转为二进制
		String bStr = Integer.toBinaryString(in);

		// 统计1的个数
		int count = 0;
		for (int i = 0; i < bStr.length(); i++) {
			char c = bStr.charAt(i);

			if (c == '1') {
				count++;
			}
		}

		System.out.println(count);

		// 关闭资源
		sc.close();
	}
}

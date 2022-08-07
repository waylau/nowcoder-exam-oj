/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HJ9 提取不重复的整数. 
 * 描述：输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * 数据范围： 1≤n≤10   
 * 输入描述：输入一个int型整数
 * 输出描述：按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ009ExtractsNonRepeatingIntegers {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// 构造一个Set结构用于判重
		Set<Character> set = new HashSet<>();
		StringBuilder result = new StringBuilder();

		// 逆序遍历
		for (int i = in.length() - 1; i >= 0; i--) {
			char c = in.charAt(i);

			// 判重，不重复的就记录下来
			if (!set.contains(c)) {
				set.add(c);
				result.append(c);
			}
		}

		// 按顺序输出
		System.out.println(result.toString());

		// 关闭资源
		sc.close();
	}
}

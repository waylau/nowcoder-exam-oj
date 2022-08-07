/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * HJ10 字符个数统计. 
 * 描述：编写一个函数，计算字符串中含有的不同字符的个数。
 * 字符在 ASCII 码范围内( 0~127 ，包括 0 和 127 )，
 * 换行表示结束符，不算在字符里。不在范围内的不作统计。
 * 多个相同的字符只计算一次。
 * 例如，对于字符串 abaca 而言，有 a、b、c 三种不同的字符，因此输出 3 。
 * 数据范围： 1≤n≤500 
 * 输入描述：输入一行没有空格的字符串。
 * 输出描述：输出 输入字符串 中范围在(0~127，包括0和127)字符的种数。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ010CharacterCountStatistics {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// 构造一个Set结构用于去重
		Set<Character> set = new HashSet<>();

		// 遍历
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);

			// 去重
			set.add(c);
		}

		// 输出
		System.out.println(set.size());

		// 关闭资源
		sc.close();
	}
}

/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ12 字符串反转. 
 * 描述：接受一个只包含小写字母的字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
 * 输入描述：输入一行，为一个只包含小写字母的字符串。
 * 输出描述：输出该字符串反转后的字符串。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ012StringReversal {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// 转为StringBuilder 
		StringBuilder sb = new StringBuilder(in);

		// 输出
		System.out.println(sb.reverse());

		// 关闭资源
		sc.close();
	}
}

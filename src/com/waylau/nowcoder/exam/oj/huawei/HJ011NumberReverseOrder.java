/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ11 数字颠倒. 
 * 描述：输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001数据范围： 0≤n≤2 
 * 输入描述：输入一个int整数
 * 输出描述：将这个整数以字符串的形式逆序输出
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ011NumberReverseOrder {

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

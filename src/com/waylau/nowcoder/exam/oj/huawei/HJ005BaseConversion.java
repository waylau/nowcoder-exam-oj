/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ5 进制转换. 
 * 描述：写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
 * 输入描述：输入一个十六进制的数值字符串。
 * 输出描述：输出该数值的十进制字符串。不同组的测试用例用\n隔开。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-06
 */
public class HJ005BaseConversion {

	public static void main(String[] args) {
		// 输入一行，代表要计算值。
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		
		// Integer.parseInt方法能直接将16进制转为10进制，
		// 输出
		System.out.println(Integer.parseInt(in.substring(2), 16));

		// 关闭资源
		sc.close();
	}
}

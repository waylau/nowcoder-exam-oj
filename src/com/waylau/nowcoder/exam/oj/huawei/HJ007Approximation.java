/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ7 取近似值. 
 * 描述：写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 * 数据范围：保证输入的数字在 32 位浮点数范围内。
 * 输入描述：输入一个正浮点数值。
 * 输出描述：输出该数值的近似整数值
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ007Approximation {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		double in = sc.nextDouble();

		// Math.round实现四舍五入
		long result = Math.round(in);

		// 输出
		System.out.println(result);

		// 关闭资源
		sc.close();
	}
}

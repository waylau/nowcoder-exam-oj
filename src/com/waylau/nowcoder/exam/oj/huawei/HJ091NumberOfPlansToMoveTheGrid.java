/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ91 走方格的方案数.
 * 描述：请计算n*m的棋盘格子（n为横向的格子数，m为竖向的格子数）
 * 从棋盘左上角出发沿着边缘线从左上角走到右下角，总共有多少种走法，
 * 要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 注：沿棋盘格之间的边缘线行走
 * 数据范围： 1≤n,m≤8 
 * 输入描述：
 * 输入两个正整数n和m，用空格隔开。(1≤n,m≤8)
 * 输出描述：
 * 输出一行结果
 * 示例1
 * 输入：
 * 2 2
 * 
 * 输出：
 * 6
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ091NumberOfPlansToMoveTheGrid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(cal(m, n));
		}

		sc.close();

	}

	// 递归
	private static int cal(int m, int n) {
		if (m == 1 || n == 1) {
			return m + n;
		}
		
		// 向下或者向右
		return cal(m - 1, n) + cal(m, n - 1);
	}
}
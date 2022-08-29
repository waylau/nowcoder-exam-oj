/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ107 求解立方根.
 * 描述:计算一个浮点数的立方根，不使用库函数。
 * 保留一位小数。
 * 数据范围：∣val∣≤20 
 * 输入描述：
 * 待求解参数，为double类型（一个实数）
 * 输出描述：
 * 输出参数的立方根。保留一位小数。
 * 示例1
 * 输入：
 * 19.9
 * 输出：
 * 2.7
 * 
 * 示例2
 * 输入：
 * 2.7
 * 
 * 输出：
 * 1.4
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ107SolveTheCubeRoot {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			double n = in.nextDouble();
			String result = null;

			// 保留四舍五入小数点1位
			result = String.format("%.1f",getCubeRoot(n));

			System.out.println(result);
		}

		in.close();
	}

	// 二分查找
	private static double getCubeRoot(double num) {
		double right, left, mid = 0.0;
		// 注意边界，输入的num可能是负数 将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
		right = Math.max(1.0, num);
		left = Math.min(-1.0, num);
		while (right - left > 0.001) {
			mid = (left + right) / 2;
			// 如果乘积大于num，说明立方根在mid的左侧
			if (mid * mid * mid > num) {
				right = mid;
			}
			// 如果乘积小于num，说明立方根在mid的右侧
			else if (mid * mid * mid < num) {
				left = mid;
			} else {
				return mid;
			}
		}
		return right;
	}

}

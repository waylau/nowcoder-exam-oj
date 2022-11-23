/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 网上商城优惠活动（一）
 * @since 1.0.0 2022年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class P1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String lineOne = s.nextLine();

		String[] lineOneArray = lineOne.split(" ");
		int manjian = Integer.valueOf(lineOneArray[0]);
		int dazhe = Integer.valueOf(lineOneArray[1]);
		int wumanekan = Integer.valueOf(lineOneArray[2]);

		int n = s.nextInt();

		for (int i = 0; i < n; i++) {
			int value = s.nextInt();
			solve(manjian, dazhe, wumanekan, value);
		}

		s.close();
	}

	private static void solve(int manjian, int dazhe,
			int wumanekan, int value) {
		// 限制边界，减少运算
		double totalManjian = (value / (manjian * 100));
		Double ceilTotalManjian = Math.ceil(totalManjian);

		// 最多用一张
		int minDazhe = Math.min(dazhe, 1);

		// 限制边界，减少运算
		double totalWumanekan = (value / wumanekan);
		Double ceiltotalWumanekan = Math
				.ceil(totalWumanekan);

		// 最小值
		int minValue = value;
		int count = 0;
		for (int i = 0; i <= ceilTotalManjian
				.intValue(); i++) {
			for (int j = 0; j <= minDazhe; i++) {
				for (int k = 0; k <= ceiltotalWumanekan
						.intValue(); i++) {
					// 只用两种卷
					if (i == 0 || j == 0 || k == 0) {
						// 第一种方式
						int result1 = (value - i * 10);
						Double ceilzhekou = Math
								.ceil(j * 0.08);
						result1 = result1
								- ceilzhekou.intValue();
						result1 = result1 - k * 5;

						// 第2种方式
						int result2 = (value - i * 10
								- k * 5);
						Double ceilzhekou2 = Math
								.ceil(j * 0.08);
						result2 = result2
								- ceilzhekou2.intValue();

						// 第3种方式
						Double ceilzhekou3 = Math
								.ceil(j * 0.08);
						int result3 = (value
								- ceilzhekou3.intValue()
								- i * 10 - k * 5);

						int min = Math.min(result2,
								result1);
						min = Math.min(min, result3);

						if (min < minValue) {
							minValue = min;
							count = i + k + j;
						}
					}
				}
			}
		}

		System.out.println(minValue + " " + count);
	}

}

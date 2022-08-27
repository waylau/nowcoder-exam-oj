/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ61 放苹果.
 * 描述：把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * 注意：如果有7个苹果和3个盘子，（5，1，1）和（1，5，1）被视为是同一种分法。
 * 数据范围： `0≤m≤10` ， `1≤n≤10` 。
 * 输入描述：
 * 输入两个int整数
 * 输出描述：
 * 输出结果，int型
 * 示例1
 * 输入：
 * 7 3
 * 输出：
 * 8
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ061PutApple {

	public static void main(String[] args)
			throws IOException {
		// 输入
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");

		int appleNamber = Integer.valueOf(in[0]);
		int plateNamber = Integer.valueOf(in[1]);

		// 输出
		System.out
				.println(getWays(appleNamber, plateNamber));

		// 关闭
		br.close();
	}

	private static int getWays(int appleNamber,
			int plateNamber) {

		// 只有1个盘子或者只有1个苹果，那只有1种分发
		if (appleNamber == 1 || plateNamber == 1) {
			return 1;
		}

		// 没有也是1种分发
		if (appleNamber == 0) {
			return 1;
		}

		// 没有盘子就分不成了
		if (plateNamber == 0) {
			return 0;
		}

		// 当n>m：必定有n-m个盘子永远空着，去掉它们对摆放苹果方法数目不产生影响。
		// 即`if(n>m) f(m,n) = f(m,m)`
		if (plateNamber > appleNamber) {
			return getWays(appleNamber, appleNamber);
		}

		// 当n<=m：不同的放法可以分成两类：
		// 1、有至少一个盘子空着，即相当于f(m,n) = f(m,n-1);
		// 2、所有盘子都有苹果，相当于可以从每个盘子中拿掉一个苹果，不影响不同放法的数目，即f(m,n) = f(m-n,n).
		// 而总的放苹果的放法数目等于两者的和，即 f(m,n) =f(m,n-1)+f(m-n,n)
		return getWays(appleNamber, plateNamber - 1)
				+ getWays(appleNamber - plateNamber,
						plateNamber);
	}
}
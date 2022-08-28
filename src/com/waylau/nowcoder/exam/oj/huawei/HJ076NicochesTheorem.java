/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ76 尼科彻斯定理.
 * 描述:验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。
 * 例如：
 * 1^3=1
 * 2^3=3+5
 * 3^3=7+9+11
 * 4^3=13+15+17+19
 * 输入一个正整数m（m≤100），将m的立方写成m个连续奇数之和的形式输出。
 * 数据范围：1≤m≤100 
 * 进阶：时间复杂度：O(m) ，空间复杂度：O(1)
 * 输入描述：
 * 输入一个int整数
 * 输出描述：
 * 输出分解后的string
 * 示例1
 * 输入：
 * 6
 * 输出：
 * 31+33+35+37+39+41
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ076NicochesTheorem {

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		// 观察规律
		// 第n行的首个数字，与n-1的首个数字差值是2(n-1)
		int first = getResult(n);
		
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		
		// 后续每个值都与前一个值差2
		for (int i = 1; i < n; i++) {
			sb.append("+");
			 int num = 2*i + first;
			 sb.append(num);
		}


		// 输出
		System.out.println(sb.toString());

		// 关闭
		in.close();
	}
	
	private static int getResult(int n) {
		if (n == 0) {
			return 1; 
		}
		
		return getResult(n-1) + 2*(n-1);
	}

}

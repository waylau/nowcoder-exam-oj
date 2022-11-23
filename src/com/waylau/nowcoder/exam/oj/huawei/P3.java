/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 统计差异值大于相似值二元组个数
 * 
 * @since 1.0.0 2022年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class P3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.println(solve(n, arr));
		s.close();
	}

	private static int solve(int n, int[] arr) {
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (chayizhi(arr[i], arr[j])) {
					result++;
				}
			}
		}
		return result;
	}

	private static boolean chayizhi(int a, int b) {
		String aB = Integer.toBinaryString(a);
		String bB = Integer.toBinaryString(b);
		StringBuilder chayizhiSB = new StringBuilder();
		StringBuilder xiangsizhiSB = new StringBuilder();

		int len = Math.max(aB.length(), bB.length());

		// 不够补0
		while (len > aB.length()) {
			aB = "0" + aB;
		}

		while (len > bB.length()) {
			bB = "0" + bB;
		}

		for (int i = 0; i < len; i++) {
			if (aB.charAt(i) == bB.charAt(i)) {
				chayizhiSB.append("0");
				if (aB.charAt(i) == '1') {
					xiangsizhiSB.append("1");
				} else {
					xiangsizhiSB.append("0");
				}
			} else {
				chayizhiSB.append("1");
				xiangsizhiSB.append("0");
			}
		}

		int aR = Integer.parseInt(chayizhiSB.toString(), 2);
		int bR = Integer.parseInt(xiangsizhiSB.toString(),
				2);

		return aR > bR;
	}
}

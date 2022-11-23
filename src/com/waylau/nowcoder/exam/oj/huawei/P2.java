/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 贪心的商人
 * @since 1.0.0 2022年11月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class P2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int days = s.nextInt();

		int[] num = new int[n];
		int[] arr = new int[days];
		int result = 0;
		
 
		for (int i = 0; i < n; i++) {
			num[i] = s.nextInt();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < days; j++) {
				arr[j] = s.nextInt();
			}

			result += solve(days, arr, num[i]);
		}

		System.out.println(result);
		s.close();
	}

	private static int solve(int days, int[] arr, int num) {
		int result = 0;
		int i = 0;
		while ((i + 1) < days) {
			if (arr[i] < arr[i + 1]) {
				result += num*(arr[i + 1] - arr[i]);
			}
			
			i++;
		}

		return result;
	}
}

/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ82 将真分数分解为埃及分数.
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ082DecomposeTrueFractionsIntoEgyptianFractions {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String[] ss = sc.nextLine().split("/");
			long a = Integer.parseInt(ss[0]);
			long b = Integer.parseInt(ss[1]);
			long t;
			StringBuilder sb = new StringBuilder();
			while (a != 0) {
				t = b / a + (b % a == 0 ? 0 : 1);
				if (b % t == 0 && a >= t) {
					a -= b / t;
					sb.append('1').append('/').append(t)
							.append('+');
				} else {
					a = a * t - b;
					b = b * t; // 这里可能溢出，所以都用long
					if (a != 0)
						sb.append('1').append('/').append(t)
								.append('+');
					else
						sb.append('1').append('/')
								.append(t);
				}
				if (a == 1) {
					sb.append('1').append('/').append(b);
					break;
				}
			}
			System.out.println(sb);
		}

		sc.close();

	}

}

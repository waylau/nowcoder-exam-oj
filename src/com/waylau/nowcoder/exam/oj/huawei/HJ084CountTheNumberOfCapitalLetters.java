/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ84 统计大写字母个数.
 * 描述:找出给定字符串中大写字符(即'A'-'Z')的个数
 * 数据范围：字符串长度：1≤∣s∣≤250 
 * 字符串中可能包含空格或其他字符
 * 输入描述：
 * 对于每组样例，输入一行，代表待统计的字符串
 * 输出描述：
 * 输出一个整数，代表字符串中大写字母的个数
 * 示例1
 * 输入：
 * A 1 0 1 1150175017(&^%&$vabovbaoadd 123#$%#%#O
 * 输出：
 * 2
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ084CountTheNumberOfCapitalLetters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int count = 0;
		for (char ch : str.toCharArray()) {
			// Character不讲武德
			if (Character.isUpperCase(ch)) {
				count ++;
			}
		}

		System.out.println(count);

		br.close();
	}

}

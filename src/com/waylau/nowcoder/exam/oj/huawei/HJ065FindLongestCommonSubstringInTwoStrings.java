/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ65 查找两个字符串a,b中的最长公共子串.
 * 描述:查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。
 * 注：子串的定义：将一个字符串删去前缀和后缀（也可以不删）形成的字符串。
 * 请和“子序列”的概念分开！
 * 数据范围：字符串长度 1≤length≤300
 * 进阶：时间复杂度：O(n^3) ，空间复杂度：O(n)
 * 输入描述：
 * 输入两个字符串
 * 输出描述：
 * 返回重复出现的字符
 * 示例1
 * 输入：
 * abcdefghijklmnop
 * abcsafjklmnopqrstuvw
 * 输出：
 * jklmnop
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ065FindLongestCommonSubstringInTwoStrings {
	public static void main(String[] args)
			throws IOException {
		// 输入
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		// a作为较短的那个字符串
		String a;
		String b;
		if (str1.length() <= str2.length()) {
			a = str1;
			b = str2;
		} else {
			a = str2;
			b = str1;
		}

		// 看a截取子串在b中是否包含
		int aLength = a.length();
		int aSubLength = aLength;
		String result = "";
		boolean isContinue = true;
		while (aSubLength > 0 && isContinue) {
			// 从前往后截取
			for (int i = 0; i < aLength - aSubLength + 1; i++) {
				String aSub = a.substring(i,
						i + aSubLength);

				// 如果包含，则程序结束
				if (b.contains(aSub)) {
					result = aSub;
					isContinue = false;
					break;
				}

			}

			// 缩小截取的范围
			aSubLength--;
		}

		// 输出
		System.out.println(result);

		// 关闭
		br.close();
	}

}

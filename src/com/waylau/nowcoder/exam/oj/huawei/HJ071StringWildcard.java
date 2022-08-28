/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ71 字符串通配符。
 * 描述：在计算机中，通配符一种特殊语法，广泛应用于文件搜索、数据库、正则表达式等领域。
 * 现要求各位实现字符串通配符的算法。
 * 要求：
 * 实现如下2个通配符：
 * *：匹配0个或以上的字符（注：能被*和?匹配的字符仅由英文字母和数字0到9组成，下同）
 * ？：匹配1个字符
 * 注意：匹配时不区分大小写。
 * 输入：
 * 通配符表达式；
 * 一组字符串。
 * 输出：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 数据范围：字符串长度：1≤s≤100 
 * 输入描述：
 * 先输入一个带有通配符的字符串，再输入一个需要匹配的字符串
 * 输出描述：
 * 返回不区分大小写的匹配结果，匹配成功输出true，匹配失败输出false
 * 示例1
 * 输入：
 * te?t*.*
 * txt12.xls
 * 
 * 输出：
 * false

 * @since 1.0.0 2022年8月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ071StringWildcard {

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);

		// 先统一为小写
		String wildcard = in.nextLine().toLowerCase();
		String str = in.nextLine().toLowerCase();
		
		// 缩减*号
		wildcard = shortAsterisk(wildcard);

		// 输出
		System.out.println(isMatch(wildcard, str, 0, 0));

		// 关闭
		in.close();
	}

	private static boolean isMatch(String wildcard,
			String str, int wildcardP, int strP) {
		// 两个字符串同时结束,返回true
		if ((wildcard.length() == wildcardP)
				&& (str.length() == strP)) {
			return true;
		} else if ((wildcard.length() == wildcardP)
				|| (str.length() == strP)) {
			// 两个字符串中有一个先结束，返回false
			return false;
		}

		if ((wildcard.length() != wildcardP)
				&& (str.length() == strP)) {
			// wildcardArray里全是* 匹配结果为 True
			// wildcardArray里不全是* 匹配结果为 False
			for (int i = 0; i < wildcard.length(); i++) {
				if (wildcard.charAt(i) != '*') {
					return false;
				}
			}

			return true;
		}

		char currentWildcard = wildcard.charAt(wildcardP);
		char currentStr = str.charAt(strP);

		// 匹配的字符仅由英文字母和数字0到9组成
		if (currentWildcard != currentStr && !(Character
				.isDigit(currentStr)
				|| Character.isLetter(currentStr))) {
			return false;
		} else if (currentWildcard != currentStr
				&& (Character.isDigit(currentStr)
						|| Character
								.isLetter(currentStr))) {

			if (currentWildcard == '?') {
				// 跳过，直接看下一位
				isMatch(wildcard, str, wildcardP + 1,
						strP + 1);
			} else if (currentWildcard == '*') {
				// 有三种选择：
				// 1、匹配0个，通配符向后移动一个字符，字符串不动；
				// 2、匹配1个，通配符和字符串都向后移动一个字符；
				// 3、匹配多个，通配符不动，字符串向后移动一个字符。
				return isMatch(wildcard, str, wildcardP + 1,
						strP)
						|| isMatch(wildcard, str,
								wildcardP + 1, strP + 1)
						|| isMatch(wildcard, str, wildcardP,
								strP + 1);

			} else {
				return false;
			}
		}  
		
		return isMatch(wildcard, str, wildcardP + 1, strP + 1);
	}

	// 缩减*号
	private static String shortAsterisk(String str) {
		char[] arr = str.toCharArray();
		int len  = arr.length;
		
		// 只有1个元素直接返回了
		if (len<=1) {
			return  str;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(arr[0]);
		
		for (int i = 1; i< arr.length; i++) {
			// 如果前面的也是*，说明有连续*，丢掉本次的*
			if (arr[i] == '*' && arr[i-1] == '*') {
				// do nothing
			} else {
				sb.append(arr[i]);
			}
		}
		
		return sb.toString();
	}
}

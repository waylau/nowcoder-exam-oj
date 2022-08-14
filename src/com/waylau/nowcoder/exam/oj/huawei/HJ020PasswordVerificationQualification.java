/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * HJ20 密码验证合格程序. 
 * 描述：密码要求:1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有长度大于2的包含公共元素的子串重复 （注：其他符号不含空格或换行）
 * 数据范围：输入的字符串长度满足 1≤n≤100 
 * 输入描述：一组字符串。
 * 输出描述：如果符合要求输出：OK，否则输出NG
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-15
 */
public class HJ020PasswordVerificationQualification {

	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);

		String result = "NG";
		while (sc.hasNext()) {
			String line = sc.nextLine();

			if (line.length() > 8 && isStringMatched(line)
					&& !isRepeatedString(line, 0, 3)) {
				result = "OK";
			}
		}

		// 输出
		System.out.println(result);

		// 关闭
		sc.close();
	}

	// 检查是否满足正则
	private static boolean isStringMatched(String str) {
		int count = 0;
		Pattern p1 = Pattern.compile("[A-Z]");
		if (p1.matcher(str).find()) {
			count++;
		}
		Pattern p2 = Pattern.compile("[a-z]");
		if (p2.matcher(str).find()) {
			count++;
		}
		Pattern p3 = Pattern.compile("[0-9]");
		if (p3.matcher(str).find()) {
			count++;
		}
		Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
		if (p4.matcher(str).find()) {
			count++;
		}
		if (count >= 3) {
			return true;
		} else {
			return false;
		}
	}

	// 递归校验是否有重复子串
	private static boolean isRepeatedString(String str,
			int l, int r) {
		if (r >= str.length()) {
			return false;
		}
		if (str.substring(r)
				.contains(str.substring(l, r))) {
			return true;
		} else {
			return isRepeatedString(str, l + 1, r + 1);
		}
	}
 
}

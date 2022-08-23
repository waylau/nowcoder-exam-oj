package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;
/**
 * HJ46 截取字符串.
 * 描述：输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 * 数据范围：字符串长度满足  `1≤n≤1000`  ， `1≤k≤n`
 * 输入描述：
 * 1.输入待截取的字符串
 * 2.输入一个正整数k，代表截取的长度
 * 输出描述：截取后的字符串
 * 示例1
 * 输入：
 * abABCcDEF
 * 6
 * 输出：
 * abABCc
 * 示例2
 * 输入：
 * bdxPKBhih
 * 6
 * 输出：
 * bdxPKB
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-23
 */
public class HJ046InterceptString {

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		int k = Integer.valueOf(in.nextLine());

		// 转为字符数组
		char[] arr = str.toCharArray();

		// 取数组的前k位字符拼接为字符串输出
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(arr[i]);
		}

		// 输出
		System.out.println(sb.toString());

		// 关闭
		in.close();
	}

}

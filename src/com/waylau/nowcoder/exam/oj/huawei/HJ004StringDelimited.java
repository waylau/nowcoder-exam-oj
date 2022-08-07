/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ4 字符串分隔. 描述：输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：连续输入字符串(每个字符串长度小于等于100) 输出描述：依次输出所有分割后的长度为8的新字符串
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-06
 */
public class HJ004StringDelimited {

	public static void main(String[] args) {
		// 输入一行，代表要拆分的字符串。
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// 对输入字符串进行倒序遍历,
		// 每遍历8个字符就输出。
		int wordLength = 0;
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < in.length(); i++) {
			sb.append(in.charAt(i));
			wordLength++;
			if (wordLength == 8) {
				// 输出
				System.out.println(sb.toString());

				// 清空数据
				sb.delete(0, wordLength);
				wordLength = 0;
			}
		}

		// sb如果还有字符存在，则说明长度不足8个，用0补齐
		if (wordLength != 0) {
			for (int i = wordLength; i < 8; i++) {
				sb.append(0);
			}
		}

		// 输出
		System.out.println(sb.toString());

		// 关闭资源
		sc.close();
	}
}

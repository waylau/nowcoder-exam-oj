/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ1 字符串最后一个单词的长度. 描述：计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：输入一行，代表要计算的字符串，非空，长度小于5000。 输出描述：输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-05
 */
public class HJ001LengthOfTheLastWordInTheString {

	public static void main(String[] args) {
		// 输入一行，代表要计算的字符串，非空，长度小于5000。
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// 按照空格对输入字符串进行分组
		String[] words = in.split(" ");

		// 取数据组中最后一个元素
		String lastWord = words[words.length - 1];

		// 输出一个整数，表示输入字符串最后一个单词的长度。
		System.out.println(lastWord.length());

		// 关闭资源
		sc.close();
	}
}

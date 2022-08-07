/*
* Copyright (c) waylau.com, 2022. All rights reserved.
*/

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ2 计算某字符出现次数. 
 * 描述：写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，
 * 然后输出输入字符串中该字符的出现次数。（不区分大小写字母） 
 * 数据范围： 1≤n≤1000
 * 输入描述：第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。 
 * 输出描述：输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-05
 */

public class HJ002CountsTheNumberOfCharacters {

	public static void main(String[] args) {
		// 输入一行，代表要计算的字符串。
		Scanner sc = new Scanner(System.in);

		// 全部转为小写
		String in = sc.nextLine().toLowerCase();

		// 构造一个哈希结构，key为字符，值为该字符的个数
		Map<Character, Integer> map = new HashMap<>();

		// 对输入字符串进行遍历，将每遍历一个字符，就将该字符记录到哈希中
		for (int i = 0; i < in.length(); i++) {
			char c = in.charAt(i);
			// 之前就记过，就累加个数；否则就记1
			Integer count = map.get(c);

			if (count != null) {
				count++;
			} else {
				count = 1;
			}

			map.put(c, count);
		}

		// 再输入一行，代表要统计的字符。
		// 从哈希结构取出指定字符的值
		char charIn = sc.nextLine().toLowerCase().charAt(0);

		// 输出一个整数，表示输入字符串中含有该字符的个数。
		System.out.println(map.get(charIn) == null ? 0
				: map.get(charIn));

		// 关闭资源
		sc.close();
	}
}
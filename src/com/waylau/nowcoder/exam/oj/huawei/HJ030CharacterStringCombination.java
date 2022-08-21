/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * HJ30 字符串合并处理. 描述：将输入的两个字符串合并。对合并后的字符串进行排序， 要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
 * 这里的下标意思是字符在字符串中的位置。 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
 * 则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
 * 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’；
 * 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，
 * 分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF” 输入描述:输入两个字符串 输出描述:输出转化后的结果 示例1
 * 输入 dec fab 输出 5D37BF
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-17
 */
public class HJ030CharacterStringCombination {
	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		String[] words = in.split(" ");

		// 对输入的字符串进行合并；
		String word = words[0] + words[1];

		// 对合并后的字符串按照下标分为奇数和偶数两组
		char[] charArray = word.toCharArray();
		List<Character> evenList = new ArrayList<>();
		List<Character> oddList = new ArrayList<>();
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			if (i % 2 == 0) {
				evenList.add(ch);
			} else {
				oddList.add(ch);
			}
		}

		// 两组排序后再组合成字符串；
		evenList.sort(Comparator.naturalOrder());
		oddList.sort(Comparator.naturalOrder());
		for (int i = 0; i < evenList.size(); i++) {
			int j = i * 2;
			charArray[j] = evenList.get(i);
		}

		for (int i = 0; i < oddList.size(); i++) {
			int j = i * 2 + 1;
			charArray[j] = oddList.get(i);
		}

		// 字符转换
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < charArray.length; i++) {
			char ch = charArray[i];
			sb.append(reverse(ch));
		}

		// 输出
		System.out.println(sb.toString());

		// 关闭
		sc.close();
	}

	private static String reverse(char ch) {
		// 超过16进制的字符，原样返回
		if (('F' < ch && ch <= 'Z')
				|| ('f' < ch && ch <= 'z')) {
			return ch + "";
		}

		// 字符转为10进制
		int decimalFromHex = Integer.valueOf(ch + "", 16);

		// 10进制转2进制
		String binaryString = Integer
				.toBinaryString(decimalFromHex);

		// 前面补零
		while (binaryString.length() < 4) {
			binaryString = "0" + binaryString;
		}

		// 2进制字符反转
		String binaryStringReverse = new StringBuffer(
				binaryString).reverse().toString();

		// 2进制转10进制
		int decimal = Integer.valueOf(binaryStringReverse,
				2);

		// 10进制转16进制字符
		String hexString = Integer.toHexString(decimal);

		// 转为大写
		return hexString.toUpperCase();
	}
}

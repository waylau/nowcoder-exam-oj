/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;


/**
 * HJ13 句子逆序. 
 * 描述：将一个英文语句以单词为单位逆序排放。
 * 例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 * 数据范围：输入的字符串长度满足 1≤n≤1000 
 * 注意本题有多组输入
 * 输入描述：输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 * 输出描述：得到逆序的句子
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ013SentenceReverseOrder {

	public static void main(String[] args) {
		// 输入一行，代表要计算值
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String in = sc.nextLine();

			// 将输入切分为字符串数组；
			// 每个单词作为数组的元素；
			String[] inArray = in.split(" ");

			int len = inArray.length;
			for (int i = 0; i < len - 1; i++) {
				if (i < (len - 1 - i)) {
					// 数组首尾元素替换位置，以实现逆序；
					String head = inArray[i];
					String tail = inArray[len - 1 - i];
					inArray[i] = tail;
					inArray[len - 1 - i] = head;
				}

			}

			// 输出数组。
			System.out.println(String.join(" ", inArray));
		}

		// 关闭资源
		sc.close();
	}
}

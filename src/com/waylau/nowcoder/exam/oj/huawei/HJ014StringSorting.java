/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * HJ14 字符串排序. 
 * 描述：给定 n 个字符串，请对 n 个字符串按照字典序排列。
 * 数据范围： 1≤n≤1000，字符串长度满足1≤len≤100
 * 输入描述：输入第一行为一个正整数n(1≤n≤1000),
 * 下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 * 输出描述：数据输出n行，输出结果为按照字典序排列的字符串。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ014StringSorting {

	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		// 输入总行数
		int num = Integer.valueOf(br.readLine());

		// 用List结构存储
		List<String> result = new ArrayList<>(num);

		for (int i = 0; i < num; i++) {
			// 输入字符串
			String in = br.readLine();
			result.add(in);
		}

		// 按照自然排序
		result.sort(Comparator.naturalOrder());

		// 输出
		result.forEach(x -> {
			System.out.println(x);
		});

		// 关闭资源
		br.close();
	}
}

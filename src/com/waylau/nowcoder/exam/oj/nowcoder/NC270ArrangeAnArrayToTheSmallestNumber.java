/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NC270 把数组排成最小的数. 输入一个非负整数数组numbers，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组[3，32，321]，则打印出这三个数字能排成的最小数字为321323。 1.输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 2.拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-10-31
 */
public class NC270ArrangeAnArrayToTheSmallestNumber {

	public static void main(String[] args) {
		int[] numbers = new int[] { 11, 3 };
		System.out.println(printMinNumber(numbers));

		numbers = new int[] {};
		System.out.println(printMinNumber(numbers));

		numbers = new int[] { 3, 32, 321 };
		System.out.println(printMinNumber(numbers));
	}

	public static String printMinNumber(int[] numbers) {
		// Java8 Stream 把int数组转成List
		List<Integer> list = Arrays.stream(numbers).boxed()
				.collect(Collectors.toList());

		// 构建一个比较器，来比较 str(a)+str(b) 和 str(b)+str(a) 的大小
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return (o1 + "" + o2)
						.compareTo(o2 + "" + o1);
			}

		});

		// List拼接为String输出
		StringBuilder sb = new StringBuilder();
		list.forEach(s -> {
			sb.append(s);
		});

		return sb.toString();
	}

}

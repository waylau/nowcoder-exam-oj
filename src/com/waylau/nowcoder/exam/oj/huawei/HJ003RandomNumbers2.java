/*
* Copyright (c) waylau.com, 2022. All rights reserved.
*/

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * HJ3 明明的随机数. 描述:明明生成了N个1到500之间的随机整数。请你删去其中重复的数字，
 * 即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。 数据范围： 1≤n≤1000
 * ，输入的数字大小满足1≤val≤500 输入描述：第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。
 * 输出描述：输出多行，表示输入数据处理后的结果
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-06
 */

public class HJ003RandomNumbers2 {

	public static void main(String[] args) {
		// 输入一行，代表随机整数的个数 N。
		Scanner sc = new Scanner(System.in);

		// 全部转为小写
		int num = sc.nextInt();

		// 构造一个TreeSet结构，实现数字去重、排序
		TreeSet<Integer> set = new TreeSet<>();

		// 对输入数字进行遍历，将每遍历一个数字，就将该字符记录到Set中
		for (int i = 0; i < num; i++) {
			int randomNumer = sc.nextInt();
			set.add(randomNumer);
		}

		// 遍历输出每个整数
		set.forEach(System.out::println);

		// 关闭资源
		sc.close();
	}
}
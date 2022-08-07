/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * HJ8 合并表记录. 
 * 描述：数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照index值升序进行输出。
 * 输入描述：先输入键值对的个数n（1 <= n <= 500）
 * 接下来n行每行输入成对的index和value值，以空格隔开
 * 输出描述：输出合并后的键值对（多行）
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-07
 */
public class HJ008MergeTableRecords {

	public static void main(String[] args) {
		// 输入一行，代表总量
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		// 构造一个TreeMap结构
		Map<Integer, Integer> map = new TreeMap<>();

		// 对输入字符串进行遍历，将每遍历一个字符，就将该字符记录到哈希中
		int i = 0;
		boolean flag = true;
		while (flag) {
			int index = sc.nextInt();
			int value = sc.nextInt();

			// 之前就记过，就累加个数；否则就记1
			Integer valueInMap = map.get(index);

			if (valueInMap != null) {
				valueInMap += value;
			} else {
				valueInMap = value;
			}

			map.put(index, valueInMap);

			i++;

			// 总共执行num次
			if (i == num) {
				flag = false;
			}
		}

		// 按照index值升序进行输出index、value
		map.forEach((index, value) -> {
			System.out.println(index + " " + value);
		});

		// 关闭资源
		sc.close();
	}
}

/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * NC54 三数之和 
 * 给出一个有n个元素的数组S，S中是否有元素a,b,c满足a+b+c=0？找出数组S中所有满足条件的三元组。 
 * 注意：
 * 三元组（a、b、c）中的元素必须按非降序排列。（即a≤b≤c） 解集中不能包含重复的三元组。 
 * 例如，给定的数组 S = {-10 0 10 20 -10 -40},解集为(-10, -10, 20),(-10, 0, 10) 
 * 示例1 
 * 输入： [0] 
 * 返回值： [] 
 * 示例2 
 * 输入： [-2,0,1,1,2]
 * 返回值： [[-2,0,2],[-2,1,1]] 
 * 示例
 * 输入： [-10,0,10,20,-10,-40] 
 * 返回值：[[-10,-10,20],[-10,0,10]]
 * 
 * @since 1.0.0 2022年10月31日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class NC054SumOfThreeNumbers {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = threeSum(
				new int[] { -10, 0, 10, 20, -10, -40 });
		result.stream().forEach(System.out::println);
	}

	public static ArrayList<ArrayList<Integer>> threeSum(
			int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();

		// 因为结果有排序的要求，所以先对输入数组进行一个升序排序
		List<Integer> numList = Arrays.stream(num).boxed()
				.collect(Collectors.toList());
		numList.sort(Comparator.naturalOrder());

		// 通过set去重
		Set<ArrayList<Integer>> resultSet = new HashSet<>();

		int length = num.length;

		// 判断长度，小于3的可以直接退出
		if (length >= 3) {
			// 第1个元素遍历的范围为0到length-2
			for (int i = 0; i < length - 2; i++) {
				// 第2个元素遍历的范围为i+1到length-1
				for (int j = i + 1; j < length - 1; j++) {
					// 第3个元素遍历的范围为j+1到length
					for (int k = j + 1; k < length; k++) {
						// 如果三个元素和为0，则记录下来
						int a = numList.get(i);
						int b = numList.get(j);
						int c = numList.get(k);

						if ((a + b + c) == 0) {
							ArrayList<Integer> zeroList = new ArrayList<>();
							zeroList.add(a);
							zeroList.add(b);
							zeroList.add(c);

							// 通过set去重
							if (!resultSet
									.contains(zeroList)) {
								resultSet.add(zeroList);
								result.add(zeroList);
							}
						}
					}
				}
			}
		}

		return result;
	}
}

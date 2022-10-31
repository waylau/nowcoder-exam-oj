/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.jianzhi;

/**
 * JZ42 连续子数组最大和 
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，
 * 子数组最小长度为1。求所有子数组的和的最大值。
 * 示例1
 * 输入：
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值：18
 * 说明：
 * 经分析可知，输入数组的子数组[3,10,-4,7,2]可以求得最大和为18    
 *     
 * @author <a href="">Way Lau</a>
 * @since 2022-10-28
 */
public class JZ042FindGreatestSumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(findGreatestSumOfSubArray(arr));
	}

	private static int findGreatestSumOfSubArray(int[] array) {
		int result = 0;
		int length = array.length;

		// 定义一个数组sum，用于存放nums数组当中以某一元素为结束的最大子数组和。
		int[] sum = new int[length];

		// 以数组nums的第0个元素为结束的最大子数组和就是`nums[0]`其本身
		sum[0] = array[0];

		for (int i = 1; i < length; i++) {
			// 对于以数组nums的其他元素为结束的最大子数组和，
			// 应该等于“以其上一个元素为结束的最大子数组和加上该元素本身”和“该元素本身”这二者的较大值
			sum[i] = Math.max(sum[i - 1] + array[i],
					array[i]);

			// 缓存当前最大值
			result = Math.max(result, sum[i]);
		}

		return result;
	}
}

/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.nowcoder;


/**
 * NC36 在两个长度相等的排序数组中找到上中位.
 * 
 * 给定两个递增数组arr1和arr2，已知两个数组的长度都为N，求两个数组中所有数的上中位数。
 * 上中位数：假设递增序列长度为n，为第n/2个数
 * 
 * 
 * @since 1.0.0 2022年11月19日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class NC036FindUpperMedianInTwoSortedArraysOfEqualLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 输入：[1,2,3,4],[3,4,5,6]
		// 返回值：3
		int[] arr1 = new int[] { 1,2,3,4 };
		int[] arr2 = new int[] { 3,4,5,6 };
		System.out.println(findMedianinTwoSortedAray(arr1, arr2));

		// 输入：[0,1,2],[3,4,5]
		// 返回值：2
		arr1 = new int[] { 0,1,2 };
		arr2 = new int[] { 3,4,5 };
		System.out.println(findMedianinTwoSortedAray(arr1, arr2));

		// 输入：[1],[2]
		// 返回值：1
		arr1 = new int[] { 1 };
		arr2 = new int[] { 2 };
		System.out.println(findMedianinTwoSortedAray(arr1, arr2));

	}

    private static int findMedianinTwoSortedAray (int[] arr1, int[] arr2) {
		// 将两个数组合为一个数组，同时保持升序
		int length = arr1.length + arr2.length;
		int left = 0;
		int right = 0;

		while (left < arr1.length && right < arr2.length) {

			if (arr1[left] < arr2[right]) {
				// left代表第一个数组移动的次数，取值的时候+1，因为索引是从0开始的
				if (right + left + 1 >= length / 2) {
					return arr1[left];
				}
				left++;
				continue;
			}
			if (arr1[left] >= arr2[right]) {
				if (right + 1 + left >= length / 2) {
					return arr2[right];
				}
				right++;
				continue;
			}
		}
		return 0;
	}
	     
}

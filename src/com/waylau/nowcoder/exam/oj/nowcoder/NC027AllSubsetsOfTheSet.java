/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;

/**
 * NC27 集合的所有子集（一） 现在有一个没有重复元素的整数集合S，求S的所有子集 注意：
 * 你给出的子集中的元素必须按升序排列；给出的解集中不能出现重复的元素 示例1 输入： [1,2,3] 返回值：
 * [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]] 示例2 输入： [] 返回值： []
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-10-31
 */
public class NC027AllSubsetsOfTheSet {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> result = subsets(
				new int[] { 1, 2, 3 });

		result.stream().forEach(System.out::println);
	}

	public static ArrayList<ArrayList<Integer>> subsets(
			int[] arr) {
		// 结果
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();

		// 0个元素
		ArrayList<Integer> currentNode = new ArrayList<>();
		res.add(currentNode);

		// 处理1-n个元素的场景
		backtrack(currentNode, arr, 0, res);

		return res;
	}

	// 回溯算法核心函数，遍历子集问题的回溯树
	static void backtrack(ArrayList<Integer> parentNode,
			int[] nums, int start,
			ArrayList<ArrayList<Integer>> res) {
		for (int i = start; i < nums.length; i++) {
			// 子节点是先复制父节点的部分，再加上当前所遍历的元素
			ArrayList<Integer> subNode = new ArrayList<>(
					parentNode);
			subNode.add(nums[i]);

			// 添加到结果
			res.add(subNode);

			// 通过 start 参数控制树枝的遍历，避免产生重复的子集
			backtrack(subNode, nums, i + 1, res);
		}
	}
}

/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * HJ44 Sudoku.
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，
 * 推算出所有剩余空格的数字，并且满足每一行、每一列、每一个粗线宫内的数字均含1-9，并且不重复
 * 输入：包含已知数字的9X9盘面数组（空缺位以数字0表示）
 * 输出：完整的9X9盘面数组
 * 输入描述:包含已知数字的9X9盘面数组（空缺位以数字0表示）
 * 输出描述:完整的9X9盘面数组
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-23
 */
public class HJ044Sudoku {
	private static final int N = 9;

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);

		List<Grid> zeroGridList = new ArrayList<>();

		// 输入的数组arr[n][m]的值0表示空格
		int[][] arr = new int[N][N];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int gridValue = in.nextInt();
				arr[i][j] = gridValue;

				if (gridValue == 0) {
					zeroGridList.add(new Grid(index, i, j));
					index++;
				}
			}
		}

		// 执行
		Stack<Grid> gridStack = new Stack<>();

		// 记录下个格子
		int nextIdex = 0;
		while (nextIdex < zeroGridList.size()) {
			nextIdex = doSudoku(arr, gridStack,
					zeroGridList.get(nextIdex), false);
		}

		// 输出
		for (int i = 0; i < N; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]);
				sb.append(" ");
			}

			System.out.println(sb.toString().trim());
		}

		// 关闭
		in.close();
	}

	private static int doSudoku(int[][] arr,
			Stack<Grid> gridStack, Grid zeroGrid,
			boolean isPreviousGrid) {
		Queue<Integer> candidates = zeroGrid.candidates;

		// 如果是从栈里面找出来的格子，说明之前已经查过候选人，无需重新再查
		if (!isPreviousGrid) {
			candidates = selectCandidate(arr, zeroGrid.x,
					zeroGrid.y);
			zeroGrid.candidates = candidates;
		}

		if (!candidates.isEmpty()) {
			// 从候选里面取一个
			int candidate = candidates.poll();
			arr[zeroGrid.x][zeroGrid.y] = candidate;
			gridStack.add(zeroGrid);

			return zeroGrid.index + 1;
		} else {
			// 找不到候选人，说明前面的空格填的有问题
			// 回退到上一个格子找后续的候选人
			Grid previousGrid = gridStack.pop();
			arr[previousGrid.x][previousGrid.y] = 0;

			return doSudoku(arr, gridStack, previousGrid,
					true);
		}

	}

	// 查找候选人列表
	private static Queue<Integer> selectCandidate(
			int[][] arr, int x, int y) {
		Queue<Integer> candidates = new ArrayBlockingQueue<>(
				N);

		for (int candidate = 1; candidate <= N; candidate++) {
			// 先探行，再探列，再探九宫格
			for (int j = 0; j < N; j++) {
				if (!contains(arr[x], candidate)
						&& !containsColumn(arr, y,
								candidate)
						&& !containsGrid(arr, x, y,
								candidate)) {
					candidates.add(candidate);

					break;
				}
			}
		}

		return candidates;
	}

	// 判断是否包含在行里
	private static boolean contains(int[] a, int val) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == val) {
				return true;
			}
		}
		return false;
	}

	// 判断是否包含在列里
	private static boolean containsColumn(int[][] a,
			int column, int val) {
		for (int i = 0; i < a.length; i++) {
			if (a[i][column] == val) {
				return true;
			}
		}
		return false;
	}

	// 是否包含在九宫格里面
	private static boolean containsGrid(int[][] a, int x,
			int y, int val) {
		// 找到所在九宫格的左上角
		int gridX = (x / 3) * 3;
		int gridY = (y / 3) * 3;

		for (int i = gridX; i < gridX + 3; i++) {
			for (int j = gridY; j < gridY + 3; j++) {
				if (a[i][j] == val) {
					return true;
				}
			}
		}

		return false;
	}

	private static class Grid {
		public int index;

		public int x;

		public int y;

		public Queue<Integer> candidates = new ArrayBlockingQueue<>(
				N);

		public Grid(int index, int x, int y) {
			this.index = index;
			this.x = x;
			this.y = y;
		}
	}
}

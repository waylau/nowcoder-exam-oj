/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.jianzhi;

import java.util.Stack;

/**
 * JZ31 栈的压入、弹出序列.
 * 描述：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-11-17
 */
public class JZ031StackPushInAndPopOutSequences {

    public static void main(String[] args) {
		// 输入： [1,2,3,4,5],[4,5,3,2,1]
		System.out.println(
				isPopOrder(new int[] { 1, 2, 3, 4, 5 },
						new int[] { 4, 5, 3, 2, 1 }));

		// 输入： [1,2,3,4,5],[4,3,5,1,2]
		System.out.println(
				isPopOrder(new int[] { 1, 2, 3, 4, 5 },
						new int[] { 4, 3, 5, 1, 2 }));

		// 输入： [2,1,0],[1,2,0]
		System.out.println(isPopOrder(new int[] { 2, 1, 0 },
				new int[] { 1, 2, 0 }));
    }

    private static boolean isPopOrder(int[] pushA, int[] popA) {
		Stack<Integer> stack = new Stack<Integer>();

		int length = pushA.length;
		int j = 0;

		// 阶段1：入栈
		for (int i = 0; i < length; i++) {

			int a = pushA[i];
			// 遍历pushA将元素入栈到stack
			stack.add(a);

			while (!stack.isEmpty()) {
				// stack的栈顶元素`pushA[i]`与popA中的当前元素`popA[j]`进行比较
				int b = popA[j];
				if (stack.peek() == b) {
					// 如果两个相等，stack的栈顶元素从stack出栈，则取pushA、popA中的下一个元素进行比较
					stack.pop();
					j++;
				} else {
					break;
				}
			}

		}

		// 阶段2：出栈
		while (!stack.isEmpty()) {
			int a = stack.pop();
			int b = popA[j];

			if (a == b) {
				j++;
			} else {
				break;
			}
		}

		// 如果stack为空，popA也遍历完了，则结果为true；否则结果为false
		return (j == length);
	}
}

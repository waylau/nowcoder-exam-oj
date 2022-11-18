/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.Stack;

/**
 * NC175 合法的括号字符串.
 * 给定一个字符串s，字符串s只包含以下三种字符: (，*，)，请你判断 s是不是一个合法的括号字符串。合法括号字符串有如下规则:
 * 1.左括号'('必须有对应的右括号')'
 * 2.右括号')'必须有对应的左括号'('
 * 3.左括号必须在对应的右括号前面
 * 4.*可以视为单个左括号，也可以视为单个右括号，或者视为一个空字符
 * 5.空字符串也视为合法的括号字符串
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-18
 */
public class NC175LegalParenthesisString {

    public static void main(String[] args) {
        // 输入："()()"
        // 返回值：true
        System.out.println(isValidString("()()"));
        
        // 输入： "((*)"
        // 返回值： true
        System.out.println(isValidString("((*)"));
        
        // 输入： "(*)"
        // 返回值： true
        System.out.println(isValidString("(*)"));
        
        // 输入： "(((*)"
        // 返回值： false
        System.out.println(isValidString("(((*)"));
    }
    
    private static boolean isValidString (String s) {    
		// 新建两个栈left、star，分别记录未匹配的左括号和*号对应下标
		Stack<Integer> left = new Stack<>();
		Stack<Integer> star = new Stack<>();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			// 左括号下标入栈
			if (c == '(') {
				left.push(i);
			}
			// *号下标入栈
			else if (c == '*') {
				star.push(i);
			}
			// 如果是右括号
			else {
				// 首先匹配左括号
				if (!left.isEmpty()) {
					left.pop();
				}
				// 其次匹配*号
				else if (!star.isEmpty()) {
					star.pop();
				}
				// 如果都没有，说明有右括号找不到匹配对象
				else {
					return false;
				}
			}
		}
		// 检查未匹配的左括号和*号
		while (!left.isEmpty() && !star.isEmpty()) {
			int top1 = left.pop();
			int top2 = star.pop();
			// 每一个左括号都必须有一个*号（视为右括号）与之匹配
			if (top1 > top2) {
				return false;
			}
		}
		return left.isEmpty();
	}

}

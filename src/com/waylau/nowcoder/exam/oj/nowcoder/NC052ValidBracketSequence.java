/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;
 
import java.util.Stack;

 
/**
 * NC52 有效括号序列.
 * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，
 * 判断给出的字符串是否是合法的括号序列
 * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-11-17
 */
public class NC052ValidBracketSequence {

    public static void main(String[] args) {
        // 输入：[
        System.out.println(isValid("["));
     
        // 输入：[]
        System.out.println(isValid("[]"));
    }
    
    private static boolean isValid (String s) {     
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i<charArray.length; i++) {
            char ch = charArray[i];

            // 空就入栈
            // 否则判断是入栈还是出栈
            if (stack.isEmpty()) {
                // 遍历将元素入栈到stack
                stack.add(ch);
            } else {
                if (isPair(stack.peek(), ch)) {
                    // 如果两个相等，stack的栈顶元素从stack出栈，则取下一个元素进行比较
                    stack.pop();
                } else {
                    // 遍历将元素入栈到stack
                    stack.add(ch);
                }  
            }
        }
        
        return stack.isEmpty();
    }
    
    // 判断是否成对
    private static boolean isPair(char a, char b) {
        boolean isPair =  false ;
        
        if (a == '(' && b ==')') {
            isPair = true;
        } 
      
        if (a == '{' && b =='}') {
            isPair = true;
        }
        
        if (a == '[' && b ==']') {
            isPair = true;
        }
        
        return isPair;
    }

}

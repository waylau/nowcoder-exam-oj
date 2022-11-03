/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

 
/**
 * NC228 判断子序列
 * 给定两个字符串 S 和 T ，判断 S 是否是 T 的子序列。
 * 即是否可以从 T 删除一些字符转换成 S。
 * 保证字符串中仅含有小写字母
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-03
 */
public class NC228JudgmentSubsequence2 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("nowcoder", "nowcoder"));
        System.out.println(isSubsequence("nower", "nowcoder"));
        System.out.println(isSubsequence("nowef", "nowcoder"));
    }

    private static boolean isSubsequence(String s, String t) {
    	// 记录结果
        int count = 0;
        
        // s的位置
    	int i = 0;
    	
    	// t的位置
    	int j = 0;
    	
        while (i < s.length() && j<t.length()) {
        	// 如果字符相同，则同时后移；
        	// 否则，只是t往后移；
        	if (s.charAt(i) == t.charAt(j)) {
        		i++;
        		j++;
        		count++;
        	} else {
        		j++;
        	}
        }
        
        return count == s.length();
    }
 
}

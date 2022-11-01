/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

/**
 * NC44 通配符匹配
 * 请实现支持'?'and'*'.的通配符模式匹配
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任何字符序列（包括空序列）。
 * 返回两个字符串是否匹配
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-01
 */
public class NC044WildcardMatching {

    public static void main(String[] args) {
    	// 输出
        System.out.println(isMatch("", "*"));
        
        // 输出
        System.out.println(isMatch("ab", "?*"));

        // 输出
        System.out.println(isMatch("ab", "*"));

        // 输出
        System.out.println(isMatch("hhhhhhhahhaahhahhhhaaahhahhahaaahhahahhhahhhahaaahaah", "h*h*ah**ha*h**h***hha"));

        // 输出
        System.out.println(isMatch("abcd", "*?******bc**?*"));
    }

    private static boolean isMatch(String s, String p) {
        // 缩减*号，优化性能
        p = shortAsterisk(p);

        // 输出
        return isMatch(p, s, 0, 0);
    }

    private static boolean isMatch(String wildcard, String str, int wildcardP, int strP) {
        // 两个字符串同时结束,返回true
        if ((wildcard.length() == wildcardP) && (str.length() == strP)) {
            return true;
        }
        
        if ((wildcard.length() == wildcardP) && (str.length() != strP)) {
            return false;
        }

        if ((wildcard.length() != wildcardP) && (str.length() == strP)) {
            // wildcardArray从wildcardP位置后面全是* 匹配结果为 True
            // wildcardArray从wildcardP位置后面不全是* 匹配结果为 False
            for (int i = wildcardP; i < wildcard.length(); i++) {
                if (wildcard.charAt(i) != '*') {
                    return false;
                }
            }

            return true;
        }

        char currentWildcard = wildcard.charAt(wildcardP);

        if (currentWildcard == '?') {
            // 跳过，直接看下一位
            isMatch(wildcard, str, wildcardP + 1, strP + 1);
        } else if (currentWildcard == '*') {
            // 有三种选择：
            // 1、匹配0个，通配符向后移动一个字符，字符串不动；
            // 2、匹配1个，通配符和字符串都向后移动一个字符；
            // 3、匹配多个，通配符不动，字符串向后移动一个字符。
            return isMatch(wildcard, str, wildcardP + 1, strP) 
            		|| isMatch(wildcard, str, wildcardP + 1, strP + 1)
                || isMatch(wildcard, str, wildcardP, strP + 1);

        } else if (currentWildcard == str.charAt(strP)) {
        	// 两个字符相等
            // 跳过，直接看下一位
            isMatch(wildcard, str, wildcardP + 1, strP + 1);
        } else {
            return false;
        }

        return isMatch(wildcard, str, wildcardP + 1, strP + 1);
    }

    // 缩减*号
    private static String shortAsterisk(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;

        // 只有1个元素直接返回了
        if (len <= 1) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            // 如果前面的也是*，说明有连续*，丢掉本次的*
            if (arr[i] == '*' && arr[i - 1] == '*') {
                // do nothing
            } else {
                sb.append(arr[i]);
            }
        }

        return sb.toString();
    }
}

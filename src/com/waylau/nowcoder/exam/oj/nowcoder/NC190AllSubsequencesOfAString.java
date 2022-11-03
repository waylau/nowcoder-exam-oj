/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * NC190 字符串的全部子序列
 * 给定一个字符串s，长度为n，求s的所有子序列
 * 1.子序列: 指一个字符串删掉部分字符（也可以不删）形成的字符串，可以是不连续的，
 * 比如"abcde"的子序列可以有"ace","ad"等等
 * 2.将所有的子序列的结果返回为一个字符串数组
 * 3.字符串里面可能有重复字符，但是返回的子序列不能有重复的子序列，
 * 比如"aab"的子序列只有"","a","aa","aab","ab","b"，不能存在2个相同的"ab"
 * 4.返回字符串数组里面的顺序可以不唯一
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-03
 */
public class NC190AllSubsequencesOfAString {

    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        System.out.println(generatePermutation("ab"));

        System.out.println(generatePermutation("dbcq"));

        System.out.println(generatePermutation("aab"));
    }

    private static String[] generatePermutation(String s) {
        result = new HashSet<>();

        solve(s, 0, "");

        return result.toArray(new String[0]);
    }

    private static void solve(String s, int startIndex, String subStr) {
        // 终止条件
        if (startIndex == s.length()) {
            // 收集结果
            result.add(subStr);

            return;
        }

        // 选择或者不选
        solve(s, startIndex + 1, subStr + (s.charAt(startIndex)));
        solve(s, startIndex + 1, subStr);
    }
}

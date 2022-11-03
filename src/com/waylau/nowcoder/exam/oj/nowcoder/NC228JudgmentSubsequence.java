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
public class NC228JudgmentSubsequence {
    // 记录结果
    private static int count = 0;

    // t的遍历位置
    private static int startIndex = 0;

    public static void main(String[] args) {
        System.out.println(isSubsequence("nowcoder", "nowcoder"));
        System.out.println(isSubsequence("nower", "nowcoder"));
        System.out.println(isSubsequence("nowef", "nowcoder"));
    }

    private static boolean isSubsequence(String s, String t) {
        // 初始化
        count = 0;
        startIndex = 0;

        // 没有命中，则查找startIndex的后续位置
        for (int i = 0; i < s.length(); i++) {
            solve(s.charAt(i), t);
        }

        return count == s.length();
    }

    private static void solve(char sChar, String t) {
        // 命中，则返回
        if (t.charAt(startIndex) == sChar) {
            // 结果计数
            count++;
            startIndex++;
            return;
        }
        
        startIndex++;
        // 没有命中，则查找startIndex的后续位置
        if ((startIndex) < t.length()) {
            solve(sChar, t);
        }
    }
}

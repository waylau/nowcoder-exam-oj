/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

/**
 * NC92 最长的公共子序列（二）
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。
 * 如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-01
 */
public class NC092LongestCommonSubsequence {

    public static void main(String[] args) {
        // 用例1
        System.out.println(getLongestCommonSubsequence("1A2C3D4B56", "B1D23A456A"));
        
        // 用例2
        System.out.println(getLongestCommonSubsequence("abc","def"));
        
        // 用例3
        System.out.println(getLongestCommonSubsequence("abc","abc"));
        
        // 用例4
        System.out.println(getLongestCommonSubsequence("ab",""));
    }

    private static String getLongestCommonSubsequence(String str1, String str2) {
        // 给定两个字符串str1和str2，假设长度分别为len1和len2，
        int len1 = str1.length();
        int len2 = str2.length();

        // 创建一个len1+1行和len2+1列的二维数组dp。
        // 其中dp[i][j]表示str1[0:i]和str2[0:j]的最长公共子序列，
        // str1[0:i]表示str1长度为i的前缀，str2[0:j]表示str2长度为j的前缀。
        int dp[][] = new int[len1 + 1][len2 + 1];

        // 考虑动态规划的边界问题。
        // 当i=0时， str1[0:i]为空，空字符串和任意字符串的最长公共子序列的长度都是0，因此对于有0<=j<=len2 有dp[0][j]=0；
        // 当j=0时， str2[0:j]为空，空字符串和任意字符串的最长公共子序列的长度都是0，因此对于有0<=i<=len1 有dp[i][0]=0。
        // 因此动态规划的边界情况是：当 i=0 或 j=0 时， dp[i][j]=0。

        // 当 i>0且 j>0时，考虑 dp[i][j] 的计算：
        // 当str1 [i-1]= str2[j-1] 时，将这两个相同的字符称为公共字符,
        // 考虑str1 [0:i−1] 和 str2 [0:j−1] 的最长公共子序列，
        // 再增加一个字符（即公共字符）即可得到str1 [0:i] 和 str2 [0:j] 的最长公共子序列，因此dp[i][j]=dp[i−1][j−1]+1。
        // 当str1 [i-1]!= str2[j-1] 时，考虑以下两项：
        // str1 [0:i−1] 和str2[0:j] 的最长公共子序列；
        // str1 [0:i] 和str2[0:j−1] 的最长公共子序列。
        // 要得到str1[0:i]和str2[0:j]的最长公共子序列，应取两项中的长度较大的一项，因此dp[i][j]=max(dp[i−1][j],dp[i][j−1])。
        for (int i = 1; i <= len1; i++) {
            char ch1 = str1.charAt(i - 1);
            for (int j = 1; j <= len2; j++) {
                char ch2 = str2.charAt(j - 1);
                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 从二维数组dp中获取字符串
        StringBuffer sb = new StringBuffer();
        while (len1 > 0 && len2 > 0) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                sb.append(str1.charAt(len1 - 1));
                len1--;
                len2--;
            } else {
                if (dp[len1 - 1][len2] > dp[len1][len2 - 1]) {
                    len1--;
                } else {
                    len2--;
                }
            }
        }
        if (sb.length() == 0) {
            return "-1";
        }

        return sb.reverse().toString();
    }
}

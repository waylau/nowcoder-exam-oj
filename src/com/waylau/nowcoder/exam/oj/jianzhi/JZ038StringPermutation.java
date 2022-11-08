/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.jianzhi;
 
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
 
/**
 * JZ38 字符串的排列
 * 
 * 输入一个长度为 n 字符串，打印出该字符串中字符的所有排列，你可以以任意顺序返回这个字符串数组。
 * 例如输入字符串ABC,则输出由字符A,B,C所能排列出来的所有字符串ABC,ACB,BAC,BCA,CBA和CAB。
 * 输入描述：
 * 输入一个字符串,长度不超过10,字符只包括大小写字母。
 * 
 * 示例1
 * 输入：
 * "ab"
 * 返回值：
 * ["ab","ba"]
 * 说明：
 * 返回["ba","ab"]也是正确的
 * 
 * 示例2
 * 输入：
 * "aab"
 * 返回值：
 * ["aab","aba","baa"]
 * 
 * 示例3
 * 输入：
 * "abc"
 * 返回值：
 * ["abc","acb","bac","bca","cab","cba"]
 * 
 * 示例4
 * 输入：
 * ""
 * 返回值：
 * [""]
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-04
 */
public class JZ038StringPermutation {

    private static List<String> res = new LinkedList<>();
    private static char[] c;
    
    public static void main(String[] args) {
        System.out.println(permutation("ab"));
        
        System.out.println(permutation("aab"));
        
        System.out.println(permutation("abc"));
        
        System.out.println(permutation(""));
    }

    private static String[] permutation(String s) {
        res = new LinkedList<>();
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    
    private static void dfs(int x) {
        if(x == c.length - 1) {
            res.add(String.valueOf(c));      // 添加排列方案
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue; // 重复，因此剪枝
            }
            
            set.add(c[i]);
            swap(i, x);                      // 交换，将 c[i] 固定在第 x 位
            dfs(x + 1);                      // 开启固定第 x + 1 位字符
            swap(i, x);                      // 恢复交换
        }
    }
    
    private static void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}

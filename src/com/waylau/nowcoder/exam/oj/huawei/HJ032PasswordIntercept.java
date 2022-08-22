/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ32 密码截取.
 * 描述：该题目是一道密码加密题，密码混合在复杂字符串中，是一个对称子字符串，
 * 比如12321AABC，则真正要提取的是12321，因为它是对称的，
 * 所以需要写一个程序来实现快速的提取。题目要求提取最长的密码长度。
 * 输入描述：输入一个字符串
 * 输出描述：返回有效密码串的最大长度
 * 示例：
 * 输入：12321AABC
 * 输出：5
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-17
 */
public class HJ032PasswordIntercept {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        // 转为字符
        char[] array = in.toCharArray();

        // 不管怎么样，如果没有形成
        int len = 1;
        int maxLen = 1;
        
        // 先处理ABA型
        for (int i = 1; i < array.length - 2; i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 1;

            // 向左、向右尝试，不要超过边界
            while (leftIndex >= 0 && rightIndex <= array.length - 1) {
                // 左右对称，则尝试下个位置
                if (array[leftIndex] == array[rightIndex]) {
                    len = rightIndex - leftIndex + 1;
                    leftIndex--;
                    rightIndex++;

                    // 记录最大值
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }

        // 再处理ABBA型
        for (int i = 1; i < array.length - 2; i++) {
            int leftIndex = i - 1;
            int rightIndex = i + 2;

            // 向左、向右尝试，不要超过边界
            while (leftIndex >= 0 && rightIndex <= array.length - 1) {
                // 左右对称，则尝试下个位置
                if ((array[i] == array[i+1]) && (array[leftIndex] == array[rightIndex])) {
                    len = rightIndex - leftIndex + 1;
                    leftIndex--;
                    rightIndex++;

                    // 记录最大值
                    maxLen = Math.max(maxLen, len);
                } else {
                    break;
                }
            }
        }
        
        
        // 输出
        System.out.println(maxLen);

        // 关闭
        sc.close();
    }
}

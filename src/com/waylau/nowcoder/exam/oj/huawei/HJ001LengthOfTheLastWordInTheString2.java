/*
* Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ1 字符串最后一个单词的长度.
 * 描述：计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-05
 */
public class HJ001LengthOfTheLastWordInTheString2 {

    public static void main(String[] args) {
        // 输入一行，代表要计算的字符串，非空，长度小于5000。
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        
        // 对输入字符串进行倒序遍历，遇到第一个空格则停止.
        // 遍历的非空字符数即为最后一个单词的长度
        int lastWordLength = 0;
        for (int i = in.length() -1 ; i >=0; i--) {
            char c = in.charAt(i);
            
            if (c == ' ') {
                break;
            }
            
            lastWordLength ++;
        }
        
        // 输出一个整数，表示输入字符串最后一个单词的长度。
        System.out.println(lastWordLength);
        
        // 关闭资源
        sc.close();
    }
}

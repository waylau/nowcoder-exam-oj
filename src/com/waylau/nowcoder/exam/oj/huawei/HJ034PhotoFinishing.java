 /*
  *  Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 描述：Lily上课时使用字母数字图片教小朋友们学习英语单词，
 * 每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。
 * 请大家给Lily帮忙，通过代码解决。
 * 数据范围：每组输入的字符串长度满足 【0 - 1000】
 * 输入描述：Lily使用的图片包括"A"到"Z"、“a"到"z”、“0"到"9”。
 * 输入字母或数字个数不超过1024。
 * 输出描述：Lily的所有图片按照从小到大的顺序输出
 * 示例1
 * 输入：Ihave1nose2hands10fingers
 * 输出：0112Iaadeeefghhinnnorsssv
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ034PhotoFinishing {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()) {
            String in = sc.nextLine();
            
            // 输出
            System.out.println(sort(in));
        }

        // 关闭
        sc.close();
    }
    
    private static String sort(String str) {
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        
        for (char ch : arr) {
            list.add(ch);
        }
        
        list.sort(Comparator.naturalOrder());
        
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }
        
        return sb.toString();
    }
}

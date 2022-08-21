 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * HJ26 字符串排序.
 * 描述：编写一个程序，将输入字符串中的字符按如下规则排序。
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 * 如，输入： Type 输出： epTy
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 * 如，输入： BabA 输出： aABb
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 * 如，输入： By?e 输出： Be?y
 * 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-16
 */
public class HJ026StringSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(sort(sc.nextLine()));
        sc.close();
    }

    private static String sort(String s) {
        // 定义字母列表
        List<Character> letterList = new ArrayList<>();

        // 将字符串转换成字符数组，遍历每一个字符，是字符则添加到列表中
        for (Character c : s.toCharArray()) { 
            if (Character.isLetter(c)) {
                letterList.add(c);
            }
        }
        
        // 按照小写英文字母排序规则排序
        letterList.sort(Comparator.comparingInt(Character::toLowerCase));
        
        StringBuilder result = new StringBuilder();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                result.append(letterList.get(j++));
            } else {
                // 若是非英文字母则直接添加
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
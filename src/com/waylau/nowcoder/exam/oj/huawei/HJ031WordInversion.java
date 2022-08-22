 /* 
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 描述：对字符串中的所有单词进行倒排。
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；
 * 如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 * 输入描述:输入一行以空格来分隔的句子
 * 输出描述:输出句子的逆序
 * 示例1
 * 输入：I am a student
 * 输出：student a am I
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-17
 */
public class HJ031WordInversion {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        // 转为字符
        char[] array = in.toCharArray();

        char[] temp = new char[20];
        int i = 0;
        boolean skip = false;
        List<String> list = new ArrayList<>();

        for (char ch : array) {
            if (Character.isUpperCase(ch) || Character.isLowerCase(ch)) {
                temp[i] = ch;
                skip = false;
                i++;
            } else {
                // 忽略连续的非字母
                if (!skip) {
                    list.add(charToString(Arrays.copyOf(temp, i)));
                    skip = true;

                    // 缓存复原
                    temp = new char[20];
                    i = 0;
                }
            }
        }

        if (i > 0) {
            list.add(charToString(Arrays.copyOf(temp, i)));
        }

        // 倒序
        StringBuilder sb = new StringBuilder();
        for (int k = list.size() - 1; k >= 0; k--) {
            sb.append(list.get(k));
            sb.append(" ");
        }

        // 输出
        System.out.println(sb.toString().trim());

        // 关闭
        sc.close();
    }

    public static String charToString(char[] chArray) {
        StringBuilder sb = new StringBuilder();

        for (char ch : chArray) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

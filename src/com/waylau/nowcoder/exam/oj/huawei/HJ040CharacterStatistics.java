 /* 
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 描述：输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 * 本题包含多组输入。
 * 数据范围：输入的字符串长度满足 【1，1000】
 * 输入描述：输入一行字符串，可以有空格
 * 输出描述：统计其中英文字符，空格字符，数字字符，其他字符的个数
 * 示例1
 * 
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 
 * 输出：
 * 26
 * 3
 * 10
 * 12
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ040CharacterStatistics {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        char[] arr = in.toCharArray();

        // 字母
        int letterCount = 0;

        // 空格字符
        int emptyCount = 0;

        // 数字字符
        int digitCount = 0;

        // 其他字符
        int otherCount = 0;

        for (char ch : arr) {
            if (Character.isLetter(ch)) {
                letterCount++;
            } else if (ch == ' ') {
                emptyCount++;
            } else if (Character.isDigit(ch)) {
                digitCount++;
            } else {
                otherCount++;
            }
        }

        // 输出
        System.out.println(letterCount);
        System.out.println(emptyCount);
        System.out.println(digitCount);
        System.out.println(otherCount);

        // 关闭
        sc.close();
    }
}

/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ21 简单密码.
 * 描述：现在有一种密码变换算法。
 * 九键手机键盘上的数字与字母的对应： 1–1， abc–2, def–3, ghi–4, jkl–5, 
 * mno–6, pqrs–7, tuv–8 wxyz–9, 0–0，把密码中出现的小写字母都变成九键键盘对应的数字，
 * 如：a 变成 2，x 变成 9.
 * 而密码中出现的大写字母则变成小写之后往后移一位，如：X ，先变成小写，再往后移一位，变成了 y ，
 * 例外：Z 往后移是 a 。
 * 数字和其它的符号都不做变换。
 * 数据范围： 输入的字符串长度满足 1≤n≤100
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-15
 */
public class HJ021SimplePassword {
    private static final String BIG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String SMALL = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String in = sc.nextLine();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < in.length(); i++) {
                String str = in.substring(i, i + 1);

                //  字符的分类。分为大写字母、小写字母和其他。这三类要分别处理。
                if (BIG.contains(str)) {
                    // 大写字母的处理。转为小写，而后往后一位。可以将所有的小写字母用一个数组表示。
                    sb.append(convertBigToSmall(str));
                } else if (SMALL.contains(str)) {
                    // 小写字母转为对应的数字。
                    sb.append(convertSmallToNumber(str));
                } else {
                    // 其他保持不变。
                    sb.append(str);
                }
            }

            // 输出
            System.out.println(sb.toString());
        }

        // 关闭
        sc.close();
    }

    private static String convertBigToSmall(String str) {
        String result = "";
        // 先找到字母在大写字符串中的索引位置
        // 而后索引位置+1 ，再找小写字符串的索引位置
        // 索引越界则置为0；
        for (int i = 0; i < BIG.length(); i++) {
            String currentStr = BIG.substring(i, i + 1);

            if (currentStr.equals(str)) {
                int j = i + 1;
                if (j == 26) {
                    j = 0;
                }

                result = SMALL.charAt(j) + "";
                break;
            }
        }

        return result;
    }

    private static int convertSmallToNumber(String str) {
        int result = 0;
        // 先找到字母在小写字符串的索引位置
        // 根据索引位置进行分组，范围对应的组的数字
        for (int i = 0; i < SMALL.length(); i++) {
            String currentStr = SMALL.substring(i, i + 1);

            if (currentStr.equals(str)) {
                if (0 <= i && i <= 2) {
                    result = 2;
                } else if (3 <= i && i <= 5) {
                    result = 3;
                } else if (6 <= i && i <= 8) {
                    result = 4;
                } else if (9 <= i && i <= 11) {
                    result = 5;
                } else if (12 <= i && i <= 14) {
                    result = 6;
                } else if (15 <= i && i <= 18) {
                    result = 7;
                } else if (19 <= i && i <= 21) {
                    result = 8;
                } else if (22 <= i && i <= 25) {
                    result = 9;
                } else {
                    // 啥都不干
                }

                break;
            }
        }

        return result;
    }
}

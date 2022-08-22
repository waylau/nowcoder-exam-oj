/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 描述：Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * 如22：twenty two，123：one hundred and twenty three。
 * 说明：数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；输出格式为twenty two；
 * 非法数据请返回“error”；关键字提示：and，billion，million，thousand，hundred。
 * 输入描述：输入一个long型整数
 * 输出描述：输出相应的英文写法
 * 示例1
 * 输入：2356
 * 输出：two thousand three hundred and fifty six
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-19
 */
public class HJ042LearnEnglish {

    private static final String[] ONE_TO_NINE =
        {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    private static final String[] TEN_TO_NINETEEN =
        {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

    private static final String[] TWENTY_TO_NINETY =
        {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

    private static final String HUNDRED = "hundred";

    private static final String THOUSAND = "thousand";

    private static final String MILLION = "million";

    private static final String AND = "and";

    private static final String SPACE = " ";

    private static final String ERROR = "error";

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 输出
        System.out.println(translate(n));

        // 关闭
        in.close();
    }

    private static String translate(int n) {
        String result = ERROR;

        if (1 <= n && n <= 9) {
            result = ONE_TO_NINE[n - 1];
        } else if (10 <= n && n <= 19) {
            result = TEN_TO_NINETEEN[n - 10];
        } else if (20 <= n && n <= 99) {
            String tensPlace = (n + "").substring(0, 1);
            String onesPlace = (n + "").substring(1, 2);

            int tensPlaceNumber = Integer.valueOf(tensPlace);
            int onesPlaceNumber = Integer.valueOf(onesPlace);

            StringBuilder sb = new StringBuilder();
            sb.append(TWENTY_TO_NINETY[tensPlaceNumber - 2]);

            if (onesPlaceNumber > 0) {
                sb.append(SPACE);
                sb.append(ONE_TO_NINE[onesPlaceNumber - 1]);
            }

            result = sb.toString();

        } else if (100 <= n && n <= 999) {
            String hundredsPlace = (n + "").substring(0, 1);
            String otherPlace = (n + "").substring(1, 3);

            int hundredsPlaceNumber = Integer.valueOf(hundredsPlace);
            int otherPlaceNumber = Integer.valueOf(otherPlace);

            StringBuilder sb = new StringBuilder();
            sb.append(ONE_TO_NINE[hundredsPlaceNumber - 1]);
            sb.append(SPACE);
            sb.append(HUNDRED);

            if (otherPlaceNumber > 0) {
                sb.append(SPACE);
                sb.append(AND);
                sb.append(SPACE);

                // 递归调用
                sb.append(translate(otherPlaceNumber));
            }

            result = sb.toString();

        } else if (1000 <= n && n <= 999999) {
            // 先判断位数
            int length = getNumberLength(n);

            String thousandPlace = (n + "").substring(0, length - 3);
            String otherPlace = (n + "").substring(length - 3, length);

            int thousandPlaceNumber = Integer.valueOf(thousandPlace);
            int otherPlaceNumber = Integer.valueOf(otherPlace);

            StringBuilder sb = new StringBuilder();

            // 递归调用
            sb.append(translate(thousandPlaceNumber));
            sb.append(SPACE);
            sb.append(THOUSAND);

            if (otherPlaceNumber > 0) {
                sb.append(SPACE);

                // 递归调用
                sb.append(translate(otherPlaceNumber));
            }

            result = sb.toString();
        } else if (1000000 <= n && n <= 999999999) {
            // 先判断位数
            int length = getNumberLength(n);

            String millionPlace = (n + "").substring(0, length - 6);
            String otherPlace = (n + "").substring(length - 6, length);

            int millionPlaceNumber = Integer.valueOf(millionPlace);
            int otherPlaceNumber = Integer.valueOf(otherPlace);

            StringBuilder sb = new StringBuilder();

            // 递归调用
            sb.append(translate(millionPlaceNumber));
            sb.append(SPACE);
            sb.append(MILLION);

            if (otherPlaceNumber > 0) {
                sb.append(SPACE);

                // 递归调用
                sb.append(translate(otherPlaceNumber));
            }

            result = sb.toString();
        } else {
            result = ERROR;
        }

        return result;
    }

    // 判断位长度
    private static int getNumberLength(int num) {
        int count = 0; // 计数
        while (num >= 1) {
            num /= 10;
            count++;
        }
        return count;
    }
}

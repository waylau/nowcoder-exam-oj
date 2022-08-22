 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ33 整数与IP地址间的转换.
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，
 * 然后把这个二进制数转变成一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 组合起来即为：00001010 00000000 00000011 11000001,
 * 转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 数据范围：保证输入的是合法的 IP 序列
 * 输入描述：
 * 输入 
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 输出描述：
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * 示例1
 * 输入：
 * 10.0.3.193
 * 167969729
 * 输出：
 * 167773121
 * 10.3.3.193
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-17
 */
public class HJ033ConversionBetweenIntegerAndIp {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        long decimal = sc.nextLong();

        // 输出
        System.out.println(ipToDecimal(ip));
        System.out.println(decimalToIp(decimal));

        // 关闭
        sc.close();
    }

    private static long ipToDecimal(String ip) {
        String[] arr = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String str = Long.toBinaryString(Long.valueOf(arr[i]));

            // 不够8位就补0
            while (str.length() < 8) {
                str = "0" + str;
            }

            sb.append(str);
        }

        return Long.valueOf(sb.toString(), 2);
    }

    private static String decimalToIp(long decimal) {
        String str = Long.toBinaryString(decimal);

        // 不够32位就补0
        while (str.length() < 32) {
            str = "0" + str;
        }

        String ip = "";
        for (int i = 0; i < 4; i++) {
            String sub = str.substring(i * 8, i * 8 + 8);
            long k = Long.valueOf(sub, 2);

            ip = ip + k;
            if (i < 3) {
                ip = ip + ".";
            }

        }

        return ip;
    }
}

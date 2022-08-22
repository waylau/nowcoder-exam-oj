 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 描述：有一只兔子，从出生后第3个月起每个月都生一只兔子，
 * 小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
 * 输入描述：输入int型表示month
 * 输出描述：输出兔子总数int型
 * 示例1
 * 输入：9
 * 输出：34
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ037CountTheTotalNumberOfRabbitsEachMonth {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        int in = sc.nextInt();

        // 输出
        System.out.println(getRabbitsByMonth(in));

        // 关闭
        sc.close();
    }

    private static int getRabbitsByMonth(int month) {
        // 三个月以上才能生育
        if (month >= 3) {
            return getRabbitsByMonth(month - 1) + getRabbitsByMonth(month - 2);
        } else {
            return 1;
        }
    }
}

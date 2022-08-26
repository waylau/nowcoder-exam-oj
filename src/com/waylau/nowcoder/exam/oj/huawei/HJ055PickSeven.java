 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ55 挑7.
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
 * （一组测试用例里可能有多组数据，请注意处理）
 * 输入描述:一个正整数N。(N不大于30000)
 * 输出描述:不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 * 示例1
 * 输入
 * 20
 * 输出
 * 3
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ055PickSeven {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 输出
        System.out.println(pickSeven(n));

        // 关闭
        in.close();
    }

    private static int pickSeven(int n) {
        int count = 0;

        // 从7算到n行为止。
        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0) {
                count++;
                continue;
            }

            if ((i + "").contains("7")) {
                count++;
                continue;
            }
        }

        return count;
    }
}

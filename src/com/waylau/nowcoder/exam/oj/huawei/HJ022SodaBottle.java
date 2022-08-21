 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ22 汽水瓶.
 * 描述：有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
 * 小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
 * 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，
 * 用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，
 * 喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 * 如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * 输入描述:输入文件最多包含10组测试数据，每个数据占一行，
 * 仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。
 * n=0表示输入结束，你的程序不应当处理这一行。
 * 输出描述:对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-15
 */
public class HJ022SodaBottle {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        // in为0则退出程序
        while (sc.hasNext()) {
            int in = sc.nextInt();
            if (in == 0) {
                break;
            }

            int result = getBottles(in);

            // 输出
            System.out.println(result);
        }

        // 关闭
        sc.close();
    }

	private static int getBottles(int empty) {
		// 边界，余数小于2则没法再兑换了
		if (empty < 2) {
			return 0;
		}

		// 取倍数，作为兑换汽水数
		int j = empty / 2;

		return j;
	}
}

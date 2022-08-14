/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ16 购物单. 输入描述：输入的第 1 行，为两个正整数，用一个空格隔开：N m 
 * （其中 N （ <32000 ，是10的倍数）表示总钱数， m （ <60）为希望购买物品的个数。） 
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q 
 * （其中 v 表示该物品的价格（ v<10000 ，是10的倍数 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 * 如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号） 。
 * 输出描述：输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（<200000 ）。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-11
 */
public class HJ016ShoppingList {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() / 10; // 总钱数，由于是10的倍数，所以先除以10，节省空间
		int m = sc.nextInt();// 总物品数目
		int[][] prices = new int[N + 1][3];
		int[][] weights = new int[m + 1][3];
		sc.nextLine();
		
		for (int i = 1; i <= m; i++) {
			int v = sc.nextInt() / 10; // 需要的钱，由于是10的倍数，所以先除以10，
			int p = sc.nextInt() * v;// 钱*重要度
			int q = sc.nextInt();
			sc.nextLine();
			if (q == 0) {// 主件直接加就行
				prices[i][0] = v;
				weights[i][0] = p;
			} else if (prices[q][1] == 0) {// 从件先试着赋值到主件的第一个位置去
				prices[q][1] = v;
				weights[q][1] = p;
			} else {// 1号有从件后赋值到从件2
				prices[q][2] = v;
				weights[q][2] = p;
			}
		}
		
		int[] dp = new int[N + 1];// 压缩空间到1维
		for (int i = 1; i <= m; i++) {// 遍历所有物品
			for (int j = N; j >= 1; j--) {// 从后向前遍历防止出错
				// 分为四种情况：只放主，放主+从1，放主+从2，放主+从1+从2
				int p1 = prices[i][0];// 从件都为0的
				int w1 = weights[i][0];
				int p2 = prices[i][1];
				int w2 = weights[i][1];
				int p3 = prices[i][2];
				int w3 = weights[i][2];
				
				if (j - p1 >= 0) {
					dp[j] = Math.max(dp[j],	dp[j - p1] + w1);
				}
				if (j - p1 - p2 >= 0) {
					dp[j] = Math.max(dp[j],	dp[j - p1 - p2] + w1 + w2);
				}
				if (j - p1 - p3 >= 0) {
					dp[j] = Math.max(dp[j],	dp[j - p1 - p3] + w1 + w3);
				}
				if (j - p1 - p2 - p3 >= 0) {
					dp[j] = Math.max(dp[j],	dp[j - p1 - p2 - p3] + w1 + w2 + w3);
				}
			}
		}
		
		System.out.println(dp[N] * 10);// 由于是10的倍数，所以乘以10

		sc.close();
	}

}

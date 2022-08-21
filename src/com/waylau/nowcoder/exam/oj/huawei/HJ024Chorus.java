 /*
  *  Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ24 合唱队.
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：N 位同学站成一排，音乐老师要请其中的 (N - K) 位同学出列，
 * 使得剩下的 K 位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为 1，2…，K ，
 * 他们的身高分别为 T1，T2，…，TK ，   
 * 则他们的身高满足存在 i （1<=i<=K） 使得 T1<T2<......<Ti-1<Ti>Ti+1>......>TK 。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 * 注意：不允许改变队列元素的先后顺序 且 不要求最高同学左右人数必须相等
 * 数据范围：1 <= n <= 3000 
 * 输入描述：用例两行数据，第一行是同学的总数 N ，第二行是 N 位同学的身高，以空格隔开
 * 输出描述：最少需要几位同学出列
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-15
 */
public class HJ024Chorus {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int[] left = getAscendingSubsequence(arr);
            int[] right = getDescendingSubsequence(arr);
            
            int max = 0;
            for (int i = 0; i < n; i++) {
                int result = left[i] + right[i] - 1;
                max = Math.max(max, result);
            }

            // 输出
            System.out.println(n - max);
        }

        // 关闭
        sc.close();

    }

    // 上升子序列长度
    private static int[] getAscendingSubsequence(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }

        }
        return result;
    }

    // 递减子序列长度
    private static int[] getDescendingSubsequence(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = 1;
            for (int j = result.length - 1; j > i; j--) {
                if (arr[j] < arr[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }

        }
        return result;
    }
}

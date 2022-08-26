/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ53 杨辉三角的变形.
 * 描述
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，
 * 左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 输入n(n <= 1000000000)
 * 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)等方式读入
 * 输入描述:输入一个int整数
 * 输出描述:输出返回的int值
 * 示例1
 * 输入
 * 4
 * 输出
 * 3
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ053DeformationOfYanghuiTriangle2 {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        
        // 观察规律法
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if(num == 1 || num == 2){
                System.out.println(-1);
                continue;
            }
            else if(num % 4 == 1 || num % 4 == 3){
                System.out.println(2);
                continue;
            }
            else if(num % 4 == 0){
                System.out.println(3);
                continue;
            }
            else if(num % 4 == 2){
                System.out.println(4);
                continue;
            }
        }
        // 关闭
        in.close();
    }
}

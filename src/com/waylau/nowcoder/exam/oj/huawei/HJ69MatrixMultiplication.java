/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ69 矩阵乘法.
 * 1、当矩阵A的列数（column）等于矩阵B的行数（row）时，A与B可以相乘。
 * 2、矩阵C的行数等于矩阵A的行数，C的列数等于B的列数。
 * 3、乘积C的第m行第n列的元素等于矩阵A的第m行的元素与矩阵B的第n列对应元素乘积之和
 * 
 * @since 1.0.0 2022年8月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ69MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //第一个矩阵的行数
            int row1 = sc.nextInt();
            //第一个矩阵的列数
            int column1 = sc.nextInt();
            //第二个矩阵的行数
            int row2 = column1;
            //第二个矩阵的列数
            int column2 = sc.nextInt();
            //矩阵
            int[][] arr1 = new int[row1][column1];
            int[][] arr2 = new int[row2][column2];
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column1; j++) {
                    arr1[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < row2; i++) {
                for (int j = 0; j < column2; j++) {
                    arr2[i][j] = sc.nextInt();
                }
            }
            //定义输出的结果数组
            int[][] result = new int[row1][column2];
            //第一个矩阵的行数等于第二个矩阵的列数
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column2; j++) {
                    for (int k = 0; k < column1; k++) {
                        result[i][j] = result[i][j] + arr1[i][k] * arr2[k][j];
                    }
                }
            }
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < column2; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
        
        sc.close();
    }
}

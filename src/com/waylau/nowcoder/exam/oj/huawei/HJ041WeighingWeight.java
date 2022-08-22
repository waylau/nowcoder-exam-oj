 /*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * HJ41 称砝码.
 * 现有一组砝码，重量互不相等，分别为 m1,m2,m3…mn ；
 * 每种砝码对应的数量为 x1,x2,x3...xn 。
 * 现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * 注：称重重量包括 0
 * 输入描述：
 * 对于每组测试数据：
 * 第一行：n --- 砝码的种数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每种砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每种砝码对应的数量(范围[1,10])
 * 输出描述：
 * 利用给定的砝码可以称出的不同的重量数
 * 
 * 示例1
 * 
 * 输入： 
 * 2
 * 1 2
 * 2 1
 * 
 * 输出：
 * 5
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ041WeighingWeight {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        // Set结构来去重
        HashSet<Integer> set = new HashSet<>();
        
        // 初始化为0，因为0也是一种结果
        set.add(0);
        
        int n = in.nextInt();//个数
        int[] w = new int[n];
        int[] nums = new int[n];
        
        for(int i=0;i<n;i++){
            w[i] = in.nextInt();//砝码的重量
        }
        
        for(int i=0;i<n;i++){
            nums[i] = in.nextInt();//砝码个数
        }
        
        for (int i = 0; i < n; i++) {// 遍历砝码
            List<Integer> list = new ArrayList<>(set);// 取当前所有的结果
            for (int j = 1; j <= nums[i]; j++) {// 遍历个数
                for (int k = 0; k < list.size(); k++) {
                    // 在之前set的结果之上，再累加现有的新砝码的重量，从而变成了新的组合
                    set.add(list.get(k) + w[i] * j);
                }
            }
        }

        // 输出
        System.out.println(set.size());
        
        // 关闭
        in.close();
    }
}

 /*
  *  Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述：若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，
 * 它们能应用于通信加密。现在密码学会请你设计一个程序，
 * 从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，
 * 挑选方案多种多样，例如有4个正整数：2，5，6，13，
 * 如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，
 * 能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。
 * 输入描述：输入说明
 * 1 输入一个正偶数n
 * 2 输入n个整数
 * 注意：数据可能有多组
 * 输出描述：求得的“最佳方案”组成“素数伴侣”的对数。
 * 示例：
 * 输入：
 * 4
 * 2 5 6 13
 * 
 * 2
 * 3 6
 * 输出：
 * 2
 * 
 * 0
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-16
 */
public class HJ028PrimeCompanion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 输入的数字先分好为奇数、偶数两组
        List<Integer> evenList= new ArrayList<>();
        List<Integer> oddList= new ArrayList<>();
        for (int i =0; i<n;i++) {
            int j = sc.nextInt();
            if (isEven(j)) {
                evenList.add(j);
            } else {
                oddList.add(j);
            }
        }
        
        int size = evenList.size();
        int count = 0;
        
        // 已经匹配的数的伴侣
        int[] evensMatch = new int[size];

        for (Integer odd : oddList) {
            // 用于标记对应的数是否查找过
            int[] used = new int[size];

            if (find(odd, evenList, used, evensMatch)) {
                count ++;
            }
        }
        
        // 输出
        System.out.println(count);
        
        // 关闭
        sc.close();
    }
    
    // 质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数
    // 0和1既不是质数也不是合数，最小的质数是2
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    // 偶数可以被2 整除的整数
    private static boolean isEven(int n) {
        if (n % 2 == 0) {
            return true;
        }

        return false;
    }
    
    /**
     * 找到指定数字的素数伴侣
     * 
     * @param odd
     * @param evens
     * @param used
     * @param evensMatch
     * @return
     */
    private static boolean find(int odd, List<Integer> evens, int[] used, int[] evensMatch) {
        // 遍历偶数：去检查当前传入的奇数能否与偶数哪些数匹配
        for (int i = 0; i < evens.size(); i++) {
            // 如果当前偶数与传入的奇数匹配，并且当前偶数位还没有匹配过奇数
            if (isPrime(odd + evens.get(i)) && used[i] == 0) {
                // 设置当前偶数位匹配为true，也就是 1
                used[i] = 1;
                
                // 如果第i个偶数没有伴侣
                // 或者第i个偶数原来有伴侣，并且该伴侣能够重新找到伴侣的话(这里有递归调用)
                // 则奇数odd可以设置为第i个偶数的伴侣
                // 这里采用了匈牙利算法，能让则让
                if (evensMatch[i] == 0 || find(evensMatch[i], evens, used, evensMatch)) {
                    evensMatch[i] = odd;
                    return true;
                }
            }
        }
        
        // 遍历完偶数都没有可以与传入奇数做伴侣的，该奇数只没有配对了
        return false;
    }

}

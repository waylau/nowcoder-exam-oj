 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 描述：假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 
 * 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 数据范围：输入的小球初始高度满足1≤n≤1000 ，且保证是一个整数
 * 输入描述：输入起始高度，int型
 * 输出描述：分别输出第5次落地时，共经过多少米以及第5次反弹多高。
 * 注意：你可以认为你输出保留六位或以上小数的结果可以通过此题。
 * 示例
 * 输入：
 * 1
 * 输出：
 * 2.875
 * 0.03125
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ038ForTheDistanceExperiencedByTheBall {
    private static final BigDecimal TWO = BigDecimal.valueOf(2);
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        BigDecimal in = sc.nextBigDecimal();

        // 输出
        System.out.println(getDistance(in, 5));
        System.out.println(getHight(in, 5));
        
        // 关闭
        sc.close(); 
    }
    
    private static BigDecimal getDistance(BigDecimal hight, int n) {
        // 第5经过的记录为第1次下落的距离+ 第2-4次起落的距离
        BigDecimal dist = hight;
        
        // 首次起落
        BigDecimal before = hight.multiply(TWO);
        
        // 后续的起落距离为前次起落距离的一半
        for (int i = 2; i <= n; i++) {
            before = before.divide(TWO);
            dist = dist.add(before);
        }

        // 首次只有落，没有起，所以减掉高度
        return dist;
    }
    
    private static BigDecimal getHight(BigDecimal hight, int n) {
        // 后续的起落距离为前次起落距离的一半
        for (int i = 1; i <= n ; i++) {
            hight = hight.divide(TWO);
        }

        return hight;
    }
}

/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

/**
 * NC61 两数之和.
 * 描述：给出一个整型数组 numbers 和一个目标值 target，
 * 请在数组中找出两个加起来等于目标值的数的下标，返回的下标按升序排列。
 * （注：返回的数组下标从1开始算起，保证target一定可以由数组里面2个数字相加得到）
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-10-28
 */
public class NC061TheSumOfTwoNumbersInArray {

    public static void main(String[] args) {
        // 输入
        int[] nums = {3, 2, 4};
        int target = 6;

        // 输出
        int[] result = twoSum(nums, target);
        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }

    private static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int length = numbers.length;

        // 每个参与计算的组合，只比较一次，
        for (int i = 0; i < length - 1; i++) { // 因此第一个元素遍历到length -1位置即可
            // 每个参与计算的组合，只比较一次
            int j = i + 1; // 取第一个元素的后一位作为第二个元素
            for (; j < length; j++) {
                // 满足条件，完成、退出
                if (numbers[i] + numbers[j] == target) {
                    // 对结果排序
                    result[0] = i + 1;
                    result[1] = j + 1;

                    break;
                }
            }

        }

        return result;
    }
}
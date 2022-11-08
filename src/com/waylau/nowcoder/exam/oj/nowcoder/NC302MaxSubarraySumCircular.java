/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;

/**
 * NC302 环形数组的连续子数组最大和
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums的非空 连续子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。例如，nums[0] 的前一个数是 nums[n−1]。
 * 示例1
 * 输入：
 * [6,-3,6]
 * 返回值：
 * 12
 * 说明：
 * 从子数组 [6,6] 得到最大和 6 + 6 = 12 
 * 示例2
 * 输入：
 * [4,-2,2,-4]
 * 返回值：
 * 4
 * 说明：
 * 从子数组 [4] 和 [4,-2,2] 都可以得到最大和 4 
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-04
 */
public class NC302MaxSubarraySumCircular {
    private static int maxSum = 0;

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(-3);
        nums.add(6);
        System.out.println(maxSubarraySumCircular(nums));

        nums = new ArrayList<>();
        nums.add(4);
        nums.add(-2);
        nums.add(2);
        nums.add(-4);
        System.out.println(maxSubarraySumCircular(nums));
        
        nums = new ArrayList<>();
        nums.add(-3);
        nums.add(-2);
        nums.add(-3);
        System.out.println(maxSubarraySumCircular(nums));
    }

    private static int maxSubarraySumCircular(ArrayList<Integer> nums) {
        maxSum = nums.get(0);
        int length = nums.size();

        for (int startIndex = 0; startIndex < length; startIndex++) {
            solve(nums, startIndex);
        }

        return maxSum;
    }

    private static void solve(ArrayList<Integer> nums, int start) {
        int size = nums.size();
        int sum = 0;

        for (int i = start; i < start + size; i++) {
            // 处理循环数组的索引
            int realIndex = 0;
            if (i >= size) {
                realIndex = i - size;
            } else {
                realIndex = i;
            }

            sum += nums.get(realIndex);

            // 添加前后的比较
            maxSum = Math.max(maxSum, sum);
        }
    }
}

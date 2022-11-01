/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.HashMap;

/**
 * NC41 最长无重复子数组.
 * 给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长度，无重复指的是所有数字都不相同。
 * 子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-11-01
 */
public class NC041LongestUnduplicatedSubarray {

    public static void main(String[] args) {
        int[] numbers = new int[] {2, 3, 4, 5};
        System.out.println(maxLength(numbers));

        numbers = new int[] {2, 2, 3, 4, 3};
        System.out.println(maxLength(numbers));

        numbers = new int[] {9};
        System.out.println(maxLength(numbers));

        numbers = new int[] {1, 2, 3, 1, 2, 3, 2, 2};
        System.out.println(maxLength(numbers));

        numbers = new int[] {2, 2, 3, 4, 8, 99, 3};
        System.out.println(maxLength(numbers));
    }

    private static int maxLength(int[] arr) {
        // 哈希表记录窗口内非重复的数字
        HashMap<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        // 设置窗口左右边界
        for (int left = 0, right = 0; right < arr.length; right++) {
            // 窗口右移进入哈希表统计出现次数
            if (mp.containsKey(arr[right])) {
                mp.put(arr[right], mp.get(arr[right]) + 1);
            } else {
                mp.put(arr[right], 1);
            }

            // 出现次数大于1，则窗口内有重复
            while (mp.get(arr[right]) > 1) {
                // 窗口右移，同时减去该字符的出现次数
                mp.put(arr[left], mp.get(arr[left++]) - 1);
            }

            // 维护子串长度最大值
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}

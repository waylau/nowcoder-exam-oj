/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * NC46 加起来和为目标值的组合(二)
 * 给出一组候选数 c 和一个目标数 t ，找出候选数中起来和等于 t 的所有组合。
 * c 中的每个数字在一个组合中只能使用一次。
 * 注意：
 * 1. 题目中所有的数字（包括目标数 t ）都是正整数
 * 2. 组合中的数字要按非递减排序
 * 3. 结果中不能包含重复的组合
 * 4. 组合之间的排序按照索引从小到大依次比较，小的排在前面，如果索引相同的情况下数值相同，则比较下一个索引。
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-03
 */
public class NC046TheSumIsTheCombinationOfTheTargetValues {
    private static ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    private static LinkedList<Integer> path = new LinkedList<>();

    private static boolean[] used;

    private static int sum = 0;

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {100, 10, 20, 70, 60, 10, 50}, 80));
    }

    private static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // 先对输入进行升序排序
        Arrays.sort(num);

        // used用于记录已经使用过的元素
        used = new boolean[num.length];

        solve(num, target, 0);

        return result;
    }

    private static void solve(int[] num, int target, int startIndex) {
        // 终止条件
        if (sum == target) {
            // 收集结果
            result.add(new ArrayList(path));
        }

        for (int i = startIndex; i < num.length; i++) {
            // 大于target了就没有必要往后尝试了
            if (sum + num[i] > target) {
                break;
            }

            // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && num[i] == num[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            sum += num[i];
            path.add(num[i]);

            // 每个节点仅能选择一次，所以从下一位开始
            solve(num, target, i + 1);

            used[i] = false;
            sum -= num[i];
            path.removeLast();
        }
    }

}

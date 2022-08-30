/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * HJ77 火车进站.
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，
 * 一共N辆火车，每辆火车以数字1-9编号，火车站只有一个方向进出，
 * 同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求输出所有火车出站的方案，以字典序排序输出。
 * 输入描述：
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 * 输出描述：
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 * 示例1
 * 输入：
 * 3
 * 1 2 3
 * 输出：
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 * 说明：
 * 第一种方案：1进、1出、2进、2出、3进、3出
 * 第二种方案：1进、1出、2进、3进、3出、2出
 * 第三种方案：1进、2进、2出、1出、3进、3出
 * 第四种方案：1进、2进、2出、3进、3出、1出
 * 第五种方案：1进、2进、3进、3出、2出、1出
 * 请注意，[3,1,2]这个序列是不可能实现的。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-29
 */
public class HJ077TheTrainComesIn {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // 待进站的火车
        Queue<Integer> input = new LinkedBlockingQueue<>(n);
        // 进站的火车
        Stack<Integer> stack = new Stack<>();
        // 输出的结果
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            input.add(in.nextInt());
        }

        // 执行
        dfs(input, stack, result);

        // 关闭
        in.close();
    }

    private static void dfs(Queue<Integer> input, Stack<Integer> stack, List<Integer> result) {
        // 栈空，且没有输入了，递归结束
        if (stack.isEmpty() && input.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i : result) {
                sb.append(i);
                sb.append(" ");
            }

            System.out.println(sb.toString().trim());
        }

        // 栈不空，出栈
        if (!stack.isEmpty()) {
            Stack<Integer> stackTemp = new Stack<>();
            stackTemp.addAll(stack);

            List<Integer> resultTemp = new ArrayList<>(result);

            // 出栈先存到到结果列表
            resultTemp.add(stackTemp.pop());

            // 递归
            dfs(input, stackTemp, resultTemp);
        }

        // 入栈
        if (!input.isEmpty()) {
            Queue<Integer> inputTemp = new LinkedBlockingQueue<>(input);

            Stack<Integer> stackTemp = new Stack<>();
            stackTemp.addAll(stack);

            // 出栈先存到到结果列表
            stackTemp.add(inputTemp.poll());

            // 递归
            dfs(inputTemp, stackTemp, result);
        }
    }
}

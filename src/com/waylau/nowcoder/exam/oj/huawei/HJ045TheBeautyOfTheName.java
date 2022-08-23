/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ45 名字的漂亮度.
 * 描述：给出一个名字，该名字有26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。 
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * 本题含有多组数据。
 * 输入描述：整数N，后续N个名字
 * 输出描述：每个名称可能的最大漂亮程度
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 输出：
 * 192
 * 101
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-23
 */
public class HJ045TheBeautyOfTheName {

    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();

        int n = Integer.valueOf(in.nextLine());

        for (int i= 0; i<n; i++) {
            String name = in.nextLine();
            result.add(doBeauty(name));
        }

        // 输出
        result.forEach(System.out::println);
 
        // 关闭
        in.close();
    }

    private static int doBeauty(String name) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : name.toCharArray()) {
            Integer count = map.get(ch);
            if (count == null) {
                count = 1;
            } else {
                count ++;
            }

            map.put(ch, count);
        }

        // map值转List
        List<Integer> list =  new ArrayList<>();
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            list.add(entry.getValue());
        }

        // 由小到大排序
        list.sort(Comparator.naturalOrder());

        // 总和
        int size = map.size();
        int beautyValue = 26 - size +1;
        int total = 0;
        for (int count : list) {
            total += count * beautyValue;
            beautyValue ++;
        }

        return  total;
    }

}

 /*
  *  Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * HJ27 查找兄弟单词.
 * 描述：定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，按字典序排列后的第k个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述：先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
 * 输出描述：输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入：3 abc bca cab abc 1
 * 输出：2 bca
 * 示例2
 * 输入：6 cab ad abcd cba abc bca abc 1
 * 输出：3 bca
 * 说明：
 * abc的兄弟单词有cab cba bca，所以输出3
 * 经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca

 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-16
 */
public class HJ027FindBrotherWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入先转为字符数组
        String[] inArray = sc.nextLine().split(" ");

        int inLength = inArray.length;
        int k = Integer.valueOf(inArray[inLength - 1]);
        String x = inArray[inLength - 2];

        List<String> list = new ArrayList<>();

        // 遍历只取输入的单词
        for (int i = 1; i < inLength - 2; i++) {
            String str = inArray[i];

            if (!str.equals(x) && sortByNaturalOrder(str).equals(sortByNaturalOrder(x))) {
                list.add(inArray[i]);
            }
        }

        // 按照字典排序
        list.sort(Comparator.naturalOrder());

        System.out.println(list.size());
        
        // 这里处理越界
        if (k <= list.size()) {
            System.out.println(list.get(k - 1));
        }
        
        // 关闭
        sc.close();
    }

    private static String sortByNaturalOrder(String s) {
        List<Character> list = new ArrayList<>();
        for (Character ch : s.toCharArray()) {
            list.add(ch);
        }
        
        // 按照字典排序
        list.sort(Comparator.naturalOrder());

        // 重新组成字符串
        StringBuilder sb = new StringBuilder();
        for (Character ch : list) {
            sb.append(ch);
        }

        return sb.toString();
    }
}

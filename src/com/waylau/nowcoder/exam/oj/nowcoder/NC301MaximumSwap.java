/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * NC301 最大数字交换
 * 给定一个字符串num，字符串由0~9的正整数组成，你至多可以交换一次字符串中的任意两位字符，使得交换后的num代表的正整数尽可能大。
 * 1.给定的num不会含有前导0，是一个合法的正整数类型的字符串
 * 2.可以不交换，但是最多只能交换一次
 * 
 * 示例1
 * 输入：
 * "4556"
 * 返回值：
 * "6554"
 * 说明：
 * 交换6和4，可以获得最大的正整数6554 
 * 
 * 示例2
 * 输入：
 * "5"
 * 返回值：
 * "5"
 * 
 * 示例3
 * 输入：
 * "8873"
 * 返回值：
 * "8873"
 * 说明：
 * 不需要交换 
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-04
 */
public class NC301MaximumSwap {

    public static void main(String[] args) {
        System.out.println(maximumSwap("4556"));

        System.out.println(maximumSwap("5"));

        System.out.println(maximumSwap("8873"));

        System.out.println(maximumSwap("6062"));
    }

    private static String maximumSwap(String num) {
        String result = "";

        // 转为列表方便处理
        List<Character> numList = new ArrayList<>();

        for (int z = 0; z < num.length(); z++) {
            numList.add(num.charAt(z));
        }

        char[] numArray = num.toCharArray();
        int length = numArray.length;

        // 字符串num进行降序排序，形成一个待比较的列表temp。
        numList.sort(Comparator.reverseOrder());
   
        Character[] temp = numList.toArray(new Character[length]);

        // 遍历字符串num中的元素a，该元素a与temp首个元素b比较，
        // 如果不相等，则说明a、b是需要交换的元素。
        // 如果相等，则查找num、temp中的下一个元素。
        int i = 0;
        int j = 0;
        int index = 0;
        char swapChar = 0;
        boolean flag = false;
        while (i < length && j < length) {
            if (numArray[i] == temp[j].charValue()) {
                // 查找num、temp中的下一个元素。
                i++;
                j++;
            } else {
                // 如果不相等，则说明找到了是需要交换的元素。
                index = i;
                swapChar = temp[j];

                // 标识是否已经找到要交换的元素
                flag = true;
                break;
            }
        }

        // 如果已经查找到了待交换的元素，那么从num中查找出最低位的元素进行交换。
        if (flag) {
            for (int k = length - 1; k > index; k--) {
                if (swapChar == numArray[k]) {

                    // 执行交换
                    char tempChar = numArray[k];
                    numArray[k] = numArray[index];
                    numArray[i] = tempChar;
                }
            }
        }

        if (flag) {
            result = String.valueOf(numArray);
        } else {
            // 无需交换就是自己
            result = num;
        }

        return result;
    }
}

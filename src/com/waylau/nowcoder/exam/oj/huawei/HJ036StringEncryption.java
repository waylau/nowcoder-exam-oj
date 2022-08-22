 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 描述：有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。
 * 下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
 * 如果单词中包含有重复的字母，只保留第1个，将所得结果作为新字母表开头，
 * 并将新建立的字母表中未出现的字母按照正常字母表顺序加入新字母表。
 * 如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 * (实际需建立小写字母的字母表，此字母表仅为方便演示）
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，
 * 并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
 * 因此，使用这个密匙， Attack AT DAWN (黎明时攻击)
 * 就会被加密为Tpptad TP ITVH。
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 * 数据范围：1≤n≤100  ，保证输入的字符串中仅包含小写字母
 * 输入描述：先输入key和要加密的字符串
 * 输出描述：返回加密后的字符串
 * 示例1
 * 输入：
 * nihao
 * ni
 * 输出：
 * le
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ036StringEncryption {
    private static char[] UPPERCASE_LETTERS = {'A', 'B', 'C', 'D', 'E',
        'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
        'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String key = sc.nextLine();
            String in = sc.nextLine();

            List<Character> newLetters = getNewLetters(key);

            // 输出
            System.out.println(encrypt(in, newLetters));
        }

        // 关闭
        sc.close();
    }

    // 生成新字母表
    private static List<Character> getNewLetters(String key) {
        char[] arr = key.toCharArray();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            // 去重，并转为大写
            char up = Character.toUpperCase(arr[i]);
            if (!list.contains(up)) {
                list.add(up);
            }
        }

        for (char ch : UPPERCASE_LETTERS) {
            if (!list.contains(ch)) {
                list.add(ch);
            }
        }

        return list;
    }

    // 生成新字母表
    private static String encrypt(String str, List<Character> letters) {
        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            // 转为大写
            char up = Character.toUpperCase(arr[i]);
            boolean isMatched = false;
            for (int j = 0; j < UPPERCASE_LETTERS.length; j++) {
                if (up == UPPERCASE_LETTERS[j]) {
                    // 判断是否大写
                    if (Character.isUpperCase(arr[i])) {
                        sb.append(letters.get(j));
                    } else {
                        // 转为小写
                        sb.append(Character.toLowerCase(letters.get(j)));
                    }

                    isMatched = true;
                    break;
                }
            }

            // 没有在字母表，就原样输出
            if (!isMatched) {
                sb.append(arr[i]);
            }

        }

        return sb.toString();
    }
}

 /*
  *  Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
 
/**
 * HJ23 删除字符串中出现次数最少的字符.
 * 描述：实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入: 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * 输出: 删除字符串中出现次数最少的字符后的字符串。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-15
 */
public class HJ023DeleteLeastOccurringCharacterFromString {
    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String in = sc.nextLine();
            int len = in.length();

            // 遍历时统计每个字符的出现的次数，可以用哈希存储。
            Map<Character, Integer> map = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                char ch = in.charAt(i);

                Integer count = map.get(ch);
                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }

                map.put(ch, count);
            }

            // 最小数量的字符用链表存储；
            List<Character> minList = new ArrayList<>(len);
            int min = Integer.MAX_VALUE;
            for (Entry<Character, Integer> entry : map.entrySet()) {
                char ch = entry.getKey();
                int count = entry.getValue();

                if (count < min) {
                    min = count;

                    // 清空非最小值
                    minList.clear();

                    minList.add(ch);
                } else if (count == min) {
                    minList.add(ch);
                } else {
                    // 什么都不做
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                char ch = in.charAt(i);

                // 不是最小，就输出
                if (!minList.contains(ch)) {
                    sb.append(ch);
                }
            }

            // 输出
            System.out.println(sb.toString());
        }

        // 关闭
        sc.close();
    }
}

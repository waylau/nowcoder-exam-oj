/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ81 字符串字符匹配.
 * 描述:判断短字符串S中的所有字符是否在长字符串T中全部出现。
 * 请注意本题有多组样例输入。
 * 数据范围:1≤len(S),len(T)≤200 
 * 输入描述：
 * 输入两个字符串。第一个为短字符串，第二个为长字符串。两个字符串均由小写字母组成。
 * 输出描述：
 * 如果短字符串的所有字符均在长字符串中出现过，则输出字符串"true"。否则输出字符串"false"。
 * 示例1
 * 输入：
 * bc
 * abc
 * 输出：
 * true
 * 说明：其中abc含有bc，输出"true"
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ081StringCharacterMatching {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int count = 0;
        
        // 用contains是否不讲武德？
        // 注意这个题目不是考是否包含子串，而是考包含字符
        // 所以要遍历较短的那个字符串的所有字符
        for (char ch : str1.toCharArray()) {
           if (str2.contains(ch + "")) {
                count ++;
            } else {
               break;
           }
        }
        if (count == str1.length()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        br.close();
    }

}

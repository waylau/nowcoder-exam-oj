/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 描述：1、对输入的字符串进行加解密，并输出。
 * 2加密方法为：当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写，
 * 如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * 输入描述:输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * 输出描述:输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * 示例1
 * 输入
 * abcdefg
 * BCDEFGH
 * 输出
 * BCDEFGH
 * abcdefg
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-17
 */
public class HJ029CharacterStringEncryptionAndDecryption {
    private static char[] UPPERCASE_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
        'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static char[] LOWERCASE_LETTERS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    private static char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String in2 = sc.nextLine();

        // 输出
        System.out.println(String.valueOf(encrypt(in.toCharArray())));
        System.out.println(String.valueOf(decrypt(in2.toCharArray())));

        // 关闭
        sc.close();
    }

    // 加密
    private static char[] encrypt(char words[]) {
        char[] result = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            if (Character.isUpperCase(word)) {
                int j = findIndex(word, UPPERCASE_LETTERS);
                j++;

                if (j == LOWERCASE_LETTERS.length) {
                    j = 0;
                }

                result[i] = LOWERCASE_LETTERS[j];
            } else if (Character.isLowerCase(word)) {
                int j = findIndex(word, LOWERCASE_LETTERS);
                j++;

                if (j == UPPERCASE_LETTERS.length) {
                    j = 0;
                }

                result[i] = UPPERCASE_LETTERS[j];
            } else if (Character.isDigit(word)) {
                int j = findIndex(word, DIGITS);
                j++;

                if (j == DIGITS.length) {
                    j = 0;
                }

                result[i] = DIGITS[j];
            } else {
                result[i] = word;
            }
        }

        return result;
    }

    // 解密
    private static char[] decrypt(char words[]) {
        char[] result = new char[words.length];

        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            if (Character.isUpperCase(word)) {
                int j = findIndex(word, UPPERCASE_LETTERS);
                j--;

                if (j < 0) {
                    j = LOWERCASE_LETTERS.length - 1;
                }

                result[i] = LOWERCASE_LETTERS[j];
            } else if (Character.isLowerCase(word)) {
                int j = findIndex(word, LOWERCASE_LETTERS);
                j--;

                if (j < 0) {
                    j = UPPERCASE_LETTERS.length - 1;
                }

                result[i] = UPPERCASE_LETTERS[j];
            } else if (Character.isDigit(word)) {
                int j = findIndex(word, DIGITS);
                j--;

                if (j < 0) {
                    j = DIGITS.length - 1;
                }

                result[i] = DIGITS[j];
            } else {
                result[i] = word;
            }
        }

        return result;
    }

    private static int findIndex(char ch, char words[]) {
        for (int i = 0; i < words.length; i++) {
            if (ch == words[i]) {
                return i;
            }
        }

        return -1;
    }
}

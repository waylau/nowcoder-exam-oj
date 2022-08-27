/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ62 查找输入整数二进制中1的个数.
 * 描述:输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * 输入描述：
 * 输入一个整数
 * 输出描述：
 * 计算整数二进制中1的个数
 * 示例1
 * 输入：
 * 5
 * 输出：
 * 2
 * 说明：
 * 5的二进制表示是101，有2个1   
 * 示例2
 * 输入：
 * 0
 * 输出：
 * 0
 * 
 * 解法2：考虑二进制的特点，逢2进1，意味有多少个进位，就有多少个1！
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ062FindTheNumberOfFirstTheInputIntegerBinary2 {

	public static void main(String[] args)
			throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));

		// 输入，考虑多组
		br.lines().forEach(in -> {
			// 考虑二进制的特点，逢2进1，意味有多少个进位，就有多少个1！
			int num = Integer.valueOf(in);
			int count = 0;

			while (num != 0) {
				if (num % 2 == 1) {
					count++;
				}

				// 右移1位
				num = num >> 1;
			}

			// 输出
			System.out.println(count);
		});

		// 关闭
		br.close();

	}

}

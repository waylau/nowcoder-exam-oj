/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ86 求最大连续bit数.
 * 描述:求一个int类型数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
 * 数据范围：数据组数： 1≤t≤5 ， 1≤n≤500000 
 * 输入描述：输入一个int类型数字
 * 输出描述：输出转成二进制之后连续1的个数
 * 示例1
 * 输入：
 * 200
 * 输出：
 * 2
 * 说明：
 * 200的二进制表示是11001000，最多有2个连续的1。
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ086FindTheMaximumNumberOfConsecutiveBits {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();

		// 转二进制字符串
		String binaryStr = Integer.toBinaryString(num);

		// 按照0分隔成字符串数组
		String[] binaryStrArr = binaryStr.split("0");

		int max = 0;
		for (String str : binaryStrArr) {
			// str要不全是0，要不全是1.只需统计全为1的字符串长度即可
			if (str.contains("1")) {
				max = Math.max(max, str.length());
			}
		}

		System.out.print(max);

		in.close();
	}
}

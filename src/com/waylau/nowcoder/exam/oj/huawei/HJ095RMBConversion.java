/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ95 人民币转换
 * 描述

考试题目和要点：

1、中文大写金额数字前应标明“人民币”字样。中文大写金额数字应用壹、贰、叁、肆、伍、陆、柒、捌、玖、拾、佰、仟、万、亿、元、角、分、零、整等字样填写。

2、中文大写金额数字到“元”为止的，在“元”之后，应写“整字，如532.00应写成“人民币伍佰叁拾贰元整”。在”角“和”分“后面不写”整字。

3、阿拉伯数字中间有“0”时，中文大写要写“零”字，阿拉伯数字中间连续有几个“0”时，中文大写金额中间只写一个“零”字，如6007.14，应写成“人民币陆仟零柒元壹角肆分”。

4、10应写作“拾”，100应写作“壹佰”。例如，1010.00应写作“人民币壹仟零拾元整”，110.00应写作“人民币壹佰拾元整”

5、十万以上的数字接千不用加“零”，例如，30105000.00应写作“人民币叁仟零拾万伍仟元整”

输入描述：
输入一个double数

输出描述：
输出人民币格式

示例1

```
输入：
151121.15

输出：
人民币拾伍万壹仟壹佰贰拾壹元壹角伍分
```

示例2

```
输入：
1010.00

输出：
人民币壹仟零拾元整

 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ095RMBConversion {
	public static String[] TEN = { "零", "壹", "贰", "叁", "肆",
			"伍", "陆", "柒", "捌", "玖" };
	public static String[] BILLION = { "万", "亿" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()) {
			// 分割为整数部分和小数部分
			String[] s = in.nextLine().split("\\.");
			
			if (s[1].equals("00")) {
				System.out.println("人民币"
						+ handleInteger(
								Double.parseDouble(s[0]))
						+ "元整");
			} else if (s[0].equals("0")) {
				System.out.println("人民币" + handleDecimal(s[1]));
			} else {
				System.out.println("人民币"
						+ handleInteger(
								Double.parseDouble(s[0]))
						+ "元" + handleDecimal(s[1]));
			}
		}

		in.close();
	}

	// 处理小数
	private static String handleDecimal(String s2) {
		StringBuilder sb = new StringBuilder();
		int jiao = Integer.parseInt(s2.substring(0, 1));
		int fen = Integer.parseInt(s2.substring(1, 2));
		if (jiao != 0) {
			sb.append(TEN[jiao]);
			sb.append("角");
		}
		if (fen != 0) {
			sb.append(TEN[fen]);
			sb.append("分");
		}
		return sb.toString();
	}

	// 处理整数
	public static String handleInteger(double zheng) {
		StringBuilder sb = new StringBuilder();
		int pow = 0;
		while ((int) zheng != 0) {
			if (pow != 0) {
				sb.append(BILLION[pow - 1]);
			}
			int temp = (int) (zheng % 10000);
			// 个位
			int gewei = temp % 10;
			int shiwei = (temp / 10) % 10;
			int baiwei = (temp / 100) % 10;
			int qianwei = (temp / 1000) % 10;
			if (gewei != 0) {
				sb.append(TEN[gewei]);
			}
			// 十位
			if (shiwei != 0) {
				sb.append("拾");
				if (shiwei != 1) {
					sb.append(TEN[shiwei]);
				}
			} else {
				if (gewei != 0 && (temp > 99
						|| (int) zheng > 10000)) {
					sb.append(TEN[0]);
				}
			}
			// 百位
			if (baiwei != 0) {
				sb.append("佰");
				sb.append(TEN[baiwei]);
			} else {
				if (shiwei != 0 && (temp > 999
						|| (int) zheng > 10000)) {
					sb.append(TEN[0]);
				}
			}
			if (qianwei != 0) {
				sb.append("仟");
				sb.append(TEN[qianwei]);
			} else {
				if (baiwei != 0 && (int) zheng > 10000) {
					sb.append(TEN[0]);//
				}
			}
			zheng /= 10000;
			pow++;
			if (pow > 2) {
				pow = 1;
			}
		}
		return sb.reverse().toString();
	}
}

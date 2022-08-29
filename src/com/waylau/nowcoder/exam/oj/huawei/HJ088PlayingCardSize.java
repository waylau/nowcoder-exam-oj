/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ88 扑克牌大小.
 * 描述:扑克牌游戏大家应该都比较熟悉了，一副牌由54张组成，含3~A、2各4张，小王1张，大王1张。
 * 牌面从小到大用如下字符和字符串表示（其中，小写joker表示小王，大写JOKER表示大王）：
 * 3 4 5 6 7 8 9 10 J Q K A 2 joker JOKER
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，"-"两边没有空格，
 * 如：4 4 4 4-joker JOKER。
 * 请比较两手牌大小，输出较大的牌，如果不存在比较关系则输出ERROR。
 * 基本规则：
 * （1）输入每手牌可能是个子、对子、顺子（连续5张）、三个、炸弹（四个）和对王中的一种，
 * 不存在其他情况，由输入保证两手牌都是合法的，顺子已经从小到大排列；
 * （2）除了炸弹和对王可以和所有牌比较之外，其他类型的牌只能跟相同类型的存在比较关系（如，对子跟对子比较，三个跟三个比较），
 * 不考虑拆牌情况（如：将对子拆分成个子）；
 * （3）大小规则跟大家平时了解的常见规则相同，个子、对子、三个比较牌面大小；顺子比较最小牌大小；
 * 炸弹大于前面所有的牌，炸弹之间比较牌面大小；对王是最大的牌；
 * （4）输入的两手牌不会出现相等的情况。
 * 数据范围：字符串长度：3≤s≤10 
 * 输入描述：
 * 输入两手牌，两手牌之间用"-"连接，每手牌的每张牌以空格分隔，
 * "-"两边没有空格，如 4 4 4 4-joker JOKER。
 * 输出描述：
 * 输出两手牌中较大的那手，不含连接符，扑克牌顺序不变，
 * 仍以空格隔开；如果不存在比较关系则输出ERROR。
 * 
 * 示例1
 * 
 * 输入：
 * 4 4 4 4-joker JOKER
 * 
 * 输出：
 * joker JOKER
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ088PlayingCardSize {
	private static final String[] CARD_SIZE = { "3", "4",
			"5", "6", "7", "8", "9", "10", "J", "Q", "K",
			"A", "2", "joker", "JOKER" };

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String[] strArray = in.nextLine().split("-");

		String str1 = strArray[0];
		String str2 = strArray[1];

		String result = "ERROR";

		// 先比较牌类型
		// 类型不同，则两副牌必有炸弹或者对王
		if (getType(str1) > getType(str2)
				&& ((getType(str1) == 4
						|| getType(str1) == 5)
						|| (getType(str2) == 4
								|| getType(str2) == 5))) {
			result = str1;
		} else if (getType(str1) < getType(str2)
				&& ((getType(str1) == 4
						|| getType(str1) == 5)
						|| (getType(str2) == 4
								|| getType(str2) == 5))) {
			result = str2;
		} else if(getType(str1) == getType(str2)) {
			// 类型相同比较牌面
			if (getIndex(str1.split(" ")[0]) > getIndex(
					str2.split(" ")[0])) {
				result = str1;
			} else {
				result = str2;
			}
		} else {
			// do nothing
		}

		System.out.print(result);

		in.close();
	}

	// 可以从长度判断出类型。每个类型赋值如下
	/*
	 * 个子 0 对子 1 三个 2 顺子 3 炸弹 4 对王 5
	 */
	private static int getType(String card) {
		int cardLength = card.split(" ").length;
		int result = 0;
		if (cardLength == 1) {
			result = 0;
		}

		// 长度为2的有对子和对王，要进一步判断
		if (cardLength == 2) {
			if (card.equals("joker JOKER")) {
				result = 5;
			} else {
				result = 1;
			}

		}
		if (cardLength == 3) {
			result = 2;
		}
		if (cardLength == 5) {
			result = 3;
		}
		if (cardLength == 4) {
			result = 4;
		}

		return result;
	}

	// 牌面大小按照数组的索引位置决定
	private static int getIndex(String ch) {
		for (int i = 0; i < CARD_SIZE.length; i++) {
			if (ch.equals(CARD_SIZE[i])) {
				return i;
			}
		}

		return -1;
	}

}

/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ17 坐标移动. 
 * 输入描述：开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * 输入：合法坐标为A(或者D或者W或者S) + 数字（两位以内）,坐标之间以;分隔。
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * 输入描述：一行字符串
 * 输出描述：最终坐标，以逗号分隔
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-13
 */
public class HJ017CoordinateMovement {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();

		// x y 代表坐标
		int x = 0;
		int y = 0;
		
		// 对输入进行分组
		String[] coordinateArray = in.split(";");
		
		for (int i = 0; i<coordinateArray.length ; i++) {
			String cmd = coordinateArray[i];
			if ( 2<= cmd.length() && cmd.length() <= 3) {
				char firstChar = cmd.charAt(0);
				
				// 每组的前2-3字符必须的是 数字。
				int number = 0;
				try {
					number = Integer.valueOf(cmd.substring(1));
				} catch (NumberFormatException e) {
					// 不是数字则忽略
					continue;
				}

				// 每组的前一个字符必须的是 A\D\W\S
				if (firstChar == 'A') {
					x -= number;
				} else if (firstChar == 'D') {
					x += number;
				} else if (firstChar == 'W') {
					y += number;
				} else if (firstChar == 'S') {
					y -= number;
				} else {
					// 忽略
				}
			}
		}

		// 输出
		System.out.println(x+","+y);

		sc.close();
	}

}

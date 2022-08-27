/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * HJ64 MP3光标位置. 描述:MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，
 * 用户要通过上下键才能浏览所有的歌曲。为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下： 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 * 其他情况下用户按Up键，光标挪到上一首歌曲；用户按Down键，光标挪到下一首歌曲。 2. 歌曲总数大于4的时候（以一共有10首歌为例）：
 * 特殊翻页：屏幕显示的是第一页（即显示第1 – 4首）时，光标在第一首歌曲上，用户按Up键后，
 * 屏幕要显示最后一页（即显示第7-10首歌），同时光标放到最后一首歌上。
 * 同样的，屏幕显示最后一页时，光标在最后一首歌曲上，用户按Down键，屏幕要显示第一页，光标挪到第一首歌上。
 * 一般翻页：屏幕显示的不是第一页时，光标在当前屏幕显示的第一首歌曲时， 用户按Up键后，屏幕从当前歌曲的上一首开始显示，光标也挪到上一首歌曲。
 * 光标当前屏幕的最后一首歌时的Down键处理也类似。 其他情况，不用翻页，只是挪动光标就行。 数据范围：命令长度 1≤s≤100 ，歌曲数量 1≤n≤150
 * 进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n) 输入描述： 输入说明： 1 输入歌曲数量 2 输入命令 U或者D 输出描述：
 * 输出说明 1 输出当前列表 2 输出当前选中歌曲 示例1 输入： 10 UUUU 输出： 7 8 9 10 7
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ064MP3CursorPosition {

	public static void main(String[] args)
			throws IOException {
		// 输入
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		char[] comands = br.readLine().toCharArray();

		// 数组表示窗口，没有歌曲默认值是0
		int[] windows = new int[4];

		// 数组表示歌曲列表，值放置歌曲的名称
		int[] songs = new int[n];

		// 前期选中的歌曲索引
		int selectedIndex = 0;

		// 实际能显示的歌曲长度
		int length = Math.min(n, 4);

		// 初始化
		for (int i = 0; i < length; i++) {
			windows[i] = i + 1;
		}

		// 初始化
		for (int i = 0; i < n; i++) {
			songs[i] = i + 1;
		}

		// 执行命令
		for (char ch : comands) {
			if (ch == 'U') {
				// 1、当前选中歌曲的处理
				// index 递减,当index<0时，则index置为n-1
				selectedIndex--;

				// 过界循环
				boolean loop = false;
				if (selectedIndex < 0) {
					selectedIndex = n - 1;
					loop = true;
				}

				// 是否滑动
				boolean slide = false;
				if (songs[selectedIndex] < windows[0]
						&& n > 4) {
					slide = true;
				}

				// 2、滑动窗口显示的歌曲
				// 只有歌曲数量大于4，才会有可以滑动的窗口
				// 当前index索引小于滑动窗口内第1个元素，则当前滑动窗口内的所有元素index 递减；
				if (loop && n > 4) {
					windows[0] = songs[selectedIndex - 3];
					windows[1] = songs[selectedIndex - 2];
					windows[2] = songs[selectedIndex - 1];
					windows[3] = songs[selectedIndex];

				} else if (slide) {
					windows[0] = songs[selectedIndex];
					windows[1] = songs[selectedIndex + 1];
					windows[2] = songs[selectedIndex + 2];
					windows[3] = songs[selectedIndex + 3];
				} else {
					// do nothing
				}
			} else if (ch == 'D') {
				// index 递增,当index>n-1时，则index置为0
				selectedIndex++;

				// 过界循环
				boolean loop = false;
				if (selectedIndex > n - 1) {
					selectedIndex = 0;
					loop = true;
				}

				// 是否滑动
				boolean slide = false;
				if (songs[selectedIndex] > windows[3]
						&& n > 4) {
					slide = true;
				}

				// 2、滑动窗口显示的歌曲
				// 只有歌曲数量大于4，才会有可以滑动的窗口
				// 当前index索引大于滑动窗口内第4个元素，则当前滑动窗口内的所有元素index 递增；
				if (loop && n > 4) {
					windows[0] = songs[selectedIndex];
					windows[1] = songs[selectedIndex + 1];
					windows[2] = songs[selectedIndex + 2];
					windows[3] = songs[selectedIndex + 3];

				} else if (slide) {
					windows[0] = songs[selectedIndex - 3];
					windows[1] = songs[selectedIndex - 2];
					windows[2] = songs[selectedIndex - 1];
					windows[3] = songs[selectedIndex];
				} else {
					// do nothing
				}
			} else {
				// do nothing
			}
		}

		// 输出
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(windows[i]);
			sb.append(" ");
		}

		System.out.println(sb.toString().trim());
		System.out.println(songs[selectedIndex]);

		// 关闭
		br.close();
	}

}

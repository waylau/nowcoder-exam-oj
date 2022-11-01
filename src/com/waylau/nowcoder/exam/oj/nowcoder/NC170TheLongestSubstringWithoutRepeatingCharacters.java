/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.HashMap;

/**
 * NC170 最长不含重复字符的子字符串 
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 
 * @since 1.0.0 2022年10月31日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class NC170TheLongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(
				lengthOfLongestSubstring("abcabcbb"));

		System.out
				.println(lengthOfLongestSubstring("bbbbb"));

		System.out.println(
				lengthOfLongestSubstring("pwwkew"));

		System.out
				.println(lengthOfLongestSubstring("dvdf"));

	}

	public static int lengthOfLongestSubstring(String s) {
		// 哈希表记录窗口内非重复的字符
		HashMap<Character, Integer> mp = new HashMap<>();
		int res = 0;
		// 设置窗口左右边界
		for (int left = 0,
				right = 0; right < s.length(); right++) {
			// 窗口右移进入哈希表统计出现次数
			if (mp.containsKey(s.charAt(right))) {
				mp.put(s.charAt(right),
						mp.get(s.charAt(right)) + 1);
			} else {
				mp.put(s.charAt(right), 1);
			}

			// 出现次数大于1，则窗口内有重复
			while (mp.get(s.charAt(right)) > 1) {
				// 窗口右移，同时减去该字符的出现次数
				mp.put(s.charAt(left),
						mp.get(s.charAt(left++)) - 1);
			}

			// 维护子串长度最大值
			res = Math.max(res, right - left + 1);
		}
		return res;
	}

}

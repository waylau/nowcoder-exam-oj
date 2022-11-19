package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NC85 拼接所有的字符串产生字典序最小的字符串.
 * 描述：给定一个长度为 n 的字符串数组 strs ，请找到一种拼接顺序，
 * 使得数组中所有的字符串拼接起来组成的字符串是所有拼接方案中字典序最小的，
 * 并返回这个拼接后的字符串。
 * 
 * 输入：["abc","de"]
 * 返回值："abcde"
 * 
 * 输入：["a","a","b"]
 * 返回值："aab"
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-11-19
 */
public class NC085SpliceSringsToProduceTheLeastLexicographicallyOrderedString {

	public static void main(String[] args) {
		String[] array = new String[] { "abc","de"};
		System.out.println(minString(array));

		array = new String[] { "a","a","b" };
		System.out.println(minString(array));
	}

	public static String minString(String[] strs) {
		// Java8 Stream 把数组转成List
		List<String> list = Arrays.stream(strs)
				.collect(Collectors.toList());

		// 构建一个比较器，来比较 str(a)+str(b) 和 str(b)+str(a) 的大小
		list.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + "" + o2)
						.compareTo(o2 + "" + o1);
			}

		});

		// List拼接为String输出
		StringBuilder sb = new StringBuilder();
		list.forEach(s -> {
			sb.append(s);
		});

		return sb.toString();
	}

}

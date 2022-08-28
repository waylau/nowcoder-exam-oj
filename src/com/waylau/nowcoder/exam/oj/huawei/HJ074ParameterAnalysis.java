/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ74 参数解析.
 * 描述
在命令行输入如下命令：

xcopy /s c:\\ d:\\e，

各个参数如下：

参数1：命令字xcopy

参数2：字符串/s

参数3：字符串c:\\

参数4: 字符串d:\\e

请编写一个参数解析程序，实现将命令行各个参数解析出来。


解析规则：

1.参数分隔符为空格
2.对于用""包含起来的参数，如果中间有空格，不能解析为多个参数。比如在命令行输入xcopy /s "C:\\program files" "d:\"时，参数仍然是4个，第3个参数应该是字符串C:\\program files，而不是C:\\program，注意输出参数时，需要将""去掉，引号不存在嵌套情况。
3.参数不定长

4.输入由用例保证，不会出现不符合要求的输入
数据范围：字符串长度：1\le s\le 1000\1≤s≤1000 
进阶：时间复杂度：O(n)\O(n) ，空间复杂度：O(n)\O(n) 
输入描述：
输入一行字符串，可以有空格

输出描述：
输出参数个数，分解后的参数，每个参数都独占一行

示例1
输入：
xcopy /s c:\\ d:\\e
复制
输出：
4
xcopy
/s
c:\\
d:\\e
 * 
 * @since 1.0.0 2022年8月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ074ParameterAnalysis {

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);

		String line = in.nextLine();
		char[] arr = line.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		// 结果
		List<String> result = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '"') {
				// 一直往后找，直到下个"出现为止
				int j = i;
				while(true) {
					j ++;
					if (arr[j] != '"') {
						sb.append(arr[j]);
					} else {
						break;
					}
				}

				// 输出
				result.add(sb.toString());
				sb = new StringBuilder();
				
				// 索引后移
				i = j + 1;
				if (i>=arr.length) {
					break;
				}
			}

			if (arr[i] == ' ') {
				if (!sb.toString().equals("")) {
					result.add(sb.toString());
					sb = new StringBuilder();
				}
			} else {
				sb.append(arr[i]);
			}
		}

		if (!sb.toString().equals("")) {
			result.add(sb.toString());
			sb = new StringBuilder();
		}

		// 输出
		System.out.println(result.size());
		result.forEach(System.out::println);
		
		// 关闭
		in.close();
	}

}

/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ63 DNA序列.
 * 一个 DNA 序列由 `A/C/G/T` 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C
 * 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。 在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ， 请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N
 * 的第一个子串。 DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等 数据范围：字符串长度满足
 * 1≤n≤1000 ，输入的字符串只包含 `A/C/G/T` 字母 输入描述： 输入一个string型基因序列，和int型子串的长度
 * 输出描述：找出GC比例最高的子串,如果有多个则输出第一个的子串 示例1 输入： ACGT 2 输出： CG 说明：
 * ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5， CG为1，故输出CG 示例2 输入：
 * AACTGTGCACGACCTGA 5 输出： GCACG 说明：
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串， 所以只能输出GCACG。
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ063DNASequence {

	public static void main(String[] args) {
		// 输入
		Scanner in = new Scanner(System.in);
		String sequence = in.nextLine();
		int n = in.nextInt();

		char[] sequenceArr = sequence.toCharArray();
		int length = sequence.length();

		// 遍历输入的字符串，分两种情况，统计`G\C`出现的次数。分两种情况：
		// 统计0到N-1个字串。纪录`G\C`出现的次数count，以及这段的开始位置sIndex;
		int count = 0;
		int sIndex = 0;
		for (int i = 0; i < n; i++) {
			if (isGC(sequenceArr[i])) {
				count++;
			}
		}

		// 再遍历后续的字符，如果该字串GC数比上一个字串的多，则接受这个字串为GC数最多的字串。
		int prev = 0; // 上个字串的首字符位置

		int max = count;// GC最大总数
		int prevCount = count;// 上次子串的GC总数
		
		for (int i = n; i < length; i++) {
			int curCount = prevCount;
			char curChar = sequenceArr[i];
			char prevChar = sequenceArr[prev];

			// 统计当前字串的GC总数
			if (isGC(curChar)) {
				curCount++;
			}
			
			if (isGC(prevChar)) {
				curCount--;
			}

			// 当前GC总数最多
			if (curCount > max) {
				sIndex = prev + 1;
				max = curCount;
			}

			prevCount = curCount;
			prev++;
		}

		// 输出
		System.out.println(
				sequence.substring(sIndex, sIndex + n));

		// 关闭
		in.close();

	}

	private static boolean isGC(char ch) {
		boolean isGC = false;

		if (ch == 'G' || ch == 'C') {
			isGC = true;
		}

		return isGC;
	}

}

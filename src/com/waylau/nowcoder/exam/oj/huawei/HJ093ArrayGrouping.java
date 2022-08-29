/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * HJ93 数组分组.
 * 输入int型数组，询问该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，
 * 所有3的倍数在另一个组中（不包括5的倍数），不是5的倍数也不是3的倍数能放在任意一组，
 * 可以将数组分为空数组，能满足以上条件，输出true；不满足时输出false。
 * 数据范围：每个数组大小满足  `1≤n≤50`  ，输入的数据大小满足 `∣val∣≤500` 
 * 输入描述：
 * 第一行是数据个数，第二行是输入的数据
 * 输出描述：
 * 返回true或者false
 * 示例1
 * ```
 * 输入：
 * 4
 * 1 5 -5 1
 * 输出：
 * true
 * 说明：
 * 第一组：5 -5 1
 * 第二组：1      
 * ```
 * 示例2
 * ```
 * 输入：
 * 3
 * 3 5 8
 * 
 * 输出：
 * false
 * 
 * 说明：
 * 由于3和5不能放在同一组，所以不存在一种分法。 
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ093ArrayGrouping {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			List<Integer> list = new ArrayList<>();
			int sum3 = 0, sum5 = 0, sum = 0;
			for (int i = 0; i < n; i++) {
				int t = in.nextInt();
				if (t % 5 == 0) {
					sum5 += t;
				} else if (t % 3 == 0) {
					sum3 += t;
				} else {
					sum += t;
					list.add(t);
				}
			}

			int target = Math.abs(sum5 - sum3); // 按5的倍数和3的倍数分组时，两组的差值target

			if (sum == target) { // 差值与剩余数的总和相等，即可以分组，直接把所有的数放在较小值那一组即可
				System.out.println("true");
				continue;
			}

			System.out.println(check(list, target));
		}

		in.close();
	}

	// 判断是否可分组
	// 把剩余数按所有情况分组，当两组的差值与target相等时，即可正确分组
	private static boolean check(List<Integer> list,
			int target) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Integer> list1 = list.subList(i, j); // 将list分为两组，list1和（list2+list3）
				List<Integer> list2 = list.subList(0, i);
				List<Integer> list3 = list.subList(j,
						list.size());
				if (Math.abs(sum(list1) - sum(list2)
						- sum(list3)) == target) { // 当两组的差值等于target时，可以正确分组
					return true;
				}
			}
		}

		return false;
	}

	// 计算总和
	private static int sum(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}
		return sum;
	}
}

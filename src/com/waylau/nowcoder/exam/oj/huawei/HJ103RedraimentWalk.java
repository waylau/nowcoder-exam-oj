/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ103 Redraiment的走法
 * 描述:Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，
 * 但只能从低处往高处的桩子走。他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 * 数据范围：每组数据长度满足 1≤n≤200  ， 数据大小满足 1≤val≤350 
 * 输入描述：
 * 数据共2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 * 输出描述：
 * 输出一个结果
 * 示例1
 * 输入：
 * 6
 * 2 5 1 5 4 5 
 * 
 * 输出：
 * 3
 * 说明：
 * 6个点的高度各为 2 5 1 5 4 5
 * 如从第1格开始走,最多为3步, 2 4 5 ，下标分别是 1 5 6
 * 从第2格开始走,最多只有1步,5
 * 而从第3格开始走最多有3步,1 4 5， 下标分别是 3 5 6
 * 从第5格开始走最多有2步,4 5， 下标分别是 5 6
 * 所以这个结果是3。 
 * 
 * @since 1.0.0 2022年8月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ103RedraimentWalk {

	public static void main(String[] args) {
		// 该题可以简化为查找最长升序序列
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int[] arr = new int[n];

			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}


			System.out.println(count(arr));
		}

		in.close();
	}
	
	private static int count(int[] nums) {
		// 假设 dp[i]为终点为第i个桩的最大走法
		// 那么比较之前num[j]中比num[i]小的桩的最大走法：
		// 如果 num[j]< num[i],那么就有两种情况：
		//	踩上j桩： dp[i] = 1 + dp[j]
		// 不踩，忽略： dp[i] = dp[i] （原数量不变）
		
		int[] dp = new int[nums.length + 1];
		// 初始化为1
		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < nums.length; ++i) {
			for (int j = 0; j < i; ++j) {
				if (nums[j] < nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				max = Math.max(dp[i], max);
			}
		}
		return max;
	}

}

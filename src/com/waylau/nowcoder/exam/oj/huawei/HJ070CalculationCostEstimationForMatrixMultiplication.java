/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * HJ70 矩阵乘法计算量估算.
 * 描述：矩阵乘法的运算量与矩阵乘法的顺序强相关。
 * 例如：A是一个50×10的矩阵，B是10×20的矩阵，C是20×5的矩阵
 * 计算A*B*C有两种顺序：((AB)C)或者(A(BC))，前者需要计算15000次乘法，后者只需要3500次。
 * 编写程序计算不同的计算顺序需要进行的乘法次数。
 * 输入描述：输入多行，先输入要计算乘法的矩阵个数n，每个矩阵的行数，列数，总共2n的数，
 * 最后输入要计算的法则计算的法则为一个字符串，仅由左右括号和大写字母（'A'~'Z'）组成，
 * 保证括号是匹配的且输入合法！
 * 输出描述：输出需要进行的乘法次数
 * 示例1
 * 输入：
 * 3
 * 50 10
 * 10 20
 * 20 5
 * (A(BC))
 * 输出：
 * 3500
 * 
 * @since 1.0.0 2022年8月28日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ070CalculationCostEstimationForMatrixMultiplication {
	private static final char[] UPPERCASE_LETTERS = { 'A',
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.valueOf(sc.nextLine());

			// 存放输入的矩阵列表
			String[] matrixArray = new String[n];

			for (int i = 0; i < n; i++) {
				matrixArray[i] = sc.nextLine();
			}

			// 计算的法则
			String rule = sc.nextLine();

			// 解析法则
			Stack<String> stack = new Stack<>();
			int result = 0;
			for (char ch : rule.toCharArray()) {
				// 遇到)一直往回找到(为止，这里用栈实现。
				// 两个括号内包裹的矩阵进行计算，计算结果入栈
				if (ch == ')') {
					while (true) {
						String charInStack1 = stack.pop();
						if (charInStack1.equals("(")) {
							break;
						}

						String charInStack2 = stack.pop();
						if (charInStack2.equals("(")) {
							// 把取出来的 charInStack1 再放回栈
							stack.push(charInStack1);
							break;
						}

						String[] matrixStrArray1 = charInStack1
								.split(" ");
						String[] matrixStrArray2 = charInStack2
								.split(" ");

						result += calculationCost(
								Integer.valueOf(
										matrixStrArray2[0]),
								Integer.valueOf(
										matrixStrArray2[1]),
								Integer.valueOf(
										matrixStrArray1[1]));

						// 矩阵相乘的结果入栈
						stack.push(matrixStrArray2[0] + " " + matrixStrArray1[1]);
					}
				} else if (ch == '('){
					stack.push(ch + "");
				} else {
					// 将字母转矩阵字符串后入栈
					String matrixStr = matrixArray[getLetterIndex(ch)];
					stack.push(matrixStr);
				}
			}

			System.out.print(result);

		}

		sc.close();
	}

	// `[m,n] x [n,p]`共会有`n*p*m`次乘法运算
	private static int calculationCost(int row1,
			int column1, int column2) {
		return row1 * column2 * column1;
	}

	// 查找字母的索引位置
	private static int getLetterIndex(char letter) {
		for (int i = 0; i < UPPERCASE_LETTERS.length; i++) {
			if (UPPERCASE_LETTERS[i] == letter) {
				return i;
			}
		}

		return -1;
	}

}

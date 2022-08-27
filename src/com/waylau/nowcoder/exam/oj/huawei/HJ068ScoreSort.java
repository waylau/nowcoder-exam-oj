/**
 * Welcome to https://waylau.com
 */
package com.waylau.nowcoder.exam.oj.huawei;

import java.io.IOException;
import java.util.Scanner;

/**
 * HJ68 成绩排序.
 * 描述:给定一些同学的信息（名字，成绩）序列，请你将他们的信息按照成绩从高到低或从低到高的排列,
 * 相同成绩都按先录入排列在前的规则处理。
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 * 
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 * 
 * 从低到高
 * smith     67
 * jack      70
 * Tom       70
 * peter     96
 * 注：0代表从高到低，1代表从低到高
 * 数据范围：人数： 1≤n≤200 
 * 进阶：时间复杂度：O(nlogn)\O(nlogn) ，空间复杂度：O(n)\O(n) 
 * 
 * 输入描述：
 * 第一行输入要排序的人的个数n，第二行输入一个整数表示排序的方式，
 * 之后n行分别输入他们的名字和成绩，以一个空格隔开
 * 输出描述：
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 * 
 * 示例1
 * 输入：
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 * 
 * 输出：
 * fang 90
 * ning 70
 * yang 50
 * 
 * 示例2
 * 输入：3
 * 1
 * fang 90
 * yang 50
 * ning 70
 * 
 * 输出：
 * yang 50
 * ning 70
 * fang 90
 * 
 * @since 1.0.0 2022年8月27日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HJ068ScoreSort {
	public static void main(String[] args)
			throws IOException {
		// 输入
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		// 排序方式，0代表从高到低，1代表从低到高
		int sortType = in.nextInt();

		// 学生列表
		Student[] students = new Student[n];

		for (int i = 0; i < n; i++) {
			Student stu = new Student(in.next(),
					in.nextInt());
			students[i] = stu;
		}

		// 排序
		sort(students, sortType);

		// 输出
		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i].name + " "
					+ students[i].score);
		}

		// 关闭
		in.close();
	}

	// 冒泡排序
	// 考虑“按先录入排列在前”
	private static Student[] sort(Student[] students,
			int sortType) {
		// 由高到低排
		if (sortType == 0) {
			for (int i = 0; i < students.length - 1; i++) {
				for (int j = students.length - 1; j
						- i > 0; j--) {
					// 当前元素current跟前面元素before比较
					// 如果current > before，则两者交换位置，
					// 否则保持不要动，因为考虑了按先录入排列在前的规则。
					Student current = students[j];
					Student before = students[j - 1];
					if (current.score > before.score) {
						students[j] = before;
						students[j - 1] = current;
					}
				}

			}
		}

		// 由低到高排
		if (sortType == 1) {
			for (int i = 0; i < students.length - 1; i++) {
				for (int j = 0; j < students.length - 1
						- i; j++) {
					// 当前元素current跟前面元素next比较
					// 如果current > next，则两者交换位置，
					// 否则保持不要动，因为考虑了按先录入排列在前的规则。
					Student current = students[j];
					Student next = students[j + 1];
					if (current.score > next.score) {
						students[j] = next;
						students[j + 1] = current;
					}
				}
			}
		}

		return students;
	}
}

class Student {
	public String name;
	public int score;

	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
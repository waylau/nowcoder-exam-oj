/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * HJ19 简单错误记录. 
 * 描述：开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * 处理：
 * 1、 记录最多8条错误记录，循环记录，最后只用输出最后出现的八条错误记录。
 * 对相同的错误记录只记录一条，但是错误计数增加。最后一个斜杠后面的带后缀名的部分（保留最后16位）
 * 和行号完全匹配的记录才做算是“相同”的错误记录。
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。也就是说，哪怕不同路径下的文件，
 * 如果它们的名字的后16个字符相同，也被视为相同的错误记录
 * 4、循环记录时，只以第一次出现的顺序为准，后面重复的不会更新它的出现时间，仍以第一次为准
 * 数据范围：错误记录数量满足1≤n≤100  ，每条记录长度满足1≤len≤100
 * 输入描述：每组只包含一个测试用例。一个测试用例包含一行或多行字符串。
 * 每行包括带路径文件名称，行号，以空格隔开。
 * 输出描述：将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-13
 */
public class HJ019SimpleErrorRecord {

	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);

		// 键为文件名+行数，值为文件出现次数
		Map<String, Integer> fileMap = new HashMap<String, Integer>();

		// 队列方式实现循环纪录文件名+行数
		Queue<String> fileQueue = new ArrayBlockingQueue<String>(
				8);

		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] lineSplit = line.split(" ");
			String fileName = lineSplit[0];
			String lineNumber = lineSplit[1];

			String[] splitFileName = fileName.split("\\\\");
			String lastFileName = splitFileName[splitFileName.length
					- 1];
			int lastFileNameLen = lastFileName.length();
			String shortName = lastFileName;

			if (lastFileNameLen > 16) {
				// 文件名截短
				shortName = lastFileName
						.substring(lastFileNameLen - 16);
			}

			// 键为文件名+行数
			String key = shortName + " " + lineNumber;

			// 文件不曾出现过，则同时计入到哈希和队列中；
			// 文件如出现过，则只需要更新哈希的值
			Integer count = fileMap.get(key);
			if (count == null) {
				count = 1;
				
				// 超过8，要删除历史的纪录
				if (fileQueue.size() == 8) {
					fileQueue.remove();
				}
				fileQueue.add(key);
			} else {
				count++;
			}
			fileMap.put(key, count);
		}

		// 输出
		fileQueue.forEach(key -> {
			System.out
					.println(key + " " + fileMap.get(key));
		});

		// 关闭
		sc.close();
	}
    
}

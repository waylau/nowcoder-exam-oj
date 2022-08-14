/* 
* Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * HJ18 识别有效的IP地址和掩码并进行分类统计. 
 * 输入描述：请解析IP地址和对应的掩码，进行分类识别。
 * 要求按照A/B/C/D/E类地址归类，不合法的地址和掩码单独归类。
 * 输入描述：多行字符串。每行一个IP地址和掩码，用~隔开。
 * 输出描述：统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-08-13
 */
public class HJ018IdentifiesValidIpAddressesAndMasks2 {

	public static void main(String[] args) {
		// 输入
		Scanner sc = new Scanner(System.in);

		// 以下变量代表A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int err = 0;
		int p = 0;

		while (sc.hasNext()) {
			String line = sc.nextLine();
			String[] lineSplit = line.split("~");
			String ip = lineSplit[0];
			String mask = lineSplit[1];

			// 是否需要忽略
			if (!isIgnoreIp(ip)) {
				// 判断IP是否非法；
				if (isIllegalIp(ip) || isIllegalIp(mask)) {
					err++;
				} else if (isIllegalMask(mask)) { // 判断子网掩码是否非法
					err++;
				} else {
					// 私有IP地址和A,B,C,D,E类地址是不冲突的
					// 一个IP地址可能被统计为私有地址，也可能是被统计为A,B,C,D,E类地址，
					// 因此需要分开统计

					// 判断是否私有IP
					if (isPrivateIp(ip)) {
						p++;
					}

					// 判断IP的分类
					String[] ipSegments = ip.split("\\.");
					int firstSegment = Integer
							.valueOf(ipSegments[0]);

					if (1 <= firstSegment
							&& firstSegment <= 126) {
						a++;
					} else if (128 <= firstSegment
							&& firstSegment <= 191) {
						b++;
					} else if (192 <= firstSegment
							&& firstSegment <= 223) {
						c++;
					} else if (224 <= firstSegment
							&& firstSegment <= 239) {
						d++;
					} else if (240 <= firstSegment
							&& firstSegment <= 255) {
						e++;
					} else {
						// 忽略
					}
				}
			}
		}

		// 输出
		System.out.println(a + " " + b + " " + c + " " + d
				+ " " + e + " " + err + " " + p);

		sc.close();
	}

    private static boolean isIgnoreIp(String ip) {
    	boolean isIgnoreIp = false;
    	String[] ipSegments = ip.split("\\.");
    	
    	if (ipSegments[0].equals("0") || ipSegments[0].equals("127")) {
    		isIgnoreIp = true;
    	}
    	
    	return isIgnoreIp;
    }
    
    private static boolean isIllegalIp(String ip) {
    	boolean isIllegalIp = false;
    	String[] ipSegments = ip.split("\\.");
    	
    	for (int i = 0; i<ipSegments.length; i++) {
    		if(ipSegments[i].isEmpty()) {
    			isIllegalIp = true;
    			break;
    		} else {
    			int ipSegmentNumber = Integer.valueOf(ipSegments[i]);
    			if (ipSegmentNumber<0 || ipSegmentNumber>255) {
    				isIllegalIp = true;
    			}
    		}
    	}
 
    	
    	return isIllegalIp;
    }
    
	private static boolean isIllegalMask(String mask) {
		boolean isIllegalMask = false;
		String[] ipSegments = mask.split("\\.");
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < ipSegments.length; i++) {
			String binaryString = Integer.toBinaryString(
					Integer.valueOf(ipSegments[i]));

			// 不足8位前面补齐0
			while (binaryString.length() < 8) {
				binaryString = "0".concat(binaryString);
			}
			
			sb.append(binaryString);
		}

		// 32位二进制数中需要同时存在0和1，且不存在01
		if (sb.toString().contains("1")
				&& sb.toString().contains("0")
				&& !sb.toString().contains("01")) {
			isIllegalMask = false;
		} else {
			isIllegalMask = true;
		}

		return isIllegalMask;
	}
    
	private static boolean isPrivateIp(String ip) {
		boolean isPrivateIp = false;
		String[] ipSegments = ip.split("\\.");

		// 私网IP范围是：
		// 从10.0.0.0到10.255.255.255
		// 从172.16.0.0到172.31.255.255
		// 从192.168.0.0到192.168.255.255
		if (ipSegments[0].equals("10")
				|| (ipSegments[0].equals("172")
						&& Integer.valueOf(
								ipSegments[1]) >= 16
						&& Integer.valueOf(
								ipSegments[1]) <= 31)
				|| (ipSegments[0].equals("192")
						&& ipSegments[1].equals("168"))) {
			isPrivateIp = true;
		}

		return isPrivateIp;
	}
    
}

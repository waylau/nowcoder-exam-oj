 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;

/**
 * 描述：IP地址是由4个0-255之间的整数构成的，用"."符号相连。
 * 二进制的IP地址格式有32位，例如：10000011，01101011，00000011，00011000;
 * 每八位用十进制表示就是131.107.3.24
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，由1和0组成，且1和0分别连续，
 * 其中网络号部分全为“1”和主机号部分全为“0”。
 * 你可以简单的认为子网掩码是一串连续的1和一串连续的0拼接而成的32位二进制数，
 * 左边部分都是1，右边部分都是0。利用子网掩码可以判断两台主机是否在同一子网中。
 * 若两台主机的IP地址分别与它们的子网掩码进行逻辑“与”运算（按位与/AND）后的结果相同，
 * 则说明这两台主机在同一子网中。
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-18
 */
public class HJ039CheckWhetherTwoIpAddressesBelongToTheSameSubnet {

    public static void main(String[] args) {
        // 输入
        Scanner sc = new Scanner(System.in);
        String mask = sc.nextLine();
        String ip1 = sc.nextLine();
        String ip2 = sc.nextLine();

        int result = 1;
        if (isIllegalIp(mask) || isIllegalMask(mask) || isIllegalIp(ip1) || isIllegalIp(ip2)) {
            result = 1;
        } else if (isSameIp(mask, ip1, ip2)) {
            result = 0;
        } else {
            result = 2;
        }

        // 输出
        System.out.println(result);

        // 关闭
        sc.close();

    }

    private static boolean isIllegalIp(String ip) {
        boolean isIllegalIp = false;
        String[] ipSegments = ip.split("\\.");

        for (int i = 0; i < ipSegments.length; i++) {
            if (ipSegments[i].isEmpty()) {
                isIllegalIp = true;
                break;
            } else {
                int ipSegmentNumber = Integer.valueOf(ipSegments[i]);
                if (ipSegmentNumber < 0 || ipSegmentNumber > 255) {
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
            String binaryString = Integer.toBinaryString(Integer.valueOf(ipSegments[i]));

            // 不足8位前面补齐0
            while (binaryString.length() < 8) {
                binaryString = "0".concat(binaryString);
            }

            sb.append(binaryString);
        }

        // 32位二进制数中需要同时存在0和1，且不存在01
        if (sb.toString().contains("1") && sb.toString().contains("0") && !sb.toString().contains("01")) {
            isIllegalMask = false;
        } else {
            isIllegalMask = true;
        }

        return isIllegalMask;
    }

    private static boolean isSameIp(String mask, String ip1, String ip2) {
        String[] maskValue = mask.split("\\.");
        String[] ipSegments1 = ip1.split("\\.");
        String[] ipSegments2 = ip2.split("\\.");

        for (int i = 0; i < ipSegments1.length; i++) {
            int maskSegment = Integer.valueOf(maskValue[i]);
            int ipSegment1 = Integer.valueOf(ipSegments1[i]);
            int ipSegment2 = Integer.valueOf(ipSegments2[i]);

            // “与” 运算
            if ((maskSegment & ipSegment1) != (maskSegment & ipSegment2)) {
                return false;
            }
        }

        return true;
    }

}

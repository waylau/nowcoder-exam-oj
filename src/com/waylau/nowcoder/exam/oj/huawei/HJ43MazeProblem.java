/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 描述：定义一个二维数组N*M(其中2<=N<=10;2<=M<=10)，
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或者竖着走，不能斜着走，
 * 要求编程序找出从左上角到右下角的最短路径。入口点为`[0,0]`，即第一格是可以走的路。
 * 输入描述：
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中1表示墙壁，0表示可走的路。
 * 数据保证有唯一解，不考虑有多解的情况，即迷宫只有一条通道。
 * 输出描述：左上角到右下角的最短路径，格式如样例所示。
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-22
 */
public class HJ43MazeProblem {
 
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        
        // 输入的数组maze[n][m]的值1表示墙壁不能走，0表示可走的路
        int[][] maze = new int[n][m];
        
        // 走过的格子，记录到数组traveled[n][m]里面去，这样，我们就不会重复走
        int[][] traveled = new int[n][m];
        
        // 纪录结果
        List<Node> result = new ArrayList<>();
        
        // 岔路用一个栈结构branches来记录
        Stack<Node> branches = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = in.nextInt();
            }
        }

        Node node = new Node(0, 0);
        result.add(node);
        
        // 输出
        while (true) {
            node = gotoNext(n, m, maze, traveled, branches, node);
            result.add(node);

            // 到达终点就退出
            if ((node.x == (n - 1)) && (node.y == (m - 1))) {
                break;
            }
        }

        // 最终的结果还要删除掉那些走到死路的节点
        // 倒序删除
        Node last = new Node(n-1, m-1);
        for (int i = result.size() -1 ; i > 0 ; i--) {
        	Node lastSecond = result.get(i-1);
        	
        	// 两个节点不是挨着的，就删除
        	if ((Math.abs(last.x - lastSecond.x) + Math.abs(last.y - lastSecond.y))>1) {
        		result.remove(i-1);
        	} else {
        		last = lastSecond;
        	}
        }
        
        result.forEach(d -> System.out.println("(" + d.x + "," + d.y + ")"));
        
        // 关闭
        in.close();
    }

    public static Node gotoNext(int n, int m, int[][] maze, int[][] traveled, 
        Stack<Node> branches, Node currentNode) {
        Node nextNode;
        int x = currentNode.x;
        int y = currentNode.y;
        traveled[x][y] = 1;

        // 先按优先级从低到高进行探路，即左上右下的方向进行尝试
        // 可行的路就记入栈结构 branches 中
        if (x - 1 >= 0 && maze[x - 1][y] != 1 && traveled[x - 1][y] != 1) {
            nextNode = new Node(x - 1, y);
            branches.add(nextNode);
        }

        if (y - 1 >= 0 && maze[x][y - 1] != 1 && traveled[x][y - 1] != 1) {
            nextNode = new Node(x, y - 1);
            branches.add(nextNode);
        }

        if (x + 1 < n && maze[x + 1][y] != 1 && traveled[x + 1][y] != 1) {
            nextNode = new Node(x + 1, y);
            branches.add(nextNode);
        }

        if (y + 1 < m && maze[x][y + 1] != 1 && traveled[x][y + 1] != 1) {
            nextNode = new Node(x, y + 1);
            branches.add(nextNode);
        }

        // 从branches取出一个即为下个节点
        nextNode = branches.pop();

        return nextNode;
    }

    private static class Node {
        public int x;

        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

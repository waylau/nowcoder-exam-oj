 /*
  * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.huawei;

import java.util.Scanner;
 

/**
 * HJ51 输出单向链表中倒数第k个结点.
 * 描述：输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 正常返回倒数第k个结点指针，异常返回空指针
 * 输入描述：
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述：
 * 输出一个整数
 * 示例：
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 输出：
 * 5
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-08-26
 */
public class HJ051OutputTheKthToLastNodeInTheUnidirectionalLinkedList {
    public static void main(String[] args) {
        // 输入
        Scanner in = new Scanner(System.in);
        
        while(in.hasNext()) {
            int n =  in.nextInt();
            
            MyLinkedList list = new MyLinkedList();
            for (int i = 0; i< n;i++) {
                list.add(in.nextInt());
            }
            
            int k = in.nextInt();

            // 输出
            System.out.println(list.get(n - k));
        }

        // 关闭
        in.close();
    }
}

class Node {
    public int data;

    public Node next;

    public Node(int data) {
        this.data = data;
    }
}

class MyLinkedList {
    // 实际链表里面的元素个数
    private int size = 0;

    // 头节点
    private Node first;

    // 尾节点
    private Node last;

    public MyLinkedList() {
    }
    
 
    public boolean add(int e) {
        final Node l = last;

        // 构造一个新节点
        final Node  newNode = new Node (e);
        last = newNode;

        // 判断尾节点，尾节点为null，则证明链表是空的。
        // 如果链表是空的，新增加的节点就作为头结点；
        // 如果链表是不空，则原尾节点的next指向新增加的节点
        if (l == null) {
            first = newNode;
            last = newNode;
        } else {
            l.next = newNode;
        }

        size++; // size累加1位

        return true;
    }
 
    public int get(int index) {
        // 判断是否越界
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    "index " + index + " out of bounds");
        }

        Node x = first;

        // 遍历链表
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x.data;
    }

}

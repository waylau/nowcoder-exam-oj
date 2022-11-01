/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * NC133 链表的奇偶重排
 * 给定一个单链表，请设定一个函数，将链表的奇数位节点和偶数位节点分别放在一起，重排后输出。
 * 注意是节点的编号而非节点的数值。
 * 示例1
 * 输入：
 * {1,2,3,4,5,6}
 * 返回值：
 * {1,3,5,2,4,6}
 * 说明：1->2->3->4->5->6->NULL
 * 重排后为1->3->5->2->4->6->NULL
 *
 * @author <a href="">Way Lau</a>
 * @since 2022-11-01
 */
public class NC133OddAndEvenRearrangementOfLinkedList {

    public static void main(String[] args) {
    	// {2,1,3,5,6,4,7}
    	ListNode a = new ListNode(2);
    	ListNode b = new ListNode(1);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(5);
    	ListNode e = new ListNode(6);
    	ListNode f = new ListNode(4);
    	ListNode g = new ListNode(7);
    	
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = e;
    	e.next = f;
    	f.next = g;
    	g.next = null;
    	
    	ListNode result = oddEvenList(a);
    	System.out.println(result);
    }

    public static ListNode oddEvenList(ListNode head) {
        // 没有后继了直接返回
        if (head == null) {
        	return head;
        }
        
        ListNode nextNode = head.next;
        
        // 没有后继了直接返回
        if (nextNode == null) {
        	return head;
        }
        
        // 1. 遍历输入的元素，将输入分为奇、偶两个数组；
        List<ListNode> oddList = new ArrayList<>();
        List<ListNode> evenList = new ArrayList<>();

        // 假设头节点为奇数
        oddList.add(head);

        int i = 1;
        while (nextNode != null) {
            i++;

            // 判断奇、偶
            if (i % 2 == 0) {
                evenList.add(nextNode);
            } else {
                oddList.add(nextNode);
            }

            nextNode = nextNode.next;
        }
        
        // 2. 将两个数组再合并为一个数组，奇数数组在前，偶数在后；
        List<ListNode> oddEvenList = new ArrayList<>();
        oddEvenList.addAll(oddList);
        oddEvenList.addAll(evenList);

        // 3. 遍历上述合并后的数组，用链表表示。
        // 尾节点要特殊处理，因此遍历到oddEvenList.size()-1位置，就停住，
        // 尾节点的next置为null
        for (int j = 0; j < oddEvenList.size() - 1; j++) {
            oddEvenList.get(j).next = oddEvenList.get(j + 1);
        }
        
        // 尾节点的next置为null
        oddEvenList.get(oddEvenList.size() - 1).next = null;
 
        return head;
    }

}


class ListNode {
    int val;

    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

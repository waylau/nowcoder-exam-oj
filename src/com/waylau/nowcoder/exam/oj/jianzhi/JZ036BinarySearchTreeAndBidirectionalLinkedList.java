/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */
 
package com.waylau.nowcoder.exam.oj.jianzhi;
 


/**
 * JZ36 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 注意:
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，
 * 树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出

 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-07
 */
public class JZ036BinarySearchTreeAndBidirectionalLinkedList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    TreeNode head = null;
    TreeNode end = null;
    
    public TreeNode convert(TreeNode pRootOfTree) {
        convertSub(pRootOfTree);
        return head;
    }
    public void convertSub(TreeNode pRootOfTree) {
        if(pRootOfTree == null) {
            return ;
        }
        
        // 中序遍历
        convert(pRootOfTree.left);
        
        if(end == null){
            head = pRootOfTree;
            end = pRootOfTree;
        }else{
            // 使用前驱节点的 right 指向当前节点，
            // 当前节点的 left 指向前驱节点，然后更新前驱节点。
            end.right = pRootOfTree;
            pRootOfTree.left = end;
            end = pRootOfTree;
        }
        
        convert(pRootOfTree.right);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
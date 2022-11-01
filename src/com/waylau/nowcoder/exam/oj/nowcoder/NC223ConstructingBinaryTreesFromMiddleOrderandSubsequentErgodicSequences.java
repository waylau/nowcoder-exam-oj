/*
 * Copyright (c) waylau.com, 2022. All rights reserved.
 */

package com.waylau.nowcoder.exam.oj.nowcoder;

import java.util.HashMap;

/**
 * NC223 从中序与后续遍历序列构造二叉树
 * 给定一个二叉树的中序与后序遍历结果，请你根据两个序列构造符合这两个序列的二叉树。
 * 保证节点的值各不相同
 * 例如输入[2,1,4,3,5],[2,4,5,3,1]时，
 * 根据中序遍历的结果[2,1,4,3,5]和后序遍历的结果[2,4,5,3,1]可构造出二叉树{1,2,3,#,#,4,5}
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 2022-11-01
 */
public class NC223ConstructingBinaryTreesFromMiddleOrderandSubsequentErgodicSequences {

    public static void main(String[] args) {
    }

    HashMap<Integer, Integer> indexMap = new HashMap<>();

    int[] inOrder;

    int[] postOrder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0)
            return null;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        inOrder = inorder;
        postOrder = postorder;
        TreeNode root = buildTreeByIndex(0, inorder.length - 1, 0, postorder.length - 1);
        return root;
    }

    // 基于后序数组，求解大小
    private TreeNode buildTreeByIndex(int inStartIndex, int inEndIndex, int postStartIndex, int postEndIndex) {
        TreeNode root = new TreeNode(postOrder[postEndIndex]);  // step 1
        int inRootIndex = indexMap.get(root.val);  // step 2 : 获得root
        int leftSize = inRootIndex - inStartIndex;  // step 3 : 求left Tree size
        int rightSize = inEndIndex - inRootIndex;   // step 3: 求right tree size
        if (leftSize == 0 && rightSize == 0) {
            return root;
        }

        /**
         * Step 5/6 入参部分：计算左右子树在中序，后序的Start/End
         * Step 7 边界要求：需要判空。避免错误递归
         */
        if (leftSize != 0) {
            root.left = buildTreeByIndex(inStartIndex, inStartIndex + leftSize - 1, postStartIndex,
                postStartIndex + leftSize - 1);
        }

        if (rightSize != 0) {
            root.right =
                buildTreeByIndex(inRootIndex + 1, inRootIndex + rightSize, postStartIndex + leftSize, postEndIndex - 1);
        }

        return root;
    }

    public class TreeNode {
        int val = 0;

        TreeNode left = null;

        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}

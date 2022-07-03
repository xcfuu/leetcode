package com.oomthread.lockoom.leetcode.leetcode.editor.cn;//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
//
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1644 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int pre = preorder[0];
        TreeNode root = new TreeNode(pre);
        int inorIndex = 0;
        //preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == pre) {
                inorIndex = i;
                break;
            }
        }
        //left 1-1   0-1
        int[] leftPre = new int[inorIndex];
        int[] rightPre = new int[preorder.length - inorIndex - 1];
        for (int i = 1; i < preorder.length; i++) {
            if (i <= inorIndex) {
                leftPre[i - 1] = preorder[i];
            } else {
                rightPre[i - inorIndex - 1] = preorder[i];
            }
        }

        int[] leftin = new int[inorIndex];
        int[] rightin = new int[inorder.length - inorIndex - 1];
        for (int i = 0; i < inorder.length; i++) {
            if (i < inorIndex) {
                leftin[i] = inorder[i];
            } else if (i > inorIndex) {
                rightin[i - inorIndex - 1] = inorder[i];
            }
        }

        //right 2-4  2-4
        TreeNode left = buildTree(leftPre, leftin);
        TreeNode right = buildTree(rightPre, rightin);
        root.left = left;
        root.right = right;

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的后序遍历
public class Solution145 {
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            readTree(root, resList);
        }
        return resList;
    }

    private void readTree(TreeNode root, List<Integer> resList) {

        if (root.left != null) {
            readTree(root.left, resList);
        }
        if (root.right != null) {
            readTree(root.right, resList);
        }
        resList.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

}

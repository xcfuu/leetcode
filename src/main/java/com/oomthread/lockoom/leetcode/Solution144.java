package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//二叉树的前序遍历
public class Solution144 {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root != null) {
            readTree(root, resList);
        }
        return resList;
    }

    private void readTree(TreeNode root, List<Integer> resList) {
        resList.add(root.val);
        if (root.left != null) {
            readTree(root.left, resList);
        }
        if (root.right != null) {
            readTree(root.right, resList);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null&&!stack.isEmpty()) {
            while (root != null) {
                resList.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return resList;
    }
}

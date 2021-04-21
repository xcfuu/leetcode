package com.oomthread.lockoom.leetcode;

import java.util.*;

public class Solution94 {
    public List<Integer> inorderTraversal1(TreeNode root) {
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
        resList.add(root.val);
        if (root.right != null) {
            readTree(root.right, resList);
        }

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;

    }
}

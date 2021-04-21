package com.oomthread.lockoom.leetcode;

import java.util.*;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList= new ArrayList<>();
        if(root==null){
            return resList;
        }
        Queue<TreeNode> stack =new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Queue<TreeNode> level=new LinkedList<>();
            List<Integer> list=new LinkedList<>();
            while (!stack.isEmpty()){
                TreeNode flag=stack.poll();
                list.add(flag.val);
                if(flag.left!=null){
                    level.add(flag.left);
                }
                if(flag.right!=null){
                    level.add(flag.right);
                }
            }
            resList.add(list);
            stack=level;
        }
        return resList;
    }
}

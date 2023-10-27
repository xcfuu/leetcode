package com.oomthread.lockoom.leetcode;

import java.util.*;

//[1,2,3]
public class Solution46 {


    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {

        List<Integer> list = new ArrayList<>();

        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            flag[i] = false;
        }
        dfs(nums, 0, list, flag);
        return res;
    }


    public void dfs(int[] nums, int i, List<Integer> list, boolean[] flag) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (!flag[j]) {
                //选择
                flag[j] = true;
                list.add(nums[j]);
                dfs(nums, i + 1, list, flag);
                //回滚
                flag[j] = false;
                list.remove(list.size() - 1);
            }
        }
    }








}

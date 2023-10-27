package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.List;

//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
public class Solution78 {


    List<Integer> t = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dsf(0, nums);
        return res;
    }

    private void dsf(int i, int[] nums) {
        if (i == nums.length) {
            res.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[i]);
        dsf(i + 1, nums);
        t.remove(t.size() - 1);
        dsf(i + 1, nums);
    }

}

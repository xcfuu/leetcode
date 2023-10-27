package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author xuechaofu
 * @Date 2023-10-16 17:27
 **/
public class Solution47 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {


        boolean[] flag = new boolean[nums.length];

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, flag, list);

        return res;
    }

    private void dfs(int[] nums, int i, boolean[] flag, List<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!flag[j] ) {
                if (j > 0 && nums[j] == nums[j - 1] && !flag[j - 1]){
                    continue;
                }

                flag[j]=true;
                list.add(nums[j]);
                dfs(nums,i+1,flag,list);
                flag[j]=false;
                list.remove(list.size()-1);


            }
        }


    }

}

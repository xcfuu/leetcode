package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution442 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                int flag= nums[i];
                //置换位置存在正常值
                if(nums[flag-1]==flag){
                    i++;
                }else {
                    //置换位置不存在正常值
                    nums[i]=nums[flag-1];
                    nums[flag-1]=flag;
                }
            }else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]-1!=j){
                res.add(nums[j]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={4,3,2,7,8,2,3,1};
        System.out.println(Solution442.findDuplicates(arr));
    }
}

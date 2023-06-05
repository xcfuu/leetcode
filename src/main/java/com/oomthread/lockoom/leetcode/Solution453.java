package com.oomthread.lockoom.leetcode;

public class Solution453 {

    public int minMoves(int[] nums) {
        if (nums.length==0){
            return 0;
        }

        int min=nums[0];
        for (int num : nums) {
            if (num<min){
                min=num;
            }
        }

        int sum =0;
        for (int num : nums) {
            sum=sum+(num-min);
        }
        return sum;
    }
}

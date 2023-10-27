package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-23 17:51
 **/
public class Solution153 {
    private  int min=Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        return getMin(nums,0,nums.length-1);
    }

    private int getMin(int[] nums, int i, int length) {
        if (i>length){
            return Integer.MAX_VALUE;
        }
        int n=(length+i)/2;
        int minLeft = getMin(nums, i, n - 1);
        int minRight = getMin(nums, n + 1, length);
        return Math.min(nums[n],Math.min(minLeft,minRight));
    }
}

package com.oomthread.lockoom.leetcode;

//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
            }
            right++;
        }
    }

}



package com.oomthread.lockoom.leetcode;

public class Solution75 {
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int p0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int flag = nums[p0];
                nums[p0] = nums[i];
                nums[i] = flag;
                p0++;
            }
        }
        int p1 = p0;
        for (int i = p0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int flag = nums[p1];
                nums[p1] = nums[i];
                nums[i] = flag;
                p1++;
            }
        }
    }
}

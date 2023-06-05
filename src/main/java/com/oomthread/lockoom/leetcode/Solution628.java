package com.oomthread.lockoom.leetcode;

import java.util.Arrays;

public class Solution628 {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);

    }
}

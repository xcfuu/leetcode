package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-11-08 11:24
 **/
public class Solution416 {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        //dp[i][j] =dp[i-1][j] | dp[i-1][j-nums[i]]

        dp[0][0] = true;

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                int num = nums[i - 1];
                if (num <= j) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}

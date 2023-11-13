package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-11-06 17:10
 **/

// sum -2neg=target
//  neg=(sum-target)/2


public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        //定义dp【i】【j】  i为数组0-i 选择之和 j为目标值 值为数目


        int sum = 0;

        for (int num : nums) {
            sum = sum + num;
        }

        if ((sum - target) < 0 || (sum - target) % 2 == 1) {
            return 0;
        }

        int neg = (sum - target) / 2;

        int[][] dp = new int[nums.length + 1][neg + 1];

        dp[0][0] = 1;
        //边界条件
        //状态转义公式 dp[i][j]=dp[i−1][j]+dp[i−1][j−num]。

        for (int i = 1; i <= nums.length; i++) {

            int num = nums[i - 1];

            for (int j = 0; j < neg + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (num <= j) {
                    dp[i][j] += dp[i - 1][j - num];
                }

            }
        }
        return dp[nums.length][neg];
    }

}

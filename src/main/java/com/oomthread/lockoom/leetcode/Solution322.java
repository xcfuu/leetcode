package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-11-08 16:41
 **/
public class Solution322 {

    public int coinChange(int[] coins, int amount) {
        //dp[j] =min(dp[j-coin]+1,dp[j])
        int[] dp = new int[amount + 1];

        int max = amount + 1;

        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

        }
        return dp[amount] == max ? -1 : dp[amount];

    }
}

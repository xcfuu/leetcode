package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-11-08 18:15
 **/
public class Solution518 {
    public int change(int amount, int[] coins) {

        //记录i代表金额，值为可实现方式数量
        int[] dp = new int[amount+1];

        dp[0]=1;

        for (int coin : coins) {
            for (int i = 1; i <=amount ; i++) {
                if (coin<=i){
                    dp[i]=dp[i]+dp[i-coin];
                }
            }
        }

        return dp[amount];

    }
}

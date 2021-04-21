package com.oomthread.lockoom.leetcode;

public class Solution70 {
    public int climbStairs(int n) {
        if(n==1||n==2){
            return n;
        }
        int[] dp=new int[n];
        return getStairs(--n,dp);
    }

    private int getStairs(int n, int[] dp) {
        if(n==0||n==1){
            return n+1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int sum=0;
        sum = getStairs(n-1,dp)+getStairs(n-2,dp);
        dp[n]=sum;
        return sum;
    }
}

package com.oomthread.lockoom.leetcode;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
public class Solution300 {


    public  int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int maxSum = 0;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int sum = getLength(i, nums, dp);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;

    }

    private  int getLength(int n, int[] nums, int[] dp) {
        int sum = 1;
        int reSum = 1;
        if(dp[n]!=0){
            return dp[n];
        }
        for (int i = n - 1; i >= 0; i--) {
            boolean flag = true;
            if (nums[n] > nums[i]) {
                flag = false;
                if(dp[i]!=0){
                    return dp[n];
                }
                sum = getLength(i, nums, dp);
                dp[i]=sum;
                sum++;
            }
            if (flag) {
                sum = 1;
            }
            if (sum > reSum) {
                reSum = sum;
            }
        }
        dp[n] = reSum;
        return reSum;
    }

    public static void main(String[] args) {
        //int[] nums ={7,7,7,7,7,7,7};
       // System.out.println(Solution300.lengthOfLIS(nums));
    }
}

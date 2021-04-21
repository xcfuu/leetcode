package com.oomthread.lockoom.leetcode;

//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//[-2,1,-3,4,-1,-5,4,2,1]
//[-2,1,-3,4,-1,2,1,-5,4]
public class Solution53 {
    //低效 O（n2）
    public int maxSubArray1(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int currSum = nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            for (int j = i + 1; j < nums.length; j++) {
                currSum = currSum + nums[j];
                if (currSum > maxSum) {
                    maxSum = currSum;
                }
            }

        }
        return maxSum;
    }

    // [8,-19,5,-4,20]
    //动态规划f(i)=max{f(i−1)+ai,ai}
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int right = 1;
        int currSum = nums[0];
        while (right < n) {
            currSum = currSum + nums[right];
            if (nums[right] > currSum) {
                currSum = nums[right];
            }
            if (currSum > maxSum) {
                maxSum = currSum;
            }

            right++;
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] nums = {-1,-2};
        System.out.println(Solution53.maxSubArray(nums));
    }
}

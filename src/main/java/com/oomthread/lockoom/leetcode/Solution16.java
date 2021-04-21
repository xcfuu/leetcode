package com.oomthread.lockoom.leetcode;

//给定一个包括n 个整数的数组nums和 一个目标值target。
// 找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//[-1,2,1,-4] [-4,-1,1,2]
//1
import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int value = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int m = nums.length - 1;
            while (j < m) {
                int valSum = nums[i] + nums[j] + nums[m];
                int flag;
                if (valSum > target) {
                    flag = valSum - target;
                    m--;
                    while (j < m && nums[m] == nums[m + 1]) {
                        m--;
                    }
                } else if(valSum<target){
                    flag = target - valSum;
                    j++;
                    while (j < m && nums[j - 1] == nums[j]) {
                        j++;
                    }
                }else {
                    flag=0;
                    value=flag;
                    sum = valSum;
                    break;
                }
                if (flag < value) {
                    value=flag;
                    sum = valSum;
                }
            }
        }
        return sum;
    }


}

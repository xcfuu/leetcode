package com.oomthread.lockoom.leetcode.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
// 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
//[2, 3, 1, 0, 2, 5, 3]
public class Solution03 {
    //n2
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]==nums[j]){
                    return nums[i];
                }
            }
        }
        return -1;
    }

    //nlogn
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1&&nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }

    //n
    public int findRepeatNumber3(int[] nums) {
        Set<Integer> set =new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])){
                return nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }


    //n
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}

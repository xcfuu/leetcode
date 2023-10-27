package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-25 17:31
 **/
public class Solution81 {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? true : false;
        }

        int left = 0;
        int right = nums.length - 1;
        int n = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
            } else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[n] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }


        }

        return false;
    }

}

package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-25 14:25
 **/
public class Solution33 {

    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }


        int left = 0;
        int right = nums.length - 1;
        int n = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //左边是有序
            if (nums[0] <= nums[mid]) {
                //在左边
                if (nums[mid]>target&& nums[left]<=target){
                    right=mid-1;
                }else {
                    //在右边
                    left=mid+1;
                }

            } else {
                //右边有序

                //目标在右边
                if(nums[mid]<target&&target<=nums[n]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }


        return -1;
    }

}

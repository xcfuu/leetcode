package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-26 15:35
 **/
public class Solution179 {
    public String largestNumber(int[] nums) {


        quickSort(nums,0,nums.length-1);

        String res="";
        for (int num : nums) {
            res=res+num;
        }
        return res;
    }

    private void quickSort(int[] nums,  int left, int right) {

        int pivot = nums[left];

        int i=left;
        int j=right;

        while (i<j){
            long y = 10;
            while (pivot >= y) {
                y *= 10;
            }
            //left右移
            while (i<j){
                long x = 10;
                while (nums[i] >= x) {
                    x *= 10;
                }
                if (nums[i] * y + pivot > nums[i] + pivot * x) {
                    i++;
                }
            }
            //右边左移
            while (i<j){
                long x = 10;
                while (nums[j] >= x) {
                    x *= 10;
                }
                if (nums[j] * y + pivot < nums[j] + pivot * x) {
                    j--;
                }
            }
            swap(nums,left,i);

        }
        swap(nums, left, j);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);

    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}

package com.oomthread.lockoom.leetcode;

public class Solution4 {
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] sumArr = new int[m + n];
        if (n == 0) {
            sumArr = nums2;
        } else if (m == 0) {
            sumArr = nums1;
        } else {
            int i = 0;
            int j = 0;
            while ((i + j) < (m + n)) {
                while ((j >= m && i < n) || (i < n && nums1[i] <= nums2[j])) {
                    sumArr[i + j] = nums1[i];
                    i++;
                }
                while ((i >= n && j < m) || (j < m && nums1[i] > nums2[j])) {
                    sumArr[i + j] = nums2[j];
                    j++;
                }
            }
        }
        boolean flag = (m + n) % 2 == 1 ? true : false;
        int index = (m + n) / 2;
        if (flag) {
            return sumArr[index];
        } else {
           return  (double)(sumArr[index] + sumArr[index - 1]) / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
    }

}

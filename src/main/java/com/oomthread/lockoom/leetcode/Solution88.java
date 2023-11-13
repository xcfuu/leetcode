package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-27 16:41
 **/
public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] newNum1 = new int[m];
        for (int i = 0; i < m; i++) {
            newNum1[i] = nums1[i];
        }
        int i = 0;
        int j = 0;
        int s = 0;
        while (i < m || j < n) {

            if (i < m && (j == n || newNum1[i] <= nums2[j])) {
                nums1[s] = newNum1[i];
                s++;
                i++;
            }

            if (j < n && (i == m || newNum1[i] > nums2[j])) {
                nums1[s] = nums2[j];
                s++;
                j++;
            }


        }


    }

}

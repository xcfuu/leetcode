package com.oomthread.lockoom.leetcode;

public class Solution665 {
    public boolean checkPossibility(int[] nums) {
//        int flag=0;
//        int size=nums.length;
//        for (int i = size-1; i >0 ; i--) {
//            if (nums[i]<nums[i-1]){
//                flag++;
//                nums[i-1]=nums[i];
//            }
//        }
//        if (flag>1){
//            return false;
//        }else {
//            return true;
//        }


        int n = nums.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution665 solution665= new Solution665();
        int[] nums={5,7,1,8};
        solution665.checkPossibility(nums);
    }
}

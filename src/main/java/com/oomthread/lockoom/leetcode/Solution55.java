package com.oomthread.lockoom.leetcode;


//[2,3,1,1,4] max=4
//[2,4,3,4,8]

//[3,2,1,0,4] max=4
//[3,3,3,0,8]
public class Solution55 {
    public  boolean canJump(int[] nums) {
        int m=nums.length;
        if(m==0){
            return false;
        }
        int flag=0;
        for (int i = 0; i < m; i++) {
            if(flag>=i){
                int val=i+nums[i];
                if(val>=m-1){
                    return true;
                }
                if(val>flag){
                    flag=val;
                }
            }else {
                return false;
            }
        }
        return false;
    }

/*    public static void main(String[] args) {
        int[] nums={1};
        System.out.println(Solution55.canJump(nums));
    }*/
}

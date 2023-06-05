package com.oomthread.lockoom.leetcode;

public class Solution189 {
    public void rotate(int[] nums, int k) {
        if(k==0){
            return;
        }
        int size= nums.length;
        k=k%size;
        int[] newNums=new int[size];
        for (int i = 0; i < size; i++) {
            if(i<k){
                newNums[i]=nums[size-k+i];
            }else {
                newNums[i]=nums[i-k];
            }
        }
        for (int i = 0; i < size; i++) {
            nums[i]=newNums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        Solution189 solution189= new Solution189();
        solution189.rotate(nums,3);
        System.out.println(nums);
    }
}

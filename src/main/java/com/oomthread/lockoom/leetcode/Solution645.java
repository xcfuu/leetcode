package com.oomthread.lockoom.leetcode;

//输入：nums = [1,2,2,4]
//输出：[2,3]

import java.util.HashMap;
import java.util.Map;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
       int size = nums.length;
       int[] res= new int[2];
       int[] newNums=new int[size+1];
        for (int i = 0; i < nums.length; i++) {
            newNums[nums[i]]=newNums[nums[i]]+1;
        }
        for (int i = 1; i < newNums.length; i++) {
            if (newNums[i]==2){
                res[0]=i;
            }else if (newNums[i]==0){
                res[1]=i;
            }
        }
        return res;
    }
}

package com.oomthread.lockoom.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author xuechaofu
 * @Date 2023-10-31 17:19
 **/
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet=new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength=0;
        for (Integer num : numSet) {
            int currNum=num;
            int length=1;

            if (!numSet.contains(currNum-1)){

                while (numSet.contains(currNum+1)){
                    currNum++;
                    length++;
                }
                maxLength= Math.max(maxLength,length);
            }


        }

        return maxLength;
    }
}

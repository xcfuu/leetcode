package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-30 17:12
 **/
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] han=matrix[0];
        int leiVal=0;
        for (int i = 0; i < han.length; i++) {
            if (han[i]==target){
                return true;
            }else if (han[i]>target){
                leiVal=i>0?i-1:0;
                break;
            }else {
                leiVal=i;
            }
        }
        int hanVal=0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]==target){
                return true;
            }else if (matrix[i][0]>target){
                hanVal=i>0?i-1:0;
                break;
            }else {
                hanVal=i;
            }
        }
        if (matrix[hanVal][leiVal]==target ){
            return true;
        }else if (matrix[hanVal][leiVal]<target){
            return false;
        }else {
            for (int i = 0; i < hanVal+1; i++) {
                for (int j = 0; j < leiVal+1; j++) {
                    if (matrix[i][j]==target){
                        return true;
                    }
                }
            }


        }
        return false;
    }
}

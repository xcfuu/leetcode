package com.oomthread.lockoom.leetcode;

public class Solution221 {
    public  int maximalSquare(char[][] matrix) {
        int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length;
        int[][] dp=new int[m][n];
        int max =0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0||j==0){
                    dp[i][j]=matrix[i][j]-'0';
                }else if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
                if(dp[i][j]>max){
                    max=dp[i][j];
                }
            }
        }
        return max*max;
    }


}

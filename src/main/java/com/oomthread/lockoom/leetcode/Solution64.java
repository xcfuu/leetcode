package com.oomthread.lockoom.leetcode;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//说明：每次只能向下或者向右移动一步。
public class Solution64 {
    public  int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<2&&n<2){
            return grid[0][0];
        }
        int[][] dp=new int[m][n];
        boolean[][] flag=new boolean[m][n];
        return getValue(--m,--n,dp, grid,flag);
    }

    private  int getValue(int m, int n, int[][] dp, int[][] grid,boolean[][] flag) {
        if(m==0&&n==0){
           return  grid[0][0];
        }
        if(flag[m][n]){
            return dp[m][n];
        }
        int minVal=0;
        if(m>0&&n>0){
            minVal= Math.min(getValue(m,n-1,dp,grid,flag),getValue(m-1,n,dp,grid,flag));
        }else if(m==0){
            minVal=getValue(m,n-1,dp,grid,flag);
        }else if(n==0){
            minVal=getValue(m-1,n,dp,grid,flag);
        }
        dp[m][n]=minVal+grid[m][n];
        flag[m][n]=true;
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] grid={{1,2,3},{4,5,6}};
        //System.out.println(Solution64.minPathSum(grid));
    }
}

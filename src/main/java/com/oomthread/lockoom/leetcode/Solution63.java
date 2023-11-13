package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-11-01 17:01
 **/
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;


        int[][] f=new int[n][m];

        //初始化边界
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0]!=1){
                f[i][0]=1;
            }else {
                break;
            }
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i]!=1){
                f[0][i]=1;
            }else {
                break;
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j]!=1 && i>0 && j>0 ){
                    int a=j>0?f[i][j-1]:0;
                    int b=i>0?f[i-1][j]:0;
                    f[i][j]=a+b;
                }
            }
        }

        return f[n-1][m-1];

    }

    public static void main(String[] args) {
        int[][] obstacleGrid={{0,0,0},{0,1,0},{0,0,0}};
        Solution63 solution63= new Solution63();
        solution63.uniquePathsWithObstacles(obstacleGrid);
    }
}

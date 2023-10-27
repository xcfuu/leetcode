package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-18 19:08
 **/
public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int re= grid.length;
        int te=grid[0].length;
        
        int max=0;
        for (int i = 0; i < re; i++) {
            for (int j = 0; j < te; j++) {
                if (grid[i][j]==1){
                    int res=dfs(grid,i,j,0);
                    max=Math.max(max,res);
                }
            }
        }

        return max;

    }

    private int dfs(int[][] grid, int i, int j, int s) {
        int re= grid.length;
        int te=grid[0].length;
        if (i<0||j<0||i>=re||j>=te||grid[i][j]==0){
            return s;
        }
        s++;
        grid[i][j]=0;
        s = dfs(grid, i - 1, j, s);
        s = dfs(grid,i+1,j,s);
        s = dfs(grid,i,j-1,s);
        s = dfs(grid,i,j+1,s);
        return s;
    }

}
